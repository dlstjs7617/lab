package lv03;

import java.util.Arrays;

public class Ex14 {
	
	/*
	 * # 4의 배수만 저장
	 * - arr 배열에서 4의 배수만 골라 temp 배열에 저장
	 * - 단! temp 의 길이를 4의 배수개수만큼만 설정한다.
	 */
	
	
	public static void main(String[] args) {
		
		int[] arr = {44, 11, 29, 24, 76};
		int[] temp = null; //값이 들어있지 않은 상태
		int count = 0;
		for(int i=0; i<5; i++) {
			if(arr[i] % 4 == 0) {
				count++;
			}
		}
		temp= new int[count];
		count = 0;
		for(int i=0; i<5; i++) {
			if(arr[i] % 4 == 0) {
				temp[count] = arr[i];
				count++;
			}
		}		
		if(count == 0)
			System.out.println("4의 배수 없음");
		else
			System.out.println(Arrays.toString(temp));
	}

}
