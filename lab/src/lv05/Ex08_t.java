package lv05;

import java.util.Random;
import java.util.Scanner;

public class Ex08_t {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		/*
		 *  # 타자연습 게임[1단계]
		 *  1. 문제를 섞는다.(shuffle)
		 *  2. 순서대로 문제를 출제하고, 문제를 다 맞추면 게임 종료
		 *  3. 문제 출제시 랜덤한 위치에 *별 찍기 (캐릭터 숨기기)
		 *  4. 정답이 아니면 별 위치가 변하면 X
		 *  5. words[i]의 문자열과 일치 하면 정답
		 *  예)
		 *  문제 : mysql
		 *  입력 : mydb
		 *  문제 : mysql
		 *  입력 : mysql		<-정답을 맞추면, 다음 문제 제시
		 *  문제 : jsp
		 */
		
		String[] words = {"java", "mysql", "jsp", "spring"};
		
		for(int i=0; i<100; i++) {
			int rIdx = ran.nextInt(words.length);
			String temp = words[0];
			words[0] = words[rIdx];
			words[rIdx] = temp;
		}
		// Play
		for(int i=0; i<words.length; i++) {
			String quiz = words[i];
			while(true) {
				int rIdx = ran.nextInt(quiz.length());	// word[i] 문자열 크기 안에서 인덱스 한 개 뽑기
				System.out.println("문제 : ");
				for(int j=0; j<quiz.length(); j++) {
					if(j == rIdx)
						System.out.print("*");
					else
						System.out.print(quiz.charAt(j));
				}
				System.out.print("\n답안 : ");
				String input = sc.next();
				
				if(quiz.equals(input)) {
					break;
				}
				
			}
			
		}
		System.out.println("GAME CLEAR!");
		
		
	}

}
