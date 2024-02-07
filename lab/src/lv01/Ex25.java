package lv01;

public class Ex25 {

	public static void main(String[] args) {
		
		//랜덤 Random : 난수 추출(두 번째 방법)
		
		double random =Math.random(); //0부터 1미만 까지의 실수를 난수로 반환 (0.1212,0.78910...)
		System.out.println(random);
		
		//정수 난수로 변환하기
		int min = 1;
		int max = 5;
		
		//double -> int
		int rNum = (int)(Math.random() * (max - min + 1)) + min;
		System.out.println(rNum);
		
		
	}

}
