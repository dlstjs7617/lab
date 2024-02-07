package lv04;

import java.util.Random;

public class Ex23_t {

	public static void main(String[] args) {

		/*
		 *  # 당첨복권 1셋트
		 *  1. 3이 연속으로 3번 등장하면 당첨복권이다. (0 또는 3으로 랜덤값 부여)
		 *  2. 랜덤으로 5개의 복권을 생성하되,
		 *     당첨복권은 한 개만 생성되도록 설정한다.
		 */
			
		Random random = new Random();
//		boolean isGoal = false;
		int goalIdx = -1;
		int[][] lottoSet = new int[5][7];
		
		for(int i=0; i<lottoSet.length; i++) {
			int cnt = 0;
			for(int j=0; j<lottoSet[i].length; j++) {
				//전체 값에 접근 -> 0 또는 3으로 초기화
				lottoSet[i][j] = random.nextInt(2) == 1 ? 3: 0;
				
				// 연속되는 3 카운트
				if(lottoSet[i][j] == 3)
					cnt++;
				else 
					cnt = 0;
				
				// 연속되는 3이 3에 도달, 즉 당첨인 경우
				// 기록 여부를 결정
				if(cnt == 3 && (goalIdx == -1 || goalIdx == i))
					goalIdx = i;
				else if(cnt == 3 && goalIdx != -1) {
					i--;
					break; // why i == 0 && {3, 3, 3, 0 ,3 ,3 ,3};
				}
			}
			
			// 로또셋 완성 후, 아직 당첨 셋이 발견되지 않은 경우
			if(i == lottoSet.length-1 && goalIdx == -1)
				i--;
			
		}
		
		for(int i=0; i<lottoSet.length; i++) {
			for(int j=0; j<lottoSet[i].length; j++) {
				if(i == goalIdx) {					
					System.err.printf("%d",lottoSet[i][j]);
				}
			}
			System.out.println();
		}

	}

}
