package become_a_farmer_exclude_Image;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HouseUpgrade extends Thread {
	
	//�� ����
	//int woodHouse_price = 3000;
	//int firstFloorHouse_price = 5000;
	//int secondFloorHouse_price = 7000;
	
	JLabel moneylabel = new JLabel();

	public HouseUpgrade(JLabel moneylabel) {
		this.moneylabel = moneylabel;
	}

	public void run() {
		
		//�� ����� 0�̰�, �����ϰ� �ִ� ���� ������ ���ݺ��� ���� �ÿ� ���׷��̵� ��
		if(House.houseGrade == 0 && FarmGame.money >= House.woodHouse_price) {
			FarmGame.money = FarmGame.money - House.woodHouse_price;
			moneylabel.setText("        G: " + FarmGame.money);
			House.houseGrade++;		
			//FarmGame.hp = FarmGame.hp - 30;
			//System.out.println("1�������� ���׷��̵�");
			//System.out.println(WoodHouse_price+"�� ����");
			//System.out.println("���� ��: "+FarmGame.money+" ���: "+House.houseGrade);
		}
		
		//�� ����� 1�̰�, �����ϰ� �ִ� ���� 2���� ���ݺ��� ���� �ÿ� ���׷��̵� ��
		else if(House.houseGrade == 1 && FarmGame.money >= House.firstFloorHouse_price) {
			FarmGame.money = FarmGame.money - House.firstFloorHouse_price;
			moneylabel.setText("        G: " + FarmGame.money);
			House.houseGrade++;
			System.out.println("2�������� ���׷��̵�");
			//System.out.println(firstFloorHouse_price+"�� ����");
			System.out.println("���� ��: "+FarmGame.money+" ���: "+House.houseGrade);	
		}
		
		//�� ����� 2�̰�, �����ϰ� �ִ� ���� 3���� ���ݺ��� ���� �ÿ� ���׷��̵� ��
		else if(House.houseGrade == 2 && FarmGame.money >= House.secondFloorHouse_price) {
			FarmGame.money = FarmGame.money - House.secondFloorHouse_price;
			moneylabel.setText("        G: " + FarmGame.money);
			House.houseGrade++;
			System.out.println("3�������� ���׷��̵�");
			//System.out.println(secondFloorHouse_price+"�� ����");
			System.out.println("���� ��: "+FarmGame.money+" ���: "+House.houseGrade);
		}
		
		//�� ����� 3�� �Ǹ� ���ǿ������� ������ ����
		else if(House.houseGrade == 3){
			JOptionPane.showMessageDialog(null,"����� ���̻�Ȱ ������ �����ϼ̽��ϴ�! ���ϵ����!", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
			//break;
			System.exit(0);
		}
		
		//���� �����ϸ� ���â�� ��
		else {
			JOptionPane.showMessageDialog(null,"�� ���׷��̵带 �� �� �����ϴ�.", "SYSTEM", JOptionPane.ERROR_MESSAGE);
		}
	}
}
