package lv05;

import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

public class Ex12_t {
	/*
	 * # 단어 교체하기(replace)
	 * 1. text변수 문장속에서 변경하고 싶은 단어를 입력받아,
	 * 2. 교체해주는 기능을 구현한다.
	 * 예)
	 * 		Life is too too short.
	 * 		변경하고 싶은 단어입력 : Life
	 * 		바꿀 단어입력 : Time
	 * 		
	 * 		Time is too short.
	 */
	
	// replace() 메서드 사용 X
	// too -> how
	// Life is how how short.
	// .-> !!!
	// Life is too short!!!
	// Life -> My height
	// My height is too short.
	// short -> long
	// Life is too too long.
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String text = "Life is too too short.";
		System.out.println(text);
		
		System.out.print("변경하고 싶은 단어를 입력하세요 : ");
		String word = sc.nextLine();
		
		System.out.print("변경할 단어를 입력하세요 : ");
		String newWord = sc.nextLine();
		
		String result = "";
		
		int size = text.length();
		
		for(int i=0; i<size; i++) {
			int cnt = 0;
			for(int j=0; j<word.length(); j++)
				if(i+j <size &&text.charAt(i+j) == word.charAt(j))
					cnt++;
			
			if(cnt == word.length()) {
				result += newWord;
				i += word.length()-1;
			}else {
				result += text.charAt(i);
			}
		}
		
		System.out.println(result);
		
		
		
		
		
		
		
		
		
		
	}

}
