package lv10;

class Vehicle{
	int wheel;

	String printwheel() {
		return "차량의 바퀴는 " + wheel + "개이다.";
	}
	
	@Override
	public String toString() {
		return printwheel();
	}
}

class Bike extends Vehicle{
	
	@Override
	String printwheel() {
		wheel = 2;
		return  "자전거의 바퀴는 " + wheel + "개이다.";
	}
	
	@Override
	public String toString() {
		return printwheel();
	}
}

class Car extends Vehicle{
	
	@Override
	String printwheel() {
		wheel = 4;
		return  "자동차의 바퀴는 " + wheel + "개이다.";
	}
	
	@Override
	public String toString() {
		return printwheel();
	}
}

class Kickboard extends Vehicle{
	
	@Override
	String printwheel() {
		wheel = 2;
		return  "킥보드의 바퀴는 " + wheel + "개이다.";
	}
	
	@Override
	public String toString() {
		return printwheel();
	}
}

class MotorCycle extends Vehicle{
	
	@Override
	String printwheel() {
		wheel = 2;
		return  "스쿠터의 바퀴는 " + wheel + "개이다.";
	}
	
	@Override
	public String toString() {
		return printwheel();
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
