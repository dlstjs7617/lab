package lv06;
/*
 *  # 나만의 마블
 *  옷 □ □ □ □
 *  □ ■ ■ ■ □
 *  □ ■ ■ ■ □
 *  □ ■ ■ ■ □
 *  □ □ □ □ □
 */

import java.util.Scanner;

// 옷이 이동 숫자를 입력 받을때마다 이동 하는데
// 외각으로 시계방향으로만 이동 아래 그림참조
// ㄴ 입력 : 이동 칸 수(1이상)

class Marble{
	Scanner sc = new Scanner(System.in);
	
	final int PLAYER = 1;
	final int SIZE = 5;
	final int RIGHT = 1;
	final int DOWN = 2;
	final int LEFT = 3;
	final int UP = 4;
	int[][] map;
	
	int x;
	int y;
	int dir;
	void setGame() {
		map = new int[SIZE][SIZE];
		dir = 1;
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				map[i][j] = 0;
				if(i > 0 && i < 4 && j != 0 && j != SIZE-1)
					map[i][j] = 2;
			}
		}
		
		map[y][x] = PLAYER;
	}
	
	void printGame() {
		System.out.println("=======모두의 마블=======");
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(map[i][j] == 0)
					System.out.print("□ ");
				else if(map[i][j] == PLAYER)
					System.out.print("옷 ");
				else {
					System.out.print("■ ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	int inputNumber() {
		int num = 0;
		
		try {
			System.out.print("이동 : ");
			String temp = sc.next();
			num = Integer.parseInt(temp);
		} catch (Exception e) {
			System.out.println("숫자만 입력");
		}
		
		return num;
	}
	
	boolean moveExcetion(int move) {
		boolean moveEx = false;
		
		if(move > 0)
			moveEx = true;
		
		return moveEx;
	}
	
	void playerMove(int move) {
		int run = move;
		while(run != 0) {
			System.out.println("x : "+ x);
			System.out.println("run : "+ run);
			System.out.println("dir : " + dir);
			if(dir == RIGHT) {
				run = rightMove(run);
			}
			if(dir == DOWN) {
				run =downMove(run);
			}
			if(dir == LEFT) {
				run =leftMove(run);
			}
			if(dir == UP) {
				run =leftMove(run);
			}
		}
		
	}
	
	int rightMove(int move) {
		map[y][x] = 0;
		if(x + move > SIZE-1) {
			move -= (SIZE-1)-x;
			x = SIZE-1;
			dir = DOWN;
		}else{
			x += move;
			move = 0;
		}
		map[y][x] = PLAYER;
		return move;
	}
	
	int downMove(int move) {
		map[y][x] = 0;
		if(y + move > SIZE-1) {
			move -= (SIZE-1)-y;
			y = SIZE-1;
			dir = LEFT;
		}else{
			y += move;
			move = 0;
		}
		map[y][x] = PLAYER;
		
		return move;
	}
	
	int leftMove(int move) {
		map[y][x] = 0;
		if(x - move < 0 ) {
			move -= x;
			x = 0;
			dir = UP;
		}else {
			x -= move;
			move = 0;
		}
		map[y][x] = PLAYER;
		
		return move;
	}
	
	int upMove(int move) {
		map[y][x] = 0;
		if(y - move < 0 ) {
			move -= y;
			y = 0;
			dir = LEFT;
		}else {
			y -= move;
			move = 0;
		}
		map[y][x] = PLAYER;
		
		return move;
	}
	
	void run() {
		setGame();
		while(true) {
			printGame();
			
			int move = inputNumber();
			if(moveExcetion(move)) {
				playerMove(move);
			}
		}
	}
	
	
}

public class Ex14 {

	public static void main(String[] args) {
		Marble game = new Marble();
		game.run();

	}

}
