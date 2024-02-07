package lv05;

import java.util.Arrays;
import java.util.Random;

public class Ex29 {
	
	// # 경마 게임
	// 5마리의 말이 랜덤으로 한번에 일정거리 이동가능하다.(0~3 범위)
	// 이동한거리의 합이 20이상이면 도착
	// 등수출력
	// 조건) 단! 동시도착 예외처리
	
	public static void main(String[] args) {
		Random ran = new Random();
		
		final int MAX = 20;
		int horse[][] = new int[5][MAX];
		
		int rank[] = new int[5];		//말의 등수 기록
		int total[] = new int[5];		//현재 뛰고있는 좌표
		

		int win = 1;
		while(true) {
			// 레이스 출력문
			System.out.println("==========레이스===========");
			for(int i=0; i<horse.length; i++) {
				for(int j=0; j<horse[i].length; j++) {
					if(total[i] == j)
						System.out.print("말");
					else
						System.out.print("--");
				}
				System.out.println();
			}
			
			if(win > 5)
				break;
			
			// 랜덤값 증가
			int cnt = 0;
			for(int i=0; i<total.length; i++) {
				int temp = total[i];
				int rIdx = ran.nextInt(3)+1;
				if(total[i] < MAX-1) {
					total[i] += rIdx;
					if(total[i] >= MAX-1)
						cnt++;
				}
				if(total[i] >= MAX-1){
					total[i] = MAX-1;
					if(rank[i] == 0 && cnt == 1)
						rank[i] = win++;										
				}
				if(cnt > 1) {
					total[i] = temp;
					cnt--;					
				}
			}
			
			try {
				Thread.sleep(500);   //딜레이를 걸 시간을 ms 밀리세컨드 1/1000초
			} catch (Exception e) {

			}
			
		}
		for(int i=0; i<rank.length; i++) {
			System.out.printf("%d번말 %d등 \n", i+1, rank[i]);			
		}
		
	}

}
