package lv05;

public class Ex23 {

	public static void main(String[] args) {
	
		String[][] student = {
				{ "bbb", "강남", "1002"},
				{ "aaa", "신촌", "1001"},
				{ "ccc", "대치", "1003"},
				{ "ddd", "강동", "1004"}};
		String[][] score = {
				{"1001", "100", "20", "30"},
				{"1002", "10", "60", "60"},
				{"1003", "23", "63", "31"},
				{"1004", "45", "30", "35"}};
		
		// 학생 정보와 성적이 담긴 데이터 이다
		// student ==> 1.id 2.주소 3.번호
		// score==> 1.번호 2.국어 3.수학 4.영어 점수이다.
		
		// 문제 1) 전체 성적이 1등인 학생 이름 출력
		
		String[][] total = new String[score.length][2]; 
		
		for(int i=0; i<student.length; i++) {
			int[] sum = new int[score.length];
			
			for(int j=1; j<score[i].length; j++) {
				sum[i] += Integer.parseInt(score[i][j]);
			}
			
			
			for(int j=0; j<student.length; j++) {
				if(student[i][2] == score[j][0]) {
					total[i][0] = student[i][0];
					total[i][1] = String.valueOf(sum[i]);
				}
			}
			
			
			
		}
		int max = 0;
		for(int i=0; i<total.length-1; i++) {
			if(Integer.parseInt(total[i][1]) < Integer.parseInt(total[i+1][1]))
				max= i;
			
		}
		System.out.printf("%s 학생 총점 : %s \n", total[max][0],total[max][1]);
	}

}
