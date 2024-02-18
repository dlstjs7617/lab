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
	
	int[] front = new int[SIZE];
	int[] back = new int[SIZE];
	
	// 기능의 단위로 메소드를 정의
	// ㄴ 코드 조각을 재사용할 수 있는 장점
	
	void shuffle(int[] array) {
		
	}
	
	// array : 초기화 할 대상 배열
	// start : 초기화 할 시작 값
	// end :  초기화 할 마지막 값
	void setMapArray(int[] array, int start, int end) {
		
	}
//	
//	
//	void setMap() {
//		setMapArray(front, start, end);		// front 초기화
//		setMapArray(back, start, end);		// back 초기화
//	}
//	
//	
//	void run() {
//		// set map
//		setMap();
//		while(getIsRun()) {
//			// print map
//			   printMap();
//			   int idx = inputIndex();
//			   flipCard(idx);
//		}
//		printResult();
//	}
}



public class Ex08_t {

	public static void main(String[] args) {
		
		OneToEighteen_t game = new OneToEighteen_t();
//		game.run();
	}

}
