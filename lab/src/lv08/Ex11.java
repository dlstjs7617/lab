package lv08;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

// 기억력 게임 (카드 뒤집기)

class Node{
	private int front;
	private int back;
	
	public Node(int back) {
		this.back = back;
	}
	
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
		return String.format("[%d]", this.back != 0 ? front :  back) ;
	}
}

class MemoryGame{
	private final int SIZE = 10;
	
	private Scanner sc = new Scanner(System.in); 
	
	private Vector<Node> nodeList;
	private int data[]; // {1,1,2,2,3,3,4,4,5,5} -> shuffle
	
	public MemoryGame() {
		nodeList = new Vector<Node>();
		setGame();
	}
	
	private void setDataArr() {
		data = new int[SIZE];
		for(int i=0; i<SIZE; i++) {
			data[i] = i/2+1;
		}
	}
	
	private void shuffle() {
		Random ran = new Random();
		for(int i=0; i<100; i++) {
			int rNum = ran.nextInt(SIZE);
			int num = data[0];
			
			data[0] = data[rNum];
			data[rNum] = num;
		}
	}	
	
	private void setNode() {
		for(int i=0; i<SIZE; i++) {
			Node node = new Node(data[i]);
			nodeList.add(node);	
		}
	}
	
	private void setGame() {
		setDataArr();
		shuffle();
		setNode();
	}
	
	private void printGame() {
		System.out.println("\t   ↓인덱스↓");
		for(int i=0; i<SIZE; i++) {
			System.out.printf("[%d]",i);
		}
		System.out.println();
		for(int i=0; i<SIZE; i++) {
			Node node = node(i);
			System.out.print(node);
		}
		System.out.println();
		try {
			Thread.sleep(500);
		} catch (Exception e) {
		}
	}
	
	private Node node(int index) {
		return nodeList.get(index);
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
	
	private boolean check(int index) {
		if(index < 0 || index >= SIZE) {
			System.err.println("유효하지않는 위치");
			return false;
		}
		
		if(nodeList.get(index).getFront() != 0) {
			System.err.println("이미 뒤집은 카드입니다");
			return false;
		}
		
		return true;
	}
	
	private void flipCard(int index) {
		Node node =node(index);
		node.setFront(node.getBack());
		
	}
	
	private void equlsCard(int first, int second) {
		Node one = node(first);
		Node two= node(second);
		if(one.getFront() == two.getFront()) {
			System.out.println("정답입니다.");
		}else {
			one.setFront(0);
			two.setFront(0);			
			System.err.println("틀렸습니다.");
		}
	}
	
	private boolean isRun() {
		for(int i=0; i<SIZE; i++) {
			Node node = nodeList.get(i);
			if(node.getFront() == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	private void game() {
		while(isRun()) {
			printGame();
			int first = inputNumber("첫번째카드 선택");
			check(first);
			
			flipCard(first);
			
			printGame();
			int second = inputNumber("두번째카드 선택");
			check(second);
			
			flipCard(second);
			printGame();
			equlsCard(first, second);
		}
		printGame();
		System.out.println("GAME CLEAR!!");
	}
	
	public void run() {
		game();
	}
	
}

public class Ex11 {

	public static void main(String[] args) {
		MemoryGame game = new MemoryGame();
		game.run();
	}

}
