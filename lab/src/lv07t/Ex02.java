package lv07t;

import java.util.Scanner;

class Tic{
	// 네모 한 칸
	boolean isMarked; // false;
	int owner;		  // 0	
	
	@Override
	public String toString() {
		return isMarked ? (owner == 1 ? "[O]" : "[X]") : "[ ]";
	}
	
}

class Tictactoe{
	// 게임 구현
	Scanner sc = new Scanner(System.in);
	
	final int SIZE = 3;
	final int P1 = 1;
	final int P2 = 2;
	
	Tic[][] map;
	
	int turn;
	int win;
	
	void setGame() {
		turn = P1;
		win = 0;
		
		setMap();
	}
	
	void setMap() {
		map = new Tic[SIZE][SIZE];
		
		/*
		 * {null, null, null},
		 * {null, null, null},
		 * {null, null, null}
		 */
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				map[i][j] = new Tic();	// null -> 객체 인스턴스
			}
		}
	}
	
	void printMap() {
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	int inputNumber(String message) {
		int number = -1;
		
		System.out.println(message + " : ");
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자를 입력하세요.");
		}
		
		return number;
	}
	
	void marking() {
		int y = inputNumber("P" + turn + " y");
		int x = inputNumber("P" + turn + " x");
		
		if(y < 0 || y >= SIZE || x < 0 || x >= SIZE || map[y][x].isMarked)
			return;
		
		Tic tic = map[y][x];
		tic.isMarked = true;
		tic.owner = turn;
		
		checkWin();
		changeTurn();
	}
	
	void changeTurn() {
		turn = turn == P1 ? P2 : P1;
	}
	
	
	void checkWin() {
		if(checkHorison())
			return;
		if(checkVertical())
			return;
		if(checkDiagonal())
			return;
		if(checkReversedDiagonal())
			return;
	}
	
	boolean checkHorison() {
		for(int i=0; i<SIZE; i++) {
			int cnt = 0;
			for(int j=0; j<SIZE; j++) {
				if(map[i][j].owner == turn)
					cnt++;
				if(cnt == SIZE) {
					win = turn;
					return true;					
				}
			}
		}
		return false;
	}
	
	boolean checkVertical(){
		for(int i=0; i<SIZE; i++) {
			int cnt = 0;
			for(int j=0; j<SIZE; j++) {
				if(map[j][i].owner == turn)
					cnt++;
				if(cnt == SIZE) {
					win = turn;
					return true;					
				}
			}
		}
		return false;
	}
	
	boolean checkDiagonal() {
		int cnt = 0;
		for(int i=0; i<SIZE; i++) {
			if(map[i][i].owner == turn)
				cnt++;
		}
		if(cnt == SIZE) {
			win = turn;
			return true;
		}
		
		return false;
	}
	
	boolean checkReversedDiagonal()	{
		int cnt = 0;
		for(int i=0; i<SIZE; i++) {
			if(map[i][SIZE-1-i].owner == turn)
				cnt++;
		}
		if(cnt == SIZE) {
			win = turn;
			return true;
		}
		return false;
	}
	
	boolean isDraw() {
		int cnt = 0;
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(map[i][j].isMarked)
					cnt++;
			}
		}
		if(cnt == SIZE*SIZE)
			return true;
		
		return false;
	}
	
	void printResult() {
		if(win == 0)
			System.out.println("DRAW~");
		else {
			System.out.printf("P%d WIN!!!", win);
		}
	}
	
	boolean isRun() {
		return win == 0 && !isDraw() ? true : false;
	}
	
	void run() {
		setGame();
		while(isRun()) {
			printMap();
			marking();
		}
		printResult();
	}
}

public class Ex02 {

	public static void main(String[] args) {
		Tictactoe game = new Tictactoe();
		game.run();

	}

}
