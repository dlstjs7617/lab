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
	
	
	private String shape;
	private int number;
	private boolean usedCard;

	public Card(String shape, int number){
		this.shape = shape;
		this.number = number;
	}
	
	public String getShape() {
		return shape;
	}

	public int getNumber() {
		return number;
	}
	
	public boolean getUsedCard() {
		return usedCard;
	}
	
	private void setUsedCard(boolean usedCard) {
		this.usedCard = usedCard;
	}
	
	public void usedCard(boolean userd) {
		setUsedCard(userd);
	}
	
	
	@Override
	public String toString() {
		return String.format("[%2d%s]", this.number, this.shape);
	}
	
}

class Player {

	private final int SIZE = 2;

	private Card[] pair;
	private int money = 0;
	private String name;
	
	CardGame game = new CardGame();
	
	Player(String name) {
		this.name = name;
	}
	
	public Card[] getPair() {
		return this.pair;
	}
	
	private void setPair(Card[] pair) {
		this.pair = pair;
	}
	
	public int getMoney() {
		return money;
	}
	
	private void setMoney(int money) {
		this.money += money;
	}
	
	public String getName() {
		return name;
	}
	
	public void cardGamePairGet(Card[] pair) {
		setPair(pair);
	}
	
	public void money(int money) {
		setMoney(money);
	}

	public int pairSum() {
		int sum = 0;
		for (int i = 0; i < SIZE; i++) {
			sum += pair[i].getNumber();
		}

		return sum;
	}
}

class CardGame {

	private Random ran = new Random();
	private Scanner sc = new Scanner(System.in);

	private final int SIZE = 40;
	private final String[] shape = { "◆", "♥", "♠", "♣" };

	private Card[] cards;
	private Card[] pair;
	private Player[] group;
	public int[][] submitCards;

	private int round;
	private int playerNum;

	// 플레이어 숫자 설정
	public void setCardGame() {
		playerNum = inputNumber("플레이어 숫자");
		round = SIZE/(playerNum*2);
		group = new Player[playerNum];
		setCard();
		setPlayer();
	}

	// 카드초기화
	private void setCard() {
		cards = new Card[SIZE];

		for (int i = 0; i < SIZE; i++) {
			cards[i] = new Card(shape[i / 10], i % 10 + 1);
		}
	}
	
	// 플레이어설정
	private void setPlayer() {
		for (int i = 0; i < playerNum; i++) {
			group[i] = new Player(inputString("이름"));
		}
	}

	// 종료조건
	private boolean isRun() {
		round--;
		return round < 0 ? false : true;
	}
	
	// 게임
	private void gameRun() {
		
		for(int i=0; i<playerNum; i++) {
			setPair();
			group[i].cardGamePairGet(pair);
		}
		
		highNum();
	}
	// 플레이어 카드패주기
	private void setPair() {
		pair = new Card[2];
		for (int i = 0; i < 2; i++) {
			int idx = returnIdx();
			pair[i] = new Card(cards[idx].getShape(), cards[idx].getNumber());
			cards[idx].usedCard(true);
		}
	}
	// 인덱스값 넘겨주기
	public int returnIdx() {
		int idx = 0;
		while (true) {
			int rShape = ran.nextInt(4);
			int rNum = ran.nextInt(10) + 1;

			idx = checkCard(rShape, rNum);
			if (idx != -1)
				break;
		}
		return idx;
	}
	// 랜덤으로 나온 카드가 사용한 카드인지 확인
	private int checkCard(int rShape, int rNum) {
		for (int i = 0; i < SIZE; i++) {
			if (cards[i].getShape().equals(shape[rShape]) && 
				cards[i].getNumber() == cards[i].getNumber() &&
				!cards[i].getUsedCard())
				return i;
		}
		return -1;
	}
	
	
	
	// 플레이어 카드 비교
	private void highNum() {
		System.out.println("라운드 " + round);
		int num = 0; 
		int win = -1;
		for(int i=0; i<playerNum; i++) {
			System.out.printf("%s : ",group[i].getName());
			System.out.print(group[i].getPair()[0]);
			System.out.print(group[i].getPair()[1]);
			System.out.println();
			if(num <group[i].pairSum()) {
				num = group[i].pairSum();
				win = i;
			}
		}
			System.out.printf("승자 : %s \n", group[win].getName());
			group[win].money(200);
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
	
	public String inputString(String message) {
		System.out.print(message+"입력 :");
		return sc.next();
	}
	
	private void printWin() {
		String name = "";
		int money = 0;
		
		for(int i=0; i<playerNum; i++) {
			if(money < group[i].getMoney()) {
				money = group[i].getMoney();
				name = group[i].getName();
			}
		}
		
		System.out.printf("승자 %s %d원 ",name ,money);
	}
	
	public void run() {
		setCardGame();

		while (isRun()) {
			gameRun();
		}
		printWin();
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