package become_a_farmer_exclude_Image;

import java.util.Random;

import javax.swing.JOptionPane;

public class RadishGrowthOfField3 extends Thread {

	// ��Ȯ������ �� ����
	/*static Random random = new Random();
	static int radishAmount = random.nextInt(3);*/
	static int radishAmount = 0;

	@Override
	public void run() {
		// System.out.println("�� �ɱ� 2�� ����(�� ���� ������ ������) ���Ѽ��ð� :
		// "+Field_3.seedsSelectCount);
		Radish.seedsAmount--;
		System.out.println("�� ���Ѱ���: " + Radish.seedsAmount);

		try {
			Thread.sleep(7000);
			radishAmount++;
			//radishAmount = radishAmount + 1;
			System.out.println("��谡���� �� ����" + radishAmount);

			if (radishAmount == 1) {
				//�ʵ� ���� ���� +1���༭ ��Ȯ�����ϰ� ����
				Field_3.fieldState++;
				System.out.println("�Ĺ��� �ɾ �ʵ� �� ���׷��̵� " + Field_3.fieldState);
				JOptionPane.showMessageDialog(null, "���� ��Ȯ�Ǳ⸦ ��ٷ���!", "SYSTEM",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
