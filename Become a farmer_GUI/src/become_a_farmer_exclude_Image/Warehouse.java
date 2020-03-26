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
		
		// 가격 초기값
		static int sellingPrice = 0;
		
		//판매 개수
		static int sellingLettuceCount = 0;
		static int sellingCarrotCount = 0;
		static int sellingRadishCount = 0;
		
		//TODO 위치 값 추가하기

		Warehouse(){
			setTitle("농작물 창고");
			setSize(350, 300);
			setResizable(false);
			setLocationRelativeTo(null);
			setVisible(true);
			setLayout(new BorderLayout());
			
			Container container = getContentPane();
			container.setLayout(null);
			container.setBackground(Color.WHITE);	
			
			//농산물 리스트를 표시하는 라벨
			JLabel agriculturalProductsListLabel = new JLabel();
			agriculturalProductsListLabel.setText("▽ 농산물 ▽ ");
			agriculturalProductsListLabel.setHorizontalAlignment(JLabel.CENTER);
			agriculturalProductsListLabel.setBounds(20, 10, 100, 20);
			agriculturalProductsListLabel.setBackground(Color.white);
			agriculturalProductsListLabel.setOpaque(true);
			container.add(agriculturalProductsListLabel);
			
			//농산물 개수를 표시하는 라벨
			JLabel productAmountLabel = new JLabel();
			productAmountLabel.setText("▽ 보유개수 ▽ ");
			productAmountLabel.setHorizontalAlignment(JLabel.CENTER);
			productAmountLabel.setBounds(120, 10, 100, 20);
			productAmountLabel.setBackground(Color.white);
			productAmountLabel.setOpaque(true);
			container.add(productAmountLabel);
			
			//농산물 판매 개수를 표시하는 라벨
			JLabel itemCountLabel = new JLabel();
			itemCountLabel.setText("▽ 판매갯수 ▽ ");
			itemCountLabel.setHorizontalAlignment(JLabel.CENTER);
			itemCountLabel.setBounds(220, 10, 100, 20);
			itemCountLabel.setBackground(Color.white);
			itemCountLabel.setOpaque(true);
			container.add(itemCountLabel);
			
			//총 판매금액을 표시하는 라벨
			final JLabel sellingPriceLabel = new JLabel();
			sellingPriceLabel.setText("총 판매금액은 : "+sellingPrice+" 원 입니다.");
			sellingPriceLabel.setHorizontalAlignment(JLabel.CENTER);
			sellingPriceLabel.setBounds(20, 200, 300, 20);
			sellingPriceLabel.setBackground(Color.white);
			sellingPriceLabel.setOpaque(true);
			container.add(sellingPriceLabel);
			
			//------------------------------------------------------------------//
			
			/* 상추 판매 (이름 / 가격 / -버튼 / 판매할개수 / +버튼) */
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
			
			//상추 마이너스 버튼을 눌렀을 때
			lettuceCountMinus.addActionListener (new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	            	sellingLettuceCount--;
	            	
	            	//값이 0보다 작아지면 더이상 작아질 수 없다.
	            	if(sellingLettuceCount < 0 ) {
	            		sellingLettuceCount = 0;
	            	}
	            	
	            	//쇼핑한 값을 계산해주는 메소드
	            	sumSellingPrice();
	            	sellingPriceLabel.setText("총 판매금액은 : "+sellingPrice+" 원 입니다.");
	            	
	            	sellLettuceCountLabel.setText(sellingLettuceCount+"");
	                System.out.println(sellingLettuceCount);
	            }
	        });
			
			//상추 플러스 버튼을 눌렀을 때
			lettuceCountPlus.addActionListener (new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	            	sellingLettuceCount++;
	            	
	            	//값이 소유하고 있는 값보다 커지면 더이상 커질 수 없다.
	            	if(sellingLettuceCount > Lettuce.amount ) {
	            		sellingLettuceCount = Lettuce.amount;
	            	}
	            	
	            	//쇼핑한 값을 계산해주는 메소드
	            	sumSellingPrice();
	            	sellingPriceLabel.setText("총 판매금액은 : "+sellingPrice+" 원 입니다.");
	            	
	            	sellLettuceCountLabel.setText(sellingLettuceCount+"");
	                System.out.println(sellingLettuceCount);
	            }
	        });
			
			//------------------------------------------------------------------//
			
			/* 당근판매 (이름 / 가격 / -버튼 / 판매할 개수 / +버튼) */				
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
			
			//당근 마이너스 버튼을 눌렀을 때
			carrotCountMinus.addActionListener (new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	            	sellingCarrotCount--;
	            	
	            	//값이 0보다 작아지면 더이상 작아질 수 없다.
	            	if(sellingCarrotCount < 0 ) {
	            		sellingCarrotCount = 0;
	            	}
	            	
	            	//쇼핑한 값을 계산해주는 메소드
	            	sumSellingPrice();
	            	sellingPriceLabel.setText("총 판매금액은 : "+sellingPrice+" 원 입니다.");
	            	
	            	sellCarrotCountLabel.setText(sellingCarrotCount+"");
	                System.out.println(sellingCarrotCount);
	            }
	        });
			
			//당근 플러스 버튼을 눌렀을 때
			carrotCountPlus.addActionListener (new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	            	sellingCarrotCount++;
	            	
	            	//값이 소유하고 있는 값보다 커지면 더이상 커질 수 없다.
	            	if(sellingCarrotCount > Carrot.amount ) {
	            		sellingCarrotCount = Carrot.amount;
	            	}
	            	
	            	//쇼핑한 값을 계산해주는 메소드
	            	sumSellingPrice();
	            	sellingPriceLabel.setText("총 판매금액은 : "+sellingPrice+" 원 입니다.");
	            	
	            	sellCarrotCountLabel.setText(sellingCarrotCount+"");
	                System.out.println(sellingCarrotCount);
	            }
	        });
			
			//------------------------------------------------------------------//
			
			/*무 판매 (이름 / 가격 / -버튼 / 판매 개수 / +버튼)*/
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
			
			//무 마이너스 버튼을 눌렀을 때
			radishCountMinus.addActionListener (new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	            	sellingRadishCount--;
	            	
	            	if(sellingRadishCount < 0 ) {
	            		sellingRadishCount = 0;
	            	}
	            	
	            	//쇼핑한 값을 계산해주는 메소드
	            	sumSellingPrice();
	            	sellingPriceLabel.setText("총 판매금액은 : "+sellingPrice+" 원 입니다.");
	            	
	            	sellCarrotCountLabel.setText(sellingCarrotCount+"");
	                System.out.println(sellingCarrotCount);
	            }
	        });
			
			//무 플러스 버튼을 눌렀을 때
			radishCountPlus.addActionListener (new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	            	sellingRadishCount++;
	            	
	            	//값이 소유하고 있는 값보다 커지면 더이상 커질 수 없다.
	            	if(sellingRadishCount > Radish.amount ) {
	            		sellingRadishCount = Radish.amount;
	            	}
	            	
	            	//쇼핑한 값을 계산해주는 메소드
	            	sumSellingPrice();
	            	sellingPriceLabel.setText("총 판매금액은 : "+sellingPrice+" 원 입니다.");
	            	
	            	sellCarrotCountLabel.setText(sellingCarrotCount+"");
	                System.out.println(sellingCarrotCount);
	            }
	        });
			
			//------------------------------------------------------------------//
			
			//판매하기 버튼
			JButton sellButton = new JButton("판매하기");
			sellButton.setBounds(100, 230, 150, 20);
			sellButton.setBorderPainted(false);
			sellButton.setOpaque(true);
			container.add(sellButton);
			
			//판매하기 버튼을 눌렀을 때
			sellButton.addActionListener (new ActionListener(){
	            public void actionPerformed(ActionEvent ae){
	    			
				JLabel sellingMoneyLabel = new JLabel();
				sellingMoneyLabel.setBounds(400, 0, 200, 50);
				sellingMoneyLabel.setBackground(Color.pink);
				//판매 스레드 실행
				Selling selling = new Selling(sellingMoneyLabel);
				selling.start();
	            sellingMoneyLabel.setOpaque(true);
				FarmGame.headerPanel.add(sellingMoneyLabel);
				//System.out.println(sellingMoneyLabel);
				
				//각각의 농작물 값에서 판매갯수만큼 빠짐
				Lettuce.amount -= sellingLettuceCount;
				Carrot.amount -= sellingCarrotCount;
				Radish.amount -= sellingRadishCount;
				
				//계산버튼을 누르면 모든 판매갯수, 가격의 값이 0으로 초기화 된다.
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
		
		//판매한 값을 계산해주는 메소드
		void sumSellingPrice(){
			sellingPrice = sellingLettuceCount*Lettuce.price
					+sellingCarrotCount*Carrot.price
					+sellingRadishCount*Radish.price;
		}

}
