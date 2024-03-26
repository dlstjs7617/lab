package mod2;

import mod1.Parents;

public class Child extends Parents{
	
	void func() {
		System.out.println(a);
//		System.out.println(b);	// 부모와 서로 다른 패키지인 경우 참조 X
		System.out.println(c);	// 서로 다른 패키지이더라고 참조가 가능하게 O
//		System.out.println(d);	
	}
}
