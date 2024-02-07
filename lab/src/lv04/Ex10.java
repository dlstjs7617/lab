package lv04;

import java.util.Arrays;
import java.util.Scanner;

public class Ex10 {
	/*
	 * # 배열 컨트롤러[2단계] : 벡터(Vector)
	 * 1. 추가
	 * . 값을 입력받아 순차적으로 추가
	 * 2. 삭제(인덱스)
	 * . 인덱스를 입력받아 해당 위치의 값 삭제
	 * 3. 삭제(값)
	 * . 값을 입력받아 삭제
	 * . 없는 값 입력 시 예외처리
	 * 4. 삽입
	 * . 인덱스와 값을 입력받아 삽입
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] score = null;
		int count = 0;
		
		while(true) {
			
			System.out.println(Arrays.toString(score));
			
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			
			if(count == 0 && (sel == 2 || sel == 3 )) { // 배열이 없을때 예외처리
				System.out.println("배열의 길이가 없습니다.");
				continue;
			}
			
			if(sel == 1) {			//추가
				System.out.print("넣을 값을 입력하세요 : ");
				int input = sc.nextInt();
				int temp[] = score;
				score = new int[count+1];
				score[count] = input;
				for(int i=0; i<count; i++) {
					score[i] = temp[i];
				}
				count++;
				
			}else if(sel == 2) {	//삭제
				System.out.print("삭제할 인덱스 입력 : ");
				int idx = sc.nextInt();
				
				if(idx < 0 || idx > count) { // 인덱스범위 예외처리
					System.out.println("잘못된 인덱스값입니다.");
					continue;					
				}
				//삭제할 인덱스까지 한칸씩 당기기
				score[idx] = 0;
				
				System.out.println(Arrays.toString(score));
				//배열 주소복사후 줄어든 배열 생성후 복사
				int temp[] = score;
				count--;
				score = new int[count];
				for(int i=0; i<count; i++) {
					if(temp[i] == 0) { 
						score[i] = temp[i+1];
						temp[i+1] = 0;
					}else
						score[i] = temp[i];
					
				}
				
			}else if(sel == 3) { // 값 삭제
				System.out.print("삭제할 값 입력 : ");
				int input = sc.nextInt();
				int idx = -1;
				
				while(true) {					
					int cnt = 0;
					for(int i=0; i<count; i++) {
						if(input == score[i]) {
							idx = i;
							cnt++;							
						}	
					}
					if(idx == -1) {
						System.out.println("없는 값입니다.");
						break;
					}
					if(cnt != 0)
						score[idx] = 0;
					for(int i=0; i<count-1; i++) {
						if(score[i] == 0) {
							score[i] = score[i+1];
							score[i+1] = 0;
						}
					}
					if(cnt == 0)
						break;
					count--;
					
				}
				int temp[] = score;
				score = new int[count];
				for(int i=0; i<count; i++) {
					score[i] = temp[i];
				}
				
			}else if(sel == 4) { // 배열길이를 늘리고 삽입할 인덱스부터 뒤로 하나씩밀어서 인덱스에 삽입
				System.out.print("삽입할 인덱스를 입력해주세요 : ");
				int idx = sc.nextInt();
				System.out.print("삽입할 값를 입력해주세요 : ");
				int num = sc.nextInt();
				
				if(idx < 0 || idx > count) {
					System.out.println("잘못된 인덱스입니다.");
					continue;
				}
				
				int temp[] = score;
				score = new int[count+1];
				for(int i=0; i<count; i++) {
					score[i] = temp[i];
				}
				for(int i=count-1; i>=idx; i--) {
					score[i+1] = score[i];
				}
				score[idx] = num;
				
				count++;
				
			}else if(sel == 0) {
				break;
			}
			
		}

	}

}
