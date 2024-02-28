package lv07;

import java.util.Random;
import java.util.Scanner;

class Lotto {

	final int SIZE = 7;

	int[] number;

	Lotto() {
		number = new int[SIZE];
	}
	
}

class LottoGame {
	
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();

	int size;
	int prizeLine;
	Lotto[] lotto;
	
	LottoGame(){
		this.size = setSize();
	}
	
	int setSize() {
		int num = 0;
		System.out.print("로또 구매수량 입력 :");
		try {
			String input = sc.next();
			num = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만입력");
		}
		
		return num;
	}
	
	void setLotto() {
		lotto = new Lotto[size];

		while (true) {
			ranLotto();
			if(checkLottoSet())
				break;
		}
	}

	void ranLotto() {
		for (int i = 0; i < size; i++) {
			lotto[i] = new Lotto();
			for(int j=0; j<lotto[i].number.length; j++) {
				int rNum = ran.nextInt(2) == 1 ? 7 : 0;
				lotto[i].number[j] = rNum;
			}
		}
	}
	
	boolean checkLottoSet() {
		int prizeCnt = 0;
		
		for(int i=0; i<size; i++) {
			int cnt = 0;

			for(int j=0; j<lotto[i].number.length; j++) {				
				if(lotto[i].number[j] == 7)
					cnt++;
				else 
					cnt = 0;
				
				if(cnt >= 3) {
					prizeLine = i;
					prizeCnt++;
					break;
				}
			}
		}
		if(prizeCnt == 1)
			return true;
		else
			return false;
	}
	
	void printLotto() {
		for(int i=0; i<size; i++) {
			System.out.printf("%d 라인 : ",i+1);
			for(int j=0; j<lotto[i].number.length; j++)
				System.out.printf("[%d]", lotto[i].number[j]);
			
			System.out.println();
		}
		System.out.printf("%d라인 당첨!",prizeLine+1);
	}
	
	void run() {
		setLotto();
		printLotto();
	}
}

public class Ex05 {

	public static void main(String[] args) {

		LottoGame game = new LottoGame();
		game.run();
	}

}
