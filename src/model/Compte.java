package model;

import java.util.Observable;

import main.DemoApli;

/**
 * This is an account of the customer. The account is made of an identification, a first name, a type and the balance 
 * When the balance change, the observers are notified
 * @author Win7
 *
 */
public class Compte extends Observable {
	
	private String numCpte;
	private String prenom;
	private TypeCompte type;
	private Double solde;
	/**
	 * Default constructor
	 */
	public Compte() {
		
	}
	
	/**
	 * Constructor with the name of the customer, the type and the balance
	 * Initialize with the first name, the kind of account, the initial balance
	 * @param prenom
	 * @param type
	 * @param solde
	 */
	public Compte(Client client, TypeCompte type, Double solde) {
		this.prenom = client.getPrenom();
		this.type = type;
		this.solde = solde;
		this.numCpte = client.getIdClient() + "-" + DemoApli.genererID();		
	}

	public String getNumCpte() {
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
	
	/**
	 * Notify all observer when the balance change
	 * @param solde
	 */
	public void setSolde(Double solde) {
		this.solde = solde;
		this.setChanged();
		this.notifyObservers();
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
