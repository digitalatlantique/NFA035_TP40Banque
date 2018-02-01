package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import model.Client;
import model.Compte;
import model.Gestionnaire;
import view.VuePrincipale;

/**
 * This main controller show the different options and get the choice of the user to display it 
 * @author Workstation
 * @version 1.4 IHM and java doc
 * @since 1.1
 *
 */
public class ControllerPrincipale implements ActionListener {
	
	protected VuePrincipale vue;
	protected Gestionnaire gest;
	/**
	 * Constructor
	 * Create the controller with the view and the administrator object
	 * @param vue it's a view object
	 * @param gest it's an administrator object
	 */
	public ControllerPrincipale(VuePrincipale vue, Gestionnaire gest) {
		this.vue = vue;
		this.gest = gest;
	}	
	/**
	 * the method controls the type and displays the choice of the user
	 * @param event
	 */
	public void actionPerformed(ActionEvent event){
		
		String itemSource = event.getActionCommand();
		
		switch(itemSource) {
		
			case "quitter" : {
				System.exit(0);
				break;
			}
			case "listeClients" : {
				vue.afficherListeClient(gest.listerClient());
				break;
			}
			case "porteFeuille" : {
				vue.afficherPortefeuilleGestionnaire(gest.listerCompte(), gest);
				break;
			}
			case "compteClient" : {
				vue.afficherCombo(gest);
				break;
			}
		}
	
	}
	/**
	 * To check if the type is an integer
	 * @param var
	 * @return
	 */
    public boolean CheckInt(String var) {			
    	 
		Pattern pattern = Pattern.compile("[0-4]");
		Matcher matcher = pattern.matcher(var);
		boolean resultat = matcher.matches();
		return resultat;    	
    }

    /**
     * To check if the type is a character string
     */
    public boolean CheckString(String var) {
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		Matcher matcher = pattern.matcher(var);
		boolean resultat = matcher.matches();
		return resultat;
    }
}
