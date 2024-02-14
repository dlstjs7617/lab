package lv05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex33 {
	/*
	 *  # 스네이크 게임
	 *  1. 10x10 배열을 0 으로 채운다.
	 *  2. 스네이크는 1234로 표시한다.
	 *  3. 상하좌우로 이동이 가능하며, 꼬리가 따라온다.
	 *  4. 자기몸하고 부딪치면, 사망한다.
	 *  5. 랜덤으로 아이템을 생성해
	 *     아이템을 먹으면 꼬리가 1개가 자란다.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		final int SIZE = 10;
		final int ITEM = -1;
		
		int[][] map = new int[SIZE][SIZE];
		
		int snake = 4;
		int[] y = new int[snake];
		int[] x = new int[snake];
		
		for(int i=0; i<snake; i++) {
			x[i] = i;
			map[y[i]][x[i]] = i + 1;
		}
		
		int itemCnt = 0;
		
		while(true) {
			
			while(itemCnt == 0) {
				int yIdx = ran.nextInt(SIZE);
				int xIdx = ran.nextInt(SIZE);
				
				if(map[yIdx][xIdx] == 0) {
					map[yIdx][xIdx] = ITEM;
					itemCnt++;
					break;
				}
			}
			
			System.out.println(Arrays.toString(y));
			System.out.println(Arrays.toString(x));
			
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					if(map[i][j] == 0)
						System.out.print(" + ");
					else if(map[i][j] == ITEM)
						System.out.print(" ● ");
					else
						System.out.printf("%2d ", map[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			
			System.out.print("a)left d)right w)up s)down : ");
			int sel = sc.next().charAt(0);
			
			int moveY = y[0];
			int moveX = x[0];
			
			
			
			if(sel == 'a') {
				moveX--;
			}else if(sel == 'd') {
				moveX++;				
			}else if(sel == 'w') {
				moveY--;
			}else if(sel == 's') {
				moveY++;
			}
			
			if(moveY < 0 || moveY >= SIZE || moveX < 0 || moveX >= SIZE)
				continue;
			if(map[moveY][moveX] == ITEM) {
				itemCnt--;
				int[] tempY = y;
				int[] tempX = x;
				
				for(int i=0; i<snake; i++) {
					y[i] = tempY[i];
					x[i] = tempX[i];
				}
				
				y[snake+1] = y[snake];
				x[snake+1] = x[snake];
				snake++;
			}
			
			
			
			map[moveY][moveX] = 1;
			
			
		}
		
	}

}
