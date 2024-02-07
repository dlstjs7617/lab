package lv04;

import java.util.Scanner;

public class Ex20_t {
	
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
		
		int itemCount = 0;
		String[][] items = new String[100][2];
		
		for(int i=0; i<items.length; i++) {
			items[i][0] = ""; // null -> 빈 문자열로 초기화
			items[i][1] = "";
		}
		
		
		while(true) {			
			System.out.println("[관리자모드]");
			System.out.println("[1]카테고리 관리");
			System.out.println("[2]아 이 템 관리");
			System.out.println("[3]전체품목 출력");
			
			System.out.print(" : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				if(itemCount == items.length) {
					System.out.println("더이상 추가할 수 없습니다.");
					continue;					
				}
				System.out.print("추가할 카테고리명 : ");
				String cateName = sc.next();
				
				//중복검사
				boolean isDupl = false;
				for(int i=0; i<itemCount; i++) {
					if(cateName.equals(items[i][0]))
						isDupl = true;
				}
				
				if(!isDupl) {
					//카테고리 추가
					items[itemCount][0] = cateName;
					itemCount ++;
				}else
					System.out.println("중복된 카테고리명입니다.");
				
			}else if(sel == 2) {
				// 카테고리 출력
				for(int i=0; i<itemCount; i++) {
					System.out.printf("%d %s\n", i+1, items[i][0]);
					System.out.print("카테고리 선택(번호) : ");
					int cateIdx = sc.nextInt()-1;
					
					// 인덱스 예외처리
					if(cateIdx < 0 || cateIdx >= itemCount) {
						System.out.println("번호입력오류");
						continue;
					}
					
					System.out.print("추가할 아이템 : ");
					String item = sc.next();
					
					items[cateIdx][1] += item +"/";
				}
			
			}else if(sel == 3) {
				for(int i=0; i<itemCount; i++) {
					System.out.printf("%d) %s : %s\n", i+1, items[i][0], items[i][1]);
				}
				
				
			}
		}
		

	}

}
