package lv04;

import java.util.Scanner;

public class Ex19 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 문자열 비교
		// == 사용 X
		// equals() 메소드 사용 O
		
		// Java : String Constant Pool (Heap)
		// 자바는 String 값을 받은뒤 Heap안에 같은값이 있으면 주소를 공유해버림
		
		String str1 = "이인선";
		String str2 = "이인선";
		String str3 = sc.next();
		String str4 = new String("이인선");
		
		System.out.println(str1 == str2);	// true
		System.out.println(str2 == str3);	// false
		System.out.println(str2 == str4);	// false
		System.out.println(str3 == str4);	// false
		
		// 고유 ID 조회
		System.out.println(System.identityHashCode(str1));	//2137211482
		System.out.println(System.identityHashCode(str2));	//2137211482
		System.out.println(System.identityHashCode(str3));	//920011586
		System.out.println(System.identityHashCode(str4));	//968514068
		
		// 문자열의 각 캐릭터(문자 한개씩) 비교해주는
		// 기 구현된 메소드인 equals를 써서
		// 문자열의 비교를 정확히 할 수 0
		
		
		
	}

}
