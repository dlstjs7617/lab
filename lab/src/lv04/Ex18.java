package lv04;

public class Ex18 {

	// arr 배열 heap 에 복제
	
	public static void main(String[] args) {
		
		int[][] arr = {
				{ 10, 20, 30 },
				{ 10, 20, 30, 40 ,50 },
				{ 10, 20, 30, 40 }
		};
		
		int[][] clone = new int[arr.length][];
		//null null null
		for(int i=0; i<arr.length; i++) {
//			int size = arr[i].length;
//			clone[i] = new int[size];
			clone[i] = new int[arr[i].length];
			
			for(int j=0; j<arr[i].length; j++) {
				clone[i][j] = arr[i][j];
			}
			
		}
		System.out.println(clone[0].length);
		System.out.println(clone[1].length);
		System.out.println(clone[2].length);
		for(int i=0; i<clone.length; i++	) {
			System.out.println();
			for(int j=0; j<clone[i].length; j++) {
				System.out.print(clone[i][j] + " ");
			}
		}
	}
}	