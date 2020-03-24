package become_a_farmer_hpUp;


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
			System.out.println("1층집으로 업그레이드");
			//System.out.println(WoodHouse_price+"원 차감");
			System.out.println("남은 돈: "+FarmGame.money+" 등급: "+House.houseGrade);
		}
		
		else if(House.houseGrade == 1 && FarmGame.money >= firstFloorHouse_price) {
			FarmGame.money = FarmGame.money - firstFloorHouse_price;
			moneylabel.setText("        G: " + FarmGame.money);
			House.houseGrade++;
			System.out.println("2층집으로 업그레이드");
			//System.out.println(firstFloorHouse_price+"원 차감");
			System.out.println("남은 돈: "+FarmGame.money+" 등급: "+House.houseGrade);	
		}
		
		else if(House.houseGrade == 2 && FarmGame.money >= secondFloorHouse_price) {
			FarmGame.money = FarmGame.money - secondFloorHouse_price;
			moneylabel.setText("        G: " + FarmGame.money);
			House.houseGrade++;
			System.out.println("3층집으로 업그레이드");
			//System.out.println(secondFloorHouse_price+"원 차감");
			System.out.println("남은 돈: "+FarmGame.money+" 등급: "+House.houseGrade);
		}
		
		else if(House.houseGrade == 3){
			JOptionPane.showMessageDialog(null,"모든 집 업그레이드가 완료되어 더이상 할 수 없습니다.!", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else {
			JOptionPane.showMessageDialog(null,"집 업그레이드를 할 수 없습니다.", "SYSTEM", JOptionPane.ERROR_MESSAGE);
		}
	}
}
