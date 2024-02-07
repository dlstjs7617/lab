package lv04;

import java.util.Scanner;

public class Ex04 {
	/*
	 * # 숫자 야구 게임
	 * 1. me에 1~9 사이의 숫자 3개를 저장
	 * 	(단, 중복되는 숫자는 저장 불가)
	 * 2. com과 me를 비교해 정답을 맞출 때 까지 반복
	 * 3. 숫자와 자리가 같으면 strike += 1
	 * 	  숫자만 같고 자리가 틀리면 ball += 1
	 * 예) : 1 7 3
	 * 3 1 5  : 2b
	 * 1 5 6 :1 s
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		final int SIZE = 3;
		
		
		int[] com = {1, 7, 3};
		int[] me = new int[3];
		
		boolean isRun = true;
	
		while (isRun) {
			int strike = 0;
			int ball = 0;
			for (int i = 0; i < SIZE; i++) {
				System.out.print("입력 : ");
				int input = sc.nextInt();
				me[i] = input;
				for(int j=0; j<i; j++) {
					if(me[i] == me[j]) {
						i--;
						System.out.println("중복된값 입력 금지");
					}
				}
				
				
			}

			for (int i = 0; i < SIZE; i++) {
				if (com[i] == me[i]) {
					strike++;
				} else {
					for (int j = 0; j < SIZE; j++) {
						if (com[i] == me[j]) {
							ball++;
						}
					}
				}
			}
			System.out.println("ball : " + ball + " strike : " + strike);
			if (strike == 3) {
				break;
			}
		}
	}
}
