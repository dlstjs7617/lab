package lv06;

import java.util.Random;
import java.util.Scanner;

// 자바 : 프로그래밍 언어 중-> "객체"지향언어 (<-> 절차지향 언어)

// 객체 Object
// ㄴ 현실세계에서 존재하는 추상적, 구체적 존재를
// ㄴ 프로그래밍 세계에서 처리할 수 있는 데이터의 단위로 만든 것

// * 공기, 사람, 책상, 모니터, 학생, 커피, 텀블러, 스마트폰
// * 강의, 과목,

// 클래스
// ㄴ 객체를 정의하는 설계도(사용자 정의 자료형) 
// ㄴ 클래스 != 객체

// 클래스 정의
// 클래스명 : 대문자로 시작하는 카멜 표기법
// class 클래스명 {}

// 인스턴스 Instance (= 생성된 객체)
// ㄴ 클래스를 통해 객체가 구현된 코드의 상태

class Person {
	// 클래스가 가질 수 있는 두 가지 요소
	// 1) 속성 (멤버 변수, 필드값)
	// 2) 기능 (메소드)
	
	// * 키, 의상, 혈액형, 몸무게, 성별, 나이, 이름, 생일 ... 
	
	String name;
	int age;
	int height;
	int weight;
	int birth;
	int gender;
	char blood;
}

public class Ex01 {	
	public static void main(String[] args) {
		
		// 클래스를 활용하여 -> 객체를 생성
		// new 클래스명();
		
		Scanner sc = new Scanner(System.in);
		
		Random random = new Random();
		
		// 참조 변수
		Person gildong = new Person();		//lv06.Person@6f2b958e
		System.out.println(gildong);
		
		Person jiyeon = new Person();		
		System.out.println(jiyeon);			//lv06.Person@340f438e
		
		
		// 생성된 객체로부터 -> 멤버를 얻어올 수 O
		// ㄴ 참조변수 뒤에 .닷을 붙여서 가져옴
		
		gildong.name = "홍길동";
		gildong.age = 30;
		gildong.height = 180;
		gildong.weight = 80;
		gildong.blood = 'A';
		gildong.gender = 1;
		gildong.birth = 950209;
		
		System.out.println(gildong.name);	// null
		System.out.println(gildong.age);		// 0
		System.out.println(gildong.height);
		System.out.println(gildong.weight);
		System.out.println(gildong.blood);
		System.out.println(gildong.gender);
		System.out.println(gildong.birth);
		
	}

}
