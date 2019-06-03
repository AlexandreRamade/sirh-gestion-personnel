package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;
	
public class EditerCollaborateursController extends HttpServlet {
	
	//récupération du service
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	public static final String LISTE_NOMS_ATT = "listeNoms";
	
	public static final String[] PARAMETRES = {"nom", "prenom", "dateNaissance", "adresse", "numeroSecu"};
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//récupère la valeur d'un parametre dont le nom est : matricule
		String matriculeParam = request.getParameter("matricule");
		
		if(matriculeParam == null) {
			request.getRequestDispatcher("/WEB-INF/views/collab/editerCollaborateur.jsp").forward(request, response);
		} else {
			response.setStatus(200);
			//code HTML écrit dans le corps de la réponse
			String respContent = "<h1>Edition de collaborateur</h1";
			respContent += "<p>Matricule : " + matriculeParam + "</p>";
			response.getWriter().write(respContent);
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//récupère les valeurs des parametres
		Map<String, String> paramValues = new HashMap<String, String>();	
		for(String param : PARAMETRES) {
			paramValues.put(param, request.getParameter(param));
		}
		
		String errorMsg = "";
		
		//teste qu'aucun champ n'est null et renvoie les noms des champs manquants
		if(paramValues.containsValue(null)) {
			errorMsg += "Les paramètres suivants sont obligatoires :";
			for(Map.Entry<String, String> entry : paramValues.entrySet()) {
				if(entry.getValue() == null) {
					errorMsg += entry.getKey() + " ";
				}
			}
		} 
		
		//veréifi que le numéro de sécu est une chaine de 15 chiffres
		try {
			String numSecu = paramValues.get(PARAMETRES[4]);
			if(numSecu.length() != 15 || !numSecu.matches("[0-9]{15}")) {
				errorMsg += "\nLe numéro de sécurité sociale doit contenir 15 chiffres";
			}
		}catch (NullPointerException e) {
		}
		
		//vérifie que la date de naissance est au bon format : yyy-MM-dd et créer le LocalDate si c'est le cas
		LocalDate dateNaissance = null;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			dateNaissance = LocalDate.parse(paramValues.get(PARAMETRES[2]), formatter);
		} catch (DateTimeParseException e) {
			errorMsg += "\nLa date de naissance doit doit être indiquée au format : jj/mm/aaaa";
		}
		
		//Si une erreur a été detecté => page d'erreur avec le message contenant le détail
		if(errorMsg.length() > 0) {
			response.sendError(400, errorMsg);		
			
		} else { //sinon, création du Collaborateur, ajout à la liste existante, et redirection vers la page qui liste les collaborateurs
			response.setStatus(201);
			
			List<Collaborateur> collaborateurs = collabService.getListeCollaborateurs();
			
			collaborateurs.add(new Collaborateur(
					paramValues.get(PARAMETRES[0]),
					paramValues.get(PARAMETRES[1]),
					dateNaissance,
					paramValues.get(PARAMETRES[3]),
					paramValues.get(PARAMETRES[4])));
			
			
			request.setAttribute(LISTE_NOMS_ATT, collaborateurs);
			request.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(request, response);
		}
	}
}
