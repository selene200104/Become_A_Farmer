package become_a_farmer_exclude_Image;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HouseUpgrade extends Thread {
	
	//집 가격
	//int woodHouse_price = 3000;
	//int firstFloorHouse_price = 5000;
	//int secondFloorHouse_price = 7000;
	
	JLabel moneylabel = new JLabel();

	public HouseUpgrade(JLabel moneylabel) {
		this.moneylabel = moneylabel;
	}

	public void run() {
		
		//집 등급이 0이고, 소지하고 있는 돈이 나무집 가격보다 높을 시에 업그레이드 함
		if(House.houseGrade == 0 && FarmGame.money >= House.woodHouse_price) {
			FarmGame.money = FarmGame.money - House.woodHouse_price;
			moneylabel.setText("        G: " + FarmGame.money);
			House.houseGrade++;		
			//FarmGame.hp = FarmGame.hp - 30;
			//System.out.println("1층집으로 업그레이드");
			//System.out.println(WoodHouse_price+"원 차감");
			//System.out.println("남은 돈: "+FarmGame.money+" 등급: "+House.houseGrade);
		}
		
		//집 등급이 1이고, 소지하고 있는 돈이 2층집 가격보다 높을 시에 업그레이드 함
		else if(House.houseGrade == 1 && FarmGame.money >= House.firstFloorHouse_price) {
			FarmGame.money = FarmGame.money - House.firstFloorHouse_price;
			moneylabel.setText("        G: " + FarmGame.money);
			House.houseGrade++;
			System.out.println("2층집으로 업그레이드");
			//System.out.println(firstFloorHouse_price+"원 차감");
			System.out.println("남은 돈: "+FarmGame.money+" 등급: "+House.houseGrade);	
		}
		
		//집 등급이 2이고, 소지하고 있는 돈이 3층집 가격보다 높을 시에 업그레이드 함
		else if(House.houseGrade == 2 && FarmGame.money >= House.secondFloorHouse_price) {
			FarmGame.money = FarmGame.money - House.secondFloorHouse_price;
			moneylabel.setText("        G: " + FarmGame.money);
			House.houseGrade++;
			System.out.println("3층집으로 업그레이드");
			//System.out.println(secondFloorHouse_price+"원 차감");
			System.out.println("남은 돈: "+FarmGame.money+" 등급: "+House.houseGrade);
		}
		
		//집 등급이 3이 되면 해피엔딩으로 게임이 끝남
		else if(House.houseGrade == 3){
			JOptionPane.showMessageDialog(null,"당신은 농촌생활 적응에 성공하셨습니다! 축하드려요!", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
			//break;
			System.exit(0);
		}
		
		//돈이 부족하면 경고창이 뜸
		else {
			JOptionPane.showMessageDialog(null,"집 업그레이드를 할 수 없습니다.", "SYSTEM", JOptionPane.ERROR_MESSAGE);
		}
	}
}
