package lv07;

import java.util.Scanner;

// 티켓예매 시스템 완성
// ㄴ 사용자는 회원가입 및 로그인 후, 예매가 가능하다.
// ㄴ 사용자의 마이페이지에는 예매완료 내역을 확인할수 있다.
// 사용자(user), 좌석(seat), 시스템(tms)

class User{
	
	Seat[] mySeats;
	
	int seatCnt = 0;

	String id;
	String password;
	String name; 
}

class Seat{
	int idx;
	int code;
	
	boolean seat;
}

class Tms{
	
	Scanner sc = new Scanner(System.in);
	
	User[] users;
	Seat[] seats;
	
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
	User user = new User();
	
	void setseat() {
		seats = new Seat[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			seats[i] = new Seat();
		}
	}
	
	Seat setSeats(int idx) {
		
		seat.idx = idx;
		seat.code = log+1;
		return seat;
	}
	// while 실행조건
	boolean isRun() {
		return true;
	}
	// 영화 좌석 출력
	void printSeat() {
		System.out.println("인덱스");
		for(int i=0; i<SIZE; i++) {
			System.out.printf("[%d]", i);
		}
		System.out.println("\n좌석");
		for(int i=0; i<SIZE; i++) {
			if(seats[i].seat)
				System.out.print("[O]");
			else
				System.out.print("[X]");
		}
		System.out.println();
	}
	// 메뉴출력
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
	
	// 메뉴선택 예외처리
	boolean selectCheck(int sel) {
		if(sel < 0 || sel > 7) {
			System.err.println("유효하지 않은 메뉴");
			return true;
		}
		
		return false;
	}
	
	// 선택한 메뉴 실행문
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
	
	// 로그인 확인
	boolean checkLog() {
		return log == -1 ? false : true;
	}
	
	// 회원가입
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
	
	// 아이디찾기
	boolean findUserById(String id) {
		for(int i=0; i<size; i++) {
			if(id.equals(users[i].id)) {
				return true;
			}
		}
		
		return false;
	}
	
	// user배열추가
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
	//회원탈퇴
	void leave() {
		String password = inputString("비밀번호");
		
		if(findUserByPw(password)) {
			setUserArr();
			System.out.println("회원 탈퇴 완료");
			log = -1;			
		}else
			System.err.println("비밀번호 불일치");
		
	}
	// 비번찾기
	boolean findUserByPw(String password) {
		if(users[log].password.equals(password)) {
			return true;
		}
		
		return false;
	}
	// user배열 감소
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
	
	//로그인
	void login() {
		String id = inputString("아이디");
		String password = inputString("비밀번호");
		
		log = checkLogin(id , password);
		if(log == -1)
			System.err.println("아이디/비밀번호 불일치");
		else
			System.out.printf("%s님 환영합니다.\n",users[log].id);
	}
	// 로그인 찾기 log리턴
	int checkLogin(String id, String pw) {
		int log = -1;
		for(int i=0; i<size; i++) {
			if(users[i].id.equals(id) && users[i].password.equals(pw))
				log = i;
		}
		
		return log;
	}
	
	// 로그아웃
	void logout() {
		log = -1;
		System.out.println("로그아웃 되셨습니다.");
	}
	
	// 예매
	void reservation() {
		printSeat();
		int input = inputNumber("좌석인덱스");
		
		if(checkSeat(input)) {
			System.out.println("이미 예매된 좌석입니다.");
		}else {
			mySeat(input);
		}
	}
	// 예매처리
	void mySeat(int input) {
		mySeatVector(input);
		
		seats[input].seat = true;
	}
	// User의 mySeat 배열추가
	void mySeatVector(int input) {
		Seat[] temp = users[log].mySeats;
		
		users[log].mySeats = new Seat[users[log].seatCnt+1];
		
		for(int i=0; i<users[log].seatCnt; i++) {
			users[log].mySeats[i]= temp[i];
		}
		
		users[log].mySeats[users[log].seatCnt] = setSeats(input);
		
		users[log].seatCnt++;
		seats[input].seat = true;
		
	}
	// 예매취소
	void cancle() {
		inquiry();
		int idx = inputNumber("취소할 자리 인덱스");
		
		for(int i=0; i<users[log].seatCnt; i++) {
			if(users[log].mySeats[i].idx == idx) {
				mySeatVectorMin(idx);
				seats[idx].seat = false;
			}
		}
		
	}
	// User 예매 mySeat 배열감소
	void mySeatVectorMin(int idx) {
		Seat[] temp = users[log].mySeats;
		users[log].mySeats = new Seat[users[log].seatCnt-1];
		
		int cnt = 0;
		
		for(int i=0; i<users[log].seatCnt; i++) {
			if(temp[i].idx != idx) {
				users[log].mySeats[cnt++] = temp[i]; 
			}
		}
		seats[idx].seat = false;
		users[log].seatCnt--;
		
		
	}
	// 예매되있는지 확인
	boolean checkSeat(int input) {
		if(seats[input].seat) {
			return true;
		}
		
		return false;
	}
	
	// 사용자가 예매좌석확인
	void inquiry() {
		for(int i=0; i<users[log].seatCnt; i++) {
			System.out.printf("%d 번 자리 \n",users[log].mySeats[i].idx);
		}
	}
	
	
	// 숫자입력
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
	
	// 문자열입력
	String inputString(String message) {
		System.out.print(message + "입력 : ");
		String input = sc.next();
		
		return input;
	}
	
	// 실행
	void run() {
		setseat();
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
