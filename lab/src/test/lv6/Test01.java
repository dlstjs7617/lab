package test.lv6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Lv6 Test (클래스 + 메소드)

// 시작 10:10
// 종료 10:22
// 소요 00:12

//1.
/*
 *  #OMR카드 : 클래스 + 메서드
 *  1. 배열 answer는 시험문제의 정답지이다.
 *  2. 배열 hgd에 1~5 사이의 랜덤 숫자 5개를 저장한다.
 *  3. answer와 hgd 값을 비교해 정오표를 출력 한다.
 *  4. 한 문제당 20점이다.
 *  
 *  예)
 *  
 *  answer ={1, 3, 4, 2, 5}
 *  hgd = {1, 1, 4, 4, 3}
 *  정오표 = {O, X, O, X, X}
 *  성적		= 40점
 */


class Omr{
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	final int SIZE = 5;
	
	int[] answer;
	int[] hgd;
	int score;
	
	void setOmr(){
		answer = new int[SIZE];
		hgd = new int[SIZE];
		
		for(int i=0; i<SIZE; i++) {
			int rNum = ran.nextInt(5);
			answer[i] = rNum;
		}
	}
	
	void answerRan() {
		for(int i=0; i<SIZE; i++) {
			int rNum = ran.nextInt(5);
			hgd[i] = rNum;
		}
	}
	
	void omrHgdPrint() {
		System.out.println("정답 : " + Arrays.toString(answer));
		System.out.println("OMR : " + Arrays.toString(hgd));
	}
	
	void scorePrint() {
		for(int i=0; i<SIZE; i++) {
			if(answer[i] == hgd[i]) {
				score +=20;
			}
		}
		
		System.out.println(score + "점");
	}
	
	void run() {
		setOmr();
		
		answerRan();
		omrHgdPrint();
		scorePrint();
	}
}


public class Test01 {

	public static void main(String[] args) {

		Omr omr = new Omr();
		
		omr.run();
		
	}

}
