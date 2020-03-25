package become_a_farmer_field;

import javax.swing.JOptionPane;

public class RadishGrowthOfField1 extends Thread{
	
	static int radishAmount = 0; //수확가능한 무 개수
	
	@Override
	public void run(){
		//System.out.println("무 심기 2번 동작(무 성장 스레드 실행중) 씨앗선택값 : "+Field_2.seedsSelectCount);
		Radish.seedsAmount--;
		System.out.println("무 씨앗개수: "+Radish.seedsAmount);
		
		try {
				Thread.sleep(7000);
				radishAmount++;
				System.out.println("재배가능한 무 개수"+radishAmount);
				
	        	if(radishAmount == 1) {
	        		Field_1.fieldState++;
	        		System.out.println("식물을 심어서 필드 값 업그레이드 "+Field_1.fieldState);
	        		JOptionPane.showMessageDialog(null,"재배 가능한 농작물이 있어요!", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
	        	}	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
