package lv05;

import java.util.Calendar;

public class Ex03 {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		
		// charAt
		// subString
		
		// 두 가지 버전으로 풀이
		
		
//		String jumin = "950209-1234567";	// 29 남 청년
		String jumin = "030209-1234567";	// 121 남 노인
//		String jumin = "950209-3234567";	// 29 남 청년
//		String jumin = "020209-4234567";	// 22 여 청년
//		String jumin = "950209-5234567";    // 29 남 청년
//		String jumin = "010209-6234567";    // 123 여 노인 
//		String jumin = "030209-7234567";    // 21 남 청년
//		String jumin = "200209-8234567";    // 4  여 청년
		
		String mz = "3478";
		// 문제1) 나이 출력
		
		
		// charAt
		char a = jumin.charAt(0);
		char b = jumin.charAt(1);
		char c = jumin.charAt(7);
		String n;
		if(c == '1' || c == '2' || c == '5'|| c == '6') {
			n = "19"+a+b;
		}else
			n = "20"+a+b;
		int age = Integer.parseInt(n);
		System.out.println("나이는 : " + (year-age));
		
		if(c % 2 == 1) 
			System.out.println("남자");
		else
			System.out.println("여자");
		
		// subStrung
		String d = jumin.substring(0,2);
		String e = jumin.substring(7,8);
		String f;
		if(mz.contains(e)) {
			f = 20+d;
		}else {			
			f = 19+d;
		}
		int age2 = Integer.parseInt(f);
		System.out.println("나이는 : " + (year-age2));
		
		String temp = "1357";
		if(temp.contains(e)) 
			System.out.println("남자");
		else
			System.out.println("여자");
		
		// 문제2) 성별 출력		
		// 정답2) 남성
		
		//1,3,5 -> 남
		//2,4,6 -> 여
		
	}

}
