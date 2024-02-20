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

class Mario{
	Scanner sc = new Scanner(System.in);
	
	final int SIZE = 10;
	final int MARIO = 8;
	final int LEFT = 1;
	final int RIGHT = 2;
	
	int[] move = new int[SIZE];
	
	int x; // 플레이어 랜덤좌표에서 시작
	
	void playerRanSet() {
		Random ran = new Random();
		x = ran.nextInt(SIZE);
		move[x] = MARIO;
	}
	

	
	void printMap() {
		
		for(int i=0; i<SIZE; i++) {
			if(move[i] == 0) {
				System.out.print("□ ");
			}else if(move[i] == MARIO){
				System.out.print("■ ");
			}
		}
		System.out.println();
	}
	
	int inputNumber() {
		System.out.println("1)왼쪽 2)오른쪽");
		System.out.print("이동할 방향 선택 : ");
		int inputNum = -1;
		
		try {
			String input = sc.next();
			inputNum = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("숫자를 적어주세요");
		}
		return inputNum;
		
	}
	
	void moving(int select) {
//		int moving = select;
		if(select == LEFT && moveExcetion(select)) {
			leftMove();
		}else if(select == RIGHT && moveExcetion(select)) {
			rightMove();
		}
	}
	
	boolean moveExcetion(int moving) {
		boolean result = false;
		if(moving == LEFT) {
			if(x-1 < 0) {
				System.err.println("쾅!");
			}else {
				result = true;
			}
		}else if(moving == RIGHT) {
			if(x+1 >= SIZE) {
				System.err.println("쾅!");
			}else {
				result = true;
			}
		}
		
		return result;
	}
	
	void leftMove() {
		move[x-1] = MARIO;
		move[x] = 0;
		x--;
	}
	void rightMove() {
		move[x+1] = MARIO;
		move[x] = 0;
		x++;
	}
	
	
	void run() {
		playerRanSet();
		while(true) {
			printMap();
			
			int moving = inputNumber();
			
			moving(moving);
		}
	}
}


public class Ex11 {

	public static void main(String[] args) {
		
		Mario mario = new Mario();
		mario.run();
		
	}

}
