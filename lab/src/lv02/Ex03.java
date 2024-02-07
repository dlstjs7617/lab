package lv02;

public class Ex03 {

	public static void main(String[] args) {
		
		// 문제1) 1~5까지의 합 출력
		// 정답 1) 15
		int num = 1;
		int temp = 0;
		while(num < 6) {
			temp+=num;
			num++;
		}
		System.out.println(temp);
		
		// 문제2) 1~10까지 반복해 3미만 7이상만 출력
		// 정답2) 1, 2, 7, 8, 9, 10
		num = 1;
		while(num < 11) {
			if(num < 3 || num >=7) {
				System.out.print(num + " ");
			}
			num++;
		}
		System.out.println("");
		
		// 문제3) 문제2의 조건에 맞는 수들의 합 출력
		// 정답3) 37
		num = 1;
		temp = 0;
		while(num < 11) {
			if(num < 3 || num >=7) {
				temp+=num;
			}
			num++;
		}
		System.out.println(temp);
		
		
		// 문제4) 문제2의 조건에 맞는 수들의 개수 출력
		// 정답4) 6
		num = 1;
		temp = 0;
		while(num < 11) {
			if(num < 3 || num >=7) {
				temp++;
			}
			num++;
		}
		System.out.println(temp);
	}
	
}
