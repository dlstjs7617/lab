package lv01;

import java.util.Scanner;

public class Ex20 {
	/*
	 * # 놀이기구 이용제한
	 * 
	 * 1. 키를 입력받는다. 2. 입력받은 키가 120 이상이면, 놀이기구를 이용할 수 있다. 3. 키가 120미만이면, 놀이기구를 이용할 수
	 * 없다. 4. 단, 부모님과 함께 온 경우 놀이기구 이용이 가능하다. 예) 부모님과 함께 오셨나요(yes:1,no :0)
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 1.키를 입력 받는다. 받은 값을 저장할 변수선언 및 초기화
		System.out.print("키 :");
		int height = sc.nextInt();

		// 2.입력 받은 키가 120이상 이면 놀이기구 사용가능 if조건문
		if (height >= 120) {
			System.out.println("놀이기구 이용가능");
		}

		// 3.키가 120이하일시 if조건문
		if (height < 120 && height > 0) {

			// 4. 부모님과 같이왔을 경우 놀이기구 이용가능하니 부모님이 같이왔는지 조건문으로 물어봄
			System.out.print("부모님과 함께 오셨나요(yes:1,no :0) :");

			// 부모동행 여부를 물어본 값을 변수에 선언 및 초기화
			int parent = sc.nextInt();

			// 0과 1을 받을시 실행되는 조건문
			if (parent == 0 || parent == 1) {

				// 부모가 동행안했을시 조건문
				if (parent == 0) {
					System.out.println("놀이기구 이용불가");
				}

				// 부모가 동행했을시 조건문
				if (parent == 1) {
					System.out.println("놀이기구 이용가능");
				}
			}

			// 부모동행 예외 처리
			if (!(parent == 0 || parent == 1)) {
				System.out.println("잘못된 입력");
			}
		}
		// 받은 키 음수값 예외처리
		if (height < 0) {
			System.out.println("잘못된 입력");
		}

	}
}
