package lv03;

public class Ex24 {

	public static void main(String[] args) {
		
		// 중첩 for문
		// ㄴ for문 안에 또다른 for구문이 들어 있는 것
		
//		for(int i=0; i<5; i++) {
//			System.err.println("i : " + i);
//			for(int j=0; j<3; j++) {
//				System.out.println("j : " + j);
//			}
//		}
		
		/*
		 * 0 0 0
		 * 0 0 0
		 * 0 0 0
		 */
//		for(int i=0; i<3; i++) {
//			for(int j=0; j<3; j++) {
//				System.out.print("0 ");
//			}
//			System.out.println();
//		}
//		
		// 문제 구구단 전체 출력하기
		// 단 타이틀 출력
		// 2~9단까지 (1~10까지)
		
		/*
		 * --- 2단 ---
		 * 2x1 = 2
		 * 2x2 = 4
		 * 2x3 = 6
		 * 2x4 = 8
		 */
		for(int i=2; i<10; i++) {
			System.out.println("=== "+ i + "단 ===");
			for(int j=1; j<=10; j++) {
				System.out.println(i + " X " + j + " = " + i*j);
			}
			System.out.println();
		}
		
		
	}

}
