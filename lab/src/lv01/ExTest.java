package lv01;

import java.util.Random;
import java.util.Scanner;

public class ExTest {
	/*
	 * # 지하철 요금 계산
	 * 1. 이용할 정거장 수를 입력받는다.
	 * 2. 다음과 같이 정거장 수에 따라 요금이 정산된다.
	 * 3. 요금표
	 * 1) 1~5	: 500원
	 * 1) 6~10	: 600원
	 * 1) 11~12	: 650원 (10정거장 이후는 2정거장 마다 50원 추가)
	 * 1) 13~14	: 700원 (10정거장 이후는 2정거장 마다 50원 추가)
	 * 1) 15~16	: 750원 (10정거장 이후는 2정거장 마다 50원 추가)
	 * ...
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int move = 0;
		int pay = 500;
		int money = 0;
		
		
		System.out.print("이동할 정거장 수 입력 : ");
		move = scanner.nextInt();
		
		if(move > 5) {
			pay += 100;
		}
		if(move > 10) {
			move -= 9;
			pay += move/2*50;			
		}
		System.out.println("요금 : " + pay + "원");
		
		
		
	}

}
