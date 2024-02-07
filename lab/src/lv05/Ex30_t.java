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
		final int PLAYER = 2;
		final int WALL = 3;
		final int ITEM = 4;
		final int BOMB = 9;
		
		int[][] map = new int[SIZE][SIZE];
		int[][] tempMap = new int[SIZE][SIZE];		//폭탄용 임시 좌표맵
		
		int pY = 0;
		int pX = 0;
		
		// 설치된 폭탄의 좌표를 기억해야 함 -> 순서대로 폭파
		int itemCnt = 10;
		int bombCnt = 0;
		int[][] bombYx = null; //{bomY,bombX},{bombY,bombX},{bombY,bombX},{bombY,bombX}...}
		
		
	}

}
