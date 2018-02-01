package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.ControllerPrincipale;
import controller.ControllerTrierCompte;
import model.Gestionnaire;

public class MonMenu extends JMenuBar{

	private JMenu gestionnaire = null;
	private JMenu client = null;
	private JMenu trier = null;
	private JMenu compte = null;
	
	private JMenuItem porteFeuille = null;
	private JMenuItem listeClient = null;
	private JMenuItem quitter = null;
	private JMenuItem prenom = null;
	private JMenuItem solde = null;
	
	private ControllerPrincipale controllerPrincipale = null;
	private ControllerTrierCompte controllerTrierCompte = null;
	
	public MonMenu(VuePrincipale vue, Gestionnaire gest, Font font1) {		
		
		this.setBackground(new Color(217, 250, 255));
		font1 = font1.deriveFont((float)15.0);
		this.setFont(font1);
		
		gestionnaire = new JMenu("Gestionnaire");
		client = new JMenu("Client");
		trier = new JMenu("Trier");
		compte = new JMenu("Compte");
		
		porteFeuille = new JMenuItem("Porte Feuille");
		porteFeuille.setActionCommand("porteFeuille");		
		
		listeClient = new JMenuItem("Liste Clients");
		listeClient.setActionCommand("listeClients");
		quitter = new JMenuItem("Quitter");
		quitter.setActionCommand("quitter");
		prenom = new JMenuItem("Prénom");
		prenom.setActionCommand("prenom");
		solde = new JMenuItem ("Solde");
		solde.setActionCommand("solde");
		
		gestionnaire.add(porteFeuille);
		gestionnaire.addSeparator();
		gestionnaire.add(quitter);
		
		client.add(listeClient);
		
		compte.add(prenom);
		compte.add(solde);
		
		trier.add(compte);
		
		this.add(gestionnaire);
		this.add(client);
		this.add(trier);
		
		controllerPrincipale = new ControllerPrincipale(vue, gest);
		controllerTrierCompte = new ControllerTrierCompte(vue, gest);
		
		porteFeuille.addActionListener(controllerPrincipale);
		listeClient.addActionListener(controllerPrincipale);
		quitter.addActionListener(controllerPrincipale);
		
		prenom.addActionListener(controllerTrierCompte);
		solde.addActionListener(controllerTrierCompte);


	}	
}
