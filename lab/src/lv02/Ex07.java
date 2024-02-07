package lv02;

public class Ex07 {

	public static void main(String[] args) {
		// 문제1) 9의 배수중 일의 자리가 6인 첫번째 배수 출력 ==> 답:36
		// 문제2) 9의 배수중 십의 자리가 6인 첫번째 배수 출력 ==> 답:63
		// 문제3) 8의 배수중 150보다 작고 150에 가장 가까운수를 출력 ===> 답 :144
		
		int num = 0;
		while(num%10 != 6) {
			num += 9;
		}
		System.out.println("답 :" + num);
		
		num = 0;
		while(num/10 != 6) {
			num += 9;
		}
		System.out.println("답 :" + num);
		
		num = 0;
		while(num < 150 ) {
			num += 8;
			if(num > 150 ) {
				num-= 8;
				break;
			}	
		}
		System.out.println("답 :" + num);
		
		num = 0;
		int temp = 0;
		while(num <= temp) {
			num += 8;
			if(num < 150 ) {
				temp = num;
			}	
		}
		System.out.println("답 :" + temp);
		
		num = 0;
		while(num < 150 ) {
			num += 8;
		}
		if(num >150) {
			System.out.println("답 :" + (num-8));			
		}else{
			System.out.println("답 :" + num);
		}
		
		//강사님코드
		boolean isRun = true;
		
		int n = 1;
		while(isRun) {
			if(n % 9 == 0 && n % 10 == 6) {
				System.out.println("답 : " + n);
				isRun = false;
			}
			n++;
		}
		
		n = 0;
		while (n * 9 / 10 != 6) {
			n ++;
		}
		System.out.println("답 : " + n*9);
		
		n = 150;
		while(n % 8 != 0) {
			n--;
		}
		System.out.println("답 : " + n);
	}
}

