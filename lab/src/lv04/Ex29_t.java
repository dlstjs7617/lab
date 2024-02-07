package lv04;

import java.util.Random;
import java.util.Scanner;

public class Ex29_t {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 7;
		final int PLAYER = 2;	// ▲
		final int BALL = 3;		// ●
		final int GOAL = 7;		// □
		final int WALL = 9;		// ■
		final int LOAD = 0;		// +
		
		int[][] map = new int[SIZE][SIZE];
		
		int wallCount = -1;
		
		// 플레이어 1명 (좌표)
		int pY = 0;
		int pX = 0;
		
		// 공 1개 (좌표)
		int ballY = 0;
		int ballX = 0;
		
		// 골대 1개 (좌표)
		int goalY = 0;
		int goalX = 0;
		// 벽 설치 (개수만큼 랜덤 좌표에 배치, ~10개)
		while(wallCount < 0 || wallCount > 10) {
			System.out.print(">>>설치할 벽 갯수 : ");
			wallCount = sc.nextInt();			
		}
		
		//벽 설치
		while(wallCount > 0) {
			// 랜덤 좌표 뽑기
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);
			
			if(map[rY][rX] == LOAD) {
				map[rY][rX] = WALL;
				wallCount --;
			}
			
		}
		
		
		
		
		//공 설치
		while(true) {
			// 랜덤 좌표 뽑기
			int rY = ran.nextInt(SIZE-2)+1;
			int rX = ran.nextInt(SIZE-2)+1;
			
			if(map[rY][rX] == LOAD) {
				// 랜덤 좌표에 대한 사방검사
				int cnt =0;
				for(int i=-1; i<=1; i++) {
					if(map[rY+i][rX] == WALL)
						cnt++;
					if(map[rY][rX+i] == WALL)
						cnt++;
				}
				if(cnt <2) {
					map[rY][rX] = BALL;
					ballY = rY;
					ballX = rX;
					break;					
				}
			}
		}
		//골대 설치
		while(true) {
			// 랜덤 좌표 뽑기
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);
			
			if(map[rY][rX] == LOAD) {
				map[rY][rX] = GOAL;
				goalY = rY;
				goalX = rX;
				break;
			}
		}
		//플레이어 배치
		while(true) {
			// 랜덤 좌표 뽑기
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);
			
			if(map[rY][rX] == LOAD) {
				
				int cnt = 0;
				for(int i=-1; i<=1; i++) {
					if(rY+i >= 0 && rY+i < SIZE && map[rY+i][rX] == WALL)
						cnt++;
					if(rX+i >= 0 && rX+i < SIZE && map[rY][rX+i] == WALL)
						cnt++;
				}
				if(cnt < 2) {					
					map[rY][rX] = PLAYER;
					pY = rY;
					pX = rX;
					break;
				}
			}
		}
		// 게임 시작
		boolean isGoal = false;
		while(true) {
			// 맵출력문
			System.out.println("==============");
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					if(map[i][j] == PLAYER) 
						System.out.print("▲ ");
					else if(map[i][j] == BALL)
						System.out.print("● ");
					else if(map[i][j] == GOAL) {
						if(isGoal)
							System.out.print("◎ ");
						else if(pY == goalY && pX == goalX)
							System.out.print("▣ ");
						else
							System.out.print("□ ");
					}
					else if(map[i][j] == WALL)
						System.out.print("■ ");
					else if(map[i][j] == LOAD)
						System.out.print("+ ");
				}
				System.out.println();
			}
			System.out.println("==============");
			//end
			if(isGoal)
				break;
			//이동하기
			System.out.print("이동할 방향 입력 : ");
			String dir = sc.next();
			
			// 이동 처리 전 임시좌표 변수
			int y = pY;
			int x = pX;
			
			int bY = ballY;
			int bX = ballX;
			if(dir.equals("a")) {
				x--;
				bX--;
			}else if(dir.equals("d")) {
				x++;
				bX++;
			}else if(dir.equals("w")) {
				y--;
				bY--;
			}else if(dir.equals("s")) {
				y++;
				bY++;
			}
			
			// 임시좌표 변화를 가지고 예외처리
			if(x < 0 || x>= SIZE || y < 0 || y >= SIZE || map[y][x] == WALL) {
				System.out.printf("%d/%d (%d)\n", y, x, map[y][x]);
				continue;
			}
			//공을 만나면
			if(map[y][x] == BALL) {
				//공 좌표에 대한 예외처리
				if(bX < 0 || bX>= SIZE || bY < 0 || bY >= SIZE || map[bY][bX] == WALL)
					continue;
				
				if(map[bY][bX] == GOAL)
					isGoal = true;
				//공배치
				ballY = bY;
				ballX = bX;
				map[ballY][ballX] = BALL;
			}
				
			// 이동
			map[pY][pX] = LOAD;
			pY = y;
			pX = x;
			map[pY][pX] = PLAYER;
			
			//골대
			map[goalY][goalX] = GOAL;
			
		}
	}

}
