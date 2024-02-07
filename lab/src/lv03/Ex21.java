package lv03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex21 {
	
	/*
	 * #미니 마블
	 * 1. 플레이어는 p1과 p2 2명이다
	 * 2. 번갈아가며 1~3 사이의 숫자를 입력해 이동한다.
	 * 3. 이동하다가 다음 플레이어와 같은 위치에 놓이게 되면,
	 * 	  상대 프레이어는 잡히게 되어 원점으로 되돌아간다.
	 * 4. 먼저 3바퀴를 돌면 이긴다.
	 * 
	 * [p2]1~3
	 * 1 2 3 4 5 6 7 8
	 * 0 1 0 0 0 0 0 0
	 * 0 0 0 2 0 0 0 0
	 * 
	 * [p1]1~3 입력 : 2
	 * [p1]이 p2를 잡았다!
	 * 1 2 3 4 5 6 7 8
	 * 0 0 0 1 0 0 0 0
	 * 2 0 0 0 0 0 0 0
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] game = null;
		int[] p1 = null;
		int[] p2 = null;
		
		game = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8}; 
		p1 = new int[]  { 0, 0, 0, 0, 0, 0, 0, 0};
		p2 = new int[]  { 0, 0, 0, 0, 0, 0, 0, 0};
		
//		int[] game = { 1, 2, 3, 4, 5, 6, 7, 8 };
//		int[] p1 = { 0, 0, 0, 0, 0, 0, 0, 0 };
//		int[] p2 = { 0, 0, 0, 0, 0, 0, 0, 0 };
		
		final int SIZE = 8;
		
		int turn = 1;
		
		//각 플레이어의 현 좌표(인덱스)
		int idx1 = 0;
		int idx2 = 0;
		
		// 게임 시작 전, 플레이어 위치
		p1[idx1] = 1;
		p2[idx2] = 2;
		
		int p1Cnt = 0;
		int p2Cnt = 0;
		
		boolean isRun = true;
		
		while(isRun) {
			//출력
			System.out.println("======================");
			System.out.println(Arrays.toString(game));
			System.out.println(Arrays.toString(p1));
			System.out.println(Arrays.toString(p2));
			System.out.println("p1은 " + p1Cnt + "바퀴");
			System.out.println("p2은 " + p2Cnt + "바퀴");
			System.out.println("======================");
			//입력
			System.out.printf("P[%d]의 차례 : ", turn);
			int move = sc.nextInt();
			
			//예외처리
			if(move < 0 || move > 3) {
				System.out.println("0~3값을 입력해주세요");
				continue;
			}
			
			//위치 이동
			if(turn == 1) {
				if (idx1+move >= 8) {	// 8초과시
					p1[idx1+move-SIZE] = 1;
					p1[idx1] = 0;
					idx1 = idx1+move-SIZE;
					p1Cnt++;
				}else {
					p1[idx1+move] = 1;
					p1[idx1] = 0;
					idx1 = idx1+move;				
				}
				if(idx1 == idx2) {	// 잡았을시
					p2[idx2] = 0;
					idx2 = 0;
					p2[idx2] = 2;
					System.err.println("잡았습니다!");
					continue;
				}
				
			}else if(turn == 2) {
				if (idx2+move >= 8) {	// 8초과시				
					p2[idx2+move-SIZE] = 2;
					p2[idx2] = 0;
					idx2 = idx2+move-SIZE;										
					p2Cnt++;
				}else {					
					p2[idx2+move] = 2;
					p2[idx2] = 0;
					idx2 = idx2+move;
				}
				if(idx2 == idx1) {	//잡았을시
					p1[idx1] = 0;
					idx1 = 0;
					p1[idx1] = 1;
					System.err.println("잡았습니다!");
					continue;
				}
			}

			//승리 트리거
			if(p1Cnt >= 3 || p2Cnt >= 3)
				break;
			
			//턴 변경
			if(turn == 1) {
				turn++;
			}else if (turn == 2) {
				turn--;
			}
			
			
			
		}
		System.out.println("---------------");
		System.out.printf("p%d의 승리\n", turn);
		System.out.println("---------------");

		
	}

}
