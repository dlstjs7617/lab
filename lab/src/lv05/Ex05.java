package lv05;

import java.util.Arrays;

public class Ex05 {

	public static void main(String[] args) {
	
		//문제) 이름은 name배열에 성적은 score배열에 각각 저장 및 출력
		String str = "김철/87,이만수/42,이영희/100";
			
		String[] name = new String[3];
		int[] score = new int[3];
		String[] temp = str.split(",");
		String str2 = "";
		int cnt = 0;
		
		for(int i=0; i<temp.length; i++)
			str2 += temp[i]+"/";
		
		str2 = str2.substring(0,str2.length()-1);
		temp = str2.split("/");
		
		for(int i=0; i<temp.length; i+=2) {
			name[cnt] = temp[i];
			score[cnt] = Integer.parseInt(temp[i+1]);
			cnt++;
		}
		
		System.out.println(str2);
		System.out.println(Arrays.toString(temp));
		
		
		
		
		System.out.println(Arrays.toString(score));
		System.out.println(Arrays.toString(name));
		
		
	}

}
