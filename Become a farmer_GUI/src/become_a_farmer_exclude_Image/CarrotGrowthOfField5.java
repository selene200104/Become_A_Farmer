package become_a_farmer_exclude_Image;

import java.util.Random;

import javax.swing.JOptionPane;

public class CarrotGrowthOfField5 extends Thread {

	// 수확가능한 당근 갯수
	/*static Random random = new Random();
	static int carrotAmount = random.nextInt(3);*/
	static int carrotAmount = 0;

	@Override
	public void run() {
		// System.out.println("당근심기 2번 동작(당근 성장 스레드 실행중) 씨앗선택값 :
		// "+Field_5.seedsSelectCount);
		Carrot.seedsAmount--;
		System.out.println("당근씨앗개수: " + Carrot.seedsAmount);

		try {
			Thread.sleep(5000);
			carrotAmount ++;
			System.out.println("재배가능한 당근개수" + carrotAmount);

			if (carrotAmount == 1) {
				//필드 정보 값을 +1해줘서 수확가능하게 만듬
				Field_5.fieldState++;
				System.out.println("식물을 심어서 필드 값 업그레이드 " + Field_5.fieldState);
				JOptionPane.showMessageDialog(null, "당근이 수확되기를 기다려요!", "SYSTEM",
						JOptionPane.INFORMATION_MESSAGE);			
				}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
