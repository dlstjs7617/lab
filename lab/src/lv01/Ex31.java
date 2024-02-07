package lv01;

import java.util.Scanner;

public class Ex31 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		// 1.로그인 ==> 1.입금 2.출금 3.조회
		
		int cash = 20000; //입금시 감소 ,출금시 증가
		int balance = 30000; //입금시 증가 ,출금시 감소
		int account = 11111; //로그인시 사용
		int password = 1234; //로그인시 사용
		
		System.out.println("===ATM===");
		System.out.print("1.로그인 2.종료 : ");

		int select = sc.nextInt();
		
		if(select == 1) {
			System.out.print("아이디를 입력하세요 :");
			int inputAcc = sc.nextInt();
			System.out.print("비밀번호를 입력하세요 : ");
			int inputPw = sc.nextInt();
			if(inputAcc == account && inputPw == password) {
				System.out.print("로그인 성공\n1.입금 2.출금 3.조회 :");
				int selectNum =sc.nextInt();
				
				if(selectNum == 1) {
					//입금
					System.out.print("입금할 금액을 입력하세요 : ");
					int inputCash =sc.nextInt();
					
					if(inputCash <= cash && inputCash > 0) {
						cash -= inputCash;
						balance += inputCash;
						System.out.println("입금완료=======================================================");
						System.out.println("입금한 금액 : " + inputCash + "원\t 현금 : " + cash + "원\t 계좌잔액 : " + balance + "원");
					}else if(inputCash > cash){
						System.out.println("현금이 부족합니다.");
					}else{
						System.out.println("음수값 입력오류");
					}
				}else if(selectNum == 2) {
					//출금
					System.out.print("출금할 금액을 입력하세요 : ");
					int inputCash =sc.nextInt();
					
					if(inputCash <= balance && inputCash > 0) {
						cash += inputCash;
						balance -= inputCash;
						System.out.println("출금완료=======================================================");
						System.out.println("출금한 금액 : " + inputCash + "원\t 현금 : " + cash + "원\t 계좌잔액 : " + balance + "원");
					}else if(inputCash >balance){
						System.out.println("계좌잔액이 부족합니다.");
					}else {
						System.out.println("입력오류");
					}
					
				}else if(selectNum == 3) {
					//조회
					System.out.println("조회================================");
					System.out.println("현금 : " + cash + "원\t 계좌잔액 : " + balance + "원");
				}else {
					System.out.println("번호 선택 오류 1~3사이로 입력해 주세요");
				}
				
			}else {
				System.out.println("로그인 실패\n아이디 또는 비밀번호를 확인하세요.");
			}
		}else if(select == 2) {
			System.out.println("종료합니다");
		}else {
			System.out.println("입력오류 다시 입력하세요");
		}
	}

}
