package lv02;

import java.util.Scanner;

public class Ex16_2 {
	/*
	 * # ATM
	 * 1. 로그인
	 * . 로그인 후 재 로그인 불가
	 * . 로그아웃 상태에서만 이용 가능
	 * 2. 로그아웃
	 * . 로그인 후 이용가능
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int dbAcc1 = 1111;
		int dbPw1 = 1234;
		int cash1 = 20000; //입금시 감소 ,출금시 증가
		int balance1 = 30000; //입금시 증가 ,출금시 감소
		
		int dbAcc2 = 2222;
		int dbPw2 = 2345;
		
		int cash2 = 20000; //입금시 감소 ,출금시 증가
		int balance2 = 30000; //입금시 증가 ,출금시 감소
		
		int log = -1; // -1(로그아웃), 1(dbAcc1로그인), 2(dbAcc2로그인)
		
		boolean run = true;
		while(run) {
			
			System.out.println("1.로그인");
			System.out.println("2.로그아웃");
			System.out.println("0.종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				if(log == -1){
					
					System.out.print("아이디를 입력해 주세요 : ");
					int inputId = sc.nextInt();
					System.out.print("\n비밀번호를 입력해 주세요 : ");				
					int inputPw = sc.nextInt();
					
					if(inputId == dbAcc1 && inputPw == dbPw1) {
						System.out.println("로그인 성공");
						log = 1;
					}else if(inputId == dbAcc2 && inputPw == dbPw2){
						System.out.println("로그인 성공");
						log = 2;
					}else {
						System.out.println("아이디 / 비밀번호가 다릅니다.");
					}					
				}
				
			}else if(sel == 2) {
				if(log == 1 || log == 2) {
					System.out.println("로그아웃 되셨습니다.");
					log = -1;
				}
			}else if(sel == 0) {
				run = false;
				System.out.println("프로그램 종료");
			}
			
			
		}
		
		
	}

}
