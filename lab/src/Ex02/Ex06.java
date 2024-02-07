package Ex02;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		/*
		1. p1과 p2가 번갈아가면서 1~3을 입력한다.
		2. br은 p1과 p2의 입력값을 누적해서 저장한다
		3. br이 31을 넘으면 게임은 종료된다.
		4. 승리자를 출력한다.				
		예)
			1턴:p1(2) br(2)
			2턴:p2(1) br(3)
			3턴:p1(3) br(6)
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int p1 = 0;
		int p2 = 0;
		int turn = 1;
		int br = 0;
		
		System.out.println("베라31");
		while(br < 31) {
			while(turn == 1) {
				System.out.print("p1턴 :");
				p1 = sc.nextInt();
				if(p1 > 0 && p1 <=3) {
					br+= p1;
					System.out.println("p1(" + p1 + ")    br(" + br + ")");
					turn = 2;
				}
				
			}
			if(br >= 31) {
				break;
			}
			while(turn == 2) {
				System.out.print("p2턴 :");
				p2 = sc.nextInt();
				if(p2 > 0 && p2 <=3) {
					br+= p2;
					System.out.println("p2(" + p2 + ")    br(" + br + ")");
					turn = 1;
				}
			}
		}
		if(turn == 1) {
			System.out.println("승자는 p1입니다");
		}else {
			System.out.println("승자는 p2입니다");
			
		}
		
	}

}
