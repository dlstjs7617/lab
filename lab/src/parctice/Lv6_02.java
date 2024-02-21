package parctice;

import java.util.Random;
import java.util.Scanner;

/*
 * # 사다리 게임(N플레이어)
 */
class ParcticeLadder{
	
	Scanner sc = new Scanner(System.in);
	
	
	final int HOOK = 1;
	final int HEIGHT = 9;
	
	int player;			//플레이어 수
	int ladder[][];
	boolean[] isHook;
	boolean[] isOpen;
	String[] menu;
	
	void playerSet() {
		while(player < 2) {
			System.out.print("인원");
			player = inputNumber();			
		}
	}
	
	void menuSet() {
		menu = new String[player];
		for(int i=0; i<player; i++) {
			menu[i] = inputString(i);
		}
	}
	
	String inputString(int i) {
		System.out.printf("%d 번째 메뉴 : ", i+1);
		String menu = sc.next();
		
		return menu;
	}
	
	void setGame() {
		playerSet();
		isOpen = new boolean[player];
		ladder = new int[HEIGHT][player];
		menuSet();
		setLadder();
		
	}
	
	void setLadder() {
		while(true) {
			ranHook();
			
			if(hookCheck()) {
				break;
			}else {
				resetLadder();
			}
		}
	}
	
	void ranHook() {
		Random ran = new Random();
		for(int i=0; i<HEIGHT; i++) {
			for(int j=0; j<player-1; j++) {
				int rNum = ran.nextInt(3);
				
				if(rNum == 2) {
					ladder[i][j] = HOOK;
					ladder[i][++j] = HOOK;
				}
			}
		}
	}
	
	boolean hookCheck() {
		boolean result = true;
		isHook = new boolean[player];
		for(int i=0; i<player; i++	) {
			int cnt = 0;
			for(int j=0; j<HEIGHT; j++) {
				if(ladder[j][i] == HOOK) {
					isHook[i] = true;
				}
			}
		}
		
		return result;
	}
	
	void resetLadder() {
		ladder = new int[HEIGHT][player];
	}
	
	
	
	
	
	int inputNumber() {
		int input = 0;
		
		try {
			System.out.print("입력 : ");
			String num = sc.next();
			input = Integer.parseInt(num);
			
		} catch (Exception e) {
			System.out.println("숫자만 입력");
		}
		
		return input;
	}
	
	boolean isRun() {
		boolean run = false;
		
		for(int i=0; i<player; i++) {
			if(!isOpen[i]) {
				run = true;
			}			
		}
		
		
		return run;
	}
	
	void printLadder() {
		for(int i=0; i<player; i++) {
			System.out.printf("%d ", i);
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
		
		for(int i=0; i<player; i++) {
			if(isOpen[i] == false) {
				System.out.print("X ");				
			}else {
				System.out.print("O ");
			}
		}
		System.out.println();
	}
	
	void open(int line) {
		int x = line;
		
		for(int i=0; i<HEIGHT; i++) {
			int cnt = 0;
			for(int j=0; j<player; j++) {
				if(j < x && ladder[i][j] == HOOK) {
					cnt++;
				}
			}
			if(cnt == 0) {
				x = x;
			}else if(cnt != 0) {
				x = cnt%2 == 1 ? --x : ++x ;
			}
			
		}
		
		isOpen[x] = true;
		System.out.printf("메뉴 : %s  당첨\n", menu[x]);
	}
	
	
	
	void run() {
		setGame();
		
		while(isRun()) {
			printLadder();
			int line = inputNumber();
			open(line);
		}
	}
}



public class Lv6_02 {

	public static void main(String[] args) {
		ParcticeLadder game = new ParcticeLadder();
		
		game.run();
	}

}