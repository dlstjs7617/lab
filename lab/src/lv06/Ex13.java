package lv06;

import java.util.Scanner;

/*
 * # 틱택톡
 */

class Tictactoe{
	
	Scanner sc = new Scanner(System.in);
	
	final int SIZE = 3;
	final int PLAYER1 = 1;
	final int PLAYER2 = 2;
	
	int[][] map;
	
	int turn;
	int win;
	
	void setMap(){
		map = new int[SIZE][SIZE];
		turn = 1;
	}
	
	boolean isRun() {
		if(win != 0)
			return false;
		else {
			return true;
		}
	}
	
	void printMap() {
		System.out.println(turn+"의 차례");
		System.out.println("   0  1  2");
		for(int i=0; i<SIZE; i++) {
			System.out.print(i + " ");
			for(int j=0; j<SIZE; j++) {
				if(map[i][j] == PLAYER1)
					System.out.print("[O]");
				else if(map[i][j] == PLAYER2)
					System.out.print("[X]");
				else
					System.out.print("[ ]");
			}
			System.out.println();
		}
	}
	
	int inputIdx() {
		int num = -1;
		
		try {
			System.out.print("좌표입력 : ");
			String temp = sc.next();
			num = Integer.parseInt(temp);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return num;
	}
	
	boolean idxExcetion(int y ,int x) {
		boolean result = true;
		if(y < 0 || y >= SIZE || x < 0 || x >= SIZE) {
			System.err.println("유효한 범위 아님");
			result = false;
			return result;			
		}
		
		if(map[y][x] == PLAYER1 || map[y][x] == PLAYER2) {
			System.err.println("이미 놓여진 자리");
			result = false;			
			return result;
		}
		return result;
		
	}
	            
	void writeMap(int y , int x) {
		map[y][x] = turn;
	}
	
	boolean width() {
		boolean win = false;
		int cnt = 0;
		
		// -
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(map[i][j] == turn)
					cnt++;
				if(cnt == 3) {
					win = true;
				}
			}
			cnt = 0;
		}
		
		return win;
	}
	
	boolean height() {
		boolean win = false;
		int cnt = 0;
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (map[j][i] == turn)
					cnt++;
				if (cnt == 3) {
					win = true;
				}
			}
			cnt = 0;
		}
		
		return win;
	}
	
	boolean rightDiagonal() {
		boolean win = false;
		int cnt = 0;
		
		// \
		for (int i = 0; i < SIZE; i++) {
			if (map[i][i] == turn)
				cnt++;
		}
		
		if (cnt == 3)
			win = true;
		return win;
	}
	
	boolean leftDiagonal() {
		boolean win = false;
		int cnt = 0;
		int minCnt = 2;
		
		// /
		for(int i=0; i<SIZE; i++) {
			if(map[i][minCnt--] == turn)
				cnt++;
		}
		if(cnt == 3)
			win = true;
		return win;
	}
	
	int winLogic() {
		int win = 0;
		
		if(width() || height() || rightDiagonal() || leftDiagonal())
			win = turn;
		
		return win;
	}
	
	boolean draw() {
		boolean draw = true;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(map[i][j] != 0)
					draw = false;
			}
		}
		
		return draw;
	}
	
	void filpTurn() {
		turn = turn == PLAYER1 ? PLAYER2 : PLAYER1;
	}
	
	void winPrint() {
		if(win == PLAYER1) {
			System.out.println("PLAYER1 의 승리");
		}else if(win == PLAYER2) {
			System.out.println("PLAYER2 의 승리");			
		}else {
			System.out.println("무승부");
		}
	}
	
	void run() {
		setMap();
			
		while(isRun()) {
			printMap();
			
			int y = inputIdx();
			int x = inputIdx();
			if(idxExcetion(y,x)) {
				writeMap(y, x);
			}else {
				continue;
			}
			win = winLogic();
			if(draw()) {
				break;
			}
			
			filpTurn();

		}
		winPrint();
	}
}


public class Ex13 {

	public static void main(String[] args) {
		Tictactoe game = new Tictactoe();
		game.run();
	}

}
