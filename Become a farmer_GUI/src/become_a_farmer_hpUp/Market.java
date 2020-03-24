package become_a_farmer_hpUp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Market extends JFrame{

	JPanel MarketPanel = new JPanel();
	
	// 초기값
	static int shoppingPrice = 0;
	static int buyLettuceSeedsCount = 0;
	static int buyCarrotSeedsCount = 0;
	static int buyRadishSeedsCount = 0;
	static int buyPotionOfHpCount = 0;
	
	Market(){
		setTitle("마켓");
		setSize(350, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
		
		Container container = getContentPane();
		container.setLayout(null);
		container.setBackground(Color.WHITE);	
		
		JLabel ItemLabel = new JLabel();
		ItemLabel.setText("▽ 구입물품 ▽ ");
		ItemLabel.setHorizontalAlignment(JLabel.CENTER);
		ItemLabel.setBounds(20, 10, 100, 20);
		ItemLabel.setBackground(Color.white);
		ItemLabel.setOpaque(true);
		container.add(ItemLabel);
		
		JLabel ItemPriceLabel = new JLabel();
		ItemPriceLabel.setText("▽ 구입가격 ▽ ");
		ItemPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		ItemPriceLabel.setBounds(120, 10, 100, 20);
		ItemPriceLabel.setBackground(Color.white);
		ItemPriceLabel.setOpaque(true);
		container.add(ItemPriceLabel);
		
		JLabel ItemCountLabel = new JLabel();
		ItemCountLabel.setText("▽ 구입갯수 ▽ ");
		ItemCountLabel.setHorizontalAlignment(JLabel.CENTER);
		ItemCountLabel.setBounds(220, 10, 100, 20);
		ItemCountLabel.setBackground(Color.white);
		ItemCountLabel.setOpaque(true);
		container.add(ItemCountLabel);
		
		final JLabel shoppingPriceLabel = new JLabel();
    	shoppingPriceLabel.setText("총 금액은 : "+shoppingPrice+" 원 입니다.");
		shoppingPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		shoppingPriceLabel.setBounds(20, 200, 300, 20);
		shoppingPriceLabel.setBackground(Color.white);
		shoppingPriceLabel.setOpaque(true);
		container.add(shoppingPriceLabel);
		
		//------------------------------------------------------------------//
		
		/* 상추 씨앗 구입 (이름 / 가격 / -버튼 / 개수 / +버튼) */
		JLabel LettuceSeedsLabel = new JLabel();
		LettuceSeedsLabel.setText(""+LettuceSeeds.name);
		LettuceSeedsLabel.setHorizontalAlignment(JLabel.CENTER);
		LettuceSeedsLabel.setBounds(20, 40, 100, 20);
		LettuceSeedsLabel.setBackground(Color.white);
		LettuceSeedsLabel.setOpaque(true);
		container.add(LettuceSeedsLabel);
		
		JLabel LettuceSeedsPriceLabel = new JLabel();
		LettuceSeedsPriceLabel.setText(""+LettuceSeeds.price);
		LettuceSeedsPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		LettuceSeedsPriceLabel.setBounds(120, 40, 100, 20);
		LettuceSeedsPriceLabel.setBackground(Color.white);
		LettuceSeedsPriceLabel.setOpaque(true);
		container.add(LettuceSeedsPriceLabel);
		
		JButton lettuceSeedsCountMinus = new JButton("-");
		lettuceSeedsCountMinus.setBounds(200, 40, 50, 20);
		//JButton의 외각선 없애기
		lettuceSeedsCountMinus.setBorderPainted(false);
		lettuceSeedsCountMinus.setBackground(Color.white);
		lettuceSeedsCountMinus.setOpaque(true);
		container.add(lettuceSeedsCountMinus);
		
		final JLabel buyLettuceSeedsCountLabel = new JLabel(buyLettuceSeedsCount+"");
		buyLettuceSeedsCountLabel.setHorizontalAlignment(JLabel.CENTER);
		buyLettuceSeedsCountLabel.setBounds(240, 40, 50, 20);
		buyLettuceSeedsCountLabel.setBackground(Color.white);
		buyLettuceSeedsCountLabel.setOpaque(true);
		container.add(buyLettuceSeedsCountLabel);
		
		JButton lettuceSeedsCountPlus = new JButton("+");
		lettuceSeedsCountPlus.setBounds(280, 40, 50, 20);
		lettuceSeedsCountPlus.setBorderPainted(false);
		lettuceSeedsCountPlus.setBackground(Color.white);
		lettuceSeedsCountPlus.setOpaque(true);
		container.add(lettuceSeedsCountPlus);
		
		lettuceSeedsCountMinus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyLettuceSeedsCount--;
            	
            	//값이 0보다 작아지면 더이상 작아질 수 없다.
            	if(buyLettuceSeedsCount < 0 ) {
            		buyLettuceSeedsCount = 0;
            	}
            	
            	//쇼핑한 값을 계산해주는 메소드
            	shoppingPrice();
            	shoppingPriceLabel.setText("총 금액은 : "+shoppingPrice+" 원 입니다.");
            	
            	buyLettuceSeedsCountLabel.setText(buyLettuceSeedsCount+"");
                System.out.println(buyLettuceSeedsCount);
            }
        });
		
		lettuceSeedsCountPlus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyLettuceSeedsCount++;
            	
            	//값이 5보다 커지면 더이상 작아질 수 없다.
            	if(buyLettuceSeedsCount > 5 ) {
            		buyLettuceSeedsCount = 5;
            	}
            	
            	//쇼핑한 값을 계산해주는 메소드
            	shoppingPrice();
            	shoppingPriceLabel.setText("총 금액은 : "+shoppingPrice+" 원 입니다.");
            	
            	buyLettuceSeedsCountLabel.setText(buyLettuceSeedsCount+"");
                System.out.println(buyLettuceSeedsCount);
            }
        });
		
		//------------------------------------------------------------------//
		
		/* 당근씨앗 구입 (이름 / 가격 / -버튼 / 개수 / +버튼) */				
		JLabel CarrotSeedsLabel = new JLabel();
		CarrotSeedsLabel.setText(""+CarrotSeeds.name);
		CarrotSeedsLabel.setHorizontalAlignment(JLabel.CENTER);
		CarrotSeedsLabel.setBounds(20, 70, 100, 20);
		CarrotSeedsLabel.setBackground(Color.white);
		CarrotSeedsLabel.setOpaque(true);
		container.add(CarrotSeedsLabel);
		
		JLabel CarrotSeedsPriceLabel = new JLabel();
		CarrotSeedsPriceLabel.setText(""+CarrotSeeds.price);
		CarrotSeedsPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		CarrotSeedsPriceLabel.setBounds(120, 70, 100, 20);
		CarrotSeedsPriceLabel.setBackground(Color.white);
		CarrotSeedsPriceLabel.setOpaque(true);
		container.add(CarrotSeedsPriceLabel);
		
		JButton carrotSeedsCountMinus = new JButton("-");
		carrotSeedsCountMinus.setBounds(200, 70, 50, 20);
		carrotSeedsCountMinus.setBorderPainted(false);
		carrotSeedsCountMinus.setBackground(Color.white);
		carrotSeedsCountMinus.setOpaque(true);
		container.add(carrotSeedsCountMinus);
		
		final JLabel buyCarrotSeedsCountLabel = new JLabel(buyCarrotSeedsCount+"");
		buyCarrotSeedsCountLabel.setHorizontalAlignment(JLabel.CENTER);
		buyCarrotSeedsCountLabel.setBounds(240, 70, 50, 20);
		buyCarrotSeedsCountLabel.setBackground(Color.white);
		buyCarrotSeedsCountLabel.setOpaque(true);
		container.add(buyCarrotSeedsCountLabel);
		
		JButton carrotSeedsCountPlus = new JButton("+");
		carrotSeedsCountPlus.setBounds(280, 70, 50, 20);
		carrotSeedsCountPlus.setBorderPainted(false);
		carrotSeedsCountPlus.setBackground(Color.white);
		carrotSeedsCountPlus.setOpaque(true);
		container.add(carrotSeedsCountPlus);		
		
		carrotSeedsCountMinus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyCarrotSeedsCount--;
            	
            	//값이 0보다 작아지면 더이상 작아질 수 없다.
            	if(buyCarrotSeedsCount < 0 ) {
            		buyCarrotSeedsCount = 0;
            	}
            	
            	//쇼핑한 값을 계산해주는 메소드
            	shoppingPrice();
            	shoppingPriceLabel.setText("총 금액은 : "+shoppingPrice+" 원 입니다.");
            	
            	buyCarrotSeedsCountLabel.setText(buyCarrotSeedsCount+"");
                System.out.println(buyCarrotSeedsCount);
            }
        });
		
		carrotSeedsCountPlus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyCarrotSeedsCount++;
            	
            	if(buyCarrotSeedsCount > 5 ) {
            		buyCarrotSeedsCount = 5;
            	}
            	
            	//쇼핑한 값을 계산해주는 메소드
            	shoppingPrice();
            	shoppingPriceLabel.setText("총 금액은 : "+shoppingPrice+" 원 입니다.");
            	
            	buyCarrotSeedsCountLabel.setText(buyCarrotSeedsCount+"");
                System.out.println(buyCarrotSeedsCount);
            }
        });
		
		//------------------------------------------------------------------//
		
		/*무씨앗 구입 (이름 / 가격 / -버튼 / 개수 / +버튼)*/
		JLabel RadishSeedsLabel = new JLabel();
		RadishSeedsLabel.setText(""+RadishSeeds.name);
		RadishSeedsLabel.setHorizontalAlignment(JLabel.CENTER);
		RadishSeedsLabel.setBounds(20, 100, 100, 20);
		RadishSeedsLabel.setBackground(Color.white);
		RadishSeedsLabel.setOpaque(true);
		container.add(RadishSeedsLabel);
		
		JLabel RadishSeedsPriceLabel = new JLabel();
		RadishSeedsPriceLabel.setText(""+RadishSeeds.price);
		RadishSeedsPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		RadishSeedsPriceLabel.setBounds(120, 100, 100, 20);
		RadishSeedsPriceLabel.setBackground(Color.white);
		RadishSeedsPriceLabel.setOpaque(true);
		container.add(RadishSeedsPriceLabel);
		
		JButton radishSeedsCountMinus = new JButton("-");
		radishSeedsCountMinus.setBounds(200, 100, 50, 20);
		radishSeedsCountMinus.setBorderPainted(false);
		radishSeedsCountMinus.setBackground(Color.white);
		radishSeedsCountMinus.setOpaque(true);
		container.add(radishSeedsCountMinus);
		
		final JLabel buyRadishSeedsCountLabel = new JLabel(buyRadishSeedsCount+"");
		buyRadishSeedsCountLabel.setHorizontalAlignment(JLabel.CENTER);
		buyRadishSeedsCountLabel.setBounds(240, 100, 50, 20);
		buyRadishSeedsCountLabel.setBackground(Color.white);
		buyRadishSeedsCountLabel.setOpaque(true);
		container.add(buyRadishSeedsCountLabel);
		
		JButton radishSeedsCountPlus = new JButton("+");
		radishSeedsCountPlus.setBounds(280, 100, 50, 20);
		radishSeedsCountPlus.setBorderPainted(false);
		radishSeedsCountPlus.setBackground(Color.white);
		radishSeedsCountPlus.setOpaque(true);
		container.add(radishSeedsCountPlus);
		
		radishSeedsCountMinus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyRadishSeedsCount--;
            	
            	if(buyRadishSeedsCount < 0 ) {
            		buyRadishSeedsCount = 0;
            	}
            	
            	//쇼핑한 값을 계산해주는 메소드
            	shoppingPrice();
            	shoppingPriceLabel.setText("총 금액은 : "+shoppingPrice+" 원 입니다.");
            	
            	buyRadishSeedsCountLabel.setText(buyRadishSeedsCount+"");
                System.out.println(buyRadishSeedsCount);
            }
        });
		
		radishSeedsCountPlus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyRadishSeedsCount++;
            	
            	if(buyRadishSeedsCount > 5 ) {
            		buyRadishSeedsCount = 5;
            	}
            	
            	//쇼핑한 모든 값을 합쳐주는 메소드
            	shoppingPrice();
            	shoppingPriceLabel.setText("총 금액은 : "+shoppingPrice+" 원 입니다.");
            	
            	buyRadishSeedsCountLabel.setText(buyRadishSeedsCount+"");
                System.out.println(buyRadishSeedsCount);
            }
        });
		
		//------------------------------------------------------------------//
		
		/*체력포션 구입 (이름 / 가격 / -버튼 / 개수 / +버튼)*/		
		JLabel potionLabel = new JLabel();
		potionLabel.setText(""+PotionOfHp.name);
		potionLabel.setHorizontalAlignment(JLabel.CENTER);
		potionLabel.setBounds(20, 130, 100, 20);
		potionLabel.setBackground(Color.white);
		potionLabel.setOpaque(true);
		container.add(potionLabel);
		
		JLabel potionPriceLabel = new JLabel();
		potionPriceLabel.setText(""+PotionOfHp.price);
		potionPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		potionPriceLabel.setBounds(120, 130, 100, 20);
		potionPriceLabel.setBackground(Color.white);
		potionPriceLabel.setOpaque(true);
		container.add(potionPriceLabel);

		JButton potionOfHpCountMinus = new JButton("-");
		potionOfHpCountMinus.setBounds(200, 130, 50, 20);
		potionOfHpCountMinus.setBorderPainted(false);
		potionOfHpCountMinus.setBackground(Color.white);
		potionOfHpCountMinus.setOpaque(true);
		container.add(potionOfHpCountMinus);
		
		final JLabel buyPotionOfHpCountLabel = new JLabel(buyPotionOfHpCount+"");
		buyPotionOfHpCountLabel.setHorizontalAlignment(JLabel.CENTER);
		buyPotionOfHpCountLabel.setBounds(240, 130, 50, 20);
		buyPotionOfHpCountLabel.setBackground(Color.white);
		buyPotionOfHpCountLabel.setOpaque(true);
		container.add(buyPotionOfHpCountLabel);
		
		JButton potionOfHpCountPlus = new JButton("+");
		potionOfHpCountPlus.setBounds(280, 130, 50, 20);
		potionOfHpCountPlus.setBorderPainted(false);
		potionOfHpCountPlus.setBackground(Color.white);
		potionOfHpCountPlus.setOpaque(true);
		//potionOfHpCountPlus.addActionListener(listener);
		container.add(potionOfHpCountPlus);
	
		potionOfHpCountMinus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                //intCount = intCount + 1;
            	buyPotionOfHpCount--;
            	
            	if(buyPotionOfHpCount < 0 ) {
            		buyPotionOfHpCount = 0;
            	}
            	
            	//쇼핑한 값을 계산해주는 메소드
            	shoppingPrice();
            	shoppingPriceLabel.setText("총 금액은 : "+shoppingPrice+" 원 입니다.");
            	
            	buyPotionOfHpCountLabel.setText(buyPotionOfHpCount+"");
                System.out.println(buyPotionOfHpCount);
            }
        });
		
		potionOfHpCountPlus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyPotionOfHpCount++;
            	
            	if(buyPotionOfHpCount > 5 ) {
            		buyPotionOfHpCount = 5;
            	}

            	//쇼핑한 값을 계산해주는 메소드
            	shoppingPrice();
            	shoppingPriceLabel.setText("총 금액은 : "+shoppingPrice+" 원 입니다.");
            	
            	buyPotionOfHpCountLabel.setText(buyPotionOfHpCount+"");
                System.out.println(buyPotionOfHpCount);
            }
        });
		
		//------------------------------------------------------------------//
		
		JButton buyButton = new JButton("구입하기");
		buyButton.setBounds(100, 230, 150, 20);
		buyButton.setBorderPainted(false);
		buyButton.setOpaque(true);
		container.add(buyButton);
		
		buyButton.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            
			JLabel shoppingMoneyLabel = new JLabel();
			shoppingMoneyLabel.setBounds(400, 0, 200, 50);
			shoppingMoneyLabel.setBackground(Color.pink);
			Shopping shopping = new Shopping(shoppingMoneyLabel);
            shopping.start();
            shoppingMoneyLabel.setOpaque(true);
			FarmGame.headerPanel.add(shoppingMoneyLabel);
			
			LettuceSeeds.count += buyLettuceSeedsCount;
			CarrotSeeds.count += buyCarrotSeedsCount;
			RadishSeeds.count += buyRadishSeedsCount;
			PotionOfHp.count += buyPotionOfHpCount;
			
			//계산버튼을 누르면 모든 값이 0으로 초기화 된다.
			buyLettuceSeedsCount = 0;
			buyCarrotSeedsCount = 0;
			buyRadishSeedsCount = 0;
			buyPotionOfHpCount = 0;
			shoppingPrice = 0;
			
			buyLettuceSeedsCountLabel.setText(""+buyLettuceSeedsCount);
			buyCarrotSeedsCountLabel.setText(""+buyCarrotSeedsCount);
			buyRadishSeedsCountLabel.setText(""+buyRadishSeedsCount);
			buyPotionOfHpCountLabel.setText(""+buyPotionOfHpCount);
			shoppingPriceLabel.setText(""+shoppingPrice);

            }
        });
	}
	
	//쇼핑한 값을 계산해주는 메소드
	void shoppingPrice(){
		shoppingPrice = buyLettuceSeedsCount*LettuceSeeds.price
				+buyCarrotSeedsCount*CarrotSeeds.price
				+buyRadishSeedsCount*RadishSeeds.price
				+buyPotionOfHpCount*PotionOfHp.price;
	}

}
