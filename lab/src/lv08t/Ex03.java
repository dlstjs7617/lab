package lv08t;

public class Ex03 {

	public static void main(String[] args) {

		// String Pool
		String str1 = "이인선";
		String str2 = "이인선";
		
		System.out.println(str1 == str2);
		
		String str3 = new String("이인선");
		
		System.out.println(str1 == str3);
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		
		// Integer Pool
		// ㄴ -128 ~ +127
		
		Integer num1 = 127;
		Integer num2 = 127;
		
		System.out.println(num1 == num2);
		
		Integer num3 = 128;
		Integer num4 = 128;
		Integer num5 = 127;

		System.out.println(num3 == num4);
		
		System.out.println(System.identityHashCode(num1));
		System.out.println(System.identityHashCode(num2));
		System.out.println(System.identityHashCode(num3));
		System.out.println(System.identityHashCode(num4));
		System.out.println(System.identityHashCode(num5));
	}

}
