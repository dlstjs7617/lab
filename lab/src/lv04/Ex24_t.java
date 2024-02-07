package lv04;

import java.util.Arrays;

public class Ex24_t {

	public static void main(String[] args) {
		int test1[] = {1,2,3,2,1};
		int test2[] = {1,3,4,4,2,100};
		int test3[] = {1,1,1,2,1};
		// 위 배열에서 중복안된숫자를 제거하시요;
		
		// 1) {1,2,2,1}
		
		// 1. test1 배열이 변화할 크기를 알아내야함
		// 2. test1 배열이 새 주소 할당
		// 3. 이사간 주소에 타겟 값들을 옮기기
		
		int size = 0;
		
		for(int i=0; i<test1.length; i++) {
			int cnt = 0;
			for(int j=0; j<test1.length; j++) {
				// test1[i] 가 배열 전체에서 몇 개?
				if(test1[i] == test1[j])
					cnt++;
			}
			
			if(cnt > 1)
				size++;
		}
		
		int[] temp = test1;
		test1 = new int[size];
		
		int idx = 0;
		for(int i=0; i<temp.length; i++) {
			int cnt = 0;
			for(int j=0; j<temp.length; j++) {
				// test1[i] 가 배열 전체에서 몇 개?
				if(temp[i] == temp[j])
					cnt++;
			}
			
			if(cnt > 1) {
				test1[idx ++] = temp[i];
			}
		}
		
		
		
		
		
		
		System.out.println(Arrays.toString(test1));
		// 1) {1,2,2,1}
		System.out.println(Arrays.toString(test2));
		// 2) {4,4}
		System.out.println(Arrays.toString(test3));
		// 3) {1,1,1,1}
		
		
		
	}

}
