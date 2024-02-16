package test.lv5;

import java.util.Arrays;
import java.util.Scanner;

public class test03 {
	//시작 12:04
	//종료 12:44
	//소요 00:40
	public static void main(String[] args) {
		// Lv5 Test
		
		//3.
		// 식권 자판기 프로그램
		//1) 관리자
		//	 ㄴ식권 충전
		//   ㄴ화폐 충전
		//   ㄴ뒤로가기
		//2) 사용자
		//   ㄴ 구입(최소 화폐단위로 연산 -> 잔돈에 대한 화폐의 개수도 보여줄것
		//   ㄴ 뒤로가기
		
		Scanner sc = new Scanner(System.in);
		final int SIZE = 6;
		int[] money =   {50000, 10000, 5000, 1000, 500, 100};
		int[] charges = {    11,     11,    11,    11,   15,  101};
		
		
		int tickets = 5;		//식권 개수
		int price = 3200;		//식권 가격
		
		while(true) {
			
			System.out.println("1.관리자  2.사용자");
			System.out.print("선택 :");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				while(true) {
					System.out.println("1.식권충전 2.화폐충전 3. 뒤로가기");
					System.out.print("선택 :");
					int sel = sc.nextInt();
					
					if(sel == 1) {
						System.out.print("충전할 갯수 : ");
						int ticket = sc.nextInt();
						
						if(ticket <= 0) {
							System.out.println("0개이하 입력불가");
							continue;
						}
						tickets += ticket;
						System.out.println("티켓 : " + tickets);
					}else if(sel == 2) {
						for(int i=0; i<SIZE; i++) {
							System.out.printf("%d. %d   ",i+1,money[i]);
						}
						System.out.print("\n추가할 금액권 선택 : ");
						int idx = sc.nextInt()-1;
						
						if(idx < 0 || idx >= SIZE-1) {
							System.out.println("없는 인덱스");
							continue;
						}
						System.out.print("추가할 갯수 입력 : ");
						int num = sc.nextInt();
						if(num <= 0) {
							System.out.println("0개이하 충전불가");
							continue;
						}
						charges[idx] += num; 
						System.out.println("현재 잔액상태 ");
						System.out.println(Arrays.toString(money));
						System.out.println(Arrays.toString(charges));
						
					}else if(sel == 3) {
						break;
					}
				}
					
			}else if(choice == 2) {
				while(true) {
					System.out.println(Arrays.toString(money));
					System.out.println(Arrays.toString(charges));
					System.out.println("1. 구입 2. 뒤로가기");
					System.out.print("선택 : ");
					int sel = sc.nextInt();
					
					if(sel == 1) {
						boolean buy = false;
						System.out.print("구입할 갯수 입력 :");
						int ticket = sc.nextInt();
						
						if(ticket <= 0) {
							System.out.println("0개이하 구매불가");
							continue;
						}
						
						System.out.print("금액입력 : ");
						int cash = sc.nextInt();
						
						if(cash <= 0) {
							System.out.println("0원 이하의 금액은 불가");
							continue;
						}else if(cash < ticket*price) {
							System.out.println("구매할 식권 가격보다 낮습니다");
							continue;
						}
						
						int total = ticket*price;
						int charge = cash-total;
						int[] tempCharges = charges.clone();
						int[] chargeArr = new int[SIZE];
						for(int i=0; i<SIZE; i++) {
							if(money[i] <= cash) {
								cash -= money[i];
								tempCharges[i]++;
								i--;
							}
						}
						
						for(int i=0; i<SIZE; i++) {
							if(money[i] <= charge && tempCharges[i] != 0) {
								charge -= money[i];
								tempCharges[i]--;
								chargeArr[i]++;
								i--;
							}
							
							if(i == SIZE-1 && charge == 0) {
								buy = true;
							}
						}
						
						if(buy) {
							tickets -= ticket;
							charges = tempCharges;
							System.out.println("구매 성공");
							System.out.println("반환받은 금액");
							for(int i=0; i<SIZE; i++) {
								System.out.printf("%d권 %d개 \n",money[i],chargeArr[i]);
							}
						}else {
							System.out.println("잔독 부족 관리자한테 문의");
						}
						
						
					}else if(sel == 2) {
						break;
					}
				}
			}
			
			
		}
		
	}

}
