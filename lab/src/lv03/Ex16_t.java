package lv03;

public class Ex16_t {

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
		
		boolean isBingo = false;
		
		//가로 검사문
//		for(int i=0; i<9; i+=3) {
//			if(arr[i] == 3 && arr[i+1] == 3 && arr[i+1] == 3) {
//				isBingo = true;
//			}
//		}
//		
//		int cnt=0;
//		for(int i=0; i<9; i++) {
//			if(arr[i] == 3)
//				cnt++;
//			if(cnt == 3)
//				isBingo = true;
//			if(i % 3 == 2)
//				cnt = 0;
//		}
		
		// 풀이 3
		for(int i=0; i<9; i+=3) {	// 0 3 6
			int cnt = 0;
			for(int j=0; j<3; j++) {	//i+j : 0 1 2
				if(arr[i+j] == 3)
					cnt ++;
			}
			if(cnt == 3)
				isBingo = true;
		}
		
		
		
		if(isBingo)
			System.out.println("빙고이다");
		else
			System.out.println("빙고가 아니다");
	}

}
