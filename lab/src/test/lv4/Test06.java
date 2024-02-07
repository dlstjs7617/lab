package test.lv4;

import java.util.Scanner;

// 시작 18:22 
// 종료 00:00
// 소요 00:00
public class Test06 {
	// 6.
	/*
	 * # 나만의 마블
	 * 읏 □ □ □ □
	 * □ ■ ■ ■ □
	 * □ ■ ■ ■ □
	 * □ ■ ■ ■ □
	 * □ □ □ □ □
	 */
	
	//캐릭터가 방향을 입력받을때마다 이동 하는데
	// 외각으로만 이동 아래 그림참조
	// ㄴ 동d/서a/남s/북w
	// ㄴ 이동 칸 수(1 이상)
	/*
	 * # 나만의 마블
	 * 읏 □ □ □ □
	 * □ ■ ■ ■ □
	 * □ ■ ■ ■ □
	 * □ ■ ■ ■ □
	 * □ □ □ □ □
	 * 입력 ==> 3
	 * 
	 * # 나만의 마블
	 * □ □ □ 읏 □
	 * □ ■ ■ ■ □
	 * □ ■ ■ ■ □
	 * □ ■ ■ ■ □
	 * □ □ □ □ □
	 * 입력 ==> 3
	 * 
	 * # 나만의 마블
	 * □ □ □ □ □
	 * □ ■ ■ ■ □
	 * □ ■ ■ ■ 읏
	 * □ ■ ■ ■ □
	 * □ □ □ □ □
	 * 입력 ==> 3

	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		
		final int EAST = 0;
		final int SOUTH = 1;
		final int WEST = 2;
		final int NORTH = 3;
		
		final int SIZE = 5;
		final int LOAD = 0;
		final int WALL = 1;
		final int PLAYER = 2;
		
		int[][] map = new int[SIZE][SIZE];
		
		//벽
		for(int i=1; i<4; i++) {
			for(int j=1; j<4; j++) {
				map[i][j] = WALL;				
			}
		}
		//사람
		int pY = 0;
		int pX = 0;

		map[pY][pX] =PLAYER;
		int dir =EAST; //동 ->남 -> 서-> 북
		while(true) {
			//출력
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					if(map[i][j] == LOAD)
						System.out.print("□ ");
					if(map[i][j] == WALL)
						System.out.print("■ ");
					if(map[i][j] == PLAYER)
						System.out.print("읏 ");
				}			
				System.out.println();
			}
			
			System.out.print("입력 ==> ");
			int move = sc.nextInt();
			if(move <= 0) {
				System.out.println("음수나 0 은 이동할수 없습니다.");
				continue;
			}
			int tempY = pY;
			int tempX = pX;
			
			while(move != 0) {
				if(dir == EAST) {
					if(pX+move > SIZE-1) {
						move = move-(4-pX);
						pX = SIZE-1;
						dir = SOUTH;
					}else {
						pX += move;
						move = 0;
					}
				}
				if(dir == SOUTH) {
					if(pY+move > SIZE-1) {
						move = move-(4-pY);
						pY = SIZE-1;
						dir = WEST;
//						System.out.println("남쪽초과");
					}else {
						pY += move;
						move = 0;
					}
				}
				if(dir == WEST) {
					if(pX-move < 0) {
						move = move-pX;
						pX = 0;
						dir = NORTH;
//						System.out.println("서쪽초과");
					}else {
						pX -= move;
						move = 0;
					}
				}
				if(dir == NORTH) {
					if(pY-move < 0) {
						move = move-pY;
						pY = 0;
						dir = EAST;
//						System.out.println("북쪽초과");
					}else {
						pY -= move;
						move = 0;
					}
				}				
			}
			map[tempY][tempX] = LOAD;
			map[pY][pX] =PLAYER;
			
		}
		
	}

}
