package lv08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Subject{
	
	private String title;
	private int code;
	private int score;
	
	public Subject(String title, int code, int score) {
		this.title = title;
		this.code = code;
		this.score = score;
	}
	
	public Subject(String title, int code) {
		this.title = title;
		this.code = code;
	}
	
	
	
	public String getTitle() {
		return title;
	}
	
	public int getCode() {
		return code;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return String.format("과목 %s(%d)", title, code);
	}
}

class Student{
	
	
	private int studentNum;
	private double totalScore;
	private String name;
	private ArrayList<Subject> subject;

	public Student(String name, int studentNum) {
		subject = new ArrayList<Subject>();
		this.name = name;
		this.studentNum = studentNum;
	}
	
	public ArrayList<Subject> getSubject() {
		return subject;
	}
	
	public void setSubject(Subject subject) {
		for(int i=0; i<this.subject.size(); i++) {
			if(subject.getCode() == this.subject.get(i).getCode()) {
				System.err.println("이미 등록한 강의입니다");
				return;
			}
				
		}
		this.subject.add(subject);
	}
	
	public int getStudentNum() {
		return studentNum;
	}

	public double getTotalScore() {
		totalScore();
		return totalScore;
	}

	public String getName() {
		return name;
	}
	
	public void setScore(int code, int score) {
		int idx = findIdxByCode(code);
		
		if(idx < 0 || idx >= subject.size()) {
			System.err.println("유효하지 않은값");
			return;
		}
		
		subject.get(idx).setScore(score);
	}
	
	private int findIdxByCode(int code) {
		int idx = -1;
		
		for(int i=0; i<subject.size(); i++) {
			if(subject.get(i).getCode() == code)
				idx = i;
		}
		
		return idx;
	}
	
	public void delSubject(int code) {
		int idx = findIdxByCode(code);
		
		if(idx < 0 || idx >= subject.size()) {
			System.out.println("유효하지 않는 값");
			return;
		}
		
		
		this.subject.remove(idx);
	}
	
	public double totalScore() {
		for(int i=0; i<subject.size(); i++){
			totalScore += subject.get(i).getScore();
		}
		totalScore = totalScore/subject.size();
		
		return totalScore;
	}
	
	public void printSubjectAll() {
		for(int i=0; i<subject.size(); i++) {
			System.out.println(subject.get(i) +"점수 : "+ subject.get(i).getScore());
		}
	}
	
	public String saveSubject() {
		String text = "";
		for(int i=0; i<subject.size(); i++) {
			text += subject.get(i).getTitle() +"/";
			text += subject.get(i).getCode() +"/";
			text += subject.get(i).getScore() +"/";
		}
		return text;
	}
	
	@Override
	public String toString() {
		return String.format("이름: %s 학번: %d 수강중인 과목수: %d",	name, studentNum, subject.size());
	}
}

class Manager{
	
	private File file;
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;
	
	private Scanner sc;
	private ArrayList<Student> group;
	private ArrayList<Subject> subject;
	
	private final int STUDENT = 1;
	private final int SUBJECT = 2;
	private final int SCORE = 3;
	private final int SORT = 4;
	private final int SAVE = 5;
	
	private final int ADD = 1;
	private final int DELETE = 2;
	private final int SEARCH = 3;
	
	private final int CREATE_SUBJECT =1;
	private final int SUBJECT_ADD =2;
	private final int SUBJECT_DELETE =3;
	
	private final int SORT_NUMBER = 1;
	private final int SORT_NAME = 2;
	private final int SORT_SCORE = 3;
	
	private final int FILE_SAVE = 1;
	private final int FILE_LOAD = 2;
	
	private String fileName = "lms.txt";
	
	public Manager() {
		this.group = new ArrayList<Student>();
		this.subject = new ArrayList<Subject>();
		this.sc = new Scanner(System.in);
	}
	
	private int inputNumber(String message) {
		int number = 0;
		System.out.print(message + ":");
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
	
	private int createStudentNum() {
		Random ran = new Random();
		
		int studentNum;
		
		boolean isDupl = false;
		while(true) {
			int rNum = ran.nextInt(8999)+1000;
			
			for(int i=0; i<group.size(); i++) {
				if(group.get(i).getStudentNum() == rNum)
					isDupl = true;
			}
			
			if(!isDupl) {
				studentNum = rNum;
				break;
			}
		}
		
		return studentNum;
	}
	private int createCode() {
		Random ran = new Random();
		
		int code;
		
		boolean isDupl = false;
		while(true) {
			int rNum = ran.nextInt(8999)+1000;
			
			for(int i=0; i<subject.size(); i++) {
				if(subject.get(i).getCode() == rNum)
					isDupl = true;
			}
			
			if(!isDupl) {
				code = rNum;
				break;
			}
		}
		
		return code;
	}
	
	private Student createStudent() {
		String name = inputString("이름");
		int number = createStudentNum();
		
		Student student = new Student(name, number);
		
		return student;
	}
	
	private Subject createSubject() {
		String title = inputString("과목명");
		int code = createCode();
		
		Subject subject = new Subject(title, code);
		
		return subject;
	}
	
	
	private int findStudentIdxByStudentNum(int studentNum) {
		int idx = -1;
		
		for(int i=0; i<group.size(); i++)
			if(group.get(i).getStudentNum() == studentNum)
				idx = i;
		
		return idx;
	}
	
	private void printStudentAll() {
		for(int i=0; i<group.size(); i++) {
			System.out.println(i+") "+group.get(i));
		}
	}
	
	private void printSubjectAll() {
		for(int i=0; i<subject.size(); i++) {
			System.out.println(i+")"+ subject.get(i));
		}
	}
	
	//확인용 전체 출력
	private void printAll() {
		printStudentAll();
		printSubjectAll();
		for(int i=0; i<group.size(); i++) {
			group.get(i).printSubjectAll();
			
		}
	}
	
	private boolean isRun() {
		return true;
	}
	
	private void printMenu() {
		System.out.println("1.학생");
		System.out.println("2.과목");
		System.out.println("3.점수");
		System.out.println("4.정렬");
		System.out.println("5.저장");
	}
	
	private void subMenu(int select) {
		if(select == STUDENT)
			studentMenu();
		else if(select == SUBJECT)
			subjectMenu();
		else if(select == SCORE)
			setScore();
		else if(select == SORT)
			sortMenu();
		else if(select == SAVE)
			saveMenu();
	}
	
	private void addStudent() {
		group.add(createStudent());	
	}
	
	private void delStudent() {
		printStudentAll();
		int StudentNum = inputNumber("삭제할 대상의 학번");
		int index = findStudentIdxByStudentNum(StudentNum);
		
		if(index <0 || index > group.size()) {
			System.err.println("유효하지 않는 값");
			return;
		}
		
		group.remove(index);
	}
	
	private void searchStudent() {
		int StudentNum = inputNumber("삭제할 대상의 학번");		
		int index = findStudentIdxByStudentNum(StudentNum);
		
		if(index == -1) {
			System.out.println("찾지 못했습니다");
			return;
		}
		
		Student student = group.get(index); 
		
		System.out.println(student);
	}
	
	private void studentMenu() {
		System.out.println("1)학생추가");
		System.out.println("2)학생제적");
		System.out.println("3)학생조회");
		
		int sel = inputNumber("메뉴선택");
		
		if(sel == ADD)
			addStudent();
		else if(sel == DELETE && group.size() != 0)
			delStudent();
		else if(sel == SEARCH && group.size() != 0)
			searchStudent();
	}
	
	private void inputSubject() {
		Subject temp = createSubject();
		subject.add(temp);
	}
	
	private void addSubject() {
		printStudentAll();
		
		int index = inputNumber("학생선택");
		
		if(index < 0 || index >= group.size()) {
			System.err.println("유효하지않는 값");
			return;
		}
		
		printSubjectAll();
		int idx = inputNumber("과목선택");
		
		if(idx < 0 || idx >= subject.size())
			return;
		
		String title = subject.get(idx).getTitle();
		int code = subject.get(idx).getCode();
		Subject temp = new Subject(title, code);
		group.get(index).setSubject(temp);
		
	}
	
	private void deleteSubject() {
		printStudentAll();
		
		int index = inputNumber("학생선택");
		
		if(index < 0 || index >= group.size()) {
			System.err.println("유효하지않는 값");
			return;
		}
		
		group.get(index).printSubjectAll();
		
		int code = inputNumber("과목코드 입력");
		
		group.get(index).delSubject(code);
	}

	private void subjectMenu() {
		System.out.println("1)과목등록");
		System.out.println("2)과목신청");
		System.out.println("3)과목철회");
		
		int sel = inputNumber("메뉴선택");
		
		if(sel == CREATE_SUBJECT)
			inputSubject();
		else if(sel == SUBJECT_ADD )
			addSubject();
		else if(sel == SUBJECT_DELETE)
			deleteSubject();
	}
	
	private void setScore() {
		printStudentAll();
		
		int sNum = inputNumber("학번입력");
		int idx = findStudentIdxByStudentNum(sNum);
		
		if(idx == -1) {
			System.err.println("유효하지 않는 값");
			return;
		}
		
		group.get(idx).printSubjectAll();
		
		int code = inputNumber("과목코드입력");
		int score = inputNumber("점수입력");
		
		if(score < 0 || score > 100) {
			System.err.println("유요한 점수가 아닙니다.");
			return;
		}
		
		group.get(idx).setScore(code,score);
	}
	
	private void sortNumber() {
		for(int i=0; i<group.size(); i++) {
			Student temp = group.get(i);
			int index = i;
			for(int j=i; j<group.size(); j++) {
				if(temp.getStudentNum() > group.get(j).getStudentNum()) {
					temp = group.get(j);
					index = j;
				}
			}
			
			group.set(index, group.get(i));
			group.set(i, temp);
		}
	}
	
	private void sortName() {
		for(int i=0; i<group.size(); i++) {
			Student temp = group.get(i);
			int index = i;
			for(int j=i; j<group.size(); j++) {
				if(temp.getName().compareTo(group.get(j).getName()) > 0) {
					temp = group.get(j);
					index = j;
				}
			}
			
			group.set(index, group.get(i));
			group.set(i, temp);
		}
	}
	
	private void sortScore() {
		for(int i=0; i<group.size(); i++) {
			Student temp = group.get(i);
			int index = i;
			for(int j=i; j<group.size(); j++) {
				if(temp.getTotalScore() < group.get(j).getTotalScore()) {
					temp = group.get(j);
					index = j;
				}
			}
			
			group.set(index, group.get(i));
			group.set(i, temp);
		}
	}
	
	private void sortMenu() {
		System.out.println("1)학번(오름차순)");
		System.out.println("2)이름(오름차순)");
		System.out.println("3)성적(내림차순)");
		
		int sel = inputNumber("메뉴선택");
		if(sel == SORT_NUMBER)
			sortNumber();
		else if(sel == SORT_NAME)
			sortName();
		else if(sel == SORT_SCORE)
			sortScore();
	}
	
	private String saveAll() {
		String text = "";
		
		text += subject.size() + "/" + group.size();
		if(subject.size() != 0) {			
			text += "-";
		}
		for(int i=0; i<subject.size(); i++) {
			text += subject.get(i).getTitle() + "/";
			text += subject.get(i).getCode();
			if(i != subject.size()-1)
				text += "/\n";
		}
		if(group.size() != 0) {			
			text += "-";
		}
		for(int i=0; i<group.size(); i++) {
			text += group.get(i).getStudentNum() + "/";
			text += group.get(i).getName() + "/";
			text += group.get(i).saveSubject();
			if(i != group.size()-1)
				text += "\n";
		}
		
		return text;
	}
	
	private void save() {
		file = new File(fileName);
		String text = saveAll();
		
		try {
			fw = new FileWriter(file);
			
			fw.write(text);
			
			fw.close();
			System.out.println("파일저장 성공");
		} catch (Exception e) {
			System.err.println("파일저장 실패");
			e.printStackTrace();
		}
		
		
	}
	
	private void readText(String text) {
		String[] temp = text.split("-");

		System.out.println(Arrays.toString(temp));
		String[] check = temp[0].split("/");
		boolean subjectSize = false;
		boolean studentSize = false;
		
		int cnt = 0;
		if(!check[0].equals("0")) {
			subjectSize = true;
			cnt++;
		}else if(!check[1].equals("0")) {
			studentSize = true;
			cnt++;
		}
		
		if(subjectSize) {
			String[] subjects = temp[1].split("\n");
			
			subject = new ArrayList<Subject>();
			for (int i = 0; i < subjects.length; i++) {
				String[] element = subjects[i].split("/");
				
				String title = element[0];
				int code = Integer.parseInt(element[1]);
				
				Subject input = new Subject(title, code);
				
				subject.add(input);
			}			
		}
		if(studentSize) {
			String[] student = temp[cnt].split("\n");
			group = new ArrayList<Student>();
			
			for (int i = 0; i < student.length; i++) {
				String[] element = student[i].split("/");
				
				int studentNum = Integer.parseInt(element[0]);
				String name = element[1];
				
				Student tempStudent = new Student(name, studentNum);
				
				group.add(tempStudent);
				for (int j = 2; j < element.length; j += 3) {
					String title = element[j];
					int code = Integer.parseInt(element[j + 1]);
					int score = Integer.parseInt(element[j + 2]);
					
					Subject tempSubject = new Subject(title, code, score);
					group.get(i).setSubject(tempSubject);
				}
				
			}			
		}

	}
	
	private void load() {
		file = new File(fileName);
		
		if(!file.exists()) {
			System.err.println("파일이 없습니다.");
			return;
		}
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String text = "";
			while(br.ready()) {
				text += br.readLine();
				if(br.ready())
					text +="\n";
			}
			if(text.isEmpty()) {
				System.err.println("빈 파일입니다");
				return;
			}
			readText(text);
			
			br.close();
			fr.close();
			System.out.println("파일 로드 성공");
		} catch (Exception e) {
			System.err.println("파일 로드 실패");
			e.printStackTrace();
		}
	}

	private void saveMenu() {
		System.out.println("1)저장");
		System.out.println("2)불러오기");
		
		int sel = inputNumber("메뉴선택");
		if(sel == FILE_SAVE) {
			save();
		}else if(sel == FILE_LOAD) {
			load();
		}
		
	}
	
	public void run() {
		
		while(isRun()) {
			printAll();
			printMenu();
			int select = inputNumber("메뉴선택");
			
			subMenu(select);
			
		}
	}
}

public class Ex07 {

	public static void main(String[] args) {
		
		Manager system = new Manager();
		system.run();

	}

}
