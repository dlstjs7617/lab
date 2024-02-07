package lv05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.annotation.processing.Filer;

public class Ex22_t {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		final String ADMIN = "admin";
		
		final String menus ="2456";
		
		int jangCount = 0;
		int[][] jang = null; //{log, itemNum}
		
		int count = 1;
		String[] ids = {"admin"};
		String[] pws = {"1234"};
		
		int itemCount = 3;
		String[] items = {"사과", "바나나", "딸기"};
		
		String jangFileName = "jang.txt"; // 자동저장 및 로드
		String userFileName = "user.txt";
		
		int log = -1;
		
		File jangFile = new File(jangFileName);
		File userFile = new File(userFileName);
		
		FileWriter fw =null;
		FileReader fr = null;
		BufferedReader br =null;
		
		//모든 파일을 로드 -> 각 배열에 정보 저장
		if(jangFile.exists()) {
			String data = "";
			try {
				fr = new FileReader(jangFile);
				br = new BufferedReader(fr);
				
				items = br.readLine().split(","); // 첫 줄은 아이템들(,)
				itemCount = items.length;
				
				while(br.ready()) {
					data += br.readLine() + "\n";
					jangCount++;
				}
				
				br.close();
				fr.close();
				System.out.println("장바구니 파일 로드 완료");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("장바구니 파일 로드 실패");
			}
			
			jang = new int[jangCount][2];
			
			String[] temp = data.split("\n");
			
			for(int i=0; i<jangCount; i++) {
				String[] info = temp[i].split("/");
				
				jang[i][0] = Integer.parseInt(info[0]); 
				jang[i][1] = Integer.parseInt(info[1]); 
			}
			
			
		}
		
		if(userFile.exists()) {
			
			try {
				fr = new FileReader(userFile);
				br = new BufferedReader(fr);
				
				// 첫 줄에 count
				count = Integer.parseInt(br.readLine());
				
				ids = new String[count];
				pws = new String[count];
				
				for(int i=0; i<count; i++) {
					String[] info = br.readLine().split("/");
					
					ids[i] = info[0];
					pws[i] = info[1];
				}
				
				br.close();
				fr.close();
				System.out.println("유저 파일 로드 성공");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("유저 파일 로드 실패");
			}
		}
	
		while(true) {
			
			boolean isUserUpdate = false;
			boolean isJangUpdate = false;
			System.out.println(Arrays.toString(ids));
			System.out.println(Arrays.toString(pws));
			for(int i=0; i<jangCount; i++) {
				System.out.printf("[%d , %d] \n",jang[i][0],jang[i][1]);
			}
			System.out.println("[SHOP]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]쇼핑");
			System.out.println("[6]장바구니");	//아이템 추가, 아이템 삭제
			System.out.println("[7]관리자");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(log == 0 && sel == 2) {
				System.out.println("관리자계정은 회원탈퇴 불가");
				continue;
			}
			
			// 로그 상태에 대한 메뉴 선택 예외처리
			if(log == -1 && menus.contains(String.valueOf(sel))) {
				System.out.println("로그인 후 이용가능");
				continue;
			}
			
			if(sel != 0 && log != -1 && !menus.contains(sel + "")) {
				System.out.println("로그아웃을 해야합니다");
				continue;
			}
			
			
			if(sel == 1) {				//회원가입
				System.out.print("ID :");
				String id = sc.next();
				System.out.print("PW :");
				String pw = sc.next();
				
				int idx = -1;
				for(int i=0; i<count;) {
					if(id.equals(ids[i]))
						idx = i;
				}
				
				if(idx != -1) {
					System.out.println("중복된 아이디 입니다.");
					continue;
				}
				
				// add user
				String[] tempIds = ids;
				String[] tempPws = pws;
				ids = new String[count+1];
				pws = new String[count+1];
				
				for(int i=0; i<count; i++) {
					ids[i] = tempIds[i];
					pws[i] = tempPws[i];
				}
				
				ids[count] = id;
				pws[count++] = pw;
				isUserUpdate = true;
			}else if(sel == 2) {		//회원탈퇴
				System.out.print("PW : ");
				String pw = sc.next();
				
				if(ids[log].equals(ADMIN)) {
					System.out.println("관리자 계정은 사측에 문의하십시오.");
					continue;
				}
				
				if(!pw.equals(pws[log])) {
					System.out.println("패스워드가 일치하지 않습니다.");
					continue;
				}
				
				String[] tempIds = ids;
				String[] tempPws = pws;

				ids = new String[count-1];
				pws = new String[count-1];
				
				int idx = 0;
				for(int i=0; i<count; i++) {
					if(log != i) {
						ids[idx] = tempIds[i];
						pws[idx] = tempPws[i];
						idx++;
					}
				}
				
				// 장바구니 내역 삭제
				int delCnt = 0;
				for(int i=0; i<jangCount; i++) {
					if(jang[i][0] == log) {
						delCnt++;
					}
				}
				
				int[][] tempJang = jang;
				jang = new int[jangCount-delCnt][];
				
				idx = 0;
				for(int i=0; i<jangCount; i++) {
					if(tempJang[i][0] != log) {
						if(tempJang[i][0] > log)
							tempJang[i][0] -= 1;
						jang[idx++]= tempJang[i];
					}
				}
				jangCount -= delCnt;
				
				count--;
				log = -1;
				isUserUpdate = true;
				isJangUpdate = true;
			}else if(sel == 3) {		//로그인
				System.out.print("ID : ");
				String id = sc.next();
				System.out.print("PW : ");
				String pw = sc.next();
				
				for(int i=0; i<count; i++) {
					if(id.equals(ids[i]) && pw.equals(pws[i])) {
						log = i;
					}
				}
				
				if(log == -1) {
					System.out.println("아이디/비밀번호가 다릅니다.");
				}else {
					System.out.printf("로그인 완료 %s님 환영합니다 \n", ids[log]);
				}
				
				
			}else if(sel == 4) {		//로그아웃
				log = -1;
				System.out.println("로그아웃");
				
			}else if(sel == 5) {		//쇼핑
				while(true) {
					for(int i=0; i<itemCount; i++)
						System.out.printf("%d.%s  \n", i+1, items[i]);
					System.out.println("0) 뒤로가기");
					System.out.print("선택 : ");
					int itemNum = sc.nextInt()-1;
					
					if(itemNum == 0)
						break;
					
					if(itemNum < 0 || itemNum >= itemCount)
						continue;
					
					// 구매이력을 jang에 기록
					int[][] jangTemp = jang;
					jang = new int[jangCount+1][];
					
					for(int i=0; i<jangCount; i++) {
						jang[i] = jangTemp[i];
					}
					
					jang[jangCount] = new int[2];					
					jang[jangCount][0] = log;
					jang[jangCount][1] = itemNum;
					
					jangCount++;
				}
				
			}else if(sel == 6) {		//장바구니
				// 소계 출력용 item count 배열 선언 & 초기화
				int[] tempCount = new int[itemCount];
				
				for(int i=0; i<jangCount; i++) {
					if(jang[i][0] == log) {
						int itemIdx = jang[i][1] -1;
							tempCount[itemIdx] ++;
					}
				}
				
				//소계 출력
				for(int i=0; i<itemCount; i++) {
					if(tempCount[i] > 0)
						System.out.printf("(%s) %d개 \n	", items[i],jang[i][1]);
				}
				
				System.out.printf("%s회원님의 장바구니 \n",ids[log]);
				for(int i=0; i<itemCount; i++) {
					System.out.printf("%s : %d개 \n", items[i], tempCount[i]);
				}
				
				
			}else if(sel == 7) {		//관리자
				if(!ids[log].equals(ADMIN)) {
					System.out.println("관리자 계정만 사용 가능합니다.");
					continue;
				}
				
				while(true) {
					System.out.println("1) 아이템추가");
					System.out.println("2) 아이템삭제");
					System.out.println("0) 뒤로가기");
					System.out.print("메뉴 : ");
					int subSel = sc.nextInt();
					
					if(subSel == 0) {
						break;
					}
					
					if(subSel == 1) {
						System.out.print("아이템명 : ");
						String itemName = sc.next();
						
						//중복 예외처리
						boolean isDupl =false;
						for(int i=0; i<itemCount; i++) {
							if(itemName.equals(items[i]))
								isDupl = true;
						}
						if(isDupl) {
							System.out.println("증복된 아이템 항목이 존재합니다.");
							continue;
						}
						
						//아이템 추가
						String[] tempItems =items;
						items = new String[itemCount+1];
						
						for(int i=0; i<itemCount; i++) {
							items[i] = tempItems[i];
							
						items[itemCount++] = itemName;
						}
						
					}else if(subSel == 2) {
						for(int i=0; i<itemCount; i++) {
							System.out.printf("%d) %s\n", i+1, items[i]);
						}
						System.out.print("삭제핳 아이템 번호 : ");
						int delIdx = sc.nextInt()-1;
						
						if(delIdx < 0 || delIdx >= itemCount)
							continue;
						//아이템 삭제
						String[] tempItems =items;
						items = new String[itemCount+1];
						
						int idx = 0;
						for(int i=0; i<itemCount; i++) {
							if(i != delIdx)
								items[idx++] = tempItems[i];
						}
						itemCount--;
						
						// 장바구니 이력 정리
						int delCnt =0;
						for(int i=0; i<jangCount; i++) {
							if(jang[i][1] == delIdx+1)
								delCnt++;
						}
						
						int[][] tempJang = jang;
						jang = new int[jangCount - delCnt][];
						
						idx = 0;
						
						for(int i=0; i<jangCount; i++) {
							if(tempJang[i][1] > delIdx+1)
								tempJang[i][1] -= 1;
							if(tempJang[i][1] != delIdx+1)
								jang[i] = tempJang[i];
						}
						
						jangCount -= delCnt;
						
						
					}
				}
				
				
			}else if(sel == 0) {		//종료
				break;
			}
			
			if(isUserUpdate) {
				// user.txt 저장
				String data = "";
				data+= count + "\n";
				
				for(int i=0; i<count; i++) {
					data += ids[i] + "/" + pws[i];
					if(i < count -1)
						data += "\n";
				}
				try {
					fw = new FileWriter(userFile);
					fw.write(data);
					fw.close();
					
					System.out.println("유저 파일 저장 성공");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("유저 파일 저장 실패");
				}
			}
			
			if(isJangUpdate) {
				String data = "";
				
				for(int i=0; i<itemCount; i++) {
					data+= items[i];
					if(i < itemCount -1)
						data+=",";
				}
				data+= "\n";
				
				// 장바구니 내역 확장
				for(int i=0; i<jangCount; i++) {
					data += jang[i][0] +"/" + jang[i][1];
					if(i < jangCount -1)
						data+= "\n";
				}
				
				try {
					fw = new FileWriter(jangFile);
					fw.write(data);
					
					fw.close();
					
					System.out.println("장바구니 파일 저장 성공");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("장바구니 파일 저장 실패");
				}
			}
		}
		
	}

}
