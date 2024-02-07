package Ex02;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		/*1. 5번 주문을 받는다
		2. 주문이 끝난 후, 돈을 입력 받는다.
		3. 각 메뉴별 주문수량과 출금액을 출력한다
			예)
			메뉴 선택: 1
			메뉴 선택: 1
			메뉴 선택: 2
			메뉴 선택: 3
			총 금액 = 31300원
			현금 입력: 32000
		=== 롯데리아 영수증 ===
		1. 불고기 버거: 2개
		2. 새우 버거: 2개
		3. 콜라: 1개
		4. 총금액: 31300원
		5. 잔돈: 700원
		*/
		Scanner sc = new Scanner(System.in);
		
		int menu1 = 5000;
		int menu2 = 10000;
		int menu3 = 1000;
		
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		
		int cash = 0;
		int money = 0;
		
		
		while(true) {
			System.out.print("메뉴 선택 : ");
			int inputMenu = sc.nextInt();
			if(inputMenu == 1) {
				count1++;
				money +=menu1;
			}
			else if(inputMenu == 2) {
				count2++;
				money += menu2;
			}
			else if(inputMenu == 3) {
				count3++;
				money += menu3;
			}
			if(count1+count2+count3 == 5) {
				break;
			}
		}
		while(true) {
			System.out.print("현금 입력 : ");
			cash = sc.nextInt();
			if(cash >= money ) {
				break;
			}else {
				System.out.println("현금부족");
			}			
		}
		System.out.println("===롯데리아 영수증 ===");
		System.out.println("데리버거 : " + count1 + "개");
		System.out.println("새우버거 : " + count2 + "개");
		System.out.println("콜   라 : " + count3 + "개");
		System.out.println("금액    : " + money +"원");
		System.out.println("잔돈    : " + (cash-money) + "원");
		
		
		
		
		
		
		
		
	}

}
