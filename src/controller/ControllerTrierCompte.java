package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import model.Gestionnaire;
import view.VuePrincipale;

public class ControllerTrierCompte extends ControllerPrincipale implements ActionListener{
	
	public ControllerTrierCompte(VuePrincipale vue, Gestionnaire gest) {
		super(vue, gest);

	}
	
	public void actionPerformed(ActionEvent e) {
		
		String itemSource = e.getActionCommand();
		
		if(itemSource == "Prénom") {
			vue.afficherListeCompte(gest.trierComptePrenom());
		}
		else if(itemSource == "Solde") {
			vue.afficherListeCompte(gest.trierCompteSolde());
		}
		
	}

}
