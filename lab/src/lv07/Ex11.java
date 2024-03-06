package lv07;

import java.util.Arrays;


// Wrapper class 포함하여 정의하기

class Member{
	private String name;
	private int code;
	private int point;
	private boolean best;
	
	public Member(int code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	public void setPlusPoint(int point) {
		this.point += point;
	}
	
	public void setBest(boolean best) {
		this.best = best;
	}
	
	@Override
	public String toString() {
		return String.format("이름 : %s 사원번호 :  %d 실적 : %d  우수사원여부 : %s", name, code, point, best == true ? "우수사원" : "일반사원");
	}
	
}

public class Ex11 {

	public static void main(String[] args) {
		String data1 = "1001/3,1002/1,1001/3,1003/5,1004/1,1002/2";
		String data2 = "1001/손창우,1002/김경현,1003/김민기,1004/김선영";
		
		// data1 은 사원번호와 판매실적이다.
		// data2 는 사원번호와 이름이다.
		
		// 판매실적이 4이상인 사원은 우수 사원으로 분류한다.
		
		// 위 데이터를 파싱 해서 Member클래스 배열을 완성후
		// 실적 내림차순으로 정렬하여 출력해보세요. (우수 사원은 BEST 붙여주기)
		Member[] memberList = null;
		
		String[] codeAndPoint = data1.split("/|,");
		String[] codeAndName = data2.split("/|,");

		int size = codeAndName.length/2;
		memberList = new Member[size];
		// 멤버생성
		for(int i=0; i<codeAndName.length; i+=2) {
			memberList[i/2] = new Member(Integer.parseInt(codeAndName[i]), codeAndName[i+1]);
		}
		// 실적추가
		for(int i=0; i<codeAndPoint.length; i+=2) {
			for(int j=0; j<size; j++) {
				if(Integer.parseInt(codeAndPoint[i]) == memberList[j].getCode() 
						&& memberList[j].getCode() == 0)
					memberList[j].setPoint(Integer.parseInt(codeAndPoint[i+1]));
				else if (Integer.parseInt(codeAndPoint[i]) == memberList[j].getCode() 
						&& memberList[j].getCode() != 0)
					memberList[j].setPlusPoint(Integer.parseInt(codeAndPoint[i+1]));				
			}
		}
		
		// 베스트설정
		int max = 0;
		for(int i=0; i<size; i++) {
			if(memberList[max].getPoint() < memberList[i].getPoint())
				max = i;
		}
		memberList[max].setBest(true);

		// 정렬
		for(int i=0; i<size; i++) {
			max = i;
			for(int j=i; j<size; j++) {
				if(memberList[max].getPoint() < memberList[j].getPoint()) {
					max = j;
				}
			}
			
			Member temp = memberList[i];
			memberList[i] = memberList[max];
			memberList[max] = temp;
		}
		
		//출력
		for(int i=0; i<size; i++) {
			System.out.println(memberList[i]);
		}
	
	}

}
