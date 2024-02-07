package lv05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Ex21_t {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final int SIZE = 5;
		int count = 0;
		int log = -1;
		
		String[] accs = new String[SIZE];
		String[] pws = new String[SIZE];
		int[] moneys = new int[SIZE];
		
		String fileName = "atm.txt";
		
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		while(true) {
			
			System.out.println(Arrays.toString(accs));
			System.out.println(Arrays.toString(pws));
			System.out.println(Arrays.toString(moneys));
			
			System.out.println("==[ATM]==");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]입금");
			System.out.println("[6]출금");
			System.out.println("[7]이체");
			System.out.println("[8]잔액조회");
			System.out.println("[9]저장");
			System.out.println("[10]로드");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(count == SIZE && sel == 1) {
				if(count == SIZE) {
					System.out.println("더 이상 회원가입이 불가능합니다");
					continue;
				}
			if(sel == 1 && log == -1) {			// 회원가입
					
					System.out.print("id : ");
					String id = sc.next();
					System.out.print("pw : ");
					String pw = sc.next();
					
					// 중복 예외처리
					boolean isDupl = false;
					for(int i=0; i<count; i++) {
						if(id.equals(accs[i]))
							isDupl = true;
					}
					
					if(!isDupl) {
						String[] accsTemp = accs;
						String[] pwsTemp = pws;
						int[] moneysTemp = moneys;
						
						accs = new String[count+1];
						pws = new String[count+1];
						moneys = new int[count+1];
						
						for(int i=0; i<count; i++) {
							accs[i] = accsTemp[i];
							pws[i] = pwsTemp[i];
							moneys[i] = moneysTemp[i];
						}
						
						accs[count] = id;
						pws[count] = pw;
						moneys[count] = 1000; //가입 축하금
						
						count++;
					}else {
						System.out.println("중복된 계정입니다");
					}
				}
				
			}else if(sel == 2 && log != -1) {	// 회원탈퇴
				System.out.print("pw : ");
				String pw = sc.next();
				
				if(pw.equals(pws[log])) {
					String[] accsTemp = accs;
					String[] pwsTemp = pws;
					int[] moneysTemp = moneys;
					
					accs = new String[count-1];
					pws = new String[count-1];
					moneys = new int[count-1];
					
					int idx =0;
					for(int i=0; i<count; i++) {
						if(i != log	) {
							accs[idx] = accsTemp[i];
							pws[idx] = pwsTemp[i];
							moneys[idx] = moneysTemp[i];
							idx++;
						}
					}
					
					count --;
					log = -1;
				}
				
			}else if(sel == 3 && log == -1) {	// 로그인
				System.out.print("id : ");
				String id = sc.next();
				System.out.print("pw : ");
				String pw = sc.next();
				
				for(int i=0; i<count; i++) {
					if(id.equals(accs[i]) && pw.equals(pws[i]))
						log = i;
				}
				
				if(log == -1)
					System.out.println("회원정보를 확인해주세요.");
				
			}else if(sel == 4 && log != -1) {	// 로그아웃
				System.out.println("로그아웃되셨습니다.");
				log = -1;
				
			}else if(sel == 5 && log != -1) {	// 입금
				System.out.print("입금 금액 : ");
				int money = sc.nextInt();
				
				if(money > 0) {
					moneys[log] += money;
				}else
					System.out.println("0원 이하 입금 불가");
					
				
				
				
			}else if(sel == 6 && log != -1) {	// 출금
				System.out.print("출금 금액 : ");
				int money = sc.nextInt();
				
				if(moneys[log] >= money  && money > 0) {
					moneys[log] -= money;
				}else
					System.out.println("출금금액 오류");
					
				
				
			}else if(sel == 7 && log != -1) {	// 이체
				System.out.print("이체할 계좌 : ");
				String acc = sc.next();
				System.out.print("이체할 금액 : ");
				int money = sc.nextInt();
				
				int targetIdx = -1;
				for(int i=0; i<count; i++) {
					if(acc.equals(accs[i]))
						targetIdx = i;
				}
				
				if(targetIdx == -1) {
					System.out.println("존재하지 않는 계좌정보입니다.");
					continue;
				}

				if(targetIdx == log) {
					System.out.println("본인 계좌로의 이체는 불가합니다.");
					continue;
				}
				
				if(money < 1) {
					System.out.println("이체 가능한 금액이 아닙니다.");
					continue;
				}
				
				if(moneys[log] < money) {
					System.out.println("잔액부족");
					continue;
				}
				
				moneys[log] -= money;
				moneys[targetIdx] += money;
				System.out.println("이체 완료");
				
			}else if(sel == 8 && log != -1) {	// 잔액조회
				System.out.printf("%s님의 잔액 : %d원 입니다.\n", accs[log], moneys[log]);
			}else if(sel == 9) {	// 저장
				// acc/pw/money
				
				String data = "";
				for(int i=0; i<count; i++) {
					String acc = accs[i];
					String pw = pws[i];
					int money = moneys[i];
					
					data+= acc+ "/" + pw + "/" + "money";
					
					if(i < count-1)
						data+="\n";
				}
				
				try {
					fw = new FileWriter(file);
					
					fw.write(data);
					
					fw.close();
					System.out.println("파일쓰기 성공");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("파일쓰기 실패");
				}
				
			}else if(sel == 10) {	//로드
				// acc/pw/money
				
				accs = new String[SIZE];
				pws = new String[SIZE];
				moneys = new int[SIZE];
				
				count = 0;
				
				if(file.exists()) {
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						while(br.ready()) {
							String[] info = br.readLine().split("/");
							
							accs[count] = info[0];
							pws[count] = info[1];
							moneys[count] = Integer.parseInt(info[2]);
							
							count ++;
						}
						
						
						br.close();
						fr.close();
						System.out.println("파일읽기 성공");
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("파일읽기 실패");
					}
				
					
				}else {
					System.out.println("파일이 존재하지 않습니다.");
				}
			}else if(sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		
	}

}