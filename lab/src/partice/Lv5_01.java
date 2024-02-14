package partice;

import java.util.Random;
import java.util.Scanner;

public class Lv5_01 {
	// 소코반 메이커
	public static void main(String[] args) {
		
		final int PLAYER = 2;
		final int BALL = 3; 
		final int GOAL = 4; 
		final int GOALIN = 5; 
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
		
		while(true) {
			// 출력문
			System.out.println("===소코반 메이커===");
			System.out.println("1. 맵 제작");
			System.out.println("2. 게임실행");
			int choice = sc.nextInt();
			if(choice == 1) {
				while(true) {
					
					for(int i=0; i<SIZE; i++) {
						for(int j=0; j<SIZE; j++) {
							if(map[i][j] != 0 && maker[i][j] == PLAYER) {
								System.out.print(" * ");
							}else if(maker[i][j] == PLAYER) {
								System.out.print(" 옷 ");
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
					
					if(map[pY][pX] == 0) {
						maker[pY][pX] = PLAYER; 
					}
					pY = y;
					pX = x;
					
					
				}	// 맵제작 끝
			}else if(choice == 2) {
				
				for(int i=0; i<SIZE; i++) {
					for(int j=0; j<SIZE; j++) {
						if(map[i][j] == PLAYER) {
							System.out.print(" 옷 ");
						}else if(map[i][j] == BALL) {
							System.out.print(" 볼 ");
						}else if(map[i][j] == GOAL) {
							System.out.print(" 골 ");
						}else if(map[i][j] == GOALIN) {
							System.out.print(" 인 ");
						}else if(map[i][j] == 0) {
							System.out.print(" + ");
						}
					}
					System.out.println();
				}
				
				
			}
			
			
			
			
			
			
			break;
		}
		
		
	}
}
