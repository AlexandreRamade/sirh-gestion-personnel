package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Departement;

public class DepartementService {
	private static final String[] NOMS_DEPARTEMENTS_PAR_DEFAUT = {"Comptabilité", "Resources Humaines", "Informatique", "Administratif"};
	List<Departement> listeDepartements = new ArrayList<Departement>();
		
	public DepartementService() {
		for(String nom : NOMS_DEPARTEMENTS_PAR_DEFAUT) {
			this.listeDepartements.add(new Departement(nom));
		}
	}
	
	public List<Departement> getListeDepartements() {
		return listeDepartements;
	}
	
	public void sauvegarderDepartement(Departement departement) {
		listeDepartements.add(departement);
	}
}
