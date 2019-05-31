package dev.sgp.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateursController extends HttpServlet {
	public static final String[] PARAMETRES = {"matricule", "titre", "nom", "prenom"};
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//récupère la valeur d'un parametre dont le nom est : matricule
		String matriculeParam = request.getParameter("matricule");
		
		if(matriculeParam == null) {
			response.setStatus(400, "Un matricule est attendu");
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
				response.setStatus(400, errorMsg);
			} else {
				response.setStatus(201);
				//code HTML écrit dans le corps de la réponse
				String respContent = "<h1>Création d'un collaborateur avec les informations suivantes :</h1";
				respContent += "<ul>";
				for(Map.Entry<String, String> entry : paramValues.entrySet()) {
					respContent += "<li>" + entry.getKey() + " = " + entry.getValue() + "</li>";
				}
				respContent += "</ul>";
				response.getWriter().write(respContent);
			}
	}
}
