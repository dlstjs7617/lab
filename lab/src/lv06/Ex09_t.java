package lv06;
	/*
	 * # 사다리 게임(N플레이어)
	 */

import java.util.Random;
import java.util.Scanner;

class Ladder_t{
	
	Scanner sc = new Scanner(System.in);
	
	
	
	
	final int HOOK = 1;
	final int HEIGHT = 9;
	
	int player;			//플레이어 수
	int ladder[][];
	boolean[] isHook;
	boolean[] isOpen;
	String[] menu;
	
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
		while(player < 2) {
			System.out.print("Player");
			player = inputNumber();
		}
	}
	
	void setLadder() {

		Random ran = new Random();
		
		ladder = new int[HEIGHT][player];
		isHook = new boolean[player];
		
		for(int i=0; i<HEIGHT; i++) {
			for(int j=0; j<player-1; j++) {
				// 왼쪽 후크 달고,
				ladder[i][j] = ran.nextInt(3) == HOOK ? HOOK : 0;
				
				if(ladder[i][j] == HOOK) {
					isHook[j] = true;
					ladder[i][++j] = HOOK;	// 오른쪽 후크 달기					
				}
			}
			
			if(i == HEIGHT -1) {
				for(int j=0; j<player-1; j++) {
					if(!isHook[j]) {
						ladder = new int[HEIGHT][player];
						isHook = new boolean[player];
						i = -1;
						break;
					}
				}
			}
		}
	}
	

	
	void setResult() {
		menu = new String[player];
		isOpen = new boolean[player];
		
		for(int i=0; i<player; i++) {
			System.out.printf("%d menu : ", i+1	);
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
		
		for(int i=0; i<player; i++) {
			if(!isOpen[i])
				isEnd = false;
		}
		return !isEnd;
	}
	void printLadder() {
		for(int i=0; i<player; i++) {
			System.out.print(i+1 + " ");
		}
		System.out.println();
		
		for(int i=0; i<HEIGHT; i++) {
			for(int j=0; j<player; j++) {
				if(ladder[i][j] == HOOK) {
					System.out.print("├─┤ ");
					j++;
				}else
					System.out.print("│ ");
			}
			System.out.println();
		}
		
		for(int i=0; i<player; i++)
			System.out.print(isOpen[i] ? "0 " : "X ");
		System.out.println();
	}
	
	void play(int number) {
		// 예외처리 후,
		if(number < 1 || number > player)
			return;
		// 결과 출력(처리)
		int x = number-1;
		
		for(int y=0; y<HEIGHT; y++) {
			if(ladder[y][x] == HOOK) {
				int cnt = 0;
				for(int i=0; i<x; i++) {
					if(ladder[y][i] == HOOK)
						cnt++;
				}
				if(cnt % 2 == 0) {
					x ++;
				}else {
					x --;
				}
			}
		}
		
		if(!isOpen[x]) {
			System.out.printf("결과 : %s 당첨 \n", menu[x]);
			isOpen[x] = true;
		}else
			System.out.println("이미 고른 번호입니다.");
	}
	
	
	void run() {
		setGame();
		while(isRun()) {
			printLadder();
			int num = inputNumber();
			play(num);
		}
	}
	
	
}



public class Ex09_t {

	public static void main(String[] args) {
		
		Ladder_t Ladder_t = new Ladder_t();
		Ladder_t.run();
	}

}
