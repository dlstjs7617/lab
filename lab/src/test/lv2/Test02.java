package test.lv2;

import java.util.Random;

public class Test02 {
	//시작 24:30
	//종료 34:40
	//소요 10:10
	public static void main(String[] args) {
		
		// Lv02 테스트
		
		// 문제 2)
		
		/*
		 *  # 랜덤학생
		 *  1. 10회 반복한다.
		 *  2. 1~100 사이의 랜덤 숫자를 저장하다.(학생의 성적)
		 *  3. 성적이 60점 이상이면 합격생이다.
		 *  -----------------------------------------
		 *  . 전교생(10명)의 총점과 평균을 출력한다.
		 *  . 합격자 수를 출력한다.
		 *  . 1등 학생의 번호화 성적을 출력한다.
		 */
		
		Random random = new Random();
		
		int student = 0;
		int score = 0;
		int pass = 0;
		
		int count = 1;
		int sum = 0;
		double svg = 0;
		int max = 0;
		
		while(count<=10) {
			score = random.nextInt(100)+1;
			if(score > max) {
				max = score;
				student = count;
			}
			if(score >= 60) {
				pass++;
			}
			sum += score;
			count++;
		}
		svg = (double)sum/10;
		System.out.printf("총점 %d점  평균 %s점 \n",sum,svg);
		System.out.printf("합격자 수 : %d명 \n",pass);
		System.out.printf("1등 학생 %d번 %d점", student, max);
		
	}

}