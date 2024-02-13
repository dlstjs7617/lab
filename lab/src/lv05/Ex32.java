package lv05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ex32 {
	/*
	 * # 콘솔 게시판
	 * 1.[이전] 또는 [이후] 버튼을 누르면 페이지 번호가 변경된다.
	 * 2. 현재 페이지 번호에 해당되는 게시글만 볼 수 있다.
	 * 3. 2차원 배열 board에 0열에는 제목을 1열에는 게시글의 내용을 저장한다.
	 * 4. 게시글을 추가하고 삭제할 떄마다 파일입출력을 통해 데이터가 바로바로 저장된다.
	 * 5. 실행시 저장되어 있는 파일이 존재한다면, 바로 파일을 불러오도록 설계한다.
	 */
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		String fileName = "board.txt";
		
		String[][] board = null;
		
		int count = 0; 			// 전체 게시글 수
		int pageSize = 5;		// 한 페이지에 보여줄 게시글 수
		int curPageNum = 1;		// 현재 페이지 번호
		int pageCount = 0;		// 전체 페이지 개수
		int startRow = 0;		// 현재 페이지의 게시글 시작번호
		int endRow = 0;			// 현재 페이지의 게시글 마지막 번호
		
		File file = new File(fileName);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		boolean autoSave = false;
		
		try {
			if(!file.exists()) {
				System.err.println("파일이 없습니다.");
			}else {
				
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			int idx = 0;
			count = Integer.parseInt(br.readLine());
			board = new String[count][2];
			while(br.ready()) {
				String[] saveData = br.readLine().split("/");
				board[idx][0] = saveData[0];
				board[idx++][1] = saveData[1];
			}
			System.out.println("로드 성공");
			
			br.close();
			fr.close();
			}
		} catch (Exception e) {
			System.err.println("로드 실패");
			e.printStackTrace();
		}
		
		
		
		while(true) {
			 if(count%5 > 0) {
				 pageCount = (count/pageSize)+1;
			 }else {
				 pageCount = (count/pageSize);
			 }
			
			startRow = pageSize*(curPageNum-1);
			endRow = startRow+(count-startRow);
			if(endRow > startRow+pageSize)
				endRow = startRow+pageSize;
			
			// 게시판 출력
			System.out.println("====게시판====");
			if(board != null) {
				for(int i=startRow; i<endRow; i++) {
					System.out.printf("%d. %s \n",i+1,board[i][0]);
				}
			}
			System.out.printf("[%d/%dpage](%d) \n",curPageNum,pageCount,count);
			
			System.out.println("-------------");
			System.out.println("[1]이전");
			System.out.println("[2]이후");
			System.out.println("[3]추가하기");
			System.out.println("[4]삭제하기");
			System.out.println("[5]내용확인");
			System.out.println("-------------");
			
			int sel = sc.nextInt();
			
			if(sel == 1) {
				if(curPageNum == 1)
					continue;
				else {
					curPageNum--;				
				}
			}else if(sel == 2) {
				if(curPageNum == pageCount)
					continue;
				else {
					curPageNum++;
				}
			}else if(sel == 3) {
				System.out.print("제목 입력 : ");
				String title = sc.nextLine();
				sc.next();
				System.out.print("내용 입력 : ");
				String content =""; 
				while(true) {
					content += sc.nextLine();
					if(sc.nextLine().length() == 0)
						break;
				}
				
				String[][] tempBoard = board;
				board = new String[count+1][2];
				
				for(int i=0; i<count; i++) {
					board[i] = tempBoard[i];
				}
				
				board[count][0] = title;
				board[count][1] = content;
				
				count++;
				autoSave = true;
			}else if(sel == 4) {
				System.out.print("삭제할 게시글 번호 : ");
				int num = sc.nextInt()-1;
				
				if(num+1 < 0 || num+1 >= count)
					continue;
				
				String[][] tempBoard = board;
				board = new String[count-1][];
				
				int cnt =0;
				for(int i=0; i<count; i++) {
					if(i != num)
						board[cnt++] = tempBoard[i];
				}
				
				count--;
				autoSave = true;
			}else if(sel == 5) {
				System.out.print("조회할 게시글 번호 : ");
				int num = sc.nextInt()-1;
				
				if(num+1 < 0 || num+1 >= count)
					continue;
				
				System.out.println("====게시글====");
				System.out.printf("%d. %s \n",num+1,board[num][0]);
				System.out.printf("내용  %s \n",board[num][1]);
				System.out.println("============");
			}
			
			
			if(autoSave) {
				try {
					String save = "";
					save += count +"\n";
					fw = new FileWriter(file);

					
					for(int i=0; i<board.length; i++) {
						save += board[i][0] + "/";
						save += board[i][1] + "\n";
					}
						
						fw.write(save.substring(0,save.length()-1));
					
					fw.close();
					
					System.out.println("저장 성공");
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println("저장 실패");
				}
				autoSave = false;
			}
		}
		
	}

}
