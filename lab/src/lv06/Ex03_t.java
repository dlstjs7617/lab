package lv06;

import java.util.Random;

class Omr_t {
	int[] answer = {1, 3, 4, 2, 5};		// 시험답안
	int[] submit = new int[5];			// 학생답안
	
	int cnt = 0;						// 정답 맞춘 개수
	int score = 0;						// 성적
}


public class Ex03_t {

	public static void main(String[] args) {
		/*
		 * # OMR카드 : 클래스 + 변수
		 * 1. 배열 answer는 시험문제의 정답지이다.
		 * 2. 배열hgd에 1~5 사이의 랜덤 숫자 5개를 저장한다.
		 * 3. answer와 hgd 값을 비교해 정오표를 출력한다.
		 * 4. 한 문제당 20점이다.
		 * 예)
		 * answer = {1, 3, 4, 2, 5}
		 * submit = {1, 1, 4, 4, 3}
		 * 정오표  = {O, X, O, X, X}
		 * 성적		= 40점
		 */
		
		Random random = new Random();
		
		Omr omr = new Omr();
		
		// 참조 변수 (값으로 주소를 가짐)
		int[] submit = omr.submit;
		int[] answer = omr.answer;
		
		// 일반 변수
		int score = omr.score;
		int cnt = omr.cnt;
		
		for(int i=0; i<omr.submit.length; i++) {
			submit[i] = random.nextInt(5)+1;
			
			if(submit[i] == answer[i]) {
				omr.cnt++;
				omr.score += 20;
			}
			
			System.out.printf("%d) %d : %d [%s]\n", i+1, submit[i], answer[i], submit[i] == answer[i] ?  "O" : "X" );
		}
	}

}
