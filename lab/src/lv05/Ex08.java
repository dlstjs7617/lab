package lv05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex08 {

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
			int ranNum = ran.nextInt(4);
			int ranNum2 = ran.nextInt(4);
			String tmp = "";
			tmp = words[ranNum];
			words[ranNum] = words[ranNum2];
			words[ranNum2] = tmp;
		}
		System.out.println(Arrays.toString(words));
		
		int cnt =0;
		int ranNum3 = ran.nextInt(words[cnt].length());
		while(true) { 
			String temp = words[cnt].substring(0,ranNum3)+"*"+words[cnt].substring(ranNum3+1,words[cnt].length());
			System.out.println("문제 : " + temp);
			System.out.print("입력 : ");
			String answer = sc.next();
			
			
			if(answer.equals(words[cnt])) {
				cnt++;
				System.out.println("정답");
				if(cnt != words.length)
					ranNum3 = ran.nextInt(words[cnt].length());
			}else {
				System.err.println("오답");
			}
			
			if(cnt == words.length)
				break;
			
		}
		System.out.println("GAME CLEAR");
		
		
	}

}
