package lv07t;

import java.util.Scanner;

class User {
	// 기존에 생성되어 있는 Tms.seats 좌석 객체 중에 -> 예약건만 바로가기로 저장 
	int bookCnt;
	Seat[] mySeats;
	
	String id, password;
	
	// 생성자 Constructor
	// ㄴ 클래스를 통해 객체를 생성하도록 하는 메소드
	// ㄴ 메소드와는  다르게, 리턴이 존재하지 않고,
	// ㄴ 메소드와는 다르게 이름이 정해져 있음
	// ㄴ 별도로 정의하지 않으면 컴파일러가 기본 생성자를 만들어줌
	// ㄴ 메소드와 같이 오버로딩으로 구현이 가능합니다.(파라미터의 개수 도는 타입이 서로 다르다면 )
	
	// 문법) 클래스명(파라미터) { 실행문; }
//	User(){
//		
//	}
	
	User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	
	void recordBooking(Seat seat) {
		Seat[] temp = mySeats;
		mySeats = new Seat[bookCnt+1];
		
		for(int i=0; i<bookCnt; i++) {
			mySeats[i] = temp[i];
		}
		
		mySeats[bookCnt++] = seat;
		
	}
	
	void removeBooking(Seat seat) {
		int index = -1;
		
		for(int i=0; i<bookCnt; i++) {
			if(mySeats[i] == seat)
				index = i;
		}
		
		if(index != -1) {
			Seat[] temp = mySeats;
			mySeats = new Seat[bookCnt - 1];
			
			int n = 0;
			for(int i=0; i<bookCnt; i++) {
				if(n != index)
					mySeats[n++] = temp[i];
			}
			
			bookCnt--;
		}
		
	}
	
	int removeBookingAll() {
		int count = bookCnt;
		
		for(int i=0; i<bookCnt; i++) {
			Seat seat = mySeats[i];
			seat.userId = null;
			seat.isBooked = false;
		}
		
		bookCnt = 0;
		return count;
	}
	
	void printMySeatsAll() {
		for(int i=0; i<bookCnt; i++) {
			Seat seat = mySeats[i];
			System.out.printf("%d좌석 [예약완료] \n", seat.code);
		}
	}
}

class Seat {

	int code; // 좌석번호
	boolean isBooked;
	String userId;
	int price;

	/*
	 *  기본 생성자 생략 상태
	 *  Seat() {}
	 */
	
	@Override
	public String toString() {
		return isBooked ? "◼︎" : "◻︎";
	}

}

class Tms {

	Scanner scan = new Scanner(System.in);

	final int SIZE = 10;
	final int JOIN = 1;
	final int LEAVE = 2;
	final int LOG_IN = 3;
	final int LOG_OUT = 4;
	final int BOOKING = 5;
	final int CANCEL = 6;
	final int MY_PAGE = 7;
	final int EXIT = 0;

	final int PRICE = 12000;

	int userCnt;
	User[] users;

	int bookCnt;
	Seat[] seats;

	int log = -1;

	boolean isExit;

	void setSeats() {
		seats = new Seat[SIZE];

		for (int i = 0; i < SIZE; i++) {
			seats[i] = new Seat();			// 기본 생성자 호출
			seats[i].code = i + 1;
			seats[i].price = PRICE;
		}
	}

	void printSeatsAll() {
		for (int i = 0; i < SIZE; i++)
			System.out.print(seats[i].code + " ");
		System.out.println();

		for (int i = 0; i < SIZE; i++)
			System.out.print(seats[i] + " ");
		System.out.println();

	}
	
	void runMenu(int select) {

		if (select == JOIN && !isLogin())
			join();
		else if (select == LEAVE && isLogin())
			leave();
		else if (select == LOG_IN && !isLogin())
			login();
		else if (select == LOG_OUT && isLogin())
			logout();
		else if (select == BOOKING && isLogin())
			booking();
		else if (select == CANCEL && isLogin())
			cancle();
		else if (select == MY_PAGE && isLogin())
			myPage();
		else if (select == EXIT)
			exit();
	}

	void join() {

		String id = inputString("id");
		String password = inputString("password");
		
		// 기본 생성자 x 새로만든 생성자 사용해서 바로 추가
		User user = new User(id, password);

		if (idxOfUser(user.id) != -1) {
			System.out.println("중복되는 아이디입니다.");
			return;
		}

		User[] temp = users;
		users = new User[userCnt + 1];

		for (int i = 0; i < userCnt; i++)
			users[i] = temp[i];

		users[userCnt] = user;
		userCnt++;
		System.out.println("회원가입완료");

	}
	
	void leave() {
		// 1. 비밀번호 확인 후,
		String password = inputString("password");
		
		if(!users[log].password.equals(password)) {
			System.err.println("패스워드가 불일치합니다.");
			return;
		}
		// 2. 탈퇴할 회원의 예매내역 -> 원복
		cancelALLById(users[log].id);
		
		// 3. 회원삭제
		User[] temp = users;
		users = new User[userCnt -1];
		
		int idx = 0;
		for(int i=0; i<userCnt; i++)
			if(i != log)
				users[idx++] = temp[i];
		
		userCnt--;
		
		logout();
		System.out.println("회원 탈퇴 완료");
	}
	
	void login() {
		
		String id = inputString("id");
		String password = inputString("password");
		
		int idx = idxOfUser(id);
		if (users[idx].password.equals(password))
			log = idx;
		
		if (log == -1)
			System.out.println("회원정보를 다시 입력하세요.");
		else
			System.out.println("로그인 완료");
		
	}
	
	void logout() {

		log = -1;
		System.out.println("로그아웃 완료");
	}
	
	void booking() {

		printSeatsAll();
		int code = inputNumber();

		int index = idxOfSeat(code);

		if (index == -1) {
			System.err.println("유효하지 않은 좌석입니다.");
			return;
		}

		String id = users[log].id;
		seats[index].userId = id;
		seats[index].isBooked = true;
		
		User user = users[log];
		Seat seat = seats[index];
		user.recordBooking(seat);
		
		bookCnt++;
		
		System.out.println("예매가 완료되었습니다.");

	}
	
	void cancelALLById(String id) {
//		for(int i=0; i<SIZE; i++) {
//			Seat seat = seats[i];
//			if(seat.isBooked && id.equals(seat.userId)) {
//				seat.userId = null;
//				seat.isBooked = false;
//				
//				bookCnt--;
//			}
//		}
		
		User user = users[log];
		bookCnt -= user.removeBookingAll();
		
	}
	
	void cancle() {
		myPage();
		
		int code = inputNumber();

		int idx = idxOfSeat(code);

		if (idx != -1) {
			Seat seat = seats[idx];

			if (!seat.isBooked || (seat.isBooked && !seat.userId.equals(users[log].id))) {
				System.err.println("예약한 좌석이 아닙니다.");
				return;
			}
			
			seat.userId = null;
			seat.isBooked = false; 
			
			User user = users[log];
			user.removeBooking(seat);
			
			bookCnt--;
			System.out.println("예매 취소가 완료되었습니다.");
		}

	}


	
	
	void printTotal() {

	}

	void myPage() {
//		for (int i = 0; i < SIZE; i++) {
//			Seat seat = seats[i];
//			if (seat.isBooked && seat.userId.equals(users[log].id))
//				System.out.printf("%d번 좌석 [예약완료]\n", seat.code);
//		}
		
		User user = users[log];
		user.printMySeatsAll();
	}
	
	void exit() {
		isExit = true;
	}

	boolean isExit() {
		return isExit;
	}

	int idxOfSeat(int code) {
		int idx = -1;

		for (int i = 0; i < SIZE; i++) {
			Seat seat = seats[i];
			if (code == seat.code)
				idx = i;
		}
		return idx;
	}

//	User createUser(String id, String password) {
//		User user = new User();		// 기본 생성자를 따로 정의하지 않으면 -> 사용이 불가
//		user.id = id;
//		user.password = password;
//
//		return user;
//	}
	
	int idxOfUser(String id) { // 중복검사
		int idx = -1;

		for (int i = 0; i < userCnt; i++) {
			if (users[i].id.equals(id))
				idx = i;
		}
		return idx;
	}

	boolean isLogin() {
		return log == -1 ? false : true;
	}

	
	String inputString(String message) {
		System.out.print(message + " : ");

		return scan.next();
	}

	int inputNumber() {
		int number = -1;

		System.out.print("선택 : ");
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("숫자만 입력하세요.");
		}

		return number;
	}

	void printMenu() {
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.예매하기");
		System.out.println("6.예매취소");
		System.out.println("7.마이페이지");
		System.out.println("0.종료");
	}

	

	void printStatus() {
		System.out.printf("예매 현황 %d/%d\n", bookCnt, SIZE);
		printSeatsAll();
	}

	void run() {
		setSeats();
		while (!isExit()) {
			printSeatsAll();
			printMenu();
			int sel = inputNumber();
			runMenu(sel);
		}
		printTotal();
	}

}

public class Ex03 {

	public static void main(String[] args) {

		Tms system = new Tms();
		system.run();

	}

}