package lv03;

public class Ex01 {

	public static void main(String[] args) {
		
		// 변수 : 값을 한 개 저장하는 것
		
		// 배열 : 값을 여러개 저장하는 것
		
		// 선언과 초기화
		// 자료형키워드 변수명 = new 자료형키워드[개수]
		
		int[] arr = new int[3];
//		int[] arr = {1,2,3};
		// 사용 방법
		// *인덱스 index (방의 번호, 0부터 시작)
		// 배열변수명[인덱스]
		
		
		// 배열의 값 초기화
		// 1~3까지로 초기화
		
		for(int i=0; i<3; i++) {
			arr[i] = i+1;
		}
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println("===================");
//		for(int i=0; i<arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//		
//		System.out.println("===================");
//		for(int i=0; i<3; i++) {
//			System.out.println(arr[i]);
//		}
//		System.out.println("===================");
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
//		System.out.println("===================");
//		int count = 0;
//		while(count < 3) {
//			System.out.println(arr[count]);
//			count++;
//		}
//		
	}

}
