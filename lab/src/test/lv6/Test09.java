package test.lv6;
//시작 16:16
//종료 16:26
//소요 00:10
public class Test09 {
	
	public int solution(int price, String grade) {
		int answer = 0;
		
		if(grade.equals("S")) {
			answer = price-(int)(price*0.05);
		}else if(grade.equals("G")) {
			answer = price-(int)(price*0.1);			
		}else if(grade.equals("V")) {
			answer = price-(int)(price*0.15);
		}
		
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		Test09 sol = new Test09();
		
		int price1 = 2500;
		String grade1 = new String("V");
		int ret1 = sol.solution(price1, grade1);
		
		System.out.println("답 : " + ret1 + " .");
		
		int price2 = 96900;
		String grade2 = new String("S");
		int ret2 = sol.solution(price2, grade2);
		
		System.out.println("답 : " + ret2 + " .");
	}
}
