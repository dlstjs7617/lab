package lv04;

import java.util.Scanner;

public class Ex26 {
	
	public static void main(String[] args) {
		// 문제1) 1~백만 사이의 숫자를 입력받고 가운데 숫자 출력
		// (단 ! 짝수자리의 수는 짝수자리라고 출력)
		// 예) 123 ==> 2
		// 예) 1234 ==> 짝수의 자리이다.
		// 예) 1 ===> 1
		// 예) 1234567 ==> 4
		
		// 힌트 자리수를 구하고 배열을 만든다음 하나씩 저장
		// 예) ===> 123 ===> 3 ===> arr[] = new int[3];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 : ");
		int num = sc.nextInt();
		int cnt = 0;
		int temp = num ;
		if(num % 2 == 0) {
			System.out.printf("%d ==> 짝수의 자리이다.",num);
		}else if(num % 2 == 1) {
			if(num > 0 && num < 10) {
				System.out.printf("%d ==> %d",num,num);
			}else {
				while(temp > 10) {
					temp = (temp / 10) +(temp % 10);
					cnt++;
				}
				temp = num;
				for(int i=0; i<cnt/2; i++) {
					temp = temp /10;
				}
				temp = temp % 10;
				System.out.println(num +" ===> " + temp);
			}
			}
			
			
		}

}
