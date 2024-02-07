package lv02;

public class Ex08 {

	public static void main(String[] args) {
		//문제4) 50에서 100까지 자연수중에서 9의 배수의 개수를 출력 # 답 : 6 (54,63,72,81,90,99)
		int n = 50;
		while(n <= 100) {
			n++;
			if(n % 9 == 0) {
				System.out.printf(n+ " ");
			}
		}
		//문제5) 28의 배수 중에서 가장 큰 세자리 수를 출력 ==> 답 :980
		boolean isRun = true;

		System.out.println();
		n = 1000;
		while(isRun) {
			n--;
			if(n % 28 == 0) {
				System.out.println(n);
				isRun = false;
			}
		}
		//문제6) 8의 배수를 작은수부터 5개 출력 ==> 답 : 8, 16, 24, 32, 40
		
		n = 1;
		int count = 0;
		while(count != 5) {
			n++;
			if(n % 8 == 0) {
				System.out.print(n + " ");
				count++;
			}
		}
		
	}

}
