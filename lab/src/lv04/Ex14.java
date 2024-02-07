package lv04;

import java.util.Scanner;

public class Ex14 {

	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		
		int k = 1;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = 10 * k;
				k+=1;
			}
		}
		
		Scanner sc = new Scanner(System.in);
		// 문제 1) 인덱스 2개를 입력받아 값 출력
		// 예	1) 인덱스1 입력 : 1 인덱스2 입력 : 2
		//		값 출력 :60
		System.out.print("인덱스 1 입력 : ");
		int idx1 = sc.nextInt();
		System.out.print("인덱스 2 입력 : ");
		int idx2 = sc.nextInt();
		
		if(!(idx1 < 0 || idx1 >arr.length || idx2 < 0 || idx2 >arr.length)) {
			System.out.println("출력"+arr[idx1][idx2]);			
		}else {
			System.out.println("입력오류");
		}
		
		
		// 문제 2) 값을 입력받아 인덱스 2개 출력
		// 예	2) 값 입력 : 60
		//		인덱스1 출력 : 1 인덱스2 출력 : 2
		System.out.print("값 입력 : ");
		int num = sc.nextInt();
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j] == num)
					System.out.printf("인덱스 1 출력 : %d 인덱스2 출력 : %d \n", i, j);
			}
		}
		
		// 문제 3) 가장 큰 값의 인덱스 2개 출력
		// 정답 3) 2 2
		int max = 0;
		idx1 = -1;
		idx2 = -1;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j] > max) {
					max = arr[i][j];
					idx1 = i;
					idx2 = j;
				}
			}
		}
		
		System.out.printf("가장 큰 값 인덱스는 : %d    %d    \n", idx1, idx2);
		
		
		// 문제 4) 값 2개를 입력받아 값 교체 (배열 안에 있는 값 두개를 서로 교체)
		System.out.print("교체값1 입력 : ");
		int input1 = sc.nextInt();
		System.out.print("교체값2 입력 : ");
		int input2 = sc.nextInt();
		
		int input1Idx1 = -1;
		int input1Idx2 = -1;
		
		int input2Idx1 = -1;
		int input2Idx2 = -1;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				
				if(arr[i][j] == input1) {
					input1Idx1 = i;
					input1Idx2 = j;
				}
				if(arr[i][j] == input2) {
					input2Idx1 = i;
					input2Idx2 = j;			
				}
				System.out.printf("arr [%d] [%d] = %d    \n", i, j, arr[i][j]);
			}
		}
		if(input1Idx1 != -1 && input1Idx2 != -1 && input2Idx1 != -1 && input2Idx2 != -1) {
			arr[input1Idx1][input1Idx2] = input2;
			arr[input2Idx1][input2Idx2] = input1;
			System.out.printf("arr[%d][%d] = %d \n", input1Idx1, input1Idx2, arr[input1Idx1][input1Idx2]);
			System.out.printf("arr[%d][%d] = %d", input2Idx1, input2Idx2, arr[input2Idx1][input2Idx2]);
		}else {
			System.out.println("입력오류");
		}
	}

}
