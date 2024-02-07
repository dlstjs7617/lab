package test.lv2;

public class Test05 {
	//시작 12:20:00
	//종료 15:33:00
	//소요 	 93:00
	public static void main(String[] args) {
		
		// Lv02 테스트
		
		// 문제5
		// 증감연산자와 반복문을 사용해서 해결하세요(산술연산 문제 아님)
		// 예)
		int clap = 3;
		while(clap > 0) {
			System.out.println("짝");
			clap--;
		}
		
		System.out.println("==============문제1================");
		// -1.
		// 운주네 반 학생은 31명입니다.
		// 이중에서 남학생은 12명, 여학생은 14명이 봉사활동을 하였습니다.
		// 은주네 반에서 봉사활동을 하지않은 학생은
		// 몇명인지 출력
		
		int student = 31;
		int boy = 12;
		int girl = 14;
		for(int i=0; i<boy; i++) {
			student--;
		}
		for(int i=0; i<girl; i++) {
			student--;
		}
		System.out.println("봉사활동 하지않은 학생수 : " + student);
		
		System.out.println("==============문제2================");
		// -2.
		// 연필 7타를 여학생 2명과 남학생 3명에게 똑같이 나누어 주었을때
		// 한사람은 연필을 몇자루 가지게 되는 지 출력(연필 1타는 12자루)
		int pen = 84;
		int count =0;
		boy = 2;
		girl = 3;
		while(pen > 0) {
			for(int i=0; i<boy; i++) {
				pen--;
			}
			for(int j=0; j<girl; j++) {
				pen--;
			}
			if(pen<0) {
				break;
			}
			count++;			
		}
		System.out.println("한사람이 가지는 수 : " + count);	
				
		System.out.println("==============문제3================");
		// -3.
		// 어느 공장에서 한사람이 1시간에 컴퓨터 4대를 조립할수 있다고한다.
		// 3명이 컴퓨터 95대를 조립하면 몇시간이 걸리는가
		int hour = 0;
		count = 0;
		while(count < 95) {
			for(int i=3; i>0; i--) {
				for(int j=4; j>0; j--) {
					count++;
				}
			}
			hour++;
		}
		System.out.println("시간 : " + hour + "시간");
		System.out.println("==============문제4================");
		// -4.
		// 귤 6개의 무게는 840g, 사과 3개의 무게는 750g 입니다.
		// 귤5개와 사과 4개의 무게는 몇g인지 출력 (단 각각의 귤끼리 무게는 같고 각각의 사과끼리는 무게가 같다.)
		
		int mandarin6 = 840;
		int apple3 = 750;
		
		int mandarin = 0;
		int apple = 0;
		
		int mandarin5 = 0;
		int apple4 = 0;
		
		for(int i=840; i>0;) {
			for(int j=6; j>0; j--) {
				i--;
			}
			mandarin++;
			
		}
		for(int x=1; x<=5; x++) {
			for(int y=0; y<mandarin; y++) {
				mandarin5++;
			}
		}
		for(int i=750; i>0;) {
			for(int j=3; j>0; j--) {
				i--;
			}
			apple++;
		}
		for(int x=1; x<=4; x++) {
			for(int y=0; y<apple; y++) {
				apple4++;
			}
		}
		System.out.printf("귤 5개 : %dg 사과3개 : %dg",mandarin5,apple4);
	}

}
