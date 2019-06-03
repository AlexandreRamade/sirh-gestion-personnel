package dev.sgp.web;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Statistique;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.util.Constantes;

/**
 * Servlet implementation class ObtenirStatistiques
 */
public class ObtenirStatistiques extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenirStatistiques() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<VisiteWeb> visites = Constantes.VISITE_SERVICE.getListeVisites();
		
		List<String> urls = visites.stream().map(v -> v.getChemin()).sorted().distinct().collect(Collectors.toList());
		
		List<Statistique> statistiques = new LinkedList<Statistique>();
		for(String chemin : urls) {
			int count = (int) visites.stream().filter(v -> v.getChemin().equals(chemin)).count();
			//Optional<Integer> min = visites.stream().filter(v -> v.getChemin().equals(chemin)).map(v -> v.getTempsExecution()).min((t1, t2) -> t1 < t2 ? -1 : 1);
			//Optional<Integer> max = visites.stream().filter(v -> v.getChemin().equals(chemin)).map(v -> v.getTempsExecution()).max((t1, t2) -> t1 < t2 ? -1 : 1);
			OptionalInt min = visites.stream().filter(v -> v.getChemin().equals(chemin)).mapToInt(v -> v.getTempsExecution()).min();
			OptionalInt max = visites.stream().filter(v -> v.getChemin().equals(chemin)).mapToInt(v -> v.getTempsExecution()).max();
			OptionalDouble average = visites.stream().filter(v -> v.getChemin().equals(chemin)).mapToInt(v -> v.getTempsExecution()).average();
			
			statistiques.add(new Statistique(chemin, count, min.orElse(0), max.orElse(0), average.orElse(0)));
		}
		
		System.out.println(statistiques.size());
		
		request.setAttribute("statistiques", statistiques);
		
		request.getRequestDispatcher("/WEB-INF/views/statistiques.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
