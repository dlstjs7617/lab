package test.lv5;

import java.util.Random;

public class test04 {
	//시작 14:10
	//종료 14:56
	//소요 00:36
	public static void main(String[] args) {
		//4.
		//경마 게임
		// ㄴ 5마리의 말이 랜덤으로 한번에 일정거리 이동가능하다.
		// ㄴ 각 말에 대한 등수 출력
		// 조건)단! 동시도착 예외처리
		Random ran = new Random();
		
		
		final int FINISH = 20;
		final int HORSE = 5;
		
		int rank[] = new int[HORSE];
		int x[] = new int[HORSE];
		
		int[][] race = new int[HORSE][FINISH];
		
		int rankCnt = 1;
		
		while(true) {
			System.out.println("=========경마=========");
			for(int i=0; i<HORSE; i++) {
				System.out.printf("%d번",i+1);
				for(int j=0; j<FINISH; j++	) {
					if(x[i] == j) {
						System.out.print("말");
					}else {
						System.out.print("-");
					}
				}
				System.out.println();
			}	
			System.out.println("=========경마=========");
			System.out.println();
			
			if(rankCnt > 5) {
				break;
			}
			
			
			boolean isGoal = false;
			for(int i=0; i<HORSE; i++) {
				int run = ran.nextInt(4);
				
				if(x[i] < FINISH-1)
					x[i] += run;
				
				if(!isGoal && x[i] >= FINISH-1 && rank[i] == 0) {
					x[i] = FINISH-1;
					isGoal = true;
					rank[i] = rankCnt++;
				}else if(isGoal && x[i] >= FINISH-1 && rank[i] == 0){
					x[i] -= run;
					i--;
				}
				
			}
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		for(int i=0; i<HORSE; i++) {
			System.out.printf("%d번말 %d등 \n",i+1,rank[i]);
		}
	}
}
