package test.lv5;

public class test05 {
	//시작 15:10
	//종료 15:19
	//소요 00:09
	public static void main(String[] args) {
		String [][] student = {
				{"aaa","신촌","1001"}, 
				{"bbb","강남","1002" },
				{"ccc" ,"대치", "1003"} ,
				{"ddd" , "강동","1004"}};
		
		String[][] score = {
				{"번호" ,"과목" , "점수"},
				{"1001" ,"국어","20"},
				{"1002" ,"국어","50"},
				{"1003" ,"국어","60"},
				{"1004" ,"국어","17"},
				{"1001" ,"수학","65"},
				{"1002" ,"수학","15"},
				{"1003" ,"수학","80"},
				{"1004" ,"수학","70"},
				{"1001" ,"영어","43"},
				{"1002" ,"영어","90"},
				{"1003" ,"영어","30"},
				{"1004" ,"영어","70"}
		};
		
		// 학생 정보와 성적이 담긴 데이터 이다
		// student ==> 1.id 2.주소 3.번호
		// score ==> 1.번호 2.국어 3.수학 4.영어 점수이다
		// 문제1) 전체성적이 1등인 학생 출력
		
		int max = 0;
		int idx = 0;
		for(int i=0; i<student.length; i++) {
			int temp = 0; 
			
			for(int j=1; j<score.length; j++) {
				if(student[i][2] == score[j][0]) {
					temp += Integer.parseInt(score[j][2]);
				}
			}
			if(temp> max) {
				max = temp;
				idx = i;
			}
			
		}
		
		System.out.printf("1등 학생 %s",student[idx][0]);

	}

}
