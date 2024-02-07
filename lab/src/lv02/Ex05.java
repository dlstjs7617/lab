package lv02;

import java.util.Scanner;

public class Ex05 {
	/*
	 * # 영수증 출력[2단계]
	 * 1. 5번의 주문을 받는다
	 * 2. 주문이 끝난 후, 돈을 입력받는다
	 * 3. 각 메뉴얼 주문수량과 총금액을 출력한다.
	 * 
	 *예)
	 *메뉴 선택 : 1 
	 *메뉴 선택 : 1 
	 *메뉴 선택 : 2 
	 *메뉴 선택 : 2 
	 *메뉴 선택 : 3  
	 * 총 금액 = 31300원
	 * 현금 입력 : 32000
	 * === 롯데리아 영수증 ===
	 * 1.불고기	버거 : 	2개
	 * 2.새우	버거 :	2개
	 * 3.콜		라 :		1개
	 * 4.총	금	액 :	31300원
	 * 5.잔		돈 :	700원
	 * 	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int price1 =8700;
		int price2 =6200;
		int price3 =1500;
		int money = 0;
		int i = 0;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		System.out.println("롯데리아");
		
		while(i < 5) {
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			if(menu == 1) {
				money+=price1;
				count1++;
			}else if(menu == 2) {
				money+=price2;
				count2++;
			}else if(menu == 3) {
				money+=price3;
				count3++;
			}
			if(menu > 0 && menu <=3) {
				i++;
			}
		}
		
		System.out.print("현금을 입력하세요 :");
		int cash = sc.nextInt();
		if(cash >= money) {
			System.out.println("====롯데리아 영수증====");
			System.out.printf("불고기  버거 : %d개\n",count1);
			System.out.printf("새우   버거 : %d개\n",count2);
			System.out.printf("콜      라 : %d개\n",count3);
			System.out.printf("총  금   액 : %d원\n",money);
			System.out.printf("잔      돈 : %d원",cash-money);
		}else {
			System.out.println("현금이 부족합니다.");
		}
	}
}
