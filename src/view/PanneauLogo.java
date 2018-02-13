package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * This panel use to display the logo
 * @author Workstation
 *
 */
public class PanneauLogo extends JPanel {
	
	private String path1 = "./assets/images/banque.png";
	private Image img1 = null;
	
	public PanneauLogo() {
		this.setPreferredSize(new Dimension(180, 100));
		this.setOpaque(false);
		
	}
	public void paintComponent(Graphics g) {

		try {
			File fis1 = new File(path1);
			this.img1= ImageIO.read(fis1);
			g.drawImage(img1, (getWidth()/2)-25,  0, this);
		}
		catch(IOException e) {
			e.printStackTrace();
		}		
	}
}
