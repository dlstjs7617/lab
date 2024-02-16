package lv06;

// 나만의 계산기

class MyCalculator{
	
	int[] nums = {10, 20};
	
	// + (return O, parameter O)
	int add(int x ,int y) {
		
		int add = x+y;
		return add;
		
	}
	// - (return O, parameter X)
	
	int sub() {
		
		int sub = nums[0] - nums[1];
		return sub;
	}
	
	
	// * (return X, parameter X)
	
	void mul(){
		int mul = nums[0] * nums[1];
		System.out.println(mul);
	}
	
	
	// / (return X, parameter O)
	
	void div(int x , int y){
		double div = x/y;
		System.out.println(div);
	}
	
}

public class Ex07 {

	public static void main(String[] args) {
		MyCalculator calculator = new MyCalculator();
		
		// 메소드 모두 호출
		System.out.println("===add===");
		System.out.println(calculator.add(4,9));
		
		System.out.println("===sub===");
		System.out.println(calculator.sub());
		
		System.out.println("===mul===");
		calculator.mul();
		
		System.out.println("===div===");
		calculator.div(50, 5);
	}

}
