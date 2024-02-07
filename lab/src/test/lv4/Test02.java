package test.lv4;

import java.util.Arrays;
import java.util.Scanner;

// 시작 30:00
// 종료 32:34
// 소요 52:34
public class Test02 {
	public static void main(String[] args) {		
		// 2.
		/*
		 * # 배열 컨트롤러[2단계] : 벡터(Vector)
		 * 1. 추가
		 * . 값을 입력받아 순차적으로 추가
		 * 2. 삭제(인덱스)
		 * . 인덱스를 입력받아 해당 위치의 값 삭제
		 * 3. 삭제(값)
		 * . 값을 입력받아 삭제(중복값 X, 인덱스 가장 작은값 한 개 0)
		 * . 없는 값 입력 시 예외처리
		 * 4. 삽입
		 * . 인덱스와 값을 입력받아 삽입
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		
		int[] arr =null;
		int cnt = 0;
		int sel;
		while(true){
			System.out.println("====현재 배열상태======");
			System.out.println(Arrays.toString(arr));
			System.out.println("1.추가 2.삭제(인덱스) 3. 삭제(값) 4.삽입 5.종료");
			System.out.print("메뉴 선택 : ");
			sel = sc.nextInt();
			
			if(cnt == 0 && sel == 2 || cnt == 0 && sel == 3 || cnt == 0 && sel == 4) {
				System.out.println("배열이 null값이라 불가합니다.");
				continue;
			}
			
			if(sel == 1) {	//추가
				System.out.print("값을 입력 : ");
				int num  = sc.nextInt();
				
				int[] temp = new int[cnt+1];
				temp[cnt] = num;
				if(cnt !=0) {
					for(int i=0; i<arr.length; i++)
						temp[i] = arr[i];					
				}
				arr = temp;
				cnt++;
			}else if(sel == 2) {	//삭제(인덱스)
				System.out.print("삭제할 인덱스 입력 : ");
				int idx = sc.nextInt();
				if(idx < 0 || idx >= cnt ) {
					System.out.println("유효하지않는 인덱스");
					continue;
				}
				int[] temp = arr;				
				for(int i=idx; i<arr.length-1; i++) {
					temp[i]= temp[i+1];
				}
				arr = new int[cnt-1];
				for(int i=0; i<arr.length; i++) {
					arr[i]= temp[i];
				}
				cnt--;
			}else if(sel == 3) {	//삭제(값)
				System.out.print("삭제할 값 입력 :");
				int num = sc.nextInt();
				int idx = -1;
				for(int i=0; i<arr.length; i++) {
					if(num == arr[i]) {
						idx = i;
						break;
					}
				}
				if(idx == -1) {
					System.out.println("없는 값입니다. ");
					continue;
				}else {
					int[] temp = arr;				
					for(int i=idx; i<arr.length-1; i++) {
						temp[i]= temp[i+1];
					}
					arr = new int[cnt-1];
					for(int i=0; i<arr.length; i++) {
						arr[i]= temp[i];
					}
					cnt--;
				}
			}else if(sel == 4) {	//삽입
				System.out.print("삽입할 인덱스 : ");
				int idx = sc.nextInt();
				System.out.print("삽입할 값 : ");
				int num = sc.nextInt();
				
				if(idx < 0 || idx >= cnt) {
					System.out.println("유효하지않는 범위");
					continue;
				}
				
				int[]temp = arr;
				arr = new int[cnt+1];
				for(int i=0; i<cnt+1; i++) {
					if(idx > i)
						arr[i]= temp[i];
					else if(idx == i)
						arr[i] = num;
					else if(idx < i)
						arr[i] = temp[i-1];
				}
				cnt++;
				
				
				
			}else if(sel == 5) {	//종료
				break;
			}
			
			
		}
		
	}

}
