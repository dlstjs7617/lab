package lv04;

import java.util.Arrays;
import java.util.Random;

public class Ex23 {

	public static void main(String[] args) {

		/*
		 *  # 당첨복권 1셋트
		 *  1. 3이 연속으로 3번 등장하면 당첨복권이다. (0 또는 3으로 랜덤값 부여)
		 *  2. 랜덤으로 5개의 복권을 생성하되,
		 *     당첨복권은 한 개만 생성되도록 설정한다.
		 */
			
		Random random = new Random();
		boolean isGoal = false;
		int[][] lottoSet = new int[5][7];
		for(int i=0; i<lottoSet.length; i++) {
			int cnt = 0;
			
			//랜덤입력
			for(int j=0; j<lottoSet[i].length; j++) {
					int ran = random.nextInt(2);
					if(ran == 1) {
						lottoSet[i][j] = 3;				
						cnt++;					
					}else {
						lottoSet[i][j] = ran;
						cnt = 0;					
					}
					if(isGoal && cnt == 3) {
						i--;
					}
			}
			if(cnt == 3) 
				isGoal = true;					

			
			
			System.out.println(isGoal);
			if(isGoal == false && i == lottoSet.length-1) {
				i=0;
				i--;
			}
		}
		
		
		
		
		for(int i=0; i<lottoSet.length; i++) {
			for(int j=0; j<lottoSet[i].length; j++) {
				System.out.printf("%d",lottoSet[i][j]);
			}
			System.out.println();
		}

	}

}
