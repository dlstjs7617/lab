package lv06;


class MyClass{
	int[] arr = { 87, 100, 11, 72, 92 };
}

public class Ex02 {

	public static void main(String[] args) {
		
		MyClass myClass = new MyClass();
		int sum = 0;
		int cnt = 0;
		// 문제 1) 전체 합 출력
		// 정답 1) 362
		for(int i=0; i<myClass.arr.length; i++) {
			sum += myClass.arr[i];
		}
		System.out.println(sum);
		
		sum = 0;
		
		// 문제 2) 4의 배수의 합 출력
		// 정답 2) 264
		for(int i=0; i<myClass.arr.length; i++) {
			if(myClass.arr[i] % 4 == 0)
				sum += myClass.arr[i];
		}
		System.out.println(sum);
		
		sum = 0;
		
		// 문제 3) 4의 배수의 개수 출력
		// 정답 3) 3
		for(int i=0; i<myClass.arr.length; i++) {
			if(myClass.arr[i] % 4 == 0)
				cnt++;
		}
		System.out.println(cnt);
		
		cnt = 0;
		// 문제 4) 짝수의 개수 출력
		// 정답 4) 3
		for(int i=0; i<myClass.arr.length; i++) {
			if(myClass.arr[i] % 2 == 0)
				cnt++;
		}
		System.out.println(cnt);
	}

}
