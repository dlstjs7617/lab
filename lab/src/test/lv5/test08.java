package test.lv5;

public class test08 {
	//시작 17:57
	//종료 19:03
	//소요 01:06
	public static void main(String[] args) {
		
		//8.LAST
		// 숫자에서 한글 단위명을 추가해서 출력
		// 예) 1234만5천6백7십8
		// 예) 4천5
		// 예)23만5십5
		// 예)1
		// 에)2백
		int[][] data = {
				{12345678},
				{4005},
				{230055},
				{1},
				{200}
		};
		
		for(int i=0; i<data.length; i++) {
			String result = "";
			int temp = data[i][0];
			
			while(true) {
				if(temp >= 100000000) {
					result += temp/100000000 + "억"; 
					temp = temp%100000000;
				}else if(temp >= 10000) {
					result += temp/10000 +"만";
					temp = temp%10000;
					
				}else if(temp >= 1000) {
					result += temp/1000 +"천";
					temp = temp%1000;
					
				}else if(temp >= 100) {
					result += temp/100 +"백";
					temp = temp%100;
					
				}else if(temp >= 10) {
					result += temp/10 +"십";
					temp = temp%10;
					
				}else {
					if(temp != 0) {
						result += temp;						
					}
					break;
				}
				
			}
			
			System.out.println(result);
		}
	}

}
