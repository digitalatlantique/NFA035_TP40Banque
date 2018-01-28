package model;


import java.util.*;

import main.DemoApli;
import view.ConsoleAffichage;

/**
 * 
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
     * 
     */
    private Vector<Client> liste;
    /**
     * 
     */
    private Integer numMat;

    /**
     * 
     */
    private Double chiffreAffaire;
    
    /**
     * 
     */
    private static int compteurId = 0; 


    /**
     * liste tout les comptes
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
     * Liste les comptes d'un client
     * @param prenom
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
     * Liste un type de compte client
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
     * Affiche le chiffre d'affaire du gestionnaire
     */
    public Double consulterChiffreAffaire() {
    	this.setChiffreAffaire();
    	return this.chiffreAffaire;
    }
    /**
     * Détermine le chiffre d'affaire du gestionnaire
     */
	public void setChiffreAffaire() {
    	double res = 0.0;
        for(int i=0; i<this.liste.size(); i++) {
        	res += liste.get(i).getTresorerie();
        }        
        this.chiffreAffaire = (Math.floor(res*100))/100;
	}

    /**
     * Create un compte client sans doublon de prénom
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
    	// Si doublon on affiche message
		if(test) {
			ConsoleAffichage aff = new ConsoleAffichage();
			aff.doublonClient();
		}
		// Sinon on créer le client 
		else {
	    	clientAjout = new Client(prenom, age, genre, this);
	    	liste.add(clientAjout);
		}
		return clientAjout;
    }
    
    /**
     * @param Gestionnaire
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
     * Permet de consulter le portefeuille d'un client
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
     * 
     * @return
     */
    public ArrayList<Compte> trierCompteSolde() {
    	ArrayList<Compte> listeAllComptes = listerCompte();
    	Collections.sort(listeAllComptes, new CompareSolde()); 
    	return listeAllComptes;   
    }
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