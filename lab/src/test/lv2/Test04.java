package test.lv2;

import java.util.Scanner;

public class Test04 {
	//시작 02:00
	//종료 05:30
	//소요 03:30
	public static void main(String[] args) {
		
		// Lv02 테스트
		
		// 문제 4)
		/*
		 * 1. 5회 반복하면서 정수를 입력받는다.
		 * 2. 입력받은 정수를 전부 합을 출력한다.
		 * 3. 만약에 입력받은 합이 100 이상이면 반복이 5회가 아닐지라도 즉시 종료
		 * 
		 * 예) 7 ===> 합 : 7 , 14 ==> 합 : 21, 1000 ==> 합 :1021 !종료
		 */
		
		Scanner sc =new Scanner(System.in);
		int sum = 0;

		for(int i=1; i<=5; i++) {
			System.out.printf("값 : ");
			int input = sc.nextInt();
			sum += input;
			System.out.printf("%d ===> 합 : %d \n",input,sum);
			if(sum >= 100) {
				System.out.println("종료");
				break;
			}
		}
		
		
		
		
	}

}
