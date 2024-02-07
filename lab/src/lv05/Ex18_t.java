package lv05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Ex18_t {

	public static void main(String[] args) {
		String[] ids = null;
		String[] pws = null;
		int[] moneys = null;
		
		String fileName ="fileTest02.txt";
		
		File file = new File(fileName);
		
		
		
		FileReader fr = null;
		BufferedReader br = null;
		
		String data ="";
		
		if(file.exists()) {	// 파일 존재 여부
			try {
				fr = new FileReader(file);	// new FileReader(fileName);
				br = new BufferedReader(fr);
				
				while(br.ready()) {		// 읽어올 데이터가 있는 경우 boolean
					data += br.readLine() + "\n";
				}
				
//				String line= br.readLine();
//				while(line != null) {
//					data += line + "\n";
//					line = br.readLine();
//				}		
				br.close();
				fr.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			System.err.println("파일이 경로에 존재하지 않습니다.");
		}
		
		String[] temp = data.split("\n");
		int cnt = temp.length;
		ids = new String[cnt];
		pws = new String[cnt];
		moneys = new int[cnt];
		
		for(int i=0; i<cnt; i++) {
			String[] info = temp[i].split("/");
			
			ids[i] = info[0];
			pws[i] = info[1];
			moneys[i] = Integer.parseInt(info[2]);
		}
		
		System.out.println(Arrays.toString(ids));
		System.out.println(Arrays.toString(pws));
		System.out.println(Arrays.toString(moneys));
	}

}
