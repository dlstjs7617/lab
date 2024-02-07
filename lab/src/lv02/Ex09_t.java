package lv02;

import java.util.Scanner;

public class Ex09_t {

	/*
	 * # 베스킨라빈스31
	 * 1. p1과 p2거 번갈아가면서 1~3을 입력한다.
	 * 2. br은 p1과 p2의 입력값을 누적해서 저장한다.
	 * 3. br이 31을 넘으면 게임은 종료된다.
	 * 4. 승리자를 출력한다.
	 * 
	 * 예)
	 * 1턴 : p1(2) br(2)
	 * 2턴 : p2(1) br(3)
	 * 3턴 : p1(3) br(6)
	 * ...
	 */
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int br = 0;
		int turn = 0;
		// 방법 1) ++ 짝홀
		// 방법 2) 1 or 2 로 스위치
		
		// 종료 조건 br값이 31이상이면,
		while(br < 31) {
			System.out.printf("br [%d]\n", br);
			// 플레이어의 입력값 받기
			System.out.printf("P%d (1~3) : ",turn % 2 +1);
			int input = scan.nextInt();
			
			// 정상 범주일 떄에만
			if(input > 0 && input <= 3) {
				// br 증가
				br += input;
				
				//turn 스위치
				turn++;
			}
		}
		// 승리자 출력
		System.out.printf("P%d WIN!!", turn % 2 + 1);
	}
	


}
