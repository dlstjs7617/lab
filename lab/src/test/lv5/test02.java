package test.lv5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class test02 {
	//시작 10:42
	//종료 11:46
	//소요 00:54
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] vector = null;
		int count = 0;
		
		String fileName = "vector.txt";
		File file = new File(fileName);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		while(true) {
			
			if(vector != null) {
				for(int i=0; i<count; i++) {
					System.out.printf("vector[%d] : %d \n",i ,vector[i]); 
				}				
			}
			System.out.println("count : " + count);
			System.out.println("[벡터컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기");
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");
			System.out.print("입력 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {					//추가
				System.out.print("값: ");
				int num = sc.nextInt();
				
				int[] temp = vector;
				vector = new int[count+1];
				
				for(int i=0; i<count; i++) {
					vector[i] = temp[i];
				}
				vector[count] = num;
				count++;
				
			}else if(sel == 2 && count != 0) {			//삭제
				System.out.print("삭제할 인덱스 : ");
				int idx = sc.nextInt();
				
				if(idx < 0 || idx >= count) {
					System.err.println("유효하지않은 인덱스범위입니다.");
					continue;
				}
				
				
				int[] temp = vector;
				vector = new int[count-1];
				int cnt = 0;
				for(int i=0; i<count; i++) {
					if(i != idx) {						
						vector[cnt++] = temp[i];
					}
				}
				
				count--;
				
			}else if(sel == 3) {			//저장
				
				String save = "";
				
				for(int i=0; i<count; i++) {
					save += vector[i];
					if(i != count-1)
						save += "\n";
				}
				
				try {
					fw = new FileWriter(file);
					
					fw.write(save);
					
					fw.close();
					System.out.println("저장성공");
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println("저장실패");
				}
			}else if(sel == 4) {			//로드
				if(file.exists()) {
					String load = "";
					
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						
						while(br.ready()) {
							load += br.readLine()+"\n";
						}
						if(!load.isEmpty()) {
						
						String[] loadArr = load.split("\n");
						count= loadArr.length;
						vector = new int[count];
						
						for(int i=0; i<count; i++) {
							vector[i] = Integer.parseInt(loadArr[i]);
						}
						
						System.out.println("로드성공");
						}else {
							System.err.println("파일이 비어있습니다.");
						}
						br.close();
						fr.close();
					} catch (Exception e) {
						e.printStackTrace();
						System.err.println("로드실패");
					}
				
				}else {
					System.err.println("저장된 파일이 없습니다.");
				}
			}else if(sel == 5) {			//종료
				break;
			}
		}
		
		 
	}

}
