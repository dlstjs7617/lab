package Ex02;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		/* 
		1. 소수란, 1과 자기 자신으로만 나눠지는 수
		2. 예) 2, 3, 5, 7, 11, 13, ..
		3. 힌트
			1) 해당 숫자를 부터 자기자신까지 나눈다.
			2) 나머지가 0일때마다 카운트를 센다
			3) 그 카운트 값이 2이면 소수이다
			4) 6/1 6/2 6/3 6/4 6/5 6/6 cnt=4 소수x
			정수 한 개를 입력받아 해당 숫자가 소수인지 아닌지 판별한다.
		 */
		// 소수구하기 자동
		Scanner sc =new Scanner(System.in);
		int num = 1;
		while(true) {
			while(true) {
				int count = 1;
				int div = 1;
				num++;
				while(num != div) {
					if(num % div == 0) {
						count++;
					}
					div++;				
				}
				if(count == 2) {
					System.out.println(num + "은 소수이다");
					break;
				}
			}
		}
	}

}
