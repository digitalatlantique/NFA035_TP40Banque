package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanneauSaisie extends JPanel {
	
	JLabel label = null;
	JTextField field = null;
	JButton bouton = null;
	
	public PanneauSaisie(VuePrincipale vue, Font font1, Font font2) {
		
		this.setPreferredSize(new Dimension(180, 70));
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		label = new JLabel("Saisir votre choix :");
		font1 = font1.deriveFont((float)15.0);
		label.setFont(font1);
		label.setForeground(new Color(0, 32, 74));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		field = new JTextField();
		font2 = font2.deriveFont(Font.BOLD, (float)17.0);
		field.setFont(font2);
		field.setForeground(new Color(0, 32, 74));
		field.setHorizontalAlignment(JTextField.CENTER);
		
		bouton = new MonBouton();
		this.add(label, BorderLayout.NORTH);
		this.add(field, BorderLayout.CENTER);
		this.add(bouton, BorderLayout.SOUTH);
		
		vue.setBouton1(bouton);
		vue.setLabel(label);
		vue.setField(field);
		
	}

}
