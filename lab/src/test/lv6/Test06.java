package test.lv6;
//시작 15:00
//종료 15:11
//소요 00:11
public class Test06 {
	public int solution(int[] data) {
		double total = 0;
		int cnt =0;
		for(int i=0; i<data.length; i++) {
			total += data[i];
		}
		
		double avg = total/data.length;
		for(int i=0; i<data.length; i++) {
			if(avg > data[i])
				cnt++;
		}
		
		
		return cnt;
	}
	
	public static void main(String[] args) {
		Test06 sol = new Test06();
		
		int[] data1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int ret1 = sol.solution(data1);
		
		System.out.println("답 : " + ret1 + ". ");
		
		int[] data2 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 10};
		int ret2 = sol.solution(data2);
		
		System.out.println("답 : " + ret2 + ". ");
	}
}
