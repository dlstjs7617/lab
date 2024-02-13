package lv05;

import java.util.Random;
import java.util.Scanner;

public class Ex30_t {
	/*
	 * # 크레이지 아케이드
	 *1. 맵의 크기는 7 x 7 이다.
	 *2. 상(w)하(s)좌(a)우(d)로 이동이 가능하며,
	 *	 폭탄설치(e),폭발(q)로 설정한다.
	 *3. 벽(3), 플레이어(2), 폭탄(9), 아이템(4)로 설정한다.
	 *4. 단, 폭탄이 설치된 순서대로 터져야 하며,
	 *   폭파 시 십자가 형태로 터진다.
	 *5. 벽 파괴시 아이템이 랜덤하게 생성되어,
	 *   아이템을 먹으면 설치할 수 있는 폭탄의 개수가 증가된다.
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 7;
		
		final int ROAD = 0;
		final int BAZZI = 2;
		final int WALL = 3;
		final int ITEM = 4;
		final int BOMB = 9;
		
		final int LEFT = 'a';
		final int RIGHT = 'd';
		final int UP = 'w';
		final int DOWN = 's';
		final int INSTALL_BOMB = 'e';
		final int EXPLODE_BOMB = 'q';
		
		int[][] map = new int[SIZE][SIZE];
		int[][] tempMap = new int[SIZE][SIZE];		//폭탄용 임시 좌표맵
		
		int pY = 0;
		int pX = 0;
		
		// 설치된 폭탄의 좌표를 기억해야 함 -> 순서대로 폭파
		int itemCnt = 10;
		int bombCnt = 0;
		int[][] bombYx = null; //{bomY,bombX},{bombY,bombX},{bombY,bombX},{bombY,bombX}...}
		
		int wallCnt = ran.nextInt(SIZE*SIZE/4) + 5;
		//벽 설치
		while(wallCnt > 0) {
			//랜덤 좌표 뽑기
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);
			
			if(map[rY][rX] == 0) {	// 맵에 벽이 없으면
				map[rY][rX] = WALL;	// 벽생성
				wallCnt--;
			}
		}
		
		//플레이어 설치
		while(true) {
			int rY = ran.nextInt(SIZE);
			int rX = ran.nextInt(SIZE);
			
			if(map[rY][rX] == 0) {
				map[rY][rX] = BAZZI;
				pY = rY;
				pX = rX;
				break;
			}
		}
		boolean isRun = true;
		while(isRun) {
			// 맵 출력
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					int block = map[i][j];
					
					if(block == BAZZI) 
						System.out.print("▲ ");
					else if(block == WALL)
						System.out.print("■ ");
					else if(block == BOMB)
						System.out.print("● ");
					else if(block == ITEM)
						System.out.print("◈ ");
					else
						System.out.print(". ");
				}
				System.out.println();
			}
			System.out.println("-----------------");
			System.out.printf("bomb : %d/%d\n", bombCnt, itemCnt);
			System.out.println("-----------------");
			System.out.println("       [w]↑      ");
			System.out.println("   [a]←[s]↑[d]→  ");
			System.out.println("   [q]폭파[e[설치] ");
			System.out.println("-----------------");
			char move = sc.next().charAt(0);
			
			//플레이어 좌표의 복사본
			int y = pY;
			int x = pX;
			if(move == LEFT) {
				x--;
			}else if(move == RIGHT) {
				x++;
			}else if(move == UP) {
				y--;
			}else if(move == DOWN) {
				y++;
			}
			
			// 이동에 대한 예외처리
			if(y < 0 || y >= SIZE || x < 0 || x >= SIZE || 
				map[y][x] == WALL || (map[y][x] == BOMB && map[pY][pX] != BOMB)) {
				continue;
			}
			
			if(map[y][x] == ITEM)
				itemCnt++;
			
			
			// 설치 및 폭파
			if(move == INSTALL_BOMB) {
				if(itemCnt == 0) {
					System.out.println("아이템이 부족합니다.");
					continue;
				}
				
				// 설치할 폭탄의 좌표 기억해둠 (차례대로)
				int bY = pY;
				int bX = pX;
				
				int[][] temp = bombYx;				// 구 주소
				bombYx = new int[bombCnt + 1][];	// 새 주소
				
				for(int i=0; i<bombCnt; i++)		// 1차원 주소 옮기기 {bY, bX} <- 기존에 설치된 폭탄 좌표들
					bombYx[i] = temp[i];
				
				bombYx[bombCnt] = new int[2];		// null ->{0,0}
				bombYx[bombCnt][0] = bY;			// 새로 설치한 폭탄 좌표를 추가
				bombYx[bombCnt][1] = bX;
				
				map[bY][bX] = BOMB;					// 설치
				
				bombCnt ++;
				itemCnt --;
				
				
			}else if(move == EXPLODE_BOMB) {
				if(bombCnt == 0) {
					System.err.println("설치된 폭탄이 없습니다.");
					continue;
				}
				
				// 먼저 설치된(0 인덱스) 순서대로 폭파
				int bY = bombYx[0][0];
				int bX = bombYx[0][1];
				
				//폭탄을 중심으로 사방 지우기
				for(int i=-1; i<=1; i++) {
					// |
					if(bY+i >=0 && bY+i < SIZE) {
						if(map[bY+i][bX] == WALL) {
							map[bY+i][bX] = ran.nextInt(2) * ITEM;
						}else if(bY+i == pY && bX ==pX) {
							isRun = false;							
						}
					}
					// -
					if(bX+i >= 0 && bX+i <SIZE) {
						if(map[bY][bX+i] == WALL) {
							map[bY][bX+i] = ran.nextInt(2) * ITEM;	
							
						}else if(bY == pY && bX+i == pX) {
							isRun = false;
						}
					}
				}
				map[bY][bX] = 0;					// 폭탄 삭제
				
				// 폭탄의 좌표 배열 -> 재정렬
				int[][] temp = bombYx;
				bombYx = new int[bombCnt -1][];
				
				for(int i=1; i<bombCnt; i++) {		// 폭파가 된 0인덱스 좌료플 뺀 나머지 옮기기
					bombYx[i-1] = temp[i];
				}
				
				bombCnt --;
				itemCnt ++;
			}
			
			// 플레이어 다시 그리기
			if(map[pY][pX] != BOMB)					// 폭탄이 설치되지 않았을 떄에만 0 초기화
				map[pY][pX] = 0;
			pY = y;
			pX = x;
			if(map[pY][pX] != BOMB)
				map[pY][pX] = BAZZI;
		}
		
		System.err.println("BAZZI is Dead....");
		
	}

}
