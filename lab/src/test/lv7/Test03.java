package test.lv7;
// 시작 14:57
// 종료 17:55
// 소요 02:28

import java.util.Scanner;

//3.
// 블록 회전
// ㄴ class : Game
// ㄴ Game 기능 :	 시계방향 회전, 반시계방향회전
// ㄴ			 클래스 정의 후, 생성자 인자로 block 을 넘겨줄 것

class Game{
	private Scanner sc = new Scanner(System.in);
	
	
	private int[][] block;
	private int[] northBlock;
	private int[] eastBlock;
	private int[] southBlock;
	private int[] westBlock;
	private int[] centerBlock;
	
	private int size;
	
	public Game(int[][] block) {
		this.block = block;
		size = block.length;
	}
	
	private int inputNumber(String message) {
		int number = -1;
		
		System.out.println(message + " : ");
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return number;
	}
	
	// 위블록
	private void setNorth() {
		northBlock = new int[size];
		for(int i=0; i<size; i++) {
			northBlock[i] =block[0][i];
		}
	}
	
	// 우측블록
	private void setEast() {
		eastBlock = new int[size];
		for(int i=0; i<size; i++) {
			eastBlock[i] = block[i][size-1];
		}
	}
	// 아래블록
	private void setSouth() {
		southBlock = new int[size];
		for(int i=0; i<size; i++) {
			southBlock[i] = block[size-1][i];
		}
	}

	// 좌측블록
	private void setWest() {
		westBlock = new int[size];
		for(int i=0; i<size; i++) {
			westBlock[i] = block[i][0];
		}
	}
	
	private void setCenter() {
		centerBlock = new int[size];
		
		int cnt = 0;
		for(int i=1; i<3; i++) {
			centerBlock[cnt++] = block[1][i];
		}
		for(int i=2; i>0; i--) {
			centerBlock[cnt++] = block[2][i];			
		}
	}
	
	//세팅
	private void setBlock() {
		setNorth();
		setEast();
		setSouth();
		setWest();
		setCenter();
	}
	
	// 방향받기
	private int question() {
		return inputNumber("1)시계방향 2)반시계방향");
	}
	
	// 중앙 시계방향
	private void setCenterRight() {
		int[] temp = centerBlock.clone();
		centerBlock = new int[size];
		
		int cnt = 0;
		for(int i=1; i<size; i++) {
			centerBlock[i] = temp[cnt++];
		}
		centerBlock[0] = temp[size-1];
		cnt = 0;
		for(int i=1; i<3; i++) {
			block[1][i] = centerBlock[cnt++];
		}
		for(int i=2; i>0; i--) {
			block[2][i] = centerBlock[cnt++];
		}
		
	}
	
	// 시계방향
	private void right() {
		// 상
		for(int i=0; i<size; i++) {
			block[0][i] = westBlock[size-1-i];
		}
		
		// 우
		for(int i=0; i<size; i++) {
			block[i][size-1] = northBlock[i];
		}
		
		// 하
		for(int i=0; i<size; i++) {
			block[size-1][i] = eastBlock[size-1-i];
		}
		
		// 좌
		for(int i=0; i<size; i++) {
			block[i][0] = southBlock[i];
		}
		setCenterRight();
		
	}
	
	private void setCenterLeft() {
		// 중앙
		int temp = centerBlock[0];
		for(int i=0; i<size-1; i++) {
			centerBlock[i] = centerBlock[i+1];			
		}
		centerBlock[size-1] = temp;
		int cnt = 0;
		for(int i=1; i<3; i++) {
			block[1][i] = centerBlock[cnt++];
		}
		for(int i=2; i>0; i--) {
			block[2][i] = centerBlock[cnt++];
		}
	}
	
	// 반시계방향
	private void left() {
		// 상
		for(int i=0; i<size; i++) {
			block[0][i] = eastBlock[i];
		}
		
		// 우
		for(int i=0; i<size; i++) {
			block[i][size-1] = southBlock[size-i-1];
		}
		
		// 하
		for(int i=0; i<size; i++) {
			block[size-1][i] = westBlock[i];
		}
		
		// 좌
		for(int i=0; i<size; i++) {
			block[i][0] = northBlock[size-i-1];
		}
		
		setCenterLeft();
		
	}
	
	// 선택
	private void select(int sel) {
		if(sel == 1) {
			right();
		}else if(sel == 2){
			left();
		}else {
			System.err.println("유효하지않은 값");
		}
	}
	
	// 종료조건
	private boolean isRun() {
		return true;
	}
	
	private void printBlock() {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.printf("%2d ",block[i][j]);
			}
			System.out.println();
		}
	}
	
	public void run() {
		while(isRun()) {
			setBlock();
			int sel = question();
			select(sel);
			
			printBlock();
		}
	}
}

public class Test03 {

	public static void main(String[] args) {
		int block[][] = {
				{1,0,1,1},
				{0,1,1,1},
				{0,1,1,0},
				{1,1,1,1}
				
		};
//		int block[][] = {
//				{1,2,3,4},
//				{12,13,14,5},
//				{11,15,16,6},
//				{10,9,8,7}
//		};
//		
		// 시계방향 회전 시,
		/*
		 *  1 0 0 1
		 *  1 1 1 0
		 *  1 1 1 1
		 *  1 0 1 1
		 * 
		 */
		
		Game game = new Game(block);
		game.run();

	}

}
