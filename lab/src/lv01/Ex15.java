package lv01;

import java.util.Scanner;

public class Ex15 {
	/*
	 * # Up & Down 게임[1단계]
	 * 1. com은 8이다.
	 * 2. me는 숫자를 하나 입력받는다.
	 * 3. com 과 me 를 비교해서 다음과 같이 메세지를 출력한다.
	 * 1) me < com : Up!
	 * 2) me == com : Bingo!
	 * 3) me > com : Down! 
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int com = 8;
		
		System.out.print("입력할 값 : ");
		int me = sc.nextInt();
		// if문 활용		
		if(me < com) {
			System.out.println("Up!");
		}
		if(me == com) {
			System.out.println("Bingo!");
		}
		if(me > com) {
			System.out.println("Down!");
		}

	}

}
