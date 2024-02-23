package lv07;

import java.util.Scanner;

// 클래스 배열
class Person{
	String name, id, password, email;
	int age, gender;
	
	void printInfo() {
		System.out.printf("이름 : %s \n id : %s \n 비밀번호 : %s \n"
				+ "이메일 : %s \n 나이 : %d \n 성별 : %d \n"
				,name,id,password,email,age,gender);
	}
}

class CMS {
	Scanner sc = new Scanner(System.in);
	
	int size;
	int log = -1;
	
	Person[] group;
	void setSize() {
		size = 0;
	}
	
	void setSizePlus(String inputId) {
		Person[] tempArr = group;
		group = new Person[size+1];
		group[size] = new Person();
		for(int i=0; i<size; i++) {
			group[i] = tempArr[i];
		}
		group[size].id = inputId;
		System.out.print("password");
		group[size].password = inputStirng();
		System.out.print("name");
		group[size].name = inputStirng();
		System.out.print("email");
		group[size].email = inputStirng();
		System.out.print("age 1)남성 2)여성");
		group[size].age = inputNumber();
		System.out.print("gender");
		group[size].gender = inputNumber();
		size++;
	}
	
	boolean isRun() {
		boolean run = true;
		
		
		return run;
	}
	
	void printMenu() {
		if(log != -1)
			System.out.printf("%s님 환영합니다.\n",group[log].name);
		System.out.println();
		System.out.println("회원관리 프로그램");
		System.out.println("1)회원가입");
		System.out.println("2)회원탈퇴");
		System.out.println("3)로그인");
		System.out.println("4)로그아웃");
		System.out.println("5)비밀번호 재설정");
		System.out.println("6)회원 조회");
	}
	
	int inputNumber() {
		int num = -1;
		try {
			System.out.print("입력 : ");
			String input = sc.next();
			num = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return num;
	}
	
	String inputStirng() {
		System.out.print("입력 : ");
		String input = sc.next();
		
		return input;
	}
	
	boolean logCheck() {
		boolean login = false;
		if(log == -1) {
			login = false;
		}else if(log != -1) {
			login = true;
		}
		
		
		
		return login;
	}
	
	boolean idDupl(String id) {
		boolean isDupl = false;
		if(size == 0)
			return false;
		for(int i=0; i<size; i++) {
			if(group[i].name.equals(id)) {
				isDupl = true;
				System.err.println("이미 있는 아이디 입니다");
				break;
			}
		}
		
		return isDupl;
	}
	
	void signUp() {
		System.out.print("id");
		String inputId = inputStirng();
		if(idDupl(inputId))
			return;
		setSizePlus(inputId);
		
		
	}
	
	void setSizeMinus() {
		Person[] tempArr = group;
		group = new Person[size-1];
		int cnt = 0;
		for(int i=0; i<size; i++) {
			if(log != i)
				group[cnt++] = tempArr[i];
		}
		size--;
		log = -1;
	}
	
	void withdrawal() {
		System.out.print("password");
		String password = inputStirng();
		if(password.equals(group[log].password))
			setSizeMinus();
		else
			System.err.println("비밀번호 불일치");
	}
	
	void login() {
		System.out.print("아이디");
		String id = inputStirng();
		System.out.print("비밀번호");
		String pw = inputStirng();
		for(int i=0; i<size; i++) {
			if(group[i].id.equals(id) && group[i].password.equals(pw))
				log = i;
		}
		
		if(log == -1)
			System.err.println("아이디/비밀번호 불일치");
	}
	
	void logout() {
		log = -1;
		System.out.println("로그인 되셨습니다");
	}
	
	void pwReset() {
		System.out.print("변경할 비번");
		String pw = inputStirng();
		
		group[log].password = pw; 
	}
	void inquiry() {
		System.out.println("1) 한명 조회 2)전체 조회");
		int sel = inputNumber();
		if(sel == 1) {
			System.out.print("조회할 id");
			String id = inputStirng();
			findId(id);
		}else if(sel == 2) {
			for(int i=0; i<size; i++) {
				group[i].printInfo();
			}
		}
	}
	
	void findId(String id) {
		for(int i=0; i<size; i++) {
			if(group[i].id.equals(id)) {
				group[i].printInfo();
			}
		}
	}
	void selectMenu(int sel) {
		if(sel == 1 && !logCheck()) {
			signUp();
		}else if(sel == 2 && logCheck()) {
			withdrawal();
		}else if(sel == 3 && !logCheck() && size != 0) {
			login();
		}else if(sel == 4 && logCheck()) {
			logout();
		}else if(sel == 5 && logCheck()) {
			pwReset();
		}else if(sel == 6) {
			inquiry();
			
		}
	}
	
	
	void run() {
		setSize();
		
		while(isRun()) {
			printMenu();
			
			int sel = inputNumber();
			selectMenu(sel);
			
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
