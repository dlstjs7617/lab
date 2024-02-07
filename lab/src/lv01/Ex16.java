package lv01;

import java.util.Scanner;

public class Ex16 {
	/*
	 * # 가위(0) 바위(1) 보(2) 게임[1단계]
	 * 1. com은 바위(1)만 낼 수 있다.
	 * 2. me는 0~2 사이의 숫자를 입력받는다.
	 * 3. com과 me를 비교해,
	 * 		1) 비겼다.
	 * 		2) 내가 이겼다.
	 * 		3) 내가 졌다.			를 출력한다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("me : 가위(0)바위(1)보(2)!  : ");
		int me = sc.nextInt();
		System.out.print("com : 가위(0)바위(1)보(2)! : ");
		int com =sc.nextInt();
		/*
		if(me == 0) {
			System.out.println("내가 졌다");
		}
		
		if(me == 1) {
			System.out.println("비겼다");
		}
		
		if(me == 2) {
			System.out.println("내가 졌다");
		} */
		if((com == 0 && me == 1) || (com == 1 && me == 2) || (com == 2 && me == 0) ) {
			System.out.println("내가 이겼다.");
		}
		if((me >= 0 && me <= 2) && com == me) {
			System.out.println("비겼다.");
		}
		if((com == 0 && me == 2) || (com == 1 && me == 0) || (com == 2 && me == 1) ) {
			System.out.println("내가 졌다.");
		} 

	}

}
