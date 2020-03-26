package become_a_farmer_exclude_Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Selling extends Thread{

	JLabel sellingPriceLabel = new JLabel();

	public Selling(JLabel sellingPriceLabel) {
		this.sellingPriceLabel = sellingPriceLabel;
	}
	
	public void run() {
			FarmGame.money = FarmGame.money + Warehouse.sellingPrice;
			sellingPriceLabel.setText("        G: " + FarmGame.money);
	
			//System.out.println("³²Àº µ·: "+FarmGame.money);
	}
}
