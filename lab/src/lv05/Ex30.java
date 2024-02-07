package lv05;

import java.util.Random;
import java.util.Scanner;

public class Ex30 {
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
		final int PLAYER = 2;
		final int WALL = 3;
		final int ITEM = 4;
		final int BOMB = 9;
		
		int[][] map = new int[SIZE][SIZE];
		int[][] tempMap = new int[SIZE][SIZE];		//폭탄용 임시 좌표맵
		
		int pY = 0;
		int pX = 0;
		
		int item = 3;
		int bomb = 0;		//설치한 폭탄 수
		boolean boom = false; 	//폭탄 설치 유무
		
		// 폭탄 범위 인덱스 제외용 
		boolean w = false;
		boolean s = false;
		boolean a = false;
		boolean d = false;
		
		//사망
		boolean dead = false;
		
		int wallNum = ran.nextInt(10)+10;
		//랜덤 벽 설치
		while(wallNum > 0) {
			int rIdxY = ran.nextInt(SIZE);
			int rIdxX = ran.nextInt(SIZE);
			
			if(map[rIdxY][rIdxX] == 0) {
				map[rIdxY][rIdxX] = WALL;
				wallNum--;
			}
		}
		// 플레이어 랜덤 설치
		while(true) {
			int rIdxY = ran.nextInt(SIZE);
			int rIdxX = ran.nextInt(SIZE);
			
			int cnt = 0;
			if(rIdxY +1 == SIZE || rIdxY-1 < 0 )
				cnt++;
			if(rIdxX +1 == SIZE || rIdxX-1 < 0 )
				cnt++;
			if(rIdxX+1 != SIZE) {
				if(map[rIdxY][rIdxX+1] == WALL)
					cnt++;
			}
			if(rIdxX-1 > 0) {
				if(map[rIdxY][rIdxX-1] == WALL) {
					cnt++;
				}				
			}
			if(rIdxY+1 != SIZE) {
				if(map[rIdxY+1][rIdxX] == WALL)
					cnt++;
			}
			if(rIdxY-1 > 0) {
				if(map[rIdxY-1][rIdxX] == WALL) {
					cnt++;
				}				
			}
			if(cnt < 4 && map[rIdxY][rIdxX] == ROAD) {
				map[rIdxY][rIdxX] = PLAYER;
				pY = rIdxY;
				pX = rIdxX;
				break;
			}
		}
		int cnt = 1;
		while(true) {
			int endCnt = 0;
			//map출력문
			System.out.println("====CARZY====");
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[i].length; j++) {
					if(map[i][j] == ROAD)
						System.out.print(". ");
					if(map[i][j] == PLAYER)
						System.out.print("♥ ");
					if(map[i][j] == WALL) {
						System.out.print("■ ");
						endCnt++;
					}
					if(map[i][j] == BOMB)
						System.out.print("○ ");
					if(map[i][j] == ITEM)
						System.out.print("Ε ");
				}
				System.out.println();
			}
//			System.out.println("temp map======");
//			for(int i=0; i<tempMap.length; i++) {
//				for(int j=0; j<tempMap[i].length; j++) {
//					System.out.print(tempMap[i][j]+ " ");
//				}
//				System.out.println();
//			}
			System.out.println("=============");
			System.out.printf("item : %d \n",item);
			System.out.println("폭탄: q , 폭발 : e");
			System.out.println("=============");
			
			//종료
			if(endCnt == 0) {
				break;
			}
			
			//이동
			System.out.print("이동 : ");
			String input = sc.next();
			
			if(input.equals("w")) {
				
				//이동 예외처리
				if(pY == 0)
					continue;
				else if(map[pY-1][pX] == WALL)
					continue;
				
				if(map[pY-1][pX] == ITEM) {
					item++;
				}
				
				// 이동
				if(map[pY][pX] != BOMB)
					map[pY][pX] = ROAD;
				pY--;
				
			}else if(input.equals("s")) {
				//이동 예외처리
				if(pY == SIZE-1)
					continue;
				else if(map[pY+1][pX] == WALL)
					continue;
				
				if(map[pY+1][pX] == ITEM) {
					item++;
				}
				
				// 이동
				if(map[pY][pX] != BOMB)
					map[pY][pX] = ROAD;
				pY++;
				
			}else if(input.equals("a")) {

				//이동 예외처리
				if(pX == 0)
					continue;
				else if(map[pY][pX-1] == WALL)
					continue;
				
				if(map[pY][pX-1] == ITEM) {
					item++;
				}
				
				// 이동
				if(map[pY][pX] != BOMB)
					map[pY][pX] = ROAD;
				pX--;
				
			}else if(input.equals("d")) {
				
				//이동 예외처리
				if(pX == SIZE-1)
					continue;
				else if(map[pY][pX+1] == WALL)
					continue;
				
				if(map[pY][pX+1] == ITEM) {
					item++;
				}
				
				// 이동
				if(map[pY][pX] != BOMB)
					map[pY][pX] = ROAD;
				pX++;
			}else if(input.equals("q")) {
				if(item+1 > bomb) {
					tempMap[pY][pX] = cnt++;
					bomb++;
					boom = true;					
				}
			}else if(input.equals("e")) {
					// 임시 위치값
					int tempY = -1;
					int tempX =	-1;
					//위치 찾기
					
					while(true) {
						for(int i=0; i<map.length; i++) {
							for(int j=0; j<map[i].length; j++) {
								if(tempMap[i][j] == 1) {
									tempY = i;
									tempX =	j; 									
								}
							}
						}
						
						if(tempY == pY && tempX == pX) {
							dead = true;
						}
						
						if(tempY == -1 || tempX == -1)
							continue;
						// 폭발범위가 인덱스바깥확인
						if(tempY+1 < SIZE)
							s = true;
						if(tempY-1 >= 0)
							w = true;
						if(tempX+1 < SIZE)
							d = true;
						if(tempX-1 >= 0)
							a = true;
						
						int rItem = ran.nextInt(6)+1;
						// 벽허물기 아이템드랍
						if(w && map[tempY-1][tempX] != ROAD) {
							map[tempY-1][tempX] = ROAD;
							if(map[tempY-1][tempX] == PLAYER)
								dead = true;
							if(map[tempY-1][tempX] == WALL)
								if(rItem == 1)
									map[tempY-1][tempX] = ITEM;
						}
						if(s && map[tempY+1][tempX] != ROAD) {
							map[tempY+1][tempX] = ROAD;
							if(map[tempY+1][tempX] == PLAYER)
								dead = true;
							if(map[tempY+1][tempX] == WALL)
								if(rItem == 2)
									map[tempY+1][tempX] = ITEM;
						}
						if(a && map[tempY][tempX-1] != ROAD) {
							map[tempY][tempX-1] = ROAD;
							
							if(map[tempY][tempX-1] == PLAYER)
								dead = true;

							if(map[tempY][tempX-1] == WALL)
								if(rItem == 3)
									map[tempY][tempX-1] = ITEM;
						}
						if(d && map[tempY][tempX+1] != ROAD) {
							map[tempY][tempX+1] = ROAD;
							
							if(map[tempY-1][tempX+1] == PLAYER)
								dead = true;
							
							if(map[tempY-1][tempX+1] == WALL)
								if(rItem == 4)
									map[tempY][tempX+1] = ITEM;
						}
						
						w = false;
						s = false;
						a = false;
						d = false;
						tempMap[tempY][tempX] = ROAD;
						map[tempY][tempX] = ROAD;
						bomb--;
						cnt--;
						// cnt 줄이기
						for(int i=0; i<tempMap.length; i++) {
							for(int j=0; j<tempMap[i].length; j++) {
								if(tempMap[i][j] != ROAD) {
									tempMap[i][j] -= 1;
								}
							}					
						}
						if(dead) {
							break;
						}
					}
					
				}
			// 플레이어 표시
			if(map[pY][pX] != BOMB) {
				map[pY][pX] = PLAYER;				
			}
			for(int i=0; i<tempMap.length; i++) {
				for(int j=0; j<tempMap[i].length; j++) {
					if(tempMap[i][j] != ROAD) {
						map[i][j] = BOMB;
					}
				}					
			}
			
				
			}
				
		// 엔딩
		if(dead) {
			System.out.println("GAME OVER");
		}else {			
			System.out.println("벽이 없습니다 GAME CLEAR");
		}
		
	}

}
