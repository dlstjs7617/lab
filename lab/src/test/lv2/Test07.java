package test.lv2;

public class Test07 {
	//시작 59:00
	//종료 20:00
	//소요 21:00
	public static void main(String[] args) {
		
		// Lv02 테스트
		
		// 문제 7
		
		System.out.println("==============문제1================");
		// -1. 36의 약수 를 전부 출력
		// 약수는 36과 나눠서 나머지가 0인수를 말한다.
		// 1,2,4,6...
		int x = 36;
		for(int i=1; i<=36; i++) {
			if(x%i == 0) {
				System.out.println(i);
			}
		}
		System.out.println("==============문제2================");
		// -2. 24의 약수중에서 2의 배수만출력
		x =24;
		for(int i=1; i<=24; i++) {
			if(x % i == 0 && i % 2 == 0) {
				System.out.println(i);
			}
		}
		System.out.println("==============문제3================");
		// -3. 18의 약수의 갯수 더하기 21의 약수의 갯수를 출력
		x = 18;
		int y =21;
		int count=0;
		
		for(int i=1; i<=18; i++) {
			if(x%i == 0) {
				count++;
			}
		}
		for(int i=1; i<=21; i++) {
			if(y%i == 0) {
				count++;
			}
		}
		System.out.println("18의 약수 + 21의 약수 = " + count);
		
		
		System.out.println("==============문제4================");
		// -4. 50 부터 100까지의 자연수중에서 9의 배수는 모두 몇개?
		count = 0;
		for(int i=50; i<=100; i++) {
			if(i%9 == 0) {
				count++;
			}
		}
		System.out.println("9의 배수의 갯수 : " + count);
		
		
	}

}
