package test.lv6;
//시작 16:55
//종료 17:03
//소요 00:08

public class Test10 {
	public int func_a(int month, int day) {
		int monthList[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int one = 0;
		for(int i=0; i<month-1; i++) {
			one += monthList[i];
		}
		
		one -= day;
		
		return one;
	}
	
	public int solution(int startMonth, int startDay, int endMonth, int endDay) {
		int startTotal = func_a(startMonth, startDay);
		int endTotal = func_a(endMonth, endDay);
		
		return endTotal - startTotal;
	}
	
	public static void main(String[] args) {
		Test10 sol = new Test10();
		
		int startMonth = 1;
		int startDay = 2;
		int endMonth = 2;
		int endDay = 2;
		int ret = sol.solution(startMonth, startDay, endMonth, endDay);
		
		
		
		// Press Run button to receive output.
		System.out.println("Solution : return value of the method is " + ret + ".");
	}
}


