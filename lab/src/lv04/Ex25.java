package lv04;

import java.util.Scanner;

public class Ex25 {
	
	/*
	 *  # 소수 찾기[3단계]
	 *  1. 숫자를 한 개 입력받는다.
	 *  2. 입력받은 숫자보다 큰 첫 번째 소수를 출력한다.
	 *  
	 *  예) Enter Number ? 1000
	 *  	100보다 큰 첫번째 소수는 1009
	 *  예) Enter Number ? 500
	 *  	500보다 큰 첫번째 소수는 503
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Number ? ");
		int number = sc.nextInt();
		
		
		int temp = number+1;
		while(true) {
			int cnt = 1;
			int x = 1;
			while(temp != x) {
				if(temp % x == 0) {
					cnt++;
				}
				x++;				
			}
			if(cnt == 2) {
				System.out.printf("%d보다 큰 첫번째 소수는 %d다", number, temp);
				break;
			}else {
				temp++;
			}
		}
	}

}
