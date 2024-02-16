package test.lv5;

import java.util.Scanner;

public class test01 {
	//시작 10 : 10
	//종료 10 : 28
	//소요 00 : 18
	public static void main(String[] args) {
		// Lv5 Test
		
		// 1.
		/*
		 * # 단어 교체하기(replace)
		 * 1. text 변수 문장 속에서 변경하고 싶은 단어를 입력받아,
		 * 2. 교체해주는 기능을 구현한다.
		 * 예)
		 * 		Life is too short
		 * 		변경하고 싶은 단어 입력 : Life
		 * 		바꿀 단어 입력 : Time
		 * 
		 * 		Time is too short.
		 */
		
		// replace() 메서도 사용 x
		
		Scanner sc = new Scanner(System.in);
		
		String text ="Life is too too short.";
		System.out.println(text);
		
		System.out.print("변경하고 싶은 단어를 입력하세요 : ");
		String word = sc.next();
		
		System.out.print("바꿀 단어 입력 : ");
		String newword = sc.next();
		
		String result = "";
		
		
		for(int i=0; i<text.length(); i++) {
			int cnt = 0;
			for(int j=0; j<word.length(); j++) {
				if(i+j < text.length() && text.charAt(i+j) == word.charAt(j)) {
					cnt++;
				}				
			}
			if(cnt == word.length()) {
				result += newword;
				i += word.length()-1;
			}else {
				result += text.charAt(i);
			}
		}
		
		System.out.println(result);
		
	}

}
