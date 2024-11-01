package study;
/*
#문제6
369 게임은 여러 명이 같이하는 게임입니다. 게임의 규칙은 아래와 같습니다.
1부터 시작합니다.
한 사람씩 차례대로 숫자를 1씩 더해가며 말합니다.
말해야 하는 숫자에 3, 6, 9중 하나라도 포함되어있다면 숫자를 말하는 대신 숫자에 포함된 3, 6, 9의 개수만큼 손뼉을 칩니다.

어떤 수 number가 매개변수로 주어질 때, 1부터 number까지 369게임을 올바르게 진행했을 경우 박수를 총 몇 번 쳤는지를 return 하도록 solution 메소드를 작성하려 합니다. 빈칸을 채워 전체 코드를 완성해주세요.

---

#####매개변수 설명
number가 solution 메소드의 매개변수로 주어집니다.
number는 10 이상 1,000 이하의 자연수입니다.

---

#####return 값 설명
1부터 number까지 369게임을 올바르게 진행했을 경우 박수를 총 몇 번을 쳤는지 return 해주세요.

---

#####예시

| number | return |
|--------|--------|
| 40     | 22     |

#####예시 설명
3, 6, 9 : 각각 한 번 (+3)
13, 16, 19 : 각각 한 번 (+3)
23, 26, 29 : 각각 한 번 (+3)
30, 31, 32, 33, ..., 38, 39 : 십의 자리 열 번 + 일의 자리 세 번 (+13)
따라서, 3 + 3 + 3 + 13 = 22번의 박수를 칩니다.
*/


class Solution{
	int solution (int number){
		int count = 0;
		
		
		for(int i=1; i<=number; i++) {
			int num1 = i/ 10;
			int num2 = i%10 %3;
			if(num1 == 3 || num1 == 6 || num1 == 9) {
				System.out.println("i : " + i);
				count++;
			}
			if(num2 == 0 && i%10 != 0) {
				System.out.println("num2 i : " + i);
				count++;
			}
		}
		
		
		
		return count;
	
	}
}

public class Ex03 {
	
	public static void main(String[] args) {
		 Solution sol = new Solution();
	        int number = 90;
	        int ret = sol.solution(number);

	        // Press Run button to receive output.
	        System.out.println("Solution: return value of the method is " + ret + " .");

	}

}
