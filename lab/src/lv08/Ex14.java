package lv08;

public class Ex14 {

	public static void main(String[] args) {
		// Static
		// ㄴ 메소드와 메소드안에서 참조되는 변수들까지 -> 메모리 영역을 static으로 지정하여 해결
		
		String userdata = "1001/pw1/김철수\n";
		userdata += "1002/pw2/이영희\n";
		userdata += "1003/pw3/신민수\n";
		userdata += "1004/pw4/최상민";
		
		String accountdata = "1001/1111-1111-1111/8000\n";
		accountdata += "1002/2222-2222-2222/5000\n";
		accountdata += "1001/3333-3333-3333/11000\n";
		accountdata += "1003/4444-4444-4444/9000\n";
		accountdata += "1001/5555-5555-5555/5400\n";
		accountdata += "1002/6666-6666-6666/1000\n";
		accountdata += "1003/7777-7777-7777/1000\n";
		accountdata += "1004/8888-8888-8888/1000";
		
		// 1)test01 김철수 는 계좌를 3개 가지고 있다.
		// 1)test02 이영희 는 계좌를 2개 가지고 있다.
		// 1)test03 신민수 는 계좌를 2개 가지고 있다.
		// 1)test04 최상민 는 계좌를 1개 가지고 있다.
		
		UserManager.dataSetting(userdata);
		AccountManager.dataSetting(accountdata);
		
		Bank system = new Bank("MEGA");
		system.run();
		
	}

}
