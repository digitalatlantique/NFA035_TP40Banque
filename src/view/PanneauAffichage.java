package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanneauAffichage extends JPanel {
	
	private JTextArea texteArea = null;
	private JLabel titre = null;

	private static String message = "\nBienvenue\n\n" + "Banque TP 40\n\n" + "Version avec Menu\n\n" + "Choisissez une option\nprésente dans le menu\n\n";
	
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
		
		// Le JTextArea		
		texteArea = new JTextArea(message);
		texteArea.setOpaque(false);
		texteArea.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		texteArea.setForeground(new Color(217, 250, 255));
		texteArea.setPreferredSize(new Dimension(180, 200));		
		font2 = font2.deriveFont((float)15.0);
		texteArea.setFont(font2);
		
		this.add(titre);
		this.add(texteArea);
		
	}
	public void changerTitre(String str) {
		this.titre.setText(str);
	}
	public void changerArea(String str) {
		this.texteArea.setText(str);
	}
	public JLabel getTitre() {
		return titre;
	}

	public void setTitre(JLabel titre) {
		this.titre = titre;
	}

	public JTextArea getTexteArea() {
		return texteArea;
	}

	public void setTexteArea(JTextArea pTexteArea) {
		this.texteArea = pTexteArea;
	}

	public static String getMessage() {
		return message;
	}

	public static void setMessage(String texte) {
		PanneauAffichage.message = texte;
	}
	
	

}
