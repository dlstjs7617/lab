package lv01;

import java.util.Scanner;

public class Ex22 {

	/*
	 * #최대값 구하기 [1단계]
	 * 1. 숫자 3개를 입력받는다.
	 * 2. 입력받은 3개의 수를 비교하여
	 * 3. 가장 큰 수(Max)를 출력한다.
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//변수선언
		int num1;
		int num2;
		int num3;
		int maxNum;
		
		//입력받아 변수 초기화
		System.out.print("첫번째 값 입력 :");
		num1 = sc.nextInt();
		
		System.out.print("두번째 값 입력 :");
		num2 = sc.nextInt();
		
		System.out.print("세번째 값 입력 :");
		num3 = sc.nextInt();
		
		maxNum=num1;
		
		if(maxNum <num2) {
			maxNum = num2;
		}
		if(maxNum < num3) {
			maxNum = num3;
		}
		System.out.println("카장큰 수는 " + maxNum + "이다");
		
		
	}

}
