package parctice;

import java.util.Random;
import java.util.Scanner;

class LadderTeacher {
	Scanner sc = new Scanner(System.in);

	final int HOOK = 1;
	final int SIZE = 9;

	int player; // 플레이어 수
	int ladder[][]; // null
	String[] menu; // null

	boolean[] isHook;
	boolean[] isOpen;

	int inputNumber() {		
		int number = -1;
		
		try {
			System.out.print("number : ");
			String input = sc.next();

			number = Integer.parseInt(input);

		} catch (Exception e) {
			System.err.println("입력값은 숫자만 허용합니다.");
		}

		return number;
	}

	void setPlayer() {
		while (player < 2) {
			System.out.print("Player");
			player = inputNumber();
		}
	}

	void setLadder() {
		Random ran = new Random();

		ladder = new int[SIZE][player];
		isHook = new boolean[player];

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < player - 1; j++) {
				// 왼쪽 후크
				ladder[i][j] = ran.nextInt(3) == HOOK ? HOOK : 0;

				if (ladder[i][j] == HOOK) {
					isHook[j] = true;
					ladder[i][++j] = HOOK; // 후크 달리면 오른쪽도 걸기
				}
			}

			if (i == SIZE - 1) {
				for (int j = 0; j < player-1; j++)
					if (!isHook[j]) {
						ladder = new int[SIZE][player];
						isHook = new boolean[player];
						i = -1;
						break;
					}
			}
		}
	}

	void setResult() {
		menu = new String[player];
		isOpen = new boolean[player];

		for (int i = 0; i < player; i++) {
			System.out.printf("%d menu : ", i + 1);
			menu[i] = sc.next();
		}
	}

	void setGame() {
		setPlayer();
		setLadder();
		setResult();
	}

	boolean isRun() {
		boolean isEnd = true;

		for (int i = 0; i < player; i++) {
			if (!isOpen[i])
				isEnd = false;
		}
		return !isEnd;
	}

	void printLadder() {
		for (int i = 0; i < player; i++) {
			System.out.print(i + 1 + " ");
		}
		System.out.println();

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < player; j++) {
				if (ladder[i][j] == HOOK) {
					System.out.print("├─┤ ");
					j++;
				} else
					System.out.print("│ ");
			}
			System.out.println();
		}

		for (int i = 0; i < player; i++)
			System.out.print(isOpen[i] ? "O " : "X ");
		System.out.println();
	}

	void play(int number) {
		// 예외처리 후,
		if (number >= 0 || number < SIZE) {
			int hookCnt = 0;

			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < player; j++) {
					if (ladder[0][number] == ladder[i][j]) {
						if (ladder[i][j] == HOOK) {
							hookCnt++;
						}
						if (hookCnt % 2 == 0)
							j++;
						else if (hookCnt % 2 == 1)
							j--;
					}
				}
			}
			
			// 결과 출력 (처리)
			if (isOpen[number]) {
				System.out.println("이미 고른 메뉴입니다.");
			} else {
				System.out.printf("%s 메뉴 당첨 !\n", menu[number]);
				isOpen[number] = true;
			}
		}
	}

	void run() {
		setGame();
		while (isRun()) {
			printLadder();
			int num = inputNumber();
			play(num);
		}
	}

}

public class Lv6_02 {

	public static void main(String[] args) {
		LadderTeacher ladderTeacher = new LadderTeacher();
		ladderTeacher.run();

	}

}