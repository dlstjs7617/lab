package lv04;

public class Ex09 {
	// 특이점 찾기
	public static void main(String[] args) {
		
		int[] arr = {87, 100, 24, 11, 79};
		System.out.println("arr : " + arr); // [I@626b2d4a 주소가출력됌
		
		// arr변수의 자료형 : 정수 배열(의 주소)
		// temp 변수의 자료형 : 정수 배열(의 주소)
		int[] temp = arr; // 주소를 공유받음	
		System.out.println("temp : " + temp);
		
		temp[1] = 0;

		for(int i=0; i<5; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		for(int i=0; i<5; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();
		
		

		// new 객체를 사용하지 않고 같은번지를 참조하기때문에 값이 같이 변한다.
	}

}
