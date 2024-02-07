package lv01;

public class Ex07 {

	public static void main(String[] args) {
		
		
		// 예) 현금이 1000원 있다. 200원짜리 과자 구입 후, 잔돈 출력
		int 현금 = 1000;
		int 과자 = 200;
		int 잔돈 = 현금 - 과자;
		System.out.println("잔돈 = " + 잔돈 + "원");
		
		// 문제1) 월급이 100원이다. 연봉은? (조건 : 세금 10%제외)
		int monthlyPay = 100;
		double salary = (monthlyPay*0.9*12); 
		System.out.println("연봉은 " + salary + "원");
		
		// 문제2) 시험점수를 30,50,4점을 받았다. 평균은?
		int score1 = 30;
		int	score2 = 50;
		int score3 = 4;
		int avg = (score1+score2+score3)/3;
		System.out.println("평균은 = " +avg);
		
		// 문제3) 가로가 3이고 세로가 6인 삼각형 넓이 출력
		int height = 6;
		int	width = 3;
		int area = height * width / 2;
		System.out.println("삼각형의 넓이는 = " + area);
		
		// 문제4) 100초를 1분 40초로 출력
		int ex = 100;
		int	min = ex/60;
		int sec = ex%60;
		System.out.println("100초는 " + min + "분" + sec +"초 이다");
		
		// 문제5) 800원에서 500원짜리 개수, 100원짜리 개수
		int cash = 800;
		int coin500 = cash/500;
		int	coin100 = (cash/500)%100;
		System.out.println("500원 "  + coin500 + "개\n100원 " + coin100 + "개");
		// 정답5) 500(1개), 100원(3개)
	}
}
