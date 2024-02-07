package lv02;

import java.util.Scanner;

public class Ex17_2 {
	/*
	 *  # ATM[4단계]
	 *  1. 로그인
	 *  . 로그인 후 재 로그인 불가
	 *  . 로그아웃 상태에서만 이용 가능
	 *  2. 로그아웃
	 *  . 로그인 후 이용가능
	 *  3. 입금
	 *  . 로그인 후 이용가능
	 *  4. 출금
	 *  . 로그인 후 이용가능
	 *  5. 이체
	 *  . 로그인 후 이용가능
	 *  6. 조회
	 *  . 로그인 후 이용가능
	 *  7. 종료
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int dbAcc1 = 1111;
		int dbPw1 = 1234;
		int dbMoney1 = 50000;
		int dbBalance1 = 0;
		
		
		int dbAcc2 = 2222;
		int dbPw2 = 2345;
		int dbMoney2 = 70000;
		int dbBalance2 = 0;
		
		int log = -1; //-1(로그아웃), 1(dbAcc1로그인), 2(dbAcc2로그인)
		
		
		int user = 0;
		
		boolean run = true;
		while(run) {
			// 검수용 출력문
			// 로그인 정보
			// dbAcc1의 잔액
			// dbAcc2의 잔액
			
			
			System.out.println("1.로그인");
			System.out.println("2.로그아웃");
			System.out.println("3.입금");
			System.out.println("4.출금");
			System.out.println("5.이체");
			System.out.println("6.조회");
			System.out.println("0.종료");
			
			if(log == 1) {
				System.out.println(dbAcc1 +"님이 로그인중입니다");
			}else if(log == 2) {
				System.out.println(dbAcc2 +"님이 로그인중입니다");
			}
			
			
			System.out.print("메뉴 선택 : ");
			int sel =sc.nextInt();
			
			if(sel == 1) {
				if(log == -1) {
					// 로그인
					System.out.print("아이디를 입력해주세요 : ");
					int inputId = sc.nextInt();
					System.out.print("비밀번호를 입력해주세요 : ");
					int inputPw = sc.nextInt();
					
					if((inputId == dbAcc1 && inputPw == dbPw1) || (inputId == dbAcc2 && inputPw == dbPw2)) {
						System.out.println("로그인 성공");
						if(inputId == dbAcc1) {
							log = 1;
						}else if(inputId == dbAcc2) {
							log = 2;
						}
					}else {
						System.err.println("로그인 실패");
					}
				}
				
			}else if(sel == 2) {
				// 로그아웃
				if(log != -1) {
					System.out.println("로그아웃 하셨습니다.");
					log = -1;
				}
			}else if(sel == 3) {
				// 입금
				if(log != -1) {
					if(log == 1) {
						System.out.print("입금할 금액을 입력해주세요 : ");
						int inputMoney = sc.nextInt();
						
						if(inputMoney > 0 && inputMoney <= dbMoney1) {
							dbBalance1 += inputMoney;
							dbMoney1 -= inputMoney;
							System.out.printf("%d원 만큼 입금하셨습니다.   통장잔액 : %d원 \n", inputMoney, dbBalance1);
						}else {
							System.err.println("현금이 부족합니다");
						}
					}else if(log == 2) {
						System.out.print("입금할 금액을 입력해주세요");
						int inputMoney = sc.nextInt();
						
						if(inputMoney > 0 && inputMoney <= dbMoney2) {
							dbBalance2 += inputMoney;
							dbMoney2 -= inputMoney;
							System.out.printf("%d원 만큼 입금하셨습니다.   통장잔액 : %d원 \n", inputMoney, dbBalance2);
						}else {
							System.err.println("현금이 부족합니다");
						}
					}
				}
			}else if(sel == 4) {
				// 출금
				if(log == 1) {
					System.out.print("출금할 금액을 입력해주세요 : ");
					int inputMoney = sc.nextInt();
					
					if(inputMoney > 0 && inputMoney <= dbBalance1) {
						dbMoney1 += inputMoney;
						dbBalance1 -= inputMoney;
						System.out.printf("%d원 만큼 출금하셨습니다.   통장잔액 : %d원 \n", inputMoney, dbBalance1);
					}else {
						System.err.println("통장 잔액이 부족합니다");
					}
				}else if(log == 2) {
					System.out.print("출금할 금액을 입력해주세요 : ");
					int inputMoney = sc.nextInt();
					
					if(inputMoney > 0 && inputMoney <= dbBalance2) {
						dbMoney2 += inputMoney;
						dbBalance2 -= inputMoney;
						System.out.printf("%d원 만큼 출금하셨습니다.   통장잔액 : %d원 \n", inputMoney, dbBalance2);
					}else {
						System.err.println("통장 잔액이 부족합니다");
					}
				}
				
			}else if(sel == 5) {
				//이체
				if(log == 1) {
					System.out.print("이체할 아이디를 입력해 주세요 : ");
					int intputId = sc.nextInt();
					
					if(intputId == dbAcc2) {
						System.out.print("이체할 금액을 입력해주세요 : ");
						int inputMoney = sc.nextInt();
						if(inputMoney >0 && inputMoney <= dbMoney1) {
							dbMoney1 -= inputMoney;
							dbBalance2 += inputMoney;
							//System.out.printf("이체가 완료되었습니다. 이체한금액 : %d원 상대계좌%d \n", inputMoney ,dbBalance2);
							System.out.printf("이체가 완료되었습니다. 이체한금액 : %d원\n", inputMoney);

						}else {
							System.err.println("현금이 부족합니다");
						}
					}else {
						System.err.println("없는 아이디 입니다");
					}
				}else if(log == 2) {
					System.out.print("이체할 아이디를 입력해 주세요 : ");
					int intputId = sc.nextInt();
					
					if(intputId == dbAcc1) {
						System.out.print("이체할 금액을 입력해주세요");
						int inputMoney = sc.nextInt();
						if(inputMoney >0 && inputMoney <= dbMoney2) {
							dbMoney2 -= inputMoney;
							dbBalance1 += inputMoney;
							//System.out.printf("이체가 완료되었습니다. 이체한금액 : %d원 상대계좌%d \n", inputMoney ,dbBalance1);
							System.out.printf("이체가 완료되었습니다. 이체한금액 : %d원\n", inputMoney);
						}else {
							System.err.println("현금이 부족합니다");
						}
					}else {
						System.err.println("없는 아이디 입니다");
					}
				}
				
			}else if(sel == 6) {
				if(log == 1) {
					System.out.printf("계좌 잔액은 %d원입니다. \n", dbBalance1);
				}else if(log == 2) {
					System.out.printf("계좌 잔액은 %d원입니다. \n", dbBalance2);
				}
				//조회
			}else if(sel == 0) {
				run = false;
				System.out.println("프로그램 종료");
			}
		
		
		}
	}

}
