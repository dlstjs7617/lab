package test.lv8;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

//시작 18:06
//종료 20:14
//소요 02:08

class Subject{
	private String title;
	private int code;
	private int score;
	
	public Subject(String title, int code) {
		this.title = title;
		this.code = code;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTitle() {
		return title;
	}

	public int getCode() {
		return code;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%d) 점수 : %d", title, code, score);
	}
}

class Student{
	private String name;
	private int code;
	private Vector<Subject> subjects;
	
	public Student(String name, int code) {
		this.name = name;
		this.code = code;
		subjects = new Vector<Subject>();
	}

	public String getName() {
		return name;
	}

	public int getCode() {
		return code;
	}
	
	private int findIndexByCode(int code) {
		for(int i=0; i<subjects.size(); i++) {
			Subject subject = subjects.get(i);
			if(subject.getCode() == code)
				return i;
		}
		
		return -1;
	}
	
	public boolean isDupl(int code) {
		for(Subject subject : subjects) {
			if(subject.getCode() == code)
				return true;
		}
		
		return false;
	}
	
	public void printSubject() {
		for(Subject subject : subjects) {
			System.out.println(subject);
		}
	}
	
	public void addSubject(Subject subject) {
		subjects.add(subject);
	}
	
	public void delSubject(int code) {
		int idx = findIndexByCode(code);
		
		if(idx == -1) {
			System.err.println("과목코드 오류");
			return;
		}
		
		subjects.remove(idx);
	}
	
	public void setScore(int code, int score) {
		int idx = findIndexByCode(code);
		
		if(idx == -1) {
			System.err.println("과목코드 오류");
			return;
		}
		
		subjects.get(idx).setScore(score);
		
	}
	
	public double getTotalScore() {
		double avg = 0;
		for(int i=0; i<subjects.size(); i++) {
			Subject subject = subjects.get(i);
			avg += subject.getScore();
		}
		
		return avg/subjects.size();
	}
	
	@Override
	public String toString() {
		return String.format("%s(%d) : %d개 수강중", name, code, subjects.size());
	}
	
}

class Lms{
	
	private final int STUDENT = 1;
	private final int SUBJECT= 2;
	private final int SCORE = 3;
	private final int SORT = 4;
	
	private final int ADD_STUDENT = 1;
	private final int INQURIY_STUDENT = 2;
	private final int DELETE_STUDENT = 3;

	private final int ADD_SUBJECT = 1;
	private final int INPUT_SUBJECT = 2;
	private final int CANCLE_SUBJECT = 3;
	
	private final int INPUT_SCORE = 1;
	private final int SET_SCORE = 2;
	
	private final int SORT_SCORE = 1;
	private final int SORT_NAME = 2;
	private final int SORT_CODE = 3;
	
	
	private Scanner sc = new Scanner(System.in);
	private Random ran = new Random();
	
	private ArrayList<Student> students;
	private Vector<Subject> subjects;
	
	private String brand;
	
	public Lms(String brand) {
		this.brand = brand;
		students = new ArrayList<Student>();
		subjects = new Vector<Subject>();
	}
	
	private int inputNumber(String message) {
		int number = -1;
		
		System.out.print(message + " : ");
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return number;
	}
	
	private String inputString(String message) {
		System.out.print(message + " : ");
		return sc.next();
	}
	
	private int rStudentCode() {
		while(true) {
			boolean isDupl = false;
			int rCode = ran.nextInt(8999)+1000;
			for(int i=0; i<students.size(); i++) {
				if(students.get(i).getCode() == rCode)
					isDupl = true;
			}
			
			if(!isDupl)
				return rCode;
		}
	}
	
	private int rSubjectCode() {
		while(true) {
			boolean isDupl = false;
			int rCode = ran.nextInt(8999)+1000;
			for(int i=0; i<subjects.size(); i++) {
				if(subjects.get(i).getCode() == rCode)
					isDupl = true;
			}
			
			if(!isDupl)
				return rCode;
		}
	}
	
	private void printStudent() {
		for(Student student : students) {
			System.out.println(student);
		}
	}
	
	private void printSubject() {
		for(Subject subject : subjects) {
			System.out.println(subject);
		}
	}
	
	private int findIndexbyStudentCode(int code) {
		for(int i=0; i<students.size(); i++) {
			Student student = students.get(i);
			if(student.getCode() == code)
				return i;
		}
		
		return -1;
	}
	
	private int findIndexbySubjectCode(int code) {
		for(int i=0; i<subjects.size(); i++) {
			Subject subject = subjects.get(i);
			if(subject.getCode() == code)
				return i;
		}
		
		return -1;
	}
	
	private Subject cloneSubject(int index) {
		String title = subjects.get(index).getTitle();
		int code = subjects.get(index).getCode();
		
		Subject subject = new Subject(title, code);
		
		return subject;
	}
	
	
	private int checkCodeReturnIndex() {
		printStudent();
		int code = inputNumber("학번입력");
		
		return findIndexbyStudentCode(code); 
	}
	
	private boolean isRun() {
		return true;
	}
	
	private void addStudent() {
		String name = inputString("이름");
		int code = rStudentCode();
		
		Student student = new Student(name, code);
		
		students.add(student);
		System.out.println("학생등록 완료");
	}
	
	private void inquriyStudent() {
		int idx = checkCodeReturnIndex();
		
		if(idx == -1) {
			System.err.println("학번 오류");
			return;
		}
		
		System.out.println(students.get(idx));
		students.get(idx).printSubject();
	}
	
	private void deleteStudent() {
		int idx = checkCodeReturnIndex();
		
		if(idx == -1) {
			System.err.println("학번 오류");
			return;
		}
		
		students.remove(idx);
		System.out.println("학생제적 완료");
	}
	
	private void studentSubMenu() {
		System.out.println("1.등록");
		System.out.println("2.조회");
		System.out.println("3.제적");
	}

	private void selectStudent(){
		int sel = inputNumber("메뉴");
		
		if(sel == ADD_STUDENT) {
			addStudent();
		}else if(sel == INQURIY_STUDENT) {
			inquriyStudent();
		}else if(sel == DELETE_STUDENT) {
			deleteStudent();
		}
	}
	
	private void addSubject() {
		String title = inputString("과목명");
		int code = rSubjectCode();
		
		Subject subject = new Subject(title, code);
		subjects.add(subject);
		
		System.out.println("과목등록 완료");
	}
	
	private boolean checkSubject(int idx, int code) {
		return students.get(idx).isDupl(code);
	}
	
	private void inputSubject() {
		int idx = checkCodeReturnIndex();
		
		if(idx == -1) {
			System.err.println("학번 오류");
			return;
		}
		
		printSubject();
		int code = inputNumber("과목코드");
		int index = findIndexbySubjectCode(code);
		
		if(index == -1) {
			System.err.println("과목코드 오류");
			return;
		}
		
		if(checkSubject(index, code)) {
			System.err.println("이미 신청한 과목입니다");
			return;
		}
		
		Subject subject = cloneSubject(index);
		students.get(idx).addSubject(subject);
		System.out.println("수강신청 완료");
	}
	
	private void cancleSubject() {
		int idx = checkCodeReturnIndex();
		
		if(idx == -1) {
			System.err.println("학번 오류");
			return;
		}
		
		printSubject();
		int code = inputNumber("과목코드");
		int index = findIndexbySubjectCode(code);
		
		if(index == -1) {
			System.err.println("과목코드 오류");
			return;
		}
		
		students.get(idx).delSubject(code);
		System.out.println("수강철회 완료");
	}
	
	private void subjectSubMenu() {
		System.out.println("1.등록");
		System.out.println("2.신청");
		System.out.println("3.철회");
	}
	
	private void selectSubject() {
		int sel = inputNumber("메뉴");
		
		if(sel == ADD_SUBJECT) {
			addSubject();
		}else if(sel == INPUT_SUBJECT) {
			inputSubject();
		}else if(sel == CANCLE_SUBJECT) {
			cancleSubject();
		}
	}
	
	private void inputScore() {
		int idx = checkCodeReturnIndex();
		
		if(idx == -1) {
			System.err.println("학번 오류");
			return;
		}
		
		students.get(idx).printSubject();
		
		int code = inputNumber("과목코드");
		int score = inputNumber("성적");
		
		if(score < 0 || score > 100) {
			System.err.println("유효하지않은 값");
			return;
		}
		
		students.get(idx).setScore(code, score);
	}
	
	private void setScore() {
		inputScore();
	}
	
	private void scoreSubMenu() {
		System.out.println("1.등록");
		System.out.println("2.수정");
	}
	
	private void selectScore() {
		int sel = inputNumber("메뉴");
		
		if(sel == INPUT_SCORE) {
			inputScore();
		}else if(sel == SET_SCORE) {
			setScore();
		}
	}
	
	private void sortScore() {
		for(int i=0; i<students.size(); i++) {
			Student student = students.get(i);
			int max = i;
			
			for(int j=i; j<students.size(); j++) {
				if(students.get(max).getTotalScore() < students.get(j).getTotalScore())
					max = j;
			}
			
			Student temp = students.get(max);
			
			students.set(i, temp);
			students.set(max, student);
		}
		
		printStudent();
	}
	
	private void sortName() {
		for(int i=0; i<students.size(); i++) {
			Student student = students.get(i);
			int max = i;
			
			for(int j=i; j<students.size(); j++) {
				if(students.get(max).getName().compareTo(students.get(j).getName()) > 0)
					max = j;
			}
			
			Student temp = students.get(max);
			
			students.set(i, temp);
			students.set(max, student);
			
		}
		printStudent();
	}
	
	private void sortCode() {
		for(int i=0; i<students.size(); i++) {
			Student student = students.get(i);
			int max = i;
			
			for(int j=i; j<students.size(); j++) {
				if(students.get(max).getCode() > students.get(j).getCode())
					max = j;
			}
			
			Student temp = students.get(max);
			
			students.set(i, temp);
			students.set(max, student);
		}
		
		printStudent();
	}
	
	private void sortSubMenu() {
		System.out.println("1.성적");
		System.out.println("2.이름");
		System.out.println("3.학번");
	}
	
	private void selectSort() {
		int sel = inputNumber("메뉴");
		
		if(sel == SORT_SCORE) {
			sortScore();
		}else if(sel == SORT_NAME) {
			sortName();
		}else if(sel == SORT_CODE) {
			sortCode();
		}
	}

	private void printMenu() {
		System.out.println(brand);
		System.out.println("1.학생");
		System.out.println("2.과목");
		System.out.println("3.성적");
		System.out.println("4.정렬");
	}
	
	private void selectMenu() {
		int select = inputNumber("메뉴");
		
		if(select == STUDENT) {
			studentSubMenu();
			selectStudent();
		}else if(select == SUBJECT) {
			subjectSubMenu();
			selectSubject();
		}else if(select == SCORE) {
			scoreSubMenu();
			selectScore();
		}else if(select == SORT) {
			sortSubMenu();
			selectSort();
		}
	}
	
	public void run() {
		while(isRun()) {
			printMenu();
			selectMenu();
		}
	}
	
	
}

public class Test04 {

	public static void main(String[] args) {
		
		// 4.
		// LMS
		// class : Subject, Student, Lms
		// collection
		// ㄴ ArrayList<Student> students
		// ㄴ Vector<Subject> subjects
		// methods
		// ㄴ 학생 등록/조회/제적
		// ㄴ 과목 등록/신청/철회
		// ㄴ 성적 등록/수정
		// ㄴ 정렬 성적/이름/학번
		
		Lms system = new Lms("Mega Academy");
		system.run();
	}

}