package lv05;

import java.util.Arrays;
import java.util.Scanner;

public class Ex28_t {
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
		
		int[] money   = {50000, 10000, 5000, 1000, 500, 100};	//화폐단위
		int[] charges = {	 1,     1,    1,    1, 	 5,  10};	// 돈통 화폐 잔여 개수
		
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
						System.out.print("충전할 식권 개수 : ");
						int add = sc.nextInt();
						
						if(add < 1)
							continue;
						
						tickets += add;
						System.out.printf("현재 남은 티켓 수는 %d장입니다.", tickets);
					}else if(choice == 2) {			// 잔돈 충전
						for(int i=0; i<money.length; i++) {
							System.out.printf("%d) %d원권 (%d)장\n", i+1, money[i], charges[i]);
						}
						System.out.print("화폐 선택 : ");
						int idx = sc.nextInt()-1;
						
						
						System.out.println("충전 매수 : ");
						int add = sc.nextInt();
						
						if(idx < 0 || idx >= money.length || add < 1)
							continue;
						
						charges[idx] += add;
						System.out.println("충전 완료되었습니다.");
						
						 
						
						
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
						// 1. 식권 매수 입력 받아
						// 1-1 보유 식권 이하 예외처리
						// 2. 총 금액을 제시
						// 3. 현금 지급 처리
						// 3-1 총 금액 <= 현금
						// 3-2 잔돈 반환이 필요한 경우 -> 연산
						// 3-2-1. 돌려줄 잔돈에 대한 화폐 권수가 모자라면 안됨
						
						System.out.println("구매할 식권 매수 :");
						int cnt = sc.nextInt();
						
						if(cnt < 1 || cnt > tickets) {
							System.out.println("식권이 부족합니다. 관리자에게 문의하세요.");
							continue;
						}
						
						int total = cnt * PRICE;
						System.out.printf("총 금액은 %d원입니다. \n", total);
						
						System.out.print("현금 지급 : ");
						int cash = sc.nextInt();
						
						if(cash < total) {
							System.out.println("현금이 부족합니다.");
							continue;
						}
						
						int change = cash - total;
						int changeCopy = change;
						// 1) 받은 화폐를 최소 화폐 연산 -> 돈통에 넣고
						// 2) 잔돈을 최소 화폐 연산 -> 돈통에 뺴기
						// 	  ㄴ 돌려줄 화폐가 모자라면 -> 원복
						
//						int[] temp = charges;					// 주소를 공유하게되면 -> 복사가 아님
//						int[] temp = new int[charges.length]; 	// 새로운 주소로 분리 후,
//						for(int i=0; i<temp.length; i++) {
//							temp[i] = charges[i];				// 값 복사
//						}
						
						int[] temp = charges.clone();			//배열변수.clone() -> 해달 배열의 복제본을 힙에 만들어줌
						// 들어온 돈
						for(int i=0; i<money.length; i++) {
							if(cash >= money[i]) {
								cash -= money[i];
								temp[i]++;
								i -- ;
							}
						}

						int[] changeCnt = new int[temp.length];
						
						// 나가는 돈
						for(int i=0; i<money.length; i++) {
							if(change >= money[i] && temp[i] > 0) {
								change -= money[i];
								changeCnt[i] ++;
								temp[i]--;
								i--;
							}
						}
						
						// 다돌려줬나 확인
						if(change >0) {
							System.out.println("잔액이 부족합니다. 관리자에게 문의하세요");
							continue;
						}
						// 복사본 ->charges 에게 돌려주기
						charges = temp;
						
						// 잔돈이 있다면 화폐 권수를 보여주기
						System.out.println("-----------------------");
						System.out.printf("거스름 돈 : %d\n", changeCopy);
						System.out.println("-----------------------");
						for(int i=0; i<changeCnt.length; i++) {
							if(changeCnt[i] > 0) {
								System.out.printf("%d원권 %d개 \n", money[i], changeCnt[i]);
							}
						}
						System.out.println("-----------------------");
						
						//티켓 차감
						tickets -= cnt;
						System.out.println("식권 구매 완료");
					}else if(choice == 2) {			// 뒤로가기
						break;
					}
				}
			}
			
			
			
		}	//자판기 while
	}

}
