package become_a_farmer_exclude_Image;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Field_2 extends JFrame {

	Container container;
	// ImageIcon filed;
	JLabel imageLabel;

	// ������ �����ִ� �г�
	static JPanel informationPanel = new JPanel();
	// ���ñ���� �ִ� ��ư���� ���ִ� �г�
	static JPanel selectPanel = new JPanel();

	// ���� ���� Ƚ��
	static int seedsSelectCount = 0;
	// ���� ���� ���� ��Ÿ��(0 = �Ÿ��ֱ� �Ϸ� / 1 = ���۹��ɱ� �Ϸ� / 2 = ��깰�����Ϸ�)
	static int fieldState = 0;

	Field_2() {

		// ���� �⺻ ����
		setTitle("��");
		setSize(350, 120);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());

		container = getContentPane();
		container.setLayout(null);
		container.setBackground(Color.WHITE);

		/*
		 * informationPanel.setLayout(null); informationPanel.setBounds(0, 0, 350, 200);
		 * informationPanel.setBackground(Color.pink); container.add(informationPanel);
		 */

		selectPanel.setLayout(null);
		selectPanel.setBounds(0, 0, 350, 90);
		selectPanel.setBackground(Color.yellow);
		container.add(selectPanel);

		/*
		 * �̹����� ���� �󺧰� ������ ���� ImageIcon statusImage = new
		 * ImageIcon("../images/felid_150x150.jpg");
		 * System.out.println("statusImage"+statusImage); JLabel imageLabel = new
		 * JLabel(statusImage);
		 * 
		 * //imageLabel.setText(" ���̺� ���� "); imageLabel.setBounds(20, 20, 150, 150);
		 * container.add(imageLabel);
		 */

		// �Ÿ��ֱ� ��ư
		JButton fertilizer = new JButton("<html><font size=-1>�Ÿ�" + "<p>�ֱ�</html>");
		fertilizer.setBounds(20, 10, 90, 60);
		fertilizer.setFocusPainted(false);
		fertilizer.setBackground(Color.white);
		fertilizer.setOpaque(true);
		selectPanel.add(fertilizer);

		// ���۹��� ���� �� �ִ� ��ư
		JButton crops = new JButton("<html><font size=-1>���۹�" + "<p>�ɱ�</html>");
		crops.setBounds(120, 10, 90, 60);
		crops.setFocusPainted(false);
		crops.setBackground(Color.white);
		crops.setOpaque(true);
		fertilizer.setOpaque(true);
		selectPanel.add(crops);

		// ��Ȯ�ϱ� ��ư
		JButton harvest = new JButton("<html><font size=-1>��Ȯ" + "<p>�ϱ�</html>");
		harvest.setBounds(220, 10, 90, 60);
		harvest.setFocusPainted(false);
		harvest.setBackground(Color.white);
		harvest.setOpaque(true);// crops.setOpaque(true);fertilizer.setOpaque(true);
		harvest.setVisible(true);
		selectPanel.add(harvest);

		// ���߽ɱ� ��ư
		JButton lettuceSeeds = new JButton("���߾���");
		lettuceSeeds.setBounds(120, 10, 90, 20);
		lettuceSeeds.setFocusPainted(false);
		lettuceSeeds.setBackground(Color.white);
		lettuceSeeds.setOpaque(true);
		lettuceSeeds.setVisible(false);
		selectPanel.add(lettuceSeeds);

		// ��ٽɱ� ��ư
		JButton carrotSeeds = new JButton("��پ���");
		carrotSeeds.setBounds(120, 30, 90, 20);
		carrotSeeds.setFocusPainted(false);
		carrotSeeds.setBackground(Color.white);
		carrotSeeds.setOpaque(true);
		carrotSeeds.setVisible(false);
		selectPanel.add(carrotSeeds);

		// ���ɱ� ��ư
		JButton radishSeeds = new JButton("������");
		radishSeeds.setBounds(120, 50, 90, 20);
		radishSeeds.setFocusPainted(false);
		radishSeeds.setBackground(Color.white);
		radishSeeds.setOpaque(true);
		radishSeeds.setVisible(false);
		selectPanel.add(radishSeeds);

		// System.out.println("â�� �������� �ʵ� ��: "+fieldState);

		// �Ÿ��ֱ� ��ư �������� ����
		fertilizer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				// �Ÿ������� 0 �̻��̸� �Ÿ��� �� �� �ְ� ��
				if (Fertilize.amount > 0) {
					Fertilize.amount--;
					// �Ÿ��� �ָ� ���� ���� ���� �ö�
					fieldState++;
					System.out.println("�Ÿ��� ����ؼ� �ʵ� �� ���׷��̵� " + fieldState);
					// �Ÿ��� �ָ� ü���� 10 ����
					FarmGame.hp = FarmGame.hp - 10;
					FarmGame.hpLabel.setText("         ü��: " + FarmGame.hp);
					// System.out.println("���� ��� : "+FarmGame.fertilizerCount+"��");
					// System.out.println("�Ÿ� �ְ� �� ü���� : "+FarmGame.hp);
					// ���� �Ÿ� ������ 0�̸� ���â�� ���.
				} else if (Fertilize.amount == 0) {
					JOptionPane.showMessageDialog(null, "��ᰡ �����", "SYSTEM", JOptionPane.ERROR_MESSAGE);
				}
				// ���� ���� ���� 0�̻��̸� �Ÿ��ֱ� ��ư�� ��Ȱ��ȭ�� �ȴ�.
				if (fieldState > 0) {
					fertilizer.setEnabled(false);
				}
			}
		});

		// ���ѽɱ� ��ư �������� ����
		crops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// FarmGame.filedValue++;
				// ���� ���� ���� 1�̸� ���� �ɱ� ��ư�� ���� �� �ְ�, �ƴϸ� ���� �� ����.
				if (fieldState == 1) {
					crops.setVisible(false);
					lettuceSeeds.setVisible(true);
					carrotSeeds.setVisible(true);
					radishSeeds.setVisible(true);

					// System.out.println("�����ϴ� ��ư�� ��");
				} else {
					JOptionPane.showMessageDialog(null, "�Ÿ��� ���� �ּ���", "SYSTEM", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// ���߾��ѽɱ� ��ư �������� ����
		lettuceSeeds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				// ���Ѽ���Ƚ���� 0�̾�� ���� �� �ִ�.
				if (seedsSelectCount == 0) {

					if (Lettuce.seedsAmount > 0) {
						lettuceSeeds.setText("�� ���߾���");
						FarmGame.hp = FarmGame.hp - 3;
						FarmGame.hpLabel.setText("         ü��: " + FarmGame.hp);

						// System.out.println(FarmGame.hp);
						// System.out.println("�� �ʵ尪: "+fieldState);

						// ���� ���� ������ ����
						LettuceGrowthOfField2 lettuce = new LettuceGrowthOfField2();
						lettuce.start();

						/*
						 * if(Filed2_carrot.carrotCount != 0) { filedValue++;
						 * //System.out.println("�Ĺ��� �ɾ �ʵ� �� ���׷��̵� "+filedValue); }
						 */

						// System.out.println("�� �ʵ尪: "+filedValue);

						// ���� ������ ������ ���Ѽ��� Ƚ���� 1�� �ȴ�.
						seedsSelectCount++;
						// System.out.println("��� ���� �� ���Ѽ��ð�: "+seedsSelectCount);
					} else {
						JOptionPane.showMessageDialog(null, "������ �����ϴ�.", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		// ��پ��ѽɱ� ��ư �������� ����
		carrotSeeds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// ���Ѽ���Ƚ���� 0�̾�� ���� �� �ִ�.
				if (seedsSelectCount == 0) {

					if (Carrot.seedsAmount > 0) {
						carrotSeeds.setText("�� ��پ���");
						FarmGame.hp = FarmGame.hp - 3;
						FarmGame.hpLabel.setText("         ü��: " + FarmGame.hp);

						// System.out.println(FarmGame.hp);
						// System.out.println("�� �ʵ尪: "+fieldState);

						// ��� ���� ������ ����
						CarrotGrowthOfField2 carrotGrow = new CarrotGrowthOfField2();
						carrotGrow.start();

						/*
						 * if(Filed2_carrot.carrotCount != 0) { filedValue++;
						 * //System.out.println("�Ĺ��� �ɾ �ʵ� �� ���׷��̵� "+filedValue); }
						 */

						// System.out.println("�� �ʵ尪: "+filedValue);

						// ��� ������ ������ ���Ѽ��� Ƚ���� 1�� �ȴ�.
						seedsSelectCount++;
						// System.out.println("��� ���� �� ���Ѽ��ð�: "+seedsSelectCount);
					} else {
						JOptionPane.showMessageDialog(null, "������ �����ϴ�.", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		// �����ѽɱ� ��ư �������� ����
		radishSeeds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// ���Ѽ���Ƚ���� 0�̾�� ���� �� �ִ�.
				if (seedsSelectCount == 0) {

					if (Radish.seedsAmount > 0) {
						radishSeeds.setText("�� ������");
						FarmGame.hp = FarmGame.hp - 3;
						FarmGame.hpLabel.setText("         ü��: " + FarmGame.hp);

						// System.out.println(FarmGame.hp);
						// System.out.println("�� �ʵ尪: "+fieldState);

						// �� ���� ������ ����
						RadishGrowthOfField2 radishGrow = new RadishGrowthOfField2();
						radishGrow.start();

						// �� ������ ������ ���Ѽ��� Ƚ���� 1�� �ȴ�.
						seedsSelectCount++;
						// System.out.println("�� ���� �� ���Ѽ��ð�: "+seedsSelectCount);
					} else {
						JOptionPane.showMessageDialog(null, "������ �����ϴ�.", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		// ��Ȯ�ϱ� ��ư �������� ����
		harvest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("������ ���� ���� ��" + seedsSelectCount);

				if (fieldState == 2) {
					FarmGame.hp = FarmGame.hp - 5;

					// ��Ȯ������ ���� ������ 0�� �̻��� ��
					if (LettuceGrowthOfField2.lettuceAmount > 0) {

						// �����ִ� ���� ������ ��Ȯ�� ���� ������ �߰��ϰ� ��Ȯ�� ���� 0���� �ʱ�ȭ ��Ŵ
						Lettuce.amount += LettuceGrowthOfField2.lettuceAmount;
						LettuceGrowthOfField2.lettuceAmount -= LettuceGrowthOfField2.lettuceAmount;
						System.out.println(LettuceGrowthOfField2.lettuceAmount);

						// ���� ���� Ƚ���� �� ������ 0���� �ʱ�ȭ ��Ų��.
						seedsSelectCount -= seedsSelectCount;
						fieldState -= fieldState;

						// System.out.println("������ ���� ���� ��"+seedsSelectCount);
						// System.out.println("������ ��Ȯ ������ ���� ����"+LettuceGrowthOfFiled2.lettuceAmount);
						// System.out.println("������ �ʵ� ��"+fieldState);

						// â�� �����鼭 �� �� �����͵��� �ʱ�ȭ�Ѵ�.
						selectPanel.removeAll();
						// dispose();

						JOptionPane.showMessageDialog(null, "���߸� ��Ȯ�߾��.", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
					}

					// ��Ȯ������ ��� ������ 0�� �̻��϶�
					if (CarrotGrowthOfField2.carrotAmount > 0) {

						// ���� �ִ� ��� ������ ��Ȯ�� ��� ������ �߰��ϰ� ��Ȯ�� ���� 0���� �ʱ�ȭ ��Ŵ
						Carrot.amount += CarrotGrowthOfField2.carrotAmount;
						CarrotGrowthOfField2.carrotAmount -= CarrotGrowthOfField2.carrotAmount;
						System.out.println(CarrotGrowthOfField2.carrotAmount);

						// ���� ���� Ƚ���� �� ������ 0���� �ʱ�ȭ ��Ų��.
						seedsSelectCount -= seedsSelectCount;
						fieldState -= fieldState;

						// System.out.println("������ ���� ���� ��"+seedsSelectCount);
						// System.out.println("������ ��Ȯ ������ ��� ����"+CarrotGrowthOfFiled2.carrotAmount);
						// System.out.println("������ �ʵ� ��"+fieldState);

						// â�� �����鼭 �� �� �����͵��� �ʱ�ȭ�Ѵ�.
						selectPanel.removeAll();
						// dispose();

						JOptionPane.showMessageDialog(null, "����� ��Ȯ�߾��.", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
					}

					// ��Ȯ������ �� ������ 0�� �̻��϶�
					if (RadishGrowthOfField2.radishAmount > 0) {

						// ���� �ִ� �� ������ ��Ȯ�� �� ������ �߰��ϰ� ��Ȯ�� ���� 0���� �ʱ�ȭ ��Ŵ
						Radish.amount += RadishGrowthOfField2.radishAmount;
						RadishGrowthOfField2.radishAmount -= RadishGrowthOfField2.radishAmount;
						System.out.println(RadishGrowthOfField2.radishAmount);

						// ���� ���� Ƚ���� �� ������ 0���� �ʱ�ȭ ��Ų��.
						seedsSelectCount -= seedsSelectCount;
						fieldState -= fieldState;

						// System.out.println("������ ���� ���� ��"+seedsSelectCount);
						// System.out.println("������ ��Ȯ ������ �� ����"+RadishGrowthOfFiled2.radishAmount);
						// System.out.println("������ �ʵ� ��"+fieldState);

						// â�� �����鼭 �� �� �����͵��� �ʱ�ȭ�Ѵ�.
						selectPanel.removeAll();
						// dispose();

						JOptionPane.showMessageDialog(null, "���� ��Ȯ�߾��.", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "������ ��Ȯ�� �� �����.", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
				}
				dispose();
			}
		});

	}
}
