package become_a_farmer_exclude_Image;

import java.util.Random;

import javax.swing.JOptionPane;

public class LettuceGrowthOfField3 extends Thread {

	// ��Ȯ������ ���� ����
	/*static Random random = new Random();
	static int lettuceAmount = random.nextInt(3);*/
	static int lettuceAmount = 0;

	@Override
	public void run() {
		// System.out.println("���߽ɱ� 2�� ����(���� ���� ������ ������) ���Ѽ��ð� :
		// "+Filed_3.seedsSelectCount);
		Lettuce.seedsAmount--;
		System.out.println("���߾��Ѱ���: " + Lettuce.seedsAmount);

		try {
			Thread.sleep(3000);
			lettuceAmount ++;
			System.out.println("��谡���� ���߰���" + lettuceAmount);

			if (lettuceAmount == 1) {
				Field_3.fieldState++;
				System.out.println("�Ĺ��� �ɾ �ʵ� �� ���׷��̵� " + Field_3.fieldState);
				JOptionPane.showMessageDialog(null, "���߰� ��Ȯ�Ǳ⸦ ��ٷ���!", "SYSTEM",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
