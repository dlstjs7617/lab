package test.lv1;

import java.util.Scanner;

public class Test04 {
	// 모든 문제 최상단에 다음 주석 추가 (분:초)

	// 시작 07:30
	// 종료 21:05
	// 소요 13:35
	public static void main(String[] args) {
		// 문제 4)
		/*
		 * # 영수증 출력[1단계]
		 * 1. 메뉴판을 출력한다.
		 * 2. 사용자는 주문하고자 하는 메뉴의 번호를 입력한다.
		 * 3. 현금을 입력받는다.
		 * 4. 입력받은 현금과 메뉴가격을 확인해, 영수증을 출력한다
		 * 5. 단, 현금이 부족한 경우 "현금이 부족합니다."라는 메세지를 출력한다
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		int price1 = 8700;
		int price2 = 6200;
		int price3 = 1500;
		int myMoney = 0;
		
		System.out.println("=== 롯데리아 ===");
		System.out.println("1.불고기  버거 : " + price1 + "원");
		System.out.println("2.새우    버거 : " + price2 + "원");
		System.out.println("3.콜       라 : " + price3 + "원");
		
		System.out.print("주문하실 메뉴를 선택해 주세요.  : ");
		int menu = scanner.nextInt();
		
		if(menu == 1 || menu == 2 || menu == 3) {
			System.out.println("현금을 입력해 주세요.");
			myMoney = scanner.nextInt();
			if(menu == 1) {
				if(myMoney >= price1) {
					System.out.println("주문하신 메뉴 : 불고기버거 " + price1 + "원\n내신 돈 :  " + myMoney + "원 \n거스름돈 :" + (myMoney-price1) + "원");
				}else if(myMoney >0  && myMoney < price1) {
					System.out.println("현금이 부족합니다.");
				}else {
					System.out.println("입력오류");
				}
			}else if(menu == 2) {
				if(myMoney >= price2) {
					System.out.println("주문하신 메뉴 : 새우버거 " + price2 + "원\n내신 돈 :  " + myMoney + "원 \n거스름돈 :" + (myMoney-price2) + "원");
				}else if(myMoney > 0 && myMoney < price2) {
					System.out.println("현금이 부족합니다.");
				}else {
					System.out.println("입력오류");
				}
			}else if(menu == 3) {
				if(myMoney >= price3) {
					System.out.println("주문하신 메뉴 : 콜라 " + price3 + "원\n내신 돈 :  " + myMoney + "원 \n거스름돈 :" + (myMoney-price3) + "원");
				}else if(myMoney > 0 && myMoney < price3) {
					System.out.println("현금이 부족합니다.");
				}else {
					System.out.println("입력오류");
				}
			}else {
				System.out.println("입력오류");
			}
			
			
			
			
		}
		
		
		
		
		
//		if(menu == 1) {
//			System.out.print("현금을 입력해 주세요 : ");
//			myMoney = scanner.nextInt();
//			temp = myMoney;
//			if(myMoney >= price1) {
//				temp -= price1;
//				System.out.println("주문하신 메뉴 : 불고기버거 " + price1 + "원\n내신 돈 :  " + myMoney + "원 \n거스름돈 :" + temp + "원");
//			}else if(myMoney >0  && myMoney < price1) {
//				System.out.println("현금이 부족합니다.");
//			}else {
//				System.out.println("입력오류");
//			}
//		}else if(menu == 2) {
//			System.out.print("현금을 입력해 주세요 : ");
//			myMoney = scanner.nextInt();
//			temp = myMoney;
//			if(myMoney >= price2) {
//				temp -= price2;
//				System.out.println("주문하신 메뉴 : 새우버거 " + price2 + "원\n내신 돈 :  " + myMoney + "원 \n거스름돈 :" + temp + "원");
//			}else if(myMoney > 0 && myMoney < price2) {
//				System.out.println("현금이 부족합니다.");
//			}else {
//				System.out.println("입력오류");
//			}
//		}else if(menu == 3) {
//			System.out.print("현금을 입력해 주세요 : ");
//			myMoney = scanner.nextInt();
//			temp = myMoney;
//			if(myMoney >= price3) {
//				temp -= price3;
//				System.out.println("주문하신 메뉴 : 콜라 " + price3 + "원\n내신 돈 :  " + myMoney + "원 \n거스름돈 :" + temp + "원");
//			}else if(myMoney > 0 && myMoney < price3) {
//				System.out.println("현금이 부족합니다.");
//			}else {
//				System.out.println("입력오류");
//			}
//		}else {
//			System.out.println("입력오류");
//		}
		
		
		
	}

}