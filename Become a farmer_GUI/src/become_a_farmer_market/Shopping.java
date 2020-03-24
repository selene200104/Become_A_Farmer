package become_a_farmer_market;

import javax.swing.JLabel;

public class Shopping extends Thread{

	JLabel shopingMoneylabel = new JLabel();

	public Shopping(JLabel shopinglabel) {
		this.shopingMoneylabel = shopinglabel;
	}
	
	public void run() {
		if(FarmGame.money >= Market.shoppingPrice) {
			FarmGame.money = FarmGame.money - Market.shoppingPrice;
			shopingMoneylabel.setText("        G: " + FarmGame.money);
				
			System.out.println("남은 돈: "+FarmGame.money);
		}else {
			System.out.println("살 수 없습니다.");
		}
	}
}
