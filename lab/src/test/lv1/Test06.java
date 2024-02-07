package test.lv1;

import java.util.Scanner;

public class Test06 {
	// 모든 문제 최상단에 다음 주석 추가 (분:초)

	// 시작 56:00
	// 종료 00:00
	// 소요 07:10
	public static void main(String[] args) {
		// 문제 6)
		// 시험점수3개를 입력받고 학점 출력
		// 조건 1) 3과목의 평균을 가지고 점수를 매긴다.
		// 조건 2) 3과목의 평균 100~90 ==> A
		// 조건 3) 3과목의 평균 89~80 ==> B
		// 조건 4) 3과목의 평균 79~70 ==> C
		// 조건 5) 69이하                    ==> 재시험
		// 추가조건) 각점수대별로 끝자리가 7점 이상은 + 가 붙는다.
		// 예) 98 ===> A+
		// 예) 89 ===> B+
		// 예) 79 ===> C+
		
		Scanner scanner =new Scanner(System.in);
		
		int math = 0;
		int eng = 0;
		int kor = 0;
		
		System.out.print("수학점수를 입력해주세요 : ");
		math = scanner.nextInt();
		System.out.print("영어점수를 입력해주세요 : ");
		eng = scanner.nextInt();
		System.out.print("국어점수를 입력해주세요 : ");
		kor = scanner.nextInt();
		
		int avg = (math + eng + kor)/3;
		if(avg >= 90 && avg <= 100) {
			if(avg%90 >=7) {
				System.out.println(avg);
				System.out.println("A+");
			}else {
				System.out.println("A");
			}
			
		}else if(avg >= 80 && avg <= 89) {
			if(avg%80 >=7) {
				System.out.println("B+");
			}else {
				System.out.println("B");
			}
			
		}else if(avg >= 70 && avg <= 79) {
			if(avg%70 >=7) {
				System.out.println("C+");
			}else {
				System.out.println("C");
			}
			
		}else if(avg <= 69) {
			System.out.println("재시험입니다.");
		}else {
			System.out.println("입력오류");
		}
	}

}
