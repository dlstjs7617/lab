package lv07t;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 경마
// ㄴ 생성자 정의 필!

class Horse {
	// 경주마 한 마리
	
	int number;
	String name;
	int rank;
	
	// 말이 이동하는 좌표
	int x;
	
	// number와 name이 부여되지 않으면 -> Horse 객체를 생성하지 못하도록
	// 나만의 Horse 생성자를 정의하고,
	// 기본 생성자는 정의하지 않음
	
	Horse(int number, String name) {
		this.number = number;
		this.name = name;
	}
	
//	void jump(int move)	{
//		x += move;
//	}
	
	@Override
	public String toString() {
		return number + "" + name.toUpperCase().charAt(0);	// ex) 1번 말이 라라면 1L로 뜨게
	}
	
}

class Racing {
	// 게임 구현
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	
	final int NUMBER = 5;
	final int FINISH = 20;
	
	Horse[] horses;
	
	int record;
	
	void setGame() {
		record = 1;
		
		horses = new Horse[NUMBER];
		
		for(int i=0; i<NUMBER; i++) {
			String name = inputString(String.format("%d name", i+1));
			horses[i] = new Horse(i+1, name);
		}
	}
	
	boolean isRun() {
		return record > NUMBER ? false : true;
	}
	
	void printMap() {
		System.out.println("RACE >>>");
		for(int i=0; i<NUMBER; i++) {
			int x = horses[i].x;
			for(int j=0; j<FINISH; j++) {
				if(j == x)
					System.out.print("_" + horses[i]);
				else
					System.out.print("__");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	void printResult() {
		printMap();
		
		for(int i=0; i<NUMBER; i++) {
			// 0번 *** 말 : 0등
			Horse horse = horses[i];
			System.out.println(String.format("%d번 %s 말 : %d등", horse.number, horse.name, horse.rank));
		}
	}
	
	void jump() {
		boolean isGoal = false;
		for(int i=0; i<NUMBER; i++) {
			Horse horse = horses[i];
			
			if(horse.rank != 0)
				continue;
			
			int x = horse.x;
			int move = random.nextInt(4);
			
			x += move;
			
			if(x >= FINISH-1) {
				if(isGoal) {
					i--;
					continue;
				}
				
				x = FINISH - 1;
				horse.rank = record ++;
				isGoal = true;
			}
			horse.x = x;
		}
	}
	
	String inputString(String message) {
		System.out.print(message + " : ");
		return scanner.next();
	}
	
	void run() {
		setGame();
		while(isRun()) {
			printMap();
			jump();
			
			try {
				Thread.sleep(300);
			} catch (Exception e) {
			}
		}
		printResult();
	}
	
}

public class Ex04{

	public static void main(String[] args) {
		Racing game = new Racing();
		game.run();

	}

}