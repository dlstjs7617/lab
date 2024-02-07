package lv02;

public class Ex21_t {

	public static void main(String[] args) {
		
		// for문과 보조제어문 활용
		
		// for를 사용해서 풀어보세요
		// 문제1) 9의 배수중 일의 자리가 6인 첫번째 배수 출력 ==> 답 :36
		for(int i=0; true; i+= 9) {
			if(i%10 == 6) {
				System.out.println(i);
				break;
			}
		}
		// 문제2) 9의 배수중 십의 자리가 6인 첫번째 배수 출력 ==> 답 :63
		for(int i=0; true; i++) {
			if(i % 9 == 0 && i / 10 == 6) {
				System.out.println(i);
				break;
			}
		}
		
		// 문제3) 8의 배수중 150보다 작고 150에 가장 가까운 수를 출력 ==> 답 :144
		for(int i=149; ; i--) {
			if(i % 8 ==0) {
				System.out.println(i);
				break;
			}
		}


		
	}

}
