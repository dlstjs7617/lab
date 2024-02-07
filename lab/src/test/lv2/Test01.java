package test.lv2;

import java.util.Scanner;

public class Test01 {
	//시작 07:30
	//종료 19:10
	//소요 11:40
	public static void main(String[] args) {
		
		// Lv02 테스트
		
		//문제 1)
		
		/*
		 * # 베스킨라빈스31
		 * 1. p1과 p2가 번갈아가면서 1~3을 입력한다.
		 * 2. br은 p1과 p2의 입력값을 누적해서 저장한다.
		 * 3. br이 31을 넘으면 게임은 종료된다.
		 * 4. 승리자를 출력한다.
		 * 
		 *  예)
		 *  1턴 : p1(2) br(2)
		 *  2턴 : p2(1) br(3)
		 *  3턴 : p1(3) br(6)
		 *  ...
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int p1 = 0;
		int p2 = 0;
		
		int br = 0;
		int turn = 1;
		
		System.out.println("=== 베스킨라빈스31 ===");
		while(br<31){
			if(turn % 2 == 1 && br < 31) {
				System.out.print("p1 : ");
				p1 = sc.nextInt();
				if(p1 >0 && p1 <=3) {
					br += p1;
					System.out.println(turn + "턴 : p1(" + p1 + ")    br(" + br + ")");
					turn++;
				}
			}if(turn % 2 == 0 && br < 31) {
				System.out.print("p2 : ");
				p2 = sc.nextInt();
				if(p2 > 0 && p2 <= 3) {
					br += p2;
					System.out.println(turn + "턴 : p2(" + p2 + ")    br(" + br + ")");
					turn++;
				}
			}
		}
		if(turn % 2 == 1) {
			System.out.println("p1의 승리입니다.");
		}else if(turn % 2 == 0) {
			System.out.println("p2의 승리입니다");
		}
		
		
		
		
		
		
	}

}
