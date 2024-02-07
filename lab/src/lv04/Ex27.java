package lv04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex27 {
	
	//# 빙고 Ver 1. (플레이어 1명) -> ver2 플레이어 2명
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		
		final int MAX_NUM = 5;
		
		int[][] bingo = new int[MAX_NUM][MAX_NUM];
		int[][] mark = new int[MAX_NUM][MAX_NUM];
		
		int[] temp = new int[MAX_NUM * MAX_NUM];
		int size = 50; // 1~50까지의 수를 중복없이 빙고판에 배치
		
		int win = 0;
		int n = 0;
		while(true) {
			System.out.print("몇 빙고 : "); // MAX_NUM *2+2
			n = sc.nextInt();
			if(n > 0 && n <= MAX_NUM*2+2)
				break;
		}
		

		//temp에 중복없이 1~50랜덤값 25개 넣기 
		for(int i=0; i<temp.length; i++) {
			temp[i] = ran.nextInt(50)+1;
			for(int j=0; j<i; j++) {
				if(temp[i] == temp[j] && temp[j] != 0) {
					i--;
					break;
				}
			}
		}
		//temp값 빙고에 넣기
		int cnt = 0;
		for(int i=0; i<bingo.length; i++) {
			for(int j=0; j<bingo[i].length; j++	) {
				bingo[i][j] = temp[cnt];
				cnt++;
			}
		}
		
		boolean isRun = true;
		// 빙고게임 시작
		while(isRun) {
			int line = 0;
			// set map (bingo 배열완성후 빙고배열출력
			for(int i=0; i<bingo.length; i++) {
				for(int j=0; j<bingo[i].length; j++) {
					System.out.printf("[%2d]",bingo[i][j]);
				}
				System.out.println();
			}
			
			//숫자 값 입력
			System.out.println("번호 입력 : ");
			int num	= sc.nextInt();
			
			// num값 예외처리
			if(num <=0 && num > 50)
				continue;
			
			//입력값이 빙고에 있는지 검증
			for(int i=0; i<bingo.length; i++) {
				for(int j=0; j<bingo.length; j++) {
					if(num == bingo[i][j]) {
						mark[i][j] = bingo[i][j];
						System.out.println("빙고에 있는 숫자입니다.");
					}
				}
			}
			
			
			// 빙고가로라인 체크
			for(int i=0; i<mark.length; i++) {
				cnt = 0;
				for(int j=0; j<mark[i].length; j++) {
					if(mark[i][j] != 0) {
						cnt++;
					}					
				}
				if(cnt == 5) {
					line++;
				}
			}
			//빙고 세로라인 체크
			for(int i=0; i<mark.length; i++) {
				cnt = 0;
				for(int j=0; j<mark[i].length; j++) {
					if(mark[j][i] != 0) {
						cnt++;
					}					
				}
				if(cnt == 5) {
					line++;
				}
			}
			//빙고 우측아래방향 대각선 라인 체크
			cnt = 0;
			for(int i=0; i<bingo.length; i++) {
				if(mark[i][i] != 0)
					cnt++;
				System.out.println("cnt돌고있음" +cnt);
			}
			if(cnt == 5) {
				line++;
				cnt = 0;
			}
			// 빙고 좌측 아래방향 대각선 라인 체크
			cnt =0;
			int tmp= 4;
			for(int i=0; i<bingo.length; i++) {
				if(mark[i][tmp] != 0) {
					cnt++;
				}
				tmp--;
			}
			if(cnt == 5) {
				line++;
				cnt = 0;
			}
//			if(mark[0][0] != 0 && mark[1][1] != 0 && mark[2][2] != 0 && mark[3][3] != 0 && mark[4][4] != 0)
//				line++;
//			if(mark[0][4] != 0 && mark[1][3] != 0 && mark[2][2] != 0 && mark[3][1] != 0 && mark[4][0] != 0)
//				line++;
			System.err.println("현재 빙고 수 : "+line);
			
			
			
			
			// mark출력문
//			System.out.println("========");
//			for(int i=0; i<mark.length; i++) {
//				for(int j=0; j<mark[i].length; j++) {
//					System.out.printf("[%2d]",mark[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println("=========");
			
			
			if(line >= n) {
				break;
			}
			
		}
			
	}

}
