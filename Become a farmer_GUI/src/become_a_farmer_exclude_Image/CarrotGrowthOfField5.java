package become_a_farmer_exclude_Image;

import java.util.Random;

import javax.swing.JOptionPane;

public class CarrotGrowthOfField5 extends Thread {

	// ��Ȯ������ ��� ����
	/*static Random random = new Random();
	static int carrotAmount = random.nextInt(3);*/
	static int carrotAmount = 0;

	@Override
	public void run() {
		// System.out.println("��ٽɱ� 2�� ����(��� ���� ������ ������) ���Ѽ��ð� :
		// "+Field_5.seedsSelectCount);
		Carrot.seedsAmount--;
		System.out.println("��پ��Ѱ���: " + Carrot.seedsAmount);

		try {
			Thread.sleep(5000);
			carrotAmount ++;
			System.out.println("��谡���� ��ٰ���" + carrotAmount);

			if (carrotAmount == 1) {
				//�ʵ� ���� ���� +1���༭ ��Ȯ�����ϰ� ����
				Field_5.fieldState++;
				System.out.println("�Ĺ��� �ɾ �ʵ� �� ���׷��̵� " + Field_5.fieldState);
				JOptionPane.showMessageDialog(null, "����� ��Ȯ�Ǳ⸦ ��ٷ���!", "SYSTEM",
						JOptionPane.INFORMATION_MESSAGE);			
				}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
