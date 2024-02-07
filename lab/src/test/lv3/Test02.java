package test.lv3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test02 {
	//시작 25:00
	//종료 40:50
	//소요 15:50
	public static void main(String[] args) {
		//Level Test 3
		
		// 2.
		
		/*
		 *  1 to 4
		 *  1. arr배열에 1~4 사이의 숫자를 중복없이 랜덤으로 저장한다.
		 *  2. 사용자는 1부터 순서대로 해당 위치 값을 입력한다.
		 *  3. 정답을 맞추면 해당 값은 9로 변경되어 모든 값이 9가 되면 게임은 종료된다.
		 *  
		 *  예)
		 *  4 2 3 1
		 *  입력 : 3
		 *  4 2 3 9
		 *  입력 : 1
		 *  4 9 3 9
		 *  ...
		 */
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		
		int[] arr = new int[4];
		int[] chk = new int[4];
		
		for(int i=0; i<4; i++) {
			int ran = random.nextInt(4)+1;
			if(chk[ran-1] == 0) {
				arr[i] = ran;
				chk[ran-1] = 1;
			}else{
				i--;
			}
		}
		
		boolean isRun = true;
		int cnt = 1;
		while(isRun) {
			System.out.println(Arrays.toString(arr));
			System.out.print("숫자 순서맞추기 : ");	
			int input = sc.nextInt();
			
			if(input < 0 || input >=4)
				continue;
			
			if(arr[input] == cnt ) {
				System.out.println("맞췄습니다.");
				arr[input] = 9;
				cnt++;
			}else {
				System.err.println("틀렸습니다.");
			}
			
			if(cnt == 5) {
				System.out.println("게임종료");
				break;
			}
		}
	}

}
