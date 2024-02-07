package lv03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex19 {
	
	
	
	
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
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		int SIZE = 4;
		
		int[] arr = new int[SIZE];
		int[] check = new int[SIZE];
		
		//랜덤값 저장
		for(int i=0; i<SIZE; i++) {
			int ranNum = random.nextInt(4);
			if(check[ranNum] == 0) {
				arr[i] = ranNum+1;
				check[ranNum] = 1;
			}else {
				i--;				
			}
		}
		
		System.out.println(Arrays.toString(arr));
		boolean isRun = true;
		
		int arrCnt = 1; //맞춰야하는 숫자
		int winCnt = 0; //승리카운트
		
		// 게임시작
		while(isRun) {
			System.out.print("값 입력:");
			int answer = sc.nextInt();
			
			//정답처리 및 예외
			if(answer < 0 || answer >= 4) {
				System.err.println("값이 올바르지 않습니다.");
			}else if(arr[answer] == arrCnt) {
				arrCnt++;
				arr[answer] = 9; 
				System.err.println("정답");
			}else if(arr[answer] != arrCnt) {
				System.err.println("틀렸습니다.");
			}
			//승리 조건반복문
			for(int i=0; i<SIZE; i++) {
				if(arr[i] == 9) {
					winCnt++;
					if(winCnt == SIZE) {
						System.out.println("게임 종료");
						isRun = false;
					}					
				}else{
					winCnt = 0;
				}
			}
			System.out.println(" ");
			
			System.out.println(Arrays.toString(arr));
		}
	}

}
