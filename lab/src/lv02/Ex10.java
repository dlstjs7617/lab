package lv02;

public class Ex10 {

	/*
	 * # 369게임[2단계]
	 * 1. 1~50까지 반복을 한다.
	 * 2. 그 안에서 해당 숫자의 369게임의 결과를 출력한다.
	 * 예) 1 2 짝 4 5 짝 7 8 짝 10 11 12 짝
	 * 369숫자가 등장하면, 개수막큼 짝짝 (33 , 36 ,39)
	 */
	public static void main(String[] args) {
		
		int num = 1;
		while(num <=50) {
			int ten = num/10;
			int one = num%10;
			if(ten != 0 && ten % 3 == 0 && one != 0 && one % 3 == 0){				
				System.out.println("("+num +")짝짝");
			}else if(ten != 0 && ten % 3 == 0 || one != 0 && one % 3 == 0) {
				System.out.println("("+num +")짝");
			}else {
				System.out.println(num);
			}
			num++;
		}
	}

}
