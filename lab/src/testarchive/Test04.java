package testarchive;
// 시작 00:00
// 종료 00:00
// 소요 00:00
class Book{
	private int bookCode;
	private int memCode;
	private String bookName;
	private String day;
	
	public Book(int bookCode, String bookName, String day, int memCode) {
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.day = day;
		this.memCode = memCode;
	}

	public Book(int bookCode, String bookName, int memCode) {
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.memCode = memCode;
	}
	
	public int getBookCode() {
		return bookCode;
	}
	
	public int getmemCode() {
		return memCode;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setMemCode(int memCode) {
		this.memCode = memCode;
	}
	
	public String getDay() {
		return day;
	}
	
	public void setDay(String day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return String.format("책코드 : %d 빌린사람 : %d 책이름 : %s 빌린날짜 : %s", bookCode, memCode, bookName, day);
	}
}

class Member{
	private int memCode;
	private int days;
	private int rentalSize;
	private Book[] books;
	
	public Member(int memCode, int bookCode,int days ,String bookName) {
		this.memCode = memCode;
		this.days = days;
		booksArrPlus(bookCode, bookName);
	}
	
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getMemCode() {
		return memCode;
	}

	
	private void booksArrPlus(int bookCode, String bookName) {
		Book[] temp = books;
		books = new Book[rentalSize +1];
		
		for(int i=0; i<rentalSize; i++) {
			books[i] = temp[i];
		}
		
		books[rentalSize] = new Book(bookCode, bookName, memCode);
		rentalSize++;
	}
	
	@Override
	public String toString() {
		return String.format("%d님 %d일 연체 %s", memCode, days, days > 7 ? "연체자입니다" : "연체자가 아닙니다");
	}
	
}

class Lms{
	
	private Book[] book;
	private Member[] member;
	
	private String retalData;
	private String userData;
	private String day;
	
	private int bSize;
	private int mSize;

	private int[] month = {31, 28, 31, 30, 31, 30 ,31, 31, 30, 31, 30};
	
	public Lms(String rentalData, String userData){
		this.retalData = rentalData;
		this.userData = userData;
		this.day = "2020-12-04";
	}
	
	private int findbookIdx(int bookCode) {
		int idx = -1;
		
		for(int i=0; i<bSize; i++) {
			if(book[i].getBookCode() == bookCode)
				idx = i;
		}
		
		return idx;
	}
	
	private int findMemCode(int memCode) {
		int idx = -1;
		
		for(int i=0; i<mSize; i++) {
			if(memCode == member[i].getMemCode())
				idx = i;
		}
		
		return idx;
	}
	
	private void setRentalData() {
		String[] rental = retalData.split("\n");
		bSize = rental.length-1;
		book = new Book[bSize];
		
		for(int i=0; i<bSize; i++) {
			String[] temp = rental[i+1].split("/");
			
			int bookCode = Integer.parseInt(temp[0]);
			String bookName = temp[1];
			String day = temp[2];
			int memCode = Integer.parseInt(temp[3]);
			
			book[i] = new Book(bookCode, bookName, day, memCode);
		}
		
	}
	
	private void setUserData() {
		String[] user = userData.split("\n");
		mSize = user.length-1;
		member = new Member[mSize];
		
		for(int i=0; i<mSize; i++) {
			String[] temp = user[i+1].split("/");
			int memerCode = Integer.parseInt(temp[0]);
			int bookCode = Integer.parseInt(temp[1]);
			
			String bookName = book[findbookIdx(bookCode)].getBookName();
			member[i] = new Member(memerCode, bookCode, 0, bookName);
		}
	}
	
	private int todayCount() {
		String[] dayArr = (day.split("-"));
		
		int month = Integer.parseInt(dayArr[1]);
		int day = Integer.parseInt(dayArr[2]);
		
		return monthCount(month, day);
	}
	
	private int monthCount(int month, int day) {
		int days = day;
		
		for(int i=0; i<month-1; i++) {
			days += this.month[i];
		}
		
		return days;
	}
	
	private int bookCount(int idx) {
			String[] rentalDay = book[idx].getDay().split("-");
			int month = Integer.parseInt(rentalDay[1]);
			int day = Integer.parseInt(rentalDay[2]);
			
			return monthCount(month, day);
	}
	
	private void setRentalDay() {
		int todayCnt = todayCount();
		
		for(int i=0; i<bSize; i++) {
			int rentalCnt = bookCount(i);
			int midx = findMemCode(book[i].getmemCode());
			
			member[midx].setDays(todayCnt-rentalCnt);
		}
	}
	
	private void printRentalMember() {
		for(int i=0; i<mSize; i++) {
			System.out.println(book[i]);
			System.out.println(member[i]);
		}
	}
	
	private void setData() {
		setRentalData();
		setUserData();
		setRentalDay();
	}
	public void run() {
		setData();
		printRentalMember();
	}
	
}

public class Test04 {

	public static void main(String[] args) {
		//4.
		// class : Book, Member, Lms(Library management System)
		// 기능 	 : 멤버관리(등록),도서관리(대여), 연체관리(출력)
		
		// 다음 데이터는 도서관 책 대여 기록이다.
		// 오늘이 12월 4일 이라고 했을때 연체자들의 회원번호를 출력(1주일 초과 시, 연체)
		
		//system.parseAndRegistRentalData(rentalData);
		String rentalData = "";
		rentalData += "책번호/책제목/대여날짜/회원번호\n";
		rentalData += "20122/연필로쓰기/2020-11-25/1001\n";
		rentalData += "40143/외국어 공부의 감각/2020-11-27/1003\n";
		rentalData += "54321/컴퓨터활용능력/2020-11-27/1041\n"; 
		rentalData += "26543/아무튼,외국어/2020-12-01/1034";
		
		// system.parseAndRegistUserData(userData)
		String userData = "";
		userData += "회원번호/책번호/대여일수(day)\n";
		userData += "1001/20122/0\n";
		userData += "1003/40143/0\n";
		userData += "1041/54321/0\n";
		userData += "1034/26543/0";
		
		Lms lms = new Lms(rentalData, userData);
		lms.run();
		
	}

}
