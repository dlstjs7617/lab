package lv04;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;

public class Ex06 {
	/*
	 * ATM[4단계] : 전체 기능 구현
	 * 1. 회원가입
	 * . id와 pw를 입력받아 기입
	 * . 가입 시 돈 1000원 부여
	 * . id중복체크
	 * 2. 회원탈퇴
	 * . 로그인시에만 이용가능
	 * 3. 로그인
	 * . id와 pw를 입력받아 로그인
	 * . 로그아웃 상태에서만 이용가능
	 * 4. 로그아웃
	 * . 로그인시에만 이용가능
	 * 5. 입금
	 * . 로그인시에만 이용가능
	 * 6. 이체
	 * . 로그인시에만 이용가능
	 * 7. 잔액조회
	 * . 로그인시에만 이용가능
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int MAX=5;
		
		int[] accs = new int[MAX];
		int[] pwds = new int[MAX];
		int[] balances = new int[MAX];
		
		int count = 0;
		int log = -1;
		String menu = "==== ATM ==== \n";
		menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
		menu += "5.입금\n6.이체\n7.잔액조회\n0.종료";
		
		while (true) {
			int error = -1;	//for문 빠져나와 예외처리 한번만 뜨게하기용
			int temp = -1;
			System.out.println("accs : "+ Arrays.toString(accs));
			System.out.println("pwds : " + Arrays.toString(pwds));
			System.out.println("balances : " + Arrays.toString(balances));
			
			System.out.println(menu);
			int sel = sc.nextInt();

			if (log != -1) {
				System.out.println("=========================");
				System.out.println("로그인중인 아이디 : " + accs[log]);
				System.out.println("=========================");
			}

			if (sel == 1) { // 회원가입
				if (count == 5) { // 배열 초과 예외처리
					System.out.println("회원이 꽉찼습니다.");
					continue;
				}

				System.out.print("회원가입하실 id를 입력하세요 :");
				int id = sc.nextInt();
				System.out.print("비밀번호를 입력해주세요 : ");
				int pw = sc.nextInt();

				for (int i = 0; i < MAX; i++) { // 아이디 중복 예외처리
					if (id == accs[i]) {
						System.out.println("이미 등록된 아이디입니다.");
						error = 1;
					}
				}
				if (error == -1) { // 정상 회원가입
					accs[count] = id;
					pwds[count] = pw;
					balances[count] = 1000;
					count++;
				} else if (error == 1)
					continue;

			} else if (sel == 2) { // 회원탈퇴
				
				if(log == -1) 
					System.out.println("로그인 후 이용가능");
				else {	//탈퇴 및 배열정리
					for(int i=log; i<count-1; i++) {
						accs[i] = accs[i+1];
						pwds[i] = pwds[i+1];
						balances[i] = balances[i+1];
					}
					accs[count-1] = 0;
					pwds[count-1] = 0;
					balances[count-1] = 0;
					count--;
					log = -1;
				}
			} else if (sel == 3) { // 로그인
				if (log != -1) {
					System.out.println("이미 로그인중입니다.");
					continue;
				}
				System.out.print("로그인할 아이디 입력 : ");
				int id = sc.nextInt();
				System.out.print("비밀번호 입력 : ");
				int pw = sc.nextInt();

				for (int i = 0; i < MAX; i++) {
					if (accs[i] == id && pwds[i] == pw && id != 0) {
						System.out.println("로그인 성공");
						log = i;
						error = -1;
						break;
					} else {
						error = 1;
					}
				}

				if (error == 1)
					System.out.println("잘못된 아이디/비밀번호입니다");
			} else if (sel == 4) { // 로그아웃
				if (log != -1) {
					System.out.println("로그아웃 하셨습니다.");
					log = -1;
				} else
					System.out.println("로그인 후 이용 가능");
			} else if (sel == 5) { // 입금
				if (log != -1) {
					System.out.print("입금하실 금액을 입력해 주세요 : ");
					int money = sc.nextInt();

					if (money <= 0)
						System.out.println("잘못된 값입니다.");
					else
						balances[log] += money;

				} else
					System.out.println("로그인 후 이용가능");
			} else if (sel == 6) { // 이체
				if (log != -1) {
					System.out.print("이체하실 아이디를 입력해주세요 :");
					int id = sc.nextInt();
					System.out.print("보낼 금액을 입력해주세요 : ");
					int money = sc.nextInt();

					if (money < 0 || id == 0) { // 계좌 및 금액 예외처리
						System.out.println("잘못된값입니다");
						continue;
					}
					for (int i = 0; i < count; i++) { //계좌확인후 저장
						if (id != accs[log] && id == accs[i]) {
							temp = i;
						}
					}

					if (balances[log] < money) {
						System.out.println("계좌 잔액이 부족합니다.");
					} else {
						balances[log] -= money;
						balances[temp] += money;
					}
				}
			} else if (sel == 7) { // 잔액조회
				if (log != -1)
					System.out.println(balances[log] + "원");
				else
					System.out.println("로그인 후 이용가능");
			} else if (sel == 0) { // 종료
				System.out.println("종료합니다");
				break;
			}
			System.out.println();
		}
	}
}
