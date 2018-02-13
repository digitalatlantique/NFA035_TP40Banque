package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * this is the main panel
 * @author Workstation
 *
 */
public class PanneauPrincipal extends JPanel {
	
	public PanneauPrincipal() {
		
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		GradientPaint gp = new GradientPaint(0, 0, new Color(0, 32, 74), 600, 800, new Color(0, 87, 146), true);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

}
