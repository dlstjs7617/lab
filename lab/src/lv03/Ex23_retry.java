package lv03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex23_retry {
	
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
			
			int exception = 0;
			if(sel == 1) {
				// 배열초과 예외처리
				if(cnt >=5) {
					System.err.println("배열이 꽉찼습니다.");
					continue;
				}
				
				// 입력
				System.out.print("아이디 입력 : ");
				int id = sc.nextInt();
				System.out.print("비밀번호 입력 : ");
				int pw = sc.nextInt();
				// id중복 예외처리
				for(int i=0; i<cnt; i++) {
					if(id == ids[i]) {
						System.err.println("이미 사용중인 아이디입니다.");
						exception++;
					}
				}
				
				// 예외발생시 탈출
				if(exception > 0) {
					continue;
				}
				
				// 계정 생성
				ids[cnt] = id;
				pws[cnt] = pw;
				cnt++;
				
				
			}else if(sel == 2){
				//입력
				System.out.print("삭제할 아이디를 입력해주세요. : ");
				int id = sc.nextInt();
				System.out.print("삭제할 아이디의 비밀번호를 입력해주세요. : ");
				int pw = sc.nextInt();
				
				for(int i=0; i<cnt; i++) { //계정삭제
					if(id == ids[i] && pw == pws[i]) {
						ids[i] = 0;
						pws[i] = 0;
						cnt--;
					}else {
						exception++;
					}
				}
				
				// 예외발생시 탈출
				if(exception > cnt-1) {
					System.err.println("아이디/비밀번호가 일치하지 않습니다.");
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
			System.out.println("---------------------");

		}
	}
}