package become_a_farmer_field;

import javax.swing.JOptionPane;

public class CarrotGrowthOfField4 extends Thread{
	
	static int carrotAmount = 0; //��Ȯ������ ��� ����
	
	@Override
	public void run(){
		//System.out.println("��ٽɱ� 2�� ����(��� ���� ������ ������) ���Ѽ��ð� : "+Field_4.seedsSelectCount);
		Carrot.seedsAmount--;
		System.out.println("��پ��Ѱ���: "+Carrot.seedsAmount);
		
		try {
				Thread.sleep(5000);
				carrotAmount++;
				System.out.println("��谡���� ��ٰ���"+carrotAmount);
				
	        	if(carrotAmount == 1) {
	        		Field_4.fieldState++;
	        		System.out.println("�Ĺ��� �ɾ �ʵ� �� ���׷��̵� "+Field_4.fieldState);
	        		JOptionPane.showMessageDialog(null,"��� ������ ���۹��� �־��!", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
	        	}	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
