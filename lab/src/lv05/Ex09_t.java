package lv05;

import java.util.Scanner;

public class Ex09_t {

	public static void main(String[] args) {
	/*
	 * # 문자열 비교
	 * . equals() 또는 compareTo() 메서드 사용 없이
	 *   문자열 일치여부 비교-> charAt() 활용 문제
	 *   
	 *   
	 *   예)
	 *   코끼리
	 *   입력 = 티라노사우루스
	 *   출력 = false
	 */
		Scanner sc =new Scanner(System.in);
		
		String name = "코끼리";
		
		System.out.print("동물 이름을 입력하세요 : ");		//ex) 티라노사우루스, 코코, 코끼, 코코코, 병아리
		String myName = sc.next();
		int size = name.length();
		boolean result = false;
		if(size == myName.length()) {
			int cnt = 0;
			for(int i=0; i<size; i++) {
				if(name.charAt(i) == myName.charAt(i))
					cnt++;
			}
			if(cnt == size)
				result = true;
		}
		System.out.println(result);
		
	}

}
