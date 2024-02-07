package Ex02;

import java.util.Random;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		//1. 구구단 게임을 5회 반복한다.
		//2. 정답을 맞추면 개당 20점이다.
		//3. 게임 종료 후 성적을 출력한다.
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		int score = 0;

		System.out.println("===구구단 게임===");
		while(true) {
			int num1 = random.nextInt(9)+1;
			int num2 = random.nextInt(9)+1;
			int result = num1 * num2;
			System.out.print(num1 +" * " + num2 + " = ");
			int answer = sc.nextInt();
			if(answer == result) {
				System.out.println("정답");
				score+=20;
			}else {
				System.out.println("오답");
			}
			count++;
			if(count == 5) {
				break;
			}
		}
		System.out.printf("총점 %d점", score);
	}

}
