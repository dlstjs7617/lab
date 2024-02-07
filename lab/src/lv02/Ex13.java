package lv02;

import java.util.Random;

public class Ex13 {
	/*
	 * # 랜덤학생
	 * 1. 10회 반복을 한다.
	 * 2. 1~100 사이의 랜덤 숫자를 저장한다.(학생의 성적)
	 * 3. 성적이 60점 이상이면 합격생이다.
	 * ------------------------------------------
	 * . 전교생(10명)의 총점과 평균을 출력한다.
	 * . 합격자 수를 출력한다.
	 * . 1등 학생의 번호와 성적을 출력한다.
	 */
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		int temp = 0;
		double total = 0;
		int studentNum = 0;
		int count = 0;
		int whileCount = 1;
		while(whileCount <= 10) {
			int score = random.nextInt(100)+1;
			if(score > temp) {
				temp = score;
				studentNum = whileCount;
			}
			if(score >= 60) count++;
			total += score;
			whileCount++;
		}
		System.out.println("전교생 총점 : " + (int)total + "점  평균 : " + total/10 +"점");
		System.out.printf("합격자수 : %d명 \n",count);
		System.out.printf("1등 학생의 번호 : %d  성적 : %d점", studentNum, temp);
	}

}
