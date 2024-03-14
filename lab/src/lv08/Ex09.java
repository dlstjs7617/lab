package lv08;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

class Box{
	private int player;
	private boolean isFlipped;
	
	public int getPlayer() {
		return player;
	}
	
	public boolean getIsFlipped() {
		return isFlipped;
	}
	
	public void setOner(int turn) {
		this.player = turn;
		this.isFlipped = true;
	}
	
	
	@Override
	public String toString() {
		return player != 0 ? (player == 1 ? "[O]" : "[X]") : "[ ]";
	}
}

class Tictactoe{
	
	private final int P1 = 1;
	private final int P2 = 2;
	private final int SIZE = 3;
	
	private Scanner sc = new Scanner(System.in);
	
	private ArrayList<Vector<Box>> map;
	private Box box;
	
	private int turn, win, count;
	
	public Tictactoe() {
		setGame();
	}

	public void run() {
		while(isRun()) {
			printMenu();
			int y = inputNumber("y좌표");
			int x = inputNumber("x좌표");
			callBox(y,x);
			if(check(y, x)) {
				drawing(y, x);
				
				checkWin();
				
				flipTurn();
			}
			
		}
		printWinner();
	}
	
	private void setGame() {
		this.turn = P1;
		this.win = 0;
		this.count = 0;
		
		setMap();
	}
	
	private void setMap() {
		map = new ArrayList<Vector<Box>>();
		
		for(int i=0; i<SIZE; i++) {
			Vector<Box> row = new Vector<Box>();
			
			for(int j=0; j<SIZE; j++) {
				Box box = new Box();
				row.add(box);
				
			}
			map.add(row);
		}
	}
	
	public void printMenu() {
		System.out.println("P"+turn + "님의 차례");
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				callBox(i,j);
				System.out.print(box);
			}
			System.out.println();
		}
	}
	
	private boolean check(int y, int x) {
		if(y < 0 || y >= SIZE || x < 0 || x >= SIZE) {
			System.err.println("유효한값이 아닙니다.");
			return false;
		}
		
		if(map.get(y).get(x).getIsFlipped()) {
			System.err.println("이미 사용한 위치입니다.");
			return false;
		}
		
		return true;
	}

	private void drawing(int y, int x) {
		count++;
		box.setOner(turn);;
		
	}
	
	private void callBox(int y, int x) {
		box = map.get(y).get(x);
	}
	
	
	public void checkWin() {
		width();
		height();
		diagonal();
		reversediagonal();
	}
	
	private void width() {
		for(int i=0; i<SIZE; i++) {
			int cnt = 0;
			for(int j=0; j<SIZE; j++) {
				callBox(i,j);
				if(box.getPlayer() == turn)
					cnt++;
			}
			if(cnt == SIZE) {
				win = turn;
			}
			else
				cnt = 0;
		}
	}
	
	private void height() {
		for(int i=0; i<SIZE; i++) {
			int cnt = 0;
			for(int j=0; j<SIZE; j++) {
				callBox(j,i);
				if(box.getPlayer() == turn)
					cnt++;
			}
			if(cnt == SIZE) {
				win = turn;
			}
			else
				cnt = 0;
		}
	}
	
	private void diagonal() {
		int cnt = 0;
		for(int i=0; i<SIZE; i++) {
			callBox(i, i);
			if(box.getPlayer() == turn)
				cnt++;
		}
		
		if(cnt == SIZE)
			win = turn;
	}
	
	private void reversediagonal() {
		int cnt = 0;
		
		for(int i=0; i<SIZE; i++) {
			callBox(i, SIZE-1-i);
			if(box.getPlayer() == turn)
				cnt++;
		}
		
		if(cnt == SIZE) {
			win = turn;
		}
	}
	
	private void printWinner() {
		if(win == 0) {
			System.out.println("무승부");
		}else {
			System.out.printf("P%d 님의 승리 \n", win);
		}
	}
	
	
	
	public void flipTurn() {
		turn = turn == P1 ? P2 :P1;
	}

	private boolean isRun() {
		if(count >= SIZE*SIZE)
			return false;
		if(win != 0)
			return false;
		
		return true;
	}
	
	private int inputNumber(String message) {
		int number = -1;
		
		System.out.println(message + " : ");
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return number;
	}
}

public class Ex09 {

	public static void main(String[] args) {
		Tictactoe game = new Tictactoe();
		game.run();

	}

}
