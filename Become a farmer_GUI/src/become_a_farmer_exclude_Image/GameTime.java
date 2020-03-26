package become_a_farmer_exclude_Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameTime extends Thread {

	int minute = 9;
	int second = 59;

	JLabel timerLabel = new JLabel();

	public GameTime(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	public void run() {
		
		while (true) {
			timerLabel.setText("                           " + minute + " : " + second);
			
			try {
				Thread.sleep(1000);
				second--;
				
				//1�� �̻��� ����, �ʰ� 0���� �۾��� ��� �ٽ� 59�ʷ� ���ư���. 
				if(minute > 0) {	
					
					if (second < 0) {
						minute--;
						second += 59;
					}
				
				//���� �ð������� 10���� ������ ���ӿ������ â�� �߰� Ȯ���� ������ ����â�� ������. 
				}else if(minute == 0) {
					
					if (second < 0) {				
						JOptionPane.showMessageDialog(null, "10���� �������ϴ�! GAME OVER!", "SYSTEM", JOptionPane.ERROR_MESSAGE);					
						//break;
						System.exit(0);
					}
					
				}	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
