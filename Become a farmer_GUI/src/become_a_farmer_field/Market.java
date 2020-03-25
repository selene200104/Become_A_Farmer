package become_a_farmer_field;

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
	
	// ���� �ʱⰪ
	static int shoppingPrice = 0;
	
	// ���� ����
	static int buyLettuceSeedsCount = 0;
	static int buyCarrotSeedsCount = 0;
	static int buyRadishSeedsCount = 0;
	static int buyPotionOfHpCount = 0;
	static int buyFertilizeCount = 0;

	//TODO ��ġ �� �߰��ϱ�

	Market(){
		setTitle("����");
		setSize(350, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
		
		Container container = getContentPane();
		container.setLayout(null);
		container.setBackground(Color.WHITE);	
		
		JLabel ItemLabel = new JLabel();
		ItemLabel.setText("�� ���Թ�ǰ �� ");
		ItemLabel.setHorizontalAlignment(JLabel.CENTER);
		ItemLabel.setBounds(20, 10, 100, 20);
		ItemLabel.setBackground(Color.white);
		ItemLabel.setOpaque(true);
		container.add(ItemLabel);
		
		JLabel ItemPriceLabel = new JLabel();
		ItemPriceLabel.setText("�� ���԰��� �� ");
		ItemPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		ItemPriceLabel.setBounds(120, 10, 100, 20);
		ItemPriceLabel.setBackground(Color.white);
		ItemPriceLabel.setOpaque(true);
		container.add(ItemPriceLabel);
		
		JLabel ItemCountLabel = new JLabel();
		ItemCountLabel.setText("�� ���԰��� �� ");
		ItemCountLabel.setHorizontalAlignment(JLabel.CENTER);
		ItemCountLabel.setBounds(220, 10, 100, 20);
		ItemCountLabel.setBackground(Color.white);
		ItemCountLabel.setOpaque(true);
		container.add(ItemCountLabel);
		
		final JLabel shoppingPriceLabel = new JLabel();
    	shoppingPriceLabel.setText("�� �ݾ��� : "+shoppingPrice+" �� �Դϴ�.");
		shoppingPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		shoppingPriceLabel.setBounds(20, 200, 300, 20);
		shoppingPriceLabel.setBackground(Color.white);
		shoppingPriceLabel.setOpaque(true);
		container.add(shoppingPriceLabel);
		
		//------------------------------------------------------------------//
		
		/* ���� ���� ���� (�̸� / ���� / -��ư / ���� / +��ư) */
		JLabel LettuceSeedsLabel = new JLabel();
		LettuceSeedsLabel.setText(""+Lettuce.seedsName);
		LettuceSeedsLabel.setHorizontalAlignment(JLabel.CENTER);
		LettuceSeedsLabel.setBounds(20, 40, 100, 20);
		LettuceSeedsLabel.setBackground(Color.white);
		LettuceSeedsLabel.setOpaque(true);
		container.add(LettuceSeedsLabel);
		
		JLabel LettuceSeedsPriceLabel = new JLabel();
		LettuceSeedsPriceLabel.setText(""+Lettuce.seedsPrice);
		LettuceSeedsPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		LettuceSeedsPriceLabel.setBounds(120, 40, 100, 20);
		LettuceSeedsPriceLabel.setBackground(Color.white);
		LettuceSeedsPriceLabel.setOpaque(true);
		container.add(LettuceSeedsPriceLabel);
		
		JButton lettuceSeedsCountMinus = new JButton("-");
		lettuceSeedsCountMinus.setBounds(200, 40, 50, 20);
		//JButton�� �ܰ��� ���ֱ�
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
            	
            	//���� 0���� �۾����� ���̻� �۾��� �� ����.
            	if(buyLettuceSeedsCount < 0 ) {
            		buyLettuceSeedsCount = 0;
            	}
            	
            	//������ ���� ������ִ� �޼ҵ�
            	shoppingPrice();
            	shoppingPriceLabel.setText("�� �ݾ��� : "+shoppingPrice+" �� �Դϴ�.");
            	
            	buyLettuceSeedsCountLabel.setText(buyLettuceSeedsCount+"");
                System.out.println(buyLettuceSeedsCount);
            }
        });
		
		lettuceSeedsCountPlus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyLettuceSeedsCount++;
            	
            	//���� 10���� Ŀ���� ���̻� Ŀ�� �� ����.
            	if(buyLettuceSeedsCount > 10 ) {
            		buyLettuceSeedsCount = 10;
            	}
            	
            	//������ ���� ������ִ� �޼ҵ�
            	shoppingPrice();
            	shoppingPriceLabel.setText("�� �ݾ��� : "+shoppingPrice+" �� �Դϴ�.");
            	
            	buyLettuceSeedsCountLabel.setText(buyLettuceSeedsCount+"");
                System.out.println(buyLettuceSeedsCount);
            }
        });
		
		//------------------------------------------------------------------//
		
		/* ��پ��� ���� (�̸� / ���� / -��ư / ���� / +��ư) */				
		JLabel CarrotSeedsLabel = new JLabel();
		CarrotSeedsLabel.setText(""+Carrot.seedsName);
		CarrotSeedsLabel.setHorizontalAlignment(JLabel.CENTER);
		CarrotSeedsLabel.setBounds(20, 70, 100, 20);
		CarrotSeedsLabel.setBackground(Color.white);
		CarrotSeedsLabel.setOpaque(true);
		container.add(CarrotSeedsLabel);
		
		JLabel CarrotSeedsPriceLabel = new JLabel();
		CarrotSeedsPriceLabel.setText(""+Carrot.seedsPrice);
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
            	
            	//���� 0���� �۾����� ���̻� �۾��� �� ����.
            	if(buyCarrotSeedsCount < 0 ) {
            		buyCarrotSeedsCount = 0;
            	}
            	
            	//������ ���� ������ִ� �޼ҵ�
            	shoppingPrice();
            	shoppingPriceLabel.setText("�� �ݾ��� : "+shoppingPrice+" �� �Դϴ�.");
            	
            	buyCarrotSeedsCountLabel.setText(buyCarrotSeedsCount+"");
                System.out.println(buyCarrotSeedsCount);
            }
        });
		
		carrotSeedsCountPlus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyCarrotSeedsCount++;
            	
            	//���� 10���� Ŀ���� ���̻� Ŀ�� �� ����.
            	if(buyCarrotSeedsCount > 10 ) {
            		buyCarrotSeedsCount = 10;
            	}
            	
            	//������ ���� ������ִ� �޼ҵ�
            	shoppingPrice();
            	shoppingPriceLabel.setText("�� �ݾ��� : "+shoppingPrice+" �� �Դϴ�.");
            	
            	buyCarrotSeedsCountLabel.setText(buyCarrotSeedsCount+"");
                System.out.println(buyCarrotSeedsCount);
            }
        });
		
		//------------------------------------------------------------------//
		
		/*������ ���� (�̸� / ���� / -��ư / ���� / +��ư)*/
		JLabel RadishSeedsLabel = new JLabel();
		RadishSeedsLabel.setText(""+Radish.seedsName);
		RadishSeedsLabel.setHorizontalAlignment(JLabel.CENTER);
		RadishSeedsLabel.setBounds(20, 100, 100, 20);
		RadishSeedsLabel.setBackground(Color.white);
		RadishSeedsLabel.setOpaque(true);
		container.add(RadishSeedsLabel);
		
		JLabel RadishSeedsPriceLabel = new JLabel();
		RadishSeedsPriceLabel.setText(""+Radish.seedsPrice);
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
            	
            	//������ ���� ������ִ� �޼ҵ�
            	shoppingPrice();
            	shoppingPriceLabel.setText("�� �ݾ��� : "+shoppingPrice+" �� �Դϴ�.");
            	
            	buyRadishSeedsCountLabel.setText(buyRadishSeedsCount+"");
                System.out.println(buyRadishSeedsCount);
            }
        });
		
		radishSeedsCountPlus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyRadishSeedsCount++;
            	
            	//���� 10���� Ŀ���� ���̻� Ŀ�� �� ����.
            	if(buyRadishSeedsCount > 10 ) {
            		buyRadishSeedsCount = 10;
            	}
            	
            	//������ ��� ���� �����ִ� �޼ҵ�
            	shoppingPrice();
            	shoppingPriceLabel.setText("�� �ݾ��� : "+shoppingPrice+" �� �Դϴ�.");
            	
            	buyRadishSeedsCountLabel.setText(buyRadishSeedsCount+"");
                System.out.println(buyRadishSeedsCount);
            }
        });
		
		
		//------------------------------------------------------------------//
		
		/*�Ÿ� ���� (�̸� / ���� / -��ư / ���� / +��ư)*/
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
		
		fertilizeCountMinus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyFertilizeCount--;
            	
            	if(buyFertilizeCount < 0 ) {
            		buyFertilizeCount = 0;
            	}
            	
            	//������ ���� ������ִ� �޼ҵ�
            	shoppingPrice();
            	shoppingPriceLabel.setText("�� �ݾ��� : "+shoppingPrice+" �� �Դϴ�.");
            	
            	buyFertilizeCountLabel.setText(buyFertilizeCount+"");
                System.out.println(buyFertilizeCount);
            }
        });
		
		fertilizeCountPlus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyFertilizeCount++;
            	
            	//���� 10���� Ŀ���� ���̻� Ŀ�� �� ����.
            	if(buyFertilizeCount > 10 ) {
            		buyFertilizeCount = 10;
            	}
            	
            	//������ ��� ���� �����ִ� �޼ҵ�
            	shoppingPrice();
            	shoppingPriceLabel.setText("�� �ݾ��� : "+shoppingPrice+" �� �Դϴ�.");
            	
            	buyFertilizeCountLabel.setText(buyFertilizeCount+"");
                System.out.println(buyFertilizeCount);
            }
        });
		
		//------------------------------------------------------------------//
		
		/*ü������ ���� (�̸� / ���� / -��ư / ���� / +��ư)*/		
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
	
		potionOfHpCountMinus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                //intCount = intCount + 1;
            	buyPotionOfHpCount--;
            	
            	if(buyPotionOfHpCount < 0 ) {
            		buyPotionOfHpCount = 0;
            	}
            	
            	//������ ���� ������ִ� �޼ҵ�
            	shoppingPrice();
            	shoppingPriceLabel.setText("�� �ݾ��� : "+shoppingPrice+" �� �Դϴ�.");
            	
            	buyPotionOfHpCountLabel.setText(buyPotionOfHpCount+"");
                System.out.println(buyPotionOfHpCount);
            }
        });
		
		potionOfHpCountPlus.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	buyPotionOfHpCount++;
            	
            	//���� 10���� Ŀ���� ���̻� Ŀ�� �� ����.
            	if(buyPotionOfHpCount > 10 ) {
            		buyPotionOfHpCount = 10;
            	}

            	//������ ���� ������ִ� �޼ҵ�
            	shoppingPrice();
            	shoppingPriceLabel.setText("�� �ݾ��� : "+shoppingPrice+" �� �Դϴ�.");
            	
            	buyPotionOfHpCountLabel.setText(buyPotionOfHpCount+"");
                System.out.println(buyPotionOfHpCount);
            }
        });
		
		//------------------------------------------------------------------//
		
		JButton buyButton = new JButton("�����ϱ�");
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
			
			Lettuce.seedsAmount += buyLettuceSeedsCount;
			Carrot.seedsAmount += buyCarrotSeedsCount;
			Radish.seedsAmount += buyRadishSeedsCount;
			Fertilize.amount += buyFertilizeCount;
			PotionOfHp.amount += buyPotionOfHpCount;
			
			//����ư�� ������ ��� ���� 0���� �ʱ�ȭ �ȴ�.
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
	
	//������ ���� ������ִ� �޼ҵ�
	void shoppingPrice(){
		shoppingPrice = buyLettuceSeedsCount*Lettuce.seedsPrice
				+buyCarrotSeedsCount*Carrot.seedsPrice
				+buyRadishSeedsCount*Radish.seedsPrice
				+buyPotionOfHpCount*PotionOfHp.price
				+buyFertilizeCount*Fertilize.price;
	}

	
}
