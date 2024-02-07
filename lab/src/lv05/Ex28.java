package lv05;

import java.util.Arrays;
import java.util.Scanner;

public class Ex28 {
	// 식권 자판기 프로그램(최소 화폐 연산)
	
	// 1) 관리자 2) 사용자
	// 관리자 ==>	 1) 식권충전	2) 잔돈 충전	3) 뒤로가기
	// 사용자 ==>	 1) 구입	==>	입금 금액 입력	==> 구매 매수 입력 ==> 잔돈출력
	//			 2)뒤로가기
	// 조건) 예) 잔돈이 7600원이다. 5000원권이 없으면 1000원짜리 7장 출력
	// 화면
	// 식권 가격 : 3200원
	// 식권	   : ??매 (매진시 매진)
	// 50000원	 : ??매		// 10000원 : ?? 매	// 5000원 : ??매
	// 1000원	: ??매		// 500원 : ??매		// 100원	 : ??매	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] money   = {50000, 10000, 5000, 1000, 500, 100};
		int[] charges = {	 1,     1,    1,    1, 	 5,  10};
		
		int tickets = 5;		// 식권 개수
		final int PRICE = 3200;	// 식권 가격
		
		while(true) {
			//검수용 출력문
			System.out.println("식권 : " + tickets);
			System.out.println(Arrays.toString(charges));
			
			System.out.println("[1]관리자");
			System.out.println("[2]사용자");
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {		//관리자
				while(true) {
					System.out.println("1)식권충전");
					System.out.println("2)잔돈충전");
					System.out.println("3)뒤로가기");
					
					System.out.print("메뉴 선택 : ");
					int choice = sc.nextInt();
					
					if(choice == 1) {				// 식권 충전
						System.out.print("충전할 매수 선택 : ");
						int ticket = sc.nextInt();
						
						// 식권 입력 예외처리
						if(ticket <= 0) {
							System.err.println("티켓은 0장 이하 불가");
							break;
						}
						
						tickets += ticket;
						
					}else if(choice == 2) {			// 잔돈 충전
						System.out.print("충전할 잔돈 입력 : ");
						int charge = sc.nextInt();
						
						// 잔돈 입력 예외처리
						if(charge <= 0) {
							System.err.println("잔돈은 0원 이하 불가");
							continue;
						}
						int idx = 0;
						while(charge > 100) {
							
							if(charge >= money[idx]) {
								charge -= money[idx];
								charges[idx]++;
							}
							
							if(charge < money[idx]) {
								idx++;
							}
							if(charge < 100)
								System.out.println("충전하고 남은 잔돈 : " + charge);
							
						}
						
					}else if(choice == 3) {			// 뒤로가기
						break;
					}
				}
			}else if(sel == 2) {
				while(true) {
					System.out.println("1)구입");
					System.out.println("2)뒤로가기");
					
					System.out.print("메뉴 선택 : ");
					int choice = sc.nextInt();
					
					if(choice == 1) {				// 구입
						System.out.print("입금 금액 : ");
						int cash = sc.nextInt();
						
						//금액 예외처리
						if(cash < PRICE) {
							System.err.println("식권 금액보다 낮습니다.");
							continue;
						}
						
						System.out.print("구입할 식권 갯수 : ");
						int ticket = sc.nextInt();
						
						int total = ticket*PRICE;
						// 식권 예외처리
						if(ticket <= 0) {
							System.err.println("0개 이하는 구입하실 수 없습니다.");
							continue;
						}else if(total > cash) {		//전체가격>입금금액 예외처리
							System.out.println("입금 하신 금액보다 구매수량값이 높습니다.");
							continue;
						}
						int coin = cash-total;
						int idx = 0;
						int[] temp = new int[money.length];
						boolean trade = false;
						while(idx != money.length) {
							if(coin > money[idx] && charges[idx] != 0) {
								coin -= money[idx];
								temp[idx]++;
							}else {
								idx++;
							}
							if(coin == 0) {
								trade = true;
							}
						}
						if(trade) {
							System.out.println("===거스름돈===");
							for(int i=0; i<temp.length; i++) {
								System.out.printf("%d원권 %d개",money[i],temp[i]);
							}
						}
						
						
					}else if(choice == 2) {			// 뒤로가기
						break;
					}
				}
			}
			
			
			
		}	//자판기 while
	}

}
