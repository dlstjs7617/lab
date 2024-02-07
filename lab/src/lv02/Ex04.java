package lv02;

import java.util.Random;
import java.util.Scanner;

public class Ex04 {
	/*
	 * # 구구단 게임[3단계]
	 * 1. 구구단 게임을 5회 반복한다.
	 * 2. 정답을 맞추면 개당 20점이다.
	 * 3. 게임 종료 후, 성적을 출력한다
	 */

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		Random random = new Random();
		int i = 1;
		int score = 0;
		int count = 0;
		while(i <= 5) {
			int num1 = random.nextInt(9)+1;
			int num2 = random.nextInt(9)+1;
			int result = num1 * num2;
			System.out.println("===구구단 게임===");
			System.out.printf("%d * %d = ? : ",num1,num2);
			int answer = sc.nextInt();
			if(answer == result) {
				score += 20;
				count++;
			}
			i++;
		}
		System.out.printf("맞춘 갯수 %d개 점수 : %d점",count,score);
	}

}
