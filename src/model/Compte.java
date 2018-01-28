package model;

public class Compte {
	
	private int numCpte;
	private String prenom;
	private TypeCompte type;
	private Double solde;
	private static int compteur = 0;
	
	public Compte() {
		
	}

	public Compte(String prenom, TypeCompte type, Double solde) {
		this.prenom = prenom;
		this.type = type;
		this.solde = solde;
		this.numCpte = compteur;
		compteur++;		
	}
	public int getNumCpte() {
		return numCpte;
	}	
	public String getPrenom() {
		return prenom;
	}
	public TypeCompte getType() {
		return type;
	}
	public void setType(TypeCompte type) {
		this.type = type;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	public String toString() {
		String str = "------------------------------------------------\n"
						+"Compte n : " + this.numCpte + "\n"
						+"Prénom : " + this.prenom + "\n"
						+"Type : " + this.type + "\n"
						+"Solde : " + this.solde + " Euro(s)\n"
						+"------------------------------------------------";
		return str;
	}
	

}
