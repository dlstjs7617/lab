package lv08;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// ATM

class User{
	private int code;
	private int size; 
	private String name;
	
	public User(int code, String name) {
		this.code = code;
		this.name = name;
		this.size = 0;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return String.format("%s님(%d) 개설된 계좌수 %d개", name, code, size);
	}
}

class UserManager{
	
	private Random ran = new Random();
	
	private ArrayList<User> list;
	
	public UserManager(){
		list = new ArrayList<User>();
	}
	
	
	
	// 기능
	private int rCode() {

		while (true) {
			boolean isDupl = false;
			int rCode = ran.nextInt(9000) + 1000;

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getCode() == rCode)
					isDupl = true;
			}

			if (!isDupl) {
				return rCode;
			}
		}
	}
	
	public int findUserCode(int code) {
		int check = -1;
		
		for(int i=0; i<list.size(); i++) {
			User user = readUser(i);
			if(user.getCode() == code)
				return code;
		}
		
		return check;
	}
	
	public int findUseridx(int code) {
		int idx = -1;
		
		for(int i=0; i<list.size(); i++) {
			User user = readUser(i);
			if(user.getCode() == code)
				return i;
		}
		return idx;
	}
	
	public boolean checkSize(int code) {
		int idx = findUseridx(code);
		
		User user = readUser(idx);
		if(user.getSize() < 3) {
			return false;
		}else {
			return true;
		}
	}
	
	public void printUser() {
		for(int i=0; i<list.size(); i++) {
			User user = readUser(i);
			System.out.println(user);
		}
	}

	// ㄴ User CRUD
	public void createUser(String name) {
		User user = new User(rCode(), name);
		list.add(user);
		
		System.out.println("회원가입 완료");
	}
	
	public User readUser(int index) {
		User user = list.get(index);
		
		return user;
	}
	
	public void updateUser(int code, String update) {
		int idx = findUseridx(code);
		
		if(idx == -1) {
			System.err.println("없는 유저입니다");
			return;
		}
		
		if(update.equals("DELETE")) {
			User user = readUser(idx);
			user.setSize(user.getSize()-1);
		}else if(update.equals("CREATE")) {
			User user = readUser(idx);
			user.setSize(user.getSize()+1);
		}
		
	}
	
	public void deleteUser(int code) {
		int idx =findUseridx(code);
		
		list.remove(idx);
	}
	
}
class Account{
	private int code;
	private String account;
	private int money;
	
	public Account(int code, String account) {
		this.code = code;
		this.account = account;
		this.money = 1000;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public String getAccount() {
		return this.account;
	}
	
	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return String.format("(%d)님  계좌 %s \n 금액: %d", code, account, money);
	}
}

class AccountManager{
	
	private Random ran = new Random();
	
	private ArrayList<Account> list;
	
	public AccountManager() {
		list = new ArrayList<Account>();
	}
	
	// 기능
	private String rAccount() {
		boolean isDupl = false;
		
		while(true) {
			int rNumLeft = ran.nextInt(9000)+1000;
			int rNumCenter = ran.nextInt(9000)+1000;
			int rNumRight = ran.nextInt(9000)+1000;
			
			String check = rNumLeft + "-" + rNumCenter + "-" + rNumRight;
			
			for(int i=0; i<list.size(); i++) {
				Account account = readAccount(i);
				
				if(account.getAccount().equals(check))
					isDupl = true;
			}
			
			if(!isDupl)
				return check;
		}
		
	}
	
	public boolean checkAcc(String acc) {
		for(int i=0; i<list.size(); i++) {
			Account account = readAccount(i);
			if(account.getAccount().equals(acc))
				return true;
		}
		
		return false;
	}
	
	public boolean checkMoney(String acc, int inputMoney) {
		int idx = findAccIdx(acc);
		
		Account account = readAccount(idx);
		if(account.getMoney() < inputMoney)
			return false;
		else
			return true;
		
	}
	
	public void printAllAccoount() {
		for(int i=0; i<list.size(); i++) {
			Account account = readAccount(i);
			System.out.println(account);
		}
	}
	
	
	public void printUserAccount(int code) {
		for(int i=0; i<list.size(); i++) {
			Account account = readAccount(i);
			if(account.getCode() == code) {
				System.out.println(account);
			}
		}
	}
	
	public int findAccIdx(String acc) {
		for(int i=0; i<list.size(); i++) {
			Account account = readAccount(i);
			if(account.getAccount().equals(acc))
				return i;
		}
		
		return -1;
	}
	
	
	
	// ㄴ Account CRUD
	public void createAccount(int code) {
		Account acc = new Account(code, rAccount());
		list.add(acc);
		
		System.out.println("계좌 개설완료");
	}
	
	public Account readAccount(int index) {
		Account account = list.get(index);
		return account;
	}
	
	public void updateAccount(String acc, String update, int money) {
		int idx = findAccIdx(acc);
		
		Account account = list.get(idx);
		
		if(update.equals("DEPOSIT")) {
			account.setMoney(account.getMoney() + money);
		}if(update.equals("WITHDRAW")) {
			account.setMoney(account.getMoney() - money);
		}
		
	}
	
	public void deleteAccount(int code) {
		for(int i=0; i<list.size(); i++) {
			Account account = readAccount(i);
			if(account.getCode() == code) {
				list.remove(i);
				i--;
			}
		}
	}
	
	public void deleteAccount(String acc) {
		int idx = findAccIdx(acc);
		
		if(idx == -1) {
			System.err.println("없는 계좌");
			return;
		}
		
		list.remove(idx);
	}
}

class Bank{
	
	private final int SIGN_UP = 1;
	private final int DEPOSIT = 2;
	private final int TRANSFER = 3;
	private final int INQUIRY_ACCOUNT = 4;
	private final int CREATE_ACCOUNT= 5;
	private final int LEAVE= 6;
	private final int DELETE_ACCOUNT= 7;
	private final int EXIT= 0;
	
	private final int PRINT_All = 1;
	private final int SELECT_INQUIRY = 2;

	private Scanner sc = new Scanner(System.in);
	
	private UserManager userManager = new UserManager();
	private AccountManager accountManager = new AccountManager();

	private boolean isRun = true;
	
	private int inputNumber(String message) {
		int number = -1;
		System.out.print(message + " : ");
		
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return number;
	}
	
	private String inputString(String message) {
		System.out.println(message + " : ");
		return sc.next();
	}
	
	private int codeCheck() {
		userManager.printUser();
		
		int code = inputNumber("회원 코드 입력");
		code = userManager.findUserCode(code);
		
		return code;
	}
	
	private boolean excetionCode(int code) {
		if(code == -1) {
			System.err.println("없는 회원입니다");
			return true;
		}else {
			return false;
		}
	}
	
	private void printMenu() {
		System.out.println("-----시스템기능-----");
		System.out.println("1.회원가입");
		System.out.println("2.입금");
		System.out.println("3.이체");
		System.out.println("4.계좌조회");
		System.out.println("5.계좌개설 (3개가능)");
		System.out.println("6.회원탈퇴(계좌 전체 철회");
		System.out.println("7.계좌철회");
		System.out.println("0.종료");
	}
	
	private void signUp() {
		String name = inputString("이름");
		userManager.createUser(name);
	}
	
	private void deposit() {
		int code = codeCheck();
		
		if(excetionCode(code))
			return;
		
		accountManager.printUserAccount(code);
		
		String acc = inputString("계좌번호입력");
		if(!accountManager.checkAcc(acc)) {
			System.err.println("없는 계좌입니다.");
			return;
		}
		
		int inputMoney = inputNumber("입금할 금액입력");
		if(inputMoney <=0) {
			System.err.println("유효하지 않은 금액");
			return;
		}
		
		accountManager.updateAccount(acc, "DEPOSIT", inputMoney);
		System.out.println("입금 완료");
	}
	
	private void transfer() {
		int code = codeCheck();

		if(excetionCode(code))
			return;
		
		accountManager.printUserAccount(code);
		
		String acc = inputString("사용할 계좌번호입력");
		if(!accountManager.checkAcc(acc)) {
			System.err.println("없는 계좌입니다.");
			return;
		}
		
		accountManager.printAllAccoount();
		
		String sandAcc = inputString("이체할 계좌입력");
		if(!accountManager.checkAcc(sandAcc)) {
			System.err.println("없는 계좌입니다.");
			return;
		}
		
		if(acc.equals(sandAcc)) {
			System.err.println("같은 계좌입니다");
			return;
		}
		
		int inputMoney = inputNumber("이체할 금액입력");
		if(inputMoney <=0) {
			System.err.println("유효하지 않은 금액");
			return;
		}
		
		if(!accountManager.checkMoney(acc, inputMoney)) {
			System.err.println("금액이 부족합니다. 계좌를 확인해주세요");
			return;
		}
		
		accountManager.updateAccount(acc, "WITHDRAW", inputMoney);
		accountManager.updateAccount(sandAcc, "DEPOSIT", inputMoney);
		System.out.println("이체 완료");
		
	}
	
	private void printAll() {
		accountManager.printAllAccoount();
	}
	
	private void selectInquiry() {
		int code = codeCheck();
		
		if(excetionCode(code))
			return;

		accountManager.printUserAccount(code);
	}
	
	private void inquirySubMenu() {
		System.out.println("1.전체조회");
		System.out.println("2.유저계좌조회");
		
		int sel = inputNumber("메뉴선택");
		if(sel == PRINT_All) {
			printAll();
		}else if(sel == SELECT_INQUIRY) {
			selectInquiry();
		}
	}
	
	private void createAccount() {
		int code = codeCheck();
		
		if(excetionCode(code))
			return;
		
		if(userManager.checkSize(code)) {
			System.err.println("최대 개설가능한 계좌를 넘었습니다");
			return;
		}
		
		accountManager.createAccount(code);
		userManager.updateUser(code, "CREATE");
		
	}
	
	private void leave() {
		int code = codeCheck();
		
		if(excetionCode(code))
			return;
		
		userManager.deleteUser(code);
		accountManager.deleteAccount(code);
		System.out.println("회원탈퇴 완료");
	}
	
	private void deleteAccount() {
		int code = codeCheck();
		
		if(excetionCode(code))
			return;
		
		accountManager.printUserAccount(code);
		String acc = inputString("탈퇴할 계좌입력");
		
		accountManager.deleteAccount(acc);
		userManager.updateUser(code, "DELETE");
		System.out.println("계좌탈퇴 완료");
	}
	
	private void selectMenu(int select) {
		if(select == SIGN_UP) {
			signUp();
		}else if(select == DEPOSIT) {
			deposit();
		}else if(select == TRANSFER) {
			transfer();
		}else if(select == INQUIRY_ACCOUNT) {
			inquirySubMenu();
		}else if(select == CREATE_ACCOUNT) {
			createAccount();
		}else if(select == LEAVE) {
			leave();
		}else if(select == DELETE_ACCOUNT) {
			deleteAccount();
		}else if(select == EXIT) {
			this.isRun = false;
		}
	}
	
	private void inputSelect() {
		int select = inputNumber("메뉴 선택");
		selectMenu(select);
	}
	
	private boolean isRun() {
		return isRun;
	}
	
	public void run() {
		while(isRun()) {
			printMenu();
			inputSelect();
			
		}
		// 시스템 기능
		// ㄴ 1) 회원가입
		// ㄴ 2) 입금
		// ㄴ 3) 이체
		// ㄴ 4) 계좌조회
		// ㄴ 5) 계좌개설 (1~3까지)
		// 	 ㄴ ####-####-####  
		// ㄴ 6) 회원탈퇴	(계좌 전체 철회)
		// ㄴ 7) 계좌철회
		// ㄴ 0) 종료
	}
	
}

public class Ex13 {

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.run();
		
	}

}
