package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

import model.Client;
import model.Gestionnaire;

/**
 * This is the center's panel
 * @author Workstation
 *
 */
public class PanneauCentral extends JPanel {	
	
	private JTable table = null;
	private JScrollPane sp = null;
	private Font font = null;	
	private String path1 = "./assets/polices/Dustismo_Roman-webfont.ttf";
	private JList list1 = null;
	private JList list2 = null;
	
	public PanneauCentral() {
		this.setPreferredSize(new Dimension(570, 552));
		this.setOpaque(false);		

	}	
	public PanneauCentral(JTable table) {		

		this.setPreferredSize(new Dimension(570, 552));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new BorderLayout());
		
		try {			
			File fis2 = new File(path1);
			this.font = Font.createFont(Font.PLAIN, fis2);
		}
		catch(IOException | FontFormatException e) {
			e.printStackTrace();
		}
		this.table = table;
		this.sp = new JScrollPane(this.table);
		this.add(sp, BorderLayout.CENTER);
	}
	
	public PanneauCentral(JTable table, Client client) {		

		this.setPreferredSize(new Dimension(570, 552));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new BorderLayout());
		this.table = table;
		
		try {			
			File fis2 = new File(path1);
			this.font = Font.createFont(Font.PLAIN, fis2);
		}
		catch(IOException | FontFormatException e) {
			e.printStackTrace();
		}
		JLabel l = new JLabel("Trésorerie : " + client.getTresorerie() + " Euro(s).");
		this.font = this.font.deriveFont((float)18.0);
		l.setFont(font);
		l.setForeground(new Color(0, 32, 74));
		l.setHorizontalAlignment(JLabel.CENTER);		
		
		this.sp = new JScrollPane(this.table);
		this.add(sp, BorderLayout.CENTER);
		this.add(l, BorderLayout.SOUTH);
	}
	public PanneauCentral(JTable table, Gestionnaire gest) {		

		this.setPreferredSize(new Dimension(570, 552));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new BorderLayout());
		this.table = table;
		
		try {			
			File fis2 = new File(path1);
			this.font = Font.createFont(Font.PLAIN, fis2);
		}
		catch(IOException | FontFormatException e) {
			e.printStackTrace();
		}
		JLabel l = new JLabel(gest.getPrenom() + " : " + gest.consulterChiffreAffaire() + " Euro(s).");
		this.font = this.font.deriveFont((float)18.0);
		l.setFont(font);
		l.setForeground(new Color(0, 32, 74));
		l.setHorizontalAlignment(JLabel.CENTER);		
		
		this.sp = new JScrollPane(this.table);
		this.add(sp, BorderLayout.CENTER);
		this.add(l, BorderLayout.SOUTH);
	}
	
}
