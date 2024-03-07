package parctice;

import java.util.Random;
import java.util.Scanner;

class Person{
	private int money;
	private int account;
	private String id;
	private String password;
	private String name;
	
	public Person(String id, String password, String name, int account) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.account = account;
		this.money = 1000;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getAccount() {
		return account;
	}
	
	public void setAccount(int account) {
		this.account = account;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return String.format("이름: %s  id: %s pw : %s 계좌번호: %d 잔액: %d", name, id, password, account, money);
	}
	
	
}

class Cms{
	private Scanner sc = new Scanner(System.in);
	private Random ran = new Random();
	
	private Person[] person;
	
	private int SIGN_UP = 1;
	private int LEAVE = 2;
	private int LOG_IN = 3;
	private int LOG_OUT = 4;
	private int MOENY_IN= 5;
	private int MOENY_OUT= 6;
	private int SEND = 7;
	private int INQURY = 8;
	
	private int log = -1;
	private int pSize;
	
	private int inputNumber(String message) {
		int number = -1;
		
		System.out.println(message + " : ");
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만입력");
		}
		
		return number;
	}
	
	private String inputString(String message) {
		System.out.println(message + " : ");
		return sc.next();
	}
	
	private boolean loginCheck() {
		return log != -1 ? true : false ;
	}
	
	private int findIdIdx(String id) {
		int idx = -1;
		
		for(int i=0; i<pSize; i++) 
			if(person[i].getId().equals(id))
				idx = i;
		
		return idx;
	}
	
	private int findAccountIdx(int account) {
		int idx = -1;
		
		for(int i=0; i<pSize; i++)
			if(person[i].getAccount() == account)
				idx = i;
		
		return idx;
	}
	
	private int createAccount() {
		int rAcc;
		while(true) {
			rAcc = ran.nextInt(9000)+1000;
			boolean isDupl = false;
			
			for(int i=0; i<pSize; i++) {
				if(person[i].getAccount() == rAcc)
					isDupl = true;
			}
			
			if(!isDupl)
				break;
		}
		return rAcc;
	}
	
	private void personArrPlus(String id, String pw, String name) {
		Person[] temp = person;
		
		person = new Person[pSize+1];
		
		
		for(int i=0; i<pSize; i++) {
			person[i] = temp[i];
		}
		
		int account = createAccount();
		
		person[pSize] = new Person(id, pw, name , account);
		
		pSize++;
		
	}
	
	private void signUp() {
		String id = inputString("id");

		if(findIdIdx(id) != -1) {
			System.err.println("이미 있는 ID");
			return;
		}
		
		String password = inputString("pw");
		String name = inputString("이름");
		
		personArrPlus(id, password, name);
		System.out.println("회원가입 완료");
	}
	
	private void personArrMinus() {
		Person[] temp = person;
		person = new Person[pSize -1];
		
		int cnt = 0;
		for(int i=0; i<pSize; i++)
			if(i != log)
				person[cnt++] = temp[i]; 
		
		pSize--;
		
		System.out.println("탈퇴 완료");
	}
	
	private void leave() {
		String pw = inputString("비번확인");
		
		if(!person[log].getPassword().equals(pw)) {
			System.err.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		
		personArrMinus();
		
		log = -1;
	}
	
	private void login() {
		String id = inputString("id");
		String pw = inputString("pw");
		
		if(findIdIdx(id) == -1) {
			System.err.println("없는 아이디입니다.");
			return;
		}
		
		if(person[findIdIdx(id)].getId().equals(id) && person[findIdIdx(id)].getPassword().equals(pw)) {
			System.out.printf("%s 님 환영합니다.\n",person[findIdIdx(id)].getName());
			log = findIdIdx(id);
		}else {
			System.err.println("아이디/비밀번호 불일치");
		}
	}
	
	private void logout() {
		log = -1;
		System.out.println("로그아웃 완료");
	}
	
	private void moneyIn() {
		int money = inputNumber("입금금액");
		
		if(money < 1) {
			System.err.println("0원 이하 입금 불가");
			return;
		}
		
		person[log].setMoney(person[log].getMoney() + money);
		System.out.println("입금 완료");
	}
	
	private void passwordReset() {
		String password = inputString("변경할 패스워드");
		
		person[log].setPassword(password);
		
		System.out.println("패스워드가 변경되었습니다.");
	}
	
	private void moneyOut() {
	int money = inputNumber("출금금액");
		
		if(money > person[log].getMoney()) {
			System.err.println("가진 금액보다 많은 금액은 출금하실 수 없습니다.");
			return;
		}
		
		person[log].setMoney(person[log].getMoney() - money);
		System.out.println("출금 완료");
	}
	
	private void sendMoney() {
		int account = inputNumber("이체할 계좌 입력");
		
		int idx = findAccountIdx(account);
		
		if(idx == -1) {
			System.err.println("없는 계좌입니다.");
			return;
		}
		
		int money = inputNumber("이체할 금액");
		
		if(money <= 0 || money > person[log].getMoney()) {
			System.err.println("유효하지 않은 이체금액");
			return;
		}
		
		person[log].setMoney(person[log].getMoney() - money);
		person[idx].setMoney(person[idx].getMoney() + money);
		
	}
	
	private void inqury() {
		System.out.println(person[log]);
	}
	
	private void printMenu() {
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		
		if(log != -1) {
			System.out.println("5.입금");
			System.out.println("6.출금");
			System.out.println("7.이체");
			System.out.println("8.조회");
			System.out.println("9.비밀번호 변경");
		}
		
	}

	private void selectMenu(int sel) {
		if(sel == SIGN_UP && !loginCheck()) {
			signUp();
		}else if(sel == LEAVE && loginCheck()) {
			leave();
		}else if(sel == LOG_IN && !loginCheck()) {
			login();
		}else if(sel == LOG_OUT && loginCheck()) {
			logout();
		}else if(sel == MOENY_IN && loginCheck()) {
			moneyIn();
		}else if(sel == MOENY_OUT && loginCheck()) {
			moneyOut();
		}else if(sel == SEND && loginCheck()) {
			sendMoney();
		}else if(sel == INQURY && loginCheck()) {
			inqury();
		}else if(sel == 9 && loginCheck()) {
			passwordReset();
		}
	}
	
	
	
	private boolean isRun() {
		return true;
	}
	
	public void run() {
		while(isRun()) {
			printMenu();
			int select = inputNumber("메뉴선택");
			selectMenu(select);
		}
	}
}
public class Lv07_1 {

	public static void main(String[] args) {
		Cms cms = new Cms();
		cms.run();
	}

}
