package lv01;

import java.util.Random;
import java.util.Scanner;

public class Ex35_t {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int x = random.nextInt(10)+1;
		int y = random.nextInt(10)+1;
		
		int op = random.nextInt(4)+1;
		
		int result = 0;
		
		// 연산자에 따라 result 초기화
		if(op == 1) {
			result = x + y;
		}else if(op == 1) {
			result = x - y;
		}else if(op == 1) {
			result = x * y;
		}else if(op == 1) {
			result = x % y;
		}
		
		//문제출력
		System.out.println("[연산자 맞추기 게임]");
		System.out.printf("%d ? %d = %d\n", x, y, result);
		System.out.println("1) + 2) - 3) * 4) / : ");
		
		int answer = scanner.nextInt();
		
		// 결과 출력
//		if(answer == op) {
//			System.out.println("딩동댕~");
//		}else {
//			System.out.println("땡-");
//		}
		
		
		int temp = 0;
		
		if(answer == 1) {
			temp = x + y;
		}else if(answer == 2) {
			temp = x - y;
		}else if(answer == 3) {
			temp = x * y;
		}else if(answer == 4) {
			temp = x / y;
		}
		
		// 제어문 영역 {} 안에 실행문이 단 한 줄 있는 경우에만 -> {} 중괄호 생략 가능
		if(result == temp) {
			System.out.println("딩동댕~");
		}else {
			System.out.println("땡~");
		}
	}

}
