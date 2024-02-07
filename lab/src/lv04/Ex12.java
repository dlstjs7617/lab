package lv04;

import java.util.Arrays;

public class Ex12 {

	public static void main(String[] args) {
		
		// 다차원 배열
		// ㄴ 배열 안에 또다른 배열이 값으로 있는 것
		
		// 1차원 배열{1, 2, 3, 5}
		// 2차원 배열 : {{1,2},{3,4],{5,6},{7,8}}
		
		// 선언과 초기화
		// 자료형키워드[][] = 변수명 new 자료형키워드[배열의 크기][내부 배열의 크기]
		int[][] arr = new int[4][2];
		System.out.println(arr); //	[[I@626b2d4a
		System.out.println(Arrays.toString(arr)); 
		// [[I@5e91993f, [I@1c4af82c, [I@379619aa, [I@cac736f]

		//{{0,0},{0,0},{0,0},{0,0}}
		
		//사용 방법(각 방에 접근)
		arr[0][0] = 10;
		arr[0][1] = 20;
		
		// arr배열의 전체값 출력(for문 사용)
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++){
				System.out.println("arr : [" + i +"][" + j + "] = "+ arr[i][j]);
			}
		}
	}

}
