package lv01;

public class Ex10 {

	public static void main(String[] args) {
		int score = 30;
		System.out.println(score >= 60);
		
		
		// 문제1) 3의 배수이면 true 출력
		// 힌트1) 숫자 % 3 == 0 (3의 배수)
		
		int num1 = 17;
		System.out.println("3의 배수인가? :" + ((num1 % 3) == 0));
		
		
		// 문제2) 짝수이면 true 출력
		// 힌트2) 숫자 % 2 == 0 (짝수)
		// 힌트2) 숫자 % 2 == 1 (홀수)
		int num2= 28;
		System.out.println("짝수인가? : " + (num2 % 2 == 0));

	}

}
