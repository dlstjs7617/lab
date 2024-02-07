package test.lv2;

import java.util.Random;
import java.util.Scanner;

public class Test03 {
	//시작 02:30
	//종료 33:40
	//소요 31:10
	public static void main(String[] args) {
		
		// Lv02 테스트
		
		// 문제 3)
		
		/*
		 * # 카카오 택시
		 * 1. 손님을 태워 목적지까지 이동하는 게임이다.
		 * 2. -10~10 사이의 랜덤 숫자를 2개 저장해 목적지로 설정한다.
		 * 3. 메뉴는 아래와 같다.
		 * 		1) 속도설정 : 1~3까지만 가능
		 * 		2) 방향설정 : 동(1)서(2)남(3)북(4)
		 *		3) 이동하기 : 설정된 방향으로 설정된 속도만큼 이동
		 * 4. 거리 1칸 당 50원씩 추가되어 도착시 요금도 출력한다.
		 */
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		int x = random.nextInt(21)-10;
		int y = random.nextInt(21)-10;
		
		int moveX = 0;
		int moveY = 0;
		
		int speed = 0;
		int vector = 0;
		
		int sel = 0;
		
		int money = 0;
		boolean drive =true;
		
		System.out.println("카카오 택시");
		
		while(true) {
			System.out.printf("목적지 : %d , %d \n", x, y);
			System.out.printf("위치 : %d , %d \n", moveX, moveY);
			System.out.printf("속도 : %d \n" , speed);
			System.out.printf("방향 : 동(1)서(2)남(3)북(4) : %d \n", vector);
			System.out.println("1.속도설정");
			System.out.println("2.방향설정");
			System.out.println("3.이동하기");
			System.out.print("메뉴 선택 : ");
			sel = sc.nextInt();
			if (sel == 1) {
				System.out.print("속도 설정하기 1~3 : ");
				speed = sc.nextInt();
			} else if (sel == 2) {
				System.out.print("방향설정하기 : 동(1)서(2)남(3)북(4) : ");
				vector = sc.nextInt();
			} else if (sel == 3 && speed > 0 && speed <= 3 && vector > 0 && vector <= 4) {
				if (vector == 1) {
					moveX += speed;
					money += (speed * 50);
				} else if (vector == 2) {
					moveX -= speed;
					money += (speed * 50);
				} else if (vector == 3) {
					moveY -= speed;
					money += (speed * 50);
				} else if (vector == 4) {
					moveY += speed;
					money += (speed * 50);
				}
				System.out.println("이동하였습니다");
			}
			if (x == moveX && y == moveY) {
				System.out.println("\n도착하였습니다.");
				System.out.println("요금 : " + money + "원입니다.");
				break;
			}
			System.out.println("");
		}
		
	}

}
