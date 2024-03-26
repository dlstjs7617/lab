package lv10;

// 자바 Java
// ㄴ 객체 지향 프로그래밍에서의
// ㄴ 핵심 개념 "상속"

// 부모 클래스가 가지는 속성을
// 자식 클래스가 물려받는 것
// ㄴ 코드의 재사용성을 높이고,
// ㄴ 유지보수를 유용하게 만들 수 있다

// class 클래스명 extend 부모클래스 {} 

// overload
// ㄴ 동일한 이름의 메소드 또는 생성자를 캍은 클래스 안에 정의하는 것
// ㄴ 파라미터의 타입 또는 개수가 서로 달라야함


// override
// ㄴ 부모의 메소드를 재정의하는 것

//class Parents extends Object {	// 모든 클래스는 최상위 클래스인 Object를 물려받는다.
class Parents {
	int data;
	
	void printData() {
		System.out.println(data);
		
		
	}
}

class Child extends Parents {
	int data;
	
	void printChildData() {
		System.out.println(data);
	}
	
	@Override
	void printData() {
		// super는 부모를 지칭하는 것
		this.data = 10;		// <- 클래스 자기 자신의 것
		super.data = 20;	// <- 부모 클래스의 멤버를 지침
		
		System.out.println(this.data + super.data);
	}
}

public class Ex05 {

	public static void main(String[] args) {
		Parents parents = new Parents();
		Child child = new Child();
		
		child.printData();
	}

}
