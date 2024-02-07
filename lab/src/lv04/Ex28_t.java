package lv04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex28_t {
	
	//# 빙고 Ver 1. (플레이어 1명)
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		
		final int MAX_NUM = 5;
		final int MARK = 0;
		final int P1 = 1;
		final int P2 = 3;
		
		int[][] bingo = new int[MAX_NUM][MAX_NUM];
		int[][] bingo2 = new int[MAX_NUM][MAX_NUM];
//		int[][] mark = new int[MAX_NUM][MAX_NUM];
		
		int[] temp = new int[MAX_NUM * MAX_NUM];
		int size = 50; // 1~50까지의 수를 중복없이 빙고판에 배치
		
		int turn = P1;
		int win = 0;
		int win2 = 0;
		System.out.print("몇 빙고 : "); // MAX_NUM *2+2
		int n = sc.nextInt();
		
		int[][] board = bingo; //주소 공유
		for(int x=0; x<2; x++) {
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
			int idx = 0;
			for(int i=0; i<bingo.length; i++) {
				for(int j=0; j<bingo[i].length; j++	) {
					bingo[i][j] = temp[idx++];
				}
			}		
			board = bingo2;
		}
		
		while(true) {
			
			System.out.println("-------- P1 --------	-------- P2 --------");
			System.out.println("--------------------	--------------------");
			for(int i=0; i<bingo.length; i++) {
				for(int j=0; j<bingo[i].length; j++) {
					if(bingo[i][j] == MARK)
						System.out.println("[●]");
					System.out.printf("[%2d]",bingo[i][j]);
				}
				System.out.println("   ");
				for(int j=0; j<bingo[i].length; j++) {
					if(bingo[i][j] == MARK)
						System.out.println("[▲]");
					System.out.printf("[%2d]",bingo2[i][j]);
				}
				System.out.println();
			}
			System.out.println("--------------------	--------------------");
			if(win >= n || win2 >=n) {
				break;
			}
			
			System.out.printf("P%d숫자 : ", turn);
			int number = sc.nextInt();
			
			for(int i=0; i<MAX_NUM; i++) {
				for(int j=0; j<MAX_NUM; j++) {
					if(bingo[i][j] == number)
						bingo[i][j] = MARK;
					if(bingo2[i][j] == number)
						bingo[i][j] = MARK;
				}
			}
			
			// -
			for(int i=0; i<MAX_NUM; i++) {
				int cnt = 0;
				int cnt2 = 0;
				for(int j=0; j<MAX_NUM; j++) {
					if(bingo[i][j] == MARK)
						cnt++;
					if(bingo2[i][j] == MARK)
						cnt2++;
				}
				if(cnt == MAX_NUM)
					win++;
				if(cnt2 == MAX_NUM)
					win2++;
			}
			// |
			for(int i=0; i<MAX_NUM; i++) {
				int cnt = 0;
				int cnt2 = 0;
				for(int j=0; j<MAX_NUM; j++) {
					if(bingo[j][i] == MARK)
						cnt++;
					if(bingo2[j][i] == MARK)
						cnt2++;
				}
				if(cnt == MAX_NUM)
					win++;
				if(cnt2 == MAX_NUM)
					win2++;
			}
			// /
			int cnt = 0;
			int cnt2 = 0;
			for(int i=0; i<MAX_NUM; i++) {
				if(bingo[i][MAX_NUM-1-i] == MARK)
					cnt++;
				if(bingo2[i][MAX_NUM-1-i] == MARK)
					cnt++;
			}
			if(cnt == MAX_NUM)
				win++;
			if(cnt2 == MAX_NUM)
				win2++;
			// \
			cnt = 0;
			cnt2 = 0;
			for(int i=0; i<MAX_NUM; i++) {
				if(bingo[i][i] == MARK)
					cnt++;
				if(bingo2[i][i] == MARK)
					cnt++;
			}
			if(cnt == MAX_NUM)
				win++;
			if(cnt2 == MAX_NUM)
				win2++;
			
			
			turn = turn == P1 ? P2 : P1;
		}
		if(win>= n && win2 >= n)
			System.out.println("무승부");
		else
			System.out.printf("P%d WIN!!", win >= n ? P1 : P2);
	}

}
