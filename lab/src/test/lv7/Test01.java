package test.lv7;

import java.util.Arrays;
import java.util.Random;

// 시작 10:03
// 종료 10:51
// 소요 00:48

// 1.
// 중복 숫자 금지
// ㄴ Wrapper 클래스 활용
// ㄴ 1~10 범위의 중복 없는 5개의 숫자를 생성하고 배열에 담으시오


class NumberCheck{
	private Boolean check;
	
	public NumberCheck() {
		check = false;
	}
	
	public Boolean getCheck() {
		return check;
	}

	public void setCheck(Boolean check) {
		this.check = check;
	}
}

class Run {
	
	final Integer SIZE = 5;
	final Integer CSIZE = 10;
	
	private NumberCheck[] check;
	private Integer[] arr;
	
	private Boolean isRun() {
		Integer cnt = 0;
		
		for(int i=0; i<CSIZE; i++) {
			if(check[i].getCheck().equals((Boolean)true))
				cnt++;
		}
		
		if(cnt < 5)
			return true;
		else 
			return false;
	}
	
	private void RanSetArr() {
		Random ran = new Random();
		
		Integer cnt = 0;
		
		while(isRun()) {
			Integer rNum = ran.nextInt(10);
			
			if(check[rNum].getCheck().equals((Boolean)false)) {
				arr[cnt++] = rNum+1;
				check[rNum].setCheck((Boolean)true);
			}
		}
		
	}
	
	private void setArray() {
		check = new NumberCheck[CSIZE];
		arr = new Integer[SIZE];
		for(int i=0; i<CSIZE; i++) {
			check[i] = new NumberCheck();
		}
		
	}
	
	private void printArr() {
		System.out.println(Arrays.toString(arr));
	}
	
	void run() {
		setArray();
		RanSetArr();
		printArr();
		
	}
	
}

public class Test01 {

	public static void main(String[] args) {
		Run run = new Run();
		
		run.run();

	}

}
