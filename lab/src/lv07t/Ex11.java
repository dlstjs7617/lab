package lv07t;

import java.util.Arrays;

// Wrapper class 포함하여 정의하기

class Member{
	private Integer code;		// null
	private Integer point;		// null
	private String name;		// null
	private Boolean isBest;		// null
	
	public Member(Integer code , String name) {
		this.code = code;
		this.name = name;
		this.point = 0;
		this.isBest = false;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Boolean getIsBest() {
		return isBest;
	}

	public void setIsBest(Boolean isBest) {
		this.isBest = isBest;
	}

	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return String.format("%d) %s 사원 : \t%2d  <<< %s", code, name, point, isBest == true ? "BEST" : "");
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
		// 실적 내림차순으로 정렬하여 출력해보세요.
		String[] temp = data2.split(",");
		int size = temp.length;
		
		Member[] memberList = null;
		memberList = new Member[size];
		for(int i=0; i<size; i++) {
			String[] info = temp[i].split("/");
			
			Integer code = Integer.parseInt(info[0]);
			String name = info[1];
			
			memberList[i] = new Member(code, name);
		}
		
		// 실적 정리
		temp = data1.split(",");
		
		for(int i=0; i<temp.length; i++) {
			String[] info = temp[i].split("/");
			
			Integer code = Integer.parseInt(info[0]);
			Integer point = Integer.parseInt(info[1]);
			
			for(int j=0; j<size; j++) {
				Member member = memberList[j];
				
				// 객체를 == 연산으로 비교를 하면 -> 인스턴스를 비교하게 됨
				if(member.getCode().toString().equals(code.toString()))
//				if((int) member.getCode() == (int) code)
					member.setPoint(member.getPoint() + point);
					
				if(member.getPoint() >= 4)
					member.setIsBest(true);
						
			}
		}
		
		// 내림차순 정렬
		for(int i=0; i<size; i++) {
			Member member = memberList[i];
			int idx = i;
			
			for(int j=i; j<size; j++) {
				Member target = memberList[j];
				
				if(member.getPoint() < target.getPoint()) {
					member = target;
					idx = j;
				}
			}
			
			if(idx != i) {
				memberList[idx] = memberList[i];
				memberList[i] = member;
			}
			
		}
		
		// 출력
		for(int i=0; i<size; i++)
			System.out.println(memberList[i]);
		
	}

}
