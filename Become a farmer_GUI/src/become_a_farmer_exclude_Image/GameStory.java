package become_a_farmer_exclude_Image;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameStory extends JPanel {
	
	//게임스토리 이미지를 그려주는 패널
	Image image = new ImageIcon(Main.class.getResource("../images/gameExplain.jpg")).getImage();
	//Image image = new ImageIcon(Main.class.getResource("../images/ex.png")).getImage();
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
