package test.lv8;

import java.util.Vector;

//시작 20:20
//종료 00:00
//소요 00:00
class Member {
	private int code;
	private String name;
	private String phone;
	private String telecom;
	private String join;
	private String group;
	private String city;
	
	public Member(int code, String name, String phone, String telecom, String join, String group, String city) {
		this.code = code;
		this.name = name;
		this.phone = phone;
		this.telecom = telecom;
		this.join = join;
		this.group = group;
		this.city = city;
	}
	
}

class Sale{
	
}

class Crm {
	private Vector<Member> memberList;
	private Vector<Sale> moneyList;
	
	
	public Crm() {
		memberList = new Vector<Member>();
		moneyList = new Vector<Sale>();
		init();
	}
	
	private void init() {
		// 회원번호, 이름, 연락처, 통신사, 가입일자, 등급, 거주도시 
		memberList.add(new Member(100001, "김행복", "010-1111-2222", "SKT", "20151202", "A", "01"));
		memberList.add(new Member(100002, "이축복", "010-1111-3333", "KT", "20151206", "B", "01"));
		memberList.add(new Member(100003, "장믿음", "010-1111-4444", "SKT", "20151001", "B", "30"));
		memberList.add(new Member(100004, "최사랑", "010-1111-5555", "SKT", "20151113", "A", "30"));
		memberList.add(new Member(100005, "진평화", "010-1111-6666", "KT", "20151225", "B", "60"));
		memberList.add(new Member(100006, "차공단", "010-1111-7777", "LGT", "20151211", "C", "60"));
		
		// 회원번호, 판매일자, 단가, 수량, 매출금액, 상품코드, 판매일자 
		moneyList.add(new Sale(100001, 20240001, 500, 5, 2500, "A001", "20240101"));
		moneyList.add(new Sale(100001, 20240002, 1000, 4, 4000, "A002", "20240101"));
		moneyList.add(new Sale(100001, 20240003, 500, 3, 1500, "A008", "20240101"));
		moneyList.add(new Sale(100002, 20240004, 2000, 1, 2000, "A004", "20240102"));
		moneyList.add(new Sale(100002, 20240005, 500, 1, 500, "A001", "20240103"));
		moneyList.add(new Sale(100003, 20240006, 1500, 2, 3000, "A003", "20240103"));
		moneyList.add(new Sale(100004, 20240007, 500, 2, 1000, "A001", "20240104"));
		moneyList.add(new Sale(100004, 20240008, 300, 1, 300, "A005", "20240104"));
		moneyList.add(new Sale(100004, 20240009, 600, 1, 600, "A006", "20240104"));
		moneyList.add(new Sale(100004, 20240010, 3000, 1, 3000, "A007", "20240106"));
	}
	
	public void calculatePurchaseRankings() {
		
	}
}

public class Test05 {

	public static void main(String[] args) {
		// 5.
		// CRM (영업 관리 시스템)
		// class : Crm, Member, Sale
		/*
		 * [정보처리산업기사 실기 문제]
		 *  아래와 같이 출력 매출(price)의 합계 + 내림차순
		 *  
		 *  100001	김행복		8000
		 *  -----------------------
		 *  100004	최사랑		4900
		 *  -----------------------
		 *  100003	장믿음		3000
		 *  -----------------------
		 *  100002	이축복		2500
		 *  -----------------------
		 */
		
		Crm manager = new Crm();
		manager.calculatePurchaseRankings();
	}

}







