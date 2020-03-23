package become_a_farmer_itembox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Market extends JFrame{

	JPanel MarketPanel = new JPanel();
	
	int shoppingPrice = 0;
	
	Market(){
		
		//마켓 창의 배경 색을 변경
		Container container = getContentPane();
		container.setLayout(null);
		container.setBackground(Color.WHITE);
		
		/*MarketPanel.setLayout(null);
		MarketPanel.setBounds(0, 0, 300, 150);
		MarketPanel.setBackground(new Color(255, 0, 0, 255));*/
		
		/*JLabel momneyLabel = new JLabel();
		momneyLabel.setText("현재 소지금은 " + FarmGame.money +" 원 입니다.");
		//momneyLabel.setBounds(20, 10, 200, 20);
		momneyLabel.setOpaque(true);
		container.add(momneyLabel);*/
		JLabel ItemLabel = new JLabel();
		ItemLabel.setText("▽ 구입물품 ▽ ");
		ItemLabel.setHorizontalAlignment(JLabel.CENTER);
		ItemLabel.setBounds(20, 10, 100, 20);
		ItemLabel.setBackground(Color.white);
		ItemLabel.setOpaque(true);
		container.add(ItemLabel);
				
		JLabel LettuceSeedsLabel = new JLabel();
		LettuceSeedsLabel.setText(""+LettuceSeeds.name);
		LettuceSeedsLabel.setHorizontalAlignment(JLabel.CENTER);
		LettuceSeedsLabel.setBounds(20, 40, 100, 20);
		LettuceSeedsLabel.setBackground(Color.white);
		LettuceSeedsLabel.setOpaque(true);
		container.add(LettuceSeedsLabel);
				
		JLabel CarrotSeedsLabel = new JLabel();
		CarrotSeedsLabel.setText(""+CarrotSeeds.name);
		CarrotSeedsLabel.setHorizontalAlignment(JLabel.CENTER);
		CarrotSeedsLabel.setBounds(20, 70, 100, 20);
		CarrotSeedsLabel.setBackground(Color.white);
		CarrotSeedsLabel.setOpaque(true);
		container.add(CarrotSeedsLabel);
		
		JLabel RadishSeedsLabel = new JLabel();
		RadishSeedsLabel.setText(""+RadishSeeds.name);
		RadishSeedsLabel.setHorizontalAlignment(JLabel.CENTER);
		RadishSeedsLabel.setBounds(20, 100, 100, 20);
		RadishSeedsLabel.setBackground(Color.white);
		RadishSeedsLabel.setOpaque(true);
		container.add(RadishSeedsLabel);
		
		JLabel potionLabel = new JLabel();
		potionLabel.setText(""+PotionOfHp.name);
		potionLabel.setHorizontalAlignment(JLabel.CENTER);
		potionLabel.setBounds(20, 130, 100, 20);
		potionLabel.setBackground(Color.white);
		potionLabel.setOpaque(true);
		container.add(potionLabel);
		
		JLabel ItemPriceLabel = new JLabel();
		ItemPriceLabel.setText("▽ 구입가격 ▽ ");
		ItemPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		ItemPriceLabel.setBounds(120, 10, 100, 20);
		ItemPriceLabel.setBackground(Color.white);
		ItemPriceLabel.setOpaque(true);
		container.add(ItemPriceLabel);
		
		JLabel LettuceSeedsPriceLabel = new JLabel();
		LettuceSeedsPriceLabel.setText(""+LettuceSeeds.price);
		LettuceSeedsPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		LettuceSeedsPriceLabel.setBounds(120, 40, 100, 20);
		LettuceSeedsPriceLabel.setBackground(Color.white);
		LettuceSeedsPriceLabel.setOpaque(true);
		container.add(LettuceSeedsPriceLabel);
		
		JLabel CarrotSeedsPriceLabel = new JLabel();
		CarrotSeedsPriceLabel.setText(""+CarrotSeeds.price);
		CarrotSeedsPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		CarrotSeedsPriceLabel.setBounds(120, 70, 100, 20);
		CarrotSeedsPriceLabel.setBackground(Color.white);
		CarrotSeedsPriceLabel.setOpaque(true);
		container.add(CarrotSeedsPriceLabel);
		//System.out.println(FarmGame.money);
		
		JLabel RadishSeedsPriceLabel = new JLabel();
		RadishSeedsPriceLabel.setText(""+RadishSeeds.price);
		RadishSeedsPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		RadishSeedsPriceLabel.setBounds(120, 100, 100, 20);
		RadishSeedsPriceLabel.setBackground(Color.white);
		RadishSeedsPriceLabel.setOpaque(true);
		container.add(RadishSeedsPriceLabel);
		
		JLabel potionPriceLabel = new JLabel();
		potionPriceLabel.setText(""+PotionOfHp.price);
		potionPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		potionPriceLabel.setBounds(120, 130, 100, 20);
		potionPriceLabel.setBackground(Color.white);
		potionPriceLabel.setOpaque(true);
		container.add(potionPriceLabel);
		
		JLabel ItemCountLabel = new JLabel();
		ItemCountLabel.setText("▽ 구입갯수 ▽ ");
		ItemCountLabel.setHorizontalAlignment(JLabel.CENTER);
		ItemCountLabel.setBounds(220, 10, 100, 20);
		ItemCountLabel.setBackground(Color.white);
		ItemCountLabel.setOpaque(true);
		container.add(ItemCountLabel);
		
		JTextField LettuceCountTextField = new JTextField();
		LettuceCountTextField.setText("0");
		LettuceCountTextField.setBounds(250, 40, 30, 20);
		LettuceCountTextField.setColumns(1);
		container.add(LettuceCountTextField);
		
		JTextField CarrotCountTextField = new JTextField();
		CarrotCountTextField.setText("0");
		CarrotCountTextField.setBounds(250, 70, 30, 20);
		CarrotCountTextField.setColumns(1);
		container.add(CarrotCountTextField);
		
		JTextField RadishCountTextField = new JTextField();
		RadishCountTextField.setText("0");
		RadishCountTextField.setBounds(250, 100, 30, 20);
		RadishCountTextField.setColumns(1);
		container.add(RadishCountTextField);
		
		JTextField PotionOfHpCountTextField = new JTextField();
		PotionOfHpCountTextField.setText("0");
		PotionOfHpCountTextField.setBounds(250, 130, 30, 20);
		PotionOfHpCountTextField.setColumns(1);
		container.add(PotionOfHpCountTextField);
		
		int lettuceCount = Integer.parseInt(LettuceCountTextField.getText());
		int carrotCount = Integer.parseInt(CarrotCountTextField.getText());
		int radishCount = Integer.parseInt(RadishCountTextField.getText());
		int potionOfHpCount = Integer.parseInt(PotionOfHpCountTextField.getText());
		
		//System.out.println("입력갯수"+lettuceCount);
		//System.out.println("적용 전 개수"+LettuceSeeds.count);
		
		LettuceSeeds.count = LettuceSeeds.count+lettuceCount;
		CarrotSeeds.count = CarrotSeeds.count+carrotCount;
		RadishSeeds.count = RadishSeeds.count+radishCount;
		PotionOfHp.count = PotionOfHp.count+potionOfHpCount;
		
		//System.out.println("적용 후 개수"+LettuceSeeds.count);

		setTitle("마켓");
		setSize(350, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
	}
}
