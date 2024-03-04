package lv07t;
// 1.추가
// 		1-1. 학생 (랜덤 4자리 학번 부여)
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
		return this.subjects.clone();
	}
	
	public void setSubject(Subject[] subjects) {
		this.subjects = subjects;
		
		this.subjectCnt = subjects == null ? 0 :subjects.length;
	}
	
	@Override
	public String toString() {
		// 학생학번(이름)
		// ㄴ 과목명1 : 00점
		// ㄴ 과목명2 : 00 점
		String info = String.format("%s (%d\n)", code, name);
		
		for(int i=0; i<subjectCnt; i++) {
			Subject subject = subjects[i];
			info += String.format("%s : %3d점\n", subjects[i].getTitle(),subjects[i].getScore());
		}
		
		return info;
	}
	
}

class Lms{
	
	int studentCount;
	private Student[] students;
	private Subject[] subjects; // 수강신청용
	
	
	int subjectCount;
	public Lms() {
		setSubjects();
	}
	
	private void setSubjects() {
		subjectCount = 3;
		subjects = new Subject[subjectCount];
		
		subjects[0] = new Subject("수학");
		subjects[1] = new Subject("영어");
		subjects[2] = new Subject("국어");
	}
	
	public void run() {
		
	}
}


public class Ex08 {
	public static void main(String[] args) {
		Lms system = new Lms();
		system.run();
	}

}
