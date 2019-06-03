package dev.sgp.entite;

public class Departement {
	public static int lastDepartementId = 0;
	private int id;
	private String nom;
	
	
	public Departement(String nom) {
		this.id = ++lastDepartementId;
		this.nom = nom;
	}

	

	@Override
	public String toString() {
		return "Departement [id=" + id + ", nom=" + nom + "]";
	}



	public int getId() {
		return id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
