package lv05;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex34 {
			// 문제1) 0 이 플레이어이다
			// a) left d) right w) up s) down r)되감기
			// 번호를 입력받고 해당위치로 이동 ==> 이동할때 값을 서로 교환한다.
			// 예) a(왼쪽이동) ===>
			/*
			 		{1,2,3,4},
					{5,6,7,8},
					{9,10,11,12},
					{13,14,0,15}
			 */
			
			//문제2) 심화 ==> 한칸한칸이동할때마다 yx 에 배열에 이동한 경로를 저장했다가
			// r값을 N번 입력할때마다 왔던길로 되돌아가기 한다.
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 4;
		
		int y = 0;
		int x = 0;
		
		int game[][] = {
				{1 ,2 ,3 ,4 },
				{5 ,6 ,7 ,8 },
				{9 ,10,11,12},
				{13,14,15,0 }
		};
		
		int move = 0;			// 4
		int yx [][] = null;		// {y,x}, {y,x},{y,x}, {y,x}, ... };
		
		// 숫자 섞기
		int[] temp = new int[16];
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				int rNum= ran.nextInt(16);
				if(temp[rNum] == 0) {
					game[i][j] = rNum;
					temp[rNum] = 1;
					if(game[i][j] == 0) {
						y = i;
						x = j;
					}
				}else
					j--;
			}			
		}
		while(true) {
//			if(yx != null) {
//				for(int i=0; i<move; i++) {
//					System.out.printf("y : %d  x : %d \n", yx[i][0], yx[i][1]);
//				}				
//			}
			
			
			// 보드판 출력
			System.out.println("=================");
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					System.out.printf("%2d ",game[i][j]);
				}
				System.out.println();
			}
			System.out.println("=================");
			System.out.println("a) left d) right w) up s) down r)되감기");
			char input = sc.next().charAt(0);
			
			int yy = y;
			int xx = x;
			
			if(input == 'a') {
				xx--;
			}else if(input == 'd') {
				xx++;
			}else if(input == 'w') {
				yy--;
			}else if(input == 's') {
				yy++;
			}else if(input == 'r') {
				if(move == 0) {
					System.err.println("더이상 되돌릴 수 없습니다.");
					continue;
				}
				
				int[][] tempLog = yx;
				yx = new int[move-1][];
				for(int i=0; i<move-1; i++) {
					yx[i] = tempLog[i]; 
				}
				
				yy = tempLog[move-1][0];
				xx = tempLog[move-1][1];
				
				int num = game[yy][xx];
				game[y][x] = num;
				game[yy][xx] = 0;
				y = yy;
				x = xx;
				move--;
				
			}
			
			if(xx < 0 || xx >= SIZE || yy < 0 || yy >= SIZE) 
				continue;
			
			if(input != 'r') {
				int[][] tempLog = yx;
				yx = new int[move+1][2];
				for(int i=0; i<move; i++) {
					yx[i] = tempLog[i]; 
				}
				yx[move][0] = y;
				yx[move][1] = x;
				move++;
				
				int num = game[yy][xx];
				game[yy][xx] = 0;
				game[y][x] = num;
				y = yy;
				x = xx;
			
			}
			
			
			
			
		}
		
		
	}

}
