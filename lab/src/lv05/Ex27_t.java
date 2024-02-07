package lv05;

import java.util.Random;
import java.util.Scanner;

public class Ex27_t {
	// 문제) 영어 단어 맞추기
	// 영어단어가 전부 * 로 표시된다.
	// 영어단어를 입력받고 틀릴때마다 랜덤으로 한글자씩 벗겨진다.(점수는 5점씩 감점)
	// (조건) 만약에 같은 철자가 여러개면 한번에 벗겨진다.
	// 전부 벗겨지거나 맞추면 종료 (점수 출력)	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int score = 100;
		
		String word = "performance";
		String meaning = "공연";
		
		int size = word.length();
		int check[] = new int[size]; // 힌트 체크를 통해서 확인할수있다.
		int open = 0;
		while(true) {
			System.out.println("뜻 : " + meaning);
			
		
		
			System.out.print("문졔 : ");
			for(int i=0; i<size; i++) {
				if(check[i] == 0)
					System.out.print("*");
				else {
					System.out.print(word.charAt(i));
				}
			}
			System.out.println();
			System.out.print("영어 단어를 입력하세요 >>>");
			String input = sc.next();
			
			// 정답이면 종료
			if(input.equals(word))
				break;

			//모든 힌트가 열리면 종료
			if(open == size)
				break;
			
			//랜덤한 위치의 ->캐릭터 오픈(check[rIdx] =1)
			while(true) {
				int rIdx = random.nextInt(size);		//랜덤 인덱스
				
				if(check[rIdx] == 0) {					// 오픈된적 없는 자리를 발견하면
					char target = word.charAt(rIdx);	// 해당 위치의 문자를 기억하고
					
					for(int i=0; i<size; i++) {			// 문자열 전체를 돌면서
						if(target == word.charAt(i)) {  // 기억둔 문자 한 개와 비교하여
							check[i] = 1;				// 해당 위치를 오픈 마킹
							open++;
						}
					}
					break;
				}
			}
		}
		score = open == size ? 0 : score - open*5;
		System.out.printf("%d점",score);
	}

}
