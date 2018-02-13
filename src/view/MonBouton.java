package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * This is a custom's button
 * @author Workstation
 *
 */
public class MonBouton extends JButton  {
		
	private ImageIcon icon = null;
	private String path = "./assets/images/boutonOK.png";
	
	public MonBouton() {
		icon = createImageIcon(path);
		this.setIcon(icon);
        this.setToolTipText("Cliquez sur ce bouton pour valider votre choix.");
        this.setMnemonic(KeyEvent.VK_ENTER);
        this.setPreferredSize(new Dimension(180, 27));
        this.setVerticalTextPosition(AbstractButton.CENTER);
        this.setHorizontalTextPosition(AbstractButton.LEADING);
	}
	
    protected static ImageIcon createImageIcon(String path) {    	
		try {
			File fis1 = new File(path);
			Image img= ImageIO.read(fis1).getScaledInstance(23, 23, Image.SCALE_DEFAULT);
			return new ImageIcon(img);
		}
		catch(IOException e) {
			e.printStackTrace();
			return null;
		}	
    }
}
