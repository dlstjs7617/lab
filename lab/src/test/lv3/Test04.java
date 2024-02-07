package test.lv3;

import java.util.Scanner;

public class Test04 {
	//시작 43:30
	//종료 31:00
	//소요 47:30
	public static void main(String[] args) {
		//Level Test 3
		
		//4.
		
		/*
		 *  # 회원가입
		 *  1. 가입
		 *  . 아이디 와 비밀번호를 입력받아 가입
		 *  . 아이디 중복검사
		 *  2. 탈퇴
		 *  . 아이디와 비밀번호를 입력받아 탈퇴
		 *  . 탈퇴 시, 비어있는 인덱스까지 값 당기기
		 */
		
		Scanner sc = new Scanner(System.in);
		
		final int MAX = 5;
		int cnt = 0;
		
		int[] ids = new int[MAX];
		int[] pws = new int[MAX];
		
		boolean isRun = true;
		
		while(isRun) {

			int error = 0;
			for(int i=0; i<MAX; i++) {
				System.out.printf("%d / %d \n", ids[i], pws[i]);
			}
			
			System.out.println("1. 가입    2. 탈퇴");
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				if(cnt == MAX) {
					System.out.println("회원수 초과");
					continue;
				}
				System.out.print("가입할 아이디입력 : ");
				int id = sc.nextInt();
				System.out.print("비밀번호 입력: ");
				int pw = sc.nextInt();
				
				for(int i = 0; i<MAX; i++) {					
					if(id == ids[i]) 
						error = 1;
				}
				if(error == 0) {
					ids[cnt] = id;
					pws[cnt] = pw;
					cnt++;
				}
				if(error == 1)
					System.out.println("이미 사용중인 아이디 입니다.");
				
			}else if(sel == 2) {
				System.out.print("탈퇴할 아이디를 입력해주세요 : ");
				int id = sc.nextInt();
				System.out.print("비밀번호를 입력해주세요 : ");
				int pw = sc.nextInt();
				
				if(id == 0 ) {
					System.out.println("초기값 예외처리");
					continue;
				}
				
				int index = -1;
				for(int i=0; i<cnt; i++) {
					if(ids[i] == id && pws[i] == pw) {
						index = i;
					}
				}
				
				if(index != -1) {
					ids[index] = 0;
					pws[index] = 0;
					cnt--;
					System.out.println("회원 탈퇴 완료");
					for(int i=0; i<4; i++) {
						if(ids[i] == 0) {
							ids[i] = ids[i+1];
							pws[i] = pws[i+1];
							pws[i+1] = 0;
							ids[i+1] = 0;
						}
					}
				}else {
					System.out.println("아이디 혹은 비밀번호가 다릅니다.");
				}
				
				
//				
//				for(int i=0; i<MAX; i++) {
//					if(id != ids[i] || pw != pws[i]) {
//						ids[i] = 0;
//						pws[i] = 0;
//						cnt--;
//						System.out.println("탈퇴가 완료되었습니다.");
//						break;
//					}
//				}
			}
			
			
			
			System.out.println();
		}
	}

}
