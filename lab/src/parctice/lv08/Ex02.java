package parctice.lv08;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Subject{
	
	private String title;
	private int subCode;
	private int code;
	private int score;
	
	public Subject(String title, int subCode) {
		this.title = title;
		this.subCode = subCode;
	}

	public String getTitle() {
		return title;
	}

	public int getSubCode() {
		return subCode;
	}

	public int getScore() {
		return score;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%d) score : %d", title, subCode, score);
	}
	
	
}
class Student{
	
	private String name;
	private int code;
	private ArrayList<Subject> subject;
	
	public Student(String name, int code) {
		subject = new ArrayList<Subject>();
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public void setSubject(Subject subject) {
		this.subject.add(subject);
	}
	
	public boolean setScore(int subScore, int score) {
		for(int i=0; i<subject.size(); i++) {
			if(subject.get(i).getSubCode() == subScore) {
				subject.get(i).setScore(score);
				return true;
			}
		}
		
		return false;
	}
	
	public double getTotalScore() {
		double avg = 0;
		
		for(int i=0; i<subject.size(); i++) {
			avg += subject.get(i).getScore();
		}
		
		avg = avg/subject.size();
		
		return avg;
	}
	
	public boolean findSubjectBySubCode(int subCode) {
		for(int i=0; i<subject.size(); i++) {
			if(subject.get(i).getSubCode() == subCode) {
				subject.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("%d(%s) 수강 : %d 개", name, code, subject.size());
	}
	
	
}

class Manager{

	private final int STUDENT = 1;
	private final int SUBJECT = 2;
	private final int SCORE = 3;
	private final int SORT = 4;
	private final int SAVE = 5;

	private final int ADD = 1;
	private final int DELETE = 2;
	private final int INQURIY = 3;

	private final int ADD_SUBJECT = 1;
	private final int APP_SUBJECT = 2;
	private final int CANCLE_SUBJECT = 3;
	
	private final int SORT_CODE = 1;
	private final int SORT_NAME = 2;
	private final int SORT_SCORE = 3;
	
	private Scanner sc = new Scanner(System.in);
	
	private ArrayList<Student> group;
	private ArrayList<Subject> subject;
	
	public Manager() {
		group = new ArrayList<Student>();
		subject = new ArrayList<Subject>();
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
	
	private boolean isRun() {
		return true;
	}
	
	private int findCodeByIndex() {
		int code = inputNumber("학번");
		
		int idx = findStudentIdx(code);
		
		return idx;
	}
	
	private void printAllStudent() {
		for(int i=0; i<group.size(); i++) {
			System.out.println(group.get(i));
		}
	}
	
	private int rSubCode() {
		Random ran = new Random();
		while(true) {
			int rNum = ran.nextInt(9000)+1000;
			
			boolean	isDupl = false;
			for(int i=0; i<group.size(); i++) {
				Subject sub = subject.get(i);
				if(sub.getSubCode() == rNum)
					isDupl = true;
			}
			
			if(!isDupl)
				return rNum;
		}
	}
	
	private int rCode() {
		Random ran = new Random();
		while(true) {
			int rNum = ran.nextInt(9000)+1000;
			
			boolean	isDupl = false;
			for(int i=0; i<group.size(); i++) {
				Student student = group.get(i);
				if(student.getCode() == rNum)
					isDupl = true;
			}
			
			if(!isDupl)
				return rNum;
		}
	}
	
	private void addStudent() {
		String name = inputString("이름");
		int code = rCode();
		Student student = new Student(name, code);
		
		group.add(student);
		System.out.println("학생추가 완료");
	}
	
	private int findStudentIdx(int code) {
		int idx = -1;
		
		for(int i=0; i<group.size(); i++) {
			Student student = group.get(i);
			
			if(student.getCode() == code) 
				return i;
		}
		
		return idx;
	}
	
	private int findSubjectIdx(int Subcode) {
		int idx = -1;
		
		for(int i=0; i<group.size(); i++) {
			Subject sub = subject.get(i);
			
			if(sub.getSubCode() == Subcode) 
				return i;
		}
		
		return idx;
	}
	
	private void deleteStudent() {
		printAllStudent();
		int idx = findCodeByIndex();
		
		if(idx == -1) {
			System.err.println("없는 학생입니다.");
			return;
		}
		
		group.remove(idx);
	}
	
	private void inquriyStudent() {
		printAllStudent();
		int idx = findCodeByIndex();
		
		if(idx == -1) {
			System.err.println("없는 학생입니다.");
			return;
		}
		
		group.get(idx);
	}
	
	private void studentSubMenu() {
		System.out.println("1.학생등록");
		System.out.println("2.학생제적");
		System.out.println("3.학생조회(학번)");
	}
	
	private void selectStudent() {
		int sel = inputNumber("메뉴");
	
		if(sel == ADD)
			addStudent();
		else if(sel == DELETE)
			deleteStudent();
		else if(sel == INQURIY)
			inquriyStudent();
	}
	
	private void addSubject() {
		String title = inputString("과목명");
		int subCode = rSubCode();
		
		Subject subject = new Subject(title, subCode);
		
		this.subject.add(subject);
	}
	
	private Subject cloneSubject(int index) {
		Subject temp = subject.get(index);
		
		String title = temp.getTitle();
		int subCode = temp.getSubCode();
		
		Subject sub = new Subject(title, subCode);
		
		return sub;
	}
	
	private void appSubject() {
		printAllStudent();
		int idx = findCodeByIndex();
		
		if(idx == -1) {
			System.err.println("없는 학생입니다.");
			return;
		}
		int subCode = inputNumber("과목코드");
		int index =findSubjectIdx(subCode);
		
		if(index == -1) {
			System.err.println("과목코드 오류");
			return;
		}
		
		Subject sub = cloneSubject(index);
		group.get(idx).setSubject(sub);
		
		System.out.println("과목신청완료");
	}
	
	private void cancleSubject() {
		printAllStudent();
		int idx = findCodeByIndex();
		
		if(idx == -1) {
			System.err.println("없는 학생입니다.");
			return;
		}
		
		int subCode = inputNumber("과목코드");
		
		if(!group.get(idx).findSubjectBySubCode(subCode))
			System.err.println("과목코드 오류");
		else
			System.out.println("수강취소 완료");
	}
	
	private void subjectSubMenu() {
		System.out.println("1.과목등록");
		System.out.println("2.수강신청");
		System.out.println("3.수강철회");
	}
	
	private void selectSubject() {
		int sel = inputNumber("메뉴");
		
		if(sel == ADD_SUBJECT) {
			addSubject();
		}else if(sel == APP_SUBJECT) {
			appSubject();
		}else if(sel == CANCLE_SUBJECT) {
			cancleSubject();
		}
			
		
	}
	
	private void score() {
		int idx = findCodeByIndex();
		
		if(idx == -1) {
			System.err.println("없는 학생입니다.");
			return;
		}
		
		int subCode = inputNumber("과목코드");
		int score = inputNumber("점수");
		
		if(score <0) {
			System.err.println("유효하지 않은 점수");
			return;
		}
		
		group.get(idx).setScore(subCode, score);
	}
	
	private void sortCode() {
		for(int i=0; i<group.size(); i++) {
			Student student = group.get(i);
			int idx = i;
			
			for(int j=i; j<group.size(); j++) {
				if(student.getCode() < group.get(j).getCode()) {
					student = group.get(j);
					idx = j;
				}
			}
			
			Student temp = group.get(i);
			
			group.set(i, student);
			group.set(idx, temp);
			
		}
		
	}
	
	private void sortName() {
		for(int i=0; i<group.size(); i++) {
			Student student = group.get(i);
			int idx = i;
			
			for(int j=i; j<group.size(); j++) {
				if(student.getName().compareTo(group.get(j).getName()) > 0) {
					student = group.get(j);
					idx = j;
				}
			}
			
			Student temp = group.get(i);
			
			group.set(i, student);
			group.set(idx, temp);
			
		}
	}
	
	private void sortScore() {
		for(int i=0; i<group.size(); i++) {
			Student student = group.get(i);
			int idx = i;
			
			for(int j=i; j<group.size(); j++) {
				if(student.getTotalScore() > group.get(j).getTotalScore()) {
					student = group.get(j);
					idx = j;
				}
			}
			
			Student temp = group.get(i);
			
			group.set(i, student);
			group.set(idx, temp);
			
		}
	}
	
	private void sortSubMenu() {
		System.out.println("1.학번(오름차순)");
		System.out.println("2.이름(오름차순)");
		System.out.println("3.성적(내림차순)");
	}

	private void selectSort() {
		int sel = inputNumber("메뉴");
		
		if(sel == SORT_CODE)
			sortCode();
		else if(sel == SORT_NAME)
			sortName();
		else if(sel == SORT_SCORE)
			sortScore();
		
	}
	
	private void saveSubMenu() {
		System.out.println("1.저장");
		System.out.println("2.불러오기");
	}
	
	private void printMenu() {
		System.out.println("1.학생");
		System.out.println("2.과목");
		System.out.println("3.점수");
		System.out.println("4.정렬");
		System.out.println("5.전체출력");
		System.out.println("5.저장");
	}
	
	private void selectMenu() {
		int sel = inputNumber("메뉴");
		
		if(sel == STUDENT) {
			studentSubMenu();
			selectStudent();
		}else if(sel == SUBJECT) {
			subjectSubMenu();
			selectSubject();
		}else if(sel == SCORE) {
			score();
		}else if(sel == SORT) {
			sortSubMenu();
			selectSort();
		}else if(sel == SAVE) {
			saveSubMenu();
		}
		
	}
	
	private void managerRun() {
		while(isRun()) {
			printMenu();
			selectMenu();
		}
	}
	
	public void run() {
		managerRun();
	}
	
}
public class Ex02 {
	public static void main(String[] args) {
		Manager system = new Manager();
		system.run();
	}
	
	// 1. 학생
	//    ㄴ 등록 			[O]
	//    ㄴ 제적 			[O]
	//    ㄴ 조회(학번)		[O]
	// 2. 과목 
	//    ㄴ 등록 			[O]
	//    ㄴ 신청(수강)		[O]
	//    ㄴ 철회(수강) 		[O]
	// 3. 성적 
	//    ㄴ 수정(수강과목) 	[O]
	// 4. 정렬 
	//    ㄴ 학번(오름차순) 	[O]
	//    ㄴ 이름(오름차순)		[O]
	//    ㄴ 성적(내림차순) 	[O]
	// 5. 파일 
	//    ㄴ 저장 			[X]
	//    ㄴ 로드 			[X]
}
