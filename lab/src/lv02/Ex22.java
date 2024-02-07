package lv02;

public class Ex22 {

	public static void main(String[] args) {
		
		// 제어문 : 프로그램의 실행 흐름 제어
		
		//1. 조건문: if문, if-else문, switch-case 문
		//2. 반복문:  while문, for문, do-while문
		//3. 보조제어문: break, continue
		
		//do-while문
		
		boolean isRun = true;
		
		while(isRun) {
			System.out.println("실행문");
			isRun = false;
		}
		
		do {
			System.out.println("실행문");
		}while(isRun);
		
		// switch-case문
		
		int grade = 2;
		
		// 1: VIP
		// 2: gold 
		// 3: Silver
		switch (grade) {
		
		case 1 :
			System.out.println("VIP 회원의 혜택을 받습니다.");
			break;
		case 2 :
			System.out.println("GOLD 회원의 혜택을 받습니다.");
			break;
		case 3 :
			System.out.println("SILVER 회원의 혜택을 받습니다.");
			break;
		default:
			System.out.println("일반 회원의 혜택을 받습니다.");
			break;
		}
		
	}

}
