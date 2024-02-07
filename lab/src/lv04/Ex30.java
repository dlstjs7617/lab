package lv04;

import java.util.Scanner;

public class Ex30 {

	public static void main(String[] args) {
		// 오목
		// ㄴ 육목 3/3등 추가 룰 모두제외
		// ㄴ 연속으로 5개 이상의 돌이 놓이면 승
		// ㄴ 인덱스 두개를 입력 받아 마킹!
		Scanner sc = new Scanner(System.in);
		
		final int SIZE = 10;
		final int P1 = 1;
		final int P2 = 1;
		int[][] omok = new int[SIZE][SIZE];
		
		int turn = P1;
		
		int win = 0;
		int mu = 0;
		
		boolean run = true;
		while(run) {
			// 배열값 출력용 변수
			int tmpNum = 0;
			mu = 0;
			//배열 출력
			System.out.println("  =0==1==2==3==4==5==6==7==8==9=");
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					if(j == 0)
						System.out.printf("%d│",tmpNum);
					if(omok[i][j] == 0)
						System.out.print("─┼─");
					if(omok[i][j] == 1)
						System.out.print("─●─");
					if(omok[i][j] == 2)
						System.out.print("─○─");
					if(omok[i][j] != 0)
						mu++;
				}
				tmpNum++;
				System.out.println();
			}
			System.out.println("  =============================");
			//end
			if(win != 0) {
				break;				
			}
			//무승부
			if(mu == SIZE*SIZE) {
				break;
			}
			System.out.printf("P%d님의 차례\n",turn);
			System.out.print("y의 인덱스 입력 : ");
			int y = sc.nextInt();
			System.out.print("x의 인덱스 입력 : ");
			int x = sc.nextInt();
			
			//입력갑 예외처리
			if(x < 0 || x >= SIZE || y < 0 || y >= SIZE)
				continue;
			if(omok[y][x] != 0) {
				System.err.println("이미 놓아진 자리입니다.");
				continue;
			}
			
			// 입력값 넣기
			if(turn == 1) {
				omok[y][x] = 1;
			}else if(turn == 2){
				omok[y][x] = 2;
			}
			// 가로 세로 확인
			int cnt = 0;
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					if(omok[i][j] == turn) 
						cnt++;
					else
						cnt = 0;
						
					if(cnt == 5) {
						win++;
						System.out.println("가로 오목승리");
					}
					
				}
				cnt = 0;
				for(int j=0; j<SIZE; j++) {
					if(omok[j][i] == turn) 
						cnt++;						
					else
						cnt = 0;
					if(cnt == 5) {
						win++;
						System.out.println("세로 오목승리");
					}
				}
			}
			// \
			for(int i=0; i<SIZE-4; i++) {
				for(int j=0; j<SIZE-4; j++) {
					if(omok[i][j] == turn && omok[i+1][j+1] == turn && omok[i+2][j+2] == turn &&
					   omok[i+3][j+3] == turn && omok[i+4][j+4] == turn){
						win++;
						System.out.println("대각선 오목승리");
						break;
					}
				}
				if(win != 0)
					break;
				
			}
			// /
			for(int i=9; i>=4; i--) {
				for(int j=0; j<SIZE-4; j++) {
					if(omok[i][j] == turn && omok[i-1][j+1] == turn && omok[i-2][j+2] == turn &&
							   omok[i-3][j+3] == turn && omok[i-4][j+4] == turn){
						win++;
						System.out.println("대각선 오목승리");
						break;
					}
				}
			}
			turn = (turn == 1 ? 2 : 1);
			
		}
		if(mu == SIZE*SIZE) {
			System.out.println("무승부");
		}else if(turn == 1) 
			System.out.printf("P%d의 승 \n",turn+1);
		else
			System.out.printf("P%d의 승 \n",turn-1);
			
			
		
		sc.close();
	}

}
