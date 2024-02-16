package lv06;


class MyClass_t{
	int[] arr = { 87, 100, 11, 72, 92 };
}

public class Ex02_t {

	public static void main(String[] args) {
		
		// 클래스로 객체를 생성(인스턴스)
		// ㄴ 생성된 객체를 -> 참조변수에 담고, 
		MyClass_t MyClass_t = new MyClass_t();
		
		// ㄴ 참조변수를 통해 배열의 인스턴스를 ->arr 변수에 담음
		int[] arr= MyClass_t.arr;
		
		int sum = 0;
		int fourthSum = 0;
		int cnt = 0;
		int fourthCnt = 0;
		
		// 문제 1) 전체 합 출력
		// 정답 1) 362

		// 문제 2) 4의 배수의 합 출력
		// 정답 2) 264
		
		// 문제 3) 4의 배수의 개수 출력
		// 정답 3) 3

		// 문제 4) 짝수의 개수 출력
		// 정답 4) 3
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			
			if(arr[i] % 4 == 0) {
				fourthSum += arr[i];
				fourthCnt++;
			}
			
			if(arr[i] % 2 == 0)
				cnt++;
			
		}
		System.out.println(sum);
		System.out.println(fourthSum);
		System.out.println(fourthCnt);
		System.out.println(cnt);
	}

}
