package test.lv6;
//Lv6 Test (클래스 + 메소드)

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 시작 14:28
// 종료 15:34
// 소요 00:06



public class Test05 {

	public int[] solution(int[] arr) {
		
		int[] temp = arr.clone();
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = temp[arr.length-1-i];
		}
		
		return arr;
	}
	
	
	public static void main(String[] args) {
		
		Test05 sol = new Test05();
		
		int[] arr = { 1, 4, 2, 3};
		int[] ret = sol.solution(arr);
		
		System.out.println("답 : " + Arrays.toString(ret) + ".");
	}

}
