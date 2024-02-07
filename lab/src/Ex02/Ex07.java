package Ex02;

public class Ex07 {

	public static void main(String[] args) {
		/*
		1. 1~50까지 반복한다
		2. 그 안에서 해당 숫자의 369 게임 결과를 출력한다
		예) 1 2 짝 4 5 짝 7 8 짝 10 11 12 짝 ... 
		369 숫자가 등장하면 개수만큼 짝짝 (33, 36, 39)
		 */
		
		for(int i=1; i<=50; i++){
			//10의자리
			int ten = i/10;
			//1의 자리
			int one = i%10;
			//두가지를 모두 만족할때 33,36,39
			if(ten % 3 == 0 && ten !=0 && one % 3 == 0 && one != 0) {
				System.out.println("짝짝");
			}else if((ten % 3 == 0 && ten != 0) || (one % 3 == 0 && one != 0)) {
				System.out.println("짝");
			}else {
				System.out.println(i);
			}
			
		}
		
	}

}
