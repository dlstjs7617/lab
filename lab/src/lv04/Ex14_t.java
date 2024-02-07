package lv04;

import java.util.Scanner;

public class Ex14_t {

	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		final int SIZE = 3;
		// { {0,0,0}, {0,0,0}, {0,0,0} }
		int k = 1;
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = 10 * k;
				k += 1;
			}
		}
		// { {10,20,30}, {40,50,60}, {70,80,90} }
		
		Scanner sc = new Scanner(System.in);
		// 문제 1) 인덱스 2개를 입력받아 값 출력
		// 예	1) 인덱스1 입력 : 1 인덱스2 입력 : 2
		//		값 출력 :60
		System.out.print("인덱스 1 입력 : ");
		int idx1 = sc.nextInt();
		System.out.print("인덱스 2 입력 : ");
		int idx2 = sc.nextInt();
		
		if(idx1 < 0 || idx1 >= SIZE || idx2 < 0 || idx2 >= SIZE) {
			System.out.println("입력오류");
		}else {
			System.out.println("출력"+arr[idx1][idx2]);			
		}
		
		
		// 문제 2) 값을 입력받아 인덱스 2개 출력
		// 예	2) 값 입력 : 60
		//		인덱스1 출력 : 1 인덱스2 출력 : 2
		System.out.print("값 입력 : ");
		int data = sc.nextInt();
		
		idx1 = -1;
		idx2 = -1;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j] == data) {
					idx1 = i;
					idx2 = j;
				}
			}
		}
		
		if(idx1 == -1)
			System.out.println("해당 값은 존재하지 않습니다.");
		else {
			System.out.println("index1 : " + idx1);
			System.out.println("index2 : " + idx2);
		}
		
		// 문제 3) 가장 큰 값의 인덱스 2개 출력
		// 정답 3) 2 2
		int max = arr[0][0];
		idx1 = 0;
		idx2 = 0;
		//기준을 하나 잡았으니 idx을 임의로 잡은 값의 인덱스로 두면된다.
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(max < arr[i][j]) {
					max = arr[i][j];
					idx1 = i;
					idx2 = j;
				}
			}
		}
		
		System.out.println("index1 : " + idx1);
		System.out.println("index2 : " + idx2);
		
		
		// 문제 4) 값 2개를 입력받아 값 교체 (배열 안에 있는 값 두개를 서로 교체)
		System.out.print("교체값1 입력 : ");
		data = sc.nextInt();
		System.out.print("교체값2 입력 : ");
		int data2 = sc.nextInt();
		
		idx1 = -1;
		idx2 = -1;
		int idx3 = -1;
		int idx4 = -1;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {

				if(arr[i][j] == data) {
					idx1 = i;
					idx2 = j;
				}
				if(arr[i][j] == data2) {
					idx3 = i;
					idx4 = j;
				}
			}
		}
		
		if(idx1 == -1 || idx3 == -1) {
			System.out.println("값 교체가 불가합니다.");
		}else {
			//값교체
			int temp = arr[idx1][idx2];
			arr[idx1][idx2] =arr[idx3][idx4];
			arr[idx1][idx2] =temp;
		}
		
		//출력
		for(int i=0; i<SIZE; i++) {
			System.out.println(arr[i]);
		}
		
		
	}

}
