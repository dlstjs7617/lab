package lv07;

import java.util.Random;
import java.util.Scanner;

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
	
	Random ran = new Random();
	
	private String shape;
	private int number;
	
	Player player = new Player();
	
	Card(String shape, int number){
		this.shape = shape;
		this.number = number;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}

class Player{
	
	private Card[] pair;
	private int money = 1000;
	
	Player(){
		
	}
	
	Player(int rShape, int rNum){
		
	}
	
	
	
}
class CardGame{
	
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);
	
	private final int SIZE = 40;
	private final String[] shape = {"◆", "♥", "♠", "♣"};
	
	private Card[] cards;
	private Player[] group;
	
	public int[][] submitCards;
	
	private int playerNum;
	
	public void setCardGame() {
		playerNum = inputNumber("플레이어 숫자");
		group = new Player[playerNum];
	}
	
	private void setCard() {
		cards = new Card[SIZE];
		for(int i=0; i<SIZE; i++) {
			cards[i] = new Card(null, i);
		}
	}
	
	
	
	public boolean isRun() {
		return SIZE == 0 ? false : true;
	}
	
	void gameRun() {
		submitCard();
	}
	
	void submitCard() {
		for(int i=0; i<player.getPlayerNum(); i++) {
			group[i] = new player();
		}
	}
	
	public int inputNumber(String message) {
		int num = 0;
		
		System.out.print(message + "입력 : ");
		try {
			String input = sc.next();
			num = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return num;
	}
	
	public void run() {
		setCardGame();
		
		while(isRun()) {
			
		}
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
