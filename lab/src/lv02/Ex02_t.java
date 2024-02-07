package lv02;

public class Ex02_t {

	public static void main(String[] args) {
		
		// 문제1) 1~10까지 반복해 5~9 출력
		// 정답1) 5,6,7,8,9
		int num = 1;
		while(num <= 10) {
			// num : 1~10
			if(num >= 5 && num < 10) {
				System.out.print(num);
			}
			num += 1;
		}
		System.out.println("");
		
		// 문제2) 10~1까지 반복해 6~3 거꾸로 출력
		// 정답2) 6,5,4,3
		num = 10;
		while(num > 0) {
			// num : 10~1
			if(num >= 3 && num < 7) {
				System.out.print(num);
			}
			num -= 1;
		}
		System.out.println("");

		// 문제3) 1~10까지 반복해 짤수만 출력
		// 정답3) 2, 4, 6, 8, 10
		num = 1;
		while(num <= 10) {
			// num : 1~10
			if(num % 2 == 0) {
				System.err.print(num + " ");
			}
			num+= 1;
		}
	}

}
