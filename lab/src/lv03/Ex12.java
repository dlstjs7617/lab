package lv03;

import java.util.Arrays;
import java.util.Random;

public class Ex12 {
	/*
	 * # 중복숫자 금지[1단계]
	 * 1. 0~4 사이의 숫자를 arr배열에 저장한다.
	 * 2. 단, 단 중복되는 숫자는 없어야한다.
	 * 힌트) 랜덤 숫자를 check배열의 인덱스로 활용한다.
	 * 
	 * 예)
	 * 랜덤숫자 : 1
	 * check = 	{ 0, 1, 0, 0, 0}
	 * arr 	 = 	{ 1, 0, 0, 0, 0}
	 * 
	 * 랜덤숫자 : 3
	 * check = 	{ 0, 1, 0, 1, 0}
	 * arr 	 = 	{ 1, 3, 0, 0, 0}
	 * 
	 * 랜덤숫자 : 2
	 * check = 	{ 0, 1, 1, 1, 0}
	 * arr 	 = 	{ 1, 3, 2, 0, 0}
	 * 
	 */
	public static void main(String[] args) {
		
		Random random = new Random();
		
		int[] check = new int[5];
		int[] arr = new int[5];
		
		for(int i=0; i<5; i++) {
				int ran = random.nextInt(5);
				if(check[ran] == 0) {
					check[ran] = 1;
					arr[i] = ran;
				}else {
					i--;					
				}
		}
		System.out.println("check : " + Arrays.toString(check));
		System.out.println("arr : " + Arrays.toString(arr));
	}

}
