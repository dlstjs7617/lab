package lv07;

import java.util.Arrays;

class Test {
	private int code;
	private int size;
	private char[] data;
	
	public void setCode(int code) {
		this.code = code;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public char[] getData() {
		return data;
	}
	
	public void setData(char[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.format("code(%d), size(%d), data %s", code, size, Arrays.toString(data));
	}
}

public class Ex10 {

	public static void main(String[] args) {
		
		int size = 0;
		
		String data = "6\n";
		data += "1/2/a/b\n";
		data += "2/3/a/b/c\n";
		data += "3/5/a/b/c/d/e\n";
		data += "4/4/a/b/c/d\n";
		data += "5/3/a/b/c\n";
		data += "6/1/a";
		
		System.out.println(data);
		
		Test[] test;
		// data의 정보를 클래스배열에 저장
		
		String[] dataArr = data.split("\n");
		size = Integer.parseInt(dataArr[0]);
		
		test = new Test[size];
		
		for(int i=0; i<dataArr[i+1].length(); i++) {
			test[i] = new Test();
			
			String[] inputData = dataArr[i+1].split("/");
			
			test[i].setCode(Integer.parseInt(inputData[0]));
			test[i].setSize(Integer.parseInt(inputData[1]));
			
			char[] temp = new char[test[i].getSize()];
		
			for(int j=0; j<temp.length; j++) {
				temp[j] = inputData[j+2].charAt(0);
			}
			
			test[i].setData(temp);
			
			System.out.println(test[i]);
		}
		
	}

}
