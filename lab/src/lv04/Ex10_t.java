package lv04;

import java.util.Arrays;
import java.util.Scanner;

public class Ex10_t {
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
				System.out.print("추가할 값  :");
				int data = sc.nextInt();
				
				int[] temp = score;
				score = new int[count+1];
				
				//구 주소에 있는 값들을 새 주소에 복사
				for(int i=0; i<count; i++)
					score[i] = temp[i];
				
				score[count] = data;
				count++;
			}else if(sel == 2) {
				System.out.print("삭제할 인덱스 : ");
				int delIdx = sc.nextInt();
				
				if(delIdx < 0 || delIdx >= count)
					continue;
				
				int[] temp = score;
				score = new int[count-1];
				
				int idx = 0;
				for(int i=0; i<count; i++) { // i : temp 배열의 인덱스
					if(i != delIdx)
						score[idx++] = temp[i];
				}
				count--;
				
			}else if(sel == 3) {
				// {1,2,3,1,1,1}
				// delData : 1
				// delIdx : 0-> 3,4,5
				// {1,2,3,1,1}
				
				
				System.out.print("삭제할 값 : ");
				int delData = sc.nextInt();
				
				// 삭제할 개수 확인
				int delCnt = 0;
				for(int i=0; i<count; i++)
					if(score[i] == delData)
						delCnt++;
				
				// 새로 이사갈 집의 규모를 알 수 0
				int[] temp = score;
				score = new int[count-delCnt];
				
				// 값 옮기기(싹제할 값만 뺴고
				int idx = 0;
				for(int i=0; i<count; i++) 
					if(temp[i] != delData)
						score[idx ++] = temp[i];
				
				count -=delCnt;
				
				/*				
				
				int delIdx = -1;
				for(int i=0; i<count; i++)
					if(score[i] == delData)
						delIdx = i;
				
				if(delIdx == -1)
					continue;
				
				int[] temp = score;
				score = new int[count-1];
				
				int idx = 0;
				for(int i=0; i<count; i++) {
					if(i != delIdx)
						score[idx++] = temp[i];
				}
				count--;
				 */
				
			}else if(sel == 4) {
				System.out.print("삽입할 인덱스 : ");
				int index = sc.nextInt();
				System.out.print("삽입할 값 : ");
				int data = sc.nextInt();
				
				if(index < 0 || index >= count)
					continue;
				
				int[] temp = score;
				score = new int[count+1];
				
				for(int i=0; i<count; i++) {
					if(i < index)
						score[i] = temp[i];
					else
						score[i+1] = temp[i];
				}
				score[index] = data;
				count++;
				
			}else if(sel == 0) {
				break;
			}
			
		}

	}

}
