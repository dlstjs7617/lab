	package parctice;
	
	import java.util.Arrays;
	import java.util.Scanner;
	//
	//시작 17:15   10:00
	//종료 18:50   11:44
	//소요 01:35 + 01:44
	//총 소요  03:19
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
		boolean yXExcetion(int x , int y) {
			if(x < 0 || y < 0 || y >= dataArr.length || x >= dataArr[y].length ) {
				System.out.println("유효하지 않은 좌표값입니다");
				return true;
			}
			
			return false;
		}
		void block(int y , int x , String block) {
			String[] tempArr = block.split(",");
			int index = 0;
			for(int i=0; i<tempArr.length; i++) {
				if(tempArr[i].contains("\n"))
					index= i;
			}
			System.out.println("temp : " + index);
			tempArr = block.split("\n|,");
			
			if(!setblockCheck(y, x, tempArr , index))
				return;
			
			int tempX = x;
			for(int i=0; i<tempArr.length; i++) {
				if(i == index) {
					y++;
					tempX = x;
					continue;
				}
				if(tempArr[i].equals("0")) {
					tempX++;
					continue;
				}
				
				dataArr[y][tempX++] = tempArr[i];
			
			}
			
		}
		
		boolean setblockCheck(int y, int x, String[] tempArr, int index) {
			boolean result = true;
			
			int tempX = x;
			int tempY = y;
			for(int i=0; i<tempArr.length; i++) {
				if(tempX == dataArr[tempY].length) {
					System.out.println("범위 초과");
					result = false;
					break;
				}
				System.out.println(tempX +" tempX");
				if(dataArr[tempY][tempX++].equals("1") && !tempArr[i].equals("0")) {
					System.out.println("1이 있어 안됩니다.");
					result = false;
					break;
				}
				if(i == index) {
					tempY++;
					tempX = x;
				}
			}
			
			return result;
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
			
			int y = 0;
			int x = 0;
			while(true) {
				System.out.print("y : ");
				y = inputNumber();
				System.out.print("x : ");
				x = inputNumber();			
				if(!yXExcetion(x , y))
					break;
			}
			block(y ,x ,block);
			
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
	//		block += "2,2,2,2";
	//		block += "\n0,2,2,0";
			block += "2,2,0";
			block += "\n0,2,2";
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