package dev.sgp.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class ListerCollaborateursController extends HttpServlet {
	//récupération du service
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	
	public static final String LISTE_NOMS_ATT = "listeNoms";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Collaborateur> collaborateurs = collabService.getListeCollaborateurs();
		
		request.setAttribute(LISTE_NOMS_ATT, Arrays.asList("Robert", "Jean", "Hugues"));
		
		request.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(request, response);
	}
}
