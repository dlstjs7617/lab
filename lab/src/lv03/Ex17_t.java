package lv03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex17_t {
	
	/*
	 * # 숫자이동[1단계]
	 * 1. 숫자2는 캐릭터이다.
	 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
	 * 	  숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
	 * 3. 단, 좌우 끝에 도달했을 때 예외처리를 해야한다.
	 * 4. {0, 0, 2, 0, 0, 0, 0,}; ==> 왼쪽 ==> {0, 2, 0, 0, 0, 0,};
	 * 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] game = {0, 0, 2, 0, 0, 0, 0 };
		
		// 플레이어의 현재 위치(좌표 :인덱스)
		int x= -1;
		
		
		while(true) {
			System.out.println(Arrays.toString(game));
			System.out.print("1.왼쪽 2.오른쪽 3.종료: ");
			int move = sc.nextInt();
			for(int i=0; i<7; i++) {
				if(game[i] == 2) {
					x = i;
				}
			}
			if(move == 1) {
				if(x != 0) {
					game[x] = 0;
					game[x-1] = 2;
				}else
					System.err.println("왼쪽 끝입니다.");
			}else if(move == 2) {
				if(x != 6) {
					game[x] = 0;
					game[x+1] = 2;
				}else
					System.err.println("오른쪽 끝입니다.");
			}else if(move == 3) {
				break;
			}
		}
	}

}
