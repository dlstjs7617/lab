package lv02;

public class Ex02 {

	public static void main(String[] args) {
		
		// 문제1) 1~10까지 반복해 5~9 출력
		// 정답1) 5,6,7,8,9
		System.out.println("문제1");
		int num1 = 1;
		while(num1 <= 10) {
			if(num1 >= 5 && num1 <= 9) {
				System.out.print(num1 + " ");
			}
			num1++;
		}

		// 문제2) 10~1까지 반복해 6~3 거꾸로 출력
		// 정답2) 6,5,4,3
		System.out.println("\n문제2");
		int num2 = 10;
		while(num2 >= 1) {
			if(num2 <= 6 && num2 >= 3) {
				System.out.print(num2 + " ");
			}
			num2--;
		}

		// 문제3) 1~10까지 반복해 짤수만 출력
		// 정답3) 2, 4, 6, 8, 10
		System.out.println("\n문제3");
		int num3 = 1;
		while(num3 <= 10) {
			if(num3 % 2 == 0) {
				System.out.print(num3 + " ");
			}
			num3++;
		}
	}

}
