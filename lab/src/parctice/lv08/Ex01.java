package parctice.lv08;

import java.util.Scanner;
import java.util.Vector;

class Tv{
	private String name;
	private String brand;
	private int price;
	
	public Tv(String name, String brand, int price){
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	@Override
	public String toString() {
		return String.format("%s (%s) : %d", name, brand, price);
	}
}

class SalesManager{
	
	private final int ADD = 1;
	private final int INSERT = 2;
	private final int DELETE_INDEX = 3;
	private final int DELETE_VALUE = 4;
	private final int INQUIRY = 5;
	private final int EDIT = 6;
	private final int SIZE = 7;

	private Scanner sc = new Scanner(System.in);
	
	private Vector<Tv> list;
	
	public SalesManager() {
		list =  new Vector<Tv>();
	}
	
	private int inputNumber(String message) {
		int number = -1;
		
		System.out.println(message + " : ");
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		
		return number;
	}
	
	private String inputString(String message) {
		System.out.println(message + " : ");
		return sc.next();
	}
	
	private boolean isRun() {
		return true;
	}
	
	private Tv createTv() {
		String name = inputString("제품명");
		String brand = inputString("브랜드");
		int price = inputNumber("가격");
		
		Tv tv = new Tv(name, brand, price);
		
		return tv;
	}
	
	private boolean checkIdx(int idx) {
		if(idx < 0 || idx >= list.size())
			return false;
		return true;
	}
	
	
	private void add() {
		Tv tv = createTv();
		list.add(tv);
		
		System.out.println("상품 추가완료");
	}
	
	private void insert() {
		int idx = inputNumber("삽입할 인덱스");
		
		if(!checkIdx(idx)) {
			System.err.println("유효한 위치값이 아닙니다");
			return;
		}
		
		Tv tv = createTv();
		
		list.add(idx, tv);
	}
	
	private void deleteIndex() {
		int idx = inputNumber("제거할 인덱스");
		
		if(!checkIdx(idx)) {
			System.err.println("유효한 위치값이 아닙니다");
			return;
		}
		
		list.remove(idx);
	}
	
	private int findIdx() {
		int idx = -1;
		
		String name = inputString("이름");
		String brand = inputString("브랜드");
		
		for(int i=0; i<list.size(); i++) {
			Tv tv = list.get(i);
			
			if(tv.getName().equals(name) && tv.getBrand().equals(brand)) {
				idx = i;
			}
			
		}
		
		return idx;
	}
	
	private void deleteValue() {
		
		int idx = findIdx();
		
		if(idx == -1) {
			System.err.println("일치하는 상품이 없습니다");
			return;
		}
		
		list.remove(idx);
		
	}
	
	private void inquiry() {
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	private void edit() {
		int idx = inputNumber("변경할 인덱스");
		
		if(!checkIdx(idx)) {
			System.err.println("유효한 위치값이 아닙니다");
			return;
		}
		
		Tv tv = createTv();
		
		list.insertElementAt(tv, idx);
	}
	
	private void size() {
		System.out.println(list.size());
	}
	
	private void selectMenu() {
		int select = inputNumber("메뉴 선택");
		
		if(select == ADD)
			add();
		else if(select == INSERT)
			insert();
		else if(select == DELETE_INDEX)
			deleteIndex();
		else if(select == DELETE_VALUE)
			deleteValue();
		else if(select == INQUIRY)
			inquiry();
		else if(select == EDIT)
			edit();
		else if(select == SIZE)
			size();
	}
	
	private void printMenu() {
		System.out.println("1)추가");
		System.out.println("2)삽입");
		System.out.println("3)삭제 (인덱스)");
		System.out.println("4)삭제 (값)");
		System.out.println("5)조회");
		System.out.println("6)수정");
		System.out.println("7)크기");
	}
	
	private void saleRun() {
		while(isRun()) {
			printMenu();
			selectMenu();
		}
	}
	
	public void run() {
		saleRun();
	}
}

public class Ex01 {

	public static void main(String[] args) {
		//전체 데이터 출력
		// 추가, 삽입, 삭제. 삭제값. 조회, 수정, 크기
		SalesManager system = new SalesManager();
		system.run();
	}

}
