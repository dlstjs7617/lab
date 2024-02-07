package lv03;

import java.util.Scanner;

public class Ex22 {

	public static void main(String[] args) {
		
		// 문제1) 추가 를 선택하고 값을 입력하면 10, 20 뒤에 저장한다.
		// 최대 5개까지 저장
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = {10, 20, 0, 0, 0};
		int cnt = 2;
		
		boolean run = true;
		while(run) {
			for(int i=0; i<cnt; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			
			System.out.println("[1]추가 [2]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();	
			
			if(sel < 1 || sel >2) {
				System.err.println("메뉴 선택 오류");
				continue;
			}else if(sel == 1 && cnt >= 5) {
				System.err.println("배열최대치도달");
			}
			
			if(sel == 1 && cnt < 5) {
				System.out.print("추가할 값 입력 : ");
				int data = sc.nextInt();
				if(cnt<5) {
					arr[cnt] = data;
					cnt++;
				}
			}else if(sel == 2) {
				break;
			}
			
		}

	}

}
