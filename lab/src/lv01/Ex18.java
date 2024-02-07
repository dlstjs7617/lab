package lv01;

import java.util.Scanner;

public class Ex18 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 로그인 처리[3단계]

		// 사용자는 데이터베이스에 저장된 아이디만 "입력"하여
		// 아이디가 일치하지 않으면 -> "존재하지 않는 회원 입니다"를 출력
		// 아이디가 일치하면 -> 패스워드를 입력받음
		// 패스워드가 일치하면
		// "로그인 성공" 을 출력
		// 패스워드가 일치하지 않으면
		// "비밀번호가 일치하지 않습니다" 를출력

		int dbId = 1111;
		int dbPw = 1212;

		int id;
		int pw;

		System.out.print("아이디 입력 :");
		id = sc.nextInt();

		if (id != dbId) {
			System.out.println("존재하지 않는 회원입니다.");
		}

		if (id == dbId) {
			System.out.print("비밀번호 입력 : ");
			pw = sc.nextInt();
			
			if (id == dbId && pw == dbPw) {
				System.out.println("로그인 성공");
			}

			if (id == dbId && pw != dbPw) {
				System.out.println("비밀번호가 일치하지 않습니다");
			}
		}
	}

}
