package lv05;

import java.util.Random;
import java.util.Scanner;

public class Ex27 {
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
		boolean answer = false;
		boolean wrong = false;
		boolean star = true;
		while(true) {
			System.out.println("뜻 : " + meaning);
			
			// 틀릴때마다 별표지우기
			while(wrong) {
				int idx = random.nextInt(size);
				if(check[idx] == 0) {
					check[idx] = 1;
					//중복단어 처리
					for(int i=0; i<size; i++) {
						if(word.charAt(idx) == word.charAt(i)) {
							check[i] = 1;
						}
						//check 전체확인 카운트
						if(check[i] == 0)
							star = true;
					}
					wrong = false;
					break;
				}else 
					continue;
			}
			
			// 모든 별표 사라질시
			if(!star) {
				System.err.println("모든 기회 소진 GAME OVER");
				System.out.println("정답 : " + word);
				break;
			}
			
			System.out.print("문졔 : ");
			for(int i=0; i<size; i++) {
				if(check[i] != 1)
					System.out.print("*");
				else {
					System.out.print(word.charAt(i));
				}
			}
			System.out.println();
			System.out.print("영어 단어를 입력하세요 >>>");
			String input = sc.next();
			
			// 글자수다를시 예외처리
			if(input.length() != size) {
				System.out.println("틀렸습니다.");
				score -= 5;
				wrong = true;
				continue;
			}
			
			//정답 확인
			if(input.equals(word)) {
				answer = true;
			}
			
			//정답일시 break;
			if(answer) {
				System.out.println("정답입니다.");
				System.out.println("점수 : " + score);
				break;
			}else {
				wrong = true;
				score -= 5;
			}
		}
	}

}
