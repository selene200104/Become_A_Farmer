package become_a_farmer_exclude_Image;

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
	
	// 가격 초기값
	static int shoppingPrice = 0;
	
	// 구입 개수
	static int buyLettuceSeedsCount = 0;
	static int buyCarrotSeedsCount = 0;
	static int buyRadishSeedsCount = 0;
	static int buyPotionOfHpCount = 0;
	static int buyFertilizeCount = 0;

	//TODO 위치 값 추가하기

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
		
		//구입 물품을 표시하는 라벨
		JLabel itemLabel = new JLabel();
		itemLabel.setText("▽ 구입물품 ▽ ");
		itemLabel.setHorizontalAlignment(JLabel.CENTER);
		itemLabel.setBounds(20, 10, 100, 20);
		itemLabel.setBackground(Color.white);
		itemLabel.setOpaque(true);
		container.add(itemLabel);
		
		//구입 가격 표시하는 라벨
		JLabel itemPriceLabel = new JLabel();
		itemPriceLabel.setText("▽ 구입가격 ▽ ");
		itemPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		itemPriceLabel.setBounds(120, 10, 100, 20);
		itemPriceLabel.setBackground(Color.white);
		itemPriceLabel.setOpaque(true);
		container.add(itemPriceLabel);
		
		//아이템 구입 개수를 표시하는 라벨
		JLabel itemCountLabel = new JLabel();
		itemCountLabel.setText("▽ 구입갯수 ▽ ");
		itemCountLabel.setHorizontalAlignment(JLabel.CENTER);
		itemCountLabel.setBounds(220, 10, 100, 20);
		itemCountLabel.setBackground(Color.white);
		itemCountLabel.setOpaque(true);
		container.add(itemCountLabel);
		
		//총 구입금액을 표시하는 라벨
		final JLabel shoppingPriceLabel = new JLabel();
    	shoppingPriceLabel.setText("총 금액은 : "+shoppingPrice+" 원 입니다.");
		shoppingPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		shoppingPriceLabel.setBounds(20, 200, 300, 20);
		shoppingPriceLabel.setBackground(Color.white);
		shoppingPriceLabel.setOpaque(true);
		container.add(shoppingPriceLabel);
		
		//------------------------------------------------------------------//
		
		/* 상추 씨앗 구입 (이름 / 가격 / -버튼 / 구입개수 / +버튼) */
		JLabel lettuceSeedsLabel = new JLabel();
		lettuceSeedsLabel.setText(""+Lettuce.seedsName);
		lettuceSeedsLabel.setHorizontalAlignment(JLabel.CENTER);
		lettuceSeedsLabel.setBounds(20, 40, 100, 20);
		lettuceSeedsLabel.setBackground(Color.white);
		lettuceSeedsLabel.setOpaque(true);
		container.add(lettuceSeedsLabel);
		
		JLabel lettuceSeedsPriceLabel = new JLabel();
		lettuceSeedsPriceLabel.setText(""+Lettuce.seedsPrice);
		lettuceSeedsPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		lettuceSeedsPriceLabel.setBounds(120, 40, 100, 20);
		lettuceSeedsPriceLabel.setBackground(Color.white);
		lettuceSeedsPriceLabel.setOpaque(true);
		container.add(lettuceSeedsPriceLabel);
		
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
		
		//상추 씨앗 마이너스 버튼을 눌렀을 때
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
		
		//상추 씨앗 플러스 버튼 눌렀을 때
		lettuceSeedsCountPlus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyLettuceSeedsCount++;
            	
            	//값이 10보다 커지면 더이상 커질 수 없다.
            	if(buyLettuceSeedsCount > 10 ) {
            		buyLettuceSeedsCount = 10;
            	}
            	
            	//쇼핑한 값을 계산해주는 메소드
            	shoppingPrice();
            	shoppingPriceLabel.setText("총 금액은 : "+shoppingPrice+" 원 입니다.");
            	
            	buyLettuceSeedsCountLabel.setText(buyLettuceSeedsCount+"");
                System.out.println(buyLettuceSeedsCount);
            }
        });
		
		//------------------------------------------------------------------//
		
		/* 당근씨앗 구입 (이름 / 가격 / -버튼 / 구입개수 / +버튼) */				
		JLabel carrotSeedsLabel = new JLabel();
		carrotSeedsLabel.setText(""+Carrot.seedsName);
		carrotSeedsLabel.setHorizontalAlignment(JLabel.CENTER);
		carrotSeedsLabel.setBounds(20, 70, 100, 20);
		carrotSeedsLabel.setBackground(Color.white);
		carrotSeedsLabel.setOpaque(true);
		container.add(carrotSeedsLabel);
		
		JLabel carrotSeedsPriceLabel = new JLabel();
		carrotSeedsPriceLabel.setText(""+Carrot.seedsPrice);
		carrotSeedsPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		carrotSeedsPriceLabel.setBounds(120, 70, 100, 20);
		carrotSeedsPriceLabel.setBackground(Color.white);
		carrotSeedsPriceLabel.setOpaque(true);
		container.add(carrotSeedsPriceLabel);
		
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
		
		//당근 씨앗 마이너스 버튼을 눌렀을 때
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
		
		//당근 씨앗 플러스 버튼을 눌렀을 때
		carrotSeedsCountPlus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyCarrotSeedsCount++;
            	
            	//값이 10보다 커지면 더이상 커질 수 없다.
            	if(buyCarrotSeedsCount > 10 ) {
            		buyCarrotSeedsCount = 10;
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
		JLabel radishSeedsLabel = new JLabel();
		radishSeedsLabel.setText(""+Radish.seedsName);
		radishSeedsLabel.setHorizontalAlignment(JLabel.CENTER);
		radishSeedsLabel.setBounds(20, 100, 100, 20);
		radishSeedsLabel.setBackground(Color.white);
		radishSeedsLabel.setOpaque(true);
		container.add(radishSeedsLabel);
		
		JLabel radishSeedsPriceLabel = new JLabel();
		radishSeedsPriceLabel.setText(""+Radish.seedsPrice);
		radishSeedsPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		radishSeedsPriceLabel.setBounds(120, 100, 100, 20);
		radishSeedsPriceLabel.setBackground(Color.white);
		radishSeedsPriceLabel.setOpaque(true);
		container.add(radishSeedsPriceLabel);
		
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
		
		//무 씨앗 마이너스 버튼을 눌렀을 때
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
		
		//무 씨앗 플러스 버튼을 눌렀을 때
		radishSeedsCountPlus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyRadishSeedsCount++;
            	
            	//값이 10보다 커지면 더이상 커질 수 없다.
            	if(buyRadishSeedsCount > 10 ) {
            		buyRadishSeedsCount = 10;
            	}
            	
            	//쇼핑한 모든 값을 합쳐주는 메소드
            	shoppingPrice();
            	shoppingPriceLabel.setText("총 금액은 : "+shoppingPrice+" 원 입니다.");
            	
            	buyRadishSeedsCountLabel.setText(buyRadishSeedsCount+"");
                System.out.println(buyRadishSeedsCount);
            }
        });
		
		
		//------------------------------------------------------------------//
		
		/*거름 구입 (이름 / 가격 / -버튼 / 구입 개수 / +버튼)*/
		JLabel fertilizeLabel = new JLabel();
		fertilizeLabel.setText(""+Fertilize.name);
		fertilizeLabel.setHorizontalAlignment(JLabel.CENTER);
		fertilizeLabel.setBounds(20, 130, 100, 20);
		fertilizeLabel.setBackground(Color.white);
		fertilizeLabel.setOpaque(true);
		container.add(fertilizeLabel);
		
		JLabel fertilizePriceLabel = new JLabel();
		fertilizePriceLabel.setText(""+Fertilize.price);
		fertilizePriceLabel.setHorizontalAlignment(JLabel.CENTER);
		fertilizePriceLabel.setBounds(120, 130, 100, 20);
		fertilizePriceLabel.setBackground(Color.white);
		fertilizePriceLabel.setOpaque(true);
		container.add(fertilizePriceLabel);
		
		JButton fertilizeCountMinus = new JButton("-");
		fertilizeCountMinus.setBounds(200, 130, 50, 20);
		fertilizeCountMinus.setBorderPainted(false);
		fertilizeCountMinus.setBackground(Color.white);
		fertilizeCountMinus.setOpaque(true);
		container.add(fertilizeCountMinus);
		
		final JLabel buyFertilizeCountLabel = new JLabel(buyFertilizeCount+"");
		buyFertilizeCountLabel.setHorizontalAlignment(JLabel.CENTER);
		buyFertilizeCountLabel.setBounds(240, 130, 50, 20);
		buyFertilizeCountLabel.setBackground(Color.white);
		buyFertilizeCountLabel.setOpaque(true);
		container.add(buyFertilizeCountLabel);
		
		JButton fertilizeCountPlus = new JButton("+");
		fertilizeCountPlus.setBounds(280, 130, 50, 20);
		fertilizeCountPlus.setBorderPainted(false);
		fertilizeCountPlus.setBackground(Color.white);
		fertilizeCountPlus.setOpaque(true);
		container.add(fertilizeCountPlus);
		
		//거름 마이너스 버튼을 눌렀을 때
		fertilizeCountMinus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyFertilizeCount--;
            	
            	if(buyFertilizeCount < 0 ) {
            		buyFertilizeCount = 0;
            	}
            	
            	//쇼핑한 값을 계산해주는 메소드
            	shoppingPrice();
            	shoppingPriceLabel.setText("총 금액은 : "+shoppingPrice+" 원 입니다.");
            	
            	buyFertilizeCountLabel.setText(buyFertilizeCount+"");
                System.out.println(buyFertilizeCount);
            }
        });
		
		//거름 마이너스 버튼을 눌렀을 때
		fertilizeCountPlus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyFertilizeCount++;
            	
            	//값이 10보다 커지면 더이상 커질 수 없다.
            	if(buyFertilizeCount > 10 ) {
            		buyFertilizeCount = 10;
            	}
            	
            	//쇼핑한 모든 값을 합쳐주는 메소드
            	shoppingPrice();
            	shoppingPriceLabel.setText("총 금액은 : "+shoppingPrice+" 원 입니다.");
            	
            	buyFertilizeCountLabel.setText(buyFertilizeCount+"");
                System.out.println(buyFertilizeCount);
            }
        });
		
		//------------------------------------------------------------------//
		
		/*체력포션 구입 (이름 / 가격 / -버튼 / 개수 / +버튼)*/		
		JLabel potionLabel = new JLabel();
		potionLabel.setText(""+PotionOfHp.name);
		potionLabel.setHorizontalAlignment(JLabel.CENTER);
		potionLabel.setBounds(20, 160, 100, 20);
		potionLabel.setBackground(Color.white);
		potionLabel.setOpaque(true);
		container.add(potionLabel);
		
		JLabel potionPriceLabel = new JLabel();
		potionPriceLabel.setText(""+PotionOfHp.price);
		potionPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		potionPriceLabel.setBounds(120, 160, 100, 20);
		potionPriceLabel.setBackground(Color.white);
		potionPriceLabel.setOpaque(true);
		container.add(potionPriceLabel);

		JButton potionOfHpCountMinus = new JButton("-");
		potionOfHpCountMinus.setBounds(200, 160, 50, 20);
		potionOfHpCountMinus.setBorderPainted(false);
		potionOfHpCountMinus.setBackground(Color.white);
		potionOfHpCountMinus.setOpaque(true);
		container.add(potionOfHpCountMinus);
		
		final JLabel buyPotionOfHpCountLabel = new JLabel(buyPotionOfHpCount+"");
		buyPotionOfHpCountLabel.setHorizontalAlignment(JLabel.CENTER);
		buyPotionOfHpCountLabel.setBounds(240, 160, 50, 20);
		buyPotionOfHpCountLabel.setBackground(Color.white);
		buyPotionOfHpCountLabel.setOpaque(true);
		container.add(buyPotionOfHpCountLabel);
		
		JButton potionOfHpCountPlus = new JButton("+");
		potionOfHpCountPlus.setBounds(280, 160, 50, 20);
		potionOfHpCountPlus.setBorderPainted(false);
		potionOfHpCountPlus.setBackground(Color.white);
		potionOfHpCountPlus.setOpaque(true);
		//potionOfHpCountPlus.addActionListener(listener);
		container.add(potionOfHpCountPlus);
	
		//포션 마이너스 버튼을 눌렀을 때
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
		
		//포션 플러스 버튼을 눌렀을 때
		potionOfHpCountPlus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyPotionOfHpCount++;
            	
            	//값이 10보다 커지면 더이상 커질 수 없다.
            	if(buyPotionOfHpCount > 10 ) {
            		buyPotionOfHpCount = 10;
            	}

            	//쇼핑한 값을 계산해주는 메소드
            	shoppingPrice();
            	shoppingPriceLabel.setText("총 금액은 : "+shoppingPrice+" 원 입니다.");
            	
            	buyPotionOfHpCountLabel.setText(buyPotionOfHpCount+"");
                System.out.println(buyPotionOfHpCount);
            }
        });
		
		//------------------------------------------------------------------//
		
		//구입하기 버튼
		JButton buyButton = new JButton("구입하기");
		buyButton.setBounds(100, 230, 150, 20);
		buyButton.setBorderPainted(false);
		buyButton.setOpaque(true);
		container.add(buyButton);
		
		//구매하기 버튼을 눌렀을 때
		buyButton.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            
            
			JLabel shoppingMoneyLabel = new JLabel();
			shoppingMoneyLabel.setBounds(400, 0, 200, 50);
			shoppingMoneyLabel.setBackground(Color.pink);
			//쇼핑 스레드 실행
			Shopping shopping = new Shopping(shoppingMoneyLabel);
            shopping.start();
            shoppingMoneyLabel.setOpaque(true);
			FarmGame.headerPanel.add(shoppingMoneyLabel);
			System.out.println(shoppingMoneyLabel);
            
			//각각 가지는 값에서 산 갯수만큼 추가됌
			Lettuce.seedsAmount += buyLettuceSeedsCount;
			Carrot.seedsAmount += buyCarrotSeedsCount;
			Radish.seedsAmount += buyRadishSeedsCount;
			Fertilize.amount += buyFertilizeCount;
			PotionOfHp.amount += buyPotionOfHpCount;
			
			//계산버튼을 누르면 모든 값이 0으로 초기화 된다.
			buyLettuceSeedsCount = 0;
			buyCarrotSeedsCount = 0;
			buyRadishSeedsCount = 0;
			buyPotionOfHpCount = 0;
			buyFertilizeCount = 0;
			shoppingPrice = 0;
			
			buyLettuceSeedsCountLabel.setText(""+buyLettuceSeedsCount);
			buyCarrotSeedsCountLabel.setText(""+buyCarrotSeedsCount);
			buyRadishSeedsCountLabel.setText(""+buyRadishSeedsCount);
			buyFertilizeCountLabel.setText(""+buyFertilizeCount);
			buyPotionOfHpCountLabel.setText(""+buyPotionOfHpCount);
			shoppingPriceLabel.setText(""+shoppingPrice);

			dispose();
            }
        });
	}
	
	//쇼핑한 값을 계산해주는 메소드
	void shoppingPrice(){
		shoppingPrice = buyLettuceSeedsCount*Lettuce.seedsPrice
				+buyCarrotSeedsCount*Carrot.seedsPrice
				+buyRadishSeedsCount*Radish.seedsPrice
				+buyPotionOfHpCount*PotionOfHp.price
				+buyFertilizeCount*Fertilize.price;
	}

	
}
