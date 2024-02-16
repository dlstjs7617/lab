package test.lv5;

public class test06 {
	//시작 15:53
	//종료 16:10
	//소요 00:17
	public static void main(String[] args) {
//		String data = "123+46";
		String delimiter = "+";
		//test case:
//		String data = "123+46+1";
		String data = "1+2+3+4+5";
		
		// 위 수의 합을 구하시오
		// split()메서드 로직 직접 만들기
		int sum = 0;
		int cnt = 0;
		boolean plus = false;
		for(int i=0; i<data.length(); i++) {
			if(data.charAt(i) == delimiter.charAt(0)) {
				sum += Integer.parseInt(data.substring(i-cnt, i));
				cnt = 0;
				plus = true;
			}else if(plus && i == data.length()-1){
				sum += Integer.parseInt(data.substring(i-cnt,i+1));
			}else {
				cnt++;
			}
		}
		System.out.println("합 : " + sum);
	}

}
