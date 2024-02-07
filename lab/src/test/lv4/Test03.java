package test.lv4;

import java.util.Scanner;

public class Test03 {
	// 시작 12:38
	// 종료 13:57
	// 소요 00:22
	public static void main(String[] args) {
		// 3.
		/*
		 * # 쇼핑몰[관리자] - 벡터로 구현
		 * 1. 카테고리와 아이템을 입력받아 아래의 예시와 같이 저장한다.
		 * 2. 카테고리는 각 행의 첫번째 열에 저장한다.(중복 예외처리)
		 * 3. 아이템은 각 행의 두번째 열에 저장한다.
		 * 단, 아이템은 여러개를 추가할 수 있도록 슬래시(/)를 구분자로 연결해준다.
		 * 예)
		 * {
		 * 			{"과일", "사과/포도/"},
		 * 			{"과자", "홈런볼/쪼리퐁/"},
		 * 			{"음료", "콜라/"},
		 * 			{"육류", "소고기/"},
		 * 			...
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int itemCount = 0;
		String[][] items = null;
		
		while(true) {
			if(items != null) {
				for(int i=0; i<items.length; i++) {
					for(int j=0; j<2; j++) {
						if(j == 0) {
							System.out.printf("{%s} , ", items[i][j]);
						}else
							System.out.printf("{%s} ", items[i][j]);
					}
					System.out.println();
				}				
			}
			System.out.println("1.카테고리추가 2. 아이템 추가 3.종료");
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(items == null && sel == 2) {
				System.out.println("카테고리가없습니다");
				continue;
			}
			
			
			if(sel == 1) {
				boolean isDupl = false;
				System.out.print("추가할 카테고리 입력 : ");
				String temp = sc.next();
				
				for(int i=0; i<itemCount; i++) {
					if(items[i][0].equals(temp)) {
						isDupl = true;
					}
				}
				if(isDupl) {
					System.out.println("이미 있는 카테고리입니다.");
					continue;
				}
				String[][] tempArr = items;
				items = new String [itemCount+1][2];
				for(int i=0; i<itemCount; i++) {
					for(int j=0; j<2; j++) {
						items[i][j] = tempArr[i][j];
					}
				}
				items[itemCount][0] = temp;
				items[itemCount][1] = "";
				itemCount++;
			}else if(sel == 2) {
				boolean isDupl = false;
				int idx = 0;
				System.out.print("카테고리 입력 : ");
				String cate = sc.next();
				for(int i=0; i<items.length; i++) {
					if(cate.equals(items[i][0])) {
						isDupl = true;
						idx = i;
						
					}
				}
				System.out.println("아이템 입력 :");
				String item = sc.next();
				if(isDupl) {
					items[idx][1] += (item+"/"); 
				}else {
					System.out.println("카테고리 불일치");
				}
				
			}else if(sel == 3) {
				break;
			}
			
		}
	}

}
