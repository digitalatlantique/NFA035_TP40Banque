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
import java.awt.event.ActionListener;
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

/**
 * This is the main frame
 * The colors use in this application are : RGB1(0, 32, 74) RGB2(0, 87, 146) RGB3(0, 187, 240) RGB4(217, 250, 255)
 * @author Workstation
 *
 */
public class VuePrincipale extends JFrame{

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

	
	/**
	 * Default constructor the main frame
	 * @param gest
	 */
	public VuePrincipale() {
		// Configuration fenêtre principale
		super("Banque_TP40_version-IHM");		
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		try {			
			File fis1 = new File(path1);
			this.font1 = Font.createFont(Font.PLAIN, fis1);
			File fis2 = new File(path2);
			this.font2 = Font.createFont(Font.PLAIN, fis2);
		}
		catch(IOException | FontFormatException e) {
			e.printStackTrace();
		}	
		
		// Main panel
		panPrincipal = new PanneauPrincipal();
		panG = new JPanel();
		panC = new PanneauCentral();
		
		// JMenuBar
		menuBar = new MonMenu(font1);
		
		// Logo panel
		panLogo = new PanneauLogo();		
		//Display panel
		panAffichage = new PanneauAffichage(font1, font2);
		
		// Left panel
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
	
	public void ecouterMenu(ActionListener controllerPrincipale) {
		((MonMenu) menuBar).ecouterElementsMenu(controllerPrincipale);
	}
	
	/**
	 * Display all accounts
	 * @param liste
	 */
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
	
	/**
	 * Display all the customers
	 * @param liste
	 */
	public void afficherListeClient(Vector<Client> liste) {
		
		panAffichage.changerTitre("Liste");
		panAffichage.changerArea("\n\nListe des clients");
		
		ModeleTableClient modele = new ModeleTableClient(liste);		
		JTable table = new JTable(modele);
		table.getColumnModel().getColumn(5).setCellRenderer(new DebitCellRenderer());

		panPrincipal.remove(panC);		
		panC = new PanneauCentral(table);
		panPrincipal.add(panC);
		
		this.setVisible(true);
	}
	
	/**
	 * Display all accounts of the customer
	 * @param client
	 * @param liste
	 */
	public void afficherCompteClient(Client client, ArrayList<Compte> liste) {
		
		panAffichage.changerTitre("Liste");
		panAffichage.changerArea("\n\nListe des comptes\nd'un client");
		
		ModeleTableCompte modele = new ModeleTableCompte(liste);
		
		JTable table = new JTable(modele);
		table.getColumnModel().getColumn(3).setCellRenderer(new DebitCellRenderer());

		panPrincipal.remove(panC);		
		panC = new PanneauCentral(table, client);
		panPrincipal.add(panC);

		this.setVisible(true);
	}
	
	/**
	 * Display all accounts of the administrator
	 * @param liste
	 * @param gest
	 */
	public void afficherPortefeuilleGestionnaire(ArrayList<Compte> liste, Gestionnaire gest) {
		
		panAffichage.changerTitre("Gestionnaire");
		panAffichage.changerArea("\n\nListe des comptes\ndes clients du\ngestionnaire");
	
		ModeleTableCompte modele = new ModeleTableCompte(liste);
		
		JTable table = new JTable(modele);
		
		table.getColumnModel().getColumn(3).setCellRenderer(new DebitCellRenderer());		
		panPrincipal.remove(panC);		
		panC = new PanneauCentral(table, gest);
		panPrincipal.add(panC);

		this.setVisible(true);
	}
	
	/**
	 * Dispaly a JComboBox with the first name of the customers
	 * @param gest
	 */
	public void afficherCombo(Gestionnaire gest) {
		
		panAffichage.changerTitre("Sélection");
		panAffichage.changerArea("\n\nChoisir un client...");
		
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
		combo.addActionListener(new ControllerPrincipale(this, gest));
		combo.setActionCommand("combo");
		
		this.panAffichage.add(combo, BorderLayout.SOUTH);
		this.setVisible(true);
		
	}

	/**
	 * Check if the JComboBox exist
	 */
	public void comboExiste() {
		panAffichage.changerTitre("Information");
		panAffichage.changerArea("\n\nVeuillez choisir un prénom\ndans la liste déroulante");
	}
	
	/**
	 * Display a message to say goodbye
	 */
	public void afficherMessageFin() {
		JOptionPane jop = new JOptionPane();
		jop.showMessageDialog(this,  "Au revoir et à bientôt", "Information", JOptionPane.INFORMATION_MESSAGE);		

	}
	// TODO Adapt with the new display 
	/**
	 * Display the choice of the user 
	 * @deprecated
	 */
	public void afficherSaisieChoix() {
		panSaisie.remove(bouton2);
		panSaisie.add(bouton1, BorderLayout.SOUTH);
		label.setText("Saisir votre choix :");
		label.setForeground(Color.BLACK);
	}
	
	// TODO Adapt with the new display 
	/**
	 * Display the first name selected
	 * @deprecated
	 */
	public void afficherSaisiePrenom() {
		this.field.setText("");
		panSaisie.remove(bouton1);
		bouton2 = new MonBouton();
		panSaisie.add(bouton2, BorderLayout.SOUTH);
		label.setText("Saisir un prénom :");
	}
	
	// TODO Adapt with the new display 
	/**
	 * Display an key in error
	 * @deprecated
	 */
	public void afficherErreurMenu() {
		label.setForeground(Color.RED);
		label.setText("Saisie incorrect !!");
	}
	
	// TODO Adapt with the new display 
	/**
	 * Display the label of the key in
	 * @deprecated
	 */
	public void afficherLabel() {
		label.setForeground(Color.BLACK);
		label.setText("Saisir votre choix :");	
	}
}
