package lv03;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 문제 1) 아래 배열 a에서 내가 입력한 값만 빼고 b에 저장
		int a[] = { 10, 20, 30, 40, 50};
		int b[] = { 0, 0, 0, 0, 0 };
		//예) 30 ==> b[] = {10, 20, 40, 50, 0 }
		System.out.println("=======문제1=======");
		
		System.out.print("값 입력 : ");
		int input = sc.nextInt();
		int idx = 0;
		for(int i=0; i<5; i++) {
			if(input != a[i]) {
				b[idx] = a[i];
				idx++;
			}
		}
		for(int i=0; i<5; i++) {
			System.out.print(b[i] + " ");
		}
		
		// 문제 2) 아래 배열에서 내가 입력한 번호의 "번호의 값" 만 뺴고 d에 저장
		int c[] = { 1001, 40, 1002, 65, 1003, 70 };
		int d[] = { 0, 0, 0, 0, 0, 0 };
		// 예) 1002 ==> d[] = { 1001, 40, 1003, 70, 0, 0 };
		System.out.println("\n=======문제2=======");
		System.out.print("번호 입력 : ");
		input = sc.nextInt();
		idx = 0;
		for(int i=0; i<6; i+=2) {
			if(input == c[i]) {
				d[idx] = 0;
				d[idx+1] = 0;
			}else if (input == c[i+1]){
				d[idx] = 0;
				d[idx+1] = 0;
			}else {
				d[idx] = c[i];
				d[idx+1] = c[i+1];
				idx+=2;
			}
			

		}
		for(int i=0; i<6; i++) {
			System.out.print(d[i] + " ");
		}
		
		//강사님 코드
		
		// 문제 2) 아래 배열에서 내가 입력한 번호의 "번호의 값" 만 뺴고 d에 저장
		int cc[] = { 1001, 40, 1002, 65, 1003, 70 };
		int dd[] = { 0, 0, 0, 0, 0, 0 };
		// 예) 1002 ==> d[] = { 1001, 40, 1003, 70, 0, 0 };
		System.out.println("\n=======문제2=======");
		System.out.print("번호 입력 : ");
		input = sc.nextInt();
		
		for(int i=0; i<6; i+=2) {
			if(input != cc[i] && input != cc[i+1]) {				
				dd[idx] = cc[i];
				dd[idx] = cc[i+1];
			}
		}
		
		for(int i=0; i<6; i++) {
			System.out.print(dd[i] + " ");
		}
	}

}
