package test.lv4;

// 시작 03:30
// 종료 23:57
// 소요 20:27
public class Test01 {

	public static void main(String[] args) {
		// 1.
		/*
		 * # 석차 출력
		 * . 성적 순으로 이름 출력
		 * 
		 */
		
		String[] name = {"홍길동", "김영", "자바킹", "민병철", "메가맨"};
		int [] score = {	87,		42,		100,	  11,	  98};
		int max = 0;
		
		
		for(int i=0; i<score.length; i++) {
			max = 0;
			int idx= -1;
			for(int j=i; j<score.length; j++) {
				if(max < score[j]) {
					max = score[j];
					idx = j;					
				}
					
			}
			score[idx] = score[i];
			score[i] = max;
			String temp = name[idx];
			name[idx] = name[i];
			name[i] = temp;
			System.out.printf("석차출력 %d등 %d점  %s \n", i+1, score[i], name[i]);
		}
	}

}
