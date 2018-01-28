package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Gestionnaire;
import view.VuePrincipale;

public class ControllerSaisiePrenom extends ControllerPrincipale implements ActionListener {
	
	public ControllerSaisiePrenom(VuePrincipale vue, Gestionnaire gest) {
		
		super(vue, gest);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		
		String saisie = this.vue.getField().getText();
		
		if(CheckString(saisie)) {
			vue.afficherCompteClient(gest.trouverClient(saisie), gest.listerCompte(saisie));
			vue.afficherSaisieChoix();
		}
		else {
			vue.afficherErreurMenu();
		}

	}

}
