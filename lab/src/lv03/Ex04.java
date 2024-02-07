package lv03;

import java.util.Random;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		int[] hakbuns = null;
		int[] scores = null;
		
		// 랜덤 점수(1~100) scores에 5개 저장
		// 학번을 (1001~1005) hakbuns에 5개 저장
		hakbuns = new int[5];
		scores = new int[5];
		int max = 0;
		int num = 0;
		for(int i=0; i<5; i++) {
			int ranScores = random.nextInt(100)+1;
			int ran = random.nextInt(5)+1001;
			scores[i] = ranScores; 
			hakbuns[i] = ran;
			System.out.println(hakbuns[i]);
			System.out.println(scores[i]);
			if(scores[i]> max) {
				max = scores[i];
				num = i;
			}
		}
		
		System.out.println("=========문제1=========");
		// 문제1) 인덱스를 입력받아 성적 출력
		// 정답1) 인덱스 입력 : 1 성적 : 11점
		while(true) {
			System.out.print("인덱스 입력 : ");
			int index = sc.nextInt();
			if(index >= 0 && index < 5) {				
				System.out.println("성적 : "+ scores[index] +"점");
				break;
			}
		}
		System.out.println("=========문제2=========");
		// 문제2) 성적을 입력받아 인덱스 출력
		// 정답2) 성적 입력 : 11 인덱스 :1
		int score = 0;
		boolean roop = true;
		while(roop) {
			System.out.print("성적 입력 : ");
			score = sc.nextInt();
			
			for(int i=0; i<5; i++) {
				if(score == scores[i]) {
					System.out.println("인덱스 : "  + i);
					roop = false;
				}
			}			
		}
		
		
		
		System.out.println("=========문제3=========");
		// 문제3) 학번을 입력받아 성적 출력
		// 정답3) 학번 입력 : 1003 성적 : 45점
		//인덱스를 기억하는 용도는 가진 변수는 유효한 인덱스 범위 밖 값으로 초기
		roop = true;
		int hakbun = 0;
		while(roop) {
			System.out.print("학번 입력 : ");
			hakbun = sc.nextInt();
			for(int i=0; i<5; i++) {
				if(hakbun == hakbuns[i]) {
					System.out.println("성적 : " + scores[i]);
					roop = false;
				}
			}			
		}
		System.out.println("=========문제4=========");
		// 문제) 1등 학생의 학번과 성적 출력
		// 정답) 1004번(98)
		System.out.println("1등학생 : " + hakbuns[num]+ "번(" + scores[num] + ")점");
	}
}
