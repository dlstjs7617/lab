package lv05;

import java.util.Scanner;

public class Ex11 {

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
		
		int cnt = 0;
		boolean check = false;
		for(int i=0; i<text.length(); i++) {
			if(word.charAt(cnt) == text.charAt(i)) {
				cnt++;
				System.out.println(cnt);
				if(cnt == word.length()) {
					check = true;
					break;
				}
			}else {
				cnt = 0;
			}
		}
		System.out.println(check);
	}

}
