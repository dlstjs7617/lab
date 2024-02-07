package lv03;

public class Ex16 {

	public static void main(String[] args) {
		
//		int arr[] = {
//				0,0,0,
//				0,0,0,
//				3,3,3
//		};
//		int arr[] = {
//				0,0,0,
//				0,0,3,
//				3,3,0
//		};
//		int arr[] = {
//				3,0,0,
//				0,0,0,
//				3,3,0
//		};
		int arr[] = {
				0,0,0,
				3,3,3,
				3,0,0
		};
		
		// 문제2) 만약에 가로가 3이 연속으로 있으면 빙고 출력
		int count = 0;

		for(int i=0; i<9; i++) {
			if(arr[i] == 3) 
				count++;
			if(count == 3) 
				break;
			if(i % 3 == 2) 
				count = 0;
		}
		if(count == 3) 
			System.out.println("빙고");
		else
			System.out.println("빙고가 아니다");
	}

}
