package dev.sgp.entite;

public class VisiteWeb {
	public static int lastVisitWebId = 0;
	private int id;
	private String chemin;
	private int tempsExecution;
	
	public VisiteWeb() {
	}

	public VisiteWeb(String chemin, int tempsExecution) {
		this.id = ++lastVisitWebId;
		this.chemin = chemin;
		this.tempsExecution = tempsExecution;
	}

	
	
	
	@Override
	public String toString() {
		return "VisiteWeb [id=" + id + ", chemin=" + chemin + ", tempsExecution=" + tempsExecution + "]";
	}

	public int getId() {
		return id;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public int getTempsExecution() {
		return tempsExecution;
	}

	public void setTempsExecution(int tempsExecution) {
		this.tempsExecution = tempsExecution;
	}

	
	
}
