package lv03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex19_t {
	
	
	
	
	/*
	 * # 1 to 4
	 * 1. arr배열에 1~4 사이의 숫자를 중복없이 랜덤으로 저장한다.
	 * 2. 사용자는 1부터 순서대로 해당 위치 값을 입력한다.
	 * 3. 정답을 맞추면 해당 값은 9로 변경되어 모든 값이 9가 되면 게임은 종료된다.
	 * 예)
	 * 4 2 3 1
	 * 입력 : 3
	 * 4 2 3 9
	 * 입력 : 1
	 * 4 9 3 9
	 * ...
	 */
	
	
	public static void main(String[] args) {
		
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		int SIZE = 4;
		
		int[] arr = new int[SIZE];		// { 0, 0, 0, 0,}
		int[] check = new int[SIZE];	// { 0, 0, 0, 0,}
		
		// arr 배열 초기화
		for(int i=0; i<SIZE; i++) {		// i: arr배열의 인덱스
			int rNum = ran.nextInt(SIZE)+1;
			
			// 사용 확인
			if(check[rNum-1] == 0) {
				arr[i] = rNum;
				check[rNum -1] = 1;
			} else {
				i--;
			}	
		}
		
		int gameNum = 1;
		
		
		boolean isRun = true;
		while(isRun) {

			//출력
			System.out.println(Arrays.toString(arr));
			
			//종료 조건
			if(gameNum > SIZE) {
				isRun = false;	
				continue;
			}
			//입력
			System.out.println("인덱스 : ");
			int index = sc.nextInt();
			
			// 예외처리 1. 인덱스 범위
			if(index < 0 || index > SIZE-1) {
				System.out.println("인덱스 범위를 벗어났습니다");
				continue;
			}
			
			// 예외처리 2. 오답
			if(arr[index] != gameNum) {
				System.out.println("일치하지 않습니다");
				continue;
			}
			
			//정답 처리
			arr[index] = 9;
			gameNum++;
			
		}
		System.out.println("GAME CLEAR");
	}

}
