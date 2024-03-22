package lv10t;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

// 클래스 : 객체를 만들기위한 설계도(정의서)
// 생성자 : 호출하면 -> 객체가 만들어짐

class MyTimer{
	// 기본 생성자
	private SimpleDateFormat sdf;
	private MyTimer() {
		sdf = new SimpleDateFormat("kk시 mm:ss초");
	}
	
	//클래스 내부에서 객체 생성 (생성자 호출)
	private static MyTimer instance = new MyTimer();
	// getter 제공
	public static MyTimer getInstance() {
		return instance;
	}
	
	public void run(int second) {
		while(second > 0) {
			// 00시 00:00초 (00초)
			Calendar calendar = Calendar.getInstance();
//			System.out.println(sdf.format(calendar.getTime()));
//			System.out.println(sdf.format(calendar.getTimeInMillis()));
//			System.out.println(sdf.format(System.currentTimeMillis()));
			String message = sdf.format(calendar.getTimeInMillis());
			message += String.format("(%d)", second);
			System.out.println(message);
			second --;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
		System.out.println("TIME OUT!");
	}
	
}

public class Ex03 {
	
	public static int makeSecond() {
		int second = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("분 :");
		second += sc.nextInt() * 60;
		System.out.print("초 :");
		second += sc.nextInt();
		
		return second;
	}
	
	public static void main(String[] args) {

		// 타이머 만들기
		// ㄴ 싱글톤 패턴으로 단일 인스턴스 구현
		// ㄴ Calendar 활용, 시간 정보 표기
		
		MyTimer timer = MyTimer.getInstance();
		timer.run(makeSecond());

	}

}
