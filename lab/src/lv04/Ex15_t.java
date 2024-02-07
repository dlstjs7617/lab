package lv04;

import java.util.Scanner;

public class Ex15_t {

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
			int total = 0;
			for(int j=0; j<SIZE; j++) {
				total+= pay[i][j];
			}
			System.out.printf("%d층 관리비 : 총 %d원 \n", i+1, total);
		}
		System.out.println();
		// 문제 2) 호를 입력하면 관리비 출력
		// 예) 2) 입력 : 202 관라비 출력 : 2000
		System.out.print("호를 입력 : ");
		int ho = sc.nextInt();
		
		int idx1 = -1;
		int idx2 = -1;
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(ho == apt[i][j]) {
					idx1 = i;					
					idx2 = i;										
				}
			}
		}
		if(idx1 != -1)
			System.out.println(pay[idx1][idx2] + "원");
		else
			System.out.println("존재하지 않는 호수입니다.");
		// 문제 3) 관리비가 가장 많이 나온 집, 적게 나온 집 추력
		// 정답 3) 가장 많이 나온 집(201), 가장 적게 나온 집(303)
		int max = pay[0][0];
		idx1 = 0;
		idx2 = 0;
		
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
		ho = sc.nextInt();
		System.out.print("호2 입력 : ");
		int ho2 = sc.nextInt();

		idx1 = -1;
		idx2 = -1;
		idx3 = -1;
		idx4 = -1;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (ho == apt[i][j]) {
					idx1 = i;
					idx2 = j;
				}
				if (ho2 == apt[i][j]) {
					idx3 = i;
					idx4 = j;
				}
			}
		}

		if (idx1 == -1 || idx3 == -1) {
			System.out.println("없는 호입니다.");
		} else {
			int temp = pay[idx1][idx2];
			pay[idx1][idx2] = pay[idx3][idx4];
			pay[idx3][idx4] = temp;
		}

	}

}
