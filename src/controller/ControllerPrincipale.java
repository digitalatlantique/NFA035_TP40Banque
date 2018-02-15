package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Compte;
import model.Gestionnaire;
import view.OperationDialog;
import view.VuePrincipale;

/**
 * This main controller manage the different options and get the choice of the user to display it 
 * @author Workstation
 * @version 1.4 IHM and java doc
 * @since 1.1
 *
 */
public class ControllerPrincipale implements ActionListener, ListSelectionListener {
	
	protected VuePrincipale vue;
	protected Gestionnaire gest;
	private static boolean doCombo = true;
	OperationDialog vueOperation;
	
	/**
	 * Default constructor
	 */
	public ControllerPrincipale() {
		
	}
	
	/**
	 * Constructor
	 * Create the controller with the view and the administrator object
	 * @param vue it's a view object
	 * @param gest it's an administrator object
	 */
	public ControllerPrincipale(VuePrincipale vue, Gestionnaire gest) {
		this.vue = vue;
		this.gest = gest;
		vue.ecouterMenu(this);
		vue.ecouterJList(this);
		vue.ecouterBouton(this);
	}	
	
	/**
	 * the method controls the choice of the user at the MenuBar, ComboBox, Button "valider"
	 * @param event
	 */
	public void actionPerformed(ActionEvent event){
		
		String itemSource = event.getActionCommand();
		
		switch(itemSource) {
		
		// MenuBar
			case "operationBancaire" : {
				ArrayList<Compte> listeComptes = gest.listerCompte();
				vueOperation = new OperationDialog(vue, "Opération bancaire", false, listeComptes);
				ControllerOperationBancaire controllerOperationBancaire = new ControllerOperationBancaire(vueOperation, gest);	
				break;
				
			}
			case "porteFeuille" : {
				vue.afficherPortefeuilleGestionnaire(gest.listerCompte(), gest);
				break;
			}			
			case "quitter" : {
				vue.afficherMessageFin();
				System.exit(0);
				break;
			}
			case "listeClients" : {
				vue.afficherListeClient(gest.listerClient());
				break;
			}
			case "compteClient" : {
				if(doCombo) {
					vue.afficherCombo(gest);
					doCombo = false;					
				}
				else {
					vue.comboExiste();
				}
				break;
			}
			case "prenom" : {
				vue.afficherListeCompte(gest.trierComptePrenom());
				break;
			}
			case "solde" : {
				vue.afficherListeCompte(gest.trierCompteSolde());
				break;
			}
			
		// ComboBox
			case "combo" : {
				
				String prenom = (String) ((JComboBox)event.getSource()).getSelectedItem();
				vue.afficherCompteClient(gest.trouverClient(prenom), gest.listerCompte(prenom));
				break;
			}

		// Button at the PanneauAffichage
			case "bouton" : {
				int choixUser = vue.getListeMenu().getSelectedIndex();
				
				switch(choixUser) {
				
					case 0 : {
						vue.afficherMessageFin();
						System.exit(0);
						break;
					}
					case 1 : {
						vue.afficherListeClient(gest.listerClient());
						break;
					}
					case 2 : {
						if(doCombo) {
							vue.afficherCombo(gest);
							doCombo = false;							
						}
						else {
							vue.comboExiste();
						}
						break;
					}
					case 3 : {
						vue.afficherPortefeuilleGestionnaire(gest.listerCompte(), gest);
						break;
					}
				}
			}
		}	
	}
	/**
	 * Display the choice of the user in the comboBox
	 */
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		
		vue.afficherChoix((String) (vue.getListeMenu().getSelectedValue()));
		
	}

}
