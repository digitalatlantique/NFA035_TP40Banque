package model;


import java.util.*;
import view.VuePrincipale;


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
     * Constructor with his name
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

    	// Check no duplicate element
		if(test) {
			VuePrincipale.afficherErreur("Client existant !");
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
    public ArrayList<Compte> trierCompteSoldeDecroissant() {
    	
    	ArrayList<Compte> listeAllComptes = listerCompte();
    	Collections.sort(listeAllComptes, new CompareSoldeDecroissant()); 
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
    public ArrayList<Compte> trierComptePrenomDecroissant(){
    	ArrayList<Compte> listeAllComptes = listerCompte();
    	Collections.sort(listeAllComptes, new ComparePrenomDecroissant()); 
    	return listeAllComptes;  
    }

    /**
     * Check if account exist
     * @param numeroCompte
     * @return
     */
    public boolean compteExiste(String numeroCompte) {
    	
    	ArrayList<Compte> listeAllCompte = listerCompte();
    	boolean trouve = false;
    	
    	for(Compte compte : listeAllCompte) {
        	if(compte.getNumCpte().equals(numeroCompte)) {
    			trouve = true;
    			break;
        	}
        	else {
        		trouve = false;
        	}
    	}    	
    	return trouve;
    }

    /**
     * To credit an account
     * @param numeroCompte
     * @param montant
     */
    public void crediterCompte(String numeroCompte, double montant) {
    	
    	ArrayList<Compte> listeAllCompte = listerCompte();
    	
    	for(Compte compte : listeAllCompte) {
        	if(compte.getNumCpte().equals(numeroCompte)) {        		
    			double nouveauSolde = compte.getSolde() + montant;
    			compte.setSolde(nouveauSolde);
        	}
    	}
    }

    /**
     * To debit an acconut
     * @param numeroCompte
     * @param montant
     * @return
     */
    public boolean debiterCompte(String numeroCompte, double montant) {
    	ArrayList<Compte> listeAllCompte = listerCompte();
    	boolean resultat = false;
    	
    	for(Compte compte : listeAllCompte) {
        	if(compte.getNumCpte().equals(numeroCompte)) {
        		
        		if((compte.getSolde() - montant) <= -1000) {
        			return false;
        		}
        		else {
        			double nouveauSolde = compte.getSolde() - montant;
        			compte.setSolde(nouveauSolde);
        			return true;
        		}
        	}
    	}
    	return resultat;
    }
    
	public Integer getNumMat() {
		return numMat;
	}
	
	public Compte getCompte(String numeroCompte) {
		
    	ArrayList<Compte> listeAllCompte = listerCompte();
    	Compte compte = null;
    	
    	for(Compte cpt : listeAllCompte) {
        	if(cpt.getNumCpte().equals(numeroCompte)) {
    			compte = cpt;    			
        	}
    	}
    	return compte;
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