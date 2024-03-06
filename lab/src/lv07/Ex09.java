package lv07;

class Employee{
	// private fields
	
	private String name;
	private int performance;
	
	// constructor
	Employee(String name, int performance){
		this.name = name;
		this.performance = performance;
	}
	
	// method : getter & setter
	public String getName() {
		return name;
	}

	public int getPerformance() {
		return performance;
	}
	
	// method : other
	@Override
	public String toString() {
		String text = "";
		text += "이름 : " + this.name + "\n";
		text += "실적 : " + this.performance;
		
		return text;
	}
}


public class Ex09 {

	public static void main(String[] args) {
		
		int size;
		
		String data = "3\n";
		data += "김영희/30\n";
		data += "이만수/40\n";
		data += "이철민/60\n";
		
		System.out.println(data);
		
		Employee[] group;
		
		
		//문제 1) data에 있는 내용을 잘라서 group에 저장후 출력
		System.out.println("=================문제1=================");		
		String[] dataArr = data.split("/|\n");
		
		size = Integer.parseInt(dataArr[0]);
		group = new Employee[size];
		
		int index = 0;
		for(int i=1; i<size*2+1; i+=2) {
			group[index++] = new Employee(dataArr[i], Integer.parseInt(dataArr[i+1]));
		}
		
		for(int i=0; i<size; i++) {
			System.out.println(group[i]);			
		}
		System.out.println("======================================");		
		
		//문제2) 실적 꼴등 삭제후 다시 data에 저장
		
		System.out.println("=================문제2=================");
		index = 0;
		for(int i=0; i<size; i++) {
			if(group[i].getPerformance() < group[index].getPerformance())
				index = i;
		}
		
		data = null;
		data = size-1 + "\n";
		for(int i=0; i<size; i++) {
			if(i != index)
				data += group[i].getName() + "/" + group[i].getPerformance() + "\n";
		}
		size--;
		
		System.out.println(data);
		System.out.println("======================================");
		/*
		 *  2
		 *  이만수/40
		 *  이철민/60
		 */
	}

}
