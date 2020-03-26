package become_a_farmer_exclude_Image;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

//게임 인트로 화면 이미지를 그려주는 패널
public class IntroGame extends JPanel {
	Image image = new ImageIcon(Main.class.getResource("../images/introBackgound.jpg")).getImage();
	//Image image = new ImageIcon(Main.class.getResource("../images/ex.png")).getImage();
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
