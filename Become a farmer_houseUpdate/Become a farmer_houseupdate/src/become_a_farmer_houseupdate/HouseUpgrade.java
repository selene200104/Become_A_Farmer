package become_a_farmer_houseupdate;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HouseUpgrade extends Thread {
	
	int WoodHouse_price = 3000;
	int firstFloorHouse_price = 5000;
	int secondFloorHouse_price = 7000;
	
	JLabel moneylabel = new JLabel();

	public HouseUpgrade(JLabel moneylabel) {
		this.moneylabel = moneylabel;
	}

	public void run() {
		
		if(House.houseGrade == 0 && FarmGame.money >= WoodHouse_price) {
			FarmGame.money = FarmGame.money - WoodHouse_price;
			moneylabel.setText("        G: " + FarmGame.money);
			House.houseGrade++;
			System.out.println("1�������� ���׷��̵�");
			System.out.println("���� ��: "+FarmGame.money+" ���: "+House.houseGrade);
			
		}else if(House.houseGrade == 1 && FarmGame.money >= firstFloorHouse_price) {
			FarmGame.money = FarmGame.money - firstFloorHouse_price;
			moneylabel.setText("        G : " + FarmGame.money);
			House.houseGrade++;
			System.out.println("2�������� ���׷��̵�");
			System.out.println("���� ��: "+FarmGame.money+" ���: "+House.houseGrade);
			
		}else if(House.houseGrade == 2 && FarmGame.money >= secondFloorHouse_price) {
			FarmGame.money = FarmGame.money - secondFloorHouse_price;
			moneylabel.setText("        G : " + FarmGame.money);
			House.houseGrade++;
			System.out.println("3�������� ���׷��̵�");
			System.out.println("���� ��: "+FarmGame.money+" ���: "+House.houseGrade);
		}
	}
}
