package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MenuBar;
import java.awt.TextField;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Iterator;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import controller.ControllerPrincipale;
import main.DemoApli;

import javax.imageio.ImageIO;

import model.Client;
import model.Compte;
import model.Gestionnaire;

public class VuePrincipale extends JFrame{
	// Palette Couleur => RGB1(0, 32, 74) RGB2(0, 87, 146) RGB3(0, 187, 240) RGB4(217, 250, 255)
	private JPanel panPrincipal = null;
	private JPanel panLogo = null;
	private JPanel panG = null;
	private PanneauCentral panC = null;
	private PanneauAffichage panAffichage = null;
	private JPanel panSaisie = null;
	
	private JMenuBar menuBar = null;

	private JLabel label = null;
	private JTextField field= null;
	
	private JButton bouton1 = null;
	private JButton bouton2 = null;
	private Font font1 = null;
	private Font font2 = null;

	private String path1 = "./assets/polices/Dustismo_Roman-webfont.ttf";
	private String path2 = "./assets/polices/CaviarDreams-webfont.ttf";	
	private Gestionnaire gestionnaire = null;
	
	public VuePrincipale(Gestionnaire gest) {
		// Configuration fenêtre principale
		super("Banque_TP40_version-IHM");		
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.gestionnaire = gest;
		
		try {			
			File fis1 = new File(path1);
			this.font1 = Font.createFont(Font.PLAIN, fis1);
			File fis2 = new File(path2);
			this.font2 = Font.createFont(Font.PLAIN, fis2);
		}
		catch(IOException | FontFormatException e) {
			e.printStackTrace();
		}	
		
		// Panneau principale
		panPrincipal = new PanneauPrincipal();
		panG = new JPanel();
		panC = new PanneauCentral();
		
		// JMenuBar
		menuBar = new MonMenu(this, gest, font1);
		
		// Panneau logo
		panLogo = new PanneauLogo();		
		// Panneau menu latérale
		panAffichage = new PanneauAffichage(font1, font2);
		/*Panneau saisie		
		panSaisie = new PanneauSaisie(this, this.font1, this.font2);
		panG.add(panSaisie, BorderLayout.SOUTH);
		
		// Ecoute du bouton
		this.getBouton().addActionListener(cp);
		
		 */
		
		// Panneau de gauche
		panG.setLayout(new BorderLayout());
		panG.setPreferredSize(new Dimension(180, 480));
		panG.setOpaque(false);
		panG.add(panLogo, BorderLayout.NORTH);
		panG.add(panAffichage, BorderLayout.CENTER);
		

		panPrincipal.add(panG);
		panPrincipal.add(panC);

		this.setJMenuBar(menuBar);
		this.setContentPane(panPrincipal);	
		
		this.pack();
		this.setVisible(true);	
		
		// Instance du controller
		ControllerPrincipale cp = new ControllerPrincipale(this, gest);

	}	


	public JButton getBouton() {
		return bouton1;
	}
	
	public void setBouton1(JButton bouton1) {
		this.bouton1 = bouton1;
	}
	public JButton getBouton2() {
		return bouton2;
	}

	public JTextField getField() {
		return field;
	}

	public void setField(JTextField field) {
		this.field = field;
	}
	
	public void setLabel(JLabel label) {
		this.label = label;
	}
	public void afficherListeCompte(ArrayList<Compte> liste) {

		panAffichage.changerTitre("Liste");
		panAffichage.changerArea("\n\nListe des comptes clients");
		
		ModeleTableCompte modele = new ModeleTableCompte(liste);
	
		JTable table = new JTable(modele);
		table.getColumnModel().getColumn(3).setCellRenderer(new DebitCellRenderer());

		panPrincipal.remove(panC);		
		panC = new PanneauCentral(table);
		panPrincipal.add(panC);
		this.setVisible(true);
	}
	public void afficherListeClient(Vector<Client> liste) {
		
		ModeleTableClient modele = new ModeleTableClient(liste);		
		JTable table = new JTable(modele);
		table.getColumnModel().getColumn(5).setCellRenderer(new DebitCellRenderer());

		panPrincipal.remove(panC);		
		panC = new PanneauCentral(table);
		panPrincipal.add(panC);
		
		this.setVisible(true);
	}
	public void afficherCompteClient(Client client, ArrayList<Compte> liste) {	
		
		ModeleTableCompte modele = new ModeleTableCompte(liste);
		
		JTable table = new JTable(modele);
		table.getColumnModel().getColumn(3).setCellRenderer(new DebitCellRenderer());

		panPrincipal.remove(panC);		
		panC = new PanneauCentral(table, client);
		panPrincipal.add(panC);

		this.setVisible(true);
	}
	public void afficherPortefeuilleGestionnaire(ArrayList<Compte> liste, Gestionnaire gest) {
	
		ModeleTableCompte modele = new ModeleTableCompte(liste);
		
		JTable table = new JTable(modele);
		table.getColumnModel().getColumn(3).setCellRenderer(new DebitCellRenderer());

		panPrincipal.remove(panC);		
		panC = new PanneauCentral(table, gest);
		panPrincipal.add(panC);

		this.setVisible(true);
	}
	public void afficherCombo(Gestionnaire gest) {
		JComboBox<String> combo = null;
		String[] prenomClient = null; 
		Vector<Client> liste = gest.listerClient();

		int i = 0;
		prenomClient = new String[liste.size()];
		Iterator iterateur = liste.iterator();
		
		while(iterateur.hasNext()) {
			prenomClient[i] = ((Client) iterateur.next()).getPrenom();
			i++;
		}		
		combo = new JComboBox(prenomClient);
		combo.addActionListener(new ControllerPrincipale(this, this.gestionnaire));
		combo.setActionCommand("combo");
		
		this.panAffichage.add(combo, BorderLayout.SOUTH);
		this.setVisible(true);
		
	}

	public void comboExiste() {
		panAffichage.changerTitre("Information");
		panAffichage.changerArea("\n\nVeuillez choisir un prénom\ndans la liste déroulante");
	}
	public void afficherMessageFin() {
		JOptionPane jop = new JOptionPane();
		jop.showMessageDialog(this,  "Au revoir et à bientôt", "Information", JOptionPane.INFORMATION_MESSAGE);		

	}
	public void afficherSaisieChoix() {
		panSaisie.remove(bouton2);
		panSaisie.add(bouton1, BorderLayout.SOUTH);
		label.setText("Saisir votre choix :");
		label.setForeground(Color.BLACK);
	}
	
	public void afficherSaisiePrenom() {
		this.field.setText("");
		panSaisie.remove(bouton1);
		bouton2 = new MonBouton();
		panSaisie.add(bouton2, BorderLayout.SOUTH);
		label.setText("Saisir un prénom :");
	}
	public void afficherErreurMenu() {
		label.setForeground(Color.RED);
		label.setText("Saisie incorrect !!");
	}
	public void afficherLabel() {
		label.setForeground(Color.BLACK);
		label.setText("Saisir votre choix :");	
	}
}
