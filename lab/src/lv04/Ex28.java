package lv04;

import java.util.Random;
import java.util.Scanner;

public class Ex28 {

	public static void main(String[] args) {
		//# 빙고 Ver 1. (플레이어 1명) -> ver2 플레이어 2명
			
			Scanner sc = new Scanner(System.in);
			Random ran = new Random();
			
			
			final int MAX_NUM = 5;
			
			int[][] bingo1 = new int[MAX_NUM][MAX_NUM];
			int[][] mark1 = new int[MAX_NUM][MAX_NUM];
			
			int[][] bingo2 = new int[MAX_NUM][MAX_NUM];
			int[][] mark2 = new int[MAX_NUM][MAX_NUM];
			
			int[] temp = new int[MAX_NUM * MAX_NUM];
			int size = 50; // 1~50까지의 수를 중복없이 빙고판에 배치
			
			int cnt = 0;
			
			int chk1 = 0;
			int chk2 = 0;
			int line1 = 0;
			int line2 = 0;
			
			int n = 0;
			while(true) {
				System.out.print("몇 빙고 : "); // MAX_NUM *2+2
				n = sc.nextInt();
				if(n > 0 && n <= MAX_NUM*2+2)
					break;
			}
			int player[][] = null;
			int playermark[][] = null;
			int turn = 1;
			while(true) {
				if(turn == 1) {
					player = bingo1;
				}else if(turn == 2) {
					player = bingo2;
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
				
				cnt = 0;
				for(int i=0; i<MAX_NUM; i++) {
					for(int j=0; j<MAX_NUM; j++	) {
						player[i][j] = temp[cnt];
						cnt++;
					}
				}
				
				if(turn == 1) {
					turn++;
				}else {
					turn--;
					break;
				}
			}
			
			
			
			
			boolean isRun = true;
			// 빙고게임 시작
			while(isRun) {
				line1 = 0;
				line2 = 0;
				// set map (bingo 배열완성후 빙고배열출력				
				System.out.println("palyer1 의 빙고판");
				for(int i=0; i<MAX_NUM; i++) {
					for(int j=0; j<MAX_NUM; j++) {
						System.out.printf("[%2d]",bingo1[i][j]);
					}
					System.out.println();
				}
				System.out.println("===========================");
				System.out.println("palyer2 의 빙고판");
				for(int i=0; i<MAX_NUM; i++) {
					for(int j=0; j<MAX_NUM; j++) {
						System.out.printf("[%2d]",bingo2[i][j]);
					}
					System.out.println();
				}
				System.out.println("===========================");
				//숫자 값 입력
				System.out.print(turn +"차례 번호 입력 : ");
				int num	= sc.nextInt();
				
				// num값 예외처리
				if(num <=0 && num > 50)
					continue;
				
				//입력값이 빙고에 있는지 검증
				for(int i=0; i<MAX_NUM; i++) {
					for(int j=0; j<MAX_NUM; j++) {
						if(num == bingo1[i][j]) {
							mark1[i][j] = bingo1[i][j];
						}
						if(num == bingo2[i][j]) {
							mark2[i][j] = bingo2[i][j];
						}
					}
				}
				
				
				// 빙고가로라인 체크
				for(int i=0; i<MAX_NUM; i++) {
					chk1 = 0;
					chk2 = 0;
					for(int j=0; j<MAX_NUM; j++) {
						if(mark1[i][j] != 0) {
							chk1++;
						}
						if(mark2[i][j] != 0) {
							chk2++;
						}	
					}
					if(chk1 == 5) {
						line1++;
					}
					if(chk2 == 5) {
						line2++;
					}
				}
				//빙고 세로라인 체크
				for(int i=0; i<MAX_NUM; i++) {
					chk1 = 0;
					chk2 = 0;
					for(int j=0; j<MAX_NUM; j++) {
						if(mark1[j][i] != 0) {
							chk1++;
						}
						if(mark2[j][i] != 0) {
							chk2++;
						}
					}
					if(chk1 == 5) {
						line1++;
					}
					if(chk2 == 5) {
						line2++;
					}
				}
				//빙고 우측아래방향 대각선 라인 체크
				chk1 = 0;
				chk2 = 0;
				for(int i=0; i<MAX_NUM; i++) {
					if(mark1[i][i] != 0)
						chk1++;
					if(mark2[i][i] != 0)
						chk2++;
				}
				if(chk1 == 5) 
					line1++;
				if(chk2 == 5) 
					line2++;
				
				// 빙고 좌측 아래방향 대각선 라인 체크
				chk1 = 0;
				chk2 = 0;
				int tmp= 4;
				for(int i=0; i<MAX_NUM; i++) {
					if(mark1[i][tmp] != 0) {
						chk1++;
					}
					if(mark2[i][tmp] != 0) {
						chk2++;
					}
					tmp--;
				}
				if(chk1 == 5) {
					line1++;
				}
				if(chk2 == 5) {
					line2++;
				}
				System.err.println("player 1 현재 빙고 수 : "+line1);
				System.err.println("player 2 현재 빙고 수 : "+line2);
				
				
				
				
				// mark출력문
//				System.out.println("===player1===");
//				for(int i=0; i<MAX_NUM; i++) {
//					for(int j=0; j<MAX_NUM; j++) {
//						System.out.printf("[%2d]",mark1[i][j]);
//					}
//					System.out.println();
//				}
//				System.out.println("=========");
//				System.out.println("===player2===");
//				for(int i=0; i<MAX_NUM; i++) {
//					for(int j=0; j<MAX_NUM; j++) {
//						System.out.printf("[%2d]",mark2[i][j]);
//					}
//					System.out.println();
//				}
//				System.out.println("=========");
				
				if(line1 >= n || line2 >= n) {
					break;
				}
				
			}
			if(line1 > line2) {
				System.out.println("p1의 승리");
			}else if(line1 < line2) {
				System.out.println("p2의 승리");
			}else {
				System.out.println("무승부");
			}

	}

}
