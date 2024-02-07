package test.lv1;

import java.util.Random;
import java.util.Scanner;

//모든 문제 최상단에 다음 주석 추가 (분:초)

//시작 53:30
//종료 01:10
//소요 07:40
public class Test01 {
	
	public static void main(String[] args) {
		
		// 문제 1)
		// 가위바위보 게임 만들기
		// ㄴ 0(가위) 1(바위) 2(보)
		// com : 랜덤 0~2 추출
		// me : 입력 0~2
		// 승자 출력
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int com = random.nextInt(3);
		
		System.out.print("0(가위)  1(바위)  2(보) ! :  ");
		int me = scanner.nextInt();		
		
		
		if((me == 0 && com == 1) || (me == 1 && com == 2) || (me == 2 && com == 0)) {
			System.out.println("me : " + me + "\tcom : " + com);
			System.out.println("졌다.");
		}else if((me == 0 && com == 2) || (me == 1 && com == 0) || (me == 2 && com == 1)) {
			System.out.println("me : " + me + "\tcom : " + com);
			System.out.println("내가 이겼다");
		}else if(me == com) {
			System.out.println("me : " + me + "\tcom : " + com);
			System.out.println("비겼다");
		}
		
	}

}
