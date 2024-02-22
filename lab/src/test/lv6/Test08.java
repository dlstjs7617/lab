package test.lv6;

import java.util.Arrays;
import java.util.Scanner;

//시작 16:02
//종료 16:15
//소요 00:13

public class Test08 {
	
	public int[] solution(String[] shirtSize) {
		Scanner sc = new Scanner(System.in);
		String[] shirtSizeArr = {"XS","S","M","L","XL","XXL"};
		
		int[] answer = {};
		
		answer = new int[shirtSizeArr.length];
		
		for(int i=0; i<shirtSize.length; i++) {
			for(int j=0; j<shirtSizeArr.length; j++) {
				if(shirtSizeArr[j].equals(shirtSize[i])) {
					answer[j]++;
				}
			}
		}
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		Test08 sol = new Test08();
		
		
		String[] shirtSize = {"XS","S","L","L","XL","S",};
		int[] ret = sol.solution(shirtSize);
		
		System.out.println("답 : " + Arrays.toString(ret) + " .");
	}
}
