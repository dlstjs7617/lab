package lv05;

public class Ex23_t {

	public static void main(String[] args) {
	
		String[][] student = {
				{ "bbb", "강남", "1002"},
				{ "aaa", "신촌", "1001"},
				{ "ccc", "대치", "1003"},
				{ "ddd", "강동", "1004"}
		};
		String[][] score = {
				{"1001", "100", "20", "30"},
				{"1002", "10", "60", "60"},
				{"1003", "23", "63", "31"},
				{"1004", "45", "30", "35"}
		};
		
		// 학생 정보와 성적이 담긴 데이터 이다
		// student ==> 1.id 2.주소 3.번호
		// score==> 1.번호 2.국어 3.수학 4.영어 점수이다.
		
		// 문제 1) 전체 성적이 1등인 학생 이름 출력
		
		int max = 0;
		String hakbun = "";
		
		for(int i=0; i<score.length; i++) {
			String num = score[i][0];
			int total = 0;
			
			for(int j=1; j<score[i].length; j++) { // score[i][1], score[i][2], score[i][3]
				total += Integer.parseInt(score[i][j]);
			}
			
			if(max < total) {
				max = total;
				hakbun = num;
			}
		}
		
		// 이름 찾기
		for(int i=0; i<student.length; i++) {
			if(student[i][2].equals(hakbun))
				System.out.printf("1등 학생 %s의 성적은 %d점입니다.",student[i][0], max);
		}
	}

}
