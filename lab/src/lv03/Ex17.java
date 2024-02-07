package lv03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex17 {
	
	/*
	 * # 숫자이동[1단계]
	 * 1. 숫자2는 캐릭터이다.
	 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
	 * 	  숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
	 * 3. 단, 좌우 끝에 도달했을 때 예외처리를 해야한다.
	 * 4. {0, 0, 2, 0, 0, 0, 0,}; ==> 왼쪽 ==> {0, 2, 0, 0, 0, 0,};
	 * 
	 */
	public static void main(String[] args) {
		//변수
		// ㄴ 변수
		// ㄴ 상수 : 변수 앞에 final 키워드를 붙여, 수정 불가한 값으로 고정
		//			이름 규칙 -> 변수명 전체 캐릭터를 대문자로 작성 ( 두 개이상의 키워드가 조합 경우,헝가리안)
		//		SIZE, MAP_SIZE
		
		
		
		
		Scanner sc = new Scanner(System.in);
		
		final int SIZE = 7;
		final int PLAYER = 2;
		final int LOAD = 0;
		
		int[] game = {0, 0, 2, 0, 0, 0, 0 };
		
		// 플레이어의 현재 위치(좌표 :인덱스)
		int x= -1;
		
		//플레이어 현재위치 초기화
		// x : 2
		for(int i=0; i<SIZE; i++) {
			if(game[i] == PLAYER)
				x = i;
		}
		
		
		
		
		while(true) {
			System.out.println(Arrays.toString(game));
			System.out.print("1.왼쪽 2.오른쪽 3.종료: ");
			int move = sc.nextInt();
			//플레이어 지우기
			
			game[x]	= LOAD;
			//좌표이동
			if(move == 1) {
				if(x>0)
					x--;
				else
					System.out.println("쾅");
			}else if(move == 2)
				if(x<6)
					x++;
				else
					System.out.println("빠직-");
			game[x] = PLAYER;
		}
	}

}
