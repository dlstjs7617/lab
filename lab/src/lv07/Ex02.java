package lv07;

import java.util.Scanner;

class Tic{
	// 네모 한칸
	final int P1 = 1;
	final int P2 = 2;
	
	int player;
	String outputPrint = "";
	
	void run() {
		if(player == P1)
			outputPrint ="[O]";	
		else if(player == P2)
			outputPrint ="[X]";
		else
			outputPrint ="[ ]";
	}
	
	@Override
	public String toString() {
		return String.format("%s", outputPrint);
	}
	
}

class Tictactoe{
	// 게임 구현
	
	Scanner sc = new Scanner(System.in);

	Tic tic = new Tic();
	
	final int SIZE = 3;
	final int P1 = 1;
	final int P2 = 2;
	
	int turn;
	int win;
	
	
	Tic[][] map = new Tic[SIZE][SIZE];
	
	
	void setGame() {
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				map[i][j] = new Tic();
			}
		}
		
		turn = P1;
		win = 0;
	}
	
	void printMap() {
		System.out.printf("P%d 의 차례 \n",turn);
		
		System.out.println("==== 틱택토 ==== ");
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				map[i][j].run();
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	void changeTurn() {
		turn = turn == P1 ? P2 : P1;
	}
	
	boolean checkMap(int y , int x) {
		if(map[y][x].player != 0) {
			System.err.println("이미 놓은 자리입니다.");			
			return true;
		}
		return false;
	}
	
	boolean isRun() {
		
		if(win != 0)
			return false;
		else {
			return true;			
		}
	}
	
	int inputNumber(String messeage) {
		int num = -1;
		System.out.print(messeage +"입력 :");
		
		try {
			String input = sc.next();
			num = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return num;
	}
	
	boolean idxExcetion(int y, int x) {
		if(x < 0 || x >= SIZE || y < 0 || y >= SIZE)
			return true;
		
		return false;
	}
	
	void drawingMap(int y , int x) {
		map[y][x].player = turn;
	}
	
	boolean drawGame() {
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(map[i][j].player == 0)
					return true;
			}
		}
		
		return false;
	}
	
	boolean width() {
		for(int i=0; i<SIZE; i++) {
			int cnt = 0;
			for(int j=0; j<SIZE; j++) {
				if(map[i][j].player == turn)
					cnt++;	
			}
			if(cnt == 3) {
				return true;
			}
		}	
		return false;
	}
	
	boolean height() {
		for(int i=0; i<SIZE; i++) {
			int cnt = 0;
			for(int j=0; j<SIZE; j++) {
				if(map[j][i].player == turn)
					cnt++;	
			}
			if(cnt == 3) {
				return true;
			}
		}	
		return false;
	}
	
	boolean diagonal() {
		int cnt = 0;
		for(int i=0; i<SIZE; i++) {
			if(map[i][i].player == turn)
				cnt++;
		}
		if(cnt == 3)
			return true;
		return false;
	}
	
	boolean reverseDiagonal() {
		int cnt = 0;
		
		for(int i=0; i<SIZE; i++) {
			if(map[i][SIZE-i-1].player == turn)
				cnt++;
		}
		
		if(cnt == 3)
			return true;
		
		return false;
	}
	
	int win() {
		
		if(width() || height() || diagonal() || reverseDiagonal()) {
			printMap();
			win = turn;
		}
		return  win;
	}
	
	void winnerPrint() {
		if(win != 0)
			System.out.printf("P%d의 승리",win);
		else
			System.out.println("무승부");
	}
	
	void run() {
		setGame();
		
		while(isRun()) {
			printMap();
			int y = inputNumber("y좌표");
			int x = inputNumber("x좌표");
			
			if(idxExcetion(y ,x))
				continue;
			if(checkMap(y ,x))
				continue;
			drawingMap(y ,x);
			if(!drawGame())
				break;
			win();
			changeTurn();
		}
		winnerPrint();
	}
}

public class Ex02 {

	public static void main(String[] args) {
		Tictactoe ttt = new Tictactoe();
		ttt.run();

	}

}
