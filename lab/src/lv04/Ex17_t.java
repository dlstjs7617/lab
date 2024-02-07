package lv04;

import java.util.Random;
import java.util.Scanner;

public class Ex17_t {
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
		for(int i=0; i<n; i++) {
			System.out.print("메뉴 입력 : ");
			String input = sc.next();
			menu[i] = input;
			System.out.println();
		}
		
		boolean[] isOpen = new boolean[n]; 	//{false,false,false}
			
		int ladder[][] = null;
		//랜덤 사다리 생성
		while(true) {
			boolean[] check = new boolean[n]; 	//{false,false,false}
			ladder = new int[SIZE][n];
//			int check = 0;
			int temp = 0;
			for(int i=0; i<SIZE; i++) {
				// 랜덤값 입력 맨 우측 1번 안나오게
				for(int j=0; j<n; j++) {
					int ran = random.nextInt(2);
					ladder[i][j] = ran;
					if(j == n-1) {
						ladder[i][j] = 0;
					}
					if(ladder[i][j] == LEFT) {
						ladder[i][j+1] = RIGHT;
						j++;
					}
				}					
				
				
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<SIZE; j++) {
					if(ladder[j][i] == LEFT) {
						check[i] = true;
					}
				}
			}
			for(int i=0; i<check.length; i++) {
				if(check[i] == true)
					temp++;
			}
			System.out.println(temp);
			if(temp == n-1)
				break;
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
				System.out.println("입력 범위는 1~5입니다.");
				continue;
			}
//			for(int i=0; i<menu.length; i++) {
//				if(isOpen[i] == false)
//					System.out.print(" ■ ");
//				else {
//					System.out.print("(" + x + ")" + menu[i]);
//				}
//			}
//			
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
