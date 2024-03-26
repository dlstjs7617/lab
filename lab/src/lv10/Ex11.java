package lv10;

import java.util.ArrayList;

// 상속
// ㄴ 부모로부터 자식이 부모의 소유를 물려받는 것
// ㄴ extends 키워드를 통해 상속의 관계 부여
// ㄴ class 자식클래스 extends 부모클래스{}

// 추상
// ㄴ 부모 클래스가 특정 메소드에 대하여 선언부만 가지고 
// ㄴ 자식 클래스가 해당 메소드에 대하여 구현하도록 하는 것

// 1) abstract class
// ㄴ 추상클래스 부분적으로 구현되어 있고, 지정한 메소드에 대해서만 추상할 수 O

// 2) interface
// ㄴ 모든 메소드가 추상 메소드로 처리됨

// 마크 인터페이스
// ㄴ 표시자 역활
// ㄴ 메소드를 가지지 않음

// * 다형성 PolyMorphism
// ㄴ 하나의 코드(클래스)로 여러가지 자료형을 만드는 것
// ㄴ 동일한 동작으로 여러가지 처리를 할 수 있는 것
// ㄴ 장점 : 코드의 재사용성을 높이고 확장성을 얻고 유지보수성을 높이게 됨
abstract class Shape {
	int x,y;
	
	abstract void draw();
	abstract void move();
}

class Circle extends Shape {

	@Override
	void draw() {
		System.out.println("원을 그립니다~");
	}

	@Override
	void move() {
		System.out.println("원을 그리기 위해 움직이는 중");
	}
	
}

class Triangle extends Shape {

	@Override
	void draw() {
		System.out.println("삼각형을 그립니다.");
	}

	@Override
	void move() {
		System.out.println("삼각형을 그리기 위해 움직이는중");
	}
	
}

class Square extends Shape {

	@Override
	void draw() {
		System.out.println("네모을 그립니다.");
	}

	@Override
	void move() {
		System.out.println("네모을 그리기 위해 움직이는중~");
	}
	
}
public class Ex11 {

	public static void main(String[] args) {
		ArrayList<Shape> group = new ArrayList<Shape>();
		
		group.add(new Circle());
		group.add(new Triangle());
		group.add(new Square());
		
		group.get(0).draw();
	}

}
