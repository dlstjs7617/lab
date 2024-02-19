package lv06;

import java.util.Random;
import java.util.Scanner;

// [ATM]
// System.out.println("===" + name + " ===");
// System.out.println("1.회원가입");
// System.out.println("2.회원탈퇴");
// System.out.println("3.로그인");
// System.out.println("4.로그아웃);
// System.out.println("5.입금하기");
// System.out.println("6.이체하기");
// System.out.println("7.조회하기");

class Atm{
	
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);
	
	String name;
	
	int size;				// 계좌수
	
	int[] accs;				// 4자리 랜덤 번호 발금
	String[] pws;
	String[] moneys;		//가입 축하금 1000원
	
	int log = -1;
	
	void signup() {
		
	}
	
	
	
	
	void menu() {
		signup();
		leave();
		login();
		logout();
		deposit();
		transfer();
		inquiry();
	}
	
	void run() {
		while(true) {
			int sel = sc.nextInt;
			menu(sel);			
		}
	}
	
}

public class Ex10 {

	public static void main(String[] args) {
		Atm atm = new Atm();
		atm.run();
		
	}

}
