package lv08;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

// 1 to 50

class Card{
	
	private int front;
	private int back;
	
	public int getFront() {
		return front;
	}
	public void setFront(int front) {
		this.front = front;
	}
	public int getBack() {
		return back;
	}
	public void setBack(int back) {
		this.back = back;
	}
	
	
	@Override
	public String toString() {
		return String.format("[%2d]", this.front);
	}
}

class Manager1to50{
	private final int SIZE = 5;
	private final int END_SIZE = 50;
	
	private Scanner sc = new Scanner(System.in);
	private Vector<ArrayList<Card>> map;
	
	private int[] data;
	private int count;
	
	public Manager1to50(){
		this.count = 1;
		setGame();
	}
	
	private void setGame() {
		setData();
		shuffleData();
		setMap();
	}
	
	private void setData() {
		data = new int[END_SIZE];
		for(int i=0; i<END_SIZE; i++) {
			data[i] = i+1;
		}
	}
	
	private void shuffleData() {
		Random ran = new Random();
		for(int i=0; i<1000; i++) {
			int rIdx = ran.nextInt(SIZE*SIZE);
			int temp =data[0];
			
			data[0] = data[rIdx];
			data[rIdx] = temp;
		}

		for(int i=0; i<1000; i++) {
			int rIdx = ran.nextInt(SIZE*SIZE)+SIZE*SIZE;
			int temp =data[SIZE*SIZE];
			
			data[SIZE*SIZE] = data[rIdx];
			data[rIdx] = temp;
		}	
	}
	
	private void setMap() {

		map = new Vector<ArrayList<Card>>();
		for(int i=0; i<SIZE; i++) {
			ArrayList<Card> list = new ArrayList<Card>();
			
			for(int j=0; j<SIZE; j++) {
				Card card = new Card();
				list.add(card);
			}
			
			map.add(list);
		}
		
		int cnt = 0;
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				Card card = card(i,j);
				card.setFront(data[cnt++]);
			}
		}
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				Card card = card(i,j);
				card.setBack(data[cnt++]);
			}
		}
		
	}
	
	private void printGame() {
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				Card card = card(i, j);
				System.out.print(card);
			}
			System.out.println();
		}
	}
	
	private boolean check(int index) {
		
		if(index < 0 || index >= SIZE)
			return false;
		
		return true;
	}
	
	private void flipCard(int y, int x) {
		Card card = card(y, x);
		
		if(card.getFront() == count) {
			card.setFront(card.getBack());
			card.setBack(0);
			this.count++;
		}else {
			System.err.println("틀렸습니다.");
		}
		
	}

	private void game() {
		while(isRun()) {
			printGame();
			int y = inputNumber("y좌표값");
			int x = inputNumber("x좌표값");
			
			if(!check(y) || !check(x)) {
				System.err.println("유효하지않은 좌표");
				continue;
			}
			
			flipCard(y,x);
		}
		System.out.println("GAME CLEAR!!!");
		
		
	}
	
	public void run() {
		game();
	}
	
	private boolean isRun() {
		if(count > END_SIZE)
			return false;
		
		return true;
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
	
	private Card card(int i, int j) {
		Card code = map.get(i).get(j);
		
		return code;
	}
	
}


public class Ex12 {

	public static void main(String[] args) {
		Manager1to50 game = new Manager1to50();
		game.run();
	}

}
