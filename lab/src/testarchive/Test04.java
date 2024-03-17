package testarchive;
// 시작 00:00
// 종료 00:00
// 소요 00:00
class Book{
	
}

class Member{
	
}

class Lms{
	
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
		
	}

}
