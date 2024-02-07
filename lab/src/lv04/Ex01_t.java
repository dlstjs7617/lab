package lv04;

import java.util.Arrays;
import java.util.Scanner;

public class Ex01_t {
	// 레벨4. 다차원 배열
	
	/*
	 * # 최대값 구하기
	 * 1. 가장 큰 값을 찾아 입력한다.
	 * 2. 정답이면 해당 값을 0으로 변경한다.
	 * 3. arr배열의 모든 값이 0으로 변경되면 프로그램은 종료된다.
	 * 예)
	 * 11, 87, 42, 100, 24
	 * 입력 : 100
	 * 
	 * 11, 87, 42, 0, 24
	 * 입력 : 87
	 * 
	 * 11, 0, 42, 100, 24
	 */
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		boolean isRun = true;
		final int MAX = 5;
		
		int[] arr= {11, 87, 42, 100, 24};
		while(isRun) {
			
			int idx = -1;
			int max = 0;
			
			System.out.println(Arrays.toString(arr));
			if(idx == -1) {
				break;
			}
			System.out.print("입력 : ");
			int input = sc.nextInt();
			for(int i=0; i<MAX; i++) {
				if(arr[i] > max) {
					max = arr[i];
					idx = i;
				}
			}
			//찾은 max 값과 <-> 입력한 input 비교
			if(input == max) {
				arr[idx] = 0 ;
			}
			
			
			System.out.println();
		}
	}
}
