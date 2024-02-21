package lv06;
/*
 * # 달팽이
 */
// 아래와 같이 2차원 배열을 완성 후,
// 플레이어 이동처리까지 완성(앞으로 +N칸, 뒤로 -N칸)
/*
 * # 달팽이
 * 1   2   3    4    5
 * 16  17  18   19   6
 * 15  24  25   20   7
 * 14  23  22   21   8
 * 13  12  11   10   9
 */

import java.util.Scanner;

// 종료 조건 이동 불가 시
class Snail_t{
	
	Scanner sc = new Scanner(System.in);
	
	final int SIZE = 5;
	
	int[][] map;
	
	int position;
	int direction;
	
	void setMap() {
		map = new int[SIZE][SIZE];
		
		
		
		int y = 0;
		int x = 0;
		
		int n = 1;
		
		while(true) {
			map[y][x] = n;
			
			if(n == SIZE*SIZE)
				break;
			
			int tempY = y;
			int tempX = x;
			
			if(direction == 0) {
				tempX++;
			}else if(direction == 1) {
				tempY++;
			}else if(direction == 2) {
				tempX--;
			}else if(direction == 3) {
				tempY--;
			}
			if(!checkPosition(tempX,tempY))
				continue;
			
			
			y = tempY;
			x = tempX;
			
			n ++;
		}
	}
	
	void setGame() {
		position = 1;
		direction = 0;
		setMap();
		
	}
	
	boolean checkPosition(int x, int y) {
		if(y < 0 || y >= SIZE || x < 0 || x >= SIZE || map[y][x] != 0) {
			direction = direction == 3 ? 0 : ++direction;
			return false;
		}
		
		return true;
	}
	
	void printMap() {
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(map[i][j] == position) 
					System.out.print(" @ ");
				else
				System.out.printf("%2d ", map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	boolean isRun() {
		return position < 1 || position >= SIZE*SIZE ? false : true;
	}
	
	int inputNumber() {
		int number = 0;
		
		try {
			System.out.print("이동 : ");
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자를 입력하세요.");
		}
		
		return number;
	}
	
	void move(int number) {
		position += number;
		
		
	}
	
	
	void run() {
		setGame();
		while(isRun()) {
			printMap();
			int number = inputNumber();
			move(number);
		}
	}
}
	

public class Ex16_t {

	public static void main(String[] args) {
		
		Snail_t game = new Snail_t();
		game.run();

	}

}