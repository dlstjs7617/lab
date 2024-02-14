package parctice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lv5_소코반메이커 {
	// 소코반 메이커
	public static void main(String[] args) {
		
		final int PLAYER = 2;
		final int BALL = 3; 
		final int GOAL = 4; 
		final int GOALIN = 5; 
		final int WALL = 6;
		final int SIZE = 10;
		
		int[][] map = new int[SIZE][SIZE];
		int[][] maker = new int[SIZE][SIZE];
		
		int ballCnt = 0;
		int goalCnt = 0;
		
		//플레이어 위치 초기화
		int pY = 0;
		int pX = 0;
		maker[pY][pX] = PLAYER;
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		
		String fileName = "maker.txt";
		File file = new File(fileName);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		while(true) {
			// 출력문
			System.out.println("===소코반 메이커===");
			System.out.println("1. 맵 제작");
			System.out.println("2. 게임실행");
			int choice = sc.nextInt();
			if(choice == 1) {
				while(true) {
					ballCnt = 0;
					goalCnt = 0;
					for(int i=0; i<SIZE; i++) {
						for(int j=0; j<SIZE; j++) {
							if(map[i][j] != 0 && maker[i][j] == PLAYER) {
								System.out.print(" * ");
							}else if(maker[i][j] == PLAYER) {
								System.out.print(" 옷 ");
							}else if(map[i][j] == WALL) {
								System.out.print(" 벽 ");
							}else if(map[i][j] == BALL) {
								System.out.print(" 볼 ");
								ballCnt++;
							}else if(map[i][j] == GOAL) {
								System.out.print(" 골 ");
								goalCnt++;
							}else if(map[i][j] == GOALIN) {
								System.out.print(" 인 ");
							}else {
								System.out.print(" + ");
							}
						}
						System.out.println();
					}
					
					System.out.println("이동  w   ");
					System.out.println("   a s d ");
					System.out.println("3)공 4)골 5)삭제 0)종료");
					char input = sc.next().charAt(0);
					System.out.println(input);
					int y = pY;
					int x = pX;
					if(input ==  'w') {
						y--;
					}else if(input == 's') {
						y++;
					}else if(input == 'a') {
						x--;
					}else if(input == 'd') {
						x++;
					}else if(input == '3') {
						map[y][x] = BALL;
					}else if(input == '4') {						
						map[y][x] = GOAL;
					}else if(input == '5') {
						map[y][x] = 0;						
					}else if(input == '6') {
						map[y][x] = WALL;						
					}else if(input == '0') {
						if(ballCnt != goalCnt) {
							System.out.println("공과 볼갯수가 다릅니다");
							System.out.printf("볼 : %d  공 : %d \n", ballCnt, goalCnt);
							continue;
						}
						break;
					}
					
					if(y < 0 || y >= SIZE || x < 0 || x >= SIZE)
						continue;
					
					maker[pY][pX] = 0;
					pY = y;
					pX = x;
					maker[pY][pX] = PLAYER; 
					
				}	// 맵제작 끝
				
				String save = "";
				for(int i=0; i<SIZE; i++) {
					for(int j=0; j<SIZE; j++) {
						save += map[i][j];
						if(j != SIZE-1)
							save += "/";
					}
					if(i != SIZE-1)
						save += "\n";					
				}
				
				try {
					fw = new FileWriter(file);
					
					fw.write(save);
					
					fw.close();
					
					System.out.println("파일저장 성공");
				} catch (Exception e) {
					System.err.println("파일저장 실패");
				}
				
				
			}else if(choice == 2) {
				if(file.exists()) {
					String load = null;
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						for(int i=0; i<SIZE; i++) {
							load = br.readLine();
							String[] loadArr =  load.split("/");
							for(int j=0; j<SIZE; j++) {
								map[i][j] = Integer.parseInt(loadArr[j]);
							}
						}
						while(true) {							
							int rIdxY = ran.nextInt(SIZE);
							int rIdxX = ran.nextInt(SIZE);
							if(map[rIdxY][rIdxX] == 0) {
								map[rIdxY][rIdxX] = PLAYER;
								pY = rIdxY;
								pX = rIdxX;
								break;
							}
						}
						
						
						br.close();
						fr.close();
						
						System.out.println("로드 성공");
					} catch (IOException e) {
						System.err.println("로드 실패");
						e.printStackTrace();
					}
					
				}else {
					System.err.println("저장된 맵파일이 없습니다.");
				}
				
				while(true) {
					ballCnt = 0;
					goalCnt = 0;
					for(int i=0; i<SIZE; i++) {
						for(int j=0; j<SIZE; j++) {
							if(map[i][j] == PLAYER) {
								System.out.print(" 옷 ");
							}else if(map[i][j] == BALL) {
								System.out.print(" 볼 ");
								ballCnt++;
							}else if(map[i][j] == GOAL) {
								System.out.print(" 골 ");
								goalCnt++;
							}else if(map[i][j] == GOALIN) {
								System.out.print(" 인 ");
							}else if(map[i][j] == WALL) {
								System.out.print(" 벽 ");
							}else if(map[i][j] == 0) {
								System.out.print(" + ");
							}
						}
						System.out.println();
					}
					
					if(ballCnt == 0) {
						System.out.println("GAME CLEAR");
						break;
					}
					
					System.out.println("==========");
					System.out.println("이동  w   ");
					System.out.println("   a s d ");
					System.out.println("==========");
					char input = sc.next().charAt(0);
					
					int y = pY;
					int x = pX;
					
					if(input == 'w') {
						y--;
					}else if(input == 's') {
						y++;
					}else if(input == 'a') {
						x--;
					}else if(input == 'd') {
						x++;
					}
					
					if(y < 0 || y >= SIZE || x < 0 || x >= SIZE || map[y][x] == WALL)
						continue;
					
					if(map[y][x] == BALL) {
						
						int yy = y;
						int xx = x;
						
						if(input == 'w') {
							yy--;
						}else if(input == 's') {
							yy++;
						}else if(input == 'a') {
							xx--;
						}else if(input == 'd') {
							xx++;
						}
						
						if(yy < 0 || yy >= SIZE || xx < 0 || xx >= SIZE || map[y][x] == WALL || map[y][x] == BALL)
							continue;
						
						if(map[yy][xx] == GOAL) {
							map[yy][xx] = GOALIN;
						}else {
							map[yy][xx] = BALL;
						}
					}
					
					if(map[pY][pX] != GOAL && map[pY][pX] != GOALIN)
						map[pY][pX] = 0;
					
					pY = y;
					pX = x;

					if(map[pY][pX] != GOAL && map[pY][pX] != GOALIN)
						map[pY][pX] = PLAYER;						
					
				}
					
			}
			
		}
		
		
	}
}
