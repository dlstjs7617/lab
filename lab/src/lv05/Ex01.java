package lv05;

public class Ex01 {

	public static void main(String[] args) {
		
		// 문자열 String
		// ㄴ 문자의 나열(배열)
		// ㄴ char[]
		
		
		//"apple"
		//{'a','p','p','l','e'};
		//  0   1   2   3   4	<- index 존재
		
		
		// 형 변환 Type casting
		
		// 1. 문자 ->숫자
		char a = 'a';
		int num = (int) a; //(int) 생략 가능
		
		System.out.println("num : " + num); // 97
		
		// 2. 숫자 ->문자
		char b = (char) ++num;
		System.out.println("b : " + b); //b
		
		// 3. 문자열 ->숫자
		// ㄴ 문자열의 모든 캐릭터가 숫자여야함
		
		String str = "12345";
		System.out.println(str + 1);	// 123451(문자열 확장)
		
		num = Integer.parseInt(str);	// 형변환 불가한 경우 발생, NumberFormatException
		System.out.println(num+1); 		// 12346
		// 4. 숫자 -> 문자열
		
		num = 1000;
		String.valueOf(num);
		System.out.println(str + 1); // 10001
		
		str = num + "";
		
	}

}
