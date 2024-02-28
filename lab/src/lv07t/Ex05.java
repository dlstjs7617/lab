package lv07t;

import java.util.Arrays;

class Lotto {
	
	// 접근 제어자
	// ㄴ 클래스 안에 멤버를 외부에서 접근할 수 있는 범주를 설정하는 것
	// 1) private	<- 클래스 내부 범위에서만 접근 가능
	// 2) (default) 
	// 3) protected
	// 4) public 	<-	모든 범위에서 접근 가능
	
	// 정보 은닉 활용하여 -> 캡슐화를 구현할 수 있게됨
	// ㄴ 대부분의 필드를 숨기고,
	// ㄴ 선택적으로 객체 내부의 정보를 공개 하는 것
	
	private final int SEVEN = 7;
	private final int GOAL = 3;
	
	
	private boolean isGoal;
	private int[] lotto;
	
	public Lotto(){
		lotto = new int[SEVEN];
		
		for(int i=0; i<SEVEN; i++)
			lotto[i] = (int)(Math.random() * 3) == 0 ? SEVEN : 0;
		
		checkGoal();
	}
	// getter & setter
	// ㄴ private field 를 처리하는 메소드
	
	// Getter 만드는 법
	// 리턴타입 get변수명() { return this.변수명; }
	public boolean getIsGoal() {
		return isGoal;
	}
	
	// Setter 만드는 법
	// void set변수명(변수타입 변수명) { this.변수명 = 매개변수명;}
	private void setIsGoal(boolean isGoal) {
		this.isGoal = isGoal;
		
	}
	
	private void checkGoal() {
		boolean isGoal = false;
		
		int cnt = 0;
		for(int i=0; i<SEVEN; i++) {
			if(lotto[i] == SEVEN)
				cnt++;
			else
				cnt = 0;
			
			if(cnt == GOAL)
				this.isGoal = true;
		}
		
		setIsGoal(isGoal);
	}
	
	
	
	@Override
	public String toString() {
		return Arrays.toString(lotto) + (isGoal ? "<<<GOAL" : "꽝");
	}
	
}

class LottoSet {
	
	final int NUMBER;
	
	Lotto[] set; 
	
	LottoSet(int number){
		NUMBER = number;
		
	}
	
	void setGame() {
		set = new Lotto[NUMBER];
		
		boolean isGoal = false;
		for(int i=0; i<NUMBER; i++) {
			set[i] = new Lotto();
			
//			set[i].isGoal = true; // 수정을 허용하지않음
								  // 조회는 허용
			if(set[i].getIsGoal() && !isGoal)
				isGoal = true;
			else if(set[i].getIsGoal())
				i--;
			
			if(i == NUMBER -1 && !isGoal)
				i = -1;
		}
	}
	
	void printGameSet() {
		for(int i=0; i<NUMBER; i++)
			System.out.println(set[i]);
	}
	
	void run() {
		setGame();
		printGameSet();
	}
}

public class Ex05 {

	public static void main(String[] args) {

		LottoSet game = new LottoSet(5);
		game.run();
	}

}
