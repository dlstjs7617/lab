package lv08t;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Subject2 {
	private int code;
	private String title;
	private int score;

	public Subject2(int code, String title) {
		this.code = code;
		this.title = title;
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

	public Subject2 clone() {
		Subject2 Subject2 = new Subject2(this.code, this.title);
		Subject2.setScore(this.score);
		return Subject2;
	}
}

class Student2 {
	private int code;
	private String name;

	private ArrayList<Subject2> Subject2s;

	public Student2(int code, String name) {
		this.code = code;
		this.name = name;

		Subject2s = new ArrayList<>();
	}

	public int getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}

	public double getScoreAverage() {
		double average = 0;

		double total = 0;
		for (Subject2 Subject2 : Subject2s)
			total += Subject2.getScore();

		average = total / Subject2s.size();

		return average;
	}
	
	public int getSubject2sSize() {
		return this.Subject2s.size();
	}

	public boolean hasSubject2(int code) {
		for (Subject2 Subject2 : Subject2s) {
			if (Subject2.getCode() == code)
				return true;
		}
		return false;
	}

	public void addSubject2(Subject2 Subject2) {
		Subject2s.add(Subject2);
	}

	public void printSubject2All() {
		for (int i = 0; i < Subject2s.size(); i++) {
			Subject2 Subject2 = Subject2s.get(i);
			System.out.printf("%d) %s", i + 1, Subject2.getTitle());
		}
	}

	// Read Subject2
	public Subject2 getSubject2(int index) {
		Subject2 Subject2 = Subject2s.get(index);
		return Subject2.clone();
	}

	// Update Subject2
	public void setSubject2(int index, Subject2 Subject2) {
		Subject2 temp = Subject2s.get(index);

		if (temp.getCode() == Subject2.getCode()) {
			temp.setScore(Subject2.getScore());
		}
	}

	// Delete Subject2
	public void removeSubject2(int index) {
		if (index < 0 || index >= Subject2s.size()) {
			System.err.println("유효하지 않은 범위입니다.");
			return;
		}
		Subject2s.remove(index);
	}

	@Override
	public String toString() {
		String info = String.format("%s(%d)", this.name, this.code);

		for (Subject2 Subject2 : Subject2s) {
			info += "\nㄴ";
			info += Subject2.getTitle() + " : " + Subject2.getScore();
		}
		return info;
	}

}

class Manager2 {
	private final int Student2 = 1;
	private final int Subject2 = 2;
	private final int SCORE = 3;
	private final int SORT = 4;
	private final int FILE = 5;

	private final int Student2_JOIN = 1;
	private final int Student2_LEAVE = 2;
	private final int Student2_SEARCH = 3;

	private final int Subject2_ENROLL = 1;
	private final int Subject2_SELECT = 2;
	private final int Subject2_CANCEL = 3;

	private final int SCORE_UPDATE = 1;

	private final int SORT_CODE = 1;
	private final int SORT_NAME = 2;
	private final int SORT_SCORE = 3;
	
	private final int FILE_SAVE = 1;
	private final int FILE_LOAD = 2;

	private Scanner scanner = new Scanner(System.in);

	private FileWriter fileWriter;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	
	private File file;
	private String fileName;
	
	private ArrayList<Student2> group;
	private ArrayList<Subject2> Subject2s;
	
	public Manager2() {
		this.group = new ArrayList<>();
		this.Subject2s = new ArrayList<>();
		
		this.fileName = "lms.txt";
		this.file = new File(fileName);
	}

	public void run() {
		while (true) {
			printStudent2All();
			showMenu();
			int select = inputNumber("menu");
			runMenu(select);
		}
	}

	private void runMenu(int select) {
		switch (select) {
		case (Student2):
			showStudent2SubMenu();
			runStudent2SubMenu(option());
			break;
		case (Subject2):
			showSubject2SubMenu();
			runSubject2SubMenu(option());
			break;
		case (SCORE):
			showScoreSubMenu();
			runScoreSubMenu(option());
			break;
		case (SORT):
			showSortSubMenu();
			runSortSubMenu(option());
			break;
		case(FILE) :
			showFileSubMenu();
			runFileSubMenu(option());
			break;
		}
	}

	private void runStudent2SubMenu(int option) {
		if (option == Student2_JOIN)
			joinStudent2();
		else if (option == Student2_LEAVE)
			leaveStudent2();
		else if (option == Student2_SEARCH)
			searchStudent2();
	}

	private void runSubject2SubMenu(int option) {
		if (option == Subject2_ENROLL)
			enrollSubject2();
		else if (option == Subject2_SELECT)
			selectSubject2();
		else if (option == Subject2_CANCEL)
			cancelSubject2();
	}

	private void runScoreSubMenu(int option) {
		if (option == SCORE_UPDATE)
			updateScore();
	}

	private void runSortSubMenu(int option) {
		if (option == SORT_CODE)
			sortByStudent2Code();
		else if (option == SORT_NAME)
			sortByStudent2Name();
		else if (option == SORT_SCORE)
			sortByStudent2Score();
	}
	
	private void runFileSubMenu(int option) {
		if (option == FILE_SAVE)
			saveData();
		else if(option == FILE_LOAD)
			loadData();
	}

	private void joinStudent2() {
		int code = createRandomStudent2Code();
		String name = inputString("name");

		Student2 Student2 = new Student2(code, name);
		group.add(Student2);

		System.out.println("학생 등록 완료");
	}

	private int createRandomStudent2Code() {
		int code = 0;
		Random random = new Random();

		while (true) {
			code = random.nextInt(9000) + 1000;

			boolean isDupl = false;
//			for(int i=0; i<group.size(); i++) {
//				Student2 Student2 = group.get(i);

			// 향상된 for문
			for (Student2 Student2 : group) {
				if (Student2.getCode() == code)
					isDupl = true;
			}

			if (!isDupl)
				break;
		}

		return code;
	}

	private int createRandomSubject2Code() {
		int code = 0;
		Random random = new Random();

		while (true) {
			code = random.nextInt(9000) + 1000;

			boolean isDupl = false;
			for (Subject2 Subject2 : Subject2s) {
				if (Subject2.getCode() == code)
					isDupl = true;
			}

			if (!isDupl)
				break;
		}

		return code;
	}

	private void leaveStudent2() {
		int code = inputNumber("제적할 학번");

		Student2 Student2 = searchStudent2(code);
		group.remove(Student2);

		System.out.println("학생 제적 완료");
	}

	private void searchStudent2() {
		int code = inputNumber("제적할 학번");

		Student2 Student2 = searchStudent2(code);
		System.out.println(Student2);
	}

	private Student2 searchStudent2(int code) {
		Student2 Student2 = null;

		for (Student2 target : group) {
			if (target.getCode() == code)
				Student2 = target;
		}

		return Student2;
	}

	private void enrollSubject2() {
		int code = createRandomSubject2Code();
		String title = inputString("title");

		Subject2 Subject2 = new Subject2(code, title);
		Subject2s.add(Subject2);

		System.out.println("신규과목 등록 완료");
	}

	private void selectSubject2() {
		int code = inputNumber("학번");
		Student2 Student2 = searchStudent2(code);

		if (Student2 == null) {
			System.err.println("학번 정보를 다시 확인하세요.");
			return;
		}

		printSubject2All();
		int index = inputNumber("선택") - 1;

		Subject2 Subject2 = Subject2s.get(index);
		int Subject2Code = Subject2.getCode();

		if (Student2.hasSubject2(Subject2Code)) {
			System.err.println("이미 수강중인 과목입니다.");
			return;
		}

		Student2.addSubject2(Subject2.clone());
		System.out.println("수강 신청 완료");
	}

	private void printStudent2All() {
		System.out.println("-----------------");
		for (Student2 Student2 : group)
			System.out.println(Student2);
		System.out.println("-----------------");
	}

	private void printSubject2All() {
		for (int i = 0; i < Subject2s.size(); i++) {
			Subject2 Subject2 = Subject2s.get(i);
			System.out.printf("%d) %s\n", i + 1, Subject2.getTitle());
		}
	}

	private void cancelSubject2() {
		int code = inputNumber("학번");
		Student2 Student2 = searchStudent2(code);

		if (Student2 == null) {
			System.err.println("학번 정보를 다시 확인하세요");
			return;
		}

		Student2.printSubject2All();
		int index = inputNumber("선택") - 1;

		Student2.removeSubject2(index);
		System.out.println("수강 철회 완료");
	}

	private void updateScore() {
		int code = inputNumber("학번");
		Student2 Student2 = searchStudent2(code);

		if (Student2 == null) {
			System.err.println("학번 정보를 다시 확인하세요.");
			return;
		}

		Student2.printSubject2All();
		int index = inputNumber("선택") - 1;
		int score = inputNumber("성적");

		Subject2 Subject2 = Student2.getSubject2(index);
		Subject2.setScore(score);

		Student2.setSubject2(index, Subject2);
		System.out.println("성적 수정 완료");
	}

	private void sortByStudent2Code() {
		for (int i = 0; i < group.size(); i++) {
			Student2 Student2 = group.get(i);
			int first = i;

			for (int j = i; j < group.size(); j++) {
				Student2 target = group.get(j);

				if (Student2.getCode() > target.getCode()) {
					Student2 = target;
					first = j;
				}
			}

			if (first != i) {
				group.set(first, group.get(i));
				group.set(i, Student2);
			}
		}
	}

	private void sortByStudent2Name() {
		for (int i = 0; i < group.size(); i++) {
			Student2 Student2 = group.get(i);
			int first = i;

			for (int j = i; j < group.size(); j++) {
				Student2 target = group.get(j);

				if (Student2.getName().compareTo(target.getName()) > 0) {
					Student2 = target;
					first = j;
				}
			}

			if (first != i) {
				group.set(first, group.get(i));
				group.set(i, Student2);
			}
		}
	}

	private void sortByStudent2Score() {
		for (int i = 0; i < group.size(); i++) {
			Student2 Student2 = group.get(i);
			int first = i;

			for (int j = i; j < group.size(); j++) {
				Student2 target = group.get(j);

				if (Student2.getScoreAverage() < target.getScoreAverage()) {
					Student2 = target;
					first = j;
				}
			}

			if (first != i) {
				group.set(first, group.get(i));
				group.set(i, Student2);
			}
		}
	}
	
	private void saveData() {
		String data = createDataString();
		
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write(data);
			fileWriter.close();
			
			System.out.println("파일저장 성공");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("파일저장 실패");
		}
	}
	
	private String createDataString() {
		String data = "";
		
		/*
		 * 과목코드1,과목명1/과목코드2,과목명2/과목코드3,과목명3 ...
		 * 학번1/이름1
		 * 학번2/이름2/과목코드1,성적1 
		 * 학번3/이름3/과목코드1,성적1/과목코드2,성적2 
		 */
		
		// Subject2s 
		if(Subject2s.size() > 0) {
			for(Subject2 Subject2 : Subject2s) {
				data += Subject2.getCode() + "," + Subject2.getTitle();
				data += "/";
			}
			data = data.substring(0, data.length() -1);
		}
		
		// group 
		for(Student2 Student2 : group) {
			data += "\n" + Student2.getCode() + "/" + Student2.getName();
			
			for(int j=0; j<Student2.getSubject2sSize(); j++) {
				Subject2 Subject2 = Student2.getSubject2(j);
				
				data += "/" + Subject2.getCode() + "," + Subject2.getScore();
			}
		}
		
		return data;
	}
	
	private void loadData() {
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
				System.out.println("파일로드 성공");
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("파일로드 실패");
			}
		}
	}
	
	private void parseLoadedData(String data) {
		this.group.clear();
		this.Subject2s.clear();
		
		String[] lines = data.split("\n");
		
		// Subject2s 
		String[] Subject2s = lines[0].split("/");
		for(int i=0; i<Subject2s.length; i++) {
			String[] info = Subject2s[i].split(",");
			
			int code = Integer.parseInt(info[0]);
			String title = info[1];
			
			Subject2 Subject2 = new Subject2(code, title);
			this.Subject2s.add(Subject2);
		}
		
		// group
		for(int i=1; i<lines.length; i++) {
			String[] info = lines[i].split("/");
			
			int code = Integer.parseInt(info[0]);
			String name = info[1];
			
			Student2 Student2 = new Student2(code, name);
			
			for(int j=2; j<info.length; j++) {
				String[] subInfo = info[j].split(",");
				
				int subCode = Integer.parseInt(subInfo[0]);
				int subScore = Integer.parseInt(subInfo[1]);
				
				Subject2 Subject2 = searchSubject2(subCode);
				
				if(Subject2 != null) {
					Subject2.setScore(subScore);
					Student2.addSubject2(Subject2.clone());
				}
			}
			this.group.add(Student2);
		}
	}
	
	private Subject2 searchSubject2(int code) {
		for(Subject2 Subject2 : Subject2s) {
			if(Subject2.getCode() == code)
				return Subject2;
		}
		return null;
	}

	private void showMenu() {
		System.out.println("1. 학생");
		System.out.println("2. 과목");
		System.out.println("3. 성적");
		System.out.println("4. 정렬");
		System.out.println("5. 파일");
	}

	private void showStudent2SubMenu() {
		System.out.println("1) 등록");
		System.out.println("2) 제적");
		System.out.println("3) 조회(학번)");
	}

	private void showSubject2SubMenu() {
		System.out.println("1) 등록");
		System.out.println("2) 신청(수강)");
		System.out.println("3) 철회(수강)");
	}

	private void showScoreSubMenu() {
		System.out.println("1) 수정(수강과목)");
	}

	private void showSortSubMenu() {
		System.out.println("1) 학번(오름차순)");
		System.out.println("2) 이름(오름차순)");
		System.out.println("3) 성적(내림차순)");
	}

	private void showFileSubMenu() {
		System.out.println("1) 저장");
		System.out.println("2) 로드");
	}

	private int option() {
		return inputNumber("");
	}

	private int inputNumber(String message) {
		int number = 0;

		System.out.print(message + ": ");
		try {
			String input = scanner.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
		}
		return number;
	}

	private String inputString(String message) {
		System.out.println(message + ": ");
		return scanner.next();
	}
}

public class Ex07t {
	public static void main(String[] args) {

		Manager2 system = new Manager2();
		system.run();

	}
}