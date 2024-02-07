package lv04;

import java.util.Arrays;

public class Ex07 {
	/*
	 * # 정렬하기
	 * 1. 인덱스 0번이 나머지를 검사한다.
	 * 2. 제일 큰 값을 찾아 교환한다.
	 * 3. 인덱스를 1 증가한다.
	 * 4. [1~3]을 끝까지 반복한다	 
	 * 예)
	 * 10, 50, 30, 40, 80, 7
	 * 80, 50, 30, 40, 10, 7
	 * 80, 50, 30, 40, 10, 7
	 * 80, 50, 40, 30, 10, 7
	 * */
	 
	public static void main(String[] args) {
		
		int[] score = {10, 50, 30, 40, 80, 7};
		
		// Bubble sort 초기 세팅된 값에 상태에 따라 모든값을 교체하고 있는 경우가 발생할수있음
//		for(int i=0; i<6; i++) {
//			for(int j=0; j<6; j++) {
//				if(score[i] < score[j]) {
//					int temp = score[i];
//					score[i] = score[j];
//					score[j] = temp;
//				}
//			}
//		}
		System.out.println("정렬하기");
		
		// Selection sort  더 낮은 값변환횟수로 이게 더좋음
		for(int i=0; i<6-1; i++) {
			int idx = i;
			for(int j=i+1; j<6; j++) {
				if(score[idx] < score[j]) {
					idx = j;
				}
			}
			//값 교체
			int temp = score[i];
			score[i] = score[idx];
			score[idx] = temp;
			System.out.println(Arrays.toString(score));
		}
		System.out.println(Arrays.toString(score));

	}

}
