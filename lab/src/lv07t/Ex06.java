package lv07t;

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
//	private boolean filpped
	
	public Card(int number, String shape) {
		this.number = number;
		this.shape = shape;
	}
	
	public String getShape() {
		return this.shape;
	}

	public int getNumber() {
		return this.number;
	}
	
	@Override
	public String toString() {
		return String.format("[%2d%s]", this.number, this.shape);
	}
	
}

class Player{	
	private String name;
	private Card[] pair;
	private int score;
	private int money = 1000;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Card[] getPair() {
		return this.pair.clone();
	}
	
	public void setPair(Card[] pair) {
		this.pair = pair;
		
		this.score = 0;
		for(int i=0; i<pair.length; i++) {
			this.score += pair[i].getNumber();
		}
	}
	
	public int getScore() {
		return this.score;
	}
	
//	public void setScore(int score) {
//		this.score = score;
//	}
	
	public int getMoney() {
		return this.money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
		public String toString() {
			String info = String.format("%s (%d)", this.name, this.money);
			if(pair != null)
				for(int i=0; i<pair.length; i++)
					info += pair[i];
			
			info += "=" + score;
			return info;
		}
}
class CardGame{
	
	Scanner sc = new Scanner(System.in);
	
	private final int SIZE = 40;
	private final String[] shape = {"◆", "♥", "♠", "♣"};
	
	private Card[] cards;
	private Player[] group;
	
	private int pick;
	private int number;
	private int round;
	
	private void setGame() {
		pick = 0;
		
		setCards();
		setPlayer();	
	}
	
	private void setPlayer() {
		while(number < 2 || number > 20) {
			number = inputNumber("플레이어 수");
		}
		
		group = new Player[number];
		for(int i=0; i<number; i++) {
			System.out.print(i+1 + "name : ");
			String name = sc.next();
			
			group[i] = new Player(name);
		}
		
		round = SIZE / (number * 2);
	}
	
	private int inputNumber(String message) {
		int number = 0;
		System.out.print(message + " :");
		
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자를 입력하세요.");
		}
		
		return number;
	}
	
	private void setCards() {
		cards = new Card[SIZE];
		
		for(int i=0; i<SIZE; i++)
			cards[i] = new Card(i%10+1, shape[i/10]);
		
		shuffleCard();
	}
	
	private void shuffleCard() {
		Random ran = new Random();
		
		for(int i=0; i<SIZE*100; i++) {
			int rIdx = ran.nextInt(SIZE);
			
			Card card = cards[0];
			cards[0] = cards[rIdx];
			cards[rIdx] = card;
		}
	}
	
	private boolean isRun() {
		return round > 0 ? true : false;
	}
	
	private Player sharingCardsAndgetWinner() {
		Player winner = null;

		for (int i = 0; i < number; i++) {
			Player player = group[i];
			Card[] picks = new Card[2];

			for (int j = 0; j < 2; j++)
				picks[j] = cards[pick++];

			player.setPair(picks);
			System.out.println(player);

			if (winner == null || player.getScore() > winner.getScore())
				winner = player;
		}
		
		return winner;
	}
	
	private void play() {
		// 플레이어 수 만큼
		// 돌아가면서 카드를 2장 뽑기 ->플레이어가 가짐(pair)
		// 라운드뱔로 승자를 출력(동점자 처리)
		// 이긴자는 money += 500
		Player winner = sharingCardsAndgetWinner();
		setRoundWinner(winner);
		
		round --;
	}
	
	private void setRoundWinner(Player winner) {
		System.out.printf("%d ROUND >>> ", SIZE / (number * 2) - round+1);
		for(int i=0; i<number; i++) {
			Player player = group[i];
			if(player.getScore() == winner.getScore()) {
				System.out.println(player.getName() + "WIN!!");
				player.setMoney(player.getMoney() + 500);				
			}
		}
		System.out.println();
	}
	
	private void printFinalWinner() {
		Player winner = null;
		
		for(int i=0; i<number; i++) {
			Player player = group[i];
			
			if(winner == null || player.getMoney() > winner.getMoney())
				winner = player;
		}
		
		System.out.print("Final winner is ");
		for(int i=0; i<number; i++) {
			Player player = group[i];
			
			if(winner.getMoney() == player.getMoney())
				System.out.println(player.getName() + "WIN!!!");
		}
	}
	
	public void run() {
		setGame();
		
		while(isRun()) {
			play();
			
			try {
				Thread.sleep(300);
			} catch (Exception e) {
			}
		}
		printFinalWinner();
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