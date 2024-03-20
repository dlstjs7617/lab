package test.lv8;
//시작 14:20
//종료 17:56
//소요 03:36

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

class Block {
	private static final int WALL = 1;
	private static final int BLOCK = 2;
	
	private int type;
	
	public Block(int type) {
		this.type = type;
	}
	
	public static int getWall() {
		return WALL;
	}

	public static int getBlock() {
		return BLOCK;
	}
	
	public int getType() {
		return this.type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return String.format(" %d ", type);
	}
}

class Tetris{
	
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Vector<Block>> map;
	
	private int heightSize;
	private int widthSize;
	
	public Tetris(String map, String block) {
		setMap(map);
		setBlock(block);
	}
	
	private Block getBlcok(int i, int j) {
		return map.get(i).get(j);
	}

	private char inputChar(String message) {
		System.out.print(message + " : ");
		String input = sc.next();
		
		char move = input.charAt(0);
		
		return move;
	}
	
	private void loadMap(String[] data) {
		heightSize =data.length;
		for(int i=0; i<heightSize; i++	) {
			Vector<Block> list = new Vector<Block>();
			
			String[] temp = data[i].split(",");
			widthSize = temp.length;
			for(int j=0; j<widthSize; j++) {
				int dataMap = Integer.parseInt(temp[j]);
				Block block = new Block(dataMap);
				
				list.add(block);
			}
			this.map.add(list);
		}
		
	}
	
	private void setMap(String map){
		this.map = new ArrayList<Vector<Block>>();
		
		String[] data = map.split("\n");
		
		loadMap(data);
	}
	
	private void setBlock(String block) {
		String[] data = block.split("\n");
		
		for(int i=0; i<data.length; i++) {
			String[] temp = data[i].split(",");
			
			for(int j=0; j<temp.length; j++) {
				Block tempBlock = getBlcok(i, j);
				int type = Integer.parseInt(temp[j]);
				
				tempBlock.setType(type);
			}
		}
	}
	
	private boolean isRun() {
		return true;
	}
	
	private void printMap() {
		for(int i=0; i<heightSize; i++) {
			for(int j=0; j<widthSize; j++) {
				System.out.print(getBlcok(i, j));
			}
			System.out.println();
		}
	}
	
	private void printMove() {
		System.out.println("==============");
		System.out.println("      방향     ");
		System.out.println("←(a) ↓(s) →(d)");
		System.out.println("==============");
	}
	
	private boolean check(int i, int j, String direction) {
		if(direction.equals("left")) {
			int tempJ = j-1;
			if(tempJ < 0)
				return false;
			
			Block block = getBlcok(i, tempJ);
			if(block.getType() == 1)
				return false;
			
		}else if(direction.equals("down")) {
			int tempI = i+1;
			if(tempI >= heightSize)
				return false;
			
			Block block = getBlcok(tempI, j);
			if(block.getType() == 1)
				return false;
				
		}else if(direction.equals("right")) {
			int tempJ = j+1;
			if(tempJ >= widthSize)
				return false;
			
			Block block = getBlcok(i, tempJ);
			if(block.getType() == 1)
				return false;
		}
		
		return true;
	}
	
	private void moveLeft() {
		for(int i=0; i<heightSize; i++) {
			for(int j=0; j<widthSize; j++) {
				Block block = getBlcok(i, j);
				
				if(block.getType() == 2) {
					Block left = getBlcok(i, j-1);
					int temp = left.getType();
					
					left.setType(block.getType());
					block.setType(temp);	
				}
			}
		}
		
	}
	
	private void left() {
		for(int i=0; i<heightSize; i++) {
			
			for(int j=0; j<widthSize; j++) {
				Block block = getBlcok(i, j);
				
				if(block.getType() == 2) {
					if(!check(i,j,"left")) {
						return;
					}
				}
			}
		}	
		
		moveLeft();
	}
	
	private void moveDown() {
		for(int i=heightSize-1; i>=0; i--) {
			for(int j=0; j<widthSize; j++) {
				Block block = getBlcok(i, j);
				
				if(block.getType() == 2) {
					Block down = getBlcok(i+1, j);
					int temp = down.getType();
					
					down.setType(block.getType());
					block.setType(temp);					
				}
			}
		}
	}
	
	private void down() {
		for(int i=0; i<heightSize; i++) {
			for(int j=0; j<widthSize; j++) {
				Block block = getBlcok(i, j);
				
				if(block.getType() == 2) {
					if(!check(i,j,"down")) {
						return;
					}
				}
			}
		}
		
		moveDown();
	}
	
	private void moveRight() {
		for(int i=0; i<heightSize; i++) {
			for(int j=widthSize-1; j>=0; j--) {
				Block block = getBlcok(i, j);
				
				if(block.getType() == 2) {
					Block right = getBlcok(i, j+1);
					int temp = right.getType();
					
					right.setType(block.getType());
					block.setType(temp);	
				}
			}
		}
	}
	
	private void right() {
		for(int i=0; i<heightSize; i++) {
			for(int j=0; j<widthSize; j++) {
				Block block = getBlcok(i, j);
				
				if(block.getType() == 2) {
					if(!check(i,j,"right")) {
						return;
					}
				}
			}
		}
		
		moveRight();
	}
	
	private void move(char move) {
		if(move == 'a') {
			left();
		}else if(move == 's') {
			down();
		}else if(move == 'd') {
			right();
		}
	}
	
	private void selectMove() {
		printMove();
		char move = inputChar("이동 : ");
		
		move(move);
	}
	
	private void runGame() {
		while(isRun()) {
			printMap();
			selectMove();
		}
	}
	
	public void run() {
		runGame();
	}
}

public class Test03 {

	public static void main(String[] args) {
		// 3. 테트리스
		// ㄴ 방향(a좌d우s하)를 입력할 때마다 해당 블록 이동
		// ㄴ BLOCK(2)는 WALL(1)은 지나갈 수 없다.
		// class : Block, Tetris
		// collection : ArrayList<Vector<Block>> map
		
		String map ="";
		map += "0,0,0,0,0,1,0,0,0,0\n";
		map += "0,0,0,0,0,1,0,0,0,0\n";
		map += "0,0,0,0,0,1,0,0,0,0\n";
		map += "0,0,0,0,0,0,0,0,0,0\n";     // check 
		map += "0,0,0,0,0,1,0,0,0,0\n";
		map += "0,0,0,0,0,1,0,0,0,0\n";
		map += "0,0,0,0,0,1,0,0,0,0\n";
		map += "0,0,0,0,0,1,0,0,0,0\n";
		map += "0,0,0,0,0,1,0,0,0,0\n";
		map += "0,0,0,0,0,0,0,0,0,0\n";
		
		String block = "";
		block += "2,0,0\n";
		block += "2,0,0\n";
		block += "2,2,2\n";
		
//		String block = "2,2,2,2";
		
		Tetris game = new Tetris(map, block);
		game.run();
	}

}