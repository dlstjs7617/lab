package lv06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * # 기억력 게임 : 클래스 + 메서드
 * 1. front 배열 카드 10장을 섞는다
 * 2. front 배열에서 같은 카드를 골라 카드의 위치를 입력한다.
 * 3. 선택한 2장의 카드가 같은 카드이면, back 배열에 표시한다.
 * 4. 모든 카드가 뒤집히면(back배열의 0이 사라지면) 게임은 종료된다.
 * 
 */

class MemoryGame_t{
	Scanner sc = new Scanner(System.in);
	
	final int SIZE = 10;
	final int FLIPED = 1;
	int[] front;
	int[] back;
	
	int cnt;			//정답을 맞춘 횟수
	void setGame() {
		cnt = 0;
		front = new int[SIZE];
		back = new int[SIZE];
		
		for(int i=0; i<SIZE; i++) {
			front[i] = (i+2)/2;
		}
		
		shuffle(front);
	}
	void shuffle(int[] front) {
		Random ran = new Random();
		for(int i=0; i<SIZE*10; i++) {
			int rIdx = ran.nextInt(SIZE);
			
			int temp = front[0];
			front[0] = front[rIdx];
			front[rIdx] = temp;
			
		}
	}
	
	boolean isRun() {
		return cnt == SIZE/2 ? false : true;
	}
	
	void printQuiz() {
		System.out.print("[");
		for(int i=0; i<SIZE; i++) {
			System.out.print(i+1);
			if(i< SIZE-1)
				System.out.print(", ");
		}
		System.out.print("]\n");
		System.out.println(Arrays.toString(front));
		System.out.println(Arrays.toString(back));
	}
	
	int inputIndex(int[] array) {
		int index = -1;
		
		while(true) {
			try {
				System.out.print("index : ");
				String input = sc.next();
				index = Integer.parseInt(input)-1;
			} catch (Exception e) {
				System.err.println("숫자를 입력해주세요");
			}
			
			if(index >= 0 && index < array.length)
				break;
			
		}
		
		return index;
	}
	
	boolean filpCards(int firstIndex, int secondIndex) {
		if(firstIndex == secondIndex)
			return false;
		if(front[firstIndex] != front[secondIndex])
			return false;
		if(back[firstIndex] == FLIPED)
			return false;
		
		back[firstIndex] = FLIPED;
		back[secondIndex] = FLIPED;
		
		cnt++;
		
		return true;
	}
	
	void printResult(boolean success) {
		if(success)
			System.out.println("카드가 뒤집혔습니다.");
		else
			System.out.println("카드 뒤집기 실패-");
	}
	
	void run() {
		setGame();
		while(isRun()) {
			printQuiz();
			int index1 = inputIndex(front); 
			int index2 = inputIndex(front);
			filpCards(index1,index2);
			
		}
	}
	
}


public class Ex12_t {

	public static void main(String[] args) {
		MemoryGame_t memoryGame = new MemoryGame_t();
		memoryGame.run();

	}

}
