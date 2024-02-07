package Ex02;

import java.util.Random;
import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		/*
		1. com은 랜덤으로 1~100 사이를 저장한다.
		2. me는 1~100 사이를 입력한다.
		3. com과 me를 비교해서 com 크면 "크다", com이 작으면 "작다" 힌트제공
		4. 정답 맞히면 게임 종료 
		 */
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		int com = random.nextInt(100)+1;
		while(true) {
			System.out.print("me : ");
			int me = sc.nextInt();
			if(me > com) {
				System.out.println("me가 크다");
			}else if(me < com) {
				System.out.println("me가 작다");				
			}else if(me == com) {
				System.out.println("정답");
				break;
			}
		}
		
		
	}

}
