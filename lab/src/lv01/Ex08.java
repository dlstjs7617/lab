package lv01;

public class Ex08 {

	public static void main(String[] args) {
		//문제) 다음의 변수 x와 y의 값을 서로 교체하여 출력하기
		// ㄴ 힌트 : 변수의 활용
		
		int x = 10;
		int y = 20;
		int z;
		
		//temp, tmp (temporary)
		
		z = x;
		x = y;
		y = z;
		
		System.out.println("x : " + x); //20
		System.out.println("y : " + y); //10

	}

}