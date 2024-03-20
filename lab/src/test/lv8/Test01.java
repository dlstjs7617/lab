package test.lv8;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

//시작 11:10
//종료 12:06
//소요 00:54

class Card{
	
	private int back;
	private int front;

	public int getBack() {
		return back;
	}
	public void setBack(int back) {
		this.back = back;
	}

	public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}
	
	@Override
	public String toString() {
		return String.format("[%2d]", front == 0 ?  0 : front);
	}
}


class OneToFifty{

	private final int SIZE = 5;
	private final int TOTAL_SIZE = 50;
	
	private Scanner sc = new Scanner(System.in);
	private Random ran = new Random();
	
	private int[] numbers;
	private int gameCnt;
	
	private Vector<Vector<Card>> board;
	
	public OneToFifty() {
		board = new Vector<Vector<Card>>();
		gameCnt = 1;
	}
	
	private int inputNumber(String message) {
		int number = -1;
		
		System.out.print(message + " : ");
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return number;
	}
	
	private void setNumber() {
		numbers = new int[TOTAL_SIZE];
		for(int i=0; i<TOTAL_SIZE; i++) {
			numbers[i] = i+1; 
		}
		
	}
	
	private void shuffle() {
		for(int i=0; i<500; i++) {
			int rIdx = ran.nextInt(SIZE*SIZE);
			int temp = numbers[0];
			numbers[0] = numbers[rIdx];
			numbers[rIdx] = temp;
		}
		
		for(int i=0; i<500; i++) {
			int rIdx = ran.nextInt(SIZE*SIZE)+SIZE*SIZE;
			int temp = numbers[SIZE*SIZE];
			numbers[SIZE*SIZE] = numbers[rIdx];
			numbers[rIdx] = temp;
		}
	}
	
	private void setCard() {
		for(int i=0; i<SIZE; i++) {
			Vector<Card> list = new Vector<Card>();
			for(int j=0; j<SIZE; j++) {
				Card card = new Card();
				list.add(card);
			}
			board.add(list);
		}
		
	}
	
	private void setFrontAndBack() {
		int cnt = 0;
		for(int i=0; i<SIZE; i++) {
			Vector<Card> list = board.get(i);
			for(int j=0; j<SIZE; j++) {
				list.get(j).setFront(numbers[cnt++]);
			}
		}
		
		for(int i=0; i<SIZE; i++) {
			Vector<Card> list = board.get(i);
			for(int j=0; j<SIZE; j++) {
				list.get(j).setBack(numbers[cnt++]);
			}
		}
	}
	
	private void setGame() {
		setNumber();
//		shuffle();
		setCard();
		setFrontAndBack();
	}
	
	private boolean isRun() {
		if(gameCnt > TOTAL_SIZE)
			return false;
		return true;
	}
	
	private void printGame() {
		for(int i=0; i<SIZE; i++) {
			Vector<Card> list = board.get(i);
			for(int j=0; j<SIZE; j++) {
				System.out.print(list.get(j));
			}
			System.out.println();
		}
	}
	
	private boolean checkNum(int y, int x) {
		Vector<Card> list = board.get(y);
		int num = list.get(x).getFront();

		if(num == gameCnt)
			return true;
		
		return false;
	}
	
	private boolean excetionIndex(int y, int x) {
		if(y < 0 || y >= SIZE || x < 0 || x >= SIZE) {
			System.err.println("유효하지않은 좌표값");
			return false;
		}else if(!checkNum(y,x)) {
			System.err.println("틀렸습니다");
			return false;
		}
		return true;
	}
	
	private Card getCard(int y, int x) {
		return board.get(y).get(x);
	}
	
	private void answer(int y, int x) {
		Card card =  getCard(y, x);
		
		card.setFront(card.getBack());
		card.setBack(0);
		
		gameCnt++;
		
		System.out.println("정답입니다");
	}
	
	private void runGame() {
		while(isRun()) {
			printGame();
			int y = inputNumber("y좌표");
			int x = inputNumber("x좌표");
			
			if(!excetionIndex(y,x))
				continue;
			answer(y, x);
		}
		printGame();
		System.out.println("GAME CLEAR!!!");
	}
	
	public void run() {
		setGame();
		runGame();
	}
}

public class Test01 {

	public static void main(String[] args) {
		// 1.
				// 1 to 50
				// class : Card, OneToFifty
				// collection : Vector만 사용
				// ㄴ Vector<Vector<Card>> board
				
				OneToFifty game = new OneToFifty();
				game.run();
	}

}
