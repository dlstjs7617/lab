package lv06;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// [ATM]
// System.out.println("===" + name + " ===");
// System.out.println("1.회원가입");
// System.out.println("2.회원탈퇴");
// System.out.println("3.로그인");
// System.out.println("4.로그아웃);
// System.out.println("5.입금하기");
// System.out.println("6.이체하기");
// System.out.println("7.조회하기");

class Atm{
	
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);
	
	String loginName;
	int name;
	int size;				// 계좌수
	
	int[] accs;				// 4자리 랜덤 번호 발금
	String[] names;
	String[] pws;
	int[] moneys;		//가입 축하금 1000원
	
	int log = -1;
	
	void outPrint() {
		
		System.out.println();
		System.out.println("===" + name + " ===");
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.입금하기");
		System.out.println("7.조회하기");
	}
	
	int ranAcc(int acc) {
		System.out.println("계좌 생성중입니다.");
		String temp = "";
		for(int j=0; j<4; j++) {
			int rNum = ran.nextInt(10);
			temp += rNum+"";
		}
		acc = Integer.parseInt(temp); 
		return acc;
	}
	
	
	void signup(int sel) {
		System.out.println("이름 : ");
		String user = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		int acc = 0;
		ranAcc(acc);
		vectorPlus(acc, pw, user);
	}
	
	void vectorPlus(int acc, String pw ,String user) {
		
		int[] tmpAccs = accs;
		String[] tmpNames = names;
		String[] tmpPws = pws;
		int[] tmpMoneys = moneys;
		
		accs = new int[size+1];
		names = new String[size+1];
		pws = new String[size+1];
		moneys = new int[size+1];
		
		for(int i=0; i<size; i++) {
			accs[i] = tmpAccs[i];
			names[i] = tmpNames[i];
			pws[i] = tmpPws[i];
			moneys[i] = tmpMoneys[i]; 
		}
		accs[size] = acc; 
		names[size] = user;
		pws[size] =  pw;
		moneys[size] += 1000;
	}
	
	void vectorMinus(int acc, String pw) {
		int[] tmpAccs = accs;
		String[] tmpNames = names;
		String[] tmpPws = pws;
		int[] tmpMoneys = moneys;
		
		accs = new int[size-1];
		names = new String[size-1];
		pws = new String[size-1];
		moneys = new int[size-1];
	}
	
	void leave() {
		
	}
	void login() {
		
	}
	void logout() {
		
	}
	void deposit() {
		
	}
	void transfer() {
		
	}
	void inquiry() {
		
	}
	
	
	void menu(int sel) {
		if(sel == 1 && log == -1) {
			signup(sel);
		}else if(sel == 2 && log != -1) {
			leave();
		}else if(sel == 3 && log == -1) {
			login();
		}else if(sel == 4 && log != -1) {
			logout();
		}else if(sel == 5 && log != -1) {
			deposit();
		}else if(sel == 6 && log != -1) {
			transfer();
		}else if(sel == 7 && log != -1) {
			inquiry();
		}
	}
	
	void run() {
		while(true) {
			System.out.println(Arrays.toString(accs));
			System.out.println(Arrays.toString(names));
			System.out.println(Arrays.toString(pws));
			System.out.println(Arrays.toString(moneys));
			outPrint();
			
			int sel = sc.nextInt();
			menu(sel);			
		}
	}
	
}

public class Ex10 {

	public static void main(String[] args) {
		Atm atm = new Atm();
		atm.run();
		
	}

}
