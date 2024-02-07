package lv02;

import java.util.Scanner;

public class Ex16_t {
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
		
		int dbAcc2 = 2222;
		int dbPw2 = 2345;
		
		int log = -1; // -1(로그아웃), 1(dbAcc1로그인), 2(dbAcc2로그인)
		
		boolean run = true;
		while(run) {
			
			System.out.println("1.로그인");
			System.out.println("2.로그아웃");
			System.out.println("0.종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				if(log == -1) { //로그아웃 상태에만 로그인 가능
					System.out.println("acc : ");
					int inputAcc =sc.nextInt();
					System.out.println("pw : ");
					int inputPw = sc.nextInt();
					
					if(dbAcc1 == inputAcc && dbPw1 == inputPw) {
						log =1;
					}else if(dbAcc1 == inputAcc && dbPw1 == inputPw) {
						log =2;
					}else {
						System.err.println("회원정보가 올바르지 않습니다.");
					}
				} else {
					int user = 0;
					if(log == 1)
						user = dbAcc1;
					else if(log == 2)
						user = dbAcc2;
				}
			}else if(sel == 2) {
				if(log != -1) { //로그인 상태
					log = -1;
					System.out.println("로그아웃 완료");
				}else {
					System.err.println("로그아웃 상태입니다.");
				}
			}else if(sel == 0) {
				run = false;
				System.out.println("프로그램 종료");
			}
		}
	}

}
