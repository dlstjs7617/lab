package lv01;

import java.util.Scanner;

public class Ex34 {
	
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
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이용할 정거장 수를 입력 : ");
		int move = sc.nextInt();
		
		int temp = move; //임시변수
		
		int fee = 500;
		if(move > 0){
			if(move > 5) {
				fee += 100;
			}	

			if(move > 10) {
				move -= 9;
				fee += move/2 * 50;
			}
			
			// 요금 출력
			// ㄴ print()
			// ㄴ println()
			// ㄴ printf("포맷 문자열", 맵핑될값1, 맵핑될값2 ...)
			
			//서식 문자
			// %d 정수 (decimal)
			// %f 실수 (float)
			// %c 문자 (character)
			// %s 문자열 (string)
			// %b 참거짓 (boolean)
			
			//System.out.println("요금 " + fee +"원 입니다.");
			//System.out.printf("요금은 %d원 입니다.",fee);
			System.out.printf("이동한 정거장은 %d이고 요금은 %d원 입니다.",temp,fee);
		}else {
			System.out.println("beep-");
		}
//		if(move > 0){
//			if(move > 5) {
//				fee +=100;
//			}
//			
//			if(move > 10) {
//				if(move % 2 == 1) {
//					move += 1;
//				}
//				move -= 10;
//				move /= 2;
//				fee += move*50;
//			}
//		}else {
//			System.out.println("beep");
//		}
		
		
		
		
		
	}

}
