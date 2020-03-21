package become_a_farmer_0320;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FarmGame extends JFrame {
	
	private IntroGame introGame;
	private GameStory gameStory;
	private FarmPanel farmPanel;
	
	private JButton gameStartButton;
	private JButton gameEndButton;
	private JButton gameStoryEndButton;
	private JButton house;
	private JButton locker;
	private JButton market;
	private JButton filed_1,filed_2,filed_3,filed_4,filed_5;
	
	JPanel headerPanel = new JPanel();
	MyListener listener = new MyListener();
	//Player_hp player = new Player_hp();
	//GameTime gamePlayTime = new GameTime();
	
	FarmGame() {

			/*���� ��Ʈ��ȭ��*/
			introGame = new IntroGame();
			introGame.setLayout(null);
			
			gameStartButton = new JButton("���� ����");
            gameStartButton.addActionListener(listener);
            introGame.add(gameStartButton);
            gameStartButton.setBounds(170, 100, 100, 50);
            
            gameEndButton = new JButton("���� ����");
            gameEndButton.addActionListener(listener);
            introGame.add(gameEndButton);
            gameEndButton.setBounds(320,100,100,50);
            
            add(introGame);
            
            /*���� ���丮 ���� ȭ��*/
			gameStory = new GameStory();
            gameStory.setLayout(null);
            
			gameStoryEndButton = new JButton("GAME START");
			gameStoryEndButton.addActionListener(listener);
			gameStory.add(gameStoryEndButton);
			gameStoryEndButton.setBounds(437, 425, 130, 30);
            	
			/* ����ȭ�� (��ܹ� - ü�� / �ð� / ��) */
			headerPanel.setLayout(null);
			headerPanel.setBounds(0, 0, 600, 50);
			
			JLabel hpLabel = new JLabel("         ü��: "+PlayerHp.hp);
			hpLabel.setBounds(0, 0, 200, 50);
			hpLabel.setBackground(Color.white);
			hpLabel.setOpaque(true);
			headerPanel.add(hpLabel);
			
			/*JLabel timeLabel = new JLabel("        Time: ");
			timeLabel.setBounds(200, 0, 200, 50);
			timeLabel.setBackground(Color.white);
			timeLabel.setOpaque(true);
			headerPanel.add(timeLabel);*/
			
			JLabel moneyLabel = new JLabel("        G: "+PlayerMoney.money);
			moneyLabel.setBounds(400, 0, 200, 50);
			moneyLabel.setBackground (Color.pink);
			moneyLabel.setOpaque(true);
			headerPanel.add(moneyLabel);
			
			/* ����ȭ�� (����ȭ��) */
			farmPanel = new FarmPanel();
			farmPanel.setLayout(null);
			farmPanel.setBounds(0,50,600,450);		
				
			house = new JButton("��");
			house.addActionListener(listener);
			farmPanel.add(house);
			house.setBounds(30, 80, 150, 70);
			
			locker = new JButton("���۹� ������");
			locker.addActionListener(listener);
			farmPanel.add(locker);
			locker.setBounds(210, 80, 150, 70);
			
			market = new JButton("����");
			market.addActionListener(listener);
			farmPanel.add(market);
			market.setBounds(390, 80, 150, 70);
			
			filed_1 = new JButton("�� 1");
			filed_1.addActionListener(listener);
			farmPanel.add(filed_1);
			filed_1.setBounds(30, 200, 70, 70);
			
			filed_2 = new JButton("�� 2");
			filed_2.addActionListener(listener);
			farmPanel.add(filed_2);
			filed_2.setBounds(140, 200, 70, 70);
			
			filed_3 = new JButton("�� 3");
			filed_3.addActionListener(listener);
			farmPanel.add(filed_3);
			filed_3.setBounds(250, 200, 70, 70);
			
			filed_4 = new JButton("�� 4");
			filed_4.addActionListener(listener);
			farmPanel.add(filed_4);
			filed_4.setBounds(360, 200, 70, 70);
			
			filed_5 = new JButton("�� 5");
			filed_5.addActionListener(listener);
			farmPanel.add(filed_5);
			filed_5.setBounds(470, 200, 70, 70);
					
            /*���� â ���� �ʱ�ȭ*/
            setTitle("Become a farmer");
            setSize(600, 500);
            setResizable(false);
            setLocationRelativeTo(null);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());   
    }
	
	/*���콺 �̺�Ʈ*/ 
	
	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == gameStartButton) {
				gameStartButton.setVisible(false);
				gameStartButton.setVisible(false);
				introGame.setVisible(false);
				//System.out.println("���� �Ұ� ȭ�� ��ȯ");
				add(gameStory);
			}
			
			if(e.getSource() == gameEndButton) {
				int gameEndSelect = JOptionPane.showConfirmDialog(null, "������ �����Ͻðڽ��ϱ�?", "SYSTEM", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				//System.out.println(num);
				
				if(gameEndSelect == 0) {
					System.exit(0);
				}
			}
			
			if(e.getSource() == gameStoryEndButton) {
					gameStory.setVisible(false);
					add(headerPanel);
					add(farmPanel);
					farmPanel.setVisible(true);
					System.out.println("���� ȭ�� ��ȯ");
					
					JLabel timerLabel = new JLabel();
					timerLabel.setBounds(200, 0, 200, 50);
					timerLabel.setBackground(Color.green);
					GameTime timer = new GameTime(timerLabel);
					timer.start();
					timerLabel.setOpaque(true);
					headerPanel.add(timerLabel);
			}
			
			if(e.getSource() == house) {	
				JLabel player_hp_Label = new JLabel();
				player_hp_Label.setBounds(0, 0, 200, 50);
				player_hp_Label.setBackground(Color.white);
				PlayerHp player_hp = new PlayerHp(player_hp_Label);
				player_hp.start();
				player_hp_Label.setOpaque(true);
				headerPanel.add(player_hp_Label);
			}
			
			/*if(e.getSource() == filed_1) {	
				JLabel player_hp_Label2 = new JLabel();
				player_hp_Label2.setBounds(0, 0, 200, 50);
				player_hp_Label2.setBackground(Color.white);
				PlayerHp player_hp = new PlayerHp(player_hp_Label2);
				player_hp.start();
				player_hp_Label2.setOpaque(true);
				headerPanel.add(player_hp_Label2);
			}*/
			
			if(e.getSource() == market) {	
				JLabel moneyLabel = new JLabel();
				moneyLabel.setBounds(400, 0, 200, 50);
				moneyLabel.setBackground(Color.pink);
				PlayerMoney gold = new PlayerMoney(moneyLabel);
				gold.start();
				moneyLabel.setOpaque(true);
				headerPanel.add(moneyLabel);
			}
		}
	}
}
