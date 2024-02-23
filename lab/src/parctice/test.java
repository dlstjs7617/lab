package parctice;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		String block = "";
		block += "2,2,2,2";
		block += "\n0,2,2,0";
		String[] arr = block.split(",");
		System.out.println(Arrays.toString(arr));
		System.out.println(arr.length);
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i].contains("\n")) {
				System.out.println("index"+i);
				System.out.println("찾음");
			}
		}
	}

}
