package lv07t;

import java.util.Arrays;

class Test {
	private int code;
	private int size;
	
	// Wrapper Class
	// ㄴ 일반 자료형을 감싸고 있는 클래스
	// ㄴ int -> Integer
	// ㄴ char -> Charater
	// ㄴ boolean -> Boolean
	// ㄴ double -> Double
	// ㄴ float -> Float  
	
//	private char[] data;
	private Character[] data;
	
	public Test(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public Character[] getData() {
		return this.data.clone();
	}
	
	public void setData(Character[] data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return String.format("%d) %d %s", code, size, Arrays.toString(data));
	}
}

public class Ex10 {

	public static void main(String[] args) {
		
		String data = "6\n";
		data += "1/2/a/b\n";
		data += "2/3/a/b/c\n";
		data += "3/5/a/b/c/d/e\n";
		data += "4/4/a/b/c/d\n";
		data += "5/3/a/b/c\n";
		data += "6/1/a";
		
		System.out.println(data);
		String[] info = data.split("\n");
		int size = Integer.parseInt(info[0]);		// 생성할 Test 객체의 개수 -> test 배열의 크기
		
		Test[] test = new Test[size];
		
		for(int i=0; i<size; i++) {
			String[] temp = info[i+1].split("/");
			
			// code
			int code = Integer.parseInt(temp[0]);
			test[i] = new Test(code);
			
			// size
			int dataSize = Integer.parseInt(temp[1]);
			test[i].setSize(dataSize);
			
			// data
//			char[] testData = new char[dataSize];
			Character[] testData = new Character[dataSize];
			for(int j=0; j<dataSize; j++) {
//				testData[j] = new Character(temp[2+j].charAt(0));
				testData[j] = temp[2+j].charAt(0);
			}
			
			test[i].setData(testData);
		}
		
		// data의 정보를 클래스배열에 저장
		for(int i=0; i<size; i++) {
			System.out.println(test[i]);
		}
		
	}

}
