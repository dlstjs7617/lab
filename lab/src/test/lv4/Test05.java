package test.lv4;
// 시작 18:06
// 종료 18:21
// 소요 00:15
public class Test05 {
	// 5 .
	/*
	 * # 2차원 반복문
	 * 1   2  3  4  5
	 * 10  9  8  7  6
	 * 11 12 13 14 15
	 * 20 19 18 17 16
	 * 21 22 23 24 25
	 */
	public static void main(String[] args) {
		
		final int SIZE = 5;
		int arr[][] = new int[5][5];
		//위와 같이 수를 채우고 출력해보세요.
		int num = 1;
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				arr[i][j] = num++;
			}
			i++;
			if(i > 4) {
				break;
			}
			for(int j=4; j>=0; j--) {
				arr[i][j] = num++;
			}
		}
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				System.out.printf("%2d ", arr[i][j]);				
			}
			System.out.println();
		}
	}
}
