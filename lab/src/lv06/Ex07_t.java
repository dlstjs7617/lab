package lv06;

// 나만의 계산기

class MyCalculator_t{
	
	int[] nums = {10, 20};
	
	// + (return O, parameter O)
	int sum(int a ,int b) {
		
		return a + b;
		
		
	}
	// - (return O, parameter X)
	
	int minus() {
		return nums[0] - nums[1];
	}
	
	
	// * (return X, parameter X)
	
	void multiple(){
		System.out.println(nums[0] * nums[1]);
	}
	
	
	// / (return X, parameter O)
	
	void divide(int a , int b){
		System.out.println((double)a/b);
	}
	
}

public class Ex07_t {

	public static void main(String[] args) {
		MyCalculator_t calculator = new MyCalculator_t();
		
		// 메소드 모두 호출
		int result = calculator.sum(1,2);
		System.out.println(result);
		
		result = calculator.minus();
		System.out.println(result);
		
		calculator.multiple();
		
		
		calculator.divide(10, 3);
	}

}
