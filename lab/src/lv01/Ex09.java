package lv01;

public class Ex09 {

	public static void main(String[] args) {
		
		//연산자
		
		// 1) 산술 연산자 +-*/%
		// 2) 등호 연산자 =
		// 3) 비교 연산자
		// ㄴ 연산 결과는 boolean 타입으로 반환됨
		int x = 10;
		int y = 3;
		
		boolean result = x > y;
		
		
		// *항상 비교의 기준은 왼쪽 항이다.
		System.out.println(x > y);
		System.out.println(x < y);
		System.out.println(x >= y);
		System.out.println(x <= y);
		System.out.println(x == y);
		System.out.println(x != y);
		
		
		// 4)논리 연산
		// ㄴ and : &&
		// ㄴ or : ||
		// not : !
		
		System.out.println(x > y && x < y );
		System.out.println(x > y || x < y );
		System.out.println(!(x >= y));
	}

}
