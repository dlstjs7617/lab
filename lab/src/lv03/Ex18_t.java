package lv03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex18_t {
	/*
	 *  # 기억력 게임
	 *  1. 같은 숫자의 위치를 2개입력해 정답을 맞추는 게임이다.
	 *  2. 정답을 맞추면 back에 해당 숫자를 저장해,
	 *     back에 모든 수가 채워지면 게임은 종료된다.
	 *     
	 *  예)
	 *  front = [1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
	 *  back =  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	 *  입력1 : 0
	 *  입력2 :1
	 *  
	 *  front = [1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
	 *  back =  [1, 1, 0, 0, 0, 0, 0, 0, 0, 0]
	 *  
	 */
	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		final int SIZE = 10;
		
		int[] front = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
		int[] back = new int[10];
		
		// 카드 섞기(front)
		// {1, 2, 5, 4, 3, 3, 1, 4, 2, 5}
		for(int shuffle=0; shuffle<100; shuffle++) {
			for(int i=0; i<10; i++) {
				int ran = random.nextInt(10);
				int temp;
				 temp = front[i];
				 front[i] = front[ran];
				 front[ran] = temp;
			}
		}
		
		int correct = 0;
		
		boolean isRun = true;
		while(isRun) {
			//번호 출력
			System.out.print("num : \n[");
			for(int i=0; i<SIZE; i++) {
				System.out.print(i);
				if(i< SIZE -1)
					System.out.print(", ");
			}
			
			System.out.print("]\n");
			
			// 카드 출력
			System.out.println(Arrays.toString(front));
			System.out.println(Arrays.toString(back));
			
			// 입력 받기
			System.out.print("idx1 :");
			int idx1 = sc.nextInt();
			System.out.print("idx2 :");
			int idx2 = sc.nextInt();
			
			// 예외 처리 1. 인덱스 범주
			if(idx1 < 0 || idx1 > SIZE- 1 || idx2 < 0 || idx2 > SIZE-1 || idx1 == idx2) {
				System.out.println("인덱스 범주를 다시 확인하세요.");
				continue;
			}
			
			// 예외 처리 2. 이미 뒤집힌 카드
			if(back[idx1] != 0) {
				System.out.println("이미 뒤집힌 카드입니다.");
				continue;
			}
			
			// 예외처리 3. 오답
			if(front[idx1] != front[idx2]) {
				System.out.println("떙-");
				continue;
			}
		
			// 카드 뒤집기
			back[idx1] = 1;
			back[idx2] = 1;
			correct ++;
			
			// 종료 조건
			if(correct == SIZE/2) {
				System.out.println("GAME CLEAR~");
				isRun = false;
			}
		}
		
	}

}
