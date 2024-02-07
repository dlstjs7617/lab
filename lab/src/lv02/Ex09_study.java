package lv02;

import java.util.Scanner;

public class Ex09_study {
	/*
	 * # 베스킨라빈스31
	 * 1. p1과 p2거 번갈아가면서 1~3을 입력한다.
	 * 2. br은 p1과 p2의 입력값을 누적해서 저장한다.
	 * 3. br이 31을 넘으면 게임은 종료된다.
	 * 4. 승리자를 출력한다.
	 * 
	 * 예)
	 * 1턴 : p1(2) br(2)
	 * 2턴 : p2(1) br(3)
	 * 3턴 : p1(3) br(6)
	 * ...
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean isRun = true;
		int p1 = 0;
		int p2 = 0;
		
		int br = 0;
		int turn = 1; //***** //짝홀 또는 1 or 2로 스위치
		
		//게임 끝 반복문
		while(br != 31 && br <=31) {
			while(isRun && turn == 1 && br != 31) {
				System.out.print("p1 : ");
				p1 = sc.nextInt();
				if(p1- br <= 3 && p1 > br && p1 < 32){
					br = p1;
					isRun = false;
					turn = 2;
					System.out.printf("p1 : br = %d \n",br);
				}else {
					System.out.println("다시입력하세요");
				}
			}
			isRun = true;
			while(isRun && turn == 2 && br != 31) {
				System.out.print("p2 : ");
				p2 = sc.nextInt();
					if(p2- br <= 3 && p2 > br && p2 < 32) {
					br = p2;
					isRun = false;
					turn = 1;
					System.out.printf("p2 : br = %d \n",br);
				}else {
					System.out.println("다시입력하세요");	
				}
			}
			isRun = true;	
		}
		if(turn == 1) {
			System.out.println("승자는 p1입니다.");
		}else {
			System.out.println("승자는 p2입니다");
		}
		
		
	}
}
