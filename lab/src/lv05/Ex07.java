package lv05;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		
		//char 문자 한 개 비교
		// ㄴ 비교 연산자 사용 가능(== !=)
		
		/*
		 *  # 끝말잇기 게임
		 *  제시어 : 자전거
		 *  입력 : 거미
		 *  제시어 : 거미
		 *  입력 : 미술
		 *  ...
		 */
		Scanner sc = new Scanner(System.in);
		
		String start = "자전거";
		while(true) {
			
			System.out.println("제시어 : " + start);
			System.out.print("입력 : ");
			String input = sc.next();
			char a = input.charAt(0);
			char b = start.charAt(start.length()-1);
			if(a == b && input.length() >= 2) {
				start = input;
			}else {
				System.out.println("틀림");
			}
//			if(input.substring(0, 1).equals(start.substring(start.length()-1)) && input.length() >= 2){
//				start = input;
//			}else {
//				System.err.println("틀림");
//			}
			
		}
				
	}

}
