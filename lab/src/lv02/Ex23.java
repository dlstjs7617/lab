package lv02;

public class Ex23 {

	public static void main(String[] args) {
		
		int n = 1;
		n = n + 1;
		n += 1;		//복함 연산자
		n++;		//단항 연산자
		++n;
		// n++		: 후위 연산
		// ++n		: 전위 연산
		
		int x = 10;
		int y = 20;
		int z = 0;
		
		// 1
		z = x++ + y;
		System.out.println(z);	//30
		// x : 11
		
		
		// 2.
		z = ++x + y++;
		System.out.println(z);	//32
		// x += 1 (12)
		// z = x + y
		// y += 1 (21)
		
		// 3.
		z = x++ + ++y;
		System.out.println(z);	//34
		// y += 1 (22)
		// z = x + y
		// x += 1 (13)
	}

}
