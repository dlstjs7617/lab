package lv05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {
	
		// 예외처리를 위한 구문
		// try-catch 문
		
		//0. Exception
		
		// 1.ArrayIndexOutOfBoundsException
		try {
			int[] arr = new int[3];
			System.out.println(arr[3]);			
		}catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.err.println("인덱스 범위 유효하지않음");
		}
		
		System.out.println("hello");
		// 2.NullPointerException
		try {
			String str = null;
			System.out.println(str.length());
		} catch (NullPointerException e) {
			System.err.println("null값 오류");
		}
		
		// 3.ArithmeticException
		try {
			System.out.println(10/0);			
		} catch (ArithmeticException e) {
			System.err.println("0으로 나눌수 없습니다");
		}
		// 4.InputMismatchException
		Scanner sc =new Scanner(System.in);
		System.out.println("num : ");
		int num = 0;
		try {
			num = sc.nextInt();			
		} catch (InputMismatchException e) {
			System.err.println("입력한 값 타입오류");
			num = 1;
		}finally {
			System.out.println("선택한 숫자 :" + num);
		}
		//5.NumberFormatException
		try {
			String number ="1234a";
			num = Integer.parseInt(number);			
		}catch (NumberFormatException e) {
			System.err.println("숫자 변환 오류");
		}
		
	}

}
