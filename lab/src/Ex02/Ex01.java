package Ex02;

public class Ex01 {

	public static void main(String[] args) { 
		//문제1) 1~10까지 반복해 5~9 출력
		for(int i=0; i <= 10; i++) {
			if(i >= 5 && i < 10) {
				System.out.println(i);
				break;
			}
		}
		//문제2) 10~1까지 반복해 6~3 거꾸로 출력
		for(int i=10; i > 0; i--) {
			if(i >= 3 && i < 7) {
				System.out.println(i);
				break;
			}
		}
		//문제3) 1~10까지 반복해 짝수만 출력
		for(int i=1; i<=10; i++) {
			if(i%2 == 0)
				System.out.println(i);
		}
	}

}
