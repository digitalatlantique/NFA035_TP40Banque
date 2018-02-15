package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import controller.ControllerPrincipale;
import controller.ControllerTrierCompte;


/**
 * This is the main menu
 * @author Workstation
 *
 */
public class MonMenu extends JMenuBar{

	private JMenu gestionnaire;
	private JMenu client;
	private JMenu trier;
	private JMenu compte;
	
	private JMenuItem crediterClient;
	private JMenuItem porteFeuille;
	private JMenuItem listeClient;
	private JMenuItem compteClient;
	private JMenuItem quitter;
	private JMenuItem prenom;
	private JMenuItem solde;
	
	private ControllerPrincipale controllerPrincipale = null;
	private ControllerTrierCompte controllerTrierCompte = null;
	
	/**
	 * Constructor with a font
	 * @param font1
	 */
	public MonMenu(Font font1) {		
		
		this.setBackground(new Color(217, 250, 255));
		font1 = font1.deriveFont((float)15.0);
		this.setFont(font1);
		
		// The menu
		gestionnaire = new JMenu("Gestionnaire");
		client = new JMenu("Client");
		trier = new JMenu("Trier");
		compte = new JMenu("Compte");
		
		//The item
		crediterClient = new JMenuItem("Opération bancaire");
		crediterClient.setActionCommand("operationBancaire");
		porteFeuille = new JMenuItem("Porte Feuille");
		porteFeuille.setActionCommand("porteFeuille");		
		
		listeClient = new JMenuItem("Liste Clients");
		listeClient.setActionCommand("listeClients");
		
		compteClient = new JMenuItem("Compte");
		compteClient.setActionCommand("compteClient");
		
		quitter = new JMenuItem("Quitter");
		quitter.setActionCommand("quitter");
		prenom = new JMenuItem("Prénom");
		prenom.setActionCommand("prenom");
		solde = new JMenuItem ("Solde");
		solde.setActionCommand("solde");
		
		// Layout
		gestionnaire.add(crediterClient);
		gestionnaire.add(porteFeuille);
		gestionnaire.addSeparator();
		gestionnaire.add(quitter);
		
		client.add(listeClient);
		client.add(compteClient);
		
		compte.add(prenom);
		compte.add(solde);
		
		trier.add(compte);
		
		this.add(gestionnaire);
		this.add(client);
		this.add(trier);
	}	
	
	/**
	 * To listen the menu
	 * @param controllerPrincipale
	 */
	public void ecouterElementsMenu(ActionListener controllerPrincipale) {
		
		crediterClient.addActionListener(controllerPrincipale);
		porteFeuille.addActionListener(controllerPrincipale);
		listeClient.addActionListener(controllerPrincipale);
		compteClient.addActionListener(controllerPrincipale);
		quitter.addActionListener(controllerPrincipale);
		
		prenom.addActionListener(controllerPrincipale);
		solde.addActionListener(controllerPrincipale);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
