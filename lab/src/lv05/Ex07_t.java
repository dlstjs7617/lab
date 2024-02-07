package lv05;

import java.util.Scanner;

public class Ex07_t {

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
			String word = sc.next();
			
			char end = start.charAt(start.length()-1);
			char begin = word.charAt(0);
			
			if(end != begin)
				break;
			
			start = word;
		}
		System.err.println("GAME OVER~");
				
	}

}
