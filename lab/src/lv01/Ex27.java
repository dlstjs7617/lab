package lv01;

import java.util.Scanner;

public class Ex27 {

	public static void main(String[] args) {
		
		// 제어문 : 프로그램의 흐름을 제어
		// 1) 조건문 : if문, if-else문
		// 2) 반복문
		// 3) 보조 제어문
		
		// if-else문 사용 방법
		// if(조건식) {실행문;}
		// else if(조건식) {실행문;}
		// else if(조건식2) {실행문;}
		// else if(조건식3) {실행문;}
		// else {실행문;}
		
		
		Scanner sc= new Scanner(System.in);
		/*
		 * # 홀짝 게임
		 * 1. 1~100사이의 랜덤 숫자를 저장한다.
		 * 2. 저장된 랜덤 숫자를 보여주고,
		 * 3. 해당 숫자가 홀수인지 짝수인지 맞추는 게임이다.
		 */
		
		
		int ranNum = (int)(Math.random() * 100) + 1;
		String answer = null;
		
		System.out.print("나온값 " + ranNum + "은 홀수인가 짝수인가 입력하시오 : ");
		String input = sc.next();
		
		if(ranNum % 2 == 1) {
			answer = "홀수";
		}else if(ranNum % 2 == 0) {
			answer = "짝수";
		}
		
		
		if(answer.equals(input)) {
			System.out.println("정답입니다");
		}else if(!(answer.equals(input))) {
			System.out.println("정답이 아닙니다");
		}
		
		
	

	}

}
