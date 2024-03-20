package test.lv8;
//시작 12:17
//종료 14:14
//소요 02:03

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class MyArrayList<T>{
	
	private int size;
	private Object[] list;
	
	public int size() {
		return this.size;
	}
	
	public boolean add(T type) {
		Object[] temp = list;
		list = new Object[size+1];
		
		for(int i=0; i<size; i++) {
			list[i] = temp[i];
		}
		
		list[size++] = type;
		
		return true;
	}
//	
//	public T remove(int index) {
//		T type = (T) list[index];
//		
//		Object[] temp = list;
//		list = new Object[size-1];
//		
//		int cnt = 0;
//		for(int i=0; i<size; i++) {
//			if(i != index)
//				list[cnt++] = temp[i];
//		}
//		
//		size--;
//		
//		return type;
//	}
	
	public T get(int index) {
		return (T)list[index];
	}
	
}

class Box{
	private int number;
	private boolean flip;
	
	public Box(int number) {
		this.number = number;
		this.flip = false;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public boolean getFlip() {
		return flip;
	}
	public void setFlip(boolean flip) {
		this.flip = flip;
	}
	
	@Override
	public String toString() {
		return String.format("[%s]", flip == false ?  " " : Integer.toString(number));
	}
}

class MemoryGame{
	
	private final int SIZE = 10;
	
	private Scanner sc = new Scanner(System.in);
	private Random ran = new Random();
	private MyArrayList<Box> board;
	
	private int[] numbers;
	
	public MemoryGame(){
		board = new MyArrayList<Box>();
		numbers = new int[SIZE];
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
		for(int i=0; i<SIZE; i++) {
			numbers[i] = i/2+1;
		}
	}
	
	private void shuffle() {
		for(int i=0; i<100; i++) {
			int rIdx = ran.nextInt(SIZE);
			int temp = numbers[0];
			
			numbers[0] = numbers[rIdx];
			numbers[rIdx] = temp;
		}
	}
	
	private void setBoard() {
		for(int i=0; i<SIZE; i++) {
			Box box = new Box(numbers[i]);
			board.add(box);
		}
	}
	
	private void setGame() {
		setNumber();
		shuffle();
//		System.out.println(Arrays.toString(numbers));
		setBoard();
	}
	
	private boolean isRun() {
		for(int i=0; i<SIZE; i++)
			if(!board.get(i).getFlip())
				return true;
		
		return false;
	}
	
	private void printGame() {
		System.out.println("인덱스");
		for(int i=0; i<SIZE; i++) {
			System.out.printf("[%d]",i);
		}
		System.out.println();
		for(int i=0; i<SIZE; i++) {
			System.out.print(board.get(i));
		}
		System.out.println();
	}
	
	private boolean checkIndex(int index) {
		if(index < 0 || index >= SIZE) {
			System.err.println("유효한 인덱스가 아닙니다.");
			return false;
		}else if(board.get(index).getFlip()) {
			System.err.println("이미 뒤집은 카드입니다");
			return false;
		}
		
		return true;
	}
	
	private void printCard(int index) {
		System.out.println("뒤집은카드 : " + board.get(index).getNumber());
	}
	
	private void flipCard(int one, int two) {
		if(board.get(one).getNumber() == board.get(two).getNumber()) {
			board.get(one).setFlip(true);
			board.get(two).setFlip(true);
			
			System.out.println("정답입니다");
		}else {
			System.err.println("오답입니다.");
		}
	}
	
	private void select() {
		int one = inputNumber("첫번째 카드");
		
		if(!checkIndex(one))
			return;
		printCard(one);
		
		int two = inputNumber("두번째 카드");
		
		if(!checkIndex(two))
			return;
		printCard(two);
		
		flipCard(one,two);
	}
	
	private void runGame() {
		while(isRun()) {
			printGame();
			select();
		}
		System.out.println("GAME CLEAR!!");
	}
	
	public void run(){
		setGame();
		runGame();
	}
}

public class Test02 {

	public static void main(String[] args) {
		// 2.
		// 기억력 게임
		// class :
		// ㄴ MyArrayList<T>
		//	ㄴ ArrayList 일부 메소드 직접 구현
		// 	ㄴ add, remove, get, size 등
		// ㄴ Box
		// ㄴ MemoryGame
		// 	ㄴ MyArrayList<Box> board
		
		MemoryGame game = new MemoryGame();
		game.run();

	}

}