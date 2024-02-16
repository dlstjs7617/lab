package lv06;

import java.util.Arrays;
import java.util.Random;

class Omr {
	int[] answer = {1, 3, 4, 2, 5};		// 시험답안
	int[] submit = new int[5];			// 학생답안
	
	int cnt = 0;						// 정답 맞춘 개수
	int score = 0;						// 성적
}


public class Ex03 {

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
		
		Random ran = new Random();
		Omr omr = new Omr();
		Omr student = new Omr();
		int[] answer = omr.answer;
		int[] submit = student.submit;
		
		String[] hgd = new String[5];
		for(int i=0; i<5; i++) {
			int rNum = ran.nextInt(5)+1;
			submit[i] = rNum;
			if(answer[i] == submit[i]) {
				student.score += 20;
				student.cnt++;
				hgd[i] = "O";
			}else {
				hgd[i] = "X";
			}
			
		}
		int score = student.score;
		int cnt = student.cnt;
		System.out.println("answer = "+ Arrays.toString(answer));
		System.out.println("submit = "+ Arrays.toString(submit));
		System.out.println("hgd  = "+ Arrays.toString(hgd));
		System.out.println("성적 = " + score);
		System.out.println("cnt = " + cnt);
			
	}

}
