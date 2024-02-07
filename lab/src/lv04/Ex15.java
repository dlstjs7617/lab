package lv04;

import java.util.Scanner;

public class Ex15 {

	public static void main(String[] args) {
		int[][] apt = {
				{101, 102, 103},
				{201, 202, 203},
				{301, 302, 303}
		};
		
//		int[][] pay = {
//				{1000, 2100, 1300},
//				{4100, 2000, 1000},
//				{3000, 1600, 800}
//		};
		
		int[][] pay = {
				{100, 2100, 1300},
				{4100, 2000, 1000},
				{3000, 1600, 800}
		};
		Scanner sc = new Scanner(System.in);
		final int SIZE = 3;
		
		// 문제 1) 각층별 관리비 합 출력
		// 정답 1) 4400, 7100, 5400
		for(int i=0; i<SIZE; i++) {
			int sum = 0;
			for(int j=0; j<SIZE; j++) {
				sum+= pay[i][j];
			}
			System.out.print(sum + " ");
		}
		System.out.println();
		// 문제 2) 호를 입력하면 관리비 출력
		// 예) 2) 입력 : 202 관라비 출력 : 2000
		System.out.print("호를 입력 : ");
		int num = sc.nextInt();
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(num == apt[i][j])
					System.out.println(pay[i][j]);					
			}
		}
		
		// 문제 3) 관리비가 가장 많이 나온 집, 적게 나온 집 추력
		// 정답 3) 가장 많이 나온 집(201), 가장 적게 나온 집(303)
		int max = pay[0][0];
		int idx1 = 0;
		int idx2 = 0;
		
		int min = pay[0][0];
		int idx3 = 0;
		int idx4 = 0;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(pay[i][j] > max) {
					max = pay[i][j];
					idx1 =i;
					idx2 =j;
				}
				if(pay[i][j] < min) {
					min = pay[i][j];
					idx3 =i;
					idx4 =j;
				}					
			}
		}
		System.out.printf("가장 많이 나온집 (%d) 가장 적게나온집 (%d) \n", apt[idx1][idx2], apt[idx3][idx4]);
		
			
		// 문제 4) 호 2개를 입력하면 관리비 교체
		System.out.print("호1 입력 : ");
		int input1 = sc.nextInt();
		System.out.print("호2 입력 : ");
		int input2 = sc.nextInt();

		idx1 = -1;
		idx2 = -1;
		idx3 = -1;
		idx4 = -1;
		int temp1 = 0;
		int temp2 = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (input1 == apt[i][j]) {
					idx1 = i;
					idx2 = j;
					temp1 = pay[i][j];
				}
				if (input2 == apt[i][j]) {
					idx3 = i;
					idx4 = j;
					temp2 = pay[i][j];
				}
			}
		}

		if (idx1 == -1 || idx3 == -1) {
			System.out.println("없는 호입니다.");
		} else {
			pay[idx1][idx2] = temp2;
			pay[idx3][idx4] = temp1;
		}

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print("apt : [" + i + "] [" + j + "] = " + pay[i][j] + "\n");
			}
		}

	}

}
