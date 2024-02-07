package lv02;

import java.util.Scanner;

public class Ex12_t {
	
	
	/*
	 * # 최대값 구하기[2단계]
	 * 1. 3회 반복을 하면서 정수를 입력 받는다.
	 * 2. 입력받은 3개의 숫자 중 가장 큰 값을 출력한다
	 */
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int max = 0;
		
		int n = 0;
		while(n < 3) {
			System.out.printf("숫자 입력 %d : ", n+1);
			int input = scanner.nextInt(); 
			
			if(input > 0) {
				if(input > max) {
					max = input;
				}				
				n++;
			}else {
				System.out.println("다시, ");
			}
		}
	}

}
