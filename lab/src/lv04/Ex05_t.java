package lv04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex05_t {
	
	/*
	 * 1 to 50을 ==> 1 to 18
	 * 1. 구글에서 1 to 50 이라고 검색한다.
	 * 2. 1 to 50 순발력 게임을 선택해 게임을 실습해본다.
	 * 3. 위 게임을 숫자범위를 좁혀 1 to 18로 실습 해본다.
	 * 4. 숫자 1~9는 front 배열에 저장하고,
	 * 5. 숫자 10 ~ 18은 back 배열에 저장한다.
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		final int SIZE = 9;
		
		int[] front = new int[SIZE]; 	// 1~9 		->shuffle
		int[] back = new int[SIZE];		// 10~18	->shuffle
		
		// set map
		for(int i=0; i<SIZE; i++) {
			front[i] = i+1;
			back[i] = i+1+SIZE;
		}
		
		//shuffle
		for(int i=0; i<100; i++) {
			int rIdx = (int)(Math.random() * SIZE);
			int temp = front[0];
			
			front[0] = front[rIdx];
			front[rIdx] = temp;
			
			rIdx = (int)(Math.random() * SIZE);
			temp = back[0];
			back[0] = back[rIdx];
			back[rIdx] = temp;
		}
	
		// run
		int gameNum = 1;
		while(true) {
			// print
			for(int i=0; i<SIZE; i++) {
				System.out.printf("[%2d]", front[i]);
				if(i % 3 == 2)
					System.out.println();
			}
			
			//end
			if(gameNum > SIZE*2)
				break;
			
			
			// input
			System.out.print("\nindex : ");
			int index = scan.nextInt();
			
			// execption 1. index range
			if(index < 0 || index >= SIZE) {
				System.out.println("인덱스 범위는 0.8입니다.");
				continue;
			}
			
			if(front[index] == gameNum) {
				front[index] = back[index];
				back[index] = 0;
				gameNum++;
			}else {
				System.out.println("Beep-");
			}
		}
		
	}

}
