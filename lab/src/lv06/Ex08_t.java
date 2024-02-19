package lv06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * # 1 to 50[3단계] : 1 to 18
 * 1. 구글에서 1 to 50 이라고 검색한다.
 * 2. 1 to 50 순발력 게임을 선택해 게임을 실습해본다.
 * 3. 위 게임의 숫자 범위를 좁혀 1 to 18로 직접 구현한다.
 * 4. 숫자 1~9는 front 배열에 저장하고,
 *    숫자 10~18은 back 배열에 저장한다.
 */
class OneToEighteen_t{
	
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);
	
	final int SIZE = 9;
	int gameNum;
	int[] front = new int[SIZE];
	int[] back = new int[SIZE];
	
	// 기능의 단위로 메소드를 정의
	// ㄴ 코드 조각을 재사용할 수 있는 장점
	
	void shuffle(int[] array) {
		Random ran = new Random();
		
		for(int i=0; i<array.length *10; i++) {
			int rIdx = ran.nextInt(array.length);
			
			int temp = array[0];
			array[0] = array[rIdx];
			array[rIdx] = temp;
		}
	}
	
	void setMapArray(int[] array, int start) {
		for(int i=0; i<array.length; i++) {
			array[i] = start + i;
		}
		
		shuffle(array);
	}
	
	
	void setMap() {
		gameNum = 1;
		setMapArray(front, 1);		// front 초기화
		setMapArray(back, SIZE+1);		// back 초기화
	}
	
	void printMap() {
		for(int i=0; i<SIZE; i++) {
			System.out.printf("%2d " , front[i]);
			
			if(i%3 == 2) {
				System.out.println();
			}
		}
	}
	
	boolean isRun() {
		return gameNum > SIZE*2 ? false : true;
	}
	
	int inputIndex() {
		System.out.print("index : ");
		int index = -1;
		
		try {
			String input = sc.next();
			index = Integer.parseInt(input);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return index;
	}
	
	void flipCard(int index) {
		if(index < 0 || index >= SIZE)
			return; // 메소드 소멸
		
		if(front[index] == gameNum) {
			front[index] = back[index];
			back[index] = 0;
			gameNum++;
		}
	}
	
	void printResult() {
		System.out.println("GAME CLEAR!");
	}
	
	void run() {
		// set map
		setMap();
		while(isRun()) {
			// print map
			   printMap();
			   int idx = inputIndex();
			   flipCard(idx);
		}
		printResult();
	}
}



public class Ex08_t {

	public static void main(String[] args) {
		
		OneToEighteen_t game = new OneToEighteen_t();
		game.run();
	}

}
