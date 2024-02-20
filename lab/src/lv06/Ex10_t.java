package lv06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

// [ATM]
// System.out.println("===" + name + " ===");
// System.out.println("1.회원가입");
// System.out.println("2.회원탈퇴");
// System.out.println("3.로그인");
// System.out.println("4.로그아웃);
// System.out.println("5.입금하기");
// System.out.println("6.이체하기");
// System.out.println("7.조회하기");

class Atm_t{
	
	Scanner sc = new Scanner(System.in);
	
	final int JOIN = 1;
	final int LEAVE = 2;
	final int LOG_IN = 3;
	final int LOG_OUT = 4;
	final int INCOME = 5;
	final int TRANSFER = 6;
	final int BALANCE = 7;
	
	final int TYPE_OUT = 1;
	final int TYPE_IN = 2;
	
	
	
	
	String name;
	
	int size;			//계좌수
	
	int[] accs;			//4자리 랜덤 번호 발급 (1000~9999;
	String[] pws;
	int[] moneys;	// 가입 축하금 1000원
	
	int log = -1;
	
	void setName(String name) {
		// this : 멤버(객체 자기 자신의)를 지칭하는 키워드
		this.name = name;
	}
	
	void printState() {
		System.out.println(Arrays.toString(accs));
		System.out.println(Arrays.toString(pws));
		System.out.println(Arrays.toString(moneys));
	}
	
	void printMenu() {
		System.out.println();
		System.out.println("===" + name + "ATM ===");
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.입금하기");
		System.out.println("6.이체하기");
		System.out.println("7.조회하기");
	}
	
	int inputNumber() {
		int number = -1;
		
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자를 입력하세요");
		}
		
		return number;
		
	}
	
	int randomAccount() {
		Random random = new Random();

		int acc = 0;
		
		while(true) {
			acc = random.nextInt(9000)+1000;
			
			boolean isDupl = false;
			for(int i=0; i<size; i++) {
				if(accs[i] == acc)
					isDupl = true;
			}
			
			if(!isDupl)
				break;
		}
		
		return acc;
	}
	
	
	void join() {
		
		int acc = randomAccount(); 	//1000 ~ 9999
		
		System.out.print("비밀번호 : ");
		String password = sc.next();
		
		int[] tempAcc = accs;
		accs = new int[size +1];
		
		String[] tempPws = pws;
		pws = new String[size +1];
		
		int[] tempMoney = moneys;
		moneys = new int[size +1];
		
		for(int i=0; i<size; i++) {
			accs[i] = tempAcc[i];
			pws[i] = tempPws[i];
			moneys[i] = tempMoney[i];
		}
		
		accs[size] = acc;
		pws[size] = password;
		moneys[size] = 1000;
		
		size++;
	}
	
	void leave() {
		
		System.out.print("비밀번호 : ");
		String password = sc.next();
		
		if(!pws[log].equals(password)) {
			System.err.println("비밀번호가 불일치합니다.");
			return;
		}
		
		int[] tempAccs = accs;
		accs = new int[size -1];
		
		String[] tempPws = pws;
		pws = new String[size-1];
		
		int[] tempMoneys = moneys;
		moneys = new int[size-1];
		
		int idx = 0;
		for(int i=0; i<size; i++) {
			if(i != log) {
				accs[idx] = tempAccs[i];
				pws[idx] = tempPws[i];
				moneys[idx] = tempMoneys[i];
				idx++;
			}
		}
		size--;
		
		log = -1;
		
	}
	
	void login() {
		
		System.out.print("acc : ");
		int acc = inputNumber();
		System.out.print("pw : ");
		String password = sc.next();
		
		for(int i=0; i<size; i++) {
			if(acc == accs[i] && password.equals(pws[i]))
				log = i;
		}
		
		if(log == -1)
			System.err.println("회원정보를 다시 확인하세요.");
	}
	
	void logout() {
		log = -1;
		System.out.println("로그아웃 완료");
	}
	
	void income() {
		
		System.out.print("입금 금액 : ");
		int money = inputNumber();
		
		if(money < 1 ) {
			System.err.println("유효하지 않는 금액입니다.");
			return;
		}
		
		moneys[log] += money;
		System.out.println("입금 완료");
	}
	
	void transfer() {
		
		System.out.print("이체할 계좌 번호 : ");
		int acc = inputNumber();
		
		System.out.print("이체할 금액 : ");
		int money = inputNumber();
		
		int idx = -1;
		for(int i=0; i<size; i++) {
			if(accs[i] == acc)
				idx = i;
		}
		
		if(idx == -1 || idx == log || money < 1	) {
			System.err.println("유효하지 않은 정보입니다.");
			return;
		}
		
		if(moneys[log] < money) {
			System.err.println("유효하지 않은 정보입니다.");
			return;
		}
		
		moneys[log] -= money;
		moneys[idx] += money;
		
		System.out.println("이체 완료");
		
		
	}
	
	void viewBalance() {
		
		System.out.printf("%d 계좌에 현재 잔액은 %d원입니다. \n", accs[log], moneys[log]);
	}
	
	boolean checkLog(int typeCode) {
		boolean result = false;
		
		if(typeCode == TYPE_OUT) {
			if(log == -1)
				result = true;
			else
				System.err.println("로그아웃 후 이용가능합니다.");
		}else if(typeCode == TYPE_IN) {
			if(log != -1)
				result = true;
			else
				System.err.println("로그인 후 이용가능합니다");
		}
		
		return result;
	}
	
	void subMenu(int select) {
		if(select == JOIN && checkLog(TYPE_OUT)) {				//로그아웃
			join();			
		}else if(select == LEAVE && checkLog(TYPE_IN)) {			// 로그인
			leave();
		}else if(select == LOG_IN && checkLog(TYPE_OUT)) {		// 로그아웃
			login();
		}else if(select == LOG_OUT && checkLog(TYPE_IN)) {		// 로그인
			logout();
		}else if(select == INCOME && checkLog(TYPE_IN)) {		// 로그인
			income();
		}else if(select == TRANSFER && checkLog(TYPE_IN)) {		// 로그인
			transfer();
		}else if(select == BALANCE && checkLog(TYPE_IN)) {		// 로그인
			viewBalance();
		}
	}
	
	void run() {
		while(true) {
			printState();
			printMenu();
			int sel = inputNumber();
			subMenu(sel);
		}
	}
	
}

public class Ex10_t {

	public static void main(String[] args) {
		Atm_t Atm_t = new Atm_t();
		Atm_t.setName("mega");
		Atm_t.run();
	}

}
