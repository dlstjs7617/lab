package lv07;

import java.util.Random;
import java.util.Scanner;

// 경마
// ㄴ 생성자 정의 필!

class Horse{
	// 경주마 한 마리
	// 번호 ,위치, 랭크, 속도
	
	int location, rank, number;
	
	Horse(){
		
	}
	
	Horse(int number, int location){
		this.location = location;
		this.number = number;
	}
	
	Horse(int number, int location, int rank){
		this.location = location;
		this.number = number;
		this.rank = rank;
	}
	
	
}

class Racing{
	// 게임 구현
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	final int SIZE = 20;
	
	int horseNum = 0;
	int rankCnt = 1;
	
	int[][] racing;
	
	Horse[] hores;
	
	// 게임 초기화
	void setGame(){
		setHorseNum();
		racing = new int[horseNum][SIZE];
		
		setHorse();
	}
	
	void setHorseNum() {
		while(horseNum < 2) {
			horseNum = inputNumber("달릴말 숫자");
		}
	}
	
	// 경주말 초기화
	void setHorse() {
		hores = new Horse[horseNum];
		
		for(int i=0; i<horseNum; i++) {
			hores[i] = new Horse(i+1, 0);			
		}
	}
	
	// 종료 조건
	boolean isRun() {
		if(rankCnt > horseNum)
			return false;
		
		return true;
	}
	
	// 레이싱 출력
	void printRacing() {
		System.out.println("================ 경마장 ===============");
		for(int i=0; i<horseNum; i++) {
			for(int j=0; j<SIZE; j++) {
				if(hores[i].location == j)
					System.out.print("🐎");
				else
					System.out.print("〓");
			}
			System.out.println();
		}
		System.out.println("======================================");
	}
	
	// 말달리자
	void horseRun() {
		
		for(int i=0; i<horseNum; i++) {
			boolean end = false;
			
			int runRan = ran.nextInt(4);
			
			if(hores[i].rank != 0)
				continue;
			
			if(hores[i].location < SIZE) {
				hores[i].location += runRan;
			}
			
			if(end && hores[i].location >= SIZE) {
				hores[i].location -= runRan;
				continue;
			}
			
			
			
			if(hores[i].location >= SIZE) {
				end = true;
				hores[i] = new Horse(i+1, SIZE-1, rankCnt++);
			}
		}
	}
	
	void slowGame() {
		try {
			Thread.sleep(300);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void printRank() {
		printRacing();
		for(int i=0; i<horseNum; i++) {
			System.out.printf("%d번말 %d등  \n",hores[i].number, hores[i].rank);
		}
	}
	
	int inputNumber(String message) {
		int number = -1;
		System.out.println(message + "입력 : ");
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return number;
	}
	
	
	void run() {
		setGame();

		while(isRun()) {
			printRacing();
			
			horseRun();
			
			slowGame();
		}
		
		printRank();
	}
}

public class Ex04 {

	public static void main(String[] args) {
		Racing game = new Racing();
		game.run();

	}

}
