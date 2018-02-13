package model;


import java.util.*;

import main.DemoApli;
import view.ConsoleAffichage;

/**
 * this is the administrator of the customers
 */
public class Gestionnaire extends Personne {
	
    /**
     * Default constructor
     */
    public Gestionnaire() {
    }
    /**
     * Constructor
     */
    public Gestionnaire(String prenom) {
    	super(prenom);
    	this.numMat = compteurId + 1;
    	this.chiffreAffaire = 0.0;
    	super.setProfil("Gestionnaire");
    	this.liste = new Vector<Client>();    	
    }
    /**
     * Contains a list of customers
     */
    private Vector<Client> liste;
    
    /**
     * This is the identification of the administrator
     */
    private Integer numMat;

    /**
     * This is the balance of all customers 
     */
    private Double chiffreAffaire;
    
    /**
     * An identification
     */
    private static int compteurId = 0; 


    /**
     * List of all the accounts
     */    
    public ArrayList<Compte> listerCompte(){
    	ArrayList<Compte> listeAllComptes = new ArrayList<Compte>();
    	
    	for(Client client : liste) {
    		ArrayList<Compte> temp = client.listerCompte();
    		for(Compte cpt : temp) {
    			listeAllComptes.add(cpt);
    		}
    	}
    	return listeAllComptes;    	
    }
    
    /**
     * List of all accounts of a customer
     * @param prenom to find all the accounts
     */
    public ArrayList<Compte> listerCompte(String prenom) {
    	
        for(Client client : liste) {
        	if(client.getPrenom().equals(prenom)) {
        		return client.listerCompte();
        	}
        }
        return new ArrayList<Compte>();
    }
    
    /**
     * list of one type of accounts
     * @param prenom, type du compte
     */
    public ArrayList<Compte> listerCompte(String prenom, TypeCompte type) {
        for(Client client : liste) {
        	if(client.getPrenom().equals(prenom)) {
        		return client.listerCompte(type);
        	}
        }
        return new ArrayList<Compte>();
    }

    /**
     * @return the balance of the administrator
     */
    public Double consulterChiffreAffaire() {
    	this.setChiffreAffaire();
    	return this.chiffreAffaire;
    }
    /**
     * Do the balance of the administrator
     */
	public void setChiffreAffaire() {
    	double res = 0.0;
        for(int i=0; i<this.liste.size(); i++) {
        	res += liste.get(i).getTresorerie();
        }        
        this.chiffreAffaire = (Math.floor(res*100))/100;
	}

    /**
     * Create an account for the customer
     */
    public Client createClient(String prenom, int age, Genre genre) {
    	boolean test = false;
    	Client clientAjout = null;
    	// Boucle pour vérifier doublon
    	for(Client client : liste) {
    		
    		if(client.getPrenom().equals(prenom)) {
    			test = true;
    			break;
    		}
    	}
    	// TODO Display in the IHM
    	// Check no duplicate element
		if(test) {
			ConsoleAffichage aff = new ConsoleAffichage();
			aff.doublonClient();
		}
		 
		else {
	    	clientAjout = new Client(prenom, age, genre, this);
	    	liste.add(clientAjout);
		}
		return clientAjout;
    }
    
    /**
     * @return the liste of the customers
     */
    public Vector<Client> listerClient() {    	
        return this.liste;
    }

    /**
     * 
     */
    public void deleteClient() {
        // TODO implement here
    }
    
    /**
     * Find the customers with his first name
     * @param prenom
     * @return the customer
     */
    public Client trouverClient(String prenom) {
    	Client client = null;
    	
    	for(Client clt : liste ) {
    		if(clt.getPrenom().equals(prenom)) {
    			client = clt;
    			return client;
    		}
    	}
    	return client;
    }    
    /**
     * To show all account of a customer
     */
    public Client consulterPortefeuilleClient(String prenom) {
        for(Client client : liste) {
        	if(client.getPrenom().equals(prenom)) {
        		return client;
        	}
        }
        return null;
    }
    /**
     * Sort account for balance
     * @return a list of account
     */
    public ArrayList<Compte> trierCompteSolde() {
    	ArrayList<Compte> listeAllComptes = listerCompte();
    	Collections.sort(listeAllComptes, new CompareSolde()); 
    	return listeAllComptes;   
    }
    
    /**
     * Sort account for the first name
     * @return a list of account
     */
    public ArrayList<Compte> trierComptePrenom(){
    	ArrayList<Compte> listeAllComptes = listerCompte();
    	Collections.sort(listeAllComptes, new ComparePrenom()); 
    	return listeAllComptes;  
    }

    
	public Integer getNumMat() {
		return numMat;
	}

	public void setNumMat(Integer numMat) {
		this.numMat = numMat;
	}


	public String toString() {

		String str = super.toString() + "\n"
						+ "Identifiant : " + this.numMat +"\n"
						+ "ChiffreAffaire : " + this.chiffreAffaire + "Euro(s)";
		return str;						 
	}
}