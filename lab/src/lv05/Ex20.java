package lv05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Ex20 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int[] vector = null;
		int count = 0;
		String fileName = "vector.txt";
		
		while(true) {
			
			System.out.println(Arrays.toString(vector));
			
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기"); //값 + 인덱스 + 전체
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");
			
			System.out.println("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(sel == 1	) {	// 추가하기
				System.out.print("입력 : ");
				int num = sc.nextInt();
				int[] temp = vector;
				
				vector = new int[count+1];
				for(int i=0; i<count; i++) {
					vector[i] = temp[i];
				}
				vector[count] = num;
				count++;
			}else if(sel == 2) {	// 삭제하기
				System.out.print("삭제할 인덱스 : ");
				int idx = sc.nextInt();
				if(idx < 0 || idx >= count)
					continue;
				int[] temp = vector;
				vector = new int[count-1];
				int index = 0;
				for(int i=0; i<count; i++) {
					if(i != idx) {
						vector[index++] = temp[i];
					}
				}
				count--;
				
			}else if(sel == 3) {	// 저장하기
				File file = new File(fileName);
				String temp = ""; 
				
				try {
					FileWriter fw = new FileWriter(file);
					for(int i=0; i<vector.length; i++) {
						temp += vector[i];
						if(i != vector.length-1)
							temp +="/";
					}
					System.out.println(temp);
					fw.write(temp);
					
					fw.close();
					System.out.println("저장하기 완료");
				} catch (IOException e) {
					System.out.println("저장하기 실패");
					e.printStackTrace();
				}
			}else if(sel == 4) {	// 로드하기
				File file = new File(fileName);
				String load = "";
				try {
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					
					load += br.readLine();						
					String[] temp = load.split("/");
					
					vector = new int[temp.length];
					for(int i=0; i<temp.length; i++	) {
						vector[i] = Integer.parseInt(temp[i]);
					}
					count = temp.length;
					
					br.close();
					fr.close();
					System.out.println("불러오기 성공");
				} catch (Exception e) {
					System.out.println("불러오기 실패");
					e.printStackTrace();
				}
			}else if(sel == 5) {	// 종료
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

}
