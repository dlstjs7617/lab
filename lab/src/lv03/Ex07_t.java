package lv03;

public class Ex07_t {

	public static void main(String[] args) {
		// 문제 1) 아래 배열 a 와 b 를 비교해서
		// 둘의 합이 짝수 일때만 c에 저장
		int a[] = { 10, 20, 30, 40, 50 };
		int b[] = { 13, 54, 17, 42, 1 };
		int c[] = { 0, 0, 0, 0, 0 };
		// 예) c[] = {74, 82, 0, 0, 0}
		System.out.println("=======문제1=======");
		
		int idx = 0;
		for(int i=0; i<5; i++) {
			int sum = a[i] + b[i];
			if(sum % 2 == 0) {
				c[idx] = sum;
				idx++;
			}
		}
		for(int i=0; i<5; i++) {
			System.out.print(c[i] + " ");
		}
		
		// 문제2) 아래는 시험결과 이다.
		// 시험에 합격한 사람의 번호만 win 에 저장 (60점이상 합격)
		int num[] = { 1001, 1002, 1003 };
		int score[] = { 50, 83, 78 };
		int win[] = { 0, 0, 0 };
		// 예) win[] = {1002, 1003, 0}
		System.out.println("\n=======문제2=======");
		idx = 0;
		for(int i=0; i<3; i++) {
			if(score[i] >= 60) {
				win[idx] = num[i];
				idx++;
			}
		}
		for(int i=0; i<3; i++) {
			System.out.print(win[i] + " ");
		}
		
		// 문제3) 아래는 시험결과이다.
		// 시험에 합격한 사람의 번호만 win2 에 저장 (60점이상 합격)
		int data[] = { 1001, 80, 1002, 23, 1003, 78 };
		int win2[] = { 0, 0, 0 };
		// 예) win2[] = {1001, 1003, 0 }
		System.out.println("\n=======문제3=======");
		idx = 0;
		for(int i=1; i<6; i+=2) {
			if(data[i] >= 60) {
				win2[idx] = data[i-1]; 
				idx++;
			}
		}
		
		for(int i=0; i<3; i++) {
			System.out.print(win2[i] + " ");
		}
		
		
	}

}
