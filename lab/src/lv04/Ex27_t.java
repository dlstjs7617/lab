package lv04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex27_t {
	
	//# 빙고 Ver 1. (플레이어 1명)
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		
		final int MAX_NUM = 5;
		final int MARK = 0;
		
		int[][] bingo = new int[MAX_NUM][MAX_NUM];
//		int[][] mark = new int[MAX_NUM][MAX_NUM];
		
		int[] temp = new int[MAX_NUM * MAX_NUM];
		int size = 50; // 1~50까지의 수를 중복없이 빙고판에 배치
		
		int win = 0;
		
		System.out.print("몇 빙고 : "); // MAX_NUM *2+2
		int n = sc.nextInt();
		

		//temp에 중복없이 1~50랜덤값 25개 넣기 
		for(int i=0; i<temp.length; i++) {
			temp[i] = ran.nextInt(50)+1;
			for(int j=i+1; j<temp.length; j++) {
				if(temp[i] == temp[j] && temp[j] != 0) {
					i--;
					break;
				}
			}
		}
		//temp값 빙고에 넣기
		int idx = 0;
		for(int i=0; i<bingo.length; i++) {
			for(int j=0; j<bingo[i].length; j++	) {
				bingo[i][j] = temp[idx++];
			}
		}
		// set 	map (bingo 배열완성후 bingo를 정방향 출력)
		// 1. temp 배열 완성(중복 없이 1~50 랜덤값으로 초기화)
		// 2. bingo 배열 전체값에 temp배열의 값을 차례대로 넣기
		// 3. bingo 배열 출력문 분리
		// 빙고배열출력
		while(true) {
			
			for(int i=0; i<bingo.length; i++) {
				for(int j=0; j<bingo[i].length; j++) {
					System.out.printf("[%2d]",bingo[i][j]);
				}
				System.out.println();
			}
			if(win >= n) {
				break;
			}
			
			System.out.print("숫자 : ");
			int number = sc.nextInt();
			
			for(int i=0; i<MAX_NUM; i++) {
				for(int j=0; j<MAX_NUM; j++) {
					if(bingo[i][j] == number)
						bingo[i][j] = MARK;
				}
			}
			
			win = 0;
			// -
			for(int y=0; y<MAX_NUM; y++) {
				int cnt = 0;
				for(int x=0; x<MAX_NUM; x++) {
					if(bingo[y][x] == MARK)
						cnt++;
				}
				if(cnt == MAX_NUM)
					win++;
			}
			// |
			for(int x=0; x<MAX_NUM; x++) {
				int cnt = 0;
				for(int y=0; y<MAX_NUM; y++) {
					if(bingo[y][x] == MARK)
						cnt++;
				}
				if(cnt == MAX_NUM)
					win++;
			}	
			// \
			int cnt = 0;
			for(int i=0; i<MAX_NUM; i++) {
				if(bingo[i][i] == MARK)
					cnt++;
			}
			if(cnt == MAX_NUM)
				win++;
			// /
			cnt = 0;
			for(int i=0; i<MAX_NUM; i++) {
				if(bingo[i][MAX_NUM-1-i] == MARK)
					cnt++;
			}
			if(cnt == MAX_NUM)
				win++;
		}
	}

}
