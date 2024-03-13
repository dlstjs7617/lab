package lv08;

import java.util.Scanner;
import java.util.Vector;

// Vector를 활용한 컨트롤러 구현

class Tv{
	private String name;
	private String brand;
	private int price;
	
	public Tv(String name, String brand, int price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}
	
	@Override
	public String toString() {
		return String.format("이름 : %s 브랜드 : %s 가격 :  %d\n" , name, brand, price);
	}
	
}

class SalesManager{
	
	Scanner sc = new Scanner(System.in);
	
	private Vector<Tv> list = new Vector<Tv>();
	
	private String inputString(String message) {
		System.out.print(message + "입력:");
		return sc.next();
	}
	
	private int inputNumber(String message) {
		int number = -1;
		System.out.print(message + "입력:");
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return number;
	}
	
	private void printIdx() {
		int idx = inputNumber("조회할 인덱스");
		
		if(idx < 0 || idx >= list.size()) {
			System.err.println("유효하지 않은값");
			return;
		}
		
		System.out.println(list.get(idx));
	}
	
	private void delete() {
		String name = inputString("이름");
		String brand = inputString("브랜드");
		
		int idx =findNameBrand(name, brand);
		
		if(idx == -1) {
			System.err.println("잘못된 정보입니다");
			return;
		}
		
		list.remove(idx);
	}
	
	private int findNameBrand(String name, String brand) {
		int idx = -1;
		
		for(int i=0; i<list.size(); i++) {
			if(name.equals(list.get(i).getName()) && brand.equals(list.get(i).getBrand()))
				idx = i;
		}
		
		return idx;
	}
	
	public void run() {
		while(true) {
			//전체 데이터 출력
			System.out.println(list);
			// 추가, 삽입, 삭제. 삭제값. 조회, 수정, 크기
			System.out.println("1)추가 2)삽입) 3)삭제 4)삭제값 5)조회 6)수정 7)크기");
			int sel = sc.nextInt();
			
			if(sel == 1) { 
				list.add(new Tv(inputString("이름"), inputString("브랜드"), inputNumber("가격")));
			}else if(sel == 2) {
				list.add(inputNumber("인덱스"), new Tv(inputString("이름"), inputString("브랜드"), inputNumber("가격")));
			}else if(sel == 3) {
				list.remove(inputNumber("인덱스"));
			}else if(sel == 4) {
				delete();
			}else if(sel == 5) {
				printIdx();
			}else if(sel == 6) {
				list.set(inputNumber("인덱스"), new Tv(inputString("이름"), inputString("브랜드"), inputNumber("가격")));
			}else if(sel == 7) {
				System.out.println(list.size());
			}
			
			
		}
	}
}

public class Ex05 {

	public static void main(String[] args) {
		
		SalesManager system = new SalesManager();
		system.run();

	}

}
