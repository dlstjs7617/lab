package lv03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex23_1 {
	
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
			System.out.println("회원가입");
			System.out.println(" 1. 가입   2.탈퇴");
			System.out.print("메뉴를 선택해 주세요.");
			int sel = sc.nextInt();
			
			
			if(sel == 1) {
				System.out.print("아이디를 입력해 주세요. : ");
				int id = sc.nextInt();
				
				for(int i=0; i<5; i++) {
					if(id == ids[i]) {
						System.out.println("이미 사용중인 아이디입니다.");
						break;
					}else if(cnt >= 5){
						System.out.println("배열정원초과");
						break;
					}else if(ids[i] == 0) {
						System.out.print("비밀번호를 입력해 주세요 : ");
						int pw = sc.nextInt();
						ids[i] = id;
						pws[i] = pw;
						cnt++;
						break;
					}
				}
				
			}else if(sel == 2) {
				System.out.println("삭제할 아이디를 입력해주세요");
				int del = sc.nextInt();
				
				for(int i=0; i<5; i++) {
					if(del == ids[i]) {
						ids[i] = 0;
						pws[i] = 0;
						cnt--;
					}
				}
			}
			System.out.println(cnt);
			
		}
		
		
		
	}

}
