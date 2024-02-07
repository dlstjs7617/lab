package lv05;

import java.util.Arrays;

public class Ex02 {

	public static void main(String[] args) {
	
		//문자열 메소드
		
		// 1. 문자 한개 추출(문자열로부터)
		// ㄴ String.charAt(index)
		
		String apple = "apple";
		System.out.println(apple.charAt(0));
		System.out.println(apple.charAt(2));
		
		// 2. 문자열 추출(문자열로부터)
		// ㄴ 1)String.subString(0,2)
		String str = "Do not go gentle into that good night.";
		System.out.println(str.substring(0));
		
		// ㄴ 2)String.subString()
		// *끝인덱스는 포함하지 X : 시작 인덱스~끝인덱스-1
		System.out.println(str.substring(0, 2));	//0~1
		System.out.println(str.substring(0, 4));	//0~3
		// ㄴ 3)String.subString()
		
		// 3. 문자열 포함 여부
		// ㄴ String.contains(타겟문자열)
		// *boolean 반환
		System.out.println(str.contains("gentle"));
		
		// 4. 문자열 구분자를 기준으로 분리
		// ㄴ String.split(구분자)
		// *String[] 반환
		str = "가/나/다/라/마";
		
		String[] result = str.split("/");
		System.out.println(Arrays.toString(result));
		
		// 5. 문자열 길이
	      // ㄴ String.length()
	      //    * int 반환
		
		// 6. 문자열 비교
		// ㄴ String.equals(비교대상문자열)
		// * boolean 반환
		
		
		// 7. 문자열 시퀀스 비교
		// ㄴ String.compareTo(비교대상문자열)
		// * 정수
		// ㄴ 음수(비교대상 문자열보다 앞에 있으면)/  0 /양수(비교대상 문자열보다 뒤에 있으면)
		
		
		//8. 문자열 패턴포함 여부
		// String.matches(정규식문자열)
		// * boolean 반환
		
		
		// 9. 알파벳으로 이루어진 문자열에 대하여
		// ㄴ String.toLowerCase() : 소문자로 변경
		// ㄴ String.toUpperCase() : 대문자로 변경
		
		str = "abc";
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		
		//10. 문자열 치환
		// ㄴ String.replace(타겟문자열, 변경할문자열)
		str = "abcdeabc";
		System.out.println(str.replace("abc", "가나다"));
		
		// 11. 문자열 안에 대상 문자열이 위치한 인덱스
		// ㄴ String.indexOf(대상값)
		// *  int 타입의 인덱스 값을 반환
		str.indexOf("abc");
		System.out.println(str.indexOf("abc")); // 0 : 첫번째 인덱스 반환
		System.out.println(str.indexOf("f"));	// -1  : 찾지 못했다
		
		// 12. 공백 또는 Empty
		// ㄴ String.isBalnk()
		// ㄴ String.isEmpty()
		str = " ";
		System.out.println(str.isBlank()); // true
		System.out.println(str.isEmpty()); // false
		
		// 14. 공백을 제거한 나머지 값에 대한 반환
		// ㄴ String.strip()
		str = " 123";
		System.out.println(str.strip());
		
	}

}
