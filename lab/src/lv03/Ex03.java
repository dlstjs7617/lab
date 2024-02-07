package lv03;

import java.util.Random;

public class Ex03 {

	public static void main(String[] args) {
		// 문제1) arr배열에 1~100점 사이의 정수를 5개 저장
		// 예	1) 84, 11, 92, 14, 47
		
		Random random = new Random();
		System.out.println("======문제1======");
		int[] arr = new int[5];
		int sum = 0;
		double svg = 0;
		int pass = 0;
		for(int i=0; i<5; i++) {
			int ran = random.nextInt(100)+1;
			arr[i] = ran;
			sum += arr[i];
			System.out.print(arr[i] + " ");
			if(arr[i]>=60) {
				pass++;
			}
		}
		System.out.println("");
		// 문제2) 전교생의 총점과 평균 출력
		// 예	2) 총점(251) 평균(50.2)
		System.out.println("======문제2======");
		svg = (double)sum/5;
		System.out.printf("총점 (%d) 평균 (%s) \n", sum, svg);
		// 문제3) 성적이 60점 이상이면 합격. 합격생 수 출력
		// 예	3) 2명
		System.out.println("======문제3======");
		System.out.println(pass + "명");
		
		
		
	}

}
