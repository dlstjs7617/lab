package test.lv7;
// 시작 18:01
// 종료 00:00
// 소요 00:00

import java.util.Arrays;

class Book{
	private String bookName;
	private int bookCode;
	private int code;
	private String day;
	
	public Book(int bookCode, String bookName, String day, int code) {
		this.bookName = bookName;
		this.bookCode = bookCode;
		this.code = code;
		this.day = day;
	}
}

class Member{
	private int code;
	private Book[] book;
	
	public Member(int code,String bookCode) {
		
	}
	
	
}

class Lms{
	
	private String reatalData;
	private String userData;
	
	private Book[] book;
	private Member[] member;
	private int bookSize; 
	private int memSize;
	
	public Lms(String reatalData ,String userData) {
		this.reatalData = reatalData;
		this.userData = userData;
	}
	
	private int findbookIdx(String bookCode) {
		int idx = -1;
		
		for(int i=0; i<bookSize; i++) {
			books[i]
		}
		
		return idx;
	}
	
	private void setUserData() {
		String[] temp = userData.split("\n");
		memSize = temp.length-1;
		member = new Member[memSize];
		
		for(int i=0; i<memSize; i++) {
			String[] data = temp[i+1].split("/");
			findbookIdx(data[1]);
			member[i] = new Member(Integer.parseInt(data[0]),data[1]);
		}
		
	}
	
	private void setBookData() {
		String[] temp = reatalData.split("\n");
		bookSize = temp.length-1;
		book = new Book[bookSize];
		
		for(int i=0; i<bookSize; i++) {
			String[] bData = temp[i+1].split("/");
			book[i] = new Book(Integer.parseInt(bData[0]), bData[1], bData[2], Integer.parseInt(bData[4]));
		}
	}
	
	// 유저 자료 정리
	private void setData() {
		setBookData();
		setUserData();
	}
	
	public void run() {
		setData();
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
		rentalData += "40143/외국어 공부의 감각/2020-11-27/1003";
		rentalData += "54321/컴퓨터활용능력/2020-11-27/1041\n"; 
		rentalData += "26543/아무튼,외국어/2020-12-01/1034";
		
		// system.parseAndRegistUserData(userData)
		String userData = "";
		userData += "회원번호/책번호/대여일수(day)\n";
		userData += "1001/20122/0\n"; //rentalData 활용 -> 대여일수 값 부여
		userData += "1003/40143/0\n";
		userData += "1041/54321/0\n";
		userData += "1034/26543/0";
		
		Lms lms = new Lms(rentalData, userData);
		lms.run();

	}

}
