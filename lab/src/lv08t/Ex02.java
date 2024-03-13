package lv08t;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(0);
		list.add(2);
		list.add(1);
		list.add(1);
		
		for(int i=0; i<list.size(); i++)
			System.out.println(System.identityHashCode(list.get(i)));
		
		while(true) {
			// 전체출력
			for(int i=0; i<list.size(); i++)
				System.out.print(list.get(i) + " ");
			
			
			System.out.println("\n1.추가 2.인덱스로삭제 3.값으로삭제 4.삽입 5.종료");
			System.out.print("메뉴 선택 :");
			int select = sc.nextInt();
			// 1.추가 2.인덱스로삭제 3.값으로삭제 4.삽입 5.종료
			if(select == 1) {
				System.out.print("data :");
				int data = sc.nextInt();
				list.add(data);
				
			}else if(select == 2) {
				System.out.print("index :");
				int index = sc.nextInt();
				
				if(index <0 || index >= list.size())
					continue;
				
				list.remove(index);
			}else if(select == 3) {
				System.out.print("data :");
				Integer data = sc.nextInt();
				// data = new Integer(scanner.nextint());
				
				int index = -1;
				for(int i=0; i<list.size(); i++) {
					if(list.get(i).equals(data))
						index = i;
				}
				
				if(index == -1)
					continue;
				
				list.remove(list.get(index));
			}else if(select == 4) {
				System.out.println("index : ");
				int index = sc.nextInt();
				System.out.println("data : ");
				int data = sc.nextInt();
				
				if(index < 0 || index >= list.size())
					continue;
				
				list.add(index,data);
				
			}else if(select == 5) {
				break;
			}
			
			
		
		}

	}

}
