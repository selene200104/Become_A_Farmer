package become_a_farmer_exclude_Image;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class House extends JFrame {
	static JButton houseUpgrade;

	MyListener listener = new MyListener();
	JPanel headerPanel = new JPanel();
	JPanel housePanel = new JPanel();

	//�� ���
	static int houseGrade = 0;
	
	static int woodHouse_price = 3000;	//������ ����
	static int firstFloorHouse_price = 5000;	//1���� ����
	static int secondFloorHouse_price = 7000;	//2���� ����

	JLabel moneyLabel = new JLabel();

	House() {
		
		setTitle("house");
		setSize(350, 150);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
		
		housePanel.setLayout(null);
		housePanel.setBounds(0, 0, 300, 150);

		JLabel houseNameLabel = new JLabel("���� ����� ����");
		houseNameLabel.setBounds(20, 20, 90, 20);
		houseNameLabel.setOpaque(true);
		housePanel.add(houseNameLabel);
		add(housePanel);

		/*�Ͽ콺 ��޿� ���� ��µǴ� ���� �޶���*/
		if (houseGrade == 0) {
			JLabel housegrade_container = new JLabel("�����̳� �ڽ� �Դϴ�.");
			housegrade_container.setBounds(120, 20, 200, 20);
			housegrade_container.setOpaque(true);
			housePanel.add(housegrade_container);
		}else if (houseGrade == 1) {
			JLabel housegrade_firstFloorHouse = new JLabel("1���� �Դϴ�.");
			housegrade_firstFloorHouse.setBounds(120, 20, 200, 20);
			housegrade_firstFloorHouse.setOpaque(true);
			housePanel.add(housegrade_firstFloorHouse);
		}else if (houseGrade == 2) {
			JLabel housegrade_secondFloorHouse = new JLabel("2���� �Դϴ�.");
			housegrade_secondFloorHouse.setBounds(120, 20, 200, 20);
			housegrade_secondFloorHouse.setOpaque(true);
			housePanel.add(housegrade_secondFloorHouse);
		}else {
			JLabel housegrade_secondFloorHouse = new JLabel("3���� �Դϴ�.");
			housegrade_secondFloorHouse.setBounds(120, 20, 200, 20);
			housegrade_secondFloorHouse.setOpaque(true);
			housePanel.add(housegrade_secondFloorHouse);
		}

		houseUpgrade = new JButton("���� ���׷��̵� �Ϸ��� Ŭ�����ּ���.");
		houseUpgrade.addActionListener(listener);
		housePanel.add(houseUpgrade);
		houseUpgrade.setBounds(20, 50, 300, 20);
		
	   	/* if(houseGrade == 3) {
	   		houseUpgrade.setEnabled(false);
	   	} */
	}

	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			//�Ͽ콺 ���׷��̵� ��ư�� ������ �Ͽ콺 ���׷��̵� ������ ����
			if (e.getSource() == houseUpgrade) {
				houseUpgrade.setVisible(true);

				JLabel moneyLabel = new JLabel();
				moneyLabel.setBounds(400, 0, 200, 50);
				moneyLabel.setBackground(Color.pink);
				HouseUpgrade houseupgrade = new HouseUpgrade(moneyLabel);
				System.out.println("�������:"+House.houseGrade);
				houseupgrade.start();
				moneyLabel.setOpaque(true);
				FarmGame.headerPanel.add(moneyLabel);
				
				dispose();
				House house = new House();
			}
		}
	}
}

