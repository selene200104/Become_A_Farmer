package become_a_farmer_field;

import javax.swing.JOptionPane;

public class CarrotGrowthOfField2 extends Thread{
	
	static int carrotAmount = 0; //수확가능한 당근 개수
	
	@Override
	public void run(){
		//System.out.println("당근심기 2번 동작(당근 성장 스레드 실행중) 씨앗선택값 : "+Field_2.seedsSelectCount);
		Carrot.seedsAmount--;
		System.out.println("당근씨앗개수: "+Carrot.seedsAmount);
		
		try {
				Thread.sleep(5000);
				carrotAmount++;
				System.out.println("재배가능한 당근개수"+carrotAmount);
				
	        	if(carrotAmount == 1) {
	        		Field_2.fieldState++;
	        		System.out.println("식물을 심어서 필드 값 업그레이드 "+Field_2.fieldState);
	        		JOptionPane.showMessageDialog(null,"재배 가능한 농작물이 있어요!", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
	        	}	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
