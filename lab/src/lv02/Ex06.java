package lv02;

import java.util.Random;
import java.util.Scanner;

public class Ex06 {
	
	/*
	 * # Up & Down 게임[2단계]
	 * 1. com 은 랜덤으로 1~100사이를 저장한다.
	 * 2. me 는 1~100사이를 입력한다.
	 * 3. com 과 me 를 비교해서 com 크면 "크다" , com이 작으면 "작다"힌트제공
	 * 4. 정답을 맞추면 게임은 종료된다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		int com = random.nextInt(100)+1;
		int me = 0;
		while(com != me) {
			System.out.print("Up & Down 게임 : ");
			me = sc.nextInt();
			if(me > com) {
				System.out.println("작다");
			}else if(me < com) {
				System.out.println("크다");
			}
		}
		System.out.println("정답");
		
	}

}
