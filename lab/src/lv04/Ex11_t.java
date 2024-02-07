package lv04;

import java.util.Arrays;

public class Ex11_t {
	/*
	 *  int[] a = {1,1,3,3,3,100,2,2,3,1,3,};
	 *  위 배열에서 똑같은 숫자의 개수가 가장적은 숫자와 가장 많은 숫자의 개수를 출력
	 *  예) 개수가 가장적은숫자 ==> 100
	 *  예) 개수가 가장많은숫자 ==> 3
	 *  
	 *  가장 많은 갯수 출력 : 3 ====>5개
	 *  가장 적은 갯수 출력 : 100 ===> 1개
	 */
	public static void main(String[] args) {

		int[] a = { 1, 1, 3, 3, 3, 100, 2, 2, 3, 1, 3 };
//		int[] a = { 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2};
//		int[] a =  {5,1,2,2,3,3,4,4,5,1};

		// 배열 같은값 0만들고 카운트 전부 반복후 당기기
		// 배열 변수명.length <-- 배열의 크기
		// null 상태에서는 length를 참조 X
		
		int maxCnt = 0;
		int maxNum = 0;
		
		int minCnt = a.length;
		int minNum = 0;
		for(int i=0; i<a.length; i++) {
			// 검사 대상 :a[i]
			int cnt = 0;
			// 검사 범위 : 배열 전체
			for(int j=0; j<a.length; j++) {
				if(a[i] == a[j]) {
					cnt++;
				}
			}
			if(cnt > maxCnt) {
				maxCnt = cnt;
				maxNum = a[i];
			}
			if(cnt < minCnt) {
				minCnt = cnt;
				minNum = a[i];
			}
			
		}
		
		System.out.printf("최대 갯수 %d개 값:%d \n", maxCnt, maxNum);
		System.out.printf("최소 갯수 %d개 값:%d \n", minCnt, minNum);
		
		// {5,1,2,2,3,3,4,4,5,1}
		// 힌트 : 벡터 컨트롤러 풀이 활용
		/*
		 * 가장 많은 갯수 출력 1 ===> 2개
		 * 가장 많은 갯수 출력 2 ===> 2개
		 * 가장 많은 갯수 출력 3 ===> 2개
		 * 가장 많은 갯수 출력 4 ===> 2개
		 * 가장 많은 갯수 출력 5 ===> 2개
		 * 
		 * 가장 적은 갯수 출력 1 ===> 2개
		 * 가장 적은 갯수 출력 2 ===> 2개
		 * 가장 적은 갯수 출력 3 ===> 2개
		 * 가장 적은 갯수 출력 4 ===> 2개
		 * 가장 적은 갯수 출력 5 ===> 2개
		 * 
		 */
	}

}
