package lv08t;

import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

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

	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return String.format("%s [%s] : %d", name, brand, price);
	}
	
}

class SalesManager{
	
	private final int ADD = 1;
	private final int INSERT = 2;
	private final int DELETE = 3;
	private final int DELETE_BY_VALUE = 4;
	private final int SEARCH = 5;
	private final int UPDATE = 6;
	private final int SIZE = 7;
	
	private Scanner sc;
	
	private Vector<Tv> list = new Vector<Tv>();
	
	public SalesManager() {
		this.sc = new Scanner(System.in);
		this.list = new Vector<Tv>();
	}
	
	private void printDataAll() {
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
	}
	
	private int inputNumber(String message) {
		int number = 0;
		System.out.print(message + ":");
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
	
	private Tv createTv() {
		String name = inputString("name");
		String brand = inputString("brand");
		int price = inputNumber("price");

		Tv tv = new Tv(name, brand, price);
		
		return tv;
	}
	
	private void add() {
		
		Tv tv = createTv();
		
		list.add(tv);
	}
	
	private void insert() {
		int index = inputNumber("index");
		
		Tv tv = createTv();
		
		if(index < 0 || index >= list.size())
			return;
		
		list.add(index, tv);
	}
	
	private void deleteByIndex() {
		int index = inputNumber("index");
		
		list.remove(index);
	}
	
	private void deleteByValue() {
		Tv target = searchTvByDatas();
		
		if(target != null)
			list.remove(target);
	}
	
	private Tv searchTvByDatas() {
		Tv target = null;
		
		String name = inputString("name");
		String brand = inputString("brand");
		int price = inputNumber("price");
		
		for(int i=0; i<list.size(); i++) {
			Tv tv = list.get(i);
			
			if(tv.getName().equals(name) 
				&& tv.getBrand().equals(brand) 
				&& tv.getPrice() == price)
				target = tv;
		}
		
		return target;
	}
	
	private void search() {
		Tv tv = searchTvByDatas();
		
		if(tv != null) {
			System.out.println(tv);
		}
		
	}
	
	private void update() {
		int index = inputNumber("index");
		Tv tv = createTv();
		
		if(index < 0 || index >= list.size())
			return;
		
		list.set(index, tv);
	}
	
	private void printSize() {
		System.out.println("size : " + list.size());
	}

	private void runMenu(int select) {
		if(select == ADD)
			add();
		else if(select == INSERT)
			insert();
		else if(select == DELETE)
			deleteByIndex();
		else if(select == DELETE_BY_VALUE)
			deleteByValue();
		else if(select == SEARCH)
			search();
		else if(select == UPDATE)
			update();
		else if(select == SIZE)
			printSize();
	}
	
	public void run() {
		while(true) {
			//전체 데이터 출력
			printDataAll();
			int select = inputNumber("메뉴");
			runMenu(select);
			// 추가, 삽입, 삭제. 삭제값. 조회, 수정, 크기
			System.out.println("1)추가 2)삽입) 3)삭제 4)삭제값 5)조회 6)수정 7)크기");
		
		}
	}
}

public class Ex05 {

	public static void main(String[] args) {
		
		SalesManager system = new SalesManager();
		system.run();

	}

}
