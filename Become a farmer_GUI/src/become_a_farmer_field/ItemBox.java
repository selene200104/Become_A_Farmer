package become_a_farmer_field;

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

		JLabel Lettuce_seedsLabel = new JLabel();
		Lettuce_seedsLabel.setText("������ : "+Lettuce.seedsName+"       ����: "+Lettuce.seedsAmount+"��");
		Lettuce_seedsLabel.setBounds(20, 10, 200, 20);
		Lettuce_seedsLabel.setOpaque(true);
		ItemBoxPanel.add(Lettuce_seedsLabel);
		
		JLabel Carrot_seeds_Label = new JLabel();
		Carrot_seeds_Label.setText("������ : "+Carrot.seedsName+"        ����: "+Carrot.seedsAmount+"��");
		Carrot_seeds_Label.setBounds(20, 30, 200, 20);
		Carrot_seeds_Label.setOpaque(true);
		ItemBoxPanel.add(Carrot_seeds_Label);
		
		JLabel Radish_seeds_Label = new JLabel();
		Radish_seeds_Label.setText("������ : "+Radish.seedsName+"          ����: "+Radish.seedsAmount+"��");
		Radish_seeds_Label.setBounds(20, 50, 200, 20);
		Radish_seeds_Label.setOpaque(true);
		ItemBoxPanel.add(Radish_seeds_Label);

		JLabel Fertilize_Label = new JLabel();
		Fertilize_Label.setText("������ : "+Fertilize.name+"              ����: "+Fertilize.amount+"��");
		Fertilize_Label.setBounds(20, 70, 200, 20);
		Fertilize_Label.setOpaque(true);
		ItemBoxPanel.add(Fertilize_Label);
		
		JLabel PotionOfHp_Label = new JLabel();
		PotionOfHp_Label.setText("������ : "+PotionOfHp.name+"       ����: "+PotionOfHp.amount+"��");
		PotionOfHp_Label.setBounds(20, 90, 200, 20);
		PotionOfHp_Label.setOpaque(true);
		ItemBoxPanel.add(PotionOfHp_Label);
		
		/*if(Lettuce.seedsAmount != 0) {
			JLabel Lettuce_seedsLabel = new JLabel();
			Lettuce_seedsLabel.setText("������ : "+Lettuce.seedsName+"       ����: "+Lettuce.seedsAmount+"��");
			Lettuce_seedsLabel.setBounds(20, 10, 200, 20);
			Lettuce_seedsLabel.setOpaque(true);
			ItemBoxPanel.add(Lettuce_seedsLabel);
		}
		
		if(Carrot.seedsAmount != 0) {
			JLabel Carrot_seeds_Label = new JLabel();
			Carrot_seeds_Label.setText("������ : "+Carrot.seedsName+"        ����: "+Carrot.seedsAmount+"��");
			Carrot_seeds_Label.setBounds(20, 30, 200, 20);
			Carrot_seeds_Label.setOpaque(true);
			ItemBoxPanel.add(Carrot_seeds_Label);
		}
		
		if(Radish.seedsAmount != 0) {
			JLabel Radish_seeds_Label = new JLabel();
			Radish_seeds_Label.setText("������ : "+Radish.seedsName+"          ����: "+Radish.seedsAmount+"��");
			Radish_seeds_Label.setBounds(20, 50, 200, 20);
			Radish_seeds_Label.setOpaque(true);
			ItemBoxPanel.add(Radish_seeds_Label);
		}
		
		if(Fertilize.amount != 0) {
			JLabel Fertilize_Label = new JLabel();
			Fertilize_Label.setText("������ : "+Fertilize.name+"              ����: "+Fertilize.amount+"��");
			Fertilize_Label.setBounds(20, 70, 200, 20);
			Fertilize_Label.setOpaque(true);
			ItemBoxPanel.add(Fertilize_Label);
		}
		
		if(PotionOfHp.amount != 0) {
			JLabel PotionOfHp_Label = new JLabel();
			PotionOfHp_Label.setText("������ : "+PotionOfHp.name+"       ����: "+PotionOfHp.amount+"��");
			PotionOfHp_Label.setBounds(20, 90, 200, 20);
			PotionOfHp_Label.setOpaque(true);
			ItemBoxPanel.add(PotionOfHp_Label);
		}*/

		setTitle("�����۹ڽ�");
		setSize(350, 160);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
	}
}
