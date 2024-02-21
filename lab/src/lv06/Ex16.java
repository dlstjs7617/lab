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
class Snail{
	
	Scanner sc = new Scanner(System.in);
	
	final int SIZE = 5;
	final int EAST = 0;
	final int SOUTH = 1;
	final int WEST = 2;
	final int NORTH = 3;
	
	int dir = 0;
	
	int snailCnt = 1;
	
	
	int[][] map;
	
	void setMap() {
		map = new int[SIZE][SIZE];
		
		int cnt = 1;
		int y = 0;
		int x = 0;
		
		map[y][x] = cnt++;
		
		while(cnt <26) {
			int tempY = y;
			int tempX = x;

			
			if(dir == EAST) {
				tempX++;
			}else if(dir == SOUTH) {
				tempY++;
			}else if(dir == WEST) {
				tempX--;
			}else if(dir == NORTH) {
				tempY--;
			}

			if(dirChange(tempY,tempX)) {
				continue;
			}
			map[tempY][tempX] = cnt++;
			
			y = tempY;
			x = tempX;
		}
		
	}
	
	boolean dirChange(int y , int x) {
		boolean result = false;
		
		if(x < 0 || x > SIZE-1 || y < 0 || y > SIZE-1 || map[y][x] != 0) {
			dir = dir+1 > NORTH ? EAST : ++dir;
			result = true;
		}
		return result;
	}
	
	
	boolean isRun(int sanilCnt) {
		boolean run = true;
		
		if(sanilCnt <= 0 || sanilCnt > SIZE*SIZE ) {
			run = false;
			printMap();
		}
		
		return run;
	}
	
	void printMap() {
		for(int i=0; i<SIZE; i++) {			
			for(int j=0; j<SIZE; j++) {
				if(map[i][j] == snailCnt) {
					System.out.print("오 ");					
				}else {					
					System.out.printf("%2d ", map[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	int inputNumber() {
		int move = 0;
		
		try {
			System.out.print("이동 : ");
			String input = sc.next();
			move = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("숫자만 입력");
		}
		
		return move;
	}
	
	void snailMove(int move) {
		snailCnt = snailCnt+move;
	}
	
	void run() {
		setMap();
		
		while(isRun(snailCnt)) {
			printMap();
			
			int move = inputNumber();
			snailMove(move);
		}
		System.out.println("달팽이 탈출 ~");		
	}
	
}

public class Ex16 {

	public static void main(String[] args) {
		
		Snail game = new Snail();
		game.run();

	}

}
