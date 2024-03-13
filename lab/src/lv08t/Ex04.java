package lv08t;

import java.util.Arrays;

class MyArrayList{
	
	private int size;
	private Integer list[];
	
	public boolean add(Integer element){
		Integer[] temp = list;
		list = new Integer[size +1];
		
		for(int i=0; i<size; i++) {
			list[i] = temp[i];;
		}
		
		list[size ++] = element;  
	
		return true;
	}
	
	 public void add(int index, Integer element){
		 Integer[] temp = list;
		 list = new Integer[size+1];
		 
		 for(int i=0; i<size; i++) {
			 if(i < index)
				 list[i] = temp[i];
			 else
				 list[i+1] = temp[i];
		 }
		 
		 list[index] = element;
		 size++;	
	 }
	 public Integer remove(int index){
		 Integer element = null;
		 element = list[index];
		 
		 Integer[] temp = list;
		 list = new Integer[size-1];
		 
		 int n=0;
		 for(int i=0; i<size; i++) {
			 if(!list[i].equals(element))
				 list[n ++] = temp[i];
		 }
		 
		 size --;
		 
		 return element;
	 }
	 public boolean remove(Integer element){
		 int index = -1;
		 for(int i=0; i<size; i++) {
			 if(list[i].equals(element)) {
				 index = i;
			 }
		 }
		 
		 if(index ==-1)
			 return false;
		 
		 remove(index);
		 return true;
		 
	 }
	 public boolean set(int index, Integer element){
		 list[index] = element;
		 return true;
	 }
	 public Integer get(int index){
		 Integer element = null;
		 element = list[index];
		 return element;
	 }
	 
	 public int size(){
		 return this.size;
	 }
	
	@Override
	public String toString() {
		return Arrays.toString(this.list); 
	}
}

public class Ex04 {

	public static void main(String[] args) {
		
		MyArrayList list = new MyArrayList();
		
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(1);
		
		System.out.println(list);
		
		for(int i=0; i<list.size(); i++	) {
			System.out.println(System.identityHashCode(list.get(i)));
		}
	}

}
