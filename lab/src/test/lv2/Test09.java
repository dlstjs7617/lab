package test.lv2;

public class Test09 {
	//시작 30:00
	//종료 07:00
	//소요 37:00
	public static void main(String[] args) {
	
		// Lv02 테스트
		
		// 문제 9) 마지막!
		
		// -1. 8과 12의 최소 공배수를 구하시오
		// 최소 공배수란 각 수의 배수를 나열한 다음 처음으로 같은숫자를 말한다.
		// 예) 8 16 24...
		// 예) 12 24...
		// 여기서 24가 최소 공배수다
		System.out.println("==============문제1================");
		int x = 8;
		int y = 12;
		for(int i=1; true; i++) {
			if(i%  x == 0 && i % y ==0) {
				System.out.println("최소 공배수 : " + i);
				break;
			}
		}
		
		
		// -2. 수인이는 4일 마다 수영장을 가고 형주는 6일마다 수영장에 간다.
		// 두사람이 4월 3일에 만났다면 다음에 만날날은 언제인가?
		System.out.println("==============문제2================");
		
		x = 4;
		y = 6;
		for(int i=1; true; i++) {
			if(i%  x == 0 && i % y ==0) {
				System.out.println("날짜 : " + i + "일 뒤");
				break;
			}
		}
		
		// -3. 가로가 12이고 세로가 8인 직사각형모양의 종이를 늘어놓아
		// 만들수 있는 가장 작은 정사각형을 만들려고한다. 직사각형은 몇장이 필요한가?
		
		System.out.println("==============문제3================");
		x = 12;
		y = 8;
		int max = 0;
		for(int i=1; true; i++) {
			if(i % x == 0 && i % y == 0) {
				max = i;
				break;
			}
		}
		int num1 = max/x;
		int num2 = max/y;
		System.out.println("최숫 갯수 : " + num1*num2 + "장");
	}

}
