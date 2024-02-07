package test.lv1;

import java.util.Random;
import java.util.Scanner;

public class Test05 {
	// 모든 문제 최상단에 다음 주석 추가 (분:초)

	// 시작 33:40
	// 종료 38:40
	// 소요 05:00
	public static void main(String[] args) {
		// 문제 5)
		/*
		 * #  구구단 게임[2단계]
		 * 1. 구구단 문제를 출제하기 위해, 숫자 2개를 랜덤하게 저장한다.
		 * 2. 저장된 숫자를 토대로 구구단 문제를 출력한다.
		 * 예) 3 x 7 = ?
		 * 3. 문제에 해당하는 정답을 입력 받는다.
		 * 4. 정답을 비교 "정답" 또는 "땡"을 출력한다.
		 */
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int num1 = random.nextInt(10)+1;
		int num2 = random.nextInt(10)+1;
		int result = num1 * num2;
		
		System.out.println("==== 구구단 게임 ====");
		System.out.printf("%d x %d = ?", num1, num2);
		System.out.print("정답 입력 : ");
		
		int answer = scanner.nextInt();
		if(answer == result) {
			System.out.println("정답");
		}else {
			System.out.println("땡");
		}
		
		
		
		
	}

}
