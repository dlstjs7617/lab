package study;

public class Ex02 {

	public static void main(String[] args) {
		// 예) 현금이 1000원있다. 200원짜리 과자 구입 후, 잔돈 출력
				int 현금 = 1000;
				int 과자 = 200;
				int 잔돈 = 현금 - 과자;
				System.out.println("잔돈 = " + 잔돈 + "원");

				// 문제1) 월급이 100원이다. 연봉은? (조건 : 세금 10% 제외)
				int pay = 100;
				int salary = (int)(pay*12*0.9);
				System.out.println(salary);
				// 문제2) 시험점수를 30, 50, 4점 을 받았다. 평균은?
				int num1 = 30;
				int num2 = 50;
				int num3 = 4;
				int svg = (num1+num2+num3)/3;
				System.out.println(svg);
				// 문제3) 가로가 3이고 세로가 6인 삼각형 넓이 출력
				int height = 6;
				int weight = 3;
				int area = height*weight/2;
				System.out.println(area);
				// 문제4) 100초를 1분 40초로 출력
				int min = 100/60;
				int sec = 100%60;
				System.out.println(min +"분 " + sec +"초");
				// 문제5) 800원에서 500원짜리 개수 , 100원짜리 개수
				int coin500 = 800/500;
				int coin100 = 800%500/100;
				System.out.println("500원 ("+ coin500 + ")개,  100원(" + coin100 +")개");
				// 정답5) 500원(1개), 100원(3개)
	}

}
