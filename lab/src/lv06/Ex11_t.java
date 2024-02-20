package lv06;

import java.util.Random;
import java.util.Scanner;

/*
 * # 숫자 이동
 * 1. 숫자 8은 캐릭터다
 * 2. 숫자 1을 입력하면, 캐릭터가 왼쪽으로 이동한다.
 * 3. 숫자 2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
 * 4. 좌우 끝에 도달했을 떄 에러가 발생하지 않도록 예외처리를 해준다.
 */

class Mario_t{
	Scanner sc = new Scanner(System.in);
	
	final int SIZE = 10;
	final int MARIO = 8;
	
	final int LEFT = 1;
	final int RIGHT = 2;
	int[] move = new int[SIZE];
	
	int x ; // 플레이어 랜덤좌표에서 시작
	
	
	void setGame() {
		Random random = new Random();
		x = random.nextInt(SIZE);
		move[x] = MARIO;
	}
	
	void printMap() {
		for(int i=0; i<SIZE; i++) {
			if(move[i] == MARIO)
				System.out.print("옷_");
			else
				System.out.print("__");
		}
		System.out.println();
	}
	
	int inputNumber() {
		int number = 0;
		
		try {
			System.out.print("1) 왼 2) 오 : ");
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요.");
		}
		return number;
	}
	
	void moveLeft() {
		if(x == 0) {
			System.err.println("쾅");
			return;			
		}
		move[x] = 0;
		move[--x] = MARIO;
	}
	
	void moveRight() {
		if(x == SIZE-1) {
			System.err.println("쾅");
			return;			
		}

		move[x] = 0;
		move[++x] = MARIO;
	}
	
	
	void move(int direction) {
		if(direction == LEFT)
			moveLeft();
		else if(direction == RIGHT)
			moveRight();
	}
	
	void run() {
		setGame();
		while(true) {
			printMap();
			int dir = inputNumber();
			move(dir);
		}
	}
}


public class Ex11_t {

	public static void main(String[] args) {
		
		Mario_t Mario_t = new Mario_t();
		Mario_t.run();
		
	}

}
