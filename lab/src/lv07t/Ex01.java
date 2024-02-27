package lv07t;

import java.util.Scanner;

// 클래스 배열
class Person{
	String name, id, password, email;
	int age, gender;
//	
//	void printInfo() {
//		System.out.printf("이름 : %s \n id : %s \n 비밀번호 : %s \n"
//				+ "이메일 : %s \n 나이 : %d \n 성별 : %d \n"
//				,name,id,password,email,age,gender);
//		System.out.printf("%s/%s(%s, %s) %d세, %s\n",id, password, name, email, age, gender == 1 ? "남자" : "여자");
//	}
//	
	@Override
	   public String toString() {
	      return String.format("%s/%s(%s, %s) %d세, %s\n", id, password, name, email, age, gender == 1 ? "남자" : "여자");
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
	
	final int SEARCH_USER = 1;
	final int SEARCH_USER_ALL = 2;
	int log =-1;
	int size;
	Person[] group;
	
	Person createUser() {		
		String name = inputString("name");
		String id = inputString("id");
		String email = inputString("email");
		String password = inputString("password");
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
	
	int searchUserById(String id) {
		for(int i=0; i<size; i++) {
			Person user = group[i];
			
			if(user.id.equals(id))
				return i;
		}
		return -1;
	}
	
	void join() {
		Person user = createUser();
	
		// id 중복 예외처리
		if(searchUserById(user.id) != -1) {
			System.err.println("중복되는 아이디입니다.");
			return;
		}
		// group 배열의 크기를 늘리고
		// 기존 값을 옮겨오고
		

		Person[] temp = size == 0 ? null : group.clone();
		group = new Person[size + 1];
		
		for(int i=0; i<size; i++) {
			group[i] = temp[i];
		}
		// 마지막 인덱스에 새로운 Person 객체를 추가
		// 	group[size] : null -> new Person();
		group[size++] = user;
		System.out.println("회원가입 완료");
	}
	
	void runMenu(int select) {
		if(select == JOIN && !isLogin())
			join();
		else if(select == LEAVE && isLogin())
			leave();
		else if(select == LOG_IN && !isLogin())
			login();
		else if(select == LOG_OUT)
			logout();
		else if(select == RESET_PASSWORD && isLogin())
			resetPassword();
		else if(select == VIEW_USER) {
			printSubMenu();
			int sel = inputNumber("메뉴");
			runSubMenu(sel);
		}
	}
	
	void resetPassword() {
		String password = inputString("현재 비밀번호");
		String newPassword = inputString("새 비밀번호");
		
		if(group[log].password.equals(password)) {
			group[log].password = newPassword;
			System.out.println("비밀번호 변경 완료");
		}else {
			System.err.println("비밀번호가 불일치합니다.");
		}
		
	}
	
	boolean isLogin() {
		return log == -1 ? false : true;
	}
	
	void leave() {
		String password = inputString("password");
		
		if(group[log].password.equals(password)) {
			Person[] temp = group.clone();
			group = new Person[size-1];
			
			int idx = 0;
			for(int i=0; i<size; i++)
				if(i != log)
					group[idx++] = temp[i];
			
			size--;
			
			logout();
		}else {
			System.err.println("패스워드가 불일치 합니다.");
		}
	}
	
	void login() {
		String id = inputString("id");
		String password = inputString("password");

		int idx = searchUserById(id);
		
		if(idx != -1 && group[idx].password.equals(password))
			log = idx;
		
		if(log == -1)
			System.err.println("회원정보를 다시 확인 해주세요.");
	}
	
	void logout() {
		log = -1;
		System.out.println("로그아웃 완료");
	}
	
	void printUserInfo() {
		String id = inputString("id");
		int idx = searchUserById(id);
		if(idx != -1)
			System.out.println(group[idx]);
		else
			System.err.println("존재하지 않는 회원입니다.");
	}
	
	void runSubMenu(int select) {
		if(select == SEARCH_USER) {
			printUserInfo();
		}else if(select == SEARCH_USER_ALL) {
			printGroupInfo();
		}
		
		
	}
	
	void printGroupInfo() {
		for(int i=0; i<size; i++) {
			System.out.println("\n" + (i+1) + ".");
			
			System.out.println(group[i]);
		}
	}
	
	boolean isRun() {
		return true;
	}
	
	void printSubMenu() {
		System.out.println("1)회원조회");
		System.out.println("1)회원 전체 조회");
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
	

	String inputString(String message) {
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
