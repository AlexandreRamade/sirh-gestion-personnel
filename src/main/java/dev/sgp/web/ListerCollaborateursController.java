package dev.sgp.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListerCollaborateursController extends HttpServlet {
	
	public static final String LISTE_NOMS_ATT = "listeNoms";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(LISTE_NOMS_ATT, Arrays.asList("Robert", "Jean", "Hugues"));
		
		request.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(request, response);
	}
}
