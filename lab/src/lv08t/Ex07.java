package lv08t;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Subject{
	private int code;
	private String title;
	private int score;
	
	public Subject(int code, String title) {
		this.code = code;
		this.title =title;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public Subject clone() {
		Subject subject = new Subject(this.code, this.title);
		subject.setScore(this.score);
		
		return subject;
	}
}

class Student{
	private int code;
	private String name;
	private ArrayList<Subject> subjects;
	
	public Student(int code, String name) {
		this.code = code;
		this.name = name;
		
		subjects = new ArrayList<Subject>();
	}
	
	public int getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public double getScoreAverage() {
		double average = 0;
		
		double total = 0;
		for(Subject subject : subjects) 
			total += subject.getScore();
		
		average = total / subjects.size();
		
		return average;
	}
	
	public int getSubjectsSize() {
		return this.subjects.size();
	}
	
	public boolean hasSubject(int code) {
		for(Subject subject : subjects)
			if(subject.getCode() == code)
				return true;
		
		return false; 
	}
	
	public void addSubject(Subject subject) {
		subjects.add(subject);
	}
	
	public void printSubjectAll() {
		for(int i=0; i<subjects.size(); i++) {
			Subject subject = subjects.get(i);
			System.out.printf("%d) %s", i+1, subject.getTitle());
		}
	}
	
	//수강 과목에 대한 추가 또는 삭제, 수정
	//CRUD
	// R.
	public Subject getSubject(int index) {
		Subject subject = subjects.get(index);
		return subject.clone();
	}
	
	// U.
	public void setSubject(int index, Subject subject) {
		Subject temp = subjects.get(index);
		
		if(temp.getCode() == subject.getCode()) {
			temp.setScore(subject.getScore());
		}
	}
	
	// D.
	public void removeSubject(int index) {
		if(index <0 || index >= subjects.size()) {
			System.err.println("유효하지 않은 범위입니다.");
			return;
		}
		
		subjects.remove(index);
	}
	
	@Override
	public String toString() {
		String info = String.format("%s(%d) \n", this.name, this.code);
				
		for(Subject subject : subjects) {
			info += "\n";
			info += subject.getTitle() + " : " + subject.getScore();
		}
				
		return info;
	}
	
}

class Manager{

	private final int STUDENT = 1;
	private final int SUBJECT = 2;
	private final int SCORE = 3;
	private final int SORT = 4;
	private final int FILE = 5;
	
	private final int STUDENT_JOIN = 1;
	private final int STUDENT_LEAVE = 2;
	private final int STUDENT_SEARCH = 3;
	
	private final int SUBJECT_ENROLL = 1;
	private final int SUBJECT_SELECT = 2;
	private final int SUBJECT_CANCLE = 3;

	private final int SOCRE_UPDATE = 1;
	
	private final int SORT_CODE = 1;
	private final int SORT_NAME = 2;
	private final int SORT_SCORE = 3;
	
	private final int FILE_SAVE = 1;
	private final int FILE_LOAD = 2;
	
	private FileWriter fileWriter;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	
	private File file;
	private String fileName;
	
	private Scanner sc = new Scanner(System.in);
	
	private ArrayList<Student> group;
	private ArrayList<Subject> subjects;
	
	public Manager() {
		this.group = new ArrayList<Student>();
		this.subjects = new ArrayList<Subject>();
		
		this.fileName = "lms.txt";
		this.file = new File(fileName);
	}
	
	public void run() {
		while(true) {
			showMenu();
			int select = inputNumber("menu");
			runMenu(select);
		}
		
		// 1. 학생
		//    ㄴ 등록
		//    ㄴ 제적
		//    ㄴ 조회
		// 2. 과목
		//    ㄴ 등록
		//    ㄴ 신청(수강)
		//    ㄴ 철회(수강)
		// 3. 성적
		//    ㄴ 수정(수강과목)
		// 4. 정렬
		//    ㄴ 학번(오름차순)
		//    ㄴ 이름(오름차순)
		//    ㄴ 성적(내림차순)
		// 5. 파일
		//    ㄴ 저장
		//    ㄴ 로드
		
	}
	
	public void runMenu(int select) {
		switch (select) {
		case(STUDENT) :
			showStudentSubMenu();
			runStudentSubMenu(option());
			break;
		case(SUBJECT) :
			showSubjectSubMenu();			
			runSubjectSubMenu(option());
			break;
		case(SCORE) :
			showScoreSubMenu();			
			runScoreSubMenu(option());
			break;
		case(SORT) :
			showSortSubMenu();			
			runSortSubMenu(option());
			break;
		case(FILE) :
			showFileSubMenu();			
			runFileSubMenu(option());
			break;
		}
	}
	public void runStudentSubMenu(int option) {
		if(option == STUDENT_JOIN)
			joinStudent();
		else if(option == STUDENT_LEAVE)
			leaveStudent();
		else if(option == STUDENT_SEARCH)
			searchStudent();
	}
	
	public void runSubjectSubMenu(int option) {
		if(option == SUBJECT_ENROLL)
			enrollSubject();
		else if(option ==SUBJECT_SELECT)
			selectSubject();
		else if(option ==SUBJECT_CANCLE)
			cancelSubject();
	}
	
	public void runScoreSubMenu(int option) {
		if(option == SOCRE_UPDATE)
			updataScore();
	}
	
	public void runSortSubMenu(int option) {
		if(option == SORT_CODE)
			sortByStudentCode();
		else if(option ==SORT_NAME)
			sortByStudentName();
		else if(option ==SORT_SCORE)
			sortByStudentScore();
	}
	
	
	public void runFileSubMenu(int option) {
		if(option == FILE_SAVE)
			saveData();
		else if(option == FILE_LOAD)
			loadData();
	}
	
	public void joinStudent() {
		int code = createRandomStudentCode();
		String name = inputString("name");
		
		Student student = new Student(code, name);
		
		group.add(student);
		System.out.println("학생 등록 완료");
	}
	
	public int createRandomStudentCode() {
		int code = 0;
		Random random = new Random();
		
		while(true) {
			code = random.nextInt(9000) + 1000;
			
			boolean isDupl = false;
//			for(int i=0; i<group.size(); i++) {
//				Student student = group.get(i);
			
			// 향상된 for문
			for(Student student : group) {
				if(student.getCode() == code)
					isDupl = true;
			}
			
			if(!isDupl)
				break;
		}
		return code;
	}
	
	public int createRandomSubjectCode() {
		int code = 0;
		Random random = new Random();
		
		while(true) {
			code = random.nextInt(9000) + 1000;
			
			boolean isDupl = false;
			for(Subject subject : subjects) {
				if(subject.getCode() == code)
					isDupl = true;
			}
			
			if(!isDupl)
				break;
		}
		
		return code;
	}
	
	public void leaveStudent() {
		int code = inputNumber("제적할 학번");
		
		Student student = searchStudent(code);
		group.remove(student);
		
		System.out.println("학생 제적 완료");
	}
	
	public void searchStudent() {
		int code = inputNumber("제적할 학번");
		
		Student student = searchStudent(code);
		System.out.println(student);
	}
	
	public Student searchStudent(int code) {
		Student student = null;
		
		for(Student target : group) {
			if(target.getCode() == code)
				student = target;
		}
		
		return student;
	}
	
	public void enrollSubject() {
		int code = createRandomSubjectCode();
		String title = inputString("title");
		
		Subject subject = new Subject(code, title);
		subjects.add(subject);
		
		System.out.println("신규과목 등록 완료");
	}
	
	public void selectSubject() {
		int code = inputNumber("학번");
		Student student = searchStudent(code);
		
		if(student == null) {
			System.err.println("학번 정보를 다시 확인하세요.");
			return;
		}
		
		printSubjectAll();
		int index = inputNumber("선택")-1;
		
		Subject subject = subjects.get(index);
		int subjectCode = subject.getCode();
		
		if(student.hasSubject(subjectCode)) {
			System.err.println("이미 수강중인 과목입니다.");
			return;
		}
		
		student.addSubject(subject);
		System.out.println("수강 신청 완료");
	}
	
	public void printSubjectAll() {
		for(int i=0; i<subjects.size(); i++	) {
			Subject subject = subjects.get(i);
			System.out.printf("%d} %s \n ", i+1, subject.getTitle());
		}
	}
	
	public void cancelSubject() {
		int code = inputNumber("학번");
		Student student = searchStudent(code);
		
		if(student == null) {
			System.err.println("학번 정보를 다시 확인하세요");
			return;
		}
		
		student.printSubjectAll();
		int index = inputNumber("선택") -1;
		
		student.removeSubject(index);
		System.out.println("수강 철회 완료");
	}
	
	public void sortByStudentCode() {
		for(int i=0; i<group.size(); i++) {
			Student student = group.get(i);
			int first = i;
			
			for(int j=i; j<group.size(); j++) {
				Student target = group.get(i);
				
				if(student.getCode() > target.getCode()) {
					student = target;
					first = j;
				}
			}
			
			if(first != i) {
				group.set(first, group.get(i));
				group.set(i, student);
			}
		}
	}
	
	public void sortByStudentName() {
		for(int i=0; i<group.size(); i++) {
			Student student = group.get(i);
			int first = i;
			
			for(int j=i; j<group.size(); j++) {
				Student target = group.get(i);
				
				if(student.getName().compareTo(target.getName()) > 0) {
					student = target;
					first = j;
				}
			}
			
			if(first != i) {
				group.set(first, group.get(i));
				group.set(i, student);
			}
		}
	}
	
	public void sortByStudentScore() {
		for(int i=0; i<group.size(); i++) {
			Student student = group.get(i);
			int first = i;
			
			for(int j=i; j<group.size(); j++) {
				Student target = group.get(i);
				
				if(student.getScoreAverage() > target.getScoreAverage()) {
					student = target;
					first = j;
				}
			}
			
			if(first != i) {
				group.set(first, group.get(i));
				group.set(i, student);
			}
		}
	}
	
	public void saveData() {
		String data = createDataString();
		
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write(data);
			fileWriter.close();
			
			System.out.println("저장 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("저장 실패");
		}
	}
	
	private String createDataString() {
		/*
		 * 과목코드1,과목명1/과목코드2,과목명2/과목코드3,과목명3/....
		 * 학번1/이름1
		 * 학번2/이름/과목코드1,성적1
		 * 학번3/이름/과목코드1,성적1/과목코드2,성적2
		 */
		
		String data = "";
		
		
		// subjects
		if(subjects.size() > 0) {
			for(Subject subject : subjects) {
				data += subject.getCode() + "," + subject.getTitle();
				data += "/";
			}			
			data = data.substring(0, data.length() -1);
		}
		
		
		
		// group
		for(Student student : group) {
			data += "\n" + student.getCode() + "/" + student.getName();
			
			for(int j=0; j<student.getSubjectsSize(); j++) {
				Subject subject = student.getSubject(j);
				
				data += "/" + subject.getCode() + "," + subject.getScore();
			}
		}
		
		return data;
	}
	
	public void loadData() {
		if(file.exists()) {
			String data = "";
			try {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				
				while(bufferedReader.ready()) {
					data += bufferedReader.readLine() + "\n";
				}
				
				bufferedReader.close();
				fileReader.close();
				
				parseLoadedData(data);
			} catch (Exception e) {
			}
		}
	}
	
	private void parseLoadedData(String data) {
		group.clear();
		subjects.clear();
		
		String[] lines =data.split("\n");
		
		// subjects
		String[] subjects = lines[0].split("/");
		for(int i=0; i<subjects.length; i++) {
			String[] info = subjects[i].split(","); 
			int code = Integer.parseInt(info[0]);
			String title = info[1];
			
			Subject subject = new Subject(code, title);
			this.subjects.add(subject);
		}
		
		// group
		for(int i=1; i<lines.length; i++) {
			String[] info = lines[i].split("/");
			
			int code = Integer.parseInt(info[0]);
			String name = info[1];
			
			Student student = new Student(code, name);
			
			for(int j=2; j<info.length; j++) {
				String[] subinfo = info[j].split(",");
				
				int subCode = Integer.parseInt(subinfo[0]);
				int subScore = Integer.parseInt(subinfo[1]);
				
				Subject subject = searchSubject(subCode);
				
				if(subject != null) {
					subject.setScore(subScore);
					student.addSubject(subject.clone());
				}
			}
			
			this.group.add(student);
		}
	}
	
	
	private Subject searchSubject(int code) {
		for(Subject subject : subjects	) {
			if(subject.getCode() == code)
				return subject;
		}
		
		return null;
	}
	
	public void showMenu() {
		System.out.println("1. 학생");
		System.out.println("2. 과목");
		System.out.println("3. 성적");
		System.out.println("4. 정렬");
		System.out.println("5. 파일");
	}
	
	public void showStudentSubMenu() {
		System.out.println("1) 등록");
		System.out.println("2) 제적");
		System.out.println("3) 조회(학번)");
	}
	
	public void showSubjectSubMenu() {
		System.out.println("1) 등록");
		System.out.println("2) 신청(수강");
		System.out.println("3) 철회(수강)");		
	}
	
	public void showScoreSubMenu() {
		System.out.println("1) 수정(수강과목)");
	}

	public void showSortSubMenu() {
		System.out.println("1) 학번(오름차순)");
		System.out.println("2) 이름(오름차순)");
		System.out.println("3) 성적(내림차순)");
	}
	
	public void showFileSubMenu() {
		System.out.println("1) 저장");
		System.out.println("2) 로드");
	}
	
	public int option() {
		return inputNumber("번호선택");
	}
	
	public int inputNumber(String message) {
		int number =0;
				
		System.out.print(message + " : ");
		try {
			String input =sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return number;
	}
	
	public String inputString(String message) {
		System.out.print(message + " : ");
		return sc.next();
	}
	
	public void updataScore() {
		int code = inputNumber("학번");
		Student student = searchStudent(code);
		
		if(student == null) {
			System.err.println("학번 정보를 다시 확인하세요.");
			return;
		}
		
		student.printSubjectAll();
		int index = inputNumber("선택") -1;
		int score = inputNumber("성적");
		
		Subject subject = student.getSubject(index);
		subject.setScore(score);
		
		student.setSubject(index, subject);
		System.out.println("성적 수정 완료");
		
	}
}

public class Ex07 {

	public static void main(String[] args) {
		
		Manager system = new Manager();
		system.run();

	}

}
