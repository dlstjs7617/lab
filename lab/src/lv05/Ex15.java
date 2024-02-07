package lv05;

import java.io.FileWriter;

public class Ex15 {

	public static void main(String[] args) {
	
		// 김철수/20,이만수/30,이영희/40
		
		String[] names = {"김철수","이만수","이영희"};
		int[] ages = { 20, 30, 40,};
		
		String fileName = "fileTest02.txt";
		
		String data ="";
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(fileName);
			
//			for(int i=0; i<ages.length; i++) {
//				data+=names[i]+"/"+ages[i];
//				if(i != ages.length) {
//					data+=",";
//				}
//			}
			for(int i=0; i<ages.length; i++) {
				fw.write(names[i]+"/"+ages[i]);				
			}
			
			System.out.println("파일쓰기 완료");
			
			fw.close();
		} catch (Exception e) {
			System.out.println("파일쓰기 오류");
		}
		
		
	}

}
