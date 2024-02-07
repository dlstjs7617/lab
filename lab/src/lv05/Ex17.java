package lv05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex17 {

	public static void main(String[] args) {
	
		// 파일 처리
		// 2) 읽기 FileReader, bufferedReader
		
		FileReader fr = null;
		BufferedReader br = null;
		
		String fileName = "test.txt";
		
		// 1. 예외처리 IOExceptio
		try {
			fr = new FileReader(fileName); // 지정한 파일이 존재하면 붙들어 둠
			br = new BufferedReader(fr);
			
			String data = br.readLine();	//읽지 않은 새로운 문자열 한 줄만 읽음
			System.out.println("data : " + data);
			
			br.close();
			fr.close();
			System.out.println("파일읽기 완료");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일읽기 실패");
		}
	}

}
