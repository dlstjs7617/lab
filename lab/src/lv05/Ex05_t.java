package lv05;

import java.util.Arrays;

public class Ex05_t {

	public static void main(String[] args) {
	
		//문제) 이름은 name배열에 성적은 score배열에 각각 저장 및 출력
		String str = "김철/87,이만수/42,이영희/100";
			
		String[] name = new String[3];
		int[] score = new int[3];
		
		//풀이 2.
		// {"김철","87","이만수","42","이영희","100"}
		// regex : Regular Expression 정규(표현)식
		
		String[] result =str.split("[/|,]");
		System.out.println(Arrays.toString(result));
		
		for(int i=0; i<name.length; i++) {
			name[i] = result[i*2];
			score[i] = Integer.parseInt(result[i*2+1]);
		}
		
		
		
		// 풀이1
//		String[] result = str.split(",");
//		// {"김철/87","이만수/42","이영희/100"}
//		
//		for(int i=0; i<result.length; i++) {
//			String[] info = result[i].split("/");
//			name[i] = info[0];
//			score[i] = Integer.parseInt(info[1]);
//		}
//		
//		
//		System.out.println(Arrays.toString(name));
//		System.out.println(Arrays.toString(score));
//		
		
	}

}
