package lv02;

import java.util.Scanner;

public class Ex16_3 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		// 1.로그인 ==> 1.입금 2.출금 3.조회
		
		int dbAcc1 = 1111;
		int dbPw1 = 1234;
		int cash1 = 20000; //입금시 감소 ,출금시 증가
		int balance1 = 30000; //입금시 증가 ,출금시 감소
		String name1 = "1번";
		
		int dbAcc2 = 2222;
		int dbPw2 = 2345;	
		int cash2 = 20000; //입금시 감소 ,출금시 증가
		int balance2 = 30000; //입금시 증가 ,출금시 감소
		String name2 = "2번";
		
		int log = -1; // -1(로그아웃), 1(dbAcc1로그인), 2(dbAcc2로그인)
		
		System.out.println("===ATM===");
		System.out.print("1.로그인 2.종료 : ");

		int sel = sc.nextInt();
		
		boolean run = true;
		
		while(run) {
			if(sel == 1) {
				System.out.print("아이디를 입력해주세요 :");
				int inputId = sc.nextInt();
				System.out.print("비밀번호를 입력해주세요 :");
				int inputPw = sc.nextInt();
				
				if(inputId == dbAcc1 && inputPw == dbPw1) {
					System.out.println("로그인 성공");
					log = 1;
				}else if(inputId == dbAcc2 && inputPw == dbPw2){
					System.out.println("로그인 성공");
					log = 2;
				}else {
					System.out.println("아이디/비밀번호가 틀렸습니다.");
				}
				while(log ==1 || log == 2) {
					System.out.println();
				}
			}else if(sel == 2) {
				
			}
		}
	}

}
