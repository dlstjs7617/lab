package lv04;

import java.util.Random;
import java.util.Scanner;

public class Ex29 {

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
		
		// 공 설치
		while (true) {
			// 랜덤 좌표 뽑기
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);
			int cnt =0;
			if(rX == 0 || rX == SIZE-1 || rY ==  0 || rY == SIZE-1)
				continue;
			
			if(map[rY-1][rX] == WALL)
				cnt++;
			if(map[rY+1][rX] == WALL)
				cnt++;
			if(map[rY][rX-1] == WALL)
				cnt++;
			if(map[rY][rX+1] == WALL)
				cnt++;
			if(cnt > 1)
				continue;
			

			if (map[rY][rX] == LOAD) {
				map[rY][rX] = BALL;
				ballY = rY;
				ballX = rX;
				break;
			}
		}
		// 골대 설치
		while (true) {
			// 랜덤 좌표 뽑기
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);
			int cnt =0;
			
			if(rX == 0 || rX == SIZE-1 || rY ==  0 || rY == SIZE-1)
				continue;
			
			if(map[rY-1][rX] == WALL)
				cnt++;
			if(map[rY+1][rX] == WALL)
				cnt++;
			if(map[rY][rX-1] == WALL)
				cnt++;
			if(map[rY][rX+1] == WALL)
				cnt++;
			if(cnt > 3)
				continue;
			
			if (map[rY][rX] == LOAD) {
				map[rY][rX] = GOAL;
				goalY = rY;
				goalX = rX;
				break;
			}
		}
		// 플레이어 배치
		while (true) {
			// 랜덤 좌표 뽑기
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);
			int cnt = 0;
			
			if(rX == 0 || rX == SIZE-1 || rY ==  0 || rY == SIZE-1)
				continue;
			
			if(map[rY-1][rX] == WALL)
				cnt++;
			if(map[rY+1][rX] == WALL)
				cnt++;
			if(map[rY][rX-1] == WALL)
				cnt++;
			if(map[rY][rX+1] == WALL)
				cnt++;
			if(cnt == 4)
				continue;
			
			if (map[rY][rX] == LOAD) {
				map[rY][rX] = PLAYER;
				pY = rY;
				pX = rX;
				break;
			}
		}
		
		
		
		
		// 게임 시작
		while(true) {
			// 맵출력문
			System.out.println("==============");
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					if(map[i][j] == PLAYER) 
						System.out.print("▲ ");
					else if(map[i][j] == BALL)
						System.out.print("● ");
					else if(map[i][j] == GOAL)
						System.out.print("□ ");
					else if(map[i][j] == WALL)
						System.out.print("■ ");
					else if(map[i][j] == LOAD)
						System.out.print("+ ");
				}
				System.out.println();
			}
			System.out.println("==============");
			
			if(map[ballY][ballX] == map[goalY][goalX]) {
				System.out.println("게임클리어");
				break;
			}
			//이동하기
			System.out.print("이동할 방향 입력 : ");
			String dir = sc.next();
			
			// 이동 처리 전 임시좌표 변수
			int y = pY;
			int x = pX;

			if(dir.equals("a")) {
				x--;
			}else if(dir.equals("d")) {
				x++;
			}else if(dir.equals("w")) {
				y--;
			}else if(dir.equals("s")) {
				y++;
			}
			
			// 임시좌표 변화를 가지고 예외처리
			if(x < 0 || x>= SIZE || y < 0 || y >= SIZE || map[y][x] == WALL)
				continue;
			int bX = ballX;
			int bY = ballY;
			if(map[y][x] == BALL) {
				if(dir.equals("a")) {
					bX--;
				}else if(dir.equals("d")) {
					bX++;
				}else if(dir.equals("w")) {
					bY--;
				}else if(dir.equals("s")) {
					bY++;
				}
				if(bX < 0 || bX >=SIZE || bY < 0 || bY >=SIZE || map[bY][bX] == WALL)
					continue;
			}

			// 이동
			
				
			map[pY][pX] = LOAD;
			ballY = bY;
			ballX = bX;
			map[goalY][goalX] = GOAL;
			pY = y;
			pX = x;
			// 골대 통과기능
			map[bY][bX] = BALL;			
			map[pY][pX] = PLAYER;
			
		}
	}

}
