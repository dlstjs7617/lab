package lv01;

public class Ex13 {

	public static void main(String[] args) {
		// 조건문
		// if(조건식){ 실행문;}
		
		//if(true) {
		//	System.out.println("hello~");
		//}
		
		// 문제1) 양수, 0, 음수 출력
		int num1 = -10;
		
		if(num1 > 0) {
			System.out.println(num1 + "은 양수");
		}
		
		if(num1 == 0) {
			System.out.println(num1 + "은 0");
		}
		
		if(num1 < 0) {
			System.out.println(num1 + "은 음수");
		}
		
		// 문제2) 4의 배수 여부 출력
		int num2 = 14;
		
		if(num2%4 == 0) {
			System.out.println(num2 + "는 4의 배수이다");
		}
		if(!(num2%4 == 0)) {
			System.out.println(num2 + "는 4의 배수가 아니다");
		}
		
		// 문제3) 합격,불합격 출력
		int score = 87;
		
		if(score >= 60) {
			System.out.println(score + "점은 합격입니다.");
		}
		
		if(score < 60) {
			System.out.println(score + "는 불합격입니다.");
		}
		
	}

}
