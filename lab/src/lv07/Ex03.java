package lv07;

import java.util.Scanner;

// 티켓예매 시스템 완성
// ㄴ 사용자는 회원가입 및 로그인 후, 예매가 가능하다.
// ㄴ 사용자의 마이페이지에는 예매완료 내역을 확인할수 있다.
// 사용자(user), 좌석(seat), 시스템(tms)

class User{
	 Seat[] mySeats;
	 
	 
	 
	 String id;
	 String password;
	 String name; 
}

class Seat{
	boolean seat;
	String seatName;
	
}

class Tms{
	
	Scanner sc = new Scanner(System.in);
	
	User[] users;
	Seat[] cgv;
	
	final int SELL = 1;
	final int SIZE = 10;
	final int SIGNUP = 1;
	final int LEAVE = 2;
	final int LOGIN = 3;
	final int LOGOUT = 4;
	final int RESERVATION = 5;
	final int CANCLE = 6;
	final int INQUIRY = 7;
	
	int size;
	int log = -1;
	
	Seat seat = new Seat();
	
	
	void setCgv() {
		cgv = new Seat[SIZE];
		setSeat();
	}
	
	void setSeat() {
		for(int i=0; i<SIZE; i++) {
			cgv[i] = new Seat();
		}
	}
	
	boolean isRun() {
		return true;
	}
	
	void printSeat() {
		System.out.println("인덱스");
		for(int i=0; i<SIZE; i++) {
			System.out.printf("[%d]", i);
		}
		System.out.println("\n좌석");
		for(int i=0; i<SIZE; i++) {
			if(cgv[i].seat)
				System.out.print("[O]");
			else
				System.out.print("[X]");
		}
		System.out.println();
	}
	
	void userMenu() {
		System.out.println("1)회원가입");
		System.out.println("2)회원탈퇴");
		System.out.println("3)로그인");
		System.out.println("4)로그아웃");
		
		if(log != -1) {
			System.out.println("5)예매");
			System.out.println("6)예매취소");
			System.out.println("7)예매확인");
		}
	}
	
	boolean selectCheck(int sel) {
		if(sel < 0 || sel > 7) {
			System.err.println("유효하지 않은 메뉴");
			return true;
		}
		
		return false;
	}
	
	void selectRun(int sel) {
		if(sel == SIGNUP && !checkLog()) {
			signup();
		}else if(sel == LEAVE && checkLog()) {
			leave();
		}else if(sel == LOGIN && !checkLog()) {
			login();
		}else if(sel == LOGOUT && checkLog()) {
			logout();
		}else if(sel == RESERVATION && checkLog()) {
			reservation();
		}else if(sel == CANCLE && checkLog()) {
			cancle();
		}else if(sel == INQUIRY && checkLog()) {
			inquiry();
		}
	}
	
	boolean checkLog() {
		if(log == -1) {
			return false;
		}else {
			return true;
		}
	}
	
	void signup() {
		String id = inputString("아이디");
		String password = inputString("비밀번호");
		String name = inputString("이름");
		if(findUserById(id)) {
			System.out.println("이미 존재하는 아이디입니다.");
			return;
		}
		
		setUserArr(id , password, name);
	}
	
	boolean findUserById(String id) {
		for(int i=0; i<size; i++) {
			if(id.equals(users[i].id)) {
				return true;
			}
		}
		
		return false;
	}
	
	void setUserArr(String id, String password, String name) {
		User[] temp = users;
		users = new User[size+1];
		
		users[size] = new User();
		
		for(int i=0; i<size; i++) {
			users[i] = temp[i];
		}
		
		users[size].id = id;
		users[size].password = password;
		users[size].name = name;
		size++;
	}
	
	void leave() {
		String password = inputString("비밀번호");
		
		if(findUserByPw(password)) {
			setUserArr();
			System.out.println("회원 탈퇴 완료");
			log = -1;			
		}else
			System.err.println("비밀번호 불일치");
		
	}
	
	boolean findUserByPw(String password) {
		if(users[log].password.equals(password)) {
			return true;
		}
		
		return false;
	}
	
	void setUserArr() {
		User[] temp = users;
		users = new User[size-1];
		
		int cnt = 0;
		for(int i=0; i<size; i++) {
			if(i != log) {
				users[cnt++] = temp[i];
			}
		}
		
		size--;
	}
	
	void login() {
		String id = inputString("아이디");
		String password = inputString("비밀번호");
		
		log = checkLogin(id , password);
		if(log == -1)
			System.err.println("아이디/비밀번호 불일치");
		else
			System.out.printf("%s님 환영합니다.\n",users[log].id);
	}
	
	int checkLogin(String id, String pw) {
		int log = -1;
		for(int i=0; i<size; i++) {
			if(users[i].id.equals(id) && users[i].password.equals(pw))
				log = i;
		}
		
		return log;
	}
	
	void logout() {
		log = -1;
		System.out.println("로그아웃 되셨습니다.");
	}
	
	void reservation() {
		printSeat();
		int input = inputNumber("좌석인덱스");
		
		if(checkSeat(input)) {
			System.out.println("이미 예메된 좌석입니다.");
		}else {
			cgv[input].seat = true;
			cgv[input].seatName = users[log].name;
		}
	}
	
	void cancle() {
		int index = inputNumber("취소할 자리 인덱스");
		
			if(cgv[index].seat = true && cgv[index].seatName == users[log].name) {
				cgv[index].seat = false;
				cgv[index].seatName = null;
				System.out.println("예매 취소되었습니다.");
			}else {
				System.err.println("예매하지 않은 자리입니다.");
			}

	}
	
	boolean checkSeat(int input) {
		if(cgv[input].seat) {
			return true;
		}
		
		return false;
	}
	
	void inquiry() {
		for(int i=0; i<SIZE; i++) {
			if(cgv[i].seat != false && cgv[i].seatName.equals(users[log].name)) {
				System.out.printf("예메좌석 %d 인덱스 자리 \n",i);
			}
		}
	}
	
	
	
	int inputNumber(String message) {
		int num = -1;
		
		System.out.println(message + "입력 : ");
		try {
			String input = sc.next();
			num = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return num;
	}
	
	String inputString(String message) {
		System.out.print(message+"입력 : ");
		String input = sc.next();
		
		return input;
	}
	
	void run() {
		setCgv();
		while(isRun()) {
			userMenu();
			int select = inputNumber("메뉴");
			
			if(selectCheck(select))
				continue;
			
			selectRun(select);
				
		}
	}
}

public class Ex03 {

	public static void main(String[] args) {
		Tms tms = new Tms();
		tms.run();
	}

}
