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
		
		//���� ��ǰ�� ǥ���ϴ� ��
		JLabel itemLabel = new JLabel();
		itemLabel.setText("�� ���Թ�ǰ �� ");
		itemLabel.setHorizontalAlignment(JLabel.CENTER);
		itemLabel.setBounds(20, 10, 100, 20);
		itemLabel.setBackground(Color.white);
		itemLabel.setOpaque(true);
		container.add(itemLabel);
		
		//���� ���� ǥ���ϴ� ��
		JLabel itemPriceLabel = new JLabel();
		itemPriceLabel.setText("�� ���԰��� �� ");
		itemPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		itemPriceLabel.setBounds(120, 10, 100, 20);
		itemPriceLabel.setBackground(Color.white);
		itemPriceLabel.setOpaque(true);
		container.add(itemPriceLabel);
		
		//������ ���� ������ ǥ���ϴ� ��
		JLabel itemCountLabel = new JLabel();
		itemCountLabel.setText("�� ���԰��� �� ");
		itemCountLabel.setHorizontalAlignment(JLabel.CENTER);
		itemCountLabel.setBounds(220, 10, 100, 20);
		itemCountLabel.setBackground(Color.white);
		itemCountLabel.setOpaque(true);
		container.add(itemCountLabel);
		
		//�� ���Աݾ��� ǥ���ϴ� ��
		final JLabel shoppingPriceLabel = new JLabel();
    	shoppingPriceLabel.setText("�� �ݾ��� : "+shoppingPrice+" �� �Դϴ�.");
		shoppingPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		shoppingPriceLabel.setBounds(20, 200, 300, 20);
		shoppingPriceLabel.setBackground(Color.white);
		shoppingPriceLabel.setOpaque(true);
		container.add(shoppingPriceLabel);
		
		//------------------------------------------------------------------//
		
		/* ���� ���� ���� (�̸� / ���� / -��ư / ���԰��� / +��ư) */
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
		
		//���� ���� ���̳ʽ� ��ư�� ������ ��
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
		
		//���� ���� �÷��� ��ư ������ ��
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
		
		/* ��پ��� ���� (�̸� / ���� / -��ư / ���԰��� / +��ư) */				
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
		
		//��� ���� ���̳ʽ� ��ư�� ������ ��
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
		
		//��� ���� �÷��� ��ư�� ������ ��
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
		
		//�� ���� ���̳ʽ� ��ư�� ������ ��
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
		
		//�� ���� �÷��� ��ư�� ������ ��
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
		
		/*�Ÿ� ���� (�̸� / ���� / -��ư / ���� ���� / +��ư)*/
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
		
		//�Ÿ� ���̳ʽ� ��ư�� ������ ��
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
		
		//�Ÿ� ���̳ʽ� ��ư�� ������ ��
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
	
		//���� ���̳ʽ� ��ư�� ������ ��
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
		
		//���� �÷��� ��ư�� ������ ��
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
		
		//�����ϱ� ��ư
		JButton buyButton = new JButton("�����ϱ�");
		buyButton.setBounds(100, 230, 150, 20);
		buyButton.setBorderPainted(false);
		buyButton.setOpaque(true);
		container.add(buyButton);
		
		//�����ϱ� ��ư�� ������ ��
		buyButton.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            
            
			JLabel shoppingMoneyLabel = new JLabel();
			shoppingMoneyLabel.setBounds(400, 0, 200, 50);
			shoppingMoneyLabel.setBackground(Color.pink);
			//���� ������ ����
			Shopping shopping = new Shopping(shoppingMoneyLabel);
            shopping.start();
            shoppingMoneyLabel.setOpaque(true);
			FarmGame.headerPanel.add(shoppingMoneyLabel);
			System.out.println(shoppingMoneyLabel);
            
			//���� ������ ������ �� ������ŭ �߰���
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
