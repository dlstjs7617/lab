package lv03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex23 {
	
	/*
	 * # 회원가입
	 * 1. 가입
	 * . 아이디 와 비밀번호를 입력받아 기입
	 * . 아이디 중복검사
	 * 2. 탈퇴
	 * . 아이디를 입력받아 탈퇴 
	 */
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] ids = { 1001, 1002, 0, 0, 0 };
		int[] pws = { 1111, 2222, 0, 0, 0 };
		
		int cnt = 2;
		
		boolean run = true;
		
		while(run) {
			System.out.println(Arrays.toString(ids));
			System.out.println(Arrays.toString(pws));
			System.out.println("---------------------");
			System.out.println("회원가입");
			System.out.println("1. 가입   2.탈퇴");
			System.out.println("---------------------");
			System.out.print("메뉴를 선택해 주세요 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				System.out.print("아이디를 입력해주세요 : ");
				int id = sc.nextInt();
				for(int i=0; i<5; i++) {
					if(id == ids[i]) {	//예외
						System.err.println("이미 사용중인 아이디입니다");
						break;
					}else if(cnt >=5) { //예외
						System.err.println("배열이 꽉찼습니다.");
						break;
					}
					
					if(ids[i] == 0) {	//정상처리
						System.out.print("비밀번호를 입력해주세요 : ");
						int pw = sc.nextInt();
						ids[cnt] = id;
						pws[cnt] = pw;
						cnt++;
						break;
					}
				}
			}else if(sel == 2) { // 탈퇴
				System.out.print("탈퇴할 아이디를 입력해주세요 : ");
				int id = sc.nextInt();
				System.out.print("탈퇴할 비밀번호를 입력해주세요 : ");
				int pw = sc.nextInt();
				int notCnt = 0;
				for(int i=0; i<5; i++) {	//삭제
					if(id == ids[i] && pw == pws[i]){
						ids[i] = 0;
						pws[i] = 0;
						cnt--;
						break;
					}else {
						notCnt++;
					}
				}
				if(notCnt == 5) { //예외출력
					System.err.println("아이디 비밀번호 불일치");
				}
				
			}
			//배열 정렬
			for(int i=0; i<4; i++) {
				if(ids[i] == 0 && ids[i+1] != 0) {
					ids[i] = ids[i+1];
					pws[i] = pws[i+1];
					ids[i+1] = 0;
					pws[i+1] = 0;
				}
			}
		}
	}
}