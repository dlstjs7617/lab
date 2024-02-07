package lv03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex23_t {
	
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
			for(int i=0; i<5; i++) {
				System.out.printf("%d) %d/%d\n", i+1, ids[i], pws[i]);
			}
			System.out.println("1) 가입");
			System.out.println("1) 탈퇴");
			
			System.out.println("선택 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				if(cnt == 5) {
					System.out.println("가입 정원 마감");
					continue;
				}
				
				
				
				System.out.print("id : ");
				int id = sc.nextInt();
				System.out.print("id : ");
				int pw = sc.nextInt();
				
				// 사용자가 입력한 id가 중복여부 확인
				int index = -1;
				for(int i=0; i<cnt; i++) {
					if(ids[i] == id)
						index = i;
				}
				
				// 가입처리
				if(index == -1) {
					ids[cnt] = id;
					pws[cnt] = pw;
					cnt ++;
					System.out.println("가입완료");
				}else {
					System.out.println("이미 사용중인 아이디입니다.");
				}
				
				
			}
			else if(sel == 2) {
				System.out.print("id : ");
				int id = sc.nextInt();
				System.out.print("id : ");
				int pw = sc.nextInt();
				
				int index = -1;
				for(int i=0; i<cnt; i++) {
					if(ids[i] == id && pws[i] == pw)
						index = i;
				}
				
				//탈퇴 처리
				if(index != -1) {
					for(int i=index; i<cnt-1; i++) {
						ids[i] = ids[i+1];
						pws[i] = pws[i+1];
					}
					ids[cnt-1] = 0;
					pws[cnt-1] = 0;
					cnt--;
					System.out.println("탈퇴 완료");
				}else {
					System.out.println("회원정보가 잘못되었습니다.");
				}
			}
		}
	}
}