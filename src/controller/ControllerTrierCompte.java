package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import model.Gestionnaire;
import view.VuePrincipale;

public class ControllerTrierCompte extends ControllerPrincipale implements ActionListener{
	
	/**
	 * Constructor
	 * @param vue
	 * @param gest
	 */
	public ControllerTrierCompte(VuePrincipale vue, Gestionnaire gest) {
		super(vue, gest);

	}
	
	/**
	 * This method displays the accounts sorted by first name or by balance
	 */
	public void actionPerformed(ActionEvent event) {
		
		String itemSource = event.getActionCommand();
		
		switch (itemSource) {
			

		}
	}
}
