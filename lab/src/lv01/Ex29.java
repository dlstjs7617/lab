package lv01;

import java.util.Scanner;

public class Ex29 {

	/*
	 * # 가위(0) 바위(1) 보(2) 게임[1단계]
	 * 1. com은 0~2 사이의 랜덤한숫자를 저장한다.
	 * 2. me는 0~2 사이의 숫자를 입력받는다.
	 * 3. com과 me를 비교해,
	 * 	  1) 비겼다.2) 내가 이겼다.3) 내가 졌다. 를 출력한다.
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int com = (int)(Math.random()*3);
		
		System.out.print("가위(0) 바위(1) 보(2) : ");
		int me = sc.nextInt();
		
		String comRsp = null;
		String meRsp = null;
		if(com == 0) {
			comRsp = "가위";
		}else if(com == 1) {
			comRsp = "바위";
		}else if(com ==  2) {
			comRsp = "보";
		}		
		if(me == 0) {
			meRsp = "가위";
		}else if(me ==  1) {
			meRsp = "바위";
		}else if(me ==  2) {
			meRsp = "보";
		}		
		
		
		if(com == me) {
			System.out.println("컴퓨터가 낸값 :("+ comRsp +")  내가 낸값 :("+ meRsp +") \n비겼다.");
		}else if((com == 0 && me == 1 ) || (com == 1 && me == 2 ) || (com == 2 && me == 0 )) {
			System.out.println("컴퓨터가 낸값 :("+ comRsp +")  내가 낸값 :("+ meRsp +") \n내가 이겼다");
		}else if((com == 0 && me == 2 ) || (com == 1 && me == 0 ) || (com == 2 && me == 1 )) {
			System.out.println("컴퓨터가 낸값 :("+ comRsp +")  내가 낸값 :("+ meRsp +") \n내가 졌다.");
		}else {
			System.out.println("입력오류 다시 입력하세요");
		}
		
	}

}
