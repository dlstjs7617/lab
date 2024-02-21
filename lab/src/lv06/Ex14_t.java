package lv06;
/*
 *  # 나만의 마블
 *  옷 □ □ □ □
 *  □ ■ ■ ■ □
 *  □ ■ ■ ■ □
 *  □ ■ ■ ■ □
 *  □ □ □ □ □
 */

import java.util.Scanner;

// 옷이 이동 숫자를 입력 받을때마다 이동 하는데
// 외각으로 시계방향으로만 이동 아래 그림참조
// ㄴ 입력 : 이동 칸 수(1이상)

class Marble_t{
	 Scanner sc = new Scanner(System.in);

	   final int PLAYER = 1;
	   final int SIZE = 5;

	   final int EAST = 0;
	   final int SOUTH = 1;
	   final int WEST = 2;
	   final int NORTH = 3;

	   int[][] map;

	   int x;
	   int y;

	   int direction; // 동 -> 남 -> 서 -> 북

	   boolean isRun;

	   void setGame() {
	      map = new int[SIZE][SIZE];
	      x = 0;
	      y = 0;
	      map[y][x] = PLAYER;

	      direction = EAST;
	      isRun = true;
	   }

	   void printMap() {
	      for (int i = 0; i < SIZE; i++) {
	         for (int j = 0; j < SIZE; j++) {
	            if (map[i][j] == PLAYER)
	               System.out.print("옷 ");
	            else if (i == 0 || i == SIZE - 1 || j == 0 || j == SIZE - 1) // 외곽
	               System.out.print("□ ");
	            else
	               System.out.print("■ ");
	         }
	         System.out.println();
	      }
	   }

	   int inputNumber() {
	      int number = 0;
	      try {
	         String input = sc.next();
	         number = Integer.parseInt(input);
	      } catch (Exception e) {
	         System.err.println("숫자를 입력하세요.");
	      }

	      return number;
	   }

	   boolean isEnd(int distance) {
	      if (distance < 0) {
	         isRun = false;
	         return true;
	      }
	      return false;
	   }

	   void move(int distance) {

	      if (isEnd(distance)) {
	         return;
	      }

	      // 지역변수에 클래스 멤버 변수의 값으로 초기화
	      int x = this.x;
	      int y = this.y;

	      distance %= SIZE * 4 - 4; // 불필요한 한바퀴 회전 없어주기

	      while (distance > 0) {
	         int tempX = x;
	         int tempY = y;

	         if (direction == EAST)
	            tempX++;
	         else if (direction == SOUTH)
	            tempY++;
	         else if (direction == WEST)
	            tempX--;
	         else if (direction == NORTH)
	            tempY--;

	         // 네 코너를 벗어나는 순간 확인 -> 방향 전환 (동남서북)
	         if (!checkDirection(tempX, tempY))
	            continue;

	         x = tempX;
	         y = tempY;

	         distance--;
	      }

	      putPlayer(x, y);

	   }

	   boolean checkDirection(int x, int y) {
	      boolean isChecked = true;
	      if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
	         direction = direction + 1 > NORTH ? EAST : ++direction;
	         isChecked = false;
	      }
	      return isChecked;
	   }

	   void putPlayer(int x, int y) {
	      // 플레이어 다시 그리기
	      map[this.y][this.x] = 0;
	      this.x = x;
	      this.y = y;
	      map[this.y][this.x] = PLAYER;
	   }

	   void run() {
	      setGame();
	      while (isRun) {
	         printMap();
	         int number = inputNumber();
	         move(number);
	      }
	   }

}

public class Ex14_t {

	public static void main(String[] args) {
		Marble_t game = new Marble_t();
		game.run();

	}

}
