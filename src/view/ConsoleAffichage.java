package view;


import java.util.*;

import model.Client;
import model.Compte;
import model.Gestionnaire;

/**
 * 
 */
public class ConsoleAffichage {

    /**
     * Default constructor
     */
    public ConsoleAffichage() {
    }


    /**
     * 
     */
    public void msgFin() {
    	System.out.println("------------------------------------------------");
    	System.out.println("----------------------FIN-----------------------");
    	System.out.println("------------------------------------------------");
    }

    /**
     * 
     */
    public void displayListClient(Vector<Client> liste) {
    	System.out.println("------------------------------------------------");
		for(int i=0; i <liste.size(); i++) {
			System.out.println("------------------------------------------------");
			System.out.println(liste.get(i));
			
		}
		System.out.println("------------------------------------------------");
    }
    public void infoClient(Client client) {
    	
    	if(client == null) {
        	System.out.println("------------------------------------------------");
        	System.out.println("| Ce client n'existe pas !                     |");
        	System.out.println("------------------------------------------------");    		
    	}
    	else {
	    	System.out.println("------------------------------------------------");
	    	System.out.println(client);
	    	System.out.println("------------------------------------------------");
    	}
    }
    public void infoGest(Gestionnaire gest) {
    	System.out.println("------------------------------------------------");
    	System.out.println(gest);
    	System.out.println("------------------------------------------------");
    }

    /**
     * 
     */
    public void displayCompte(ArrayList<Compte> mesComptes) {
    	
    	if(mesComptes.size() == 0) {
        	System.out.println("------------------------------------------------");
        	System.out.println("Pas de compte de dépôt à afficher !");
        	System.out.println("------------------------------------------------");
    	}
    	else {
            for(int i=0 ;i<mesComptes.size(); i++) {
            	System.out.println(mesComptes.get(i));
            }
    	}

    }

    /**
     * 
     */
    public void displayAllCompte() {
        // TODO implement here
    }

    /**
     * 
     */
    public void menu() {
    	System.out.println("------------------------------------------------");
        System.out.println("| 0 Fin                                        |\n"
        				  +"| 1 Afficher tout les clients                  |\n"
        				  +"| 2 Afficher les comptes de dépôt d'un client  |\n"
        				  +"| 3 Afficher trésorerie client                 |\n"
        				  +"| 4 Chiffre d'affaire du gestionnaire          |");
        System.out.println("------------------------------------------------");
    }
    
    public void doublonClient() {
    	System.out.println("Client existant !");
    }

}