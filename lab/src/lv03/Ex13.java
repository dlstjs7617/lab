package lv03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex13 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = { 10, 20, 30, 40, 50 };
		
		// 문제 1) 인덱스 2개를 입력받아 값 교체
		// 예 1) 인덱스1 입력 : 1 , 인덱스2 입력 : 3
		// { 10, 40, 30, 20, 50 }
		System.out.println("=======문제1=======");
		
		System.out.print("인덱스1 입력 : ");
		int idx1 = sc.nextInt();
		System.out.print("인덱스2 입력 : ");
		int idx2 = sc.nextInt();
		int temp = -1;
		if(idx1 >= 0 && idx1 < 5 && idx1 >= 0 && idx2 <5) {
			temp = arr[idx1]; 
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;			
		}else {
			System.err.println("입력오류");
		}
		System.out.println(Arrays.toString(arr));
		
		// 문제 2) 값 2개를 입력받아 값 교체하기
		// 예 1) 값1 입력 : 40 , 값2 입력 : 20
		// { 10, 20, 30, 40, 50}
		System.out.println("=======문제2=======");
		System.out.print("값1 입력 : ");
		idx1 = sc.nextInt();
		System.out.print("값2 입력 : ");
		idx2 = sc.nextInt();
		
		int index1 = -1;
		int index2 = -1;
		temp = 0;
		for(int i=0; i<5; i++) {
			if(idx1== arr[i]) {
				index1 = i;
			}else if(idx2== arr[i]) {
				index2 = i;
			}
		}
		
		if(index1 != -1 && index2 != -1) {
			temp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = temp;
		}else {
			System.err.println("없는 값");
		}
	
		System.out.println(Arrays.toString(arr));
		
		
		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005};
		int[] scores = { 87, 11, 45, 98, 23};
		
		// 문제 3) 학번 2개를 입력받아 성적 교체하기
		// 예 3) 학번1 입력 : 1002, 학번2 입력 : 1003
		// {87, 45, 11, 98, 23}
		System.out.println("=======문제3=======");
		System.out.println(Arrays.toString(scores));
		System.out.print("학번1 입력 : ");
		int hakbun1 = sc.nextInt();
		System.out.print("학번2 입력 : ");
		int hakbun2 = sc.nextInt();
		index1 = -1;
		index2 = -1;
		temp = 0;
		for(int i=0; i<5; i++) {
			if(hakbun1 == hakbuns[i]) {
				index1 = i;
			}else if(hakbun2 == hakbuns[i]) {
				index2 = i;
			}
		}
		
		if(index1 != -1 && index2 != -1) {
			temp = scores[index1];
			scores[index1] = scores[index2];
			scores[index2] = temp;
		}else {
			System.err.println("입력오류");
		}
		System.out.println(Arrays.toString(scores));

	}

}
