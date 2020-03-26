package become_a_farmer_exclude_Image;

import java.util.Random;

import javax.swing.JOptionPane;

public class RadishGrowthOfField3 extends Thread {

	// 수확가능한 무 갯수
	/*static Random random = new Random();
	static int radishAmount = random.nextInt(3);*/
	static int radishAmount = 0;

	@Override
	public void run() {
		// System.out.println("무 심기 2번 동작(무 성장 스레드 실행중) 씨앗선택값 :
		// "+Field_3.seedsSelectCount);
		Radish.seedsAmount--;
		System.out.println("무 씨앗개수: " + Radish.seedsAmount);

		try {
			Thread.sleep(7000);
			radishAmount++;
			//radishAmount = radishAmount + 1;
			System.out.println("재배가능한 무 개수" + radishAmount);

			if (radishAmount == 1) {
				//필드 정보 값을 +1해줘서 수확가능하게 만듬
				Field_3.fieldState++;
				System.out.println("식물을 심어서 필드 값 업그레이드 " + Field_3.fieldState);
				JOptionPane.showMessageDialog(null, "무가 수확되기를 기다려요!", "SYSTEM",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
