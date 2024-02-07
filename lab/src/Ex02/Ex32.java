package Ex02;

import java.util.Random;

public class Ex32 {

	public static void main(String[] args) {
		Random random = new Random();
		int y = 0;
		for(int i=0; i<100; i++) {
			int x = random.nextInt(21)-10;
			if(x < y) {
				y = x;
			}
			
		}
		System.out.println(y);
		
	}

}
