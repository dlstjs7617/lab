package test.lv7;
// 시작 10:58
// 종료 14:51
// 소요 02:34

import java.util.Scanner;

// 2.
// 타켓 예매 시스템
// ㄴ class : User, Seat, Tms (Ticket managerMent system)
// ㄴ Tms 기능 : 	회원관리(가입/탈퇴/로그인/아웃/나의예매현황).
//			    좌석관리(예매/취소)
//				기능 종료 후 총 매출 출력

class User{
	private String id;
	private String password;
	private String name;
	private Seat[] seat;
	
	private int seatCnt;
	
	public User(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}
	
	
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getname() {
		return name;
	}
	
	public int getSeatCnt() {
		return seatCnt;
	}
	
	public void reservation(int idx) {
		Seat[] temp = seat;
		seat = new Seat[seatCnt +1];
		
		for(int i=0; i<seatCnt; i++)
			seat[i] = temp[i];
		
		seat[seatCnt] = new Seat(idx, name);
		
		seatCnt++;
	}
	
	public void seatMinus(int idx) {
		Seat[] temp = seat;
		seat = new Seat[seatCnt-1];
		
		int index = 0;
		
		for(int i=0; i<seatCnt; i++)
			if(temp[i].getIndex() != idx)
				seat[index++] = temp[i];
		
		seatCnt--;
	}
	
	public void Cancle(int idx) {
		boolean find = false;
		for(int i=0; i<seatCnt; i++) {
			if(seat[i].getIndex() == idx)
				find = true;
		}
		
		if(!find) {
			System.err.println("유효하지 않은 자리");
			return;
		}
		
		seatMinus(idx);
	}
	
	@Override
	public String toString() {
		String text = "";
		
		for(int i=0; i<seatCnt; i++) {
			text += "좌석 :"+ seat[i].getIndex() + "번 자리\n";
		}
		
		return text;
	}
	
}

class Seat{
	private boolean reservation;
	private String name;
	private int index;
	
	public Seat() {
		this.index = -1;
	}
	
	public Seat(int index, String name) {
		this.reservation = true;
		this.name = name;
		this.index = index;
	}
	
	public boolean getReservation() {
		return reservation;
	}
	
	public String getName() {
		return name;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void seting(String name, int index) {
		this.reservation = true;
		this.name = name;
		this.index = index;
	}

	public void cancle() {
		this.reservation = false;
		this.index = -1;
		this.name = null;
	}
	
	
}

class Tms{
	private Scanner sc = new Scanner(System.in);
	
	private final int SIZE = 10;
	private final int PRICE = 12000;
	
	private final int SIGN_UP = 1;
	private final int LEAVE = 2;
	private final int LOG_IN = 3;
	private final int LOG_OUT = 4;
	private final int RESERVATION = 5;
	private final int CANCLE = 6;
	private final int MYSEAT = 7; 
	private final int EXIT = 0;
	
	private int log;
	private int userCnt;
	private boolean run;
	private int total;
	
	private Seat[] seat;
	private User[] user;
	
	// 숫자받기
	private int inputNumber(String message) {
		int number = -1;
		System.out.print(message + ":");
		
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return number;
	}
	
	// 문자열받기
	private String inputString(String message) {
		System.out.print(message + " : ");
		return sc.next();
	}
	
	// 세팅
	private void setTms() {
		log = -1;
		run = true;
		seat = new Seat[SIZE];
		
		for(int i=0; i<SIZE; i++) {
			seat[i] = new Seat();
		}
	}
	
	// 종료 조건
	private boolean isRun() {
		return run;
	}
	
	// 아이디 인덱스 찾기
	private int findIdIdx(String id) {
		int idx =-1;
		
		for(int i=0; i<userCnt; i++) {
			if(user[i].getId().equals(id))
				idx = i;
		}
		
		return idx;
	}
	
	// 비밀번호 인덱스 찾기
	private int findPwIdx(String pw) {
		int idx = -1;
		
		for(int i=0; i<userCnt; i++) {
			if(user[i].getPassword().equals(pw))
				idx = i;
		}
		
		return idx;
	}
	
	// 비번 확인
	private boolean pwCheck(String pw) {
		if(user[log].getPassword().equals(pw))
			return true;
		else
			return false;
	}
	
	// 로그인 체크
	private boolean logCheck() {
		if(log == -1) {
			return false;
		}else {
			return true;
		}
	}
	
	// 유저 추가
	private void userPlus(String id, String pw, String name) {
		User[] temp = user;
		user = new User[userCnt+1];
		
		for(int i=0; i<userCnt; i++)
			user[i] = temp[i];
		
		user[userCnt] = new User(id, pw, name);
		userCnt++;
	}
	
	private void deleteSeat() {
		int cnt = user[log].getSeatCnt();
		
		while(cnt > 0) {
			for(int i=0; i<SIZE; i++) {
				if(seat[i].getName() != null &&seat[i].getName().equals(user[log].getname())) {
					seat[i].cancle();
					cnt--;
					total -= PRICE;
				}
			}
		}
		
	}
	
	// 유저 제거
	private void userMinus(int log) {
		deleteSeat();
		User[] temp = user;
		user = new User[userCnt -1];
		
		int idx = 0;
		for(int i=0; i<userCnt; i++) {
			if(i != log)
				user[idx++] = temp[i];
		}
		
		userCnt--;
		
	}
	
	// 회원가입
	private void signup() {
		String id = inputString("id");
		String pw = inputString("password");
		
		if(findIdIdx(id) != -1) {
			System.err.println("이미 존재하는 회원입니다");
			return;
		}
		
		String name = inputString("이름입력");
		
		userPlus(id, pw, name);
		
		System.out.println("회원가입 완료");
	}
	
	// 회원탈퇴
	private void leave() {
		String pw = inputString("비밀번호 확인");
		
		if(!pwCheck(pw)) {
			System.err.println("비밀번호가 다릅니다.");
			return;
		}
		
		userMinus(log);
		log = -1;
		// 여기다가 좌석예매한거 취소 넣기
		System.out.println("회원 탈퇴 완료");
	}
	
	// 로그인
	private void login() {
		String id = inputString("id");
		String pw = inputString("pw");
		
		if(findIdIdx(id) == findPwIdx(pw)) {
			log = findIdIdx(id);
			System.out.printf("%s님 환엽합니다. \n",user[log].getname());
		}else 
			System.err.println("아이디/비밀번호 불일치");
	}
	
	// 로그아웃
	private void logout() {
		log = -1;
	}
	
	// 좌석 출력
	private void printSeat() {
		System.out.println("자리");
		for(int i=0; i<SIZE; i++) {
			System.out.print(i + " ");			
		}
		System.out.println();
		for(int i=0; i<SIZE; i++) {
			System.out.print(seat[i].getReservation() == true ? "■ " : "□ ");
		}
		System.out.println();
	}
	
	// 예매
	private void reservation() {
		printSeat();
		int seatNum = inputNumber("좌석 선택");
		
		if(seatNum < 0 || seatNum >= SIZE) {
			System.err.println("유효하지 않은 값");
			return;
		}
		if(seat[seatNum].getReservation() == true) {
			System.err.println("이미 예매된 자리");
			return;
		}
		
		seat[seatNum].seting(user[log].getname(), seatNum);
		user[log].reservation(seatNum);
		total += PRICE;
	}
	
	// 예매취소
	private void cancle() {
		System.out.println(user[log]);
		
		int cancle = inputNumber("취소할자리 선택");
		
		if(cancle < 0 || cancle >= SIZE) {
			System.err.println("유효하지 않은값");
			return;
		}
		
		user[log].Cancle(cancle);
		seat[cancle].cancle();
		total -= PRICE;
	}
	
	// 내좌석 확인
	private void mySeat() {
		System.out.println(user[log].getname() + "님의 예메좌석");
		System.out.println(user[log]);
	}
	
	private void printMoney() {
		System.out.println("매출 : " + total);
	}
	
	// 메뉴출력
		private void printMenu() {
			System.out.println("=====영화 예메 시스템=====");
			System.out.println("1.회원가입");
			System.out.println("2.회원탈퇴");
			System.out.println("3.로그인");
			System.out.println("4.로그아웃");
			if(log != -1) {
				System.out.println("5.예매하기");
				System.out.println("6.예매취소");
				System.out.println("7.나의 예메현황");			
			}
			System.out.println("0.종료");
			System.out.println("=======================");
		}
		
	// 메뉴 선택
	private void selectMenu(int sel) {
		if(sel == SIGN_UP && !logCheck()) {
			signup();
		}else if(sel == LEAVE && logCheck()) {
			leave();
		}else if(sel == LOG_IN && !logCheck()) {
			login();
		}else if(sel == LOG_OUT && logCheck()) {
			logout();
		}else if(sel == RESERVATION && logCheck()) {
			reservation();
		}else if(sel == CANCLE && logCheck()) {
			cancle();
		}else if(sel == MYSEAT && logCheck()) {
			mySeat();
		}else if(sel == EXIT) {
			run = false;
		}
	}
	
	private void printAll() {
		printSeat();
		
		for(int i=0; i<userCnt; i++) {
			System.out.printf("아이디 : %s 비번 : %s 이름 :%s \n",user[i].getId(),user[i].getPassword(),user[i].getname());		
			System.out.println(user[i]);
		}
	}
	
	public void run() {
		setTms();
		
		while(isRun()) {
//			printAll();	// 확인용
			printMenu();
			int select = inputNumber("메뉴선택");
			selectMenu(select);
		}
		
		printMoney();
	}
	
}


public class Test02 {

	public static void main(String[] args) {
		Tms tms = new Tms();
		tms.run();

	}

}
