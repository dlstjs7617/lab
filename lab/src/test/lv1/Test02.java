package test.lv1;

import java.util.Random;
import java.util.Scanner;

public class Test02 {
	// 모든 문제 최상단에 다음 주석 추가 (분:초)

	// 시작 13:00
	// 종료 18:01
	// 소요 05:01
	public static void main(String[] args) {
		
		// 문제 2)
		/*
		 * 홀짝 게임
		 * 1. 1~100사이의 랜덤 숫자를 저장한다.
		 * 2. 저장된 랜덤 숫자를 보여주고,
		 * 3. 해당 숫자가 홀수인지 짝수인지 맞추는 게임이다.
		 */
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int ran = random.nextInt(100)+1;
		
		System.out.println("=======홀짝 게임=======");
		System.out.print(ran + " 는 홀(0) 짝(1)이다 : ");
		int answer = scanner.nextInt();
		
		if(ran % 2 == 0 && answer == 1) {
			System.out.println("정답입니다.");
		}else if(ran % 2 == 1 && answer == 0){
			System.out.println("정답입니다.");
		}else {
			System.out.println("틀렸습니다.");
		}
		
		
	}

}
