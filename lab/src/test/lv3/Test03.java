package test.lv3;

import java.util.Scanner;

public class Test03 {
	//시작 03:30
	//종료 43:00
	//소요 40:30
	public static void main(String[] args) {
		//Level Test 3
		
		//
		
		/*
		 *#틱택토
		 *  === 틱택토 ===
		 *  [X][X][O]
		 *  [ ][O][ ]
		 *  [ ][ ][ ]
		 *  [p1]인덱스 입력 : 6
		 *  === 틱택토 ===
		 *  [X][X][O]
		 *  [ ][O][ ]
		 *  [O][ ][ ]
		 *  [p1]승리
		 */
		
		final int SIZE = 9;
		int[] map = new int[SIZE];
		
		Scanner sc = new Scanner(System.in);
		boolean isRun = true;
		int p1 = 1;
		int p2 = 2;
		int turn = 1;
		int win = 0;
		while(isRun) {

			System.out.println("=== 틱택토 ===");
			for(int i=0; i<SIZE; i++) {
				if(map[i] == 0)
					System.out.print("[ ]");
				else if(map[i] == 1)
					System.out.print("[O]");
				else if(map[i] == 2)
					System.out.print("[X]");
				if(i % 3 == 2) {
					System.out.println();
				}
			}
			
			System.out.println("p" + turn + "의 차례입니다. 인데스 입력 : ");
			int index = sc.nextInt();
			
			if(index < 0 || index >=9)
				continue;
			if(map[index] != 0) {
				System.err.println("이미 입력된 자리입니다.");
				continue;
			}
			
			map[index] = turn;
			
			
			
			for (int i = 0; i < SIZE; i += 3) {
				if (map[i] == turn && map[i + 1] == turn && map[i + 2] == turn) {
					win++;
				}
			}
			for (int i = 0; i < 3; i++) {
				if (map[i] == turn && map[i + 3] == turn && map[i + 6] == turn) {
					win++;
				}
			}
			if (map[2] == turn && map[4] == turn && map[6] == turn) {
				win++;
			}
			if (map[0] == turn && map[4] == turn && map[8] == turn) {
				win++;
			}
			
			if (win == 1) {
				break;
			}
			if(turn == 1)
				turn++;
			else 
				turn--;
			
		}
		
		
		System.out.println("=== 틱택토 ===");
		for(int i=0; i<SIZE; i++) {
			if(map[i] == 0)
				System.out.print("[ ]");
			else if(map[i] == 1)
				System.out.print("[O]");
			else if(map[i] == 2)
				System.out.print("[X]");
			if(i % 3 == 2) {
				System.out.println();
			}
		}
		System.out.println("p" + turn + "의 승리입니다.");
		
		
		
	}

}
