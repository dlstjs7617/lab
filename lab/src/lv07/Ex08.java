package lv07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


// 1.추가
// 		1-1. 학생 (랜덤 4자리 학번 부여)
// 		1-2. 과목  (수강 신청)
// 		1-2-2. (과목등록)
// 		1-3. 성적
// 2.삭제
// 		2-1. 학생
// 		2-2. 과목 (수강 취소)
// 3.정렬
// 		3-1. 학번순
// 		3-2. 이름순
// 		3-3. 성적순 (평균) 
// 4.출력
// 		4-1. 학생 + 성적
// 5.저장
// 6.로드

class Subject{
	
	private String name;
	private int score;

	public Subject(String name){
		this.name = name;
	}

	public Subject(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	private void setScore(int score) {
		this.score = score;
	}
	
	public void scoreMethod(int socre) {
		setScore(socre);
	}
	
	@Override
	public String toString() {
		String text = "과목 : " + name;
		return text;
	}
	
	
}

class Student{
	
	private String name;
	private int studentId;
	private Subject[] subjects;
	private int size;
	private double dvg;
	private int loadCnt;
	public Student(String name, int studentId){
		this.name = name;
		this.studentId = studentId;
		this.size = 0;
	}

	public Student(String name, int studentId, int size){
		this.name = name;
		this.studentId = studentId;
		this.size = size;
	}

	public String getName() {
		return name;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public int getSize() {
		return size;
	}
	
	
	public void addScore(String subject,int score) {
		int idx = findSubject(subject);
		subjects[idx].scoreMethod(score);
	}
	
	public int findSubject(String subject) {
		int idx = -1;
		for(int i=0; i<size; i++) {
			if(subjects[i].getName().equals(subject)) {
				idx = i;
			}
		}
		return idx;
	}
	
	public void addSubject(String name) {
		Subject[] subject = subjects;
		subjects = new Subject[size+1];
		
		for(int i=0; i<size; i++) {
			subjects[i] = subject[i];
		}
		
		subjects[size] = new Subject(name);
		
		size++;
	}
	
	public void delSubject(String name) {
		Subject[] subject = subjects;
		subjects = new Subject[size-1];
		
		int cnt = 0;
		for(int i=0; i<size; i++) {
			if(!subject[i].getName().equals(name)) {
				subjects[cnt++] = subject[i];
			}
		}
		
		size--;
	}
	
	public double getDvg() {
		int sum = 0;
		
		for(int i=0; i<size; i++) {
			sum += subjects[i].getScore();
		}
		dvg = (double)sum/size;
		
		return dvg;
	}
	
	public String saveSubject() {
		String info = "";
		for(int i=0; i<size; i++) {
			info += subjects[i].getName() + "/";
			info += subjects[i].getScore();
			if(i != size-1)
				info +="/";
		}
		return info;
	}
	
	public void loadSetSize() {
		subjects = new Subject[size];
		loadCnt = 0;
	}
	
	public void loadSubject(String name, int score) {
		subjects[loadCnt++] = new Subject(name, score);
	}
	
	public void studentSubject() {
		for(int i=0; i<size; i++) {
			System.out.println(subjects[i]);
		}
	}
	
	
	@Override
	public String toString() {
		// 학생학번(이름)
		// ㄴ 과목명1 : 00점
		// ㄴ 과목명2 : 00 점
		String info = String.format("%s (%d)\n", name, studentId);
		
		for(int i=0; i<size; i++) {
			Subject subject = subjects[i];
			info += String.format("%s : (%3d점)\n", subjects[i].getName(),subjects[i].getScore());
		}
		
		return info;
	}
}

class Lms{
	
	private final int ADD = 1;
	private final int DEL = 2;
	private final int SORT = 3;
	private final int PRINT = 4;
	private final int SAVE = 5;
	private final int LOAD = 6;
	
	private int subjectSize;
	private int studentSize;
	
	private Subject[] subjects;
	private Student[] students;
	
	private Scanner sc = new Scanner(System.in);
	private Random ran = new Random();
	
	private File file;
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;
	
	
	private boolean isRun() {
		return true;
	}
	
	private void printMenu() {
		System.out.println("===학생관리 시스템===");
		System.out.println("1.추가");
		System.out.println("2.삭제");
		System.out.println("3.정렬");
		System.out.println("4.출력");
		System.out.println("5.저장");
		System.out.println("6.로드");
	}
	
	private int inputNumber(String message) {
		int number = -1;
		
		System.out.print(message + "입력:");
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println();
		}
		
		return number;
	}
	
	private String inputString(String message) {
		System.out.print(message + "입력 : ");
		return sc.next();
	}
	
	private void selectMenu(int select) {
		if(select == ADD) {
			addMenu();
		}else if(select == DEL) {
			delMenu();
		}else if(select == SORT) {
			sortingMenu();
		}else if(select == PRINT) {
			printScore();
		}else if(select == SAVE) {
			save();
		}else if(select == LOAD) {
			load();
		}else {
			System.err.println("유효하지 않은 메뉴");
		}
		
	}
	
	private void addMenu() {
		System.out.println("1-1. 학생추가");
		System.out.println("1-2. 과목추가");
		System.out.println("1-3. 학생수강신청");
		System.out.println("1-4. 성적설정");
		
		int select = inputNumber("메뉴입력");
		
		if(select == 1) {
			addStudent();	
		}else if(select == 2) {
			addSubject();
		}else if(select == 3 && !subjectExcetion()) {
			addStudentSubject();
		}else if(select == 4 && !subjectExcetion()) {
			addScore();
		}
	}
	
	private boolean subjectExcetion() {
		if(subjectSize == 0) {
			System.err.println("개설된 강의가 없습니다");
			return true;
		}
		return false;
	}
	
	private void addStudent() {
		String name = inputString("학생이름");
		int rId = rId(); 
		Student[] student = students;

		students = new Student[studentSize+1];
		
		for(int i=0; i<studentSize; i++) {
			students[i] = student[i];
		}
		
		students[studentSize] = new Student(name, rId);
		
		studentSize++;
	}
	
	private void addSubject() {
		String name = inputString("과목이름");
		Subject[] subject = subjects;
		
		subjects = new Subject[subjectSize+1];
		
		for(int i=0; i<subjectSize; i++) {
			subjects[i] = subject[i];
		}
		
		subjects[subjectSize] = new Subject(name);
		
		subjectSize++;
	}
	
	private void addStudentSubject() {
		printStudent();
		String name = inputString("학생이름");
		int idx = findNameIdx(name);
		
		if(idx == -1) {
			System.err.println("존재하지 않는 학생입니다.");
			return;
		}
		
		for(int i=0; i<subjectSize; i++) {
			System.out.println(subjects[i]);
		}
		
		String subject = inputString("과목");
		if(findSubjectIdx(subject) == -1) {
			System.err.println("없는 과목입니다");
			return;
		}
		
		students[idx].addSubject(subject);
	}
	
	private void addScore() {
		printStudent();
		String name = inputString("학생이름");
		if(findNameIdx(name) == -1) {
			System.err.println("존재하지 않는 학생입니다.");
			return;
		}
		
		students[findNameIdx(name)].studentSubject();
		studentAddScore(name , findNameIdx(name));
	}
	
	private int findNameIdx(String name) {
		int idx = -1;
		for(int i=0; i<studentSize; i++) {
			if(name.equals(students[i].getName()))
				idx = i;
		}
		return idx;
	}
	
	private void studentAddScore(String name, int idx) {
		String subject = inputString("과목");
		int score = inputNumber("점수");
		
		if(score < 0 || score > 100) {
			System.err.println("유효하지 않은 점수");
			return;
		}
		
		students[idx].addScore(subject, score);
	}
	
	private void printStudent() {
		for(int i=0; i<studentSize; i++) {
			System.out.printf("%d. 이름 : %s(%d) \n", i+1, students[i].getName(), students[i].getStudentId());
		}
	}
	
	private int rId() {
		int id = 0;
		while(true) {
			id = ran.nextInt(8000)+1000;
			boolean find = false;
			
			for(int i=0; i<studentSize; i++) {
				if(id == students[i].getStudentId())
					find = true;
			}
			
			if(!find)
				break;
		}
		
		return id;
	}
	
	private void delMenu() {
		System.out.println("2-1. 학생");
		System.out.println("2-2. 과목");
		
		int select = inputNumber("메뉴입력");
		
		if(select == 1) {
			delStudent();
		}else if(select == 2) {
			delSubject();
		}else if(select == 3) {
			
		}else {
			System.err.println("유효하지 않는 메뉴");
		}
	}
	
	private void delStudent() {
		String name = inputString("이름");
		int idx = findNameIdx(name);
		
		if(findNameIdx(name) == -1) {
			System.err.println("존재하지 않는 학생입니다.");
			return;
		}
		Student[] student = students;

		students = new Student[studentSize - 1];
		int cnt = 0;
		
		for (int i = 0; i < studentSize; i++) {
			if (i != idx) {
				students[cnt++] = student[i];
			}
		}
		studentSize--;
		
	}
	
	private void delSubject() {
		String name = inputString("학생이름");
		
		if(findNameIdx(name) == -1) {
			System.err.println("존재하지 않는 학생입니다.");
			return;
		}
		
		int index = findNameIdx(name);
		
		if(students[index].getSize() == 0) {
			System.err.println("수강중인 강의가없습니다");
			return;
		}
		
		
		System.out.println(students[index]);
		String subject = inputString("과목");
		int idx = findSubjectIdx(subject);
		delSubjectArr(idx,subject);
	}
	
	private int findSubjectIdx(String subject) {
		int idx = -1;
		
		for(int i=0; i<subjectSize; i++	) {
			if(subjects[i].getName().equals(subject))
				idx = i;
		}
		
		return idx;
	}
	
	private void delSubjectArr(int idx,String delsubject) {		
		Subject[] subject = subjects;
		subjects = new Subject[subjectSize-1];
		
		int cnt = 0;
		for(int i=0; i<subjectSize; i++) {
			if(i != idx)
				subjects[cnt++] = subject[i];
		}
		studentAllDelSubject(delsubject);
		subjectSize--;
	}
	
	private void studentAllDelSubject(String subject) {
		for(int i=0; i<studentSize; i++) {
			students[i].delSubject(subject);
		}
	}
	
	private void sortingMenu() {
		System.out.println("3-1. 학번순");
		System.out.println("3-2. 이름순");
		System.out.println("3-3. 성적순");
		
		int select = inputNumber("메뉴입력");
		
		if(select == 1) {
			sortNumber();
		}else if(select == 2) {
			sortName();
		}else if(select == 3) {
			sortScore();
		}
	}
	
	private void sortNumber() {
		Student temp;
		
		for(int i=0; i<studentSize-1; i++) {
			if(students[i].getStudentId() > students[i+1].getStudentId()) {
				temp = students[i];
				students[i] = students[i+1];
				students[i+1] = temp;
				i=-1;
			}
		}
	}
	
	private void sortName() {
		Student temp;
		
		for(int i=0; i<studentSize-1; i++) {
			if(students[i].getName().charAt(0) > students[i+1].getName().charAt(0)) {
				temp = students[i];
				students[i] = students[i+1];
				students[i+1] = temp;
				i=-1;
			}
		}
	}
	
	private void sortScore() {
		Student temp;
		
		for(int i=0; i<studentSize-1; i++) {
			if(students[i].getDvg() < students[i+1].getDvg()) {
				temp = students[i];
				students[i] = students[i+1];
				students[i+1] = temp;
				i=-1;
			}
		}
	}
	
	private void printScore() {
		for(int i=0; i<studentSize; i++) {
			System.out.print(students[i]);
		}
	}
	
	private void save() {
		studentSave();
		subjectSave();
	}
	
	private void studentSave() {
		String fileName = "student.txt";
		String text = studentText();
		file = new File(fileName);
		
		
		try {
			fw = new FileWriter(file);
			
			fw.write(text);
			
			fw.close();
			System.out.println("저장 성공");
		} catch (Exception e) {
			System.err.println("저장 실패");
			e.printStackTrace();
		}
		
	}
	private String studentText() {
		
		String info = studentSize + "\n";
		
		for(int i=0; i<studentSize; i++) {
			info += students[i].getName() +"/";
			info += students[i].getStudentId() +"/";
			info += students[i].getSize()+"/";
			info += students[i].saveSubject()+ "\n";
		}
		
		return info;
	}
	private void subjectSave() {
		String fileName = "subject.txt";
		String text = subjectText();
		file = new File(fileName);
		
		try {
			fw = new FileWriter(file);
			
			fw.write(text);
			
			fw.close();
			System.out.println("저장 성공");
		} catch (Exception e) {
			System.err.println("저장 실패");
		}
	}
	
	private String subjectText() {
		String info = "";
		
		for(int i=0; i<subjectSize; i++) {
			info += subjects[i].getName();
			if(i != subjectSize-1)
				info += "/";
		}
		
		return info;
	}

	private void load() {
		studentLoad();
		subjectLoad();
	}
	
	private void studentLoad(){
		file = new File("student.txt");
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			if(!br.ready()) {
				System.err.println("파일없음");
				return;
			}
			
			this.studentSize = Integer.parseInt(br.readLine());
			students = new Student[studentSize];
			int cnt = 0;
			while(br.ready()) {
				String[] info = br.readLine().split("/");
				System.out.println(info[0]);
				students[cnt] = new Student(info[0],Integer.parseInt(info[1]) , Integer.parseInt(info[2]));
				students[cnt].loadSetSize();
				
				for(int j=3; j<info.length; j+=2) {
					students[cnt].loadSubject(info[j], Integer.parseInt(info[j+1]));
				}
				
				cnt++;
			}
			
			
			br.close();
			fr.close();
			System.out.println("불러오기 성공");
		} catch (IOException e) {
			System.err.println("불러오기 실패");
			e.printStackTrace();
		}
	}
	
	private void subjectLoad() {
		file = new File("subject.txt");
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String[] info = br.readLine().split("/");
			this.subjectSize = info.length;
			subjects = new Subject[subjectSize];
			for(int i=0; i<subjectSize; i++) {
				subjects[i] = new Subject(info[i]);
			}
			
			br.close();
			fr.close();
			System.out.println("불러오기 성공");
		} catch (Exception e) {
			System.err.println("불러오기 실패");
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		while(isRun()) {
			printMenu();
			int select = inputNumber("메뉴선택");
			
			selectMenu(select);
		}
		
	}
}


public class Ex08 {
	public static void main(String[] args) {
		Lms system = new Lms();
		system.run();
	}

}
