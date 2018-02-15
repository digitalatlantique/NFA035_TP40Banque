package model;


import java.util.*;

/**
 * This is the abstract superclass of Client and Administrator
 * this abstract method list aal account of a customer
 * this define a person
 */

abstract class Personne {

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
     * For the first name
     */
    private String prenom;

    /**
     * For the statut
     */
    private String profil;
    
    /**
     * list all account
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