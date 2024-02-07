package lv05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Ex21 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int size = 5;
		int count = 0;
		int log = -1;
		
		String[] accs = new String[size];
		String[] pws = new String[size];
		int[] moneys = new int[size];
		
		String fileName = "atm.txt";
		
		File file = new File(fileName);
		while(true) {
			FileReader fr = null;
			BufferedReader br = null;
			FileWriter fw = null;
			
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
			
			if(log == -1 && sel == 2 || log == -1 && sel == 4 || log == -1 && sel == 5 || 
			   log == -1 && sel == 6 || log == -1 && sel == 7 || log == -1 && sel == 8) {
				System.out.println("로그인 후 이용가능");
				continue;
			}else if(log != -1 && sel == 1 || log != -1 && sel == 3) {
				System.out.println("이미 로그인 중입니다.");
				continue;
			}
			
			if(count == size && sel == 1) {
				System.out.println("회원이 가득 찼습니다");
				continue;
			}
				
			if(sel == 1) {			// 회원가입
				boolean isDupl = false;
				System.out.print("ID : ");
				String id = sc.next();
				System.out.print("PW : ");
				String pw = sc.next();
				
				for(int i=0; i<count; i++) {
					if(id.equals(accs[i]))
						isDupl = true;
				}
				if(isDupl) {
					System.out.println("이미 있는 아이디입니다.");
					continue;
				}
				
				accs[count] = id;
				pws[count] = pw;
				count++;
				
				
			}else if(sel == 2) {	// 회원탈퇴
				System.out.print("비밀번호 확인 : ");
				String pw = sc.next();
				
				if(pws[log].equals(pw))
					System.out.println("회원탈퇴 완료");
				else {
					System.out.println("비밀번호 불일치");
					continue;
				}
				
				int  idx = 0;
				
				String[] tempAccs = accs;
				String[] tempPws = pws;
				int[] tempMoneys = moneys;
				
				accs = new String[count-1];
				pws = new String[count-1];
				moneys = new int[count-1];
				for(int i=0; i<count; i++) {
					if(i != log) {
						accs[idx] = tempAccs[i];
						pws[idx] = tempPws[i];
						moneys[idx++] = tempMoneys[i];
					}
				}
				log = -1;
				count--;
				
			}else if(sel == 3) {	// 로그인
				System.out.print("ID : ");
				String id = sc.next();
				System.out.print("PW : ");
				String pw = sc.next();
				
				boolean isDupl = false;
				
				for(int i=0; i<count; i++) {
					if(id.equals(accs[i]) && pw.equals(pws[i])) {
						System.out.println("로그인 성공");
						isDupl = true;
						log = i;
					}
				}
				
				if(!isDupl) {
					System.out.println("ID/PW 불일치");
				}
				
				
			}else if(sel == 4) {	// 로그아웃
				System.out.println("로그아웃되셨습니다.");
				log = -1;
			}else if(sel == 5) {	// 입금
				System.out.print("입금할 금액 : ");
				int money = sc.nextInt();
				
				if(money < 0) {
					System.out.println("0원 이하 입금 불가");
					continue;
				}
				
				moneys[log] += money;
				
				
			}else if(sel == 6) {	// 출금
				System.out.print("출금할 금액 : ");
				int money = sc.nextInt();
				
				if(money < 0 || money > moneys[log]) {
					System.out.println("출금금액 오류");
					continue;
				}
				
				moneys[log] -= money;
				
			}else if(sel == 7) {	// 이체
				
				System.out.print("이체할 계좌 입력 : ");
				String acc = sc.next();
				
				if(acc.equals(accs[log])) {
					System.out.println("본인 계좌에 이체하실수없습니다.");
					continue;
				}
				
				int idx = -1;
				for(int i=0; i<count; i++) {
					if(acc.equals(accs[i]))
						idx = i;
				}
				
				if(idx == -1) {
					System.out.println("없는 계좌입니다.");
					continue;
				}
				
				System.out.print("이체하실 금액을 입력해주세요 : ");
				int money = sc.nextInt();
				
				if(money < 0 || money > moneys[idx]) {
					System.out.println("이체하실금액 오류");
				}
				
				moneys[log] -= money;
				moneys[idx] += money;
				
			}else if(sel == 8) {	// 잔액조회
				
				System.out.printf("%s님의 잔액 : %d원 입니다.\n", accs[log], moneys[log]);
				
				
			}else if(sel == 9) {	// 저장
				String data = "";

				
				
				for(int i=0; i<count; i++) {
					data+= accs[i]+"/";
					data+= pws[i]+"/";
					data+= moneys[i]+"/";
				}
				try {
					fw = new FileWriter(file);
					fw.write(data);
					fw.close();
					System.out.println("저장완료");
				} catch (Exception e) {
					System.out.println("저장하기 실패");
				}
				
			}else if(sel == 10) {	//로드
				
				
				if(file.exists()) {
					count = 0;
					String data = "";
				
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						if(br.ready()) {
							data += br.readLine();
						}
						
						String[] dataArr = data.split("/");
						count = dataArr.length / 3;
						
						accs = new String[count];
						pws = new String[count];
						moneys = new int[count];
						
						int idx = 0;
						for(int i=0; i<dataArr.length; i+=3) {
							accs[idx] = dataArr[i];
							pws[idx] = dataArr[i+1];
							moneys[idx] = Integer.parseInt(dataArr[i+2]);
							idx++;
						}
						System.out.println("저장하기 완료");
					} catch (Exception e) {
						System.out.println("저장하기 실패");
					}
				
				}
			}else if(sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		
	}

}