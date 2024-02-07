package lv01;

import java.util.Scanner;

public class Ex21 {
	/*
	 * #영수증 출력[1단계]
	 * 
	 * 1.메뉴판을 출력한다. 
	 * 2.사용자는 주문하고자 하는 메뉴의 번호를 입력한다. 
	 * 3.현금을 입력받는다. 4.입력받은 현금과 메뉴가격을 확인해,
	 * 영수증을 출력한다. 5.단, 현금이 부족한 경우 "현금이 부족합니다."라는 메세지를 출력한다.
	 */
	public static void main(String[] args) {

		// 입력한 값받기
		Scanner sc = new Scanner(System.in);

		int price1 = 8700;
		int price2 = 6200;
		int price3 = 1500;

		System.out.println("=== 롯데리아 ===");
		System.out.println("1.불고기\t버거 :" + price1 + "원");
		System.out.println("2.새우\t버거 : " + price2 + "원");
		System.out.println("3.콜\t라 :  " + price3 + "원");

		// 주문하고자 하는 메뉴 값 받아 저장하기
		System.out.print("원하시는 메뉴 : ");
		int menu = sc.nextInt();

		//메뉴 및  예외처리
		if(menu <= 0 || menu > 3) {
			System.out.println("입력 오류 다시 입력하세요");
		}


		// 입력받은 현금과 메뉴가격을 확인해 영수증 출력할 조건문
		if(menu >= 1 && menu <= 3) {
			
			// 현금을 입력받아 저장하기
			System.out.print("현금을 입력해 주세요 : ");
			int money = sc.nextInt();
			
			// 현금 예외 처리
			if(money < 0) {
				System.out.println("입력 오류 다시 입력하세요");
			}
			
			// 현금이 정상입력 될때
			if(money > 0) {
				// 선택한 메뉴1에 대한 조건문
				if(menu == 1) {

					// 현금이 메뉴가격보다 크거나 작을때 조건문
					if(money >= price1) {
						System.out.println("주문하신 메뉴가격: " + price1 + "원\t내신금액:" + money + "원\t잔돈:" + (money - price1) + "원");
					}
					if(money < price1) {
						System.out.println("현금이 부족합니다.");
					}
				}

				// 선택한 메뉴2에 대한 조건문
				if(menu == 2) {

					// 현금이 메뉴가격보다 크거나 작을때 조건문
					if(money >= price2) {
						System.out.println("주문하신 메뉴가격: " + price2 + "원\t내신금액:" + money + "원\t잔돈:" + (money - price2) + "원");
					}
					if(money < price2) {
						System.out.println("현금이 부족합니다.");
					}
				}

				// 선택한 메뉴3에 대한 조건문
				if(menu == 3) {

					// 현금이 메뉴가격보다 크거나 작을때 조건문
					if(money >= price3) {
						System.out.println("주문하신 메뉴가격: " + price3 + "원\t내신금액: " + money + "원\t잔돈: " + (money - price3) + "원");
					}
					if(money < price3) {
						System.out.println("현금이 부족합니다.");
					}
				}
			}
			

		}
	
	}

}
