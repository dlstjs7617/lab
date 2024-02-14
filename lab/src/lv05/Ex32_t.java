package lv05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ex32_t {
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

		File file = new File(fileName);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		String[][] board = null;
		
		int count = 0; 			// 전체 게시글 수
		int pageSize = 5;		// 한 페이지에 보여줄 게시글 수
		int curPageNum = 1;		// 현재 페이지 번호
		int pageCount = 0;		// 전체 페이지 개수
		int startRow = 0;		// 현재 페이지의 게시글 시작번호
		int endRow = 0;			// 현재 페이지의 게시글 마지막 번호
		
		if(file.exists()) {
			String data = "";

			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				
				while(br.ready()) {
					data += br.readLine() + "\n";
					count++;
				}
				
				
				br.close();
				fr.close();
				System.out.println("로드 성공");
			}catch (Exception e) {
				System.err.println("로드 실패");
			}
			
			board = new String[count][];
			String[] info = data.split("\n");
			
			for(int i=0; i<count; i++) {
				board[i] = info[i].split("/");
			}
		}
		boolean isRun = true;
		while(isRun) {
			
			startRow = (curPageNum -1) * pageSize;
			endRow = startRow + pageSize-1;
			endRow = endRow >= count ? count -1 : endRow;
			
			pageCount = count / pageSize;
			pageCount = count % pageSize > 0 ? ++pageCount : pageCount;
			
			System.out.println("---- BOARD ----");
			System.out.printf("total : %d \n", count);
			System.out.printf("page : %d \n", curPageNum, pageCount);
			System.out.println("---------------");
			
			for(int i=startRow; i<=endRow; i++) {
				System.out.printf("%d) %s \n", i+1, board[i][0]);
			}
			
			System.out.println("---------------");
			System.out.println("[1]이전");
			System.out.println("[2]이후");
			System.out.println("[3]추가하기");
			System.out.println("[4]삭제하기");
			System.out.println("[5]내용확인");
			System.out.println("---------------");
			
			int choice = sc.nextInt();
			
			if(choice == 1 && 1 < curPageNum)
				curPageNum--;
			else if(choice == 2 && curPageNum < pageCount) {
				curPageNum++;
			}else if(choice == 3) {
				sc.nextLine();
				
				System.out.print("title : ");
				String title = sc.nextLine();
				
				System.out.println("content : ");
				System.out.println("문장의 끝에 .마침표를 붙이면 종료");
								
				String content = "";
				
				while(true) {
					String line = sc.nextLine();
					content += line + "<br>";
					
					if(line.charAt(line.length()-1) == '.')
						break;
				}
				
				String[][] temp = board;
				board = new String[count + 1][];
				
				for(int i=0; i<count; i++)
					board[i] = temp[i];
				
				board[count] = new String[2];	//{null,null}
				board[count][0] = title;
				board[count][1] = content;
				
				count++;
				
			}else if(choice == 4) {
				System.out.println("삭제할 게시글 번호 : ");
				int delIdx = sc.nextInt()-1;
				
				if(delIdx < 0 || delIdx >= count)
					continue;
				
				// 삭제
				String[][] temp = board;
				
				board = new String[count-1][];
				
				int idx = 0;
				for(int i=0; i<count; i++)
					if(i != delIdx)
						board[idx++] = temp[i];
				
				count--;
				
			}else if(choice == 5) {
				System.out.print("조회할 게시글의 번호 : ");
				int idx = sc.nextInt()-1;
				
				if(idx < 0 || idx >= count)
					continue;
				
				//조회
				System.out.println("----------------");
				System.out.printf("제목 : %s \n",board[idx][0]);
				System.out.println("내용 : ");
				 
				String[] content = board[idx][1].split("<br>");
				
				for(int i=0; i<content.length; i++) {
					System.out.println(content[i]);
				}
			}else if(choice == 0) {
				isRun = false;
			}
			
			// 저장
			// title/content
			// ...
			String data = "";
			for(int i=0; i<count; i++) {
				String title = board[i][0];
				String content = board[i][1];
				
				data += title + "/" + content;
				
				if(i < count-1)
					data+= "\n";
			}
			
			try {
				fw = new FileWriter(file);
				fw.write(data);
				fw.close();
				
				System.out.println("저장 성공");
			} catch (Exception e) {
				System.err.println("저장 실패");
			}
			
		}
	}

}
