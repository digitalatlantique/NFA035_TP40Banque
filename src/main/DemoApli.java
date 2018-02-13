package main;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.SwingUtilities;

import controller.ControllerPrincipale;
import model.Client;
import model.Compte;
import model.Genre;
import model.Gestionnaire;
import model.TypeCompte;
import view.ConsoleAffichage;
import view.VuePrincipale;

/**
 * This application is a practice Java language for the course of NFA035 CNAM Center of France
 * 
 * @author Workstation
 * @version 1.4 IHM and Java documentation
 * @since 1.1
 *
 */
public class DemoApli {	
	
	public static VuePrincipale vue; 
		 
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
						
		// Création du gestionnaire
		Gestionnaire gest = new Gestionnaire("Rotchild");	
		
		// Récupération data
		String[] tab = extractData();
		
		// Création des clients avec les datas
		initialisationClient(tab, gest);
		
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
            	vue = new VuePrincipale();
            }
          });
		
		ControllerPrincipale controllerPrincipale = new ControllerPrincipale(vue, gest);
		vue.ecouterMenu(controllerPrincipale);
		

	}	
	
	/**
	 * Extract data to file
	 * @return an array String with the property of customers
	 */
	public static String[] extractData() {
		// Chemin file
		String pathname = "./assets";
		String fileName = "/bankCustomers.txt";
		File fn = new File(pathname + fileName);		
		String contenu = "";
		
		try {
			FileReader fr = new FileReader(fn);
			BufferedReader br = new BufferedReader(fr);
			
			String tmp;
			while ((tmp = br.readLine()) != null) {
				// Concatenation of an element from a file with a separator to locate the rows
				contenu += tmp + "/";
			}
			
			br.close();
			fr.close();
		} 
		catch (FileNotFoundException e) {
		e.printStackTrace();
		System.out.println(" ERROR Fichier non TROUVÉ ");
		} 
		catch (IOException e) {
		System.out.println(" ERROR acces Reader ");
		e.printStackTrace();
		}
		
		return contenu.split("/");		
	}
	/**
	 * Initialize the customers and their accounts
	 * @param tab, contains the data customers to initialize this application
	 * @param gest is the administrator of the customers, he has all accounts of his customers
	 */
	public static void initialisationClient(String[] tab, Gestionnaire gest) {
		Client client = null;
		for(int i=0; i<tab.length; i++) {
			
			String recupStr = "";			
			recupStr += tab[i] +"*";
			String[] tmp = recupStr.split("[/*]");
			
			if(tmp[3].equals("homme")){
				
				client = gest.createClient(tmp[0], Integer.parseInt(tmp[2]), Genre.homme);
				creerCompteAleatoire(client, genererNbrInt(0, 4));
			}
			if(tmp[3].equals("femme")){
				client = gest.createClient(tmp[0], Integer.parseInt(tmp[2]), Genre.femme);
				creerCompteAleatoire(client, genererNbrInt(0, 4));
			}
			// A break to differentiate the customer's identifications
			try {
	            Thread.sleep(3);
	        } 
			catch (InterruptedException e) {
	            e.printStackTrace();
	        }			
		}
	}
	/**
	 * Create an account randomly
	 * 
	 * @param client to add his accounts
	 * @param nbreCompte to define the number of accounts
	 */
	public static void creerCompteAleatoire(Client client, int nbreCompte) {
    	// Create randomly account(s)
    	for(int i=0; i<nbreCompte; i++) {
    		// Choice which type of account
    		TypeCompte choixType;
    		int nbre = DemoApli.genererNbrInt(0, 2);
    		if(nbre == 0) {
    			choixType = TypeCompte.Courant;
    		}
    		else if(nbre == 1) {
    			choixType = TypeCompte.Livret_A;
    		}
    		else {
    			choixType = TypeCompte.PEL;
    		}
    		// Create account(s)
    		client.creerCompte(choixType, DemoApli.genererNbrDouble(-1000.0, 100000.0));
    
    	}
	}
	
	/**
	 * Generate an identification for the customers.
	 * The identifications are made with the six first numbers of time stamp and two first vowels of the first name 
	 *  
	 * @param prenom is the first name of the customer
	 * @return an identification
	 */
	public static String genererIdClient(String prenom) {
		String str1 = "";
		String str2;
		String lettre1 = "";
		String lettre2 = "";
		String seq = "[aeuioyAEUIOY]";
		int compteur = 0;
		
		// Get the six last figures of time stamp 
		long ts = System.currentTimeMillis();
		str2 = String.valueOf(ts);
		str2 = str2.substring(7);	
		
		// Get the first two vowels 
		for(int i=0; i<prenom.length(); i++) {			
			String test = prenom.charAt(i) +"";
			if(test.matches(seq) && compteur==0) {
				lettre1 = prenom.charAt(i) + "";
				compteur++;
			}
			else if(test.matches(seq) && compteur==1) {
				lettre2 = prenom.charAt(i) + "";
				break;
			}			
		}		
		str1 += lettre1.toLowerCase() + lettre2.toLowerCase() + str2;
		
		return str1;
	}
	/**
	 * Generate an integer
	 * @param min
	 * @param max
	 * @return A number randomly
	 */
	public static int genererNbrInt(int min, int max) {		
		
		int nbr = (int) ((Math.random() * (max - min)) + min);		
		return nbr;
	}
	/**
	 * Generate a real number
	 * @param min
	 * @param max
	 * @return A real number randomly
	 */
	public static Double genererNbrDouble(Double min, Double max) {	
		double delta = max - min + 1;
		double resultat = Math.random() * (delta);
		resultat += min;
		return (Math.floor(resultat * 100)) / 100;
	}

}
