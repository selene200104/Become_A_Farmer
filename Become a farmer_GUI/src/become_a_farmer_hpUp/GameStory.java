package become_a_farmer_hpUp;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameStory extends JPanel {
	
	Image image = new ImageIcon(Main.class.getResource("../images/gameExplain.jpg")).getImage();
	//Image image = new ImageIcon(Main.class.getResource("../images/ex.png")).getImage();
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
