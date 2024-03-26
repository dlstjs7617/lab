package lv10;

// 상속
// 추상화
// 인터페이스
// 마크인터페이스

class A{
	public int a;
	
	public void funcA() {
		
	}
}


// 자바에서는 다중 상속 허용하지 않음
// ㄴ 인터페이스를 활용한 다중 상속의 효과를 가져갈 수는 있도록 O
class B extends A {
	public int b;
	
	public void funcB() {
		
	}
}

//	abstract class 추상 클래스가 가진 메소드 중,
// 	abstract 붙어있는 메소드는 -> body 가 명세될 수 없고,
//  자식 클래스가 override를 통해 구현할 수 있다.
abstract class C {
	public int c;
	
	abstract public void funcC();
	
	public void funcCC() {
		
	}
}

class D extends C{
	public int d;
	
	public void funcD() {
		
	}

	@Override
	public void funcC() {
		System.out.println("부모의 꿈을 이뤘습니다.");
	}
}

// 모든 메소드가 추상화 처리됨 (메소드의 묶음)
interface E {
	public static int e = 1;
	void funcE();
	void funcEE();
}
// 마크인터페이스 : 아무것도 담기지않은 인터페이스
// 
interface EE {
	
}

class F implements E{

	@Override
	public void funcE() {
		
	}

	@Override
	public void funcEE() {
		
	}
	
}

public class Ex08 {

	public static void main(String[] args) {

	}

}
