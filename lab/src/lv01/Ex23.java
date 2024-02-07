package lv01;

// 1. Random 클래스 가져오기
import java.util.Random;

public class Ex23 {

	public static void main(String[] args) {
		
		
		// 랜덤 Random : 무작위 난수를 추출
		
		// 2.Random 객체 생성하여 변수로 담아줌
		Random random = new Random();
		
		// 3.nextInt()메소드 호출
		// nextInt(난수의개수)
		// 0부터 시작
		
		//int ranNum = random.nextInt(5);   //범위0~4
		//ranNum = ranNum + 1; 				//범위1~5
		int ranNum = random.nextInt(5)+1;   //범위1~5
		
		System.out.println(ranNum);
	}

}
