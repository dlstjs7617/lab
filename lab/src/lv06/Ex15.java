package lv06;

import java.util.Scanner;

// 클래스 Class
// ㄴ 객체를 생성하기(만들기) 위한 설계도 (사용자 정의 자료형)
// ㄴ 클래스가 가지는 요소(변수-속성, 메소드-기능)

// 객체 Object
// ㄴ 현실 세계에 존재하는 추상적 또는 구체적 존재를 -> 프로그래밍 세계에서 다룰 수 있는 데이터의 단위

// 인스턴스 Instance
// ㄴ 클래스를 통해 객체가 힙에 구현된 상태

// 1-1. 멤버 Member
// ㄴ 클래스 안에 있는 요소들 (객체 자기 자신의 것)
// ㄴ 1)멤버 변수
// ㄴ 2)멤버 메소드

// 1-1-1. 메소드 Method
// ㄴ 클래스 안에 정의된 함수를 메소드라고 함
// ㄴ 클래스의 기능을 구현하게 됨
// ㄴ 문법 : 리턴할자료형 메소드명(파라미터) { 실행문; return; }

// 1-1-1-1. 오버로딩 Overloading
// ㄴ 동일한 이름의 메소드를 클래스 안에 정의한 것
// ㄴ 조건. 파라미터의 개수 또는 타입이 서로 달라야함
// ㄴ ex) String.substring(),print

class SampleEx {
	
	Scanner sc = new Scanner(System.in);
	void func(String name) {
		System.out.println("이름 : "+ name);		
	}
	void func(String name , int age) {
		System.out.println("이름 : "+ name + " 나이 : " + age );		
	}
	void func(String name , int age , int height) {
		System.out.println("이름 : "+ name + " 나이 : " + age + " 키 : " + height);		
		
	}
	void func(String name , int age , int height , int weight) {
		System.out.println("이름 : "+ name + " 나이 : " + age + " 키 : " + height + " 몸무게 : " + weight);		
	}
}

public class Ex15 {

	public static void main(String[] args) {
		
		SampleEx object = new SampleEx();
		object.func("이인선");
		object.func("이인선", 27);
		object.func("이인선", 27, 177);
		object.func("이인선", 27, 177, 70);

	}

}
