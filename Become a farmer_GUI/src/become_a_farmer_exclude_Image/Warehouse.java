package become_a_farmer_exclude_Image;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Warehouse extends JFrame{

		JPanel Warehouse = new JPanel();
		
		// ���� �ʱⰪ
		static int sellingPrice = 0;
		
		//�Ǹ� ����
		static int sellingLettuceCount = 0;
		static int sellingCarrotCount = 0;
		static int sellingRadishCount = 0;
		
		//TODO ��ġ �� �߰��ϱ�

		Warehouse(){
			setTitle("���۹� â��");
			setSize(350, 300);
			setResizable(false);
			setLocationRelativeTo(null);
			setVisible(true);
			setLayout(new BorderLayout());
			
			Container container = getContentPane();
			container.setLayout(null);
			container.setBackground(Color.WHITE);	
			
			//��깰 ����Ʈ�� ǥ���ϴ� ��
			JLabel agriculturalProductsListLabel = new JLabel();
			agriculturalProductsListLabel.setText("�� ��깰 �� ");
			agriculturalProductsListLabel.setHorizontalAlignment(JLabel.CENTER);
			agriculturalProductsListLabel.setBounds(20, 10, 100, 20);
			agriculturalProductsListLabel.setBackground(Color.white);
			agriculturalProductsListLabel.setOpaque(true);
			container.add(agriculturalProductsListLabel);
			
			//��깰 ������ ǥ���ϴ� ��
			JLabel productAmountLabel = new JLabel();
			productAmountLabel.setText("�� �������� �� ");
			productAmountLabel.setHorizontalAlignment(JLabel.CENTER);
			productAmountLabel.setBounds(120, 10, 100, 20);
			productAmountLabel.setBackground(Color.white);
			productAmountLabel.setOpaque(true);
			container.add(productAmountLabel);
			
			//��깰 �Ǹ� ������ ǥ���ϴ� ��
			JLabel itemCountLabel = new JLabel();
			itemCountLabel.setText("�� �ǸŰ��� �� ");
			itemCountLabel.setHorizontalAlignment(JLabel.CENTER);
			itemCountLabel.setBounds(220, 10, 100, 20);
			itemCountLabel.setBackground(Color.white);
			itemCountLabel.setOpaque(true);
			container.add(itemCountLabel);
			
			//�� �Ǹűݾ��� ǥ���ϴ� ��
			final JLabel sellingPriceLabel = new JLabel();
			sellingPriceLabel.setText("�� �Ǹűݾ��� : "+sellingPrice+" �� �Դϴ�.");
			sellingPriceLabel.setHorizontalAlignment(JLabel.CENTER);
			sellingPriceLabel.setBounds(20, 200, 300, 20);
			sellingPriceLabel.setBackground(Color.white);
			sellingPriceLabel.setOpaque(true);
			container.add(sellingPriceLabel);
			
			//------------------------------------------------------------------//
			
			/* ���� �Ǹ� (�̸� / ���� / -��ư / �Ǹ��Ұ��� / +��ư) */
			JLabel lettuceLabel = new JLabel();
			lettuceLabel.setText(""+Lettuce.name);
			lettuceLabel.setHorizontalAlignment(JLabel.CENTER);
			lettuceLabel.setBounds(20, 40, 100, 20);
			lettuceLabel.setBackground(Color.white);
			lettuceLabel.setOpaque(true);
			container.add(lettuceLabel);
			
			JLabel lettuceAmountLabel = new JLabel();
			lettuceAmountLabel.setText(""+Lettuce.amount);
			lettuceAmountLabel.setHorizontalAlignment(JLabel.CENTER);
			lettuceAmountLabel.setBounds(120, 40, 100, 20);
			lettuceAmountLabel.setBackground(Color.white);
			lettuceAmountLabel.setOpaque(true);
			container.add(lettuceAmountLabel);
			
			JButton lettuceCountMinus = new JButton("-");
			lettuceCountMinus.setBounds(200, 40, 50, 20);
			lettuceCountMinus.setBorderPainted(false);
			lettuceCountMinus.setBackground(Color.white);
			lettuceCountMinus.setOpaque(true);
			container.add(lettuceCountMinus);
			
			final JLabel sellLettuceCountLabel = new JLabel(sellingLettuceCount+"");
			sellLettuceCountLabel.setHorizontalAlignment(JLabel.CENTER);
			sellLettuceCountLabel.setBounds(240, 40, 50, 20);
			sellLettuceCountLabel.setBackground(Color.white);
			sellLettuceCountLabel.setOpaque(true);
			container.add(sellLettuceCountLabel);
			
			JButton lettuceCountPlus = new JButton("+");
			lettuceCountPlus.setBounds(280, 40, 50, 20);
			lettuceCountPlus.setBorderPainted(false);
			lettuceCountPlus.setBackground(Color.white);
			lettuceCountPlus.setOpaque(true);
			container.add(lettuceCountPlus);
			
			//���� ���̳ʽ� ��ư�� ������ ��
			lettuceCountMinus.addActionListener (new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	            	sellingLettuceCount--;
	            	
	            	//���� 0���� �۾����� ���̻� �۾��� �� ����.
	            	if(sellingLettuceCount < 0 ) {
	            		sellingLettuceCount = 0;
	            	}
	            	
	            	//������ ���� ������ִ� �޼ҵ�
	            	sumSellingPrice();
	            	sellingPriceLabel.setText("�� �Ǹűݾ��� : "+sellingPrice+" �� �Դϴ�.");
	            	
	            	sellLettuceCountLabel.setText(sellingLettuceCount+"");
	                System.out.println(sellingLettuceCount);
	            }
	        });
			
			//���� �÷��� ��ư�� ������ ��
			lettuceCountPlus.addActionListener (new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	            	sellingLettuceCount++;
	            	
	            	//���� �����ϰ� �ִ� ������ Ŀ���� ���̻� Ŀ�� �� ����.
	            	if(sellingLettuceCount > Lettuce.amount ) {
	            		sellingLettuceCount = Lettuce.amount;
	            	}
	            	
	            	//������ ���� ������ִ� �޼ҵ�
	            	sumSellingPrice();
	            	sellingPriceLabel.setText("�� �Ǹűݾ��� : "+sellingPrice+" �� �Դϴ�.");
	            	
	            	sellLettuceCountLabel.setText(sellingLettuceCount+"");
	                System.out.println(sellingLettuceCount);
	            }
	        });
			
			//------------------------------------------------------------------//
			
			/* ����Ǹ� (�̸� / ���� / -��ư / �Ǹ��� ���� / +��ư) */				
			JLabel carrotLabel = new JLabel();
			carrotLabel.setText(""+Carrot.name);
			carrotLabel.setHorizontalAlignment(JLabel.CENTER);
			carrotLabel.setBounds(20, 70, 100, 20);
			carrotLabel.setBackground(Color.white);
			carrotLabel.setOpaque(true);
			container.add(carrotLabel);
			
			JLabel carrotAmountLabel = new JLabel();
			carrotAmountLabel.setText(""+Carrot.amount);
			carrotAmountLabel.setHorizontalAlignment(JLabel.CENTER);
			carrotAmountLabel.setBounds(120, 70, 100, 20);
			carrotAmountLabel.setBackground(Color.white);
			carrotAmountLabel.setOpaque(true);
			container.add(carrotAmountLabel);
			
			JButton carrotCountMinus = new JButton("-");
			carrotCountMinus.setBounds(200, 70, 50, 20);
			carrotCountMinus.setBorderPainted(false);
			carrotCountMinus.setBackground(Color.white);
			carrotCountMinus.setOpaque(true);
			container.add(carrotCountMinus);
			
			final JLabel sellCarrotCountLabel = new JLabel(sellingCarrotCount+"");
			sellCarrotCountLabel.setHorizontalAlignment(JLabel.CENTER);
			sellCarrotCountLabel.setBounds(240, 70, 50, 20);
			sellCarrotCountLabel.setBackground(Color.white);
			sellCarrotCountLabel.setOpaque(true);
			container.add(sellCarrotCountLabel);
			
			JButton carrotCountPlus = new JButton("+");
			carrotCountPlus.setBounds(280, 70, 50, 20);
			carrotCountPlus.setBorderPainted(false);
			carrotCountPlus.setBackground(Color.white);
			carrotCountPlus.setOpaque(true);
			container.add(carrotCountPlus);		
			
			//��� ���̳ʽ� ��ư�� ������ ��
			carrotCountMinus.addActionListener (new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	            	sellingCarrotCount--;
	            	
	            	//���� 0���� �۾����� ���̻� �۾��� �� ����.
	            	if(sellingCarrotCount < 0 ) {
	            		sellingCarrotCount = 0;
	            	}
	            	
	            	//������ ���� ������ִ� �޼ҵ�
	            	sumSellingPrice();
	            	sellingPriceLabel.setText("�� �Ǹűݾ��� : "+sellingPrice+" �� �Դϴ�.");
	            	
	            	sellCarrotCountLabel.setText(sellingCarrotCount+"");
	                System.out.println(sellingCarrotCount);
	            }
	        });
			
			//��� �÷��� ��ư�� ������ ��
			carrotCountPlus.addActionListener (new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	            	sellingCarrotCount++;
	            	
	            	//���� �����ϰ� �ִ� ������ Ŀ���� ���̻� Ŀ�� �� ����.
	            	if(sellingCarrotCount > Carrot.amount ) {
	            		sellingCarrotCount = Carrot.amount;
	            	}
	            	
	            	//������ ���� ������ִ� �޼ҵ�
	            	sumSellingPrice();
	            	sellingPriceLabel.setText("�� �Ǹűݾ��� : "+sellingPrice+" �� �Դϴ�.");
	            	
	            	sellCarrotCountLabel.setText(sellingCarrotCount+"");
	                System.out.println(sellingCarrotCount);
	            }
	        });
			
			//------------------------------------------------------------------//
			
			/*�� �Ǹ� (�̸� / ���� / -��ư / �Ǹ� ���� / +��ư)*/
			JLabel radishLabel = new JLabel();
			radishLabel.setText(""+Radish.name);
			radishLabel.setHorizontalAlignment(JLabel.CENTER);
			radishLabel.setBounds(20, 100, 100, 20);
			radishLabel.setBackground(Color.white);
			radishLabel.setOpaque(true);
			container.add(radishLabel);
			
			JLabel radishAmountLabel = new JLabel();
			radishAmountLabel.setText(""+Radish.amount);
			radishAmountLabel.setHorizontalAlignment(JLabel.CENTER);
			radishAmountLabel.setBounds(120, 100, 100, 20);
			radishAmountLabel.setBackground(Color.white);
			radishAmountLabel.setOpaque(true);
			container.add(radishAmountLabel);
			
			JButton radishCountMinus = new JButton("-");
			radishCountMinus.setBounds(200, 100, 50, 20);
			radishCountMinus.setBorderPainted(false);
			radishCountMinus.setBackground(Color.white);
			radishCountMinus.setOpaque(true);
			container.add(radishCountMinus);
			
			final JLabel sellRadishCountLabel = new JLabel(sellingRadishCount+"");
			sellRadishCountLabel.setHorizontalAlignment(JLabel.CENTER);
			sellRadishCountLabel.setBounds(240, 100, 50, 20);
			sellRadishCountLabel.setBackground(Color.white);
			sellRadishCountLabel.setOpaque(true);
			container.add(sellRadishCountLabel);
			
			JButton radishCountPlus = new JButton("+");
			radishCountPlus.setBounds(280, 100, 50, 20);
			radishCountPlus.setBorderPainted(false);
			radishCountPlus.setBackground(Color.white);
			radishCountPlus.setOpaque(true);
			container.add(radishCountPlus);
			
			//�� ���̳ʽ� ��ư�� ������ ��
			radishCountMinus.addActionListener (new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	            	sellingRadishCount--;
	            	
	            	if(sellingRadishCount < 0 ) {
	            		sellingRadishCount = 0;
	            	}
	            	
	            	//������ ���� ������ִ� �޼ҵ�
	            	sumSellingPrice();
	            	sellingPriceLabel.setText("�� �Ǹűݾ��� : "+sellingPrice+" �� �Դϴ�.");
	            	
	            	sellCarrotCountLabel.setText(sellingCarrotCount+"");
	                System.out.println(sellingCarrotCount);
	            }
	        });
			
			//�� �÷��� ��ư�� ������ ��
			radishCountPlus.addActionListener (new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	            	sellingRadishCount++;
	            	
	            	//���� �����ϰ� �ִ� ������ Ŀ���� ���̻� Ŀ�� �� ����.
	            	if(sellingRadishCount > Radish.amount ) {
	            		sellingRadishCount = Radish.amount;
	            	}
	            	
	            	//������ ���� ������ִ� �޼ҵ�
	            	sumSellingPrice();
	            	sellingPriceLabel.setText("�� �Ǹűݾ��� : "+sellingPrice+" �� �Դϴ�.");
	            	
	            	sellCarrotCountLabel.setText(sellingCarrotCount+"");
	                System.out.println(sellingCarrotCount);
	            }
	        });
			
			//------------------------------------------------------------------//
			
			//�Ǹ��ϱ� ��ư
			JButton sellButton = new JButton("�Ǹ��ϱ�");
			sellButton.setBounds(100, 230, 150, 20);
			sellButton.setBorderPainted(false);
			sellButton.setOpaque(true);
			container.add(sellButton);
			
			//�Ǹ��ϱ� ��ư�� ������ ��
			sellButton.addActionListener (new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	    			
				JLabel sellingMoneyLabel = new JLabel();
				sellingMoneyLabel.setBounds(400, 0, 200, 50);
				sellingMoneyLabel.setBackground(Color.pink);
				//�Ǹ� ������ ����
				Selling selling = new Selling(sellingMoneyLabel);
				selling.start();
	            sellingMoneyLabel.setOpaque(true);
				FarmGame.headerPanel.add(sellingMoneyLabel);
				//System.out.println(sellingMoneyLabel);
				
				//������ ���۹� ������ �ǸŰ�����ŭ ����
				Lettuce.amount -= sellingLettuceCount;
				Carrot.amount -= sellingCarrotCount;
				Radish.amount -= sellingRadishCount;
				
				//����ư�� ������ ��� �ǸŰ���, ������ ���� 0���� �ʱ�ȭ �ȴ�.
				sellingLettuceCount = 0;
				sellingCarrotCount = 0;
				sellingRadishCount = 0;
				sellingPrice = 0;
				
				sellLettuceCountLabel.setText(""+sellingLettuceCount);
				sellCarrotCountLabel.setText(""+sellingCarrotCount);
				sellRadishCountLabel.setText(""+sellingRadishCount);
				sellingPriceLabel.setText(""+sellingPrice);

				dispose();
	            }
	        });
		}
		
		//�Ǹ��� ���� ������ִ� �޼ҵ�
		void sumSellingPrice(){
			sellingPrice = sellingLettuceCount*Lettuce.price
					+sellingCarrotCount*Carrot.price
					+sellingRadishCount*Radish.price;
		}

}
