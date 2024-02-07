package lv01;

import java.util.Scanner;

public class Ex32 {
	/*
	 *  # 가운데 숫자 맞추기 게임
	 *  1. 150~250 사이의 랜덤 숫자 저장
	 *  2.랜덤 숫자의 가운데 숫자를 맞추는 게임이다.
	 *  예) 249 : 4
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int rNum2 = (int)(Math.random()*101+150) ;
		System.out.print(rNum2 + "의 가운데 숫자는? : ");
		int input2 = sc.nextInt();
		int x = rNum2/10;
		//System.out.println(x);
		int y = x%10;
		//System.out.println(y);
		if(input2 == y) {
			System.out.println("정답입니다");
		}else {
			System.out.println("틀렸습니다.");
		}
		
		/*
		int rNum = (int)(Math.random()*101+150) ;
		System.out.print(rNum + "의 가운데 숫자는? : ");
		int input =sc.nextInt();
		int temp = rNum - input*10;
		if((temp >=100 && temp <=110) || (temp >= 200 && temp <210)) {
			System.out.println("정답입니다");
		}else {
			System.out.println("정답이 아닙니다.");
		}
		*/
	
	}

}
