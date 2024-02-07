package lv05;

import java.io.FileWriter;

public class Ex16 {

	public static void main(String[] args) {
		
		String[] names = { "mom", "megait", "github" };
		String[] pws= { "1111", "2222", "3333" };
		int[] moneys = { 20000, 30000, 40000 };
		
		String fileName = "fileTest02.txt";
		
		String data = "";
		
		// 위 데이터를 아래와 같이 저장해보세요.
		
		// mom/1111/20000
		// megait/2222/30000
		// github/3333/40000
		
		for(int i=0; i<names.length; i++) {
			data += names[i]+"/" + pws[i] +"/" + moneys[i] +"\n";
		}
		
		try {
			
			FileWriter fw = new FileWriter(fileName);
			
			fw.write(data);
			
			fw.close();
			System.out.println("파일 쓰기 성공");
		} catch (Exception e) {
			System.out.println("파일쓰기 실패");
		}
		
	}

}
