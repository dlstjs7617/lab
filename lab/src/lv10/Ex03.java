package lv10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class MyTimer{
	
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

	private static MyTimer instance = new MyTimer();
	
	public static MyTimer getInstance() {
		return instance;
		
	}
	
	public void run(int second) {
		System.out.printf("입력된 시간 %d초 \n", second);
		while(second>0) {
			Calendar calendar = Calendar.getInstance();
			Date today = calendar.getTime();
			
			System.out.println(sdf.format(today) + " (" + second--  + ")");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
		System.out.println("타임아웃!!!!!!!!!!!");
	}
	
}

public class Ex03 {

	public static void main(String[] args) {
		
		// 타이머 만들기
		// ㄴ 싱글톤 패턴으로 단일 인스턴스 구현
		// ㄴ Calendar 활용, 시간 정보 표기
		
		MyTimer timer = MyTimer.getInstance();
		timer.run(10);

	}

}
