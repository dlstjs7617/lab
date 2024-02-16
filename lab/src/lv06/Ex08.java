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
class OneToEighteen{
	
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);
	
	final int SIZE = 9;
	int cnt = 1;
	boolean end = false;
	int[] front = new int[SIZE];
	int[] back = new int[SIZE];
	int[] length = new int[SIZE+SIZE];
	
	//게임세팅
	void setNum() {
		
		for(int i=0; i<SIZE; i++) {
			int rIdx = ran.nextInt(9);
			if(length[rIdx] == 0) {
				front[i] = rIdx+1;
				length[rIdx]++;
			}else {
				i--;
			}
		}
		
		for(int i=0; i<SIZE; i++) {
			int rIdx = ran.nextInt(9)+9;
			if(length[rIdx] == 0) {
				back[i] = rIdx+1;
				length[rIdx]++;
			}else {
				i--;
			}
		}
	}
	
	//게임출력
	void output() {
		for(int i=0; i<SIZE; i++) {
			if(front[i] != 0) {
				System.out.printf("[%2d] ",front[i]);
			}else if(back[i] != 0) {
				System.out.printf("[%2d] ",back[i]);				
			}else if(back[i] == 0) {
				System.out.print("[  ] ");
			}
			if(i != 0 && i%3 == 2)
				System.out.println();
		}
	}
	
	//게임 종료
	void end() {
		if(cnt == SIZE+SIZE+1) {
			System.out.println("GAME CLEAR!");
			end = true;
		}
	}
	
	//인덱스 받기
	int inputIdx() {
		System.out.print("인덱스 : ");
		int idx = sc.nextInt();
		
		return idx;
	}
	
	// 정답 처리
	void equals(int idx) {
		if (front[idx] == cnt || back[idx] == cnt) {
			for (int i = 0; i < SIZE; i++) {
				if (front[i] == cnt)
					front[i] = 0;
				else if (back[i] == cnt)
					back[i] = 0;
			}
			cnt++;
		}
	}
	void run() {
		setNum();
		while(true) {		
			output();
			end();
			
			if(end)
				break;
			
			int idx = inputIdx();
			if(idx < 0 || idx >= SIZE) {
				continue;
			}
			
			equals(idx);
		}
	}
}



public class Ex08 {

	public static void main(String[] args) {
		
		OneToEighteen game = new OneToEighteen();
		game.run();
	}

}
