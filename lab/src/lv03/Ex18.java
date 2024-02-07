package lv03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex18 {
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
		
		boolean isRun = true;
		int cnt = 0;
		while(isRun) {
			System.out.println(Arrays.toString(front));
			System.out.println(Arrays.toString(back));
			System.out.print("뒤집을 카드1 : 선택 : ");
			int card1 = sc.nextInt();
			System.out.print("뒤집을 카드2 : 선택 : ");
			int card2 = sc.nextInt();
			
			
			if(card1 < 0 || card1 >=10 || card2 < 0 || card2 >=10 ) {
				System.err.println("뒤집은 카드값이 범위 밖입니다.");
			}else if(card1 == card2) {
				System.err.println("동일한 카드를 선택할수 없습니다.");				
			}else if(back[card1] == 1 || back[card2] == 1) {
				System.err.println("이미 뒤집은 카드가 포함되어 있습니다.");
			}else if(front[card1] == front[card2]) {
				back[card1] = 1; 
				back[card2] = 1; 
			}else {
				System.err.println("뒤집은 카드가 일치하지 않습니다.");
			}
			
			for(int i=0; i<10; i++) {
				if(back[i] == 1) {
					cnt++;
					if(cnt == 10) {
						isRun = false;
						System.out.println(" ");
						System.out.println("=========게임 종료=========");
						System.out.println("전부 맞췄다.");
					}
				}else {
					cnt = 0;
				}
			}
		}

		System.out.println(Arrays.toString(front));
		System.out.println(Arrays.toString(back));
	}

}
