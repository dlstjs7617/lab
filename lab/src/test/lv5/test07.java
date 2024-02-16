package test.lv5;

import java.util.Arrays;

public class test07 {
	//시작 16:30
	//종료 17:55
	//소요 01:05
	public static void main(String[] args) {
		//7.
		// 아주긴수는 변수에 저장할수없다. int 나 long 에 넣지 않고 아래 합 구하기
		
		//위 수의 합을 구하시오. (테스트케이스에서 data1과 data2는 자리가 바뀔수 0)
		//힌트 배열에 넣으세요~
		
		String data1 ="123456789123456";
		String data2 ="88888888888888";
		
		String[] dataArr1 = new String[data1.length()];
		String[] dataArr2 = new String[data2.length()];
		
//		for(int i=0; i<data1.length(); i++) {
//			dataArr1[i] = data1.charAt((data1.length()-1)-i)+"";
//		}
//		for(int i=0; i<data2.length(); i++) {
//			dataArr2[i] = data2.charAt((data2.length()-1)-i)+"";
//		}
		for(int i=0; i<data1.length(); i++) {
			dataArr1[i] = data1.charAt(i)+"";
		}
		for(int i=0; i<data2.length(); i++) {
			dataArr2[i] = data2.charAt(i)+"";
		}

		String temp = "";
		int cnt = 0;
		boolean up = false; 
		while(true) {
			int sum = 0;
			
			if(cnt < dataArr1.length) {
				sum += Integer.parseInt(dataArr1[dataArr1.length-1-cnt]);
			}
			if(cnt < dataArr2.length) {
				sum += Integer.parseInt(dataArr2[dataArr2.length-1-cnt]);
			}
			if(up == true) {
				sum++;
				up = false;
			}
			if(sum >= 10) {
				up = true;
				sum-= 10;
				temp += sum;
				
			}else {
				temp += sum;
			}
			cnt++;
			
			
			if(cnt >= dataArr1.length && cnt >= dataArr2.length)
				break;
		}
		String result = "";
		for(int i=temp.length()-1; i>=0; i--) {
			result += temp.charAt(i) + "";
			if(i !=0 && i%3 == 0)
				result +=",";
		}
		System.out.println(result);
		
	}

}
