package lv03;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 문제1) 인덱스(방번호)를 입력하면 값출력
		int a[]	= { 10, 20, 30, 40, 50 };
		// 예) 3 ==> 40
		System.out.println("=======문제1=======");
		System.out.print("인덱스 입력 : ");
		int input = sc.nextInt();
		if(input >= 0 && input < 5) {
				System.out.println(input + " ==> " + a[input]);			
		}else {
			System.out.println("존재하지 않는 인덱스입니다.");
		}
		
		
		// 문제2) 아래 배열증 가장큰값 출력
		int b[] = { 12, 54, 23, 87, 1};
		// 예) 87
		System.out.println("=======문제2=======");
		int max = 0;
		for(int i=0; i<5; i++) {
			if(max < b[i]) {
				max = b[i];
			}
		}
		System.out.println("가장 큰 값 : " + max);
		
		// 문제3) 아래 배열중 홀수의 개수 출력
		int c[] = { 12, 54, 23, 87, 1 };
		// 예) 홀수의 개수 : 3
		System.out.println("=======문제3=======");
		int count = 0;
		for(int i=0; i<5; i++) {
			if(c[i] % 2 == 1) {
				count++;
			}
		}
		System.out.println("홀수의 개수 : " + count);
		
		// 문제4) 아래배열을 거꾸로 저장
		int d[] = { 1, 2, 3, 4, 5 };
		//          0  1  2  3  4
		int e[] = { 0, 0, 0, 0, 0 };
		// 4 -> 0;
		// 3 -> 1;
		// 2 -> 2;
		// 1 -> 3;
		// 0 -> 4;
		// 예) ={5,4,3,2,1};
		System.out.println("=======문제4=======");
		
		for(int i=0; i<5; i++) {
			e[i] = d[4-i];
		}
		for(int i=0; i<5; i++) {
			System.out.print(e[i] + " ");
		}
		
		
		
	}

}
