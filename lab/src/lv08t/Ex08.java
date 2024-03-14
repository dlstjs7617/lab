package lv08t;

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

class MyArrayList22<E> {
	
	private int size;
	private Object[] list;
	
	// 모든 클래스는 최상위 부모인 object에 속한다
	// ㄴ Object type은 모든 클래스부터 타입 캐스팅(형변환)이 가능함
	
	// Object : list[0]
	// E : (E) list[0];
	// add(?){}
	public boolean add(E element) {
		Object[] temp = list;
		list = new Object[size +1];
		
		for(int i=0; i<size; i++) {
			list[i] = temp[i];
		}
		list[size ++] = element;
		return true;
	}
	
	public void add(int index, E element) {
		if(index < 0 || index > size) {
			System.err.println("유효하지 않은 인덱스 범위입니다.");
			return;
		}
		
		Object[] temp = list;
		list = new Object[size+1];
		
		
		for(int i=0; i<size; i++) {
			if(i < index)
				list[i] = temp;
			else
				list[i+1] = temp[i];
		}	
		
		list[index] = element;
	}
	
	// clear(){}
	public void clear() {
		list = null;
		size = 0;
	}
	
	// contains(?){}
	public boolean contains(Object o) {
	      int index = indexOf(o);

	      return index != -1;
	   }
	
	// equals(?){}
//	public boolean equals(Object o) {
//		if(this == o)
//			return true;
//		// hint
////		MyArrayList2<E> arr = (MyArrayList2) o;
//		
//		if(arr.size() == this.size)
//			return false;
//
//		for(int i=0; i<size; i++) {
//			if(!arr.get(i).equals(this.list[i]))
//				return false;
//		}
//		
//		return true;
//	}
//	
	// get(?){}
	public E get(int index) {
		return (E)list[index];
	}
	// indexOf(?){}
	public int indexOf(Object o) {
		for(int i=0; i<size; i++) {
			if(list[i].equals(o))
				return i;
		}
		
		return -1;
	}
	// isEmpty(){}
	public boolean isEmpty() {
		return this.size == 0;
	}
	// remove(?){}
	
	public E remove(int index) {
		E obj = (E) list[index];
		
		Object[] temp = list;
		list = new Object[size -1];
		
		int n = 0;
		for(int i=0; i<size; i++) {
			if(i != index)
				list[n ++] = temp[i];
		}
		size --;
		
		return obj;
	}
	// remove(?){}
	public boolean remove(E element) {
		int index = indexOf(element);
		
		remove(index);
		
		return true;
	}
	// set(?){}
	public E set (int index, E element) {
		
		E temp = (E) list[index];
		
		list[index] = element;
		
		return temp;
	}
	
	// size(){}
	public int size() {
		return this.size;
	}
	
}

public class Ex08 {

//	public static void main(String[] args) {
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(1);
//		list.add(2);
//		list.add(1);
////		MyArrayList2<Integer> arr = new MyArrayList2<>();
////		arr.add(1);
////		arr.add(2);
////		arr.add(1);
////		arr.add(1);
//		
//		System.out.println(list.equals(arr));
//	}

}
