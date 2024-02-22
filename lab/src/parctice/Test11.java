package parctice;

import java.util.Arrays;
import java.util.Scanner;

//시작 17:15
//종료 00:00
//소요 00:00

class MiniTetris {
	
	String[][] dataArr; 
	String returnData = "";
	Scanner sc = new Scanner(System.in);
	
	int inputNumber() {
		int num = -1;
		
		try {
			System.out.print("좌표 입력 : ");
			String input = sc.next();
			num = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return num;
	}
	
	void setData(String data) {
		int yCnt = 0;
		int xCnt = 0;
		for(int i=0; i<data.length(); i++) {
			if(data.charAt(i) == '\n') {
				yCnt++;
				if(xCnt == 0)
					xCnt = (i+1)/2;
			}
		}
		
		dataArr = new String[yCnt][xCnt];
		
		inputArr(data);
		
				
	}
	
	void inputArr(String data) {
		int y = 0;
		int x = 0;
		String[] dataSplit = data.split("\n|,");
		for(int i=0; i<dataSplit.length; i++) {
			dataArr[y][x++] = dataSplit[i];
			if(x == dataArr[y].length) {
				y++;
				x = 0;
			}
		}
	}
	
	void block() {
		
	}
	
	String setResult() {
		String result = "";
		
		for(int i=0; i<dataArr.length; i++) {
			for(int j=0; j<dataArr[i].length; j++) {
				result += dataArr[i][j];
				if(j != dataArr[i].length-1)
					result += ",";
			}
			result += "\n";
		}
		
		return result;
	}
	
	
	
	String run(String data , String block) {
		setData(data);
		
		int y = inputNumber();
		int x = inputNumber();

		String returnData = setResult();
		return returnData;
	}
}


public class Test11 {
	public static void main(String[] args) {
		String data = "";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,1,1,1,1,1,1,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,0,0,0,0,0\n";
		
		System.out.println(data);
		
		String block = "";
		block += "2,2,2,2";
		block += "\n0,2,2,0";
		System.out.println(block);
		
		// 좌표 y , x 를 입력받고 block 에 있는 내용을 data 에 복사
		// 예) 1, 1
		/*
			"0,0,0,0,0,1,0,0,0,0\n";
			"0,0,0,0,0,1,0,0,0,0\n";
			"0,0,0,0,0,1,0,0,0,0\n";
			"0,0,1,1,1,1,1,1,0,0\n";
			"0,0,0,0,0,1,0,0,0,0\n";
			"0,0,0,0,0,1,0,0,0,0\n";
			"0,0,0,0,0,1,0,0,0,0\n";
			"0,0,0,0,0,1,0,0,0,0\n";
			"0,0,0,0,0,1,0,0,0,0\n";
			"0,0,0,0,0,0,0,0,0,0\n";
		
		 */
		
		MiniTetris game = new MiniTetris();
		data = game.run(data,block);
		System.out.println(data);
	}
}