package lv05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Ex22 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int jangCount = 0;
		int[][] jang = null; //{log, itemNum}
		
		int count = 1;
		String[] ids = {"admin"};
		String[] pws = {"1234"};
		
		int itemCount = 3;
		String[] items = {"사과", "바나나", "딸기"};
		
		String fileName = "jang.txt"; // 자동저장 및 로드
		String userFileName = "user.txt";
		String itemFileName = "item.txt";
		
		int log = -1;
		
		File jangFile = new File(fileName);
		File userFile = new File(userFileName);
		File itemFile = new File(itemFileName);
		
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		//자동 로드
		if(userFile.exists()) {
			try {
				fr = new FileReader(userFile);
				br = new BufferedReader(fr);
				
				String data = "";
				count = 0;
				
				data += br.readLine();
				String[] dataArr = data.split(",");
				
				count = dataArr.length/2;
				ids = new String[count];
				pws = new String[count];
				
				int idx = 0;
				for(int i=0; i<dataArr.length; i+=2) {
					ids[idx] = dataArr[i];
					pws[idx] = dataArr[i+1];
					idx++;
				}
				
				
				br.close();
				fr.close();
				System.out.println("유저파일 읽기 성공");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("유저파일읽기 실패");
			}
		}
		if(jangFile.exists()) {
			try {
				fr = new FileReader(jangFile);
				br = new BufferedReader(fr);
				
				String data ="";
				jangCount = 0;

				data += br.readLine();
				String[] dataArr = data.split(",");
				jangCount = dataArr.length/2;
				jang = new int[jangCount][2];
				
				int idx = 0;
				for(int i=0; i<dataArr.length; i+=2) {
					jang[idx][0] = Integer.parseInt(dataArr[i]);
					jang[idx][1] = Integer.parseInt(dataArr[i+1]);
					idx++;
				}
				
				
				br.close();
				fr.close();
				System.out.println("장바구니 읽기 성공");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("장바구니 읽기 실패");
			}
		}
		
		if(itemFile.exists()) {
			try {
				fr = new FileReader(itemFile);
				br = new BufferedReader(fr);
				
				String data = "";
				itemCount = 0;
				data += br.readLine();
				
				String[] dataArr = data.split(",");
				itemCount = dataArr.length;
				
				items = new String[itemCount];
				
				for(int i=0; i<dataArr.length; i++) {
					items[i] = dataArr[i];
				}
				
				System.out.println("아이템 읽기 성공");
			} catch (Exception e) {
				System.out.println("아이템 읽기 실패");
				e.printStackTrace();
			}
		}
		
		while(true) {
			
			boolean userSave = false;
			boolean jangSave = false;
			boolean itemSave = false;
			
			
			
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
			
			if(sel == 1 && log == -1) {				//회원가입
				System.out.print("ID : ");
				String id = sc.next();
				System.out.print("PW : ");
				String pw = sc.next();
				
				boolean isDupl = false;
				
				for(int i=0; i<count; i++) {
					if(id.equals(ids[i]))
						isDupl = true;
				}
				
				if(!isDupl) {
					String[] idsTemp = ids;
					String[] pwsTemp = pws;
					
					ids = new String[count+1];
					pws = new String[count+1];
					
					for(int i=0; i<count; i++) {
						ids[i] = idsTemp[i];
						pws[i] = pwsTemp[i];
					}
					
					ids[count] = id;
					pws[count] = pw;
					count++;
					userSave = true;
				}else {
					System.out.println("이미 있는 아이디입니다.");
				}
					
			}else if(sel == 2 && log != -1) {		//회원탈퇴
				System.out.print("PW : ");
				String pw = sc.next();
				
				if(pw.equals(pws[log])) {
					String[] idsTemp = ids;
					String[] pwsTemp = pws;
					
					ids = new String[count-1];
					pws = new String[count-1];
					
					int idx = 0;
					for(int i=0; i<count; i++) {
						if(log != i) {
							ids[idx] = idsTemp[i];
							pws[idx] = pwsTemp[i];
							idx++;
						}
					}
					
					int delCnt = 0;
					for(int i=0; i<jangCount; i++) {
						if(jang[i][0] == log) {
							delCnt++;
						}
					}
					
					int[][] jangTemp = jang;
					jang = new int[jangCount-delCnt][];
					
					idx = 0;
					for(int i=0; i<jangCount; i++) {
						if(jangTemp[i][0] != log) {
							if(jangTemp[i][0] >= log)
								jangTemp[i][0] -= 1;
							jang[idx++] = jangTemp[i];
						}
					}
					jangCount -= delCnt;
					
					count--;
					log = -1;
					
					userSave = true;
					System.out.println("회원탈퇴 완료");
				}else {
					System.out.println("비밀번호가 다릅니다.");
				}
				
			}else if(sel == 3 && log == -1) {		//로그인
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
				
				
			}else if(sel == 4 && log != -1) {		//로그아웃
				log = -1;
				System.out.println("로그아웃");
			}else if(sel == 5 && log != -1) {		//쇼핑
				for(int i=0; i<itemCount; i++)
				System.out.printf("%d.%s  \n", i+1, items[i]);
				
				System.out.print("선택 : ");
				int input = sc.nextInt()-1;
				
				if(input < 0 || input >= itemCount) {
					System.out.println("유효하지않는 숫자");
					continue;
				}
				
				// 로그삭제
				int[][] jangTemp = jang;
				jang = new int[jangCount+1][2];
				
				for(int i=0; i<jangCount; i++) {
					jang[i][0] = jangTemp[i][0];
					jang[i][1] = jangTemp[i][1];
				}
				
				jang[jangCount][0] = log;
				jang[jangCount][1] = input;
				
				jangCount++;
				jangSave = true;
				
			}else if(sel == 6 && log != -1) {		//장바구니
				
				int[] temp = new int[itemCount];
				for(int i=0; i<jangCount; i++) {
					if(jang[i][0] == log) {
						temp[jang[i][1]]++;
					}
				}
				
				System.out.printf("%s회원님의 장바구니 \n",ids[log]);
				for(int i=0; i<itemCount; i++) {
					System.out.printf("%s : %d개 \n", items[i], temp[i]);
				}
				
				
			}else if(sel == 7 && log == 0) {		//관리자
				if(log == 0) {
					System.out.println("관리자님 환영합니다.");
				}else {
					System.out.println("관리자 계정이 아닙니다.");
					continue;
				}
				
				System.out.println("1.아이템 추가  2.아이템 삭제");
				System.out.print("선택 : ");
				int input = sc.nextInt()-1;
				
				if(input == 0) {
					System.out.print("추가할 아이템 : ");
					String item = sc.next();
					
					String[] itemsTemp = items;
					items = new String[itemCount+1];
					
					for(int i=0; i<itemCount; i++) {
						items[i] = itemsTemp[i];
					}
					
					items[itemCount] = item;
					itemCount++;
					itemSave = true;
				}else if(input == 1) {
					
					for(int i=0; i<itemCount; i++)
						System.out.printf("%d.%s  \n", i+1, items[i]);
					
					System.out.print("삭제할 아이템 번호 : ");
					int item = sc.nextInt() -1;
					
					
					if(item < 0 || item >= itemCount) {
						System.out.println("없는 아이템입니다");
						continue;
					}
					
					String[] tempItem = items;
					items = new String[itemCount-1];
					
					int idx = 0;
					for(int i=0; i<itemCount; i++) {
						if(item != i)
							items[idx++] = tempItem[i]; 
					}
					itemCount--;
					
					//로그삭제
					
					int delCnt = 0;
					for(int i=0; i<jangCount; i++) {
						if(jang[i][1] == item) {
							delCnt++;
						}
					}
					
					int[][] jangTemp = jang;
					jang = new int[jangCount-delCnt][];
					
					idx = 0;
					for(int i=0; i<jangCount; i++) {
						if(jangTemp[i][1] != item) {
							if(jangTemp[i][1] > item)
								jangTemp[i][1] -= 1;
							jang[idx++] = jangTemp[i];
						}
					}
					jangCount -= delCnt;
					
					itemSave = true;
					jangSave = true;
				}
			}else if(sel == 0) {		//종료
				break;
			}
			
			// 자동 저장	
			if (userSave) {
				try {
					fw = new FileWriter(userFile);

					String data = "";
					for (int i = 0; i < count; i++) {
						data += ids[i] + ",";
						data += pws[i];
						if (i != count - 1)
							data += ",";
					}
					fw.write(data);

					fw.close();
					System.out.println("유저저장 성공");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("유저저장 실패");
				}
			}
			if (jangSave) {
				try {
					fw = new FileWriter(jangFile);

					String data = "";
					for (int i = 0; i < jangCount; i++) {
						data += jang[i][0] + ",";
						data += jang[i][1];
						if (i != jangCount - 1)
							data += ",";
					}
					fw.write(data);

					fw.close();
					System.out.println("장바구니 저장 성공");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("장바구니 저장 실패");
				}
			}

			if (itemSave) {
				try {
					fw = new FileWriter(itemFile);

					String data = "";
					for (int i = 0; i < itemCount; i++) {
						data += items[i];
						if (i != itemCount - 1)
							data += ",";
					}
					fw.write(data);

					fw.close();
					System.out.println("아이템 저장 성공");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("아이템 저장 실패");
				}
			}
			
		}
		
	}

}
