package lv02;

public class Ex13_t {
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
		
		int total = 0;
		int pass = 0;
		
		int top = 0;
		int max = 0;
		
		int n = 0;
		while(n < 10) {
			int score = (int)(Math.random() * 100)+1;
			total += score;
			
			if(score >= 60) {
				pass++;
			}
			
			if(max < score) {
				top = n + 1;
				max = score;
			}
			
			System.out.printf("%d번 학생) %d점 [%s]\n", n+1, score, score >= 60);
			n++;
		}
		System.out.println("---");
		System.out.printf("전교생 총점 %d점, 평균 %d점\n", total, total/n);
		System.out.printf("합격생 %d명\n", pass);
		System.out.printf("1등 학생 : %d번, %d점\n", top, max);
	}
}
