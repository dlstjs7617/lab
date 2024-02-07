package lv02;

public class Ex10_t {

	/*
	 * # 369게임[2단계]
	 * 1. 1~50까지 반복을 한다.
	 * 2. 그 안에서 해당 숫자의 369게임의 결과를 출력한다.
	 * 예) 1 2 짝 4 5 짝 7 8 짝 10 11 12 짝
	 * 369숫자가 등장하면, 개수막큼 짝짝 (33 , 36 ,39)
	 */
	public static void main(String[] args) {
		
		int n = 1;
		while(n <= 50) {
			int x = n / 10; // 십의 자리 수
			int y = n % 10; // 일의 자리 수
			
			int count = 0;
			
			if(x % 3 == 0 && x != 0)
				count ++;
			if(y % 3 == 0 && y != 0)
				count ++;
			
			if(count > 0) {
				while(count > 0){
					System.out.print("짝");
					count --;
				}
			}else {
				System.out.print(n);
			}
			System.out.print(" ");
			
			n++;
		}
	}

}
