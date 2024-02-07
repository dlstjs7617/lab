package test.lv1;

import java.util.Scanner;

public class Test03 {
	// 모든 문제 최상단에 다음 주석 추가 (분:초)

	// 시작 52:50
	// 종료 59:30
	// 소요 06:40
	public static void main(String[] args) {
		
		// 문제 3)
		/*
		 * # 놀이기구 이용제한
		 * 1. 키를 입력받는다.
		 * 2. 입력받은 키가 120 이상이면 놀이기구를 이용 할 수 있다.
		 * 3. 키가 120 미만이면, 놀이기구를 이용 할 수 없다.
		 * 4. 단, 부모님과 함께 온 경우 놀이기구 이용이 가능하다.
		 * 	  예) 부모님과 함께 오셨나요?(yes:1, no:0)
		 */
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("놀이기구 이용제한 120cm이상");
		System.out.print("키를 입력해 주세요 : ");
		
		int height = scanner.nextInt();
		
		if(height >= 120) {
			System.out.println("놀이 기구 이용이 가능합니다.");
		}else if(height >0 && height < 120) {
			System.out.println("부모님 동반시 입장가능합니다.");
			System.out.print("부노님과 함께 오셨나요?(yes : 1,   no : 0)   :");
			int inputParent = scanner.nextInt();
			if(inputParent == 1) {
				System.out.println("놀이 기구 이용이 가능합니다.");
			}else {
				System.out.println("놀이 기구 이용이 불가능합니다.");
			}
		}else {
			System.out.println("입력 오류 다시입력해주세요.");
		}	
	}

}
