package lv10;

import java.util.ArrayList;

// Singleton pattern (생성 패턴)
// ㄴ 단일 인스턴스를 만들기 위함

class User{
	
}

class UserManager{
	private ArrayList<User> list;
	
	
	// 1. 생성자를 노출하지 않기 
	private UserManager() {
		list = new ArrayList<User>();
	}
		
	// 2. 유일한 객체 생성
	private static UserManager instance = new UserManager();
	
	// 3. 유일한 객체를 반환하는 getter
	public static UserManager getInstance() {
		return instance;
	}
	
	
}

public class Ex02 {

	public static void main(String[] args) {
//		UserManager manager1 = new UserManager(); // 리스트 1개 생성
//		UserManager manager2 = new UserManager(); // 리스트 1개 생성
//		UserManager manager3 = new UserManager(); // 리스트 1개 생성
		
		UserManager manager = UserManager.getInstance();
	}

}
