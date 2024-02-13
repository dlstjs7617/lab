package lv05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Ex31_t {
	
	// 플레이어가 돌아다니면서 폭탄 내려놓듯이 구조물을 설치 -> 파일로 저장 후,
	// 콘솔종료 후 재실행 시에도 -> 게임을 이어갈 수 있게 만들어보세요
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 9;
		// 이동
		final int LEFT = 'a';
		final int RIGHT = 'd';
		final int UP = 'w';
		final int DOWN = 's';		
		
		final int INSTALL_WALL = '1';
		final int INSTALL_BALL = '2';
		final int INSTALL_GOAL = '3';
		final int REMOVE = '4';
		final int EXIT = '0';
		
		final int PLAYER = 2;
		final int WALL = 3;
		final int BALL = 4;
		final int GOAL = 5;
		final int GOAL_IN = 6;
		
		int pY = 0;
		int pX = 0;
		int ballY = 0;
		int ballX = 0;
		
		int[][] map = new int[SIZE][SIZE];
		int[][] maker = new int[SIZE][SIZE];
	
		String fileName = "maker.txt";
		
		File file = new File(fileName);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		String lastPos = null;	// y/x
		
		int ballCnt = 0;
		int goalCnt = 0;
		
		maker[pY][pX] = PLAYER;

		//파일 로드
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			int y = 0;
			while(y < SIZE) {
				String[] line = br.readLine().split("/");
				
				for(int x=0; x<line.length; x++) { 			// x : map 배열의 바깥 인덱스
					map[y][x] = Integer.parseInt(line[x]);
					
					if(map[y][x] == BALL)
						ballCnt++;
					else if(map[y][x] == GOAL)
						goalCnt++;
				}
				y++;
			}
			
			lastPos = br.readLine();
			
			br.close();
			fr.close();
			System.out.println("파일로드 성공");
		}catch (Exception e) {
			System.out.println("파일로드 실패");
		}
		
		
		while(true) {
			boolean load = false;
			System.out.println("[1] 소코반 메이커");
			System.out.println("[2] 게임 시작하기");
			// 저장된 맵이 있으면 -> 불러와서 게임시작
			System.out.println("[0] 종료하기");
			
			int choice = sc.nextInt();
			
			if(choice == 1) {
				while(true) {
					// 맵출력
					for(int i=0; i<SIZE; i++) {
						for(int j=0; j<SIZE; j++) {
							if(map[i][j] != 0 && maker[i][j] == PLAYER) {
								System.out.print("* ");
							}
							else if(maker[i][j] == PLAYER) {
								System.out.print("옷 ");
							}else if(map[i][j] == WALL) {
								System.out.print("벽 ");
							}else if(map[i][j] == BALL) {
								System.out.print("공 ");
							}else if(map[i][j] == GOAL) {
								System.out.print("골 ");
							}else {
								System.out.print("+ ");
							}
//							else if(i == pY && j == pX) {
//							System.out.print("옷 ");
							
						}
						System.out.println();					
					}	//맵 출력 종료
					System.out.println();
					
					System.out.println("[이동] ▶ 상(w)하(s)좌(a)우(d)");
					System.out.println("[설치] ▶ 벽(1)공(2)골(3)제거(4)");
					System.out.println("[종료] ▶ 0");
					
					int move = sc.next().charAt(0);
					
					// 이동용 임시좌표
					int y = pY;
					int x = pX;
					
					if(move == LEFT)
						x--;
					else if(move == RIGHT)
						x++;
					else if(move == UP)
						y--;
					else if(move == DOWN)
						y++;
					
					// 이동에 대한 예외처리
					if(y < 0 || y >= SIZE || x < 0 || x >= SIZE)
						continue;
					
					// 구조물 설치 예외처리
					if(map[y][x] != 0 && (move == INSTALL_WALL || move == INSTALL_BALL || move == INSTALL_GOAL))
						continue;
					
					// 구조물 설치
					if(move == INSTALL_WALL)
						map[y][x] = WALL;
					else if(move == INSTALL_BALL) {
						map[y][x] = BALL;
						ballCnt++;
					}
					else if(move == INSTALL_GOAL) {
						map[y][x] = GOAL;
						goalCnt++;
					}
					else if(move == REMOVE) {
						if(map[y][x] == BALL)
							ballCnt--;
						else if(map[y][x] == GOAL)
							goalCnt--;
						map[y][x] = 0;
					}
					else if(move == EXIT) {
						if(ballCnt != goalCnt) {
							System.out.println("공과 골대는 쌍을 이루어야 합니다.");
							continue;
						}
						break;
					}
					// 플레이어 이동 (좌표만 변경)
					maker[pY][pX] = 0;
					pY = y;
					pX = x;
					maker[pY][pX] = PLAYER;
					
				}
				
			}else if(choice == 2) {
				// 게임 실행
				// ㄴ 게임용 플레이어의 좌표 -> 랜덤으로 배치
				
				int y = 0;
				int x = 0;
				
				if(lastPos == null) {
					while(true) {
						int rY = ran.nextInt(SIZE);
						int rX = ran.nextInt(SIZE);
						
						if(map[rY][rX] == 0) {
							map[rY][rX] = PLAYER;
							y = rY;
							x = rX;
							break;
						}					
					}
				}else {
					String[] pos = lastPos.split("/");
					y = Integer.parseInt(pos[0]);
					x = Integer.parseInt(pos[1]);
				}
				
				map[y][x] = PLAYER;
				
				boolean isRun = true;
				while(isRun) {
					for(int i=0; i<SIZE; i++) {
						for(int j=0; j<SIZE; j++) {
							if(map[i][j] == PLAYER) {
								System.out.print("옷 ");
							}else if(map[i][j] == WALL) {
								System.out.print("벽 ");
							}else if(map[i][j] == BALL) {
								System.out.print("공 ");
							}else if(map[i][j] == GOAL) {
								System.out.print("골 ");
							}else if(map[i][j] == GOAL_IN){
								System.out.print("인 ");
							}else {
								System.out.print("+ ");
							}
//							else if(i == pY && j == pX) {
//							System.out.print("옷 ");
							
						}
						System.out.println();					
					}	//맵 출력 종료
					
					// 종료 조건
					if(ballCnt == 0) {
						System.out.println("GAME CLEAR~");
						map = new int[SIZE][SIZE];
						lastPos = null;
						break;
					}
					
					System.out.println("[이동] ▶ 상(w)하(s)좌(a)우(d)");
					System.out.println("[종료] ▶ 0");
					int move = sc.next().charAt(0);
					
					int yy = y;
					int xx = x;
					
					if(move == LEFT)
						xx--;
					else if(move == RIGHT)
						xx++;
					else if(move == UP)
						yy--;
					else if(move == DOWN)
						yy++;
					else if(move == EXIT)
						break;
					
					// 플레이어 이동 예외처리
					if(yy < 0 || yy >= SIZE || xx < 0 || xx >= SIZE || map[yy][xx] == WALL)
						continue;
					
					// 이동시 공이 있을때 이동처리
					if(map[yy][xx] == BALL) {
						int bY = yy;
						int bX = xx;
						
						if(move == LEFT)
							bX--;
						else if(move == RIGHT)
							bX++;
						else if(move == UP)
							bY--;
						else if(move == DOWN)
							bY++;
						else if(move == EXIT) {
							// 플레이어용 좌표 기억이 필요
							lastPos = y + "/" + x;
							break;
						}
						
						// 공에 대한 이동처리
						if(bY < 0 || bY >= SIZE || bX < 0 || bX >= SIZE || map[bY][bX] == WALL || map[bY][bX] == GOAL_IN)
							continue;
						
						if(map[bY][bX] == GOAL) {
							map[bY][bX] = GOAL_IN;
							ballCnt--;
							goalCnt--;
						}
						else
							map[bY][bX] = BALL;
						
						map[bY][bX] = BALL;
					}
					if(map[y][x] != GOAL)
						map[y][x] =0;
					y = yy;
					x = xx;
					if(map[y][x] != GOAL)
						map[y][x] = PLAYER;
				}
				
				
			}else if(choice == 0) {
				break;
			}
			
			// 파일 저장(map)
			String mapData = "";
			
			for(int i=0; i<SIZE; i++) {
				String line = "";
				for(int j=0; j<SIZE; j++) {
					line += map[i][j] + "/";
				}
				mapData += line.substring(0,line.length()-1);
				
				if(i < SIZE-1)
					mapData += "\n";
			}
			
			try {
				fw = new FileWriter(file);
				fw .write(mapData);
				
				if(lastPos != null)
					fw.write("\n "+lastPos);
				
				fw.close();
				
				System.out.println("파일저장 성공");
			} catch (Exception e) {
				System.err.println("파일저장 실패");
			}
		}
		
	}

}
