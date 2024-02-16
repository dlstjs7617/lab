package lv06;

import java.util.Scanner;

// 클래스가 가지는 요소 2가지
// 1) 멤버 변수(속성)
// 2) 멤버 메소드(기능)

class Theater_t{
	Scanner sc = new Scanner(System.in);
	
	final int PRICE = 12000;
	int total;					//총 매출
	int[] seat = new int[7];	//좌석 현황
	
	// 메소드 : 클래스 안에 정의된 함수
	// 리턴타입 메소드명(파라미터){ 실행문; }
	// * void 타입 : 리턴값이 없는 것

	void run() {
		int size = seat.length;
		
		while (true) {

			System.out.println("[GGV]");
			System.out.println("[1]좌석예매");
			System.out.println("[2]종료하기");

			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();

			if (sel == 1) {
				// print
				for (int i = 0; i < size; i++) {
					System.out.print(i + 1 + " ");
				}
				System.out.println();
				for (int i = 0; i < size; i++) {
					if (seat[i] == 1)
						System.out.print("■ ");
					else
						System.out.print("□ ");
				}
				System.out.print("\n 좌석 번호 : ");
				int idx = sc.nextInt() - 1;

				// 예외 처리
				if (idx < 0 || idx >= size)
					continue;

				if (seat[idx] == 1) {
					System.err.println("이미 선택된 좌석입니다.");
					continue;
				}

				// 예매 처리
				seat[idx] = 1;

				// 총 매출액 증가
				total += PRICE;

			} else if (sel == 2) {
				System.out.println("총 매출액 : " + total);
				break;
			}
		}
	}
	
}
public class Ex04_t {

	public static void main(String[] args) {
		/*
		 * # 영화관 좌석예매 : 클래스 + 변수
		 * 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다.
		 * 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다.
		 * 3. 이미 예매가 완료된 좌석은 재구매할 수없다.
		 * 4. 한 좌석당 예매 가격은 12000원이다.
		 * 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
		 */
		
		
		
		Theater_t ggv = new Theater_t();
		
		// 메소드 호출(사용)
		// ㄴ 참조변수 뒤에 .닷을 붙여서 메소드를 불러오고 ()를 붙이면된다.
		ggv.run();
	}

}
