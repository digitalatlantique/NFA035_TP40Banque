package model;


import java.util.*;

/**
 * 
 */
abstract class Personne  {

    /**
     * Default constructor
     */
    public Personne() {
    }
    /**
     * Constructor
     */
    public Personne(String prenom) {
    	this.prenom = prenom;
    }

    /**
     * 
     */
    private String prenom;

    /**
     * 
     */
    private String profil;
    
    /**
     * 
     */
    abstract ArrayList<Compte> listerCompte();

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public String toString() {
		String str = "Prénom : " + this.prenom + "\n"
						+ "Profil : " + this.profil;
		return str;
	}
}