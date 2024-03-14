package lv08;

import java.util.ArrayList;

// Generic 제네릭<> 클래스
// ㄴ 다루는 자료형이 다르지만
// ㄴ 동일한 기능을 구현을 필요로 할 때에
// ㄴ 컴파일 단계에서 자료형 정할 수 있도록
// Type 타입의 안정을 높이는 프로그래밍 방법

// 클래스 정의
// class 클래스명 {}

// 제네릭 클래스 정의
// class 클래스명<E> {}

// E : Element
// T : Type

class MyArrayList<E> {
	
	private int size;
	private Object[] list;
	
	// 모든 클래스는 최상위 부모인 object에 속한다
	// ㄴ Object type은 모든 클래스부터 타입 캐스팅(형변환)이 가능함
	
	// Object : list[0]
	// E : (E) list[0];
	// add(?){}
	public boolean add(E element) {
		Object[] temp = list;
		list = new Object[size+1];
		
		for(Object list : temp) {
			list = temp;
		}
		
		list[size] = element;
		return true;
	}
	
	// clear(){}
	public void clear() {
		list = new Object[size];
		for(int i=0; i<size; i++) {
			list[i] = new Object();			
		}
		size = 0;
	}
	
	// contains(?){}
	public boolean contains(Object o) {
		return indexOf(o) > 0;
		
	}
	
	// equals(?){}
	public boolean equals(Object o) {
		
		//hint
		MyArrayList<E> arr =(MyArrayList) o;
		ArrayList<E> arrayList;
		for(int i=0; i<size; i++) {
			if(list[i].equals(o)) {
				return true;
			}
			
		}
		return false;
	}
	
	// get(?){}
	public Object get(int index) {
		return list[index];
	}
	// indexOf(?){}
	public int indexOf(Object o) {
		int index = -1;
		for(int i=0; i<size; i++)
			if(list.equals(o))
				index = i;
		
		return index;
	}
	// isEmpty(){}
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}
	// remove(?){}
	
	public Integer remove(int index) {
		Object[] temp = list;
		list = new Object[size-1];
		
		if(index < 0 || index >= size)
			return -1;
		
		int cnt = 0;
		for(int i=0; i<size; i++) {
			if(i != index)
				list[cnt++] = temp[i];
		}
		size--;
		
		return index;
	}
	// remove(?){}
//	public boolean remove(Object o) {
//		for(int i=0;)
//		Object[] temp = list;
//		
//		list = new Object[size-1];
//		
//		
//		
//	}
	// set(?){}
	// size(){}
	
}

public class Ex08 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.clear();
		list.contains(list);
		list.remove(list);
		MyArrayList<Integer> myList = new MyArrayList<>();

	}

}
