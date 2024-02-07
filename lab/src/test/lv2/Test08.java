package test.lv2;

public class Test08 {
	//시작 21:00
	//종료 14:00
	//소요 53:00
	public static void main(String[] args) {
		
		// Lv02테스트
		// 문제 8)
		
		
		// -1. 7의 배수를 차례대로 출력했을때 8번째 배수를 출력
		System.out.println("==============문제1================");
		int count = 0;
		for(int i=1; true; i++) {
			if(i % 7 == 0) {
				count++;
			}
			if(count == 8) {
				System.out.println("7의 8번째 배수 : " + i);
				break;
			}
		}
		
		// -2. 6과 8의 공약수를 모두 출력
		// 공약수란 각수의 공통인 약수를 말한다.
		// 예)	6 ==> 1, 2, 3, 6
		//		8 ==> 1, 2, 4, 8
		//		공약수는 1, 2
		System.out.println("==============문제2================");

		int x = 6;
		int y = 8;
		int max = 0;
		for(int i=1; i<=x; i++) {
			if(x % i == 0 && y % i == 0) {
				if(max < i) {
					max = i;
				}
				System.out.println("공약수는 " + i);
			}
		}
		
		// -3. 위 수의 최대 공약수 출력
		// 최대 공약수란 공약수중에서 가장큰수
		System.out.println("==============문제3================");
		
		System.out.println("최대 공약수는 : " +max);
		
		// -4. 25, 75 의 최대 공약수를 출력
		System.out.println("==============문제4================");
		x = 25;
		y = 75;
		max = 0;
		for(int i=1; i<=x; i++) {
			if(x % i == 0 && y % i == 0) {
				if(max < i) {
					max = i;
				}
			}
		}
		System.out.println("최대 공약수는 " + max);
		
		
		
		// -5. 연필 42자루와 지우개 28개를 최대한 많은 학생에가 남기도록 똑같이 나누어 주려고합니다.
		// 몇 명까지 나누어 줄 수 있는지 출력
		System.out.println("==============문제5================");
		
		x = 42;
		y = 28;
		max = 0;
		for(int i=1; i<=x; i++) {
			if(x % i == 0 && y % i == 0) {
				if(max < i) {
					max = i;
				}
			}
		}
		System.out.println("최대로 똑같이 나눌수 있는 학생수 : " + max);
		
	}

}
