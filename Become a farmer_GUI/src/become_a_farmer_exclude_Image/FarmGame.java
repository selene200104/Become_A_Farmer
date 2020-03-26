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

	static int hp = 100; // �÷��̾� ü��
	static int money = 5000; // �÷��̾� ��

	static JPanel headerPanel = new JPanel();
	protected static Object moneyLabel;
	//MyListener listener = new MyListener();

	FarmGame() {

		/* ���� ��Ʈ��ȭ�� */
		introGame = new IntroGame();
		introGame.setLayout(null);

		gameStartButton = new JButton("���� ����");
		introGame.add(gameStartButton);
		gameStartButton.setBounds(170, 100, 100, 50);

		gameEndButton = new JButton("���� ����");
		introGame.add(gameEndButton);
		gameEndButton.setBounds(320, 100, 100, 50);

		add(introGame);

		/* ���� ���丮 ���� ȭ�� */
		gameStory = new GameStory();
		gameStory.setLayout(null);

		gameStoryEndButton = new JButton("GAME START");
		gameStory.add(gameStoryEndButton);
		gameStoryEndButton.setBounds(437, 425, 130, 30);

		/* ����ȭ�� (��ܹ� - ü�� / ��) */
		headerPanel.setLayout(null);
		headerPanel.setBounds(0, 0, 600, 50);

		hpLabel = new JLabel("         ü��: " + hp);
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

		/* ����ȭ�� (����ȭ��) */
		farmPanel = new FarmPanel();
		farmPanel.setLayout(null);
		farmPanel.setBounds(0, 50, 600, 450);

		house = new JButton("��");
		farmPanel.add(house);
		house.setBounds(30, 80, 150, 70);

		warehouse = new JButton("���۹� ������");
		farmPanel.add(warehouse);
		warehouse.setBounds(210, 80, 150, 70);

		market = new JButton("����");
		farmPanel.add(market);
		market.setBounds(390, 80, 150, 70);

		filed_1 = new JButton("�� 1");
		farmPanel.add(filed_1);
		filed_1.setBounds(30, 200, 70, 70);

		filed_2 = new JButton("�� 2");
		farmPanel.add(filed_2);
		filed_2.setBounds(140, 200, 70, 70);

		filed_3 = new JButton("�� 3");
		farmPanel.add(filed_3);
		filed_3.setBounds(250, 200, 70, 70);

		filed_4 = new JButton("�� 4");
		farmPanel.add(filed_4);
		filed_4.setBounds(360, 200, 70, 70);

		filed_5 = new JButton("�� 5");
		farmPanel.add(filed_5);
		filed_5.setBounds(470, 200, 70, 70);

		itemBox = new JButton("ITEM");
		farmPanel.add(itemBox);
		itemBox.setBounds(440, 400, 100, 30);

		potionBox = new JButton("ü�º����ϱ�");
		farmPanel.add(potionBox);
		potionBox.setBounds(300, 400, 130, 30);

		/* ���콺 �̺�Ʈ */
		// ���� ���۹�ư�� ������ ���ӽ��丮�� �Ѿ
		gameStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				gameStartButton.setVisible(false);
				gameStartButton.setVisible(false);
				introGame.setVisible(false);
				// System.out.println("���� �Ұ� ȭ�� ��ȯ");
				add(gameStory);
			}
		});

		// ���� �����ư�� ������ �������Ḧ Ȯ���ϴ� �˾�â�� ��
		gameEndButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int gameEndSelect = JOptionPane.showConfirmDialog(null, "������ �����Ͻðڽ��ϱ�?", "SYSTEM",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				// System.out.println(num);

				// �� ��ư ������ ������ ����
				if (gameEndSelect == 0) {
					System.exit(0);
				}
			}
		});

		// ���� ���丮 �����ư�� ������ ����ȭ������ ��ȯ
		gameStoryEndButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				gameStory.setVisible(false);
				add(headerPanel);
				add(farmPanel);
				farmPanel.setVisible(true);
				System.out.println("���� ȭ�� ��ȯ");

				// ���� ȭ������ ��ȯ�� ���ÿ� Ÿ�̸� �����尡 ������
				JLabel timerLabel = new JLabel();
				timerLabel.setBounds(200, 0, 200, 50);
				timerLabel.setBackground(Color.green);
				GameTime timer = new GameTime(timerLabel);
				timer.start();
				timerLabel.setOpaque(true);
				headerPanel.add(timerLabel);
			}
		});

		// ������ ��ư�� ������ �ش��ϴ� ������ �̵���
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

		// ���ǹڽ��� ������ �� ü�� ȸ�� �� ü�� ȸ�� ������ ������
		potionBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (hp < 100 && PotionOfHp.amount > 0) {
					System.out.println("��� �� ü��" + hp);
					System.out.println("��� �� ü������ ����" + PotionOfHp.amount);
					hp = hp + 10;
					PotionOfHp.amount = PotionOfHp.amount - 1;

					if (hp > 100) {
						hp = 100;
					}
					hpLabel.setText("         ü��: " + hp);
					// System.out.println("��� �� ü��"+hp);
					// System.out.println("��� �� ü������ ����"+PotionOfHp.count);
					// shoppingPriceLabel.setText(""+shoppingPrice);
				}

				else if (hp == 100) {
					System.out.println("��� �� ü������ ����" + PotionOfHp.amount);
					JOptionPane.showMessageDialog(null, "ü���� ������ ���̻� ����� �� �����!", "SYSTEM",
							JOptionPane.INFORMATION_MESSAGE);
				}

				else if (PotionOfHp.amount == 0) {
					System.out.println("��� �� ü������ ����" + PotionOfHp.amount);
					JOptionPane.showMessageDialog(null, "������ �����ϴ�!", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		// ���� â ���� �ʱ�ȭ
		setTitle("Become a farmer");
		setSize(600, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	}

}
