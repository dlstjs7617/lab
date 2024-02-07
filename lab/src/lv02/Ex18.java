package lv02;

public class Ex18 {

	public static void main(String[] args) {
		
		//제어문 : 프로그램의 실행 흐름을 제어하는 문장
		
		// 1. 조건문 :if문, if문 if-else문, switch-case문
		// 2. 반복문 :while문, for문, do-while문
		// 3. 보조제어문 : break, continue
		
		// for문
		// 문법
		// for(초기식; 조건식; 증감식)
		
		int n = 0;								//초기식
		while(n < 5) {							//조건식
			System.out.println(n + 1);
			n++;								//증감식
		}
		
		
		for(int i=0; i< 5; i++) {
			System.out.println(i + 1);
			
		}
		//System.out.println(i);

	}

}
