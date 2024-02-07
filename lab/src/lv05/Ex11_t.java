package lv05;

import java.util.Scanner;

public class Ex11_t {

	public static void main(String[] args) {
	/*
	 * # 단어 검색
	 * 1. 단어를 입력받아 text변수 문장 속에 해당 단어가 있는지 검색한다.
	 * 2. 단어가 존재하면 true
	 *    단어가 없으면 false를 출력한다.
	 * 3. contains() 사용 안함
	 * 
	 */
		Scanner sc = new Scanner(System.in);
		
		String text = "Life is too short.";
		System.out.println(text);
		
		System.out.println("검색할 단어를 입력하세요 : ");
		String word = sc.nextLine();
		
		// [true] life, short, short., to, Life is
		// [false]Life is too short!!!, soot
		text = text.toLowerCase();
		word = word.toLowerCase();
		
		// word를 검색하기 위한 시작점
		// text : abcd
		//		  012
		// word : ab
		
		boolean result = false;
		
		for(int i=0; i<=text.length()-word.length(); i++) {
			int cnt = 0;
			for(int j=0; j<word.length(); j++) {	// j : word 문자열의 각 인덱스
				if(text.charAt(i+j) == word.charAt(j)) {
					cnt++;
				}
			}
			if(cnt == word.length()) {
				result = true;
			}
		}
		System.out.println(result);
			
	}

}
