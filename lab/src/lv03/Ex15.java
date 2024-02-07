package lv03;

public class Ex15 {

	public static void main(String[] args) {
		
		int arr[] = { 0, 0, 0, 0, 0, 0, 3, 3, 3 };
		
		/*
		 * 0 0 0
		 * 0 0 0
		 * 3 3 3
		 */
		
		//문제1) 배열을 위와 같이 3줄씩 출력
		for(int i=0; i<9; i++) {
			if(i != 0 && i % 3 == 0) {
				System.out.println(" ");
			}
			System.out.print(arr[i] + " "); 
		}
	}

}
