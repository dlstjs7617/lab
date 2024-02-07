package test.lv3;

import java.util.Arrays;
import java.util.Scanner;

public class Test01 {
	//시작 02:00
	//종료 12:30
	//소요 10:30
	public static void main(String[] args) {
		//Level Test 3
		
		// 1.
		
		/*
		 * # 영화관 좌석예매
		 * 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다.
		 * 2. 예매가 완료되면 해당좌석 값을 1로 변경한다.
		 * 3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
		 * 4. 한좌석당 예매 가격은 12000원이다.
		 * 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
		 * 
		 * 예)
		 * seat = 0 0 0 0 0 0 0
		 * 
		 * 좌석선택 : 1
		 * seat = 0 1 0 0 0 0 0
		 * 
		 * 좌석선택 : 3
		 * seat = 0 1 0 1 0 0 0
		 * 
		 * 좌석선택 : 3
		 * seat = 0 1 0 1 0 0 0
		 * 이미 예매가 완료된 자리입니다.
		 * -----------------------
		 * 매출액 : 24000원
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int[] seat = new int[7];
		
		
		boolean isRun = true;
		int money = 0;
		
		while(isRun) {
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1. 예매하기 2.종료");
			int sel = sc.nextInt();
			
	
			
			if(sel == 1) {
				System.out.println(Arrays.toString(seat));
				System.out.print("좌석을 선택해 주세요 : ");
				int index = sc.nextInt();
				
				if(index < 0 || index >= 7) {
					System.out.println("유효한 좌석을 선택해 주세요.");
					continue;
				}
				
				if(seat[index] == 0) {
					System.out.println("좌석이 선택되었습니다.");
					seat[index] = 1;
					money+= 12000;
				}else if(seat[index] == 1) {
					System.out.println("이미 예매가 완료된 자리 입니다.");
					continue;
				}else {
					System.out.println("입력 오류");
				}
				
			}else if(sel == 2) {
				System.out.println("종료");
				break;
			}
			System.out.println();
		}
		System.out.println("----------------");
		System.out.println("정산된 금액 : " + money + "원");
		
	}

}
