package lv06;

import java.util.Arrays;
import java.util.Scanner;

class Theater{
	int total;					//총 매출
	int[] seat = new int[7];	//좌석 현황
}

public class Ex04 {

	public static void main(String[] args) {
		/*
		 * # 영화관 좌석예매 : 클래스 + 변수
		 * 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다.
		 * 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다.
		 * 3. 이미 예매가 완료된 좌석은 재구매할 수없다.
		 * 4. 한 좌석당 예매 가격은 12000원이다.
		 * 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		Theater ggv = new Theater();
		
		final int PRICE = 12000;

		int[] seat = ggv.seat;
		int total = 0;
		
		while(true) {
			
			System.out.println("[GGV]");
			System.out.println("[1]좌석예매");
			System.out.println("[2]종료하기");
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				System.out.println("======좌석번호========");
				System.out.println(" 1  2  3  4  5  6  7");
				System.out.println(Arrays.toString(seat));
				System.out.println("====================");
				System.out.print("예매할 자리를 입력 : ");
				int idx = sc.nextInt()-1;
				
				if(idx < 0 || idx >= seat.length-1)
					continue;
				if(seat[idx] != 0) {
					System.err.println("이미 예매되있는 자리입니다.");
					continue;
				}else {
					seat[idx] = 1;
					total += PRICE;
				}
				
			}else if(sel == 2) {
				break;
			}
		}
		ggv.total = total;
		System.out.println("총 매출 : " + total);
	}

}
