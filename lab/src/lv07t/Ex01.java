package lv07t;

import java.util.Scanner;

// 클래스 배열
class Person{
	String name, id, password, email;
	int age, gender;
	
	void printInfo() {
		System.out.printf("이름 : %s \n id : %s \n 비밀번호 : %s \n"
				+ "이메일 : %s \n 나이 : %d \n 성별 : %d \n"
				,name,id,password,email,age,gender);
		System.out.printf("%s/%s(%s, %s) %d세, %s\n",id, password, name, email, age, gender == 1 ? "남자" : "여자");
	}
}

class CMS {
	Scanner sc = new Scanner(System.in);
	
	final int JOIN = 1;
	final int LEAVE = 2;
	final int LOG_IN = 3;
	final int LOG_OUT = 4;
	final int RESET_PASSWORD = 5;
	final int VIEW_USER = 6;
	
	int size;
	Person[] group;
	
	Person createUser() {		
		String name = inputStirng("name");
		String id = inputStirng("id");
		String email = inputStirng("email");
		String password = inputStirng("password");
		int age = inputNumber("age");
		int gender = inputNumber("1)남자 2)여자 ");
		
		Person person = new Person();
		
		person.name = name;
		person.id = id;
		person.email = email;
		person.password = password;
		person.gender = gender;
		
		return person;
	}
	
	boolean isDuplicationUserId(String id) {
		for(int i=0; i<size; i++) {
			Person user = group[i];
			
			if(group[i].id.equals(id))
				return true;
		}
		
		return false;
	}
	
	void join() {
		Person user = createUser();
	
		// id 중복 예외처리
		if(isDuplicationUserId(user.id)) {
			System.err.println("중복되는 아이디입니다.");
			return;
		}
		// group 배열의 크기를 늘리고
		// 기존 값을 옮겨오고
		
//		Person[] temp = size == 0 ? null group.clone();
		group = new Person[size + 1];
		// 마지막 인덱스에 새로운 Person 객체를 추가
	}
	
	void runMenu(int select) {
		if(select == JOIN)
			join();
//		else if(select == LEAVE)
//			leave();
//		else if(select == LOG_IN)
//			login();
//		else if(select == LOG_OUT)
//			logout();
//		else if(select == RESET_PASSWORD)
//			resetPassword();
//		else if(select == VIEW_USER) {
//			printSubMenu();
//			int sel = inputNumber();
//			runSubMenu(sel);
//		}
	}
	
	boolean isRun() {
		return true;
	}
	
	void printMenu() {
		System.out.println("---- CMS ----");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원탈퇴");
		System.out.println("3. 로그인");
		System.out.println("4. 로그아웃");
		System.out.println("5. 비밀번호 변경");
		System.out.println("6. 회원정보 조회");
		System.out.println("-------------");
	}
	

	String inputStirng(String message) {
		System.out.print(message + " : ");
		return sc.next();
	}
	
	int inputNumber(String message) {
		int num = -1;
		System.out.print(message + " : ");
		try {
			String input = sc.next();
			num = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return num;
	}
	
	
	void run() {
		while(isRun()) {
			printMenu();
			int sel = inputNumber("menu");
			runMenu(sel);
		}
		
	}
}

public class Ex01 {

	public static void main(String[] args) {
//		group[0] = new Person(); // 이렇게 선언 해줘야 주소값 들어갈 수 있음
		// 회원관리 프로그램 만들기
		// ㄴ 회원 가입
		// ㄴ 회원 탈퇴
		// ㄴ 로그인/아웃
		// ㄴ 비밀번호 재설정
		// ㄴ 회원 조회
		//    ㄴ 한 명 조회
		//    ㄴ 전체 조회
		
		CMS system = new CMS();
		system.run();
	}

}
