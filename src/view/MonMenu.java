package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.ControllerTrierCompte;
import model.Gestionnaire;

public class MonMenu extends JMenuBar{

	private JMenu trier = null;
	private JMenu compte = null;
	
	private JMenuItem prenom = null;
	private JMenuItem solde = null;
	
	public MonMenu(VuePrincipale vue, Gestionnaire gest, Font font1) {		
		
		this.setBackground(new Color(217, 250, 255));
		font1 = font1.deriveFont((float)15.0);
		this.setFont(font1);
		
		trier = new JMenu("Trier");
		compte = new JMenu("Compte");
		
		prenom = new JMenuItem("Prénom");
		solde = new JMenuItem ("Solde");
		
		compte.add(prenom);
		compte.add(solde);
		
		trier.add(compte);
		
		this.add(trier);
		
		prenom.addActionListener(new ControllerTrierCompte(vue, gest));
		solde.addActionListener(new ControllerTrierCompte(vue, gest));

	}	
}
