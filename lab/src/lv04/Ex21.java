package lv04;

import java.util.Arrays;
import java.util.Scanner;

public class Ex21 {
	/*
	 * # 쇼핑몰[장바구니]
	 * 1. 로그인 후 쇼핑 메뉴를 선택하면, 다음과 같이 상품목록을 보여준다.
	 * 	1) 사과
	 * 	2) 바나나
	 * 	3) 딸기
	 * 2. 번호를 선택해 상품을 장바구니에 담을 수 있다.
	 * 3. 로그인 회원의 인덱스 번호는 각 행의 첫번째 열에 저장한다.
	 * 4. 해당 회원이 구매한 상품의 인덱스 번호는 각 행의 두번째 열에 저장한다.
	 * 예)
	 * {
	 * 		{0, 1},		qwer회원			> 사과구매
	 * 		{1, 2},		javaking회원		> 바나나구매
	 * 		{2, 1},		abcd회원			> 사과구매
	 * 		{0, 3},		qwer회원			> 딸기구매
	 */

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int log = -1;
		
		int cnt = 0;			// 회원
		String[] ids = null;
		String[] pwd = null;
		
		int size = 0;			// 장바구니 길이(jang)
		int[][] jang = null;

		String[] items = {"사과", "바나나", "딸기"};
		
		while(true){
			
			System.out.println("[MEGA MART]");			
			System.out.println("[1]회원가입");
			System.out.println("[2]탈	퇴");
			// 탈퇴 시, 구매 기록 삭제까지만
			// ㄴ 기존 log 인덱스에 대한 변경 생략
			/*
			 * {
			 * {0,1},
			 * {0,1},
			 * {1,0},
			 * {2,1},
			 * {0,0}
			 * }
			 */
			System.out.println("[3]로 그 인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]쇼	핑");
			System.out.println("[6]장바구니");
			/*
			 * id : apple [0] 회원이 쇼핑
			 * 사과 구매
			 * 바나나 구매
			 * 딸기 구매
			 * 사과 구매
			 * 바나나 구매
			 * 사과 구매
			 * -> 장바구니
			 * 사과 3개
			 * 바나나 2개
			 * 딸기 1개
			 * 
			 * 사과 3개
			 * 바나나 2개
			 * 딸기 1개
			 * 
			 */
			System.out.println("[0]종	료");
			
			if(log != -1)
				System.out.printf("%s님 로그인중", ids[log]);
			
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			//메뉴 선택 예외처리
			if(sel == 2 && log == -1 || sel == 4 && log == -1 || sel == 5 && log == -1 || sel == 6 && log == -1) {
				System.out.println("로그인 후 이용가능");
				continue;
			}else if(sel == 1 && log != -1 || sel == 3 && log != -1) {
				System.out.println("로그인중 이용불가");
				continue;
			}
			
			if(sel == 1) {
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				
				//아이디 중복검사
				boolean isDupl = false;
				for(int i=0; i<cnt; i++) {
					if(id.equals(ids[i])) {
						System.out.println("이미 사용중인 아이디입니다.");
						isDupl = true;						
					}
				}
				// 배열늘려 입력
				if(!isDupl) {
					String[] idTemp = new String[cnt+1];
					String[] pwTemp = new String[cnt+1];
					System.out.print("비밀번호 입력 : ");
					String pw = sc.next();

					for(int i=0; i<cnt; i++) {
						idTemp[i] = ids[i];
						pwTemp[i] = pwd[i];
					}
					
					idTemp[cnt] = id;
					pwTemp[cnt] = pw;
					
					ids = idTemp;
					pwd = pwTemp;
					cnt++;
				}
				
			}else if(sel == 2) {
				System.out.print("탈퇴할 아이디 입력 : ");
				String id = sc.next();
				System.out.print("탈퇴한 비번 입력 : ");
				String pw = sc.next();
				
				// 아이디 비번검사
				boolean isDupl = false;
				for(int i=0; i<cnt; i++) {
					if(id.equals(ids[i]) && pw.equals(pwd[i])){
						isDupl = true;
					}
				}
				
				//계정 삭제처리
				if(isDupl) {
					for(int i=0; i<cnt-1; i++) {
						ids[log] = ids[log+1];
						pwd[log] = pwd[log+1];
					}
					
					cnt--;
					
					String[] idTemp = new String[cnt];
					String[] pwTemp = new String[cnt];
					
					for(int i=0; i<cnt; i++) {
						idTemp[i] = ids[i];
						pwTemp[i] = pwd[i];
					}
					
					ids = idTemp;
					pwd = pwTemp;
				}else {
					System.out.println("아이디/비밀번호가 다릅니다.");
				}
			}else if(sel == 3) {
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();
				
				boolean isDupl = false;
				// 아이디비번검사
				for(int i=0; i<cnt; i++) {
					if(id.equals(ids[i]) && pw.equals(pwd[i])){
						isDupl = true;
						log = i;
					}
				}
				
				if(isDupl) 
					System.out.printf("로그인 성공 %s님 환영합니다. \n", ids[log]);
				else
					System.out.println("아이디/비번이 다릅니다");
				
			}else if(sel == 4) {
				log = -1;
				System.out.println("로그아웃 되셨습니다.");
			}else if(sel == 5) {
				int[][] temp = new int[size+1][2];
				System.out.println("1)사과 2)바나나 3)딸기");
				System.out.print("선택 :");
				int input = sc.nextInt();
				
				if(input < 0 || input > 3) {
					System.out.println("잘못된 입력입니다");
					continue;
				}
				
				for(int i=0; i<size; i++) {
					for(int j=0; j<2; j++) {
						temp[i][j] = jang[i][j];
					}
				}
				temp[size][0] = log;
				temp[size][1] = input;
				jang = temp;
				size++;
				for(int i=0; i<jang.length; i++) {
					for(int j=0; j<jang[i].length; j++) {
						System.out.print(jang[i][j] + " ");						
					}
					System.out.println();
				}
			}else if(sel == 6) {
				int[] num = new int[3];
				for(int i=0; i<jang.length; i++) {
					if(jang[i][0] == log) {
						if(jang[i][1] == 1) {
							num[0]++;
						}else if(jang[i][1] == 2) {
							num[1]++;							
						}else if(jang[i][1] == 3) {
							num[2]++;							
						}					
					}
				}
				System.out.printf("%s 님의 장바구니 \n", ids[log]);
				System.out.printf("사과 %d개\n",num[0]);
				System.out.printf("바나나 %d개\n",num[1]);
				System.out.printf("딸기 %d개\n",num[2]);
				
			}else if(sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

}
