package lv01;

import java.util.Scanner;

public class Ex12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		// 문제1) 숫자 2개를 입력받아, 합 출력
		System.out.print("첫번째 숫자 : ");
		int input1 = sc.nextInt();
		System.out.print("두번쨰 숫자 : ");
		int input2 = sc.nextInt();
		System.out.println("입력 받은 두 수의 합 : " + (input1 + input2));
		
		
		// 문제2) 숫자 1개를 입력받아, 홀수이면 true 추력
		System.out.print("입력 받을 숫자 : ");
		int input3 = sc.nextInt();
		
		System.out.println("홀수인가? : " + (input3% 2 == 1));
		
		
		// 문제3) 성적을 입력받아, 60점 이상이고 100점 이하이면 true 출력
		
		System.out.print("성적 : ");
		int input4 = sc.nextInt();
		System.out.println("60점 이상인가? :" + (input4 >= 60 && input4 <=100));
	}

}
