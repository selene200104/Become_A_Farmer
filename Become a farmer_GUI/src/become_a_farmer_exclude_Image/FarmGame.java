package become_a_farmer_exclude_Image;

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
	private JButton warehouse;
	private JButton market;
	private JButton itemBox;
	private JButton potionBox;
	private JButton filed_1, filed_2, filed_3, filed_4, filed_5;

	static JLabel hpLabel;

	static int hp = 100; // 플레이어 체력
	static int money = 5000; // 플레이어 돈

	static JPanel headerPanel = new JPanel();
	protected static Object moneyLabel;
	//MyListener listener = new MyListener();

	FarmGame() {

		/* 게임 인트로화면 */
		introGame = new IntroGame();
		introGame.setLayout(null);

		gameStartButton = new JButton("게임 시작");
		introGame.add(gameStartButton);
		gameStartButton.setBounds(170, 100, 100, 50);

		gameEndButton = new JButton("게임 종료");
		introGame.add(gameEndButton);
		gameEndButton.setBounds(320, 100, 100, 50);

		add(introGame);

		/* 게임 스토리 설명 화면 */
		gameStory = new GameStory();
		gameStory.setLayout(null);

		gameStoryEndButton = new JButton("GAME START");
		gameStory.add(gameStoryEndButton);
		gameStoryEndButton.setBounds(437, 425, 130, 30);

		/* 게임화면 (상단바 - 체력 / 돈) */
		headerPanel.setLayout(null);
		headerPanel.setBounds(0, 0, 600, 50);

		hpLabel = new JLabel("         체력: " + hp);
		hpLabel.setBounds(0, 0, 200, 50);
		hpLabel.setBackground(Color.white);
		hpLabel.setOpaque(true);
		headerPanel.add(hpLabel);

		JLabel moneyLabel = new JLabel();
		moneyLabel.setText("        G: " + money);
		moneyLabel.setBounds(400, 0, 200, 50);
		moneyLabel.setBackground(Color.pink);
		moneyLabel.setOpaque(true);
		headerPanel.add(moneyLabel);

		/* 게임화면 (농장화면) */
		farmPanel = new FarmPanel();
		farmPanel.setLayout(null);
		farmPanel.setBounds(0, 50, 600, 450);

		house = new JButton("집");
		farmPanel.add(house);
		house.setBounds(30, 80, 150, 70);

		warehouse = new JButton("농작물 보관함");
		farmPanel.add(warehouse);
		warehouse.setBounds(210, 80, 150, 70);

		market = new JButton("시장");
		farmPanel.add(market);
		market.setBounds(390, 80, 150, 70);

		filed_1 = new JButton("밭 1");
		farmPanel.add(filed_1);
		filed_1.setBounds(30, 200, 70, 70);

		filed_2 = new JButton("밭 2");
		farmPanel.add(filed_2);
		filed_2.setBounds(140, 200, 70, 70);

		filed_3 = new JButton("밭 3");
		farmPanel.add(filed_3);
		filed_3.setBounds(250, 200, 70, 70);

		filed_4 = new JButton("밭 4");
		farmPanel.add(filed_4);
		filed_4.setBounds(360, 200, 70, 70);

		filed_5 = new JButton("밭 5");
		farmPanel.add(filed_5);
		filed_5.setBounds(470, 200, 70, 70);

		itemBox = new JButton("ITEM");
		farmPanel.add(itemBox);
		itemBox.setBounds(440, 400, 100, 30);

		potionBox = new JButton("체력보충하기");
		farmPanel.add(potionBox);
		potionBox.setBounds(300, 400, 130, 30);

		/* 마우스 이벤트 */
		// 게임 시작버튼을 누르면 게임스토리로 넘어감
		gameStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				gameStartButton.setVisible(false);
				gameStartButton.setVisible(false);
				introGame.setVisible(false);
				// System.out.println("게임 소개 화면 전환");
				add(gameStory);
			}
		});

		// 게임 종료버튼을 누르면 게임종료를 확인하는 팝업창이 뜸
		gameEndButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int gameEndSelect = JOptionPane.showConfirmDialog(null, "게임을 종료하시겠습니까?", "SYSTEM",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				// System.out.println(num);

				// 예 버튼 누르면 게임이 꺼짐
				if (gameEndSelect == 0) {
					System.exit(0);
				}
			}
		});

		// 게임 스토리 종료버튼을 누르면 게임화면으로 전환
		gameStoryEndButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				gameStory.setVisible(false);
				add(headerPanel);
				add(farmPanel);
				farmPanel.setVisible(true);
				System.out.println("농장 화면 전환");

				// 게임 화면으로 전환과 동시에 타이머 스레드가 실행됌
				JLabel timerLabel = new JLabel();
				timerLabel.setBounds(200, 0, 200, 50);
				timerLabel.setBackground(Color.green);
				GameTime timer = new GameTime(timerLabel);
				timer.start();
				timerLabel.setOpaque(true);
				headerPanel.add(timerLabel);
			}
		});

		// 각각의 버튼을 누르면 해당하는 곳으로 이동함
		house.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				House house = new House();
			}
		});

		market.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Market market = new Market();
			}
		});

		itemBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				ItemBox itemBox = new ItemBox();
			}
		});

		warehouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Warehouse warehouse = new Warehouse();
			}
		});

		filed_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Field_1 filed_1 = new Field_1();
			}
		});

		filed_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Field_2 filed_2 = new Field_2();
			}
		});

		filed_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Field_3 filed_3 = new Field_3();
			}
		});

		filed_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Field_4 filed_4 = new Field_4();
			}
		});

		filed_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Field_5 filed_5 = new Field_5();
			}
		});

		// 포션박스를 눌렀을 때 체력 회복 및 체력 회복 포션을 관리함
		potionBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (hp < 100 && PotionOfHp.amount > 0) {
					System.out.println("사용 전 체력" + hp);
					System.out.println("사용 전 체력포션 개수" + PotionOfHp.amount);
					hp = hp + 10;
					PotionOfHp.amount = PotionOfHp.amount - 1;

					if (hp > 100) {
						hp = 100;
					}
					hpLabel.setText("         체력: " + hp);
					// System.out.println("사용 후 체력"+hp);
					// System.out.println("사용 후 체력포션 개수"+PotionOfHp.count);
					// shoppingPriceLabel.setText(""+shoppingPrice);
				}

				else if (hp == 100) {
					System.out.println("사용 전 체력포션 개수" + PotionOfHp.amount);
					JOptionPane.showMessageDialog(null, "체력이 꽉차서 더이상 사용할 수 없어요!", "SYSTEM",
							JOptionPane.INFORMATION_MESSAGE);
				}

				else if (PotionOfHp.amount == 0) {
					System.out.println("사용 전 체력포션 개수" + PotionOfHp.amount);
					JOptionPane.showMessageDialog(null, "포션이 없습니다!", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		// 게임 창 구성 초기화
		setTitle("Become a farmer");
		setSize(600, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	}

}
