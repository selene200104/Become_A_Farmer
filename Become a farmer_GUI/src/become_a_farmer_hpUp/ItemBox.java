package become_a_farmer_hpUp;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ItemBox extends JFrame{

	JPanel ItemBoxPanel = new JPanel();
	
	ItemBox(){
		
		ItemBoxPanel.setLayout(null);
		ItemBoxPanel.setBounds(0, 0, 300, 150);
		
		add(ItemBoxPanel);
		
		if(LettuceSeeds.count != 0) {
			JLabel Lettuce_seedsLabel = new JLabel();
			Lettuce_seedsLabel.setText("������ : "+LettuceSeeds.name+"      ����: "+LettuceSeeds.count+"��");
			Lettuce_seedsLabel.setBounds(20, 10, 200, 20);
			Lettuce_seedsLabel.setOpaque(true);
			ItemBoxPanel.add(Lettuce_seedsLabel);
		}
		
		if(CarrotSeeds.count != 0) {
			JLabel Carrot_seeds_Label = new JLabel();
			Carrot_seeds_Label.setText("������ : "+CarrotSeeds.name+"       ����: "+CarrotSeeds.count+"��");
			Carrot_seeds_Label.setBounds(20, 30, 200, 20);
			Carrot_seeds_Label.setOpaque(true);
			ItemBoxPanel.add(Carrot_seeds_Label);
		}
		
		if(RadishSeeds.count != 0) {
			JLabel Radish_seeds_Label = new JLabel();
			Radish_seeds_Label.setText("������ : "+RadishSeeds.name+"           ����: "+RadishSeeds.count+"��");
			Radish_seeds_Label.setBounds(20, 50, 200, 20);
			Radish_seeds_Label.setOpaque(true);
			ItemBoxPanel.add(Radish_seeds_Label);
		}
		
		if(PotionOfHp.count != 0) {
			JLabel PotionOfHp_Label = new JLabel();
			PotionOfHp_Label.setText("������ : "+PotionOfHp.name+"       ����: "+PotionOfHp.count+"��");
			PotionOfHp_Label.setBounds(20, 70, 200, 20);
			PotionOfHp_Label.setOpaque(true);
			ItemBoxPanel.add(PotionOfHp_Label);
		}

		setTitle("�����۹ڽ�");
		setSize(350, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
	}
}
