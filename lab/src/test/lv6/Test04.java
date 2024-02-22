package test.lv6;
//Lv6 Test (클래스 + 메소드)

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 시작 12:15
// 종료 14:15
// 소요 01:00

/*
 * 4.
 * 
 * 사다리 게임(N플레이어)
 * HEIGHT : 9
 */

class Ladder {
	
	Scanner sc = new Scanner(System.in);
	
	final int HEIGHT = 9;
	final int HOOK = 1;
	int player;
	
	int[][] ladder;
	String[] menu;
	
	boolean[] isHook;
	boolean[] isOpen;
	void setGame() {
		setPlayer();
		setHook();
		setMenu();
	}
	
	void setPlayer() {
		while(player < 2) {
			System.out.print("플레이어");
			player = inputNumber();			
		}
		
		menu = new String[player];
		isOpen = new boolean[player];
	}
	
	void setHook() {
		Random ran = new Random();
		
		while(true) {
			ladder = new int[HEIGHT][player];			
			isHook = new boolean[player];
			
			for(int i=0; i<HEIGHT; i++) {
				for(int j=0; j<player-1; j++) {
					int rNum = ran.nextInt(3);
					if(rNum == HOOK) {
						isHook[j] = true;
						ladder[i][j] = HOOK;
						ladder[i][++j] = HOOK;
					}
				}
			}
			boolean set = true;
			isHook[player-1] = true;
			for(int i=0; i<player; i++) {
				if(isHook[i] == false)
					set = false;
			}
			
			if(set)
				break;
		}
		
	}
	
	void setMenu() {
		for(int i=0; i<player; i++) {
			System.out.printf("%d번째 메뉴입력:",i);
			String inputMenu = sc.next();
			menu[i] = inputMenu;
		}
	}
	
	int inputNumber() {
		int num = -1;
		try {
			System.out.print("입력 : ");
			String input = sc.next();
			num = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return num;
	}
	boolean isRun() {
		boolean run = false;
		for(int i=0; i<player; i++) {
			if(isOpen[i] == false)
				run = true;
		}
		
		return run;
	}
	
	void printLadder() {
		for (int i = 0; i < player; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < player; j++) {
				if (ladder[i][j] == HOOK) {
					System.out.print("├─┤ ");
					++j;
				} else {
					System.out.print("│ ");
				}
			}
			System.out.println();
		}

		for (int i = 0; i < player ; i++) {
			if (isOpen[i] == true)
				System.out.print("O ");
			else
				System.out.print("X ");
		}
		System.out.println();
		
	}
	
	boolean indexExcetion(int index) {
		if(index < 0 || index >= player) {
			return true;
		}
		return false;
	}
	
	void menuRun(int index) {
		int x = index;
		for(int i=0; i<HEIGHT; i++) {
			int cnt = 0;
			for(int j=0; j<=x; j++) {
				if(ladder[i][j] == HOOK) {
					cnt++;
				}else {
					cnt = 0;
				}
			}
			if(cnt != 0)
				x = cnt % 2 == 0 ? --x : ++x;  
		}
		
		menuOpen(x);
	}
	
	void menuOpen(int x) {
		System.out.println(menu[x] + " 당첨");
		isOpen[x] = true;
	}
	
	void run() {
		setGame();
		
		while(isRun()) {
			printLadder();
			int index = inputNumber();
			if(indexExcetion(index))
				continue;
			
			menuRun(index);
		}
	}
	
}

public class Test04 {

	public static void main(String[] args) {
		
		Ladder game = new Ladder();
		game.run();
		
	

	}

}
