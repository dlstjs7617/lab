package lv06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * # 더하기 게임
 * 1. 1부터 10 사이의 랜덤한 값을 중복 없이 game 배열에 6개 저장한다.
 * 2. 6개의 배열의 인덱스를 0부터 5사이의 랜덤 값 3개를 중복 없이 선택해
 *    그 인덱스 값의 합을 출력한다.
 * 3. 사용자는 중복없이 3개의 인덱스를 골라 그 합을 맞추는 게임이다. 
 *   예) 4, 7, 5, 3, 2, 9 // 문제 : 12 ===> 인덱스 3개를 골라서 합을 맞추면 된다.
 *   정답) 1, 3, 4 (여러가지 경우의 수가 나올수는있다)
 */

class Game{
	
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);
	
	int total;
	int win;
	
	int[] game = new int[6];
	int[] idx = new int[3];
	int[] myIdx = new int[3];
	void run() {
		
		for(int i=0; i<game.length; i++) {
			int rNum = ran.nextInt(10)+1;
			game[i] = rNum;
			
			for(int j=0; j<i; j++) {
				if(game[i] == game[j])
					i--;
			}
			
		}
		
		for(int i=0; i<idx.length; i++) {
			int rIdx = ran.nextInt(6);
			
			idx[i] = game[rIdx];
			total += game[rIdx];
			
			for(int j=0; j<i; j++) {
				if(idx[i] == idx[j]) {
					i--;
					total -= game[rIdx];
					break;
				}
			}
		}
		
		
		
		while(true) {
			System.out.println(Arrays.toString(idx));
			System.out.println(Arrays.toString(myIdx));
			System.out.println("===== 인덱스번호 =====");
			System.out.println(" 1  2  3  4  5  6  ");
			System.out.println(Arrays.toString(game) + " ===> " + total);
			System.out.println("===================");
			
//			System.out.print("첫번째 인덱스 선택 : ");
//			myIdx[0] = game[sc.nextInt()-1];
//			System.out.print("두번째 인덱스 선택 : ");
//			myIdx[1] = game[sc.nextInt()-1];
//			System.out.print("세번째 인덱스 선택 : ");
//			myIdx[2] = game[sc.nextInt()-1];
			
			
			for(int i=0; i<myIdx.length; i++) {
				System.out.printf("%d번째 인덱스 : ",i+1);
				myIdx[i] = game[sc.nextInt()-1];
				
				for(int j=0; j<i; j++) {
					if(myIdx[i] == myIdx[j]) {
						System.err.println("중복된 인덱스 값입니다.");
						i--;
						break;
					}
				}
				
			}
			
			
			int cnt = 0;
			int sum = 0;
			for(int i=0; i<myIdx.length; i++) {
				for(int j=i+1; j<myIdx.length; j++)
				if(myIdx[i] == idx[j]) {
					cnt++;
				}
				
				sum +=myIdx[i];
			}
			
			
			
			if(cnt == 3 || sum == total) {
				System.out.println("정답입니다");
				break;
			}else {
				System.err.println("오답입니다.");
			}
		}
		
		
	}
	
	
}


public class Ex05 {

	public static void main(String[] args) {
		
		Game game = new Game();
		game.run();
	}

}
