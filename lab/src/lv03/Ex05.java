package lv03;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean roop = true;
		
		
		int a[] =  { 10, 49, 51, 36, 17 };
		//문제 1) 다음 리스트를 값을 입력하면 번호 출력
		//예) 51 ===> 2
		//예) 10 ===> 0
		System.out.println("========문제1========");
		while(roop) {
			System.out.print("값을 입력하세요 : ");
			int input = sc.nextInt();
			for(int i=0; i<5; i++) {
				if(input == a[i]) {
					System.out.println(a[i] + " ==> " + i);
					roop = false;
				}
			}			
		}
		roop = true;
		
		
		// 문제 2) 다음 리스트를 이용해서 a의 값중 홀수만 b에 저장(위치는 동일한위치에 저장)
		// 예) b = [0, 49, 51, 0, 17];
		System.out.println("========문제2========");
		int b[] = { 0, 0, 0, 0, 0 };
		for(int i=0; i<5; i++) {
			if(a[i] % 2 == 1) {
				b[i] = a[i];
			}
			System.out.print(b[i] + " ");
		}
		
		
		
		
		// 문제 3) 다음 리스트를 이용해서 a의 값중 홀수만 c에 저장(위치는 앞에서부터 저장)
		// 2번문제와 조금다름
		// 예) c = [49, 51, 17, 0, 0]
		System.out.println("\n========문제3========");
		int c[] = { 0, 0, 0, 0, 0 };
		int count = 0;
		for(int i=0; i<5; i++) {
			if(a[i] % 2 == 1) {
				c[count] = a[i];
				count++;
			}
		}
		for(int i=0; i<5; i++) {
			System.out.print(c[i] + " ");
		}
		
		// -------------------------------------------------
		int arr[] = { 1001, 20, 1002, 45, 1003,54 };
		// 학번과 점수가 한쌍이다. ==> 1001:20, 1002:45, 1003:54
		
		// 문제4) 학번을 입력하면 점수출력
		// 예) 1001 ==> 20, 1003 ==> 54
		System.out.println("\n========문제4========");
		while(roop) {
			System.out.print("학번입력 : ");
			int input = sc.nextInt();
			for(int i=0; i<5; i++) {
				if(input == arr[i]) {
					System.out.println(input + " ==> " + arr[i+1]);
					roop = false;
				}
			}
		}
		roop = true;
		
		
		
		// 문제5) 점수를 입력하면 학번 출력
		// 예5 20 ==> 1001, 45 ==> 1002
		System.out.println("========문제5========");
		while(roop) {
			System.out.print("점수입력 : ");
			int input = sc.nextInt();
			for(int i=0; i<5; i++) {
				if(input == arr[i]) {
					System.out.println(input + " ==> " + arr[i-1]);
					roop = false;
				}
			}
		}
	}

}
