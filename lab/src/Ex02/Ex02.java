package Ex02;

public class Ex02 {

	public static void main(String[] args) {
//		문제2) 1~10까지 반복해 3미만 7이상만 출력
//		문제3) 문제2의 조건에 맞는 수들의 합 출력
//		문제4) 문제2이 조건에 맞는수들의 개수출력
		int count=0;
		int sum=0;
		for(int i=1; i<=10; i++) {
			if(i<3 || i>6) {
				System.out.println(i);
				count++;
				sum+=i;
			}
		}
		System.out.printf("문제 3) %d 문제 4) %d",sum,count);

	}

}
