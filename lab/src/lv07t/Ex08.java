package lv07t;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

// 1.추가
// 		1-1. 학생 (랜덤 4자리 학번 부여) [O]
// 		1-2. 과목 (수강 신청)			 	
//		1-2-2. (과목등록) 옵션
// 		1-3. 성적 
// 2.삭제
// 		2-1. 학생
// 		2-2. 과목 (수강 취소) 
// 		2-3. 성적 
// 3.정력
// 		3-1. 학번순
// 		3-2. 이름순
// 		3-3. 성적순 (평균)
// 4.출력
// 		4-1. 학생 + 성적
// 5.저장
// 6.로드
class Subject{
	private String title;
	private int score;
	
	public Subject(String title) {
		this.title = title;
	}

	public Subject(String title, int score) {
		this.title = title;
		this.score =score;
	}
	
	public String getTitle() {
		return this.title;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public Subject clone() {
		return new Subject(this.title);
	}

	@Override
	public String toString() {
		return this.title;
	}
}

class Student{
	private int code;
	private String name;
	
	private int subjectCnt;
	private Subject[] subjects;  // 수강 신청한 과목들
	
	public Student(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}

	public int getSubjectCnt() {
		return this.subjectCnt;
	}

	public Subject[] getSubjects() {
		return this.subjects != null ?
				subjects.clone() : null;
	}
	
	public Subject getSubjectByIndex(int index) {
		Subject subject = null;
		
		try {
			subject = subjects[index];
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return subject;
	}
	
	public double getScoreAverage() {
		double average = 0;
		
		double total = 0;
		for(int i=0; i<subjectCnt; i++)
			total += subjects[i].getScore();
		
		if(total != 0)
			average = total /subjectCnt;
		
		return average;
	}
	
	public void setSubject(Subject[] subjects) {
		this.subjects = subjects;
		
		this.subjectCnt = subjects == null ? 0 :subjects.length;
	}
	
	public int indexOfSubject(String title) {
		int index = -1;
		
		for(int i=0; i<subjectCnt; i++)
			if(subjects[i].getTitle().equals(title))
				index = i;
		
		return index;
	}
	
	@Override
	public String toString() {
		// 학생학번(이름)
		// ㄴ 과목명1 : 00점
		// ㄴ 과목명2 : 00 점
		String info = String.format("%s (%d\n)", code, name);
		
		for(int i=0; i<subjectCnt; i++) {
			Subject subject = subjects[i];
			info += String.format("%s : %3d점\n", subject.getTitle(),subject.getScore());
		}
		
		return info;
	}
	
}

class Lms{
	
	private Scanner scanner = new Scanner(System.in);
	
	private final int ADD = 1;
	private final int DELETE = 2;
	private final int SORT = 3;
	private final int PRINT = 4;
	private final int SAVE = 5;
	private final int LOAD = 6;
	private final int EXIT = 7;
	
	private final int ADD_STUDENT = 1;
	private final int ADD_SUBJECT = 2;
	private final int ADD_SCORE = 3;
	
	private final int ADD_SUBJECT_ENROLL = 1;
	private final int ADD_SUBJECT_OPEN = 2;
	
	private final int DELETE_STUDENT = 1;
	private final int DELETE_SUBJECT = 2;
	
	private final int SORT_BY_CODE = 1;
	private final int SORT_BY_NAME = 2;
	private final int SORT_BY_SCORE = 3;
	
	private FileWriter fileWriter;
	private FileReader fileReader;
	private BufferedReader bufferdReader;
	private File file;
	private String fileName;
	
	private Student[] students;
	private int studentCount;
	
	private Subject[] subjects; // 수강신청용
	private int subjectCount;
	
	private boolean isRun;
	
	public Lms() {
		fileName = "lms.txt";
		file = new File(fileName);
		
		isRun = true;
		setSubjects();
	}
	
	private void setSubjects() {
		subjectCount = 3;
		subjects = new Subject[subjectCount];
		
		subjects[0] = new Subject("수학");
		subjects[1] = new Subject("영어");
		subjects[2] = new Subject("국어");
	}
	
	private void setSubjects(String[] list) {
		int size = list == null ? 0 : list.length;
		
		if(size > 0) {
			
			subjects = new Subject[size];
			
			for(int i=0; i<subjects.length; i++)
				subjects[i] = new Subject(list[i]);
			
			subjectCount = subjects.length;
		}
	}
	
	private boolean isRun() {
		return isRun;
	}
	
	private void printMenu() {
		System.out.println("1. 추가");
		System.out.println("2. 삭제");
		System.out.println("3. 정렬");
		System.out.println("4. 출력");
		System.out.println("5. 저장");
		System.out.println("6. 로드");
		System.out.println("0. 종료");
	}
	
	private int inputNumber(String message) {
		int number = -1;
		
		System.out.print(message + " : ");
		try {
			String input = scanner.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return number;
	}
	
	private void printAddSubMenu() {
		System.out.println("1) 학생");
		System.out.println("2) 과목");
		System.out.println("3) 성적");
	}
	
	private void addStudent() {
		// 고유한 식별자 학번
		// 사용자에게 이름을 받고(동명이인 허용)
		// Student 객체를 생성
		int code = createStudentCode();
		String name = inputString("name");
		
		Student student = new Student(code, name);
		
		Student[] temp = students;
		students = new Student[studentCount+1];
		
		for(int i=0; i<studentCount; i++) {
			students[i] = temp[i];
		}
		
		students[studentCount++] = student;
		
		System.out.printf("학생(%d) 등록 완료 \n", student.getCode());
	}
	
	private void addStudent(Student student) {
		Student[] temp = students;
		students = new Student[studentCount+1];
		
		for(int i=0; i<studentCount; i++) {
			students[i] = temp[i];
		}
		
		students[studentCount++] = student;
	}
	
	private int createStudentCode() {
		int code;
		
		Random random = new Random();
		
		while(true) {
			code = random.nextInt(9000)+1000;
			
			int index = indexOfStudent(code);
			
			if(index == -1)
				break;
		}	
		return code;
	}
	
	private int indexOfStudent(int code) {
		int index = -1;
		
		for(int i=0; i<studentCount; i++) {
			Student student = students[i];
			if(student.getCode() == code)
				index = i;
		}
		
		if(index == -1) {
			System.err.println("존재하지 않는 학생");
		}
		return index;
	}
	
	private Student searchStudent() {
		Student student = null;
		
		int studentCode = inputNumber("학번");
		int index = indexOfStudent(studentCode);
		
		if(index != -1)
			student = students[index];
		
		return student;
	}
	
	private int printAddSubjectOption() {
		int option = 0;
		
		System.out.println("1) 수강신청");
		System.out.println("2) 과목개설");
		option = inputNumber("option");
		
		return option;
	}
	
	private void enrollSubject() {
		
		Student student = searchStudent();
		
		if(student != null) {
			printSubjectAll();
			int subjectIndex = inputNumber("과목 번호");
			
			if(subjectIndex < 0 || subjectIndex >= subjectCount) {
				System.err.println("유효하지 않은 번호입니다.");
				return;
			}
			
			Subject subject = subjects[subjectIndex];
			
			if(student.indexOfSubject(subject.getTitle()) != -1) {
				System.err.println("이미 신청한 과목입니다.");
				return;
			}
			
			enrollSubjectForStudent(student, subject.clone());
			
		}
				
		
	}
		private void  enrollSubjectForStudent(Student student, Subject subject) {
		
		Subject[] temp = student.getSubjects();
		
		int size = student.getSubjectCnt();
		Subject[] list = new Subject[size + 1];
		
		for(int i=0; i<size; i++)
			list[i] = temp[i];
		
		student.setSubject(list);
		
		System.out.println("수강신청 완료");
		
	}
	
	
	
	private void openSubject() {
		String title = inputString("개설할 과목");
		
		if(indexofSubject(title) != -1) {
			System.err.println("동일 과목명이 이미 존재합니다.");
			return;
		}
		
		Subject[] temp = subjects;
		subjects = new Subject[subjectCount + 1];
		
		for(int i=0; i<subjectCount; i++)
			subjects[i] = temp[i];
		
		subjects[subjectCount ++] = new Subject(title);
		
		System.out.println("과목 개설 완료");
		
	}
	
	private int indexofSubject(String title) {
		int index = -1;
		
		for(int i=0; i<subjectCount; i++)
			if(subjects[i].getTitle().equals(title))
				index = i;
		
		
		return index;
	}
	
	private void addSubject() {
		int option = printAddSubjectOption();
		
		if(option == ADD_SUBJECT_ENROLL)
			enrollSubject();
		else if(option == ADD_SUBJECT_OPEN)
			openSubject();
	}
	
	private void addScore() {
		Student student = searchStudent();
		
		if(student != null) {
			System.out.println(student);
			String title = inputString("과목명");
			
			int subjectIndex = student.indexOfSubject(title);
			
			if(subjectIndex == -1) {
				System.err.println("수강신청한 과목이 아닙니다");
				return;
			}
			
			Subject subject = student.getSubjectByIndex(subjectIndex);
			int score = inputNumber("성적");
			
			if(score < 0 || score > 100) {
				System.out.println("유효하지 않은 성적 범위입니다.");
				return;
			}
			
			subject.setScore(score);
			System.out.println("성적 입력 완료");
		}
		
	}
	
	private void runAddSubMenu(int select) {
		if(select == ADD_STUDENT) {
			addStudent();
		}else if(select == ADD_SUBJECT) {
			addSubject();
		}else if(select == ADD_SCORE) {
			addScore();
		}
	}
	
	private void printSubjectAll() {
		for(int i=0; i<subjectCount; i++) {
			System.out.print(i + 1 + ") ");
			System.out.println(subjects[i]);
		}
	}
	
	private void printStudentAll() {
	      for (int i = 0; i < studentCount; i++)
	         System.out.println(students[i]);
	}
	
	private void printDeleteSubMenu() {
		System.out.println("1)학생");
		System.out.println("2)과목");
	}
	
	private void deleteStudent() {
		Student student = searchStudent();
		
		if(student != null) {
			Student[] temp = students;
			students = new Student[studentCount-1];
			
			int index = 0;
			for(int i=0; i<studentCount; i++) {
				if(temp[i] != student)
					students[index ++] = temp[i];
			}
			studentCount--;
			System.out.println("학생 삭제 완료");
		}
	}
	private void runDeleteSubMenu(int select) {
        if (select == DELETE_STUDENT)
            deleteStudent();
        else if (select == DELETE_SUBJECT)
            deleteSubject();
    }
	private void deleteSubject() {
		Student student =searchStudent();
		
		if(student != null) {
			System.out.println(student);
			String title = inputString("과목명");
			
			int subjectIndex = student.indexOfSubject(title);
			
			if(subjectIndex == -1)
				System.out.println("수강신청한 과목이 아닙니다.");
			
			Subject[] temp = student.getSubjects();
			int size = student.getSubjectCnt();
			
			Subject[] list = new Subject[size -1];
			int index = 0;
			for(int i=0; i<size; i++) {
				if(i != subjectIndex)
					list[index ++] = temp[i];
			}
			student.setSubject(list);
			
			
			System.out.println("수강철회 완료");
		}
	}
	
	private void printSortSubMenu() {
		System.out.println("1) 학번순 (오른차순)");
		System.out.println("2) 이름순 (오른차순)");
		System.out.println("3) 성적순 (내림차순)");
	}
	
	private void sortByCode() {
		for(int i=0; i<studentCount; i++) {
			Student student = students[i];
			int index = i;
			
			for(int j=i; j<studentCount; j++) {
				Student target = students[j];
				
				if(student.getCode() > target.getCode()) {
					student = target;
					index = j;
				}
			}
			
			if(index != i) {
				students[index] = students[i];
				students[i] = student;
			}
		}
	}
	
	private void sortByName() {
		for(int i=0; i<studentCount; i++) {
			Student student = students[i];
			int index = i;
			
			for(int j=i; j<studentCount; j++) {
				Student target = students[j];
				
				if(student.getName().compareTo(target.getName()) > 0) {
					student = target;
					index = j;
				}
			}
			
			if(index != i) {
				students[index] = students[i];
				students[i] = student;
			}
		}
	}
	
	private void sortByScore() {
		for(int i=0; i<studentCount; i++) {
			Student student = students[i];
			int index = i;
			
			for(int j=i; j<studentCount; j++) {
				Student target = students[j];
				
				if(student.getScoreAverage() < target.getScoreAverage()) {
					student = target;
					index = j;
				}
			}
			
			if(index != i) {
				students[index] = students[i];
				students[i] = student;
			}
		}
	}
	
	private void runSortSubMenu(int select) {
		if(select == SORT_BY_CODE)
			sortByCode();
		else if(select == SORT_BY_NAME)
			sortByName();
		else if(select == SORT_BY_SCORE)
			sortByScore();
	}
	
	private void saveData() {
		/*
		 * 수학/영어/국어/자바/데이터베이스...
		 * 학번1/이름1/과목1성적1/과목2/성적2
		 * 학번2/이름2/과목1성적1
		 * 학번3/이름3
		 */
		
		String data = createDataString();
		
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write(data);
			fileWriter.close();
			
			System.out.println("파일 저장 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("파일 저장 실패");
		}
	}
	
	private String createDataString() {
		String data = "";
		
		for(int i=0; i<subjectCount; i++) {
			data += subjects[i].getTitle();
			
			if(i < subjectCount - 1)
				data+= "/";
		}
		data += "\n";
		
		for(int i=0; i<studentCount; i++) {
			Student student = students[i];
			
			data+= student.getCode() + "/" + student.getName();
			
			if(student.getSubjectCnt() > 0)
				data += "/";
			
			for(int j=0; j<student.getSubjectCnt(); j++) {
				Subject subject = student.getSubjectByIndex(j);
				
				data += subject.getTitle() + "/" + subject.getScore();
				
				if(j < student.getSubjectCnt() -1)
					data += "/";
			}
			
			if(i < studentCount-1)
				data+= "\n";
		}
		
		return data;
	}
	
	private void loadDataStudents(FileReader fileReader, BufferedReader bufferedReader) {
		try {
			while(bufferedReader.ready()) {
				String[] data = bufferedReader.readLine().split("/");
				
				int code = Integer.parseInt(data[0]);
				String name = data[1];
				Student student = new Student(code, name);
				
				// 수강신청 내역이 존재함
				if(data.length > 2) {
					int size = (data.length-2)/2;
					
					Subject[] subjects = new Subject[size];
					
					int index = 2;
					for(int i=0; i<size; i++) {
						String title = data[index++];
						int score = Integer.parseInt(data[index++]);
						subjects[i] = new Subject(title, score);
					}
					
					student.setSubject(subjects);
				}
				
				addStudent(student);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadData() {
		if(file.exists()) {
			try {
				fileReader = new FileReader(file);
				bufferdReader = new BufferedReader(fileReader);
				
				String[] subjectList = bufferdReader.readLine().split("/");
				setSubjects(subjectList);
				
				loadDataStudents(fileReader, bufferdReader);
				
				
				bufferdReader.close();
				fileReader.close();
				
				System.out.println("파일로드 성공");
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("파일로드 실패");
			}
		}else {
			System.err.println("파일이 존재하지 않습니다.");
		}
	}
	
	private void runMenu(int select) {
		if(select == ADD) {
			printAddSubMenu();
			runAddSubMenu(inputNumber(""));
		}
		else if(select == DELETE) {
			printDeleteSubMenu();
			runDeleteSubMenu(inputNumber(""));
		}
		else if(select == SORT) {
			printSortSubMenu();
			runSortSubMenu(inputNumber(""));			
		}
		else if(select == PRINT) {
			printStudentAll();		
		}else if(select == SAVE) {
			saveData();
		}else if(select == LOAD) {
			loadData();
		}else if(select == EXIT) {
			isRun = false;
		}
	}
	
	private String inputString(String message) {
		System.out.print("입력: ");
		return scanner.next();
	}
	
	public void run() {
		while(isRun()) {
			printMenu();
			int select = inputNumber("menu");
			runMenu(select);
		}
	}
}


public class Ex08 {
	public static void main(String[] args) {
		Lms system = new Lms();
		system.run();
	}

}
