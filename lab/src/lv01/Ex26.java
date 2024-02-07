package lv01;

import java.util.Scanner;

public class Ex26 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		/*
		 * # 홀짝 게임
		 * 1. 1~100사이의 랜덤 숫자를 저장한다.
		 * 2. 저장된 랜덤 숫자를 보여주고,
		 * 3. 해당 숫자가 홀수인지 짝수인지 맞추는 게임이다.
		 */
		
		
		int ranNum = (int)(Math.random() * 100) + 1;
		int answer = 0;
		
		System.out.println("나온값 " + ranNum + "은 홀수인가 짝수인가 입력하시오 홀수(1) 짝수(2): ");
		//입력받은값
		int input = sc.nextInt();
		
		//정답이 홀수인지 짝수인지 구별하는 if문
		if(ranNum % 2 == 1) {
			answer = 1;
		}
		if(ranNum % 2 == 0) {
			answer = 2;
		}
		
		//입력받은값과 정답이 일치할시 나오는 if문
		if(answer == input) {
			System.out.println("정답입니다");
		}
		if(answer != input) {
			System.out.println("정답이 아닙니다");
		}
	

	}

}
