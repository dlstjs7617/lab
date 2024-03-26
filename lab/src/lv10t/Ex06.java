package lv10t;

class Vehicle{
	String name;
	int wheel;
	
	Vehicle(String name, int wheel) {
		this.name = name;
		this.wheel = wheel;
	}
	
	@Override
	public String toString() {
		return String.format("%s의 바퀴는 %d개이다.", this.name, this.wheel);
	}
}

class Bike extends Vehicle{
	Bike() {
//		super();
		super("바이크", 2);
//		super.name = "바이크";
//		super.wheel = 2;
	}
}

class Car extends Vehicle{
	Car() {
		super("자동차", 4);	// 부모의 생성자를 호출(부모 객체가 생성됨)
//		super.name = "자동차";
//		super.wheel = 4;
	}
}

class Kickboard extends Vehicle{
	Kickboard() {
//		super();			// 기본 생성자 호출이 불가해지는 이유는? 생성자를 정의해두었고, 기본 생성자 허용을 하지 않았기 때문
		super("킥보드", 2);	// Vechicle 즉 부모 생성자 호출 -> 객체 생성
//		super.name = "킥보드";
//		super.wheel = 2;
	}
}

class MotorCycle extends Vehicle{
	MotorCycle() {
		super("스쿠터", 2);	// 부모가 정의한 생성자를 호출
//		super.name = "스쿠터";
//		super.wheel = 2;
	}
}

public class Ex06 {

	public static void main(String[] args) {
		// 자전거
		// 자동차
		// 킥보드
		// 스쿠터
		Bike bike = new Bike();
		Car car = new Car();
		Kickboard board = new Kickboard();
		MotorCycle motor = new MotorCycle();
		
		System.out.println(bike); 	// 자전거의 바퀴는 2개이다.
		System.out.println(car);	// 자동차의 바퀴는 4개이다.
		System.out.println(board);	// 킥보드의 바퀴는 2개이다.
		System.out.println(motor);	// 스쿠터의 바퀴는 2개이다
	}

}