package lv01;

import java.util.Scanner;

public class Ex35 {

	/*
	 * # 연산자 기호 맞추기 게임
	 * 1. 1~10사이의 랜덤 숫자 2개를 저장한다.
	 * 2. 1~4 사이의 랜덤 숫자 1개를 저장한다.
	 * 3. 위 숫자는 연산자 기호에 해당된다.
	 * 		1)덧셈	2)뺼셈	3)곱셈	4)나머지
	 * 4. 사용자는 연산자 기호를 맞추는 게임이다.
	 * 예) 3 ? 4 = 7
	 * 		1) + 2) - 3) * 4) %
	 * 		정답 : 1번
	 */
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int rNum1 = (int)(Math.random()*10+1);
		int rNum2 = (int)(Math.random()*10+1);
		int operator = (int)(Math.random()*4+1);
		int result = 0;
		if(operator == 1) {
			result = rNum1 + rNum2;
		}else if(operator == 2) {
			result = rNum1 - rNum2;
		}else if(operator == 3) {
			result = rNum1 * rNum2;
		}else if(operator == 4) {
			result = rNum1 % rNum2;
		}
		
		int add = rNum1 + rNum2;
		int sub = rNum1 - rNum2;
		int mul = rNum1 * rNum2;
		int mod = rNum1 % rNum2;
		
		int answer1 = 0;
		int count = 1;
		
		if(result == add && operator != 1) {
			answer1 = 1;
			count ++;
		}
		if(result == sub && operator != 2) {
			answer1 = 2;
			count ++;
		}
		if(result == mul && operator != 3) {
			answer1 = 3;
			count ++;
		}
		if(result == mod && operator != 4) {
			answer1 = 4;
			count ++;
		}
		
		//System.out.println(count);
		if(count == 1) {
			System.out.println(rNum1 + " ? " + rNum2 + " = " + result + "이다\n이때 들어갈 연산자를 구하시오" );
			System.out.print("정답 :");
			int inputanswer = sc.nextInt();
			if(inputanswer == operator) {
				System.out.println("정답");
			}else {
				System.out.println("오답");
			}
		}else if(count == 2) {
			System.out.println(rNum1 + " ? " + rNum2 + " = " + result + "이다\n이때 들어갈 연산자를 모두구하시오" );
			System.out.print("1) +  2) -  3) *  4) %   정답 :");
			int inputanswer1 = sc.nextInt();
			System.out.print("1) +  2) -  3) *  4) %   정답 :");
			int inputanswer2 = sc.nextInt();
			if((inputanswer1 == operator || inputanswer2 == operator) && (inputanswer2 == answer1 || inputanswer1 == answer1)) {
				System.out.println("정답");
			}else {
				System.out.println("오답");
			}
		}
	}

}