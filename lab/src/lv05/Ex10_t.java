package lv05;

import java.util.Arrays;
import java.util.Scanner;

public class Ex10_t {

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
//		int cnt = 0; // 숫자의 개수
//		for(int i=0; i<text.length(); i++) {
//			char target = text.charAt(i);
//			if(target >= '0' && target <= '9')
//				cnt++;
//		}
//		if(cnt == 0) 
//			System.out.println("문자만 있다");
//		else if(cnt == text.length()) 
//			System.out.println("숫자만 있다.");
//		else
//			System.out.println("문자와 숫자가 섞여있다.");
		
		// 풀이 2. contains() 특정 캐릭터 포함 여부
//		String nums ="0123456789";
//		int cnt = 0; // 숫자의 개수
//		for(int i=0; i<text.length(); i++) {
//			char target = text.charAt(i);
//			if(nums.contains(target+""))	//if(nums.contains(String.valueOf(target)))
//				cnt++;
//		}
//		if(cnt == 0) 
//			System.out.println("문자만 있다");
//		else if(cnt == text.length()) 
//			System.out.println("숫자만 있다.");
//		else
//			System.out.println("문자와 숫자가 섞여있다.");
		
		// 풀이 3. split()
		
		String[] temp = text.split("\\d");
		System.out.println(Arrays.toString(temp));
		
//		boolean isAllNumber	= text.split("\\d").length == 0;
//		boolean isAllCharacter	= text.split("\\D").length == 0;
		boolean isAllNumber	= text.matches("\\d+");
		boolean isAllCharacter	= text.matches("\\D+");
		
		if(isAllNumber)
			System.out.println("숫자만 있다");
		else if(isAllCharacter)
			System.out.println("문자만 있다");
		else
			System.out.println("문자와 숫자가 섞여있다.");
		
		text.matches(text);
		
		
	}

}
