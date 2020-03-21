package become_a_farmer_0320;

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
				Thread.sleep(100);
				second--;
				
				//1분 이상일 때는, 초가 0보다 작아질때 59초로 돌아간다. 
				if(minute > 0) {	
					
					if (second < 0) {
						minute--;
						second += 59;
					}
				
				//만약 시간제한인 10분이 지나면 게임오버라고 창이 뜨고 확인을 누르면 게임창이 꺼진다. 
				}else if(minute == 0) {
					
					if (second < 0) {				
						JOptionPane.showMessageDialog(null, "10분이 지났습니다! GAME OVER!", "SYSTEM", JOptionPane.ERROR_MESSAGE);					
						//break;
						System.exit(0);
					}
					
				}	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	/*
	 * int timer = 1;
	 * 
	 * JLabel timerLabel = new JLabel();
	 * 
	 * public GameTime(JLabel timerLabel) { this.timerLabel = timerLabel; }
	 * 
	 * public void run() { while(true) { timerLabel.setText("         시간:  "+timer);
	 * try { Thread.sleep(1000); } catch (InterruptedException e) {
	 * e.printStackTrace(); } timer++; } }
	 */
}
