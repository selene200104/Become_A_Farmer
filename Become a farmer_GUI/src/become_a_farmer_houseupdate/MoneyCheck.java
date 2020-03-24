package become_a_farmer_houseupdate;

import javax.swing.JLabel;

public class MoneyCheck extends Thread {

	int money = FarmGame.money;
	
	JLabel moneyLabel = new JLabel();
	
	public MoneyCheck(JLabel moneyLabel) {
		this.moneyLabel = moneyLabel;
	}
	
	public void run() {
		money = FarmGame.money;
		moneyLabel.setText("                           " + money);
		//System.out.println(money);
	}
}
