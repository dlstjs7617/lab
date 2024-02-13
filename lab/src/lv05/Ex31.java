package lv05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Ex31 {
	
	// 플레이어가 돌아다니면서 폭탄 내려놓듯이 구조물을 설치 -> 파일로 저장 후,
	// 콘솔종료 후 재실행 시에도 -> 게임을 이어갈 수 있게 만들어보세요
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 9;
		final int PLAYER = 2;
		final int WALL = 3;
		final int BALL = 4;
		final int GOAL = 5;
		
		// 이동
		final int LEFT = 'a';
		final int RIGHT = 'd';
		final int UP = 'w';
		final int DOWN = 's';
		
		int pY = 0;
		int pX = 0;
		int ballY = 0;
		int ballX = 0;
		
		int ballCnt = 0;
		int goalCnt = 0;
		
		int[][] map = new int[SIZE][SIZE];
		int[][] maker = new int[SIZE][SIZE];
		
		boolean isRun = false;
		
		String fileName = "maker.txt";
		
		maker[pY][pX] = PLAYER;
		
		fileName = "maker.txt";
		File file = new File(fileName);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		
		while(true) {
			boolean load = false;
			System.out.println("[1] 소코반 메이커");
			System.out.println("[2] 게임 시작하기");
			// 저장된 맵이 있으면 -> 불러와서 게임시작
			System.out.println("[0] 종료하기");
			
			int choice = sc.nextInt();
			
			if(choice == 1) {
				// 저장된 맵 불러올지 말지 선택
				System.out.println("저장된 맵을 불러오시겠습니까?");
				System.out.print("1. 불러오기 2. 새로만들기 : ");
				int sel = sc.nextInt();
				
				if(sel == 1) {
					if(!file.exists()) {
						System.out.println("파일이 없습니다.");
						continue;
					}
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						boolean empty = br.ready();
						if(!empty) {
							System.out.println("파일 내용이 없습니다.");
							continue;
						}
						for(int i=0; i<SIZE; i++) {
							if(br.ready()) {
								String data = br.readLine();
								
								for(int j=0; j<SIZE; j++) {
									String[] dataArr = data.split("/");
									maker[i][j] = Integer.parseInt(dataArr[j]);
								}							
							}
							System.out.println("");
						}
						
						br.close();
						fr.close();
						
						System.out.println("데이터 불러오기 성공");
						load = true;
					} catch (Exception e) {
						System.out.println("데이터 불러오기 실패");
						continue;
					}	
				}
				//맵 설치하기 while시작지점
				while(true) {
					if(!load)
						maker = new int[SIZE][SIZE];
					
					goalCnt = 0;
					ballCnt = 0;
					//맵 출력 시작
					for(int i=0; i<SIZE; i++) {
						for(int j=0; j<SIZE; j++) {
							if(map[i][j] != 0 && maker[i][j] == PLAYER) {
								System.out.print("*\t");
							}else if(maker[i][j] == PLAYER) {
								System.out.print("옷\t");
								pY = i;
								pX = j;
							}else if(maker[i][j] == WALL) {
								System.out.print("벽\t");
							}else if(maker[i][j] == BALL) {
								System.out.print("공\t");
								ballCnt++;
							}else if(maker[i][j] == GOAL) {
								System.out.print("골\t");
								goalCnt++;
							}else {
								System.out.print(map[i][j] + "\t");
							}
						}
						System.out.println("\n");					
					}	//맵 출력 종료
					System.out.println();
					
					System.out.println("[이동] ▶ 상(w)하(s)좌(a)우(d)");
					System.out.println("[설치] ▶ 벽(1)공(2)골(3)");
					System.out.println("[종료] ▶ 0");
					
					// 이동
					char move = sc.next().charAt(0);
					
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
					
					if(x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
						continue;
					}
					if(move == '1') {
						maker[y][x] = WALL;
					}else if(move == '2') {
						maker[y][x] = BALL;
					}else if(move == '3') {
						maker[y][x] = GOAL;
					}
					if(maker[pY][pX] == PLAYER)
						maker[pY][pX] = 0;
					pY = y;
					pX = x;
					if(maker[pY][pX] == 0)
						maker[pY][pX] = PLAYER;
					y = 0;
					x = 0;
					
					if(move == '0') {
						if(goalCnt == 0 || ballCnt == 0 || goalCnt != ballCnt) {
							System.out.println("공갯수와 골대갯수가 맞지 않습니다.");
							System.out.printf("현재 공 : %d개 골대 : %d개 \n", ballCnt, goalCnt);
							continue;
						}
						
						
						
						System.out.println("맵 제작 종료");
						
						String data = "";
						
						try {
							fw = new FileWriter(file);
							
							for(int i=0; i<SIZE; i++) {
								for(int j=0; j<SIZE; j++) {
									data += maker[i][j];
									if(j != SIZE-1)
										data+= "/";
								}
								if(i != SIZE-1)
									data += "\n";
							}
							
							fw.write(data);
							
							fw.close();
							System.out.println("파일 저장성공");
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("파일 저장 실패");
						}
						
						
						
						break;
					}
					
					
					
				}	//맵 설치하기 while종료지점
			}else if(choice == 2) {
				if(!file.exists()) {
					System.out.println("파일이 없습니다.");
					continue;
				}
				try {
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					
					
					
					//파일 내부 확인
					boolean empty = br.ready();
					if(!empty) {
						System.out.println("파일 내용이 없습니다.");
						continue;
					}
					for(int i=0; i<SIZE; i++) {
						if(br.ready()) {
							String data = br.readLine();
							for(int j=0; j<SIZE; j++) {
								String[] dataArr = data.split("/");
								map[i][j] = Integer.parseInt(dataArr[j]);
								if(map[i][j] == PLAYER) {
									map[i][j] = 0;
								}
							}							
						}
						System.out.println("");
					}
					
					br.close();
					fr.close();
					
					isRun =true;
					System.out.println("데이터 불러오기 성공");
				} catch (Exception e) {
					System.out.println("데이터 불러오기 실패");
					e.printStackTrace();
				}
				
				//플레이어 배치
				while(isRun) {
					int rY = ran.nextInt(SIZE);
					int rX = ran.nextInt(SIZE);
					
					if(map[rY][rX] == 0) {
						map[rY][rX] = PLAYER;
						pY = rY;
						pX = rX;
						break;
					}
				}
				
				// 게임시작
				while(isRun){
					goalCnt = 0;
					ballCnt = 0;
					int end = 0;
					
					for(int i=0; i<SIZE; i++) {
						for(int j=0; j<SIZE; j++) {
							if(map[i][j] == PLAYER) {
								System.out.print("옷\t");
							}else if(map[i][j] == WALL) {
								System.out.print("벽\t");
							}else if(map[i][j] == BALL) {
								System.out.print("공\t");
								ballCnt++;
							}else if(map[i][j] == GOAL) {
								System.out.print("골\t");
								goalCnt++;
							}else {
								System.out.print(map[i][j] + "\t");
							}
						}
						System.out.println("\n");					
					}	//맵 출력 종료
					System.out.println();
					
					
					System.out.println("[이동] ▶ 상(w)하(s)좌(a)우(d)");
					System.out.println("[종료] ▶ 0");
					
					// 이동
					char move = sc.next().charAt(0);
					
					int y = pY;
					int x = pX;
					
					if(move == '0') {
						break;
					}
					
					if(move == LEFT) {
						x--;
					}else if(move == RIGHT) {
						x++;
					}else if(move == UP) {
						y--;
					}else if(move == DOWN) {
						y++;
					}
					
					// 인덱스 밖 벽 예외처리
					if(x < 0 || x >= SIZE || y < 0 || y >= SIZE || map[y][x] == WALL)
						continue;
//					if(map[x][y] == WALL)
//						continue;
					
					//공 이동 처리
					if(map[y][x] == BALL) {
						ballY = y;
						ballX = x;
						if(move == LEFT) {
							ballX--;
						}else if(move == RIGHT) {
							ballX++;
						}else if(move == UP) {
							ballY--;
						}else if(move == DOWN) {
							ballY++;
						}
						
						//공에 대한 예외처리
						if(ballX < 0 || ballX >= SIZE ||ballY < 0 || ballY >= SIZE || 
								map[ballY][ballX] == BALL || map[ballY][ballX] == WALL)
							continue;
						
						
						map[y][x] = 0;
						// 공이 골에 도착했을때
						if(map[ballY][ballX] == GOAL) {
							map[ballY][ballX] = 0;
							end++;
						}else {
							map[ballY][ballX] = BALL;							
						}
						
					}
					
					//종료 조건
					if(end == goalCnt) {
						System.out.println("게임 클리어");
						break;
					}
					
					if(map[pY][pX] == PLAYER)
						map[pY][pX] = 0;
					pY = y;
					pX = x;
					if(map[pY][pX] == 0)
						map[pY][pX] = PLAYER;
					y = 0;
					x = 0;
					
				}
				
				
			}else if(choice == 0) {
				break;
			}
			
		}
		
	}

}
