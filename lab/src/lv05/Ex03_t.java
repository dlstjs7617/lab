package lv05;

import java.util.Calendar;

public class Ex03_t {

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
		
		String birth = jumin.substring(0,2); 	// jumin.charAt(0) + jumin.charAt(1)
		String gender = jumin.substring(7,8); 	// jumin.charAt(7) + "" 
												// String.valueof(jumin.charAt(7))
		// 문제1) 나이 출력
		// 정답1) 00세
		int target = Integer.parseInt(birth);
		target = mz.contains(gender) ? target +2000 : target + 1900;
		
		System.out.println(year -target +1);
		// 문제2) 성별 출력		
		// 정답2) 남성
		
		//1,3,5 -> 남
		//2,4,6 -> 여
		System.out.println(Integer.parseInt(gender) % 2 == 1 ? "남" : "여");
	}

}
