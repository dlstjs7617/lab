package parctice;

import java.util.Random;
import java.util.Scanner;

public class Minecraft {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 20;
		final int GRASS = 0;
		final int TREE = 1;
		final int STONE = 2;
		final int IRON = 3;
		final int COAL = 4;
		final int STICK = 5;
		final int PLAYER = -1;
		
		int heart = 10;
		int hunger = 10;
		
		int hungerCnt = 10;
		
		int[][] map = new int[SIZE][SIZE];
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				int ranMap = ran.nextInt(20);
				if(ranMap == TREE) {
					map[i][j] = TREE;
				}else if(ranMap == STONE) {
					map[i][j] = STONE;
				}else if(ranMap == IRON) {
					map[i][j] = IRON;
				}else if(ranMap == COAL) {
					map[i][j] = COAL;
				}else {
					map[i][j] = GRASS;
				}
			}
		}
		
		int pY = 0;
		int pX = 0;
		map[0][0] = PLAYER;
		
		while(true) {
			//맵출력
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					if(map[i][j] == TREE) {
						System.out.print(" [목] ");
					}else if(map[i][j] == STONE) {
						System.out.print(" [돌] ");
					}else if(map[i][j] == IRON) {
						System.out.print(" [철] ");						
					}else if(map[i][j] == COAL) {
						System.out.print(" [석] ");												
					}else if(map[i][j] == PLAYER){
						System.out.print(" [옷] ");
					}else {
						System.out.print(" [흙] ");																		
					}
				}
				System.out.println();
			}
			System.out.println("===========");
			System.out.println("      ↑ ");
			System.out.println("이동 ← ↓ → ");
			System.out.println("아이템창 : i");
			System.out.println("제작창 : e ");
			System.out.println("===========");
			
			break;
		}

	}

}
