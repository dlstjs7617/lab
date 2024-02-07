package lv03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex20_t {
	
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
		final int P1 = 1;
		final int P2 = 2;

		int[] game = new int[SIZE];
		
		int turn = P1;
		int win = 0;
		
		boolean isRun = true;
		while(isRun) {
			//틱택토 보드판 출력
			System.out.println("===========");
			for(int i=0; i<SIZE; i++) {
				if(game[i] == 0)
					System.out.print("[ ]");
				else if(game[i] == P1)
					System.out.print("[O]");					
				else if(game[i] == P2)
					System.out.print("[X]");
				if(i % 3 == 2)
					System.out.println(" ");
			}
			System.out.println("===========");
			
			// 종료 조건
			if(win != 0) {
				break;
			}
			
			//입력
			System.out.printf("\n [P%d] index : ", turn);
			int idx = sc.nextInt();
			
			// 예외처리 1. 인덱스 범주 밖 & 이미 마킹된 자리
			if(idx < 0 || idx >= SIZE || game[idx] !=0) {
				continue;
			}
			
			// 마킹 처리
			game[idx] = turn;
			
			// 승리 확인
			// -
			/*
			 *  [0] 1 2
			 *  [3] 4 5
			 *  [6] 7 8
			 */
			for(int i=0; i<SIZE; i+=3) { // i : 0 3 6
				if(game[i] == turn && game[i+1] == turn && game[i+2] == turn) {
					win = turn;
				}
			}
			
			// |
			/*
			 *  [0] [1] [2]
			 *   3   4   5
			 *   6   7   8
			 */
			for(int i=0; i<3; i++) { // i : 0 1 2
				if(game[i] == turn && game[i+3] == turn && game[i+6] == turn) {
					win = turn;
				}
			}
			
			// \
			/*
			 *  [0] 1  2
			 *   3 [4] 5
			 *   6  7 [8]
			 */
			if(game[0] == turn && game[4] == turn && game[8] == turn)
				win = turn;
			
			// /
			/*
			 *   0  1 [2]
			 *   3 [4] 5
			 *  [6] 7  8
			 */
			if(game[2] == turn && game[4] == turn && game[6] == turn)
				win = turn;
			
			// 턴 변경
			turn = turn == P1 ? P2 : P1;
			
			
			
			
			
			
			
		}
		
		// 승자 출력
		System.out.printf("[P%d]", win);
		
	}
}