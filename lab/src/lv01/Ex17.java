package lv01;

import java.util.Scanner;

public class Ex17 {

	public static void main(String[] args) {
		//로그인 처리[1단계]
		
		// 사용자는 데이터베이스에 저장된 아이디와 비밀번호를 입력하여
		// 두 개의 값이 모두 일치하면
		// "로그인 성공" 을 출력
		// 두 개의 값이 하나라도 일치하지 않으면
		// "회원정보가 일치하지 않습니다" 를 출력
		
		
		int dbId = 1111;
		int dpPw = 1212;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 입력 : ");
		int userId = sc.nextInt();
		System.out.print("비밀번호 입력 : ");
		int userPw = sc.nextInt();
		
		if(userId == dbId && userPw == dpPw) {
			System.out.println("로그인 성공");
		}
		if(!(userId == dbId && userPw == dpPw)) {
			System.out.println("회원 정보가 일치하지 않습니다.");
		}
		
		//if(userId != dbId || userPw != dpPw) {
		//	System.out.println("회원 정보가 일치하지 않습니다.");
		//}
	}

}
