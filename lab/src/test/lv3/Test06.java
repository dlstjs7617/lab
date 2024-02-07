package test.lv3;

import java.util.Arrays;
import java.util.Scanner;

public class Test06 {
	//시작 04:26
	//종료 14:00
	//소요 10:34
	public static void main(String[] args) {
		//Level Test 3
		
		// 6 Last
	
//		int arr[] = { 0, 2, 0, 4, 3, 0, 0, 5, 6};
		
		// Test case.
//		int arr[] = { 1, 2, 0, 3, 4, 0, 0, 5, 8};
		int arr[] = { 1, 0, 0, 0, 0, 0, 0, 0, 0};
		
		// 아래 번호를 입력받고 각방향 으로 0 이아닌 숫자를 모으시오
		// 1)left 2)right
		
		// 예) 1) left ==> arr = [2, 4, 3, 5, 6, 0, 0, 0, 0]
//		 예) 1) right ==> arr = [0, 0, 0, 0, 2, 4, 3, 5, 6]
		
		final int MAX = 9;
		Scanner sc = new Scanner(System.in);
		boolean isRun = true;
		
		while(isRun) {
			System.out.print("1.left 2.right : ");
			int sel = sc.nextInt();
			
			
			if(sel == 1) {
				int temp = -1;
				for(int i=0; i<MAX; i++) {
					for(int j=0; j<MAX-1; j++) {
						if(arr[j] == 0) {
							temp = arr[j];
							arr[j] = arr[j+1];
							arr[j+1] = temp; 
						}
					}
					
				}
				
			}else if(sel == 2) {
				int temp = -1;
				for(int i=0; i<MAX; i++) {
					for(int j=MAX-1; j>0; j--) {
						if(arr[j] == 0) {
							temp = arr[j];
							arr[j] = arr[j-1];
							arr[j-1] = temp; 
						}
					}
				}
			}
			
			
			
			System.out.println(Arrays.toString(arr));
			
		}
		
		
	}

}
