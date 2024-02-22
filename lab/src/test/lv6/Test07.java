package test.lv6;
//시작 15:17
//종료 15:41
//소요 00:24
public class Test07 {
	
	int func_a(int[] arr) {
		int max = 0;
		int maxCnt = 0;
		for(int i=0; i<arr.length; i++) {
			int cnt = 0;				
			for(int j=0; j<arr.length; j++) {
				if(arr[i] == arr[j]) {
					cnt++;
				}
			}
			
			if(cnt > maxCnt) {
				maxCnt = cnt;
				max = arr[i];
			}
		}
		return max;
	}
	int func_b(int[] arr) {
		int min = 0;
		int minCnt = arr.length;
		for(int i=0; i<arr.length; i++) {
			int cnt = 0;				
			for(int j=0; j<arr.length; j++) {
				if(arr[i] == arr[j]) {
					cnt++;
				}
			}
			
			if(cnt < minCnt) {
				minCnt = cnt;
				min = arr[i];
			}
		}
		
		return min;
	}
	
	public int solution(int[] arr) {
		int maxCnt = func_a(arr);
		int minCnt = func_b(arr);
		return maxCnt / minCnt;
	}
	
	public static void main(String[] args) {
		Test07 sol = new Test07();
		
		int[] arr = { 1, 2, 3, 3, 1, 3, 3, 2, 3, 2};
		int ret = sol.solution(arr);
		
		System.out.println("답 : " + ret + " .");
	}
}
