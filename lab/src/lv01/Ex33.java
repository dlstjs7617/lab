package lv01;

public class Ex33 {

	/*
	 * # 369게임[1단계]
	 * 1. 1~50 사이의 랜덤 숫자를 저장한다.
	 * 2. 위 수에 369의 개수가
	 * 	1) 2개이면, 짝짝을 출력
	 * 	2) 1개이면, 짝을 출력
	 *  3) 0개이면, 해당 숫자를 출력
	 *  예)
	 *  
	 *  	33 : 짝짝
	 *  	16 : 짝
	 *  	7  : 7
	 */
	
	public static void main(String[] args) {
		
		int rNum = (int)(Math.random()*50+1);
		int ten = rNum/10;
		int one = rNum%10;
		int count = 0;
		System.out.println("랜덤값 :"+rNum + "\n십의자리값 : " + ten +"\n일의자리값 : "+ one);
		
		if(ten % 3 == 0 && ten != 0) {
			count++;
		}
		if(one % 3 == 0 && one != 0) {
			count++;
		}
		
		if (count == 2) {
			System.out.println(rNum + " : 짝짝");
		} else if (count == 1) {
			System.out.println(rNum + " : 짝");
		} else {
			System.out.println(rNum);
		}
		
		
//		if(ten != 0 && one != 0) {
//			if(ten % 3 == 0 && one % 3 == 0) {
//				count= 2;
//			}else if(ten % 3 == 0 || one % 3 == 0) {
//				count++;
//			}
//		}else if(ten != 0 || one != 0) {
//			if(ten % 3 == 0 && one % 3 == 0) {
//				count++;
//			}
//		}
//		
//		if((ten == 3 || ten == 6 || ten == 9) && (one == 3 || one == 6 || one == 9) ) {
//			count = 2;
//		}else if((ten == 3 || ten == 6 || ten == 9) || (one == 3 || one == 6 || one == 9)) {
//			count++;
//		}


	

		/*if((ten == 3 || ten ==6 || ten == 9) && (one == 3 || one ==6 || one == 9)) {
			System.out.println(rNum + ": 짝짝");
		}else if((ten == 3 || ten ==6 || ten == 9) || (one == 3 || one ==6 || one == 9)) {
			System.out.println(rNum + ": 짝");
		}else {
			System.out.println(rNum + " : " + rNum);
		}
		*/
		
	}

}
