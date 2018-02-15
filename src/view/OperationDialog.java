package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.Compte;

/**
 * This show the banking transaction and get the data capture
 * @author Workstation
 *
 */
public class OperationDialog extends JDialog implements Observer {
	
	private JPanel nord;
	private JPanel checkPan;
	private JPanel principale;
	private JPanel sud;	

	private JRadioButton radioCrediter;
	private JRadioButton radioDebiter;
	private JComboBox<String> combo;	
	
	private JLabel labelNumero;
	private JLabel labelSolde;
	private JLabel montant;
	
	private JTextField saisieMontant;
	private JButton bouton;
		
	private ButtonGroup bg;	
	
	/**
	 * Constructor for the operation dialog
	 * @param parent
	 * @param title
	 * @param modal
	 * @param listeCPT
	 */
	public OperationDialog(JFrame parent, String title, boolean modal, ArrayList<Compte> listeCPT) {
		
		super(parent, title, modal);
		
		this.setLocation(parent.getLocation());
		this.setResizable(false);
		
		// Panel
		nord = new JPanel();
		checkPan = new JPanel();
		principale = new JPanel();
		sud = new JPanel();		

		// Label
		labelNumero = new JLabel("  Numéro de compte : ");
		labelSolde = new JLabel("Choisir un compte  ");
		montant = new JLabel("Saisir le montant : ");
		
		// Radio Button
		radioCrediter = new JRadioButton("Créditer");
		radioCrediter.setSelected(true);
		radioDebiter = new JRadioButton("Débiter");
		
		// To group the Radio Button
		bg = new ButtonGroup();
		bg.add(radioCrediter);
		bg.add(radioDebiter);

		checkPan.add(radioCrediter);
		checkPan.add(radioDebiter);
		
		// Text Field
		saisieMontant = new JTextField(15);
		
		// Layout
		nord.setLayout(new BorderLayout());
		nord.add(checkPan, BorderLayout.NORTH);
		nord.add(labelNumero, BorderLayout.WEST);
		nord.add(labelSolde, BorderLayout.EAST);		
		
		// To initialize Combo Box
		initComBo(listeCPT);
		principale.add(combo);
		principale.add(montant);
		principale.add(saisieMontant);
		
		// The button
		bouton = new JButton("Valider");
		bouton.setActionCommand("bouton");
		sud.add(bouton);
		
		this.setLayout(new BorderLayout());
		this.add(nord, BorderLayout.NORTH);
		this.add(principale, BorderLayout.CENTER);
		this.add(sud, BorderLayout.SOUTH);
		
		this.pack();
		this.setVisible(true);
		
	}
	
	/**
	 * To initialize Combo Box
	 * @param listeCPT
	 */
	public void initComBo(ArrayList<Compte> listeCPT) {
		
		String[] listeNumeroCompte = new String[listeCPT.size()];
		
		Iterator iterateur = listeCPT.iterator();
		
		int indice = 0;
		
		while(iterateur.hasNext()) {
			
			listeNumeroCompte[indice] = (String) ((Compte) iterateur.next()).getNumCpte();
			indice++;
		}	
		
		combo = new JComboBox(listeNumeroCompte);
		combo.setActionCommand("combo");
	}

	/**
	 * To listen button
	 * @param contollerOperationBancaire
	 */
	public void ecouterBouton(ActionListener contollerOperationBancaire) {
		bouton.addActionListener(contollerOperationBancaire);
	}
	
	/**
	 * To listen Combo Box
	 * @param contollerOperationBancaire
	 */
	public void ecouterCombo(ActionListener contollerOperationBancaire) {		
		combo.addActionListener(contollerOperationBancaire);
	}	

	public JRadioButton getRadioCrediter() {
		return radioCrediter;
	}
	public JRadioButton getRadioDebiter() {
		return radioDebiter;
	}
	public JLabel getLabelSolde() {
		return labelSolde;
	}
	public JTextField getSaisieMontant() {
		return saisieMontant;
	}
	
	/**
	 * Update of the balance label
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		double solde = ((Compte) arg0).getSolde();
		String soldeStr = new DecimalFormat("0.00 E  ").format(solde);
		labelSolde.setText("Nouveau solde : " + soldeStr);
	}	

}
