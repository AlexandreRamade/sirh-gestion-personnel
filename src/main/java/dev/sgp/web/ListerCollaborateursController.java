package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListerCollaborateursController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//récupère la valeur d'un parametre dont le nom est : avecPhoto
		String avecPhotoParam = request.getParameter("avecPhoto");
		
		//récupère la valeur d'un parametre dont le nom est : departement
		String departementParam = request.getParameter("departement");
		
		//code HTML écrit dans le corps de la réponse
		String respContent = "<h1>Lister des collaborateurs</h1";
		respContent += "<ul>";
		respContent += "<li>avecPhoto = " + avecPhotoParam + "</li>";
		respContent += "<li>departement = " + departementParam + "</li>";
		respContent += "</ul>";
		response.getWriter().write(respContent);
	}
}
