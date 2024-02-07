package lv04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex05 {
	
	/*
	 * 1 to 50을 ==> 1 to 18
	 * 1. 구글에서 1 to 50 이라고 검색한다.
	 * 2. 1 to 50 순발력 게임을 선택해 게임을 실습해본다.
	 * 3. 위 게임을 숫자범위를 좁혀 1 to 18로 실습 해본다.
	 * 4. 숫자 1~9는 front 배열에 저장하고,
	 * 5. 숫자 10 ~ 18은 back 배열에 저장한다.
	 */
	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		final int SIZE = 9;
		
		int[] front = new int[SIZE]; 	// 1~9 		->shuffle
		int[] back = new int[SIZE];		// 10~18	->shuffle
		
		/*
		 * front :
		 * [2][6][8]
		 * [3][1][7]
		 * [9][5][4]
		 * 
		 * index : 4
		 * [2][6][8]
		 * [3][17][7]
		 * [9][5][4]
		 */
		for(int i=0; i<SIZE; i++) {
			int ran = random.nextInt(9)+1;
			front[i] = ran;
			for(int j=0; j<i; j++) {
				if(front[i] == front[j])
					i--;
			}
		}
		for(int i=0; i<SIZE; i++) {
			int ran = random.nextInt(9)+10;
			back[i] = ran;
			for(int j=0; j<i; j++) {
				if(back[i] == back[j])
					i--;
			}
		}
		System.out.println(Arrays.toString(front));
		System.out.println(Arrays.toString(back));
		
		boolean isRun = true;	
		int cnt = 1;
		while(isRun) {			
			for(int i=0; i<SIZE; i++) {
				if(i % 3 == 0 && i != 0) 
					System.out.println("");		
				if(front[i] <= 9 && front[i] >= 0) {
					System.out.print("["+front[i]+"]");
				}else {
					if(back[i] == -1)
						System.out.print("[ ]");
							
					if(back[i] != -1)
						System.out.print("["+back[i]+"]");
					
					
				}
			}
			
			System.out.println("\n인덱스 입력 : ");
			int idx = sc.nextInt();
			if(idx < 0 || idx > 9)
				continue;
			if(cnt <= 9) {
				if(front[idx] == cnt) {
					cnt++;
					front[idx] = -1;
				}
			}else if(cnt > 9) {
				if(back[idx] == cnt) {
					cnt++;
					back[idx] = -1;
				}
			}
			if(cnt == 19) {
				System.out.println("GAME CLEAR");
				break;
			}
		}
		
		
		
	}

}
