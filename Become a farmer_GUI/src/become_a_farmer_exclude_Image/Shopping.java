package become_a_farmer_exclude_Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Shopping extends Thread{

	JLabel shoppingMoneylabel = new JLabel();

	public Shopping(JLabel shoppingMoneylabel) {
		this.shoppingMoneylabel = shoppingMoneylabel;
	}
	
	public void run() {
		if(FarmGame.money >= Market.shoppingPrice) {
			FarmGame.money = FarmGame.money - Market.shoppingPrice;
			shoppingMoneylabel.setText("        G: " + FarmGame.money);
				
			//System.out.println("���� ��: "+FarmGame.money);
		}else {
			JOptionPane.showMessageDialog(null,"���� �����մϴ�.", "SYSTEM", JOptionPane.ERROR_MESSAGE);
			//System.out.println("�� �� �����ϴ�.");
		}
	}
}
