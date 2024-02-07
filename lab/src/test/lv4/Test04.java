package test.lv4;

import java.util.Arrays;
import java.util.Scanner;

// 시작 14:01
// 종료 00:00
// 소요 00:00
public class Test04 {
	/*
	 * 4.
	 * 
	 * # 쇼핑몰[장바구니]
	 * 1. 로그인 후 쇼핑 메뉴를 선택하면, 다음과 같이 상품목록을 보여준다.
	 * 1) 사과
	 * 	2) 바나나
	 * 	3) 딸기
	 * 2. 번호를 선택해 상품을 장바구니에 담을 수 있다.
	 * 3. 로그인 회원의 인덱스 번호는 각 행의 첫번째 열에 저장한다.
	 * 4. 해당 회원이 구매한 상품의 인덱스 번호는 각 행의 두번째 열에 저장한다.
	 * 예)
	 * {
	 * 		{0,1},				qwer회원			>	사과구매
	 * 		{1,2},				javaking회원		>	바나나구매
	 * 		{2,1},				abcd회원			>	사과구매
	 * 		{0,3},				qwer회원			>	딸기구매
	 * 
	 * 
	 */	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int userCnt = 1;
		String[] ids = {"admin"};
		String[] pws = {"1234"};
		
		int jangCnt = 0;
		int[][] jang = null;
		
		int itemCnt = 3;
		String[] items = {"사과", "바나나", "딸기"};
		
		int log =-1;
		
		while(true) {
			System.out.println("[MAGA MART]");
			System.out.println("[1]회원가입");
			System.out.println("[2]탈   퇴");
			System.out.println("[3]로 그 인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]쇼   핑");
			System.out.println("[6]장바구니");
			System.out.println("[7]관 리 자"); //admin /1234
			// 					[7-1] 아이템 추가
			// 					[7-2] 아이템 삭제
			System.out.println("[8]종   료");
			
			System.out.println(Arrays.toString(ids));
			System.out.println(Arrays.toString(pws));
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(log == -1 && sel == 2 ||log == -1 && sel == 4 || log == -1 && sel == 5 || log == -1 && sel == 6 || log == -1 && sel == 7) {
				System.out.println("로그인후 이용가능");
				continue;
			}
			if(log != -1 && sel == 1 || log != -1 && sel == 3) {
				System.out.println("이미 로그인중입니다.");
				continue;
			}
			
			
			if(sel == 1) {	//회원가입
				boolean isDupl = false;
				System.out.print("ID입력 :");
				String id = sc.next();
				System.out.print("PW입력 :");
				String pw = sc.next();
				
				for(int i=0; i<userCnt; i++) {
					if(id.equals(ids[i])) {
						isDupl = true;
					}
				}
				
				if(isDupl) {
					System.out.println("이미 있는 ID입니다.");
					continue;
				}
				
				String[] tempId = ids;
				String[] tempPw = pws;
				userCnt++;
				ids = new String[userCnt];
				pws = new String[userCnt];
				for(int i=0; i<userCnt-1; i++) {
					ids[i] =tempId[i];
					pws[i] =tempPw[i];
				}
				ids[userCnt-1] = id;
				pws[userCnt-1] = pw;
				
			}else if(sel == 2) {	//탈퇴
				System.out.print("ID 입력 : ");
				String id =sc.next();
				System.out.print("PW 입력 : ");
				String pw =sc.next();
				if(log == 0) {
					System.out.println("관리자 계정탈퇴불가");
					continue;
				}
				if(id.equals(ids[log]) && pw.equals(pws[log])){
					System.out.println("탈퇴되었습니다.");	
				}else {
					System.out.println("아이디/비번 불일치");
					continue;
				}
				
				String[] tempId = ids;
				String[] tempPw = pws;
				ids = new String[userCnt-1];
				pws = new String[userCnt-1];
				for(int i=0; i<ids.length; i++) {
					if(log > i) {
						ids[i] =tempId[i];
						pws[i] =tempPw[i];
					}else {
						ids[i] =tempId[i+1];
						pws[i] =tempPw[i+1];
						
					}
				}
				log = -1;
				userCnt--;
				
			}else if(sel == 3) {	//로그인
				boolean isDupl = false;
				int idx = -1;
				System.out.print("ID입력 : ");
				String id= sc.next();
				System.out.print("PW입력 : ");
				String pw= sc.next();
				
				for(int i=0; i<userCnt; i++) {
					if(id.equals(ids[i])  && pw.equals(pws[i])) {
						isDupl =true;
						idx = i;
					}
				}
				
				if(isDupl) {
					log = idx;
					System.out.println(ids[log] +"님 환영합니다.");
				}else {
					System.out.println("아이디/비밀번호 불일치");
				}
				
				
			}else if(sel == 4) {	//로그아웃
				log = -1;
				System.out.println("로그아웃 되셨습니다.");
			}else if(sel == 5) {	//쇼핑
				
				for(int i=0; i<items.length; i++) {
					System.out.print(i+1 +"번 : " + items[i] + " ");
				}
				System.out.println();
				
				System.out.print("구매하실 품목 선택 :");
				int input = sc.nextInt()-1;
				
				if(input < 0 || input >= items.length) {
					System.out.println("없는 품목");
					continue;
				}
				
				int[][] temp = jang;
				jang = new int[jangCnt+1][2];
				for(int i=0; i<jangCnt; i++) {
					for(int j=0; j<2; j++) {
						jang[i][j]= temp[i][j];
					}
				}
				jang[jangCnt][0] = log;
				jang[jangCnt][1] = input;
				jangCnt++;
			}else if(sel == 6) {	//장바구니
				int[] itemsCnt = new int[items.length];
				System.out.println(ids[log] + "님의 장바구니");
				for(int i=0; i<jang.length; i++) {
					if(jang[i][0] == log) {
						itemsCnt[jang[i][1]]++;
					}
				}
				for(int i=0; i<items.length; i++) {					
					if(itemsCnt[i] != 0)
						System.out.printf("%s ==> %d개 \n",items[i] ,itemsCnt[i]);
				}
			}else if(sel == 7) {	//관리자
				if(ids[log].equals("admin")) {
					System.out.println("관리자님 환영합니다.");
				}else {
					System.out.println("admin이 아닙니다.");
					continue;
				}
				
				System.out.println("7-1아이템 추가");
				System.out.println("7-2아이템 삭제");
				System.out.print("1 or 2 선택 : ");
				int input = sc.nextInt();
				
				if(input == 1) {
					boolean isDupl = false;
					System.out.print("추가할 아이템 입력 : ");
					String item = sc.next();
					
					for(int i=0; i<items.length; i++) {
						if(item.equals(items[i])) {
							isDupl = true;
						}
							
					}
					
					if(isDupl) {
						System.out.println("이미 있는 아이템입니다");
						continue;
					}
					
					String[] tempItems = items;
					items = new String[itemCnt+1];
					for(int i=0; i<itemCnt; i++) {
						items[i] = tempItems[i];
					}
					items[itemCnt] = item;
					itemCnt++;
					
				}else if(input == 2) {
					boolean isDupl = false;
					int idx = -1;
					System.out.print("삭제할 아이템 입력 : ");
					String item = sc.next();
					for(int i=0; i<items.length; i++) {
						if(item.equals(items[i])) {
							isDupl = true;
							idx = i;
						}
					}
					
					if(!isDupl) {
						System.out.println("없는 아이템입니다.");
						continue;
					}
					
					String[] tempItems = items;
					items = new String[itemCnt-1];
					for(int i=0; i<itemCnt-1; i++) {
						if(i < idx) {
							items[i] = tempItems[i];
						}else {
							items[i] = tempItems[i+1];
						}
					}
					itemCnt--; 
				}
				
			}else if(sel == 8) {	//종료
				break;
			}
			
		}
	}	

}
