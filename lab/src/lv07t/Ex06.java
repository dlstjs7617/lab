package lv07t;

/* class 클래스명 {
 * 
 * 상수
 * 
 * 필드값
 * 
 * 생성자
 * 
 * 메소드(getter & setter)
 * 
 * 메소드(기능)
 * 
 * }
 */


class Card{
	
	private String shape;
	private int number;
	
	
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}

class Player{
	
	private Card[] pair;
	private int money = 1000;
	
}
class CardGame{
	
	private final int SIZE = 40;
	private final String[] shape = {"◆", "♥", "♠", "♣"};
	
	private Card[] cards;
	private Player[] group;
	
	
	public void run() {
		
	}
}

public class Ex06 {

	public static void main(String[] args) {
		
		//카드게임
		// 1) 카드모양 :  다이다, 하트, 스페이드, 클로버
		// 2) 숫자 	 : 1~10
		// 3) 총 40장이 있다.
		// 4) 라운드 별로 2장씩 나눠갖은 다음, 각 카드의 숫자의 합이 큰쪽이 이긴다.(직접만들기)
		// 5) 종료조건 -> 더 이상 나눠가질 카드가 없으면 종료
		//    ㄴ 최종 승자도 출력
		CardGame game = new CardGame();
		game.run();

	}

}
