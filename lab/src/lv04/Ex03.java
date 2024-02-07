package lv04;

import java.util.Arrays;
import java.util.Random;

public class Ex03 {

	/*
	 * # 중복숫자 금지[2단계]
	 * 1. arr배열에 1~10 사이의 랜덤 숫자 5개를 저장한다.
	 * 2. 단 중복되는 숫자가 없어야 한다.
	 * 체크배열 사용금지
	 */
	public static void main(String[] args) {
		
		Random random = new Random();
		
		final int SIZE = 5;
		int[] arr = new int[5];
		int temp = 0;
		
		for(int i=0; i<SIZE; i++) {
			int ran = random.nextInt(10)+1;
			arr[i]= ran;
			for(int j=0; j<i; j++) {
				if(arr[i] == arr[j]) {
					i = j;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		

	}

}
