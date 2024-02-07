package lv01;

import java.util.Scanner;

public class Ex30 {
	/*
	 *  # ATM[1단계] : 이체하기
	 *  1. 이체할 계좌번호를 입력받는다.
	 *  2. 계좌번호가 일치하면.
	 *  3. 이체할 금액을 입력 받는다.
	 *  4. 이체할 금액<= myMoney : 이체가능
	 *  		myMoney - 이체할 금액
	 *  		yourMoney + 이체할 금액
	 *  	이체할 금액 > myMoney :이체 불가
	 */

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int myAcc = 1234;
		int myMoney = 8700;
		
		int yourAcc = 4321;
		int yourMoney = 12000;
		
		System.out.println("myMoney = " + myMoney);
		System.out.println("yourMoney = " + yourMoney);
		
		
		System.out.print("출금한 계좌번호를 입력하세요 : ");
		int inputMyAcc = sc.nextInt();
		
		if(inputMyAcc == myAcc) {
			System.out.print("이체하실 계좌번호를 입력하세요 : ");
			int inputYourAcc = sc.nextInt();
			
			if(inputYourAcc == yourAcc) {
				System.out.print("이체하실 금액을 입력하세요 : ");
				int inputMoney = sc.nextInt();
				
				if(inputMoney <= myMoney) {
					myMoney -= inputMoney;
					yourMoney += inputMoney;
					System.out.print("계좌이체가 완료 되었습니다. \n이체한 금액 : (" +  inputMoney + ")원 \n남은 잔액   : (" + myMoney +")원");
				}else {
					System.out.println("잔액이 부족합니다");
				}
				
			}else {
				System.out.println("존재하지 않는 계좌번호입니다.");
			}
		}else {
			System.out.println("존재하지 않는 계좌번호입니다.");
		}
	}

}
