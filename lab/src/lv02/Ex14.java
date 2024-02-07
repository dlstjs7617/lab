package lv02;

import java.util.Scanner;

public class Ex14 {

	/*
	 * # 쇼핑몰 뒤로가기
	 * 
	 * 문제) 쇼핑몰메인메뉴에서 남성의류 선택해서 뒤로가기 누르기전까지 남성의류 페이지를 유지하려고한다. 힌트) 계층 별로 반복문을 추가 해주면
	 * 된다 1. 남성의류 1) 티셔츠 2) 바지 3) 뒤로가기 2. 여성의류 1) 가디건 2) 치마 3) 뒤로가기 3. 종료
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		boolean run = true;
		while(run) {
			System.out.println("1.남성의류");
			System.out.println("2.여성의류");
			System.out.println("3.종료");

			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();

			if(sel == 1) {
				boolean selRun = true;
				
				while(selRun) {
					System.out.println("1)티셔츠)");
					System.out.println("2)바지");
					System.out.println("3)뒤로가기");
					
					int num = sc.nextInt();
					if(num == 3) selRun =false;
				}
			}else if(sel == 2) {
				boolean selRun = true;
				
				while(selRun) {
					System.out.println("1)가디건");
					System.out.println("2)치마");
					System.out.println("3)뒤로가기");
					
					int num = sc.nextInt();
					if(num == 3) selRun =false;
				}
			}else if(sel == 3) {
				run = false;
				System.out.println("프로그램 종료");
			}

		}

	}

}
