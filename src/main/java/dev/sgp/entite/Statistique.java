package dev.sgp.entite;

public class Statistique {
	private String chemin;
	private int nbVisites;
	private int min;
	private int max;
	private double moyenne;
	
	
	
	
	
	public Statistique(String chemin, int nbVisites, int min, int max, double moyenne) {
		this.chemin = chemin;
		this.nbVisites = nbVisites;
		this.min = min;
		this.max = max;
		this.moyenne = moyenne;
	}
	
	public String getChemin() {
		return chemin;
	}
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	public int getNbVisites() {
		return nbVisites;
	}
	public void setNbVisites(int nbVisites) {
		this.nbVisites = nbVisites;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}

	public double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}
	
	
	
}
