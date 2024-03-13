package lv08;

import java.util.Scanner;

class MyArrayList{
	
	private int size;
	private int[] list;
	
	// public boolean add(?){}
	public boolean add(Integer number) {
		arrPlus(number);
		return true;
	}
	// public void add(?){}
	public void add(Integer index, Integer number) {
		insertArrays(index, number);
	}
	// public void remove(?){}
	public void remove(int index) {
		arrMinus(index);
	}
	// public boolean remove(?){}
	public boolean remove(Integer number) {
		for(int i=0; i<size; i++) {
			if(number.equals(list[i])) {
				arrMinus(i);
				return true;
			}
		}
		return true;
	}
	
	// public boolean set(?){}
	public boolean set(Integer idx, Integer num){
		list[idx] = (int)num;
		
		return true;
	}
	// public Integer get(?){}
	public Integer get(Integer index) {
		return list[index];
	}
	// public int size(){}
	public Integer size() {
		return list.length;
	}
	
	private void arrPlus(Integer number) {
		int[] temp = list;
		list = new int[size+1];
		
		for(int i=0; i<size; i++) {
			list[i] = temp[i];
		}
		list[size] = number;
		size++;
		
	}
	
	private void arrMinus(Integer idx) {
		int[] temp = list;
		list = new int[size-1];
		
		int cnt = 0;
		for(int i=0; i<size; i++) {
			if(i != idx)
				list[cnt++] = temp[i];
		}
		
		size--;
	}
	
	private void insertArrays(Integer index, Integer number) {
		int[] temp = list;
		list = new int[size+1];
		
		for(int i=0; i<size; i++) {
			if(i < index) {
				list[i] = temp[i];
			}else if(i == index) {
				list[i] = number;
			}else if(i > index) {
				list[i] = temp[i-1];
			}
		}
		
		size++;
	}
	
	@Override
	public String toString() {
		String text = "[";
		for(int i=0; i<size; i++) {
			text += list[i];
			if(i != size-1)
				text+= ",";
		}
		text += "]";
		return text;
	}	
}

public class Ex04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		MyArrayList list = new MyArrayList();
		
		while(true) {
			System.out.println(list);
			System.out.println("1.추가 2.인덱스로삭제 3.값으로삭제 4.삽입 5.종료");
			System.out.print("메뉴 선택 :");
			
			int sel = sc.nextInt();
			
			if(sel == 1) {
				System.out.print("data :");
				list.add(sc.nextInt());
			}else if(sel == 2) {
				System.out.print("index:");
				int idx = sc.nextInt();
				
				if(idx < 0 || idx >= list.size())
					continue;
				
				list.remove(idx);
			}else if(sel == 3) {
				System.out.print("data :");
				Integer number = sc.nextInt();
				
				list.remove(number);
			}else if(sel == 4) {
				System.out.print("index");
				int idx = sc.nextInt();
				
				if(idx < 0 || idx >= list.size())
					continue;
				System.out.print("data");
				int number =sc.nextInt();
				list.add(idx , number);
			}else if(sel == 5) {
				break;
			}
			
			
		}
		
	}

}
