package test.lv6;
//Lv6 Test (클래스 + 메소드)

import java.util.Arrays;
import java.util.Scanner;

// 시작 10:29
// 종료 11:03
// 소요 00:24

// 2.
	/*
	 * # 영화관 좌석예매 : 클래스 + 메서드
	 * 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다.
	 * 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다. (예매 취소가 되면 해당 좌석을 값을 0으로 변경)
	 * 3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
	 * 4. 한 좌석당 예매 가격은 12000원이다.
	 * 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
	 * 
	 */

class CGV {
	
	Scanner sc = new Scanner(System.in);
	
	final int SIZE = 10;
	final int PRICE = 12000;
	
	int[] seat;
	int select;
	int total;
	
	void setCgv() {
		seat = new int[SIZE];
	}
	
	boolean isRun(int select) {
		boolean run = true;
		
		if(select == 3)
			run = false;
		
		return run;
	}
	
	int inputNumber() {
		int num = -1;
		
		try {
			System.out.print("입력 :");
			String input = sc.next();
			num = Integer.parseInt(input);
			
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return num;
	}
	
	void printMap() {
		System.out.println("===CGV 좌석 예매===");
		System.out.println("자리인덱스");
		System.out.println("[0  1  2  3  4  5  6  7  8  9]");
		System.out.println(Arrays.toString(seat));
	}
	
	void printMenu(){
		System.out.println("1. 좌석예매 2. 예매취소 3. 종료");
	}
	
	void seatSystem(int select) {
		
		if(select == 1) {
			seat();
		}else if(select == 2) {
			seatCancel();
		}	
	}
	
	void seat() {
		printMap();
		System.out.print("자리");
		int index = inputNumber();
		
		if(!idxLengthException(index))
			return;
		
		if(idxException(index))
			return;
		
		System.out.println("예매되셨습니다");
		seat[index] = 1;
		total += PRICE;
	}
	
	void seatCancel() {
		printMap();
		System.out.print("자리");
		int index = inputNumber();
		
		if(!idxLengthException(index))
			return;
		
		if(!idxException(index))
			return;
		
		System.out.println("예매취소되셨습니다");
		seat[index] = 0;
		total -= PRICE;
	}
	boolean idxLengthException(int index) {
		if(index < 0 || index >= SIZE) {
			System.err.println("유효하지 않는값");
			return false;
		}
		return true;
	}
	
	boolean idxException(int index) {
		if(seat[index] == 1) {
			System.out.println("이미 예매된 자리입니다");
			return true;
		}
		System.out.println("빈자리 입니다.");
		return false;
	}
	
	void printTotal() {
		System.out.println("총 매출 : " + total);
	}
	
	void run() {
		
		setCgv();
		
		while(isRun(select)) {
			
			printMenu();
			select = inputNumber();
			seatSystem(select);
			
		}
		
		printTotal();
	}
}


public class Test02 {

	public static void main(String[] args) {
		CGV cgv = new CGV();
		
		cgv.run();
	

	}

}
