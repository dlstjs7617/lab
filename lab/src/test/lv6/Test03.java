package test.lv6;
//Lv6 Test (클래스 + 메소드)

import java.util.Scanner;

// 시작 11:25
// 종료 12:10
// 소요 00:35
		
// 3.
/*
 * 틱 택 토
 */

class Tictactoe {
	
	Scanner sc = new Scanner(System.in);
	
	final int SIZE = 9;
	final int P1 = 1;
	final int P2 = 2;
	
	int win;
	int turn;
	
	int[] map;
	
	void setGame() {
		turn = P1;
		map = new int[SIZE];
	}
	
	boolean isRun() {
		if(win != 0)
			return false;
		return true;
	}
	
	void printGame(){
		for(int i=0; i<SIZE; i++) {
			if(map[i] == P1)
				System.out.print("[O]");
			else if(map[i] == P2)
				System.out.print("[X]");
			else
				System.out.print("[ ]");
			if(i % 3 == 2)
				System.out.println();
		}
		System.out.println();
	}
	
	int inputNumber() {
		int idx = -1;
		
		try {
			System.out.print("입력 :");
			String input = sc.next();
			idx = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return idx;
	}
	
	boolean idxExcetion(int index) {
		boolean idx = false;
		
		if(index < 0 || index >= SIZE) {
			System.out.println("유효하지 않는 인덱스");
			idx = true;
		}
		
		return idx;
	}
	
	boolean DrawingExcetion(int index) {
		if(map[index] != 0) {
			System.out.println("이미 사용한 자리입니다");
			return true;
		}
		return false;
	}
	
	void DrawingMap(int index) {
		map[index] = turn;
	}
	
	boolean winLogic() {
		boolean run = false;
		height();
		wdith();
		diagonal();
		reverseDiagonal();
		
		if(win != 0)
			run = true;
		
		return run;
	}
	
	void height() {
		for(int i=0; i<3; i++) {
			int cnt = 0;
			for(int j=i; j<SIZE; j+=3) {
				if(map[j] == turn) {
					cnt++;
				}
				if(cnt == 3)
					win = turn;				
			}
		}
	}
	
	void wdith() {
		for(int i=0; i<SIZE; i+=3) {
			int cnt = 0;
			for(int j=i; j<3; j++) {
				if(map[j] == turn)
					cnt++;
				if(cnt == 3)
					win = turn;
			}
		}
	}
	void diagonal()	{
		int cnt = 0;
		for(int i=0; i<SIZE; i+=4) {
			if(map[i] == turn)
				cnt++;
		}
		
		if(cnt == 3)
			win = turn;
	}
	void reverseDiagonal() {
		int cnt = 0;
		for(int i=2; i<SIZE; i+=2) {
			if(map[i] == turn)
				cnt++;
		}
		
		if(cnt == 3)
			win = turn;
	}
	
	void filpTurn() {
		turn = turn == P1 ? P2 : P1;
	}
	boolean drawGame() {
		boolean draw = true;
		for(int i=0; i<SIZE; i++) {
			if(map[i] == 0)
				draw = false;
		}
		
		return draw;
	}
	
	void winPrint() {
		printGame();
		if(win != 0) {
			System.out.printf("승자 : P%d", win = win == P1 ? P1 : P2);
		}else {
			System.out.println("비김");
		}
	}
	
	void run() {
		
		setGame();
		while(isRun()) {
			printGame();
			
			System.out.print("P"+turn);
			int index = inputNumber();
			
			if(idxExcetion(index))
				continue;
			if(DrawingExcetion(index))
				continue;
			
			DrawingMap(index);
			
			if(drawGame())
				break;
			if(winLogic())
				break;
			filpTurn();
			System.out.println(win);
		}
		winPrint();
		
	}
}
public class Test03 {

	public static void main(String[] args) {
		
		Tictactoe game = new Tictactoe();
		game.run();

	}

}
