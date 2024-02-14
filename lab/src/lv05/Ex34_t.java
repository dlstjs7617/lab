package lv05;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex34_t {
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
		
		while(true) {
			// print
			
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					System.out.printf("[%2d]",game[i][j]);
					
					if(game[i][j] == 0) {
						y = i;
						x = j;
					}
				}
				System.out.println();
			}
			System.out.println("a) left d) right w) up s) down r)되감기");
			int dir = sc.next().charAt(0);
			
			int yy = y;
			int xx = x;
			
			if(dir == 'a') {
				xx--;
			}else if(dir == 'd') {
				xx++;
			}else if(dir == 'w') {
				yy--;
			}else if(dir == 's') {
				yy++;
			}else if(dir == 'r') {
				if(move == 0) {
					System.err.println("더이상 이동할 수 없습니다.");
					continue;
				}
				
				yy = yx[move-1][0];
				xx = yx[move-1][1];
				
				int[][] temp = yx;
				yx = new int[move -1][];
				
				for(int i=0; i<move-1; i++)
					yx[i] = temp[i];
				
				move--;
			}
			
			if(yy < 0 || yy >= SIZE || xx < 0 || xx >= SIZE)
				continue;
			
			// 이동이 발생하면 -> yx변수에 현재 좌표 -> 기록
			if("adws".contains(String.valueOf((char)dir))) {
				int[][] temp = yx;
				yx = new int[move +1][];
				
				for(int i=0; i<move; i++) {
					yx[i] = temp[i];
				}
				
				//마지막 인덱스에 현좌표 기록
				yx[move] = new int[2];		// {0 , 0}
				yx[move][0] = y;
				yx[move][1] = x;
				
				move++;
			}
			
			// 이동
			int temp = game[yy][xx];
			game[yy][xx] = game[y][x];
			game[y][x] = temp;
			
			
			
		}
		
		
			
		
	}

}
