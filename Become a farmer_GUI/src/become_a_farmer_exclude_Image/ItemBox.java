package become_a_farmer_exclude_Image;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ItemBox extends JFrame{

	JPanel ItemBoxPanel = new JPanel();
	
	ItemBox(){
		
		//x축, y축, 너비, 높이 
		int x_axis = 20;
		int y_axis = 10;
		int width = 120;
		int height = 20;
		
		//아이템 박스 창 초기값
		setTitle("아이템박스");
		setSize(80, 180);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
		
		Container container = getContentPane();
		container.setLayout(null);
		container.setBackground(Color.WHITE);	
		
		JLabel itemListLabel = new JLabel();
		itemListLabel.setText("◈ 아이템종류  ◈");
		itemListLabel.setHorizontalAlignment(JLabel.CENTER);
		itemListLabel.setBounds(x_axis, y_axis, width, height);
		itemListLabel.setBackground(Color.white);
		itemListLabel.setOpaque(true);
		container.add(itemListLabel);
		
		//상추씨앗의 갯수를 나타낼 라벨
		JLabel item_LettuceSeeds = new JLabel();
		item_LettuceSeeds.setText(Lettuce.seedsName+" [ "+Lettuce.seedsAmount+" ] ");
		item_LettuceSeeds.setHorizontalAlignment(JLabel.CENTER);
		item_LettuceSeeds.setBounds(x_axis, y_axis+20, width, height);
		item_LettuceSeeds.setBackground(Color.white);
		item_LettuceSeeds.setOpaque(true);
		container.add(item_LettuceSeeds);
		
		//당근씨앗의 갯수를 나타낼 라벨
		JLabel item_CarrotSeeds = new JLabel();
		item_CarrotSeeds.setText(Carrot.seedsName+" [ "+Carrot.seedsAmount+" ] ");
		item_CarrotSeeds.setHorizontalAlignment(JLabel.CENTER);
		item_CarrotSeeds.setBounds(x_axis, y_axis+40, width, height);
		item_CarrotSeeds.setBackground(Color.white);
		item_CarrotSeeds.setOpaque(true);
		container.add(item_CarrotSeeds);
		
		//무 씨앗의 갯수를 나타낼 라벨
		JLabel item_RadishSeeds = new JLabel();
		item_RadishSeeds.setText(Radish.seedsName+" [ "+Radish.seedsAmount+" ] ");
		item_RadishSeeds.setHorizontalAlignment(JLabel.CENTER);
		item_RadishSeeds.setBounds(x_axis, y_axis+60, width, height);
		item_RadishSeeds.setBackground(Color.white);
		item_RadishSeeds.setOpaque(true);
		container.add(item_RadishSeeds);
		
		//무 씨앗의 갯수를 나타낼 라벨
		JLabel item_Fertilize = new JLabel();
		item_Fertilize.setText(Fertilize.name+" [ "+Fertilize.amount+" ] ");
		item_Fertilize.setHorizontalAlignment(JLabel.CENTER);
		item_Fertilize.setBounds(x_axis, y_axis+80, width, height);
		item_Fertilize.setBackground(Color.white);
		item_Fertilize.setOpaque(true);
		container.add(item_Fertilize);
		
		//포션의 갯수를 나타낼 라벨
		JLabel item_PotionOfHp = new JLabel();
		item_PotionOfHp.setText(PotionOfHp.name+" [ "+PotionOfHp.amount+" ] ");
		item_PotionOfHp.setHorizontalAlignment(JLabel.CENTER);
		item_PotionOfHp.setBounds(x_axis, y_axis+100, width, height);
		item_PotionOfHp.setBackground(Color.white);
		item_PotionOfHp.setOpaque(true);
		container.add(item_PotionOfHp);
		
	}
}
