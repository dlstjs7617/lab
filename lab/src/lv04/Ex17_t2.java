package lv04;

import java.util.Random;
import java.util.Scanner;

public class Ex17_t2 {
	/*
	 * # 사다리 게임
	 * 1. 인덱스 0~4를 하나선택한다.
	 * 2. 숫자 0 을 만나면 그냥 아래로 내려간다.
	 * 3. 숫자 1 을 만나면 오른쪽으로 이동후 내려간다.
	 * 4. 숫자 2 를 만나면 왼쪽으로 이동후 내려간다
	 * 5. 오늘의 메뉴 출력
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		final int SIZE = 9;
		final int LEFT = 1;
		final int RIGHT = 2;
		
		int n = 0;
		while(n < 2) {
			System.out.print("참여 인원 수 : ");
			n = sc.nextInt();
		}
		
		
		String menu[] = new String[n]; 		// sc.next()
		boolean[] isOpen = new boolean[n]; 	//{false,false,false}		
			
		//랜덤 사다리 생성
		int[][] ladder = new int[SIZE][n];
		boolean[] isHook = new boolean[n];
		
		for(int y=0; y<SIZE; y++) {
			for(int x=0; x<n -1; x++) {
				// 0 또는 1 -> 고리를 걸 때, 1-2 쌍으로
				ladder[y][x] = (int)(Math.random() *2);
				if(ladder[y][x] == LEFT) {
					isHook[x] = true;
					ladder[y][++x] = RIGHT;
				}
			}
			//맵이 완성된 후 검증
			if(y == SIZE-1) {
				for(int i=0; i<n-1; i++) {
					if(!isHook[i]) {
						System.err.println("사다리 다시 그리기");
						ladder= new int[SIZE][n];
						y = -1;
						break;
					}
				}
			}
		}
		
		// 참여 인원 수많큼 문자열 입력받기
		for(int i=0; i<n; i++) {
			System.out.printf("결과값 %d : ",i+1);
			String str = sc.next();
			
			// 문자열 비교
			// == 사용X 
			// A.equles(B)  A가 B랑 같은 boolean 타입으로 반환
			boolean isDupl = false;
			for(int j=0; j<i; j++) {
				if(str.equals(menu[j]) == true) {
					isDupl = true;
				}
			}
			
			if(!isDupl)
				menu[i] = str;
		}
		
		while(true) {
			//print
			for(int i=0; i<n; i++) {
				System.out.print(i+1 + " ");
			}
			System.out.println();
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<n; j++) {
					if(ladder[i][j] == LEFT)
						System.out.print("├─");
					else if(ladder[i][j] == RIGHT)
						System.out.print("┤ ");
					else
						System.out.print("│ ");
				}
				System.out.println();
			}
			for(int i=0; i<n; i++) {
				if(isOpen[i])
					System.out.print("□ ");
				else
					System.out.print("■ ");					
			}
			//end
			int cnt = 0;
			for(int i=0; i<n; i++) {
				if(isOpen[i])
					cnt++;
			}
			if(cnt == n)
				break;
			
			//input
			System.out.print("\n 번호 선택 : ");
			int x = sc.nextInt() -1;
			
			if(x<0 || x >= n) {
				System.out.printf("입력 범위는 1~%d입니다.", n);
				continue;
			}		
			for(int y=0; y<SIZE; y++) {
				if(ladder[y][x] == LEFT)
					x++;
				else if(ladder[y][x] == RIGHT)
					x--;
			}
			
			if(isOpen[x]) {
				System.out.println("이미 고른 메뉴 입니다.");
			} else {
				System.out.print(menu[x]+" 메뉴 당첨!\n");
				isOpen[x] = true;
			}
				
		}

	}

}
