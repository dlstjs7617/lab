package lv10;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

// 객체 지향 -> Java Library 활용 & 패턴

// 텍스트 형식 활용
// ㄴ DecimalFormat
// ㄴ SimpleDateFormat

public class Ex01 {

	public static void main(String[] args) {
		
		// 숫자 출력하기
		DecimalFormat dcf = new DecimalFormat("#,###원");
		System.out.println(dcf.format(1000000000));
		// 날짜 출력하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일, hh:mm:ss.S");
		
		Date today = new Date();
		System.out.println(sdf.format(today));
		System.out.println(today.getYear());
		System.out.println(today.getMonth());
		System.out.println(today.getDate());
		System.out.println(today.getDay());
		System.out.println(today.getHours());
		System.out.println(today.getTime());
		
		System.out.println(System.currentTimeMillis());
		long now =System.currentTimeMillis();
		System.out.println(sdf.format(now));
		// Date -> Calendar
//		Calendar calendar = new Calendar(); 		// 불가
		Calendar calendar = Calendar.getInstance(); // 단일 인스턴스 얻기
													// Singleton Pattern 으로 구현됨
													// ㄴ GoF -> Design Pattern 설계 패턴을 소개
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));
		System.out.println(calendar.get(Calendar.HOUR));
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println(calendar.get(Calendar.MINUTE)+ "Asdasdad");
		System.out.println(calendar.get(Calendar.SECOND));
		System.out.println(calendar.get(Calendar.MILLISECOND));
	}

}
