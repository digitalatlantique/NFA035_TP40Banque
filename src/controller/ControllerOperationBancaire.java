package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JDialog;

import model.Gestionnaire;
import view.OperationDialog;
import view.VuePrincipale;

/**
 * This controller show the different options for the banking transaction  
 * @author Workstation
 *
 */
public class ControllerOperationBancaire implements ActionListener {
	
	private OperationDialog vueOperationBancaire;
	private Gestionnaire gestionnaire;
	private String numeroSaisie = null;

	/**
	 * Default constructor
	 */
	public ControllerOperationBancaire() {
		
	}
	
	/**
	 * Constructor with view and model
	 * @param vueOperation
	 * @param gest
	 */
	public ControllerOperationBancaire(OperationDialog vueOperation, Gestionnaire gest) {
		vueOperationBancaire = vueOperation;
		vueOperationBancaire.ecouterBouton(this);
		vueOperationBancaire.ecouterCombo(this);
		gestionnaire = gest;
		
	}

	/**
	 * Action for the button at the OperationDialog class and ComboBox "numéro de compte"
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String itemSource = arg0.getActionCommand();		
		
		switch(itemSource) {
		
			case "bouton" : {
				
				String montantSaisie = vueOperationBancaire.getSaisieMontant().getText();
				
				// Check the identication of the account
				if(gestionnaire.compteExiste(numeroSaisie)) {
					gestionnaire.getCompte(numeroSaisie).addObserver(vueOperationBancaire);					
					
					// Check data capture
					if(CheckDouble(montantSaisie)) {
						
						// To credit
						if(vueOperationBancaire.getRadioCrediter().isSelected()) {
							gestionnaire.crediterCompte(numeroSaisie, Double.parseDouble(montantSaisie));
							VuePrincipale.afficherConfirme("Opération validée");
							vueOperationBancaire.setVisible(false);
							vueOperationBancaire.dispose();
						}
						
						// To debit
						else {
							boolean debitCompte = gestionnaire.debiterCompte(numeroSaisie, Double.parseDouble(montantSaisie));
							
							// Check credit balance
							if(debitCompte) {
								VuePrincipale.afficherConfirme("Opération validée");
							}
							else {
								VuePrincipale.afficherErreur("Solde insuffisant !");
							}
							vueOperationBancaire.setVisible(false);
							vueOperationBancaire.dispose();
						}

					}
					else {
						VuePrincipale.afficherErreur("Veuillez saisir un montant valide !");
					}			
				}
				else {
					VuePrincipale.afficherErreur("Selectionner un compte !");
				}
				break;
			}
			
		// ComboBox
			case "combo" : {
				double montant;
				numeroSaisie = (String) ((JComboBox) arg0.getSource()).getSelectedItem();
				montant = gestionnaire.getCompte(numeroSaisie).getSolde();		
				String montantStr = new DecimalFormat("0.00 E  ").format(montant);
				vueOperationBancaire.getLabelSolde().setText("Solde disponible : " + montantStr);
			}
		}

	}
	
	/**
	 * To check if the data capture is a double
	 * @param var
	 * @return
	 */
    public boolean CheckDouble(String var) {			
    	 
		Pattern pattern = Pattern.compile("[0-9]+.[0-9]{0,2}");
		Matcher matcher = pattern.matcher(var);
		boolean resultat = matcher.matches();
		return resultat;    	
    }
}
