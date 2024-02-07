package lv01;

import java.util.Scanner;

public class ttt {
	
	public static void main(String[] args) {
		
		//변수: 변할수 있는 값
		//변수는 원하는 만큼 만들수 있다.
		//int타입(정수)의 변수를 num이라 선언하겠다.
		int num1; //변수 선언
		num1 = 0; // 변수 초기화
		
		//위를 한번에 하는방법
		int num2 = 1;
		//↑설명 타입 변수이름 = 변수에 넣은 값;
		
		//num2의 값을 num1에 넣겠다(대입하겠다)
		num1 = num2;
		System.out.println(num1); //출력시 1이나옴
		
		//출력문
		System.out.println();
		// 괄호안에 (출력할 내용)입력
		
		//if문의 기본 선언문
		//if문은 조건식이 참일때만 실행된다.
		/*
		if(조건식) {
			조건식이 참일때 실행할 내용
		}
		*/
		//Scanner 사용법
		Scanner sc= new Scanner(System.in);
		
		//스캐너 사용 클래스를를 sc라는 변수안에 담겠다.
		int num3 = sc.nextInt();
		//int타입(정수)의 num3이라는 변수에 입력받은 값을 넣겠다.
		
		
	}
}
