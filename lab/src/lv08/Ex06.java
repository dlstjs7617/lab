package lv08;

import java.util.Scanner;

class Tv2{
	
	private String name;
	private String brand;
	private Integer price;
	
	public String getName() {
		return name;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	public Tv2(String name, String brand, Integer price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	
	@Override
	public String toString() {
	
		return String.format("이름:%s  브랜드: %s  가격 :%d", name, brand, price);
	}
}

class MyVector {
	
    private int size;
    private Tv2[] list;
    
    public boolean add(Tv2 inputList) {
    	Tv2[] temp = list;
    	list = new Tv2[size +1];
    	
    	for(int i=0; i<size; i++) {
    		list[i] = temp[i];
    	}
    	
    	list[size++] = inputList;
    	
    	return true;
    }
    public void add(int index, Tv2 inputList) {
    	Tv2[] temp = list;
    	list = new Tv2[size+1];
    	
    	for(int i=0; i<size; i++) {
    		if(i < index) {
    			list[i] = temp[i];
    		}else {
    			list[i+1] = temp[i];
    		}
    	}
    	
    	list[index] = inputList;
    	size ++;
    }

    public Tv2 remove(Tv2 inputList) {
		int idx = -1;
		for(int i=0; i<size; i++) {
			if(inputList.getName().equals(list[i].getName()) &&
					inputList.getBrand().equals(list[i].getBrand()) &&
					inputList.getPrice().equals(list[i].getPrice()))
				idx = i;
		}
		
		if(idx == -1) {
			System.err.println("유효하지않은 값");
		}
		
		Tv2[] temp = list;
		list = new Tv2[size-1];
		
		int cnt = 0;
		for(int i=0; i<size; i++) {
			if(i != idx)
				list[cnt++] = temp[i];
		}
		size --;
		
		return inputList;
	}

    public boolean remove(int index) {
		Tv2[] temp = list;
		list = new Tv2[size-1];
		
		int cnt = 0;
		for(int i=0; i<size; i++) {
			if(i != index)
				list[cnt++] = temp[i];
		}
		size --;
		
		return true;
	}
		
    public boolean set(int index, Tv2 inputList) {
		list[index] = inputList;
		
		return true;
	}

    public Tv2 get(int index) {
		return list[index];
	}

    public int size() {
		return size;
	}

}

class SalesManager2 {

	private Scanner sc = new Scanner(System.in);
	
    private MyVector list = new MyVector();
    
    public void printAll() {
    	for(int i=0; i<list.size(); i++) {
    		System.out.println(list.get(i));
    	}
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
    
    private String inputString(String message) {
		System.out.print(message + "입력:");
		return sc.next();
	}
    
	private Tv2 inputTv(String name, String brand, int price) {
		Tv2 list = new Tv2(name, brand, price);
		return list;
    }
    
    public void printMenu() {
		// 추가, 삽입, 삭제. 삭제값. 조회, 수정, 크기
		System.out.println("1)추가 2)삽입) 3)삭제 4)삭제값 5)조회 6)수정 7)크기");
		int sel = sc.nextInt();
		
		if(sel == 1) { 
			list.add(inputTv(inputString("이름"), inputString("브랜드"), inputNumber("가격")));
		}else if(sel == 2) {
			list.add(inputNumber("인덱스"),inputTv(inputString("이름"), inputString("브랜드"), inputNumber("가격")));
		}else if(sel == 3) {
			list.remove(inputNumber("인덱스"));
		}else if(sel == 4) {
			list.remove(inputTv(inputString("이름"), inputString("브랜드"), inputNumber("가격")));
		}else if(sel == 5) {
			int index = (inputNumber("인덱스"));
			if(index < 0 || index >= list.size()) {
	    		System.err.println("유효하지 않은 인덱스");
	    		return;
	    	}
			System.out.println(list.get(index));
		}else if(sel == 6) {
			list.set(inputNumber("인덱스"), inputTv(inputString("이름"), inputString("브랜드"), inputNumber("가격")));
		}else if(sel == 7) {
			System.out.println(list.size());
		}
		
    }
    
    public void run() {
    	while(true) {
    		printAll();
    		printMenu();
    	}
    }
}

public class Ex06 {

	public static void main(String[] args) {
		SalesManager2 list = new SalesManager2();
		list.run();

	}

}
