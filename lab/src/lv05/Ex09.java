package lv05;

import java.util.Scanner;

public class Ex09 {

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
		
		boolean isDupl = true;
		if(name.length() != myName.length()) {
			isDupl = false;
		}
		if(isDupl) {
			for(int i=0; i<name.length(); i++) {
				if(name.charAt(i) == myName.charAt(i)) {
					isDupl = true;
				}else {
					isDupl = false;
					break;
				}
				
			}			
		}
		System.out.println(isDupl);
		
	}

}
