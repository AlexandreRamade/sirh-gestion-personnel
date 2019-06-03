package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.VisiteWeb;

public class VisiteWebService {
	List<VisiteWeb> listeVisites = new ArrayList<VisiteWeb>();

	public List<VisiteWeb> getListeVisites() {
		return listeVisites;
	}
	
	public void sauvegarderVisite(VisiteWeb visit) {
		listeVisites.add(visit);
	}
}
