package lv08;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> list;
		list = new ArrayList<>();
		while(true) {
			// 전체출력
			// 1.추가 2.인덱스로삭제 3.값으로삭제 4.삽입 4.종료
			System.out.println(list);
			
			System.out.println("1.추가");
			System.out.println("2.인덱스로 삭제");
			System.out.println("3.값으로 삭제");
			System.out.println("4.삽입");
			System.out.println("5.종료");
			
			int sel = sc.nextInt();
			if(sel == 1) {
				System.out.print("추가할 값 입력 :");
				list.add(sc.nextInt());
			}else if(sel == 2) {
				System.out.print("삭제할 인덱스:");
				int idx = sc.nextInt();
				
				if(idx < 0 || idx >= list.size()) {
					System.err.println("유효하지 않은 인덱스");
					continue;
				}
				
				list.remove(idx);
			}else if(sel == 3) {
				Integer num = sc.nextInt();
				list.remove(num);
			}else if(sel == 4) {
				System.out.print("삽입할 자리:");
				int idx = sc.nextInt();
				
				if(idx < 0 || idx >= list.size()) {
					System.err.println("유효하지 않은 인덱스");
					continue;
				}
				
				System.out.print("삽입할 값:");
				int num = sc.nextInt();
				list.add(idx, num);
			}else if(sel == 5) {
				break;
			}
			
		}

	}

}
