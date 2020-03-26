package become_a_farmer_exclude_Image;

import java.util.Random;

import javax.swing.JOptionPane;

public class LettuceGrowthOfField3 extends Thread {

	// 수확가능한 상추 갯수
	/*static Random random = new Random();
	static int lettuceAmount = random.nextInt(3);*/
	static int lettuceAmount = 0;

	@Override
	public void run() {
		// System.out.println("상추심기 2번 동작(상추 성장 스레드 실행중) 씨앗선택값 :
		// "+Filed_3.seedsSelectCount);
		Lettuce.seedsAmount--;
		System.out.println("상추씨앗개수: " + Lettuce.seedsAmount);

		try {
			Thread.sleep(3000);
			lettuceAmount ++;
			System.out.println("재배가능한 상추개수" + lettuceAmount);

			if (lettuceAmount == 1) {
				Field_3.fieldState++;
				System.out.println("식물을 심어서 필드 값 업그레이드 " + Field_3.fieldState);
				JOptionPane.showMessageDialog(null, "상추가 수확되기를 기다려요!", "SYSTEM",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
