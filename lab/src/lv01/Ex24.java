package lv01;

import java.util.Random;

public class Ex24 {

	public static void main(String[] args) {

		Random random = new Random();
		int ranNum;
		//난수 범위의 개수 구하기 : max - min +1
		
		//문제 1) 1~10
		ranNum = random.nextInt(10)+1;
		ranNum = (int)(Math.random() * 10) +1;
		
		//문제 2) 3~7
		ranNum = random.nextInt(5)+3;
		ranNum = (int)(Math.random() * 5) +3;
		
		//문제 3) -3~3
		ranNum = random.nextInt(7)-3;
		ranNum = (int)(Math.random() * 7) -3;
		
		//문제 4) 2~5
		ranNum = random.nextInt(4)+2;
		ranNum = (int)(Math.random() * 4) + 2;
		
		//문제 5) 1000~9999
		ranNum = random.nextInt(9000)+1000;
		ranNum = (int)(Math.random() * 9000) +1000;	
		

	}

}
