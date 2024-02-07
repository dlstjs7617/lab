package lv03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex20 {
	
	/*
	 *  # 틱택토
	 *  === 틱택토 ===
	 *  [X][X][X]
	 *  [ ][O][ ]
	 *  [ ][ ][ ]
	 *  [p1]인덱스 입력 : 6
	 *  === 틱택토 ===
	 *  [X][X][X]
	 *  [ ][O][ ]
	 *  [O][ ][ ]
	 *  [p1]승리
	 *  
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		final int SIZE = 9;
		final int PLAYER1 = 1;
		final int PLAYER2 = 2;
		int[] game = new int[SIZE];
		
		int turn = 1;
		boolean isRun = true;
		int p = 0;
		
		while(isRun) {
			//틱택토 보드판 출력
			System.out.println("===========");
			for(int i=0; i<SIZE; i++) {
				if(game[i] == 0)
					System.out.print("[ ]");
				else if(game[i] == PLAYER2)
					System.out.print("[O]");					
				else if(game[i] == PLAYER1)
					System.out.print("[X]");
				if(i % 3 == 2)
					System.out.println(" ");
			}
			System.out.println("===========");
			
			//플레이어 차례 입력
			if(turn == 1) {
				System.out.print("p["+turn+"]의 차례 : ");
				p = sc.nextInt();	
			}else if(turn == 2) {
				System.out.print("p["+turn+"]의 차례 : ");
				p = sc.nextInt();		
			}

			//입력값 예외처리
			if(p < 0 || p >= SIZE) {
				System.err.println("입력값이 올바르지않습니다");
				continue;
			}else if(game[p] == PLAYER2 || game[p] == PLAYER1) {
				System.err.println("이미 입력된 값입니다.");
				continue;				
			}else {	//입력
				if(turn == 2) {
					game[p] = PLAYER1;
					turn--;
				}else if(turn == 1) {
					game[p] = PLAYER2;
					turn++;
				}
			}
			// 우승 트리거
//			for(int i=0; i<SIZE; i+=3) {	//가로줄 빙고
//				if(game[i] == turn && game[i+1] == turn && game[i+2] == turn) {
//					isRun = false;
//					System.out.println("가로줄빙고활성화");					
//				}
//			}
//			for(int i=0; i<3; i++) {	//세로줄 빙고
//				if(game[i] == turn && game[i+3] == turn && game[i+6] == turn) {
//					isRun = false;
//					System.out.println("세로줄빙고활성화");					
//				}
//			}
			for (int i = 0; i < SIZE; i += 3) { // 가로줄 빙고
			    if (game[i] == turn && game[i + 1] == turn && game[i + 2] == turn) {
			        isRun = false;
			        System.out.println("가로줄빙고활성화");
			    }
			}
			for (int i = 0; i < 3; i++) { // 세로줄 빙고
			    for (int j = 0; j < 3; j++) {
			        if (game[j * 3 + i] == turn && game[j * 3 + i + 3] == turn && game[j * 3 + i + 6] == turn) {
			            isRun = false;
			            System.out.println("세로줄빙고활성화");
			        }
			    }
			}
			//우측 대각선 빙고
			if(game[0] == turn && game[4] == turn && game[8] == turn) 
				isRun = false;
			// 좌측아래 대각선빙고
			if(game[2] == turn && game[4] == turn && game[6] == turn) 
				isRun = false;
		}
		if(turn == 1)
			System.out.println("승자 p2");
		else if(turn == 2)
			System.out.println("승자 p1");
	}

}
