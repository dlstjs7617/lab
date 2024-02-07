package lv05;

import java.util.Arrays;
import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		/*
		 * # 문자열 속 숫자검사
		 * 예) adklajsiod
		 * 		문자만 있다.
		 * 예) 123123
		 * 	 숫자만 있다.
		 * 예) dasd12312asd
		 * 	문자와 숫자가 섞여 있다.
		 * 
		 */
		
		// 2가지 이상의 방법으로 풀이 해보기~
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 : ");
		String text = sc.next();
		
		// 풀이 1.
		boolean num = false;
		boolean str = false;
		for(int i=0; i<text.length(); i++) {
			if(text.charAt(i) >= 48 && text.charAt(i) <= 57) {
				num = true;
			}else {
				str = true;
			}
		}
		if(num && str) {
			System.out.println("숫자와 문자가 섞여있다");
		}else if(num) {
			System.out.println("숫자만 있다");
		}else if(str) {
			System.out.println("문자만 있다.");
		}
		// 풀이 2.
		String[] temp = text.split("\\d");
		if(temp.length >= 1) {
			temp = text.split("\\D");
			if(temp.length >=1) {
				System.out.println("숫자와 문자가 섞여있다");
			}else {
				System.out.println("문자만 있다");
			}
		}else {
			System.out.println("숫자만 있다");
		}
		
		
		
		
	}

}
