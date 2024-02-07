package lv04;

import java.util.Scanner;

public class Ex20 {
	
	/*
	 * # 쇼핑몰 [관리자]
	 * 1. 카테고리와 아이템을 입력받아 아래의 예시와 같이 저장한다.
	 * 2. 카테고리는 각 행의 첫번쨰 열에 저장한다. (중복 예외처리)
	 * 3. 아이템은 각 행의 두번째 열에 저장한다.
	 * 	단, 아이템은 여러개를 추가할 수 있도록 슬래시(/)를 구분자로 연결해준다.
	 *
	 * 예)
	 * {
	 * 		{"과일", "사과/포도/"},
	 * 		{"과자", "홈런볼/쓰리퐁/"},
	 * 		{"음료", "콜라/"},
	 * 		{"육류", "소고기/"}
	 * 		...
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[][] items = new String[100][2];
		String[][] temp = new String[items.length][]; 
		for(int i=0; i<items.length; i++) {
			items[i][0] = "";
			items[i][1] = "";
		}
		
		int itemCount = 0;
		int cateIdx = 0;
		
		while(true) {
			
			System.out.println("[관리자모드]");
			System.out.println("[1]카테고리 관리");
			System.out.println("[2]아 이 템 관리");
			System.out.println("[3]전체품목 출력");
			
			System.out.print(" : ");
			int sel = sc.nextInt();
			if(sel == 1) {
				boolean isDupl= false;
				
				for(int i=0; i<items.length; i++) {
					for(int j=0; j<items[i].length; j++)
						if(items[i][j].equals("") == false) {
							if(j == 0)							
								System.out.printf("{%s}, ", items[i][j]);							
							else
								System.out.printf("{%s}/",items[i][j]);							
							System.out.println();
						}
				}
				
				System.out.print("추가할 카테고리 입력 : ");
				String input = sc.next();
				
				//중복검사
				for(int i=0; i<items.length; i++) {
					if(input.equals(items[i]) == true) {
						isDupl = true;
					}					
				}
				
				// 카테고리 입력
				if(!isDupl) {
					items[cateIdx][0] = input;
					cateIdx++;
				}
			}else if(sel == 2) {
				boolean isDupl= false;
				int idx = -1;
				System.out.print("카테고리를 입력해 주세요 : ");
				String input = sc.next();
				
				for(int i=0; i<items.length; i++) {
					if(input.equals(items[i][0]) == true) {
						isDupl = true;
						idx = i;
						break;
					}
				}
				
				
				if(!isDupl) {
					System.out.println("없는 카테고리입니다.");
				}else {
					System.out.print("추가할 아이템을 입력해주세요 : ");
					String item = sc.next();
					items[idx][1]+=input;
				}
				
			}else if(sel == 3) {
				for(int i=0; i<items.length; i++) {
					for(int j=0; j<items[i].length; j++)
						if(items[i][j].equals("") == false) {
							if(j == 0)							
								System.out.printf("{%s}, ", items[i][j]);							
							else
								System.out.printf("{%s}/",items[i][j]);							
						}
					System.out.println();
				}
			}
		}
		

	}

}
