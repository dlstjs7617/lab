package lv02;

import java.util.Scanner;

public class Ex11 {
	/*
	 * # 소수찾기[1단계]
	 * 1. 소수란 1과 자기자신으로만 나눠지는 수
	 * 2. 예) 2, 3, 5, 7, 11, 13 ..
	 * 3. 힌트
	 * 1) 해당 숫자를 1부터 자기자신까지 나눈다
	 * 2) 나머지가 0일 때마다 카운트를 센다.
	 * 3) 그 카운트 값이 2이면 소수이다.
	 * 4) 6/1 6/2 6/3 6/4 6/5 6/6 cnt=4 소수 x
	 * 
	 * 정수 한 개를 입력받아, 해당 숫자가 소수인지 아닌지 판별한다.
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean isRun = true;
		
		
		System.out.print("소수 찾기 :");
		int num = scanner.nextInt();
		
		while(isRun) {
			int cnt = 1;
			int temp = 1;
			
			while(temp != num) {
				if(num % temp == 0) {
					cnt++;
				}
				temp++;
			}

			if(cnt == 2) {
				System.out.println(num +"은 소수이다");
				isRun = false;
			}else {
				System.out.println(num +"은 소수가 아니다");
				isRun = false;
			}
		}
		
	}
}
