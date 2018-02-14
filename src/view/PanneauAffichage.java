package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ControllerPrincipale;

/**
 * This is the display's panel
 * @author Workstation
 *
 */
public class PanneauAffichage extends JPanel {
	
	private JList listeChoix;
	private JLabel titre = null;
	private JLabel infoChoix = null;
	private JButton bouton = null;

	private static String[] ChoixUtilisateur = {"0 Fin session", "1 Lister client", "2 Lister compte d'un client", "3 CA gestionnaire"};
	
	public PanneauAffichage(Font font1, Font font2) {
	
		this.setOpaque(false);
		
		// Le titre du menu
		titre = new JLabel("Accueil");
		titre.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		titre.setPreferredSize(new Dimension(180, 40));
		font1 = font1.deriveFont((float)25.0);
		titre.setFont(font1);
		titre.setForeground(Color.WHITE);
		titre.setHorizontalAlignment(JLabel.CENTER);
		
		// Le JList	
		listeChoix = new JList(ChoixUtilisateur);
		listeChoix.setOpaque(true);
		listeChoix.setBorder(BorderFactory.createLineBorder(Color.WHITE));	
		font2 = font2.deriveFont((float)15.0);
		listeChoix.setFont(font2);
		
		infoChoix = new JLabel("Choisir une option");
		infoChoix.setPreferredSize(new Dimension(180, 22));
		infoChoix.setBackground(Color.WHITE);
		infoChoix.setOpaque(true);
		font1 = font1.deriveFont((float)15.0);
		infoChoix.setFont(font1);
		infoChoix.setForeground(new Color(0, 32, 74));		
		infoChoix.setHorizontalAlignment(JLabel.CENTER);
		
		bouton = new JButton("Valider");
		bouton.setPreferredSize(new Dimension(180, 25));
		bouton.setActionCommand("bouton");
		
		this.add(titre);
		this.add(listeChoix);
		this.add(infoChoix);
		this.add(bouton);
		
	}
	public void changerTitre(String str) {
		this.titre.setText(str);
	}
	public JLabel getTitre() {
		return titre;
	}
	
	public void ecouterJList(ListSelectionListener controllerPrincipale) {
		listeChoix.addListSelectionListener(controllerPrincipale);
	}
	public void ecouterBouton(ActionListener controllerPrincipale) {
		bouton.addActionListener(controllerPrincipale);
	}

	public JList getListeChoix() {
		return listeChoix;
	}
	public void setTitre(JLabel titre) {
		this.titre = titre;
	}
	public void afficherChoix(String choix) {
		infoChoix.setText(choix);
	}
	
	

}
