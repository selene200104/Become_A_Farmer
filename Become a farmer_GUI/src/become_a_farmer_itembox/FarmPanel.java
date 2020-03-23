package become_a_farmer_itembox;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FarmPanel extends JPanel {
	Image image = new ImageIcon(Main.class.getResource("../images/gameBackground.jpg")).getImage();
	//Image image = new ImageIcon(Main.class.getResource("../images/ex.png")).getImage();
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 50, 600, 450, this);
	}
}
