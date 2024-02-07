package lv02;

import java.util.Scanner;

public class Ex12 {
	
	
	/*
	 * # 최대값 구하기[2단계]
	 * 1. 3회 반복을 하면서 정수를 입력 받는다.
	 * 2. 입력받은 3개의 숫자 중 가장 큰 값을 출력한다
	 */
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int temp = 0 ;
		int count = 0;
		while(count !=3) {
			System.out.print("값 입력 : ");
			int input = scanner.nextInt();
			if(input > temp) {
				temp = input;
			}else {
				System.out.println("입력오류");
			}
			if(input > 0) {				
				count++;
			}
			
		}
		System.out.println("최대값은 : " + temp);
		
	}

}
