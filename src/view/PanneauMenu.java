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

public class PanneauMenu extends JPanel {
	
	private JTextArea ta = null;
	private JLabel titre = null;

	private static String texteMenu = "\n0 Fin session\n\n" + "1 Liste des comptes\n\n" + "2 Liste des clients\n\n" + "3 Trésorerie d'un client\n\n" + "4 Portefeuille gestionnaire\n\n";
	
	public PanneauMenu(Font font1, Font font2) {
	
		this.setOpaque(false);
		
		// Le titre du menu
		titre = new JLabel("Menu");
		titre.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		titre.setPreferredSize(new Dimension(180, 40));
		font1 = font1.deriveFont((float)25.0);
		titre.setFont(font1);
		titre.setForeground(Color.WHITE);
		titre.setHorizontalAlignment(JLabel.CENTER);
		
		// Le JTextArea
		ta = new JTextArea(texteMenu);
		ta.setOpaque(false);
		ta.setForeground(new Color(217, 250, 255));
		ta.setPreferredSize(new Dimension(180, 200));		
		font2 = font2.deriveFont((float)15.0);
		ta.setFont(font2);
		
		this.add(titre);
		this.add(ta);
		
	}

}
