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

class MemoryGame{
	Scanner sc = new Scanner(System.in);
	
	final int SIZE = 10;
	
	int[] front;		// {1,1,2,2,3,3,4,4,5,5}
	int[] back;			// {0,0,0,0,0,0,0,0,0,0}
	
	int cnt;			//정답을 맞춘 횟수
	
	void arrSet() {
		front = new int[SIZE];
		back = new int[SIZE];
		int cnt = 1;
		for(int i=0; i<SIZE; i+=2) {
			front[i] = cnt;
			front[i+1] = cnt++;
		}
	}
	
	void shuffle(int[] arr) {
		Random ran = new Random();
		
		for(int i=0; i<100; i++) {
			int rIdx = ran.nextInt(SIZE);
			int temp = 0;
			temp = arr[0];
			arr[0] = arr[rIdx];
			arr[rIdx] = temp;
		}
	}
	
	void printArray() {
		System.out.println("=========== 인덱스 ============");
		for(int i=0; i<SIZE; i++) {
			if(i == 0 ) {
				System.out.print(" ");
			}
			System.out.print(i + "  ");
		}
		System.out.println("\n=============================");
		System.out.println();
		System.out.println(Arrays.toString(front));
		System.out.println(Arrays.toString(back));
	}
	
	boolean clear() {
		boolean clear = true;
		for(int i=0; i<SIZE; i++) {
			if(back[i] == 0) {
				clear = false;
			}
		}
		
		return clear;
	}
	
	int inputIdx() {
		int idx = 0;
		System.out.print("인덱스 입력 : ");
		try {
			String temp = sc.next();
			idx = Integer.parseInt(temp);
		} catch (Exception e) {
			System.out.println("숫자를 입력해주세요");
		}
		
		return idx;
	}
	
	
	
	void answer(int one , int two) {
		if(!inputExcetion(one, two))
			return;
		
		if(front[one] == front[two]) {
			back[one] = front[one];
			back[two] = front[two];
		}else {
			System.err.println("틀렸습니다.");
			System.out.printf("첫번째 뒤집은 카드 숮자 : %d   \n",front[one]);
			System.out.printf("두번째 뒤집은 카드 숫자 : %d   \n",front[two]);
		}
	}
	
	boolean inputExcetion(int one ,int two) {
		boolean result = true;
		
		if(one < 0 || two < 0 || one >= SIZE || two >= SIZE) {
			System.err.println("유효하지 않는 값입니다.");
			result = false;
		} 
		if(back[one] != 0 || back[two] != 0) {
			System.err.println("이미 뒤집은 카드입니다.");
			result = false;
		}
		
		if(one == two) {
			System.err.println("동일한 카드입니다.");
			result = false;
		}
		
		return result;
	}
	
	
	void run() {
		arrSet();
		shuffle(front);
		
		while(!clear()) {
			printArray();
			
			int firstopen = inputIdx();
			int secondopen = inputIdx();
			answer(firstopen, secondopen);
			
		}
		
		if(clear()) {
			printArray();
			System.out.println("게임 클리어");
		}
	}
	
}


public class Ex12 {

	public static void main(String[] args) {
		MemoryGame memoryGame = new MemoryGame();
		memoryGame.run();

	}

}
