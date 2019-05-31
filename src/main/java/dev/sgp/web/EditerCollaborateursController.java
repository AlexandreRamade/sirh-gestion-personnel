package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	
	public static final String[] PARAMETRES = {"nom", "prenom", "dateNaissance", "adresse", "numeroSecu"};
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//récupère les valeurs des parametres
		Map<String, String> paramValues = new HashMap<String, String>();	
		for(String param : PARAMETRES) {
			paramValues.put(param, request.getParameter(param));
		}
			
			if(paramValues.containsValue(null)) {
				String errorMsg = "Les paramètres suivants sont incorects :";
				for(Map.Entry<String, String> entry : paramValues.entrySet()) {
					if(entry.getValue() == null) {
						errorMsg += entry.getKey() + " ";
					}
				}
				response.sendError(400, errorMsg);
			} else {
				response.setStatus(201);

				List<Collaborateur> collaborateurs = collabService.getListeCollaborateurs();
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dateNaissance = LocalDate.parse(paramValues.get(PARAMETRES[2]), formatter);
				
				collaborateurs.add(new Collaborateur(paramValues.get(PARAMETRES[0]),
						paramValues.get(PARAMETRES[1]),
						dateNaissance,
						paramValues.get(PARAMETRES[3]),
						paramValues.get(PARAMETRES[4])));
				
			}
	}
}
