package become_a_farmer_field;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Shopping extends Thread{

	JLabel shopingMoneylabel = new JLabel();

	public Shopping(JLabel shopinglabel) {
		this.shopingMoneylabel = shopinglabel;
	}
	
	public void run() {
		if(FarmGame.money >= Market.shoppingPrice) {
			FarmGame.money = FarmGame.money - Market.shoppingPrice;
			shopingMoneylabel.setText("        G: " + FarmGame.money);
				
			//System.out.println("남은 돈: "+FarmGame.money);
		}else {
			JOptionPane.showMessageDialog(null,"돈이 부족합니다.", "SYSTEM", JOptionPane.ERROR_MESSAGE);
			//System.out.println("살 수 없습니다.");
		}
	}
}
