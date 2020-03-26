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

	// 정보를 보여주는 패널
	static JPanel informationPanel = new JPanel();
	// 선택기능이 있는 버튼들이 모여있는 패널
	static JPanel selectPanel = new JPanel();

	// 씨앗 선택 횟수
	static int seedsSelectCount = 0;
	// 밭의 정보 값을 나타냄(0 = 거름주기 완료 / 1 = 농작물심기 완료 / 2 = 농산물제조완료)
	static int fieldState = 0;

	Field_2() {

		// 밭의 기본 설정
		setTitle("밭");
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
		 * 이미지를 넣을 라벨과 아이콘 설정 ImageIcon statusImage = new
		 * ImageIcon("../images/felid_150x150.jpg");
		 * System.out.println("statusImage"+statusImage); JLabel imageLabel = new
		 * JLabel(statusImage);
		 * 
		 * //imageLabel.setText(" 레이블 글자 "); imageLabel.setBounds(20, 20, 150, 150);
		 * container.add(imageLabel);
		 */

		// 거름주기 버튼
		JButton fertilizer = new JButton("<html><font size=-1>거름" + "<p>주기</html>");
		fertilizer.setBounds(20, 10, 90, 60);
		fertilizer.setFocusPainted(false);
		fertilizer.setBackground(Color.white);
		fertilizer.setOpaque(true);
		selectPanel.add(fertilizer);

		// 농작물을 심을 수 있는 버튼
		JButton crops = new JButton("<html><font size=-1>농작물" + "<p>심기</html>");
		crops.setBounds(120, 10, 90, 60);
		crops.setFocusPainted(false);
		crops.setBackground(Color.white);
		crops.setOpaque(true);
		fertilizer.setOpaque(true);
		selectPanel.add(crops);

		// 수확하기 버튼
		JButton harvest = new JButton("<html><font size=-1>수확" + "<p>하기</html>");
		harvest.setBounds(220, 10, 90, 60);
		harvest.setFocusPainted(false);
		harvest.setBackground(Color.white);
		harvest.setOpaque(true);// crops.setOpaque(true);fertilizer.setOpaque(true);
		harvest.setVisible(true);
		selectPanel.add(harvest);

		// 상추심기 버튼
		JButton lettuceSeeds = new JButton("상추씨앗");
		lettuceSeeds.setBounds(120, 10, 90, 20);
		lettuceSeeds.setFocusPainted(false);
		lettuceSeeds.setBackground(Color.white);
		lettuceSeeds.setOpaque(true);
		lettuceSeeds.setVisible(false);
		selectPanel.add(lettuceSeeds);

		// 당근심기 버튼
		JButton carrotSeeds = new JButton("당근씨앗");
		carrotSeeds.setBounds(120, 30, 90, 20);
		carrotSeeds.setFocusPainted(false);
		carrotSeeds.setBackground(Color.white);
		carrotSeeds.setOpaque(true);
		carrotSeeds.setVisible(false);
		selectPanel.add(carrotSeeds);

		// 무심기 버튼
		JButton radishSeeds = new JButton("무씨앗");
		radishSeeds.setBounds(120, 50, 90, 20);
		radishSeeds.setFocusPainted(false);
		radishSeeds.setBackground(Color.white);
		radishSeeds.setOpaque(true);
		radishSeeds.setVisible(false);
		selectPanel.add(radishSeeds);

		// System.out.println("창을 열었을때 필드 값: "+fieldState);

		// 거름주기 버튼 눌렀을시 동작
		fertilizer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				// 거름개수가 0 이상이면 거름을 줄 수 있게 함
				if (Fertilize.amount > 0) {
					Fertilize.amount--;
					// 거름을 주면 밭의 정보 값이 올라감
					fieldState++;
					System.out.println("거름을 사용해서 필드 값 업그레이드 " + fieldState);
					// 거름을 주면 체력이 10 깎임
					FarmGame.hp = FarmGame.hp - 10;
					FarmGame.hpLabel.setText("         체력: " + FarmGame.hp);
					// System.out.println("남은 비료 : "+FarmGame.fertilizerCount+"개");
					// System.out.println("거름 주고 난 체력은 : "+FarmGame.hp);
					// 만약 거름 개수가 0이면 경고창이 뜬다.
				} else if (Fertilize.amount == 0) {
					JOptionPane.showMessageDialog(null, "비료가 없어요", "SYSTEM", JOptionPane.ERROR_MESSAGE);
				}
				// 밭의 정보 값이 0이상이면 거름주기 버튼이 비활성화가 된다.
				if (fieldState > 0) {
					fertilizer.setEnabled(false);
				}
			}
		});

		// 씨앗심기 버튼 눌렀을시 동작
		crops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// FarmGame.filedValue++;
				// 밭의 정보 값이 1이면 씨앗 심기 버튼을 누를 수 있고, 아니면 누를 수 없음.
				if (fieldState == 1) {
					crops.setVisible(false);
					lettuceSeeds.setVisible(true);
					carrotSeeds.setVisible(true);
					radishSeeds.setVisible(true);

					// System.out.println("선택하는 버튼이 뜸");
				} else {
					JOptionPane.showMessageDialog(null, "거름을 먼저 주세요", "SYSTEM", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// 쌍추씨앗심기 버튼 눌렀을시 동작
		lettuceSeeds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				// 씨앗선택횟수가 0이어야 누를 수 있다.
				if (seedsSelectCount == 0) {

					if (Lettuce.seedsAmount > 0) {
						lettuceSeeds.setText("▶ 상추씨앗");
						FarmGame.hp = FarmGame.hp - 3;
						FarmGame.hpLabel.setText("         체력: " + FarmGame.hp);

						// System.out.println(FarmGame.hp);
						// System.out.println("전 필드값: "+fieldState);

						// 상추 성장 스레드 시작
						LettuceGrowthOfField2 lettuce = new LettuceGrowthOfField2();
						lettuce.start();

						/*
						 * if(Filed2_carrot.carrotCount != 0) { filedValue++;
						 * //System.out.println("식물을 심어서 필드 값 업그레이드 "+filedValue); }
						 */

						// System.out.println("후 필드값: "+filedValue);

						// 상추 성장이 끝나면 씨앗선택 횟수가 1이 된다.
						seedsSelectCount++;
						// System.out.println("당근 심은 후 씨앗선택값: "+seedsSelectCount);
					} else {
						JOptionPane.showMessageDialog(null, "씨앗이 없습니다.", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		// 당근씨앗심기 버튼 눌렀을시 동작
		carrotSeeds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// 씨앗선택횟수가 0이어야 누를 수 있다.
				if (seedsSelectCount == 0) {

					if (Carrot.seedsAmount > 0) {
						carrotSeeds.setText("▶ 당근씨앗");
						FarmGame.hp = FarmGame.hp - 3;
						FarmGame.hpLabel.setText("         체력: " + FarmGame.hp);

						// System.out.println(FarmGame.hp);
						// System.out.println("전 필드값: "+fieldState);

						// 당근 성장 스레드 시작
						CarrotGrowthOfField2 carrotGrow = new CarrotGrowthOfField2();
						carrotGrow.start();

						/*
						 * if(Filed2_carrot.carrotCount != 0) { filedValue++;
						 * //System.out.println("식물을 심어서 필드 값 업그레이드 "+filedValue); }
						 */

						// System.out.println("후 필드값: "+filedValue);

						// 당근 성장이 끝나면 씨앗선택 횟수가 1이 된다.
						seedsSelectCount++;
						// System.out.println("당근 심은 후 씨앗선택값: "+seedsSelectCount);
					} else {
						JOptionPane.showMessageDialog(null, "씨앗이 없습니다.", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		// 무씨앗심기 버튼 눌렀을시 동작
		radishSeeds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// 씨앗선택횟수가 0이어야 누를 수 있다.
				if (seedsSelectCount == 0) {

					if (Radish.seedsAmount > 0) {
						radishSeeds.setText("▶ 무씨앗");
						FarmGame.hp = FarmGame.hp - 3;
						FarmGame.hpLabel.setText("         체력: " + FarmGame.hp);

						// System.out.println(FarmGame.hp);
						// System.out.println("전 필드값: "+fieldState);

						// 무 성장 스레드 시작
						RadishGrowthOfField2 radishGrow = new RadishGrowthOfField2();
						radishGrow.start();

						// 무 성장이 끝나면 씨앗선택 횟수가 1이 된다.
						seedsSelectCount++;
						// System.out.println("무 심은 후 씨앗선택값: "+seedsSelectCount);
					} else {
						JOptionPane.showMessageDialog(null, "씨앗이 없습니다.", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		// 수확하기 버튼 눌렀을시 동작
		harvest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("삭제전 씨앗 선택 값" + seedsSelectCount);

				if (fieldState == 2) {
					FarmGame.hp = FarmGame.hp - 5;

					// 수확가능한 상추 개수가 0개 이상일 때
					if (LettuceGrowthOfField2.lettuceAmount > 0) {

						// 원래있던 상추 갯수에 수확한 상추 갯수를 추가하고 수확한 값을 0으로 초기화 시킴
						Lettuce.amount += LettuceGrowthOfField2.lettuceAmount;
						LettuceGrowthOfField2.lettuceAmount -= LettuceGrowthOfField2.lettuceAmount;
						System.out.println(LettuceGrowthOfField2.lettuceAmount);

						// 씨앗 선택 횟수랑 밭 정보도 0으로 초기화 시킨다.
						seedsSelectCount -= seedsSelectCount;
						fieldState -= fieldState;

						// System.out.println("삭제후 씨앗 선택 값"+seedsSelectCount);
						// System.out.println("삭제후 수확 가능한 상추 개수"+LettuceGrowthOfFiled2.lettuceAmount);
						// System.out.println("삭제후 필드 값"+fieldState);

						// 창을 닫으면서 그 전 데이터들을 초기화한다.
						selectPanel.removeAll();
						// dispose();

						JOptionPane.showMessageDialog(null, "상추를 수확했어요.", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
					}

					// 수확가능한 당근 개수가 0개 이상일때
					if (CarrotGrowthOfField2.carrotAmount > 0) {

						// 원래 있던 당근 갯수에 수확한 당근 갯수를 추가하고 수확한 값을 0으로 초기화 시킴
						Carrot.amount += CarrotGrowthOfField2.carrotAmount;
						CarrotGrowthOfField2.carrotAmount -= CarrotGrowthOfField2.carrotAmount;
						System.out.println(CarrotGrowthOfField2.carrotAmount);

						// 씨앗 선택 횟수랑 밭 정보도 0으로 초기화 시킨다.
						seedsSelectCount -= seedsSelectCount;
						fieldState -= fieldState;

						// System.out.println("삭제후 씨앗 선택 값"+seedsSelectCount);
						// System.out.println("삭제후 수확 가능한 당근 개수"+CarrotGrowthOfFiled2.carrotAmount);
						// System.out.println("삭제후 필드 값"+fieldState);

						// 창을 닫으면서 그 전 데이터들을 초기화한다.
						selectPanel.removeAll();
						// dispose();

						JOptionPane.showMessageDialog(null, "당근을 수확했어요.", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
					}

					// 수확가능한 무 개수가 0개 이상일때
					if (RadishGrowthOfField2.radishAmount > 0) {

						// 원래 있던 무 갯수에 수확한 무 갯수를 추가하고 수확한 값을 0으로 초기화 시킴
						Radish.amount += RadishGrowthOfField2.radishAmount;
						RadishGrowthOfField2.radishAmount -= RadishGrowthOfField2.radishAmount;
						System.out.println(RadishGrowthOfField2.radishAmount);

						// 씨앗 선택 횟수랑 밭 정보도 0으로 초기화 시킨다.
						seedsSelectCount -= seedsSelectCount;
						fieldState -= fieldState;

						// System.out.println("삭제후 씨앗 선택 값"+seedsSelectCount);
						// System.out.println("삭제후 수확 가능한 무 개수"+RadishGrowthOfFiled2.radishAmount);
						// System.out.println("삭제후 필드 값"+fieldState);

						// 창을 닫으면서 그 전 데이터들을 초기화한다.
						selectPanel.removeAll();
						// dispose();

						JOptionPane.showMessageDialog(null, "무를 수확했어요.", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "지금은 수확할 수 없어요.", "SYSTEM", JOptionPane.INFORMATION_MESSAGE);
				}
				dispose();
			}
		});

	}
}
