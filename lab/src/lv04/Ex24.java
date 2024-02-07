package lv04;

import java.util.Arrays;

public class Ex24 {

	public static void main(String[] args) {
		int test1[] = {1,2,3,2,1};
		int test2[] = {1,3,4,4,2,100};
		int test3[] = {1,1,1,2,1};
		// 위 배열에서 중복안된숫자를 제거하시요;
		
		boolean[] isDupl = new boolean[test1.length];
		for(int i=0; i<test1.length; i++) {
			for(int j=i+1; j<test1.length; j++) {
				if(test1[i] == test1[j]) {
					isDupl[i] = true;
					isDupl[j] = true;
				}
			}
		}
		
		int cnt=0;
		for(int i=0; i<isDupl.length; i++) {
			if(isDupl[i] == true) {
				cnt++;
			}
			
		}
		int[] temp = new int[cnt];
		int idx = 0;
		for(int i=0; i<test1.length; i++) {
			if(isDupl[i]) {
				temp[idx] = test1[i];
				idx++;
			}
		}
		
		test1 = temp;
		
		System.out.println(Arrays.toString(isDupl));
		System.out.println(Arrays.toString(test1));
		// 1) {1,2,2,1}
		
		isDupl = new boolean[test2.length];
		for(int i=0; i<test2.length; i++) {
			for(int j=i+1; j<test2.length; j++) {
				if(test2[i] == test2[j]) {
					isDupl[i] = true;
					isDupl[j] = true;
				}
			}
		}
		
		cnt=0;
		for(int i=0; i<isDupl.length; i++) {
			if(isDupl[i] == true) {
				cnt++;
			}
			
		}
		temp = new int[cnt];
		idx = 0;
		for(int i=0; i<test2.length; i++) {
			if(isDupl[i]) {
				temp[idx] = test2[i];
				idx++;
			}
		}
		
		test2 = temp;
		

		System.out.println(Arrays.toString(test2));
		// 2) {4,4}
		
		isDupl = new boolean[test3.length];
		for(int i=0; i<test3.length; i++) {
			for(int j=i+1; j<test3.length; j++) {
				if(test3[i] == test3[j]) {
					isDupl[i] = true;
					isDupl[j] = true;
				}
			}
		}
		
		cnt=0;
		for(int i=0; i<isDupl.length; i++) {
			if(isDupl[i] == true) {
				cnt++;
			}
			
		}
		temp = new int[cnt];
		idx = 0;
		for(int i=0; i<test3.length; i++) {
			if(isDupl[i]) {
				temp[idx] = test3[i];
				idx++;
			}
		}
		
		test3 = temp;
		
		System.out.println(Arrays.toString(test3));
		// 3) {1,1,1,1}
		
		
		
	}

}
