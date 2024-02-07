package lv04;

import java.util.Random;
import java.util.Scanner;

public class Ex17 {
	/*
	 * # 사다리 게임
	 * 1. 인덱스 0~4를 하나선택한다.
	 * 2. 숫자 0 을 만나면 그냥 아래로 내려간다.
	 * 3. 숫자 1 을 만나면 오른쪽으로 이동후 내려간다.
	 * 4. 숫자 2 를 만나면 왼쪽으로 이동후 내려간다
	 * 5. 오늘의 메뉴 출력
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		//참여인원 입력받기
		System.out.print("참여인원을 입력해주세요 : ");
		int input = sc.nextInt();
		
		String menu[] = new String[input];
		for(int i=0; i<input; i++) {
			System.out.print("메뉴를 입력해 주세요 : ");
			String menuInput = sc.next();
			menu[i] = menuInput;
		}
		
		int[][] ladder = new int[random.nextInt(10)+4][input];
		
		for(int i=0; i<ladder.length; i++) {
			for(int j=0; j<ladder[i].length; j++) {
				int ran = random.nextInt(2);
				ladder[i][j] = ran;
				if(j == ladder[i].length-1)
					ladder[i][j] = 0;
				if(ladder[i][j] == 1)
					ladder[i][j+1] = 2;
			}
		}
		
		
//		int ladder[][] = {
//				{0, 0, 0, 0, 0},
//				{1, 2, 0, 1, 2},
//				{0, 1, 2, 0, 0},
//				{0, 0, 1, 2, 0},
//				{1, 2, 0, 0, 0},
//				{0, 1, 2, 0, 0},
//				{1, 2, 0, 0, 0},
//				{0, 0, 0, 0, 0},
//				{0, 0, 0, 1, 2},
//				{0, 0, 0, 0, 0}};
//		
		boolean isRun = true;
		int[] menuSel = new int[menu.length];
		int temp = -1;
		int sel = -1;
		int cnt = 0;
		
		
		
		
		while(isRun) {
			//사다리타기 구현
			for(int i=0; i<input; i++) {
				System.out.print(" " + (i+1) + " ");				
			}
			System.out.println();
			for(int i=0; i<ladder.length; i++) {
				for(int j=0; j<ladder[i].length; j++) {
					if(ladder[i][j] == 0)
						System.out.print(" │ ");
					else if(ladder[i][j] == 1) {
						System.out.print(" ├ ");												
					}
					else if(ladder[i][j] == 2)
						System.out.print(" ┤ ");
				}
				System.out.println();
			}
			//선택된 사다리 뒤집기
			for(int i=0; i<menuSel.length; i++) {
				if(menuSel[i] == 0)
					System.out.print(" ■ ");
				else {
					System.out.print("(" + menuSel[i] + ")" + menu[i]);
				}
			}
			System.out.println();
			System.out.println("=================");
			if(cnt == 5)
				break;
			System.out.printf("골라(1~5) : ");
			if(sel != -1 || temp != -1)
				System.out.println(sel+"번 메뉴 : " + menu[temp]);
			sel = sc.nextInt();
			// 인덱스 범위 밖 예외처리
			if(sel < 1 || sel > 5) {
				System.out.println("다시 입력해 주세요");
				continue;
			}
			//중복 선택 예외처리
			int exception = 0;
			for(int i=0; i<menuSel.length; i++) {
				if(menuSel[i] == sel)
					exception = 1;
			}
			if(exception == 1) {
				System.out.println("이미 선택된 번호입니다.");
				continue;
			}
			//사타리 타기
			temp = sel-1;
			for(int i=0; i<ladder.length; i ++) {
					if(ladder[i][temp] == 1) {
						temp++;
					}
					else if(ladder[i][temp] == 2) {
						temp--;
					}
				
			}
			//선택된 배열 저장
			menuSel[temp] = sel;
			
			cnt = 0;
			for(int i=0; i<menuSel.length; i++) {
				if(menuSel[i] != 0)
					cnt++;
			}
			
		}

	}

}
