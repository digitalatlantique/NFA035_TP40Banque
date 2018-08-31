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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ControllerPrincipale;
import main.DemoApli;
import model.Client;
import model.Compte;
import model.Gestionnaire;

/**
 * This is the main frame
 * The colors use in this application are : RGB1(0, 32, 74) RGB2(0, 87, 146) RGB3(0, 187, 240) RGB4(217, 250, 255)
 * @author Workstation
 *
 */
public class VuePrincipale extends JFrame implements Observer{

	private JPanel panPrincipal = null;
	private JPanel panLogo = null;
	private JPanel panG = null;
	private PanneauCentral panC = null;
	private PanneauAffichage panAffichage = null;
	private JPanel panSaisie = null;
	
	private MonMenu menuBar = null;

	private JLabel label = null;
	private JTextField field= null;
	private JList<String> listeMenu;
	
	private JButton bouton1 = null;
	private JButton bouton2 = null;
	private Font font1 = null;
	private Font font2 = null;

	private String path1 = "/data/polices/Dustismo_Roman-webfont.ttf";
	private String path2 = "/data/polices/CaviarDreams-webfont.ttf";	

	
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
			InputStream is1 = this.getClass().getResourceAsStream(path1);
			InputStream is2 = this.getClass().getResourceAsStream(path2);
			
			this.font1 = Font.createFont(Font.PLAIN, is1);			
			this.font2 = Font.createFont(Font.PLAIN, is2);
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
		listeMenu = panAffichage.getListeChoix();
		
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
	

	public JList<String> getListeMenu() {
		return listeMenu;
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
	
	public void ecouterJList(ListSelectionListener controllerPrincipale) {
		panAffichage.ecouterJList(controllerPrincipale);
	}
	public void ecouterBouton(ActionListener controllerPrincipale) {
		panAffichage.ecouterBouton(controllerPrincipale);
	}
	
	/**
	 * Display all accounts
	 * @param liste
	 */
	public void afficherListeCompte(ArrayList<Compte> liste) {

		panAffichage.changerTitre("Liste");
		
		
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
		
		this.panAffichage.add(combo);
		this.setVisible(true);
		
	}

	/**
	 * Check if the JComboBox exist
	 */
	public void comboExiste() {
		panAffichage.changerTitre("Information");
		afficherChoix("Selectionner un client ");
	}
	
	/**
	 * Display a message to say goodbye
	 */
	public void afficherMessageFin() {
		JOptionPane jop = new JOptionPane();
		jop.showMessageDialog(this,  "Au revoir et à bientôt", "Information", JOptionPane.INFORMATION_MESSAGE);		

	}
	
	/**
	 * Display the choice of the user 
	 * 
	 */
	public void afficherChoix(String choix) {		
		panAffichage.afficherChoix(choix);		
	}
	
	/**
	 * Display an key in error
	 * 
	 */
	public static void afficherErreur(String message) {
		JOptionPane optionPane = new JOptionPane();
		optionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void afficherConfirme(String message) {
		JOptionPane optionPane = new JOptionPane();
		optionPane.showMessageDialog(null, message, "Confirmation", JOptionPane.INFORMATION_MESSAGE);
	}


	@Override
	public void update(Observable arg0, Object arg1) {

		afficherChoix("Nouveau solde ");
	
		Compte compte = (Compte) arg0;
		ArrayList<Compte> compteListe = new ArrayList();
		compteListe.add(compte);
		
		this.afficherListeCompte(compteListe);
		
	}

}
