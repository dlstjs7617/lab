package lv04;

import java.util.Arrays;
import java.util.Scanner;

public class Ex02 {
	/*
	 * # 숫자이동[2단계]
	 * 1. 숫자2는 캐릭터이다.
	 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
	 * 	  숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
	 * 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
	 * 4. 숫자 1은 벽이다. 벽을 만나면 이동할 수 없다.
	 * 5. 단, 숫자3을 입력하면, 벽을 격파할 수 있다.
	 * 
	 */
	public static void main(String[] args) {
		
		final int SIZE = 9;
		final int MARIO = 2;
		final int WALL = 1;
		final int LEFT = 1;
		final int RIGHT = 2;
		final int PUNCH = 3;
		Scanner sc = new Scanner(System.in);
		
//		int[] game = { 0, 0, 1, 0, 2, 0, 0, 1, 0};
//		int[] game = { 2, 1, 1, 0, 0, 0, 0, 1, 0};
		int[] game = { 0, 0, 1, 2, 1, 0, 0, 1, 0};
		
		int x = -1;
		boolean paly = true;
		
		while(paly) {
			System.out.println(Arrays.toString(game));
			int temp = -1;
			for(int i=0; i<SIZE; i++) { // 마리오 인덱스값 구하기
				if(game[i] == 2) {
					x = i;
				}
			}
			System.out.print("1.왼쪽 2.오른쪽 3.펀치 : ");
			int sel = sc.nextInt();

			System.out.println();
			if(sel == LEFT) {
				if(x-1 < 0 || game[x-1] == WALL ) {
					System.err.println("쾅!");
					continue;
				}
				game[x-1] = MARIO ;
				game[x] = 0;
				
			}else if(sel == RIGHT) {
				if(x+1 >= SIZE ||game[x+1] == WALL ) {
					System.err.println("쾅!");
					continue;
				}
				game[x+1] = MARIO;
				game[x] = 0;
				
			}else if(sel == PUNCH) {
				
				if(x-1 < 0 && game[x+1] == WALL) {
					game[x+1] = 0;
				}else if(x+1 >= SIZE && game[x-1] == WALL) {
					game[x-1] = 0;
				}
				
				
				if((x-1 < 0 || x+1 >= SIZE)) {
					System.err.println("주먹으로 부수기엔 너무 단단한 벽이다.");
					System.out.println(temp);
					System.out.println(x);
				}
				
				if(game[x-1] == WALL && game[x+1] == WALL) {
					System.out.println("양쪽이 벽이다 어느 벽을 부술까?");
					System.out.print("1.왼쪽 2.오른쪽 3.전부 : ");
					temp = sc.nextInt();
				}
				if(temp == PUNCH) {
					game[x-1] = 0;
					game[x+1] = 0;
					System.out.println("양쪽 펀치!");
				}
				
				if((game[x-1] == WALL && temp == -1) || temp == LEFT){
					game[x-1] = 0;
					System.out.println("왼쪽 펀치");
				}else if((game[x+1] == WALL && temp == -1) || temp == RIGHT){
					game[x+1] = 0;
					System.out.println("오른쪽 펀치");
				}else{
					System.err.println("허공에 주먹질을 했습니다.");
				}
			}
			
			
		}
		
		
		
		
	}

}
