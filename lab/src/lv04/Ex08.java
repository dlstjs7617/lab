package lv04;

import java.util.Arrays;

public class Ex08 {
	/*
	 * # 석차 출력
	 * . 성적 순으로 이름 출력
	 */

	public static void main(String[] args) {
		
		String[] name1 = {"홍길동", "김영", "자바킹", "민병철", "메가맨"};
		String[] name2 = {"홍길동", "김영", "자바킹", "민병철", "메가맨"};
		int[] score1 = {		87,		42,		100,	11,		98};
		int[] score2 = {		87,		42,		100,	11,		98};
		int count1 = 0;
		int count2 = 0;
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(score1[i] > score1[j]) {
					int temp = score1[i];
					score1[i] = score1[j];
					score1[j] = temp;
					String tmp = name1[i];
					name1[i] = name1[j];
					name1[j] = tmp;
					count1++;
				}
			}
		}
				
		for(int i=0; i<5-1; i++) {
			int idx = i;
			for(int j=i+1; j<5; j++) {
				if(score2[idx] < score2[j]) {
					idx = j;
					count2++;
				}
			}
			int temp = 0;
			temp =score2[i];
			score2[i] = score2[idx];
			score2[idx] = temp;
			String tmp = name2[i];
			name2[i] = name2[idx];
			name2[idx] = tmp;
			
		}
		// %d등 %s : %3d점\n
		for(int i=0; i<5; i++) {
			System.out.printf("%d등 %s : %3d점\n", i+1, name1[i], score1[i]);
		}
		System.out.println();
		for(int i=0; i<5; i++) {
			System.out.printf("%d등 %s : %3d점\n", i+1, name1[i], score1[i]);
		}
		System.out.println();
		System.out.println("버블 소트교환 횟수 : " + count1);
		System.out.println("셀렉션 소트교환 횟수 : " + count2);
		
	}

}
