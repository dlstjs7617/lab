package parctice;

import java.util.Random;
import java.util.Scanner;

// 1 to 18
	// 9x9


class OneToEighteen_Parctice{
	
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	final int SIZE = 9;
	int gameCnt = 1;
	
	int[] front = new int[SIZE];
	int[] back = new int[SIZE];
	
	// 섞기
	void shuffle(int[] arr) {
		int rNum;
		int tempNum;
		
		for(int i=0; i<100; i++) {
			rNum = ran.nextInt(arr.length-1);
			tempNum = arr[0];
			arr[0] = arr[rNum];
			arr[rNum] = tempNum;
		}
	}
	
	// 배열 숫자 할당
	void allot(int[] array, int start, int end) {
		int cnt = 0;
		for(int i=start; i<=end; i++) {
			array[cnt++] = i;
		}
	}
	
	//출력
	void output(int[] arr) {
		
		for(int i=0; i<SIZE; i++) {
			if(arr[i] != 0) {
				System.out.printf("[%2d] ", arr[i]);
			}else if(arr[i] == 0) {
				System.out.print("[  ] ");
			}
			if((i+1) % 3 == 0) {
				System.out.println();
			}
		}
	}
	//입력
	int input() {
		System.out.print("인덱스 :");
		return sc.nextInt()-1;
		 
	}
	
	
	// 입력 예외처리
	boolean inputExcetion(int index){
		return index < 0 || index >= SIZE; 
	}
	
	
	//정답 확인
	void answer(int index) {
		if(front[index] == gameCnt) {
			System.out.println("정답입니다.");
			answerProcess(index);
		}else {
			System.err.println("오답입니다.");
		}
	}
	//정답처리
	void answerProcess(int index) {
		front[index] = back[index];
		back[index] = 0;
		gameCnt++;
	}
	//종료 조건
	boolean clear() {
		if(gameCnt == 19) {
			System.out.println();
			System.out.println("GAME CLEAR");
			return true;
		}
		else {
			return false;
		}
	}
	
	// 돌리기
	void run() {
		allot(front, 1, 9);
		allot(back, 10, 18);
		
		shuffle(front);
		shuffle(back);
		
		while(!clear()) {			
			output(front);
			
			int index = input();
			if(inputExcetion(index)) {
				System.err.println("유효하지않은 범위");
				continue;
			}
			
			
			answer(index);
			
		}
	}
}


public class Lv6_01 {
	
	
	public static void main(String[] args) {
		OneToEighteen_Parctice game = new OneToEighteen_Parctice();
		game.run();
	}

}
