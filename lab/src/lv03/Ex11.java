package lv03;

import java.util.Scanner;

public class Ex11 {
	
	/*
	 *  # 즉석복권
	 *  1. 숫자 7이 연속으로 3번 등장하면, "당첨"출력.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		int[] lotto = { 0, 0, 7, 7, 7, 0, 0, 0 };
		
		// Test Case
//		int[] lotto = { 7, 0, 7, 7, 0, 0, 0, 7 };	//꽝
//		int[] lotto = { 7, 7, 7, 7, 0, 7, 0, 7 };	//당첨
//		int[] lotto = { 7, 7, 7, 7, 7, 7, 7, 7 };	//당첨
//		int[] lotto = { 0, 0, 0, 0, 0, 0, 7, 7 };	//꽝
//		int[] lotto = { 0, 0, 0, 0, 0, 7, 7, 7 };	//당첨
		int[] lotto = { 0, 0, 0, 0, 0, 0, 0, 0 };	//꽝
		 
		boolean run = true;
		
		System.out.println("1) 복권 결과확인");
		System.out.print("메뉴 선택 : ");
		int sel = sc.nextInt();
		int count = 0;
		if(sel == 1) {
			for(int i=0; i<8; i++) {
				if(lotto[i] == 7) {
					count++;
					if(count == 3) {
						break;
					}
				}else if(lotto[i] != 7) {
					count = 0;
				}
				
			}
			if(count >= 3) {
				System.out.println("당첨");
			}else {
				System.out.println("낙첨");
			}
		}
		
	}

}
