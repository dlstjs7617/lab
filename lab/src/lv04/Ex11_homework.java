package lv04;

import java.util.Arrays;

public class Ex11_homework {

	public static void main(String[] args) {
		/*
		 *  int[] a = {1,1,3,3,3,100,2,2,3,1,3,};
		 *  위 배열에서 똑같은 숫자의 개수가 가장적은 숫자와 가장 많은 숫자의 개수를 출력
		 *  예) 개수가 가장적은숫자 ==> 100
		 *  예) 개수가 가장많은숫자 ==> 3
		 *  
		 *  가장 많은 갯수 출력 : 3 ====>5개
		 *  가장 적은 갯수 출력 : 100 ===> 1개
		 */
//		int[] a = { 1, 1, 3, 3, 3, 100, 2, 2, 3, 1, 3 };
//		int[] a = { 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2};
//		int[] a =  {5,1,2,2,3,3,4,4,5,1};

		 int[] a = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };
//       위 배열에서 똑같은 숫자의 개수가 가장 적은 숫자와 가장 많은 숫자의 개수를 출력
//       예) 개수가 가장 적은 숫자 ==> 100
//       예) 개수가 가장 많은 숫자 ==> 3
//       
//       가장 많은 갯수 출력: 3 ==> 5개
//       가장 적은 갯수 출력: 100 ==> 1개

    // 1. 가장 많은 숫자의 개수
    // 2. 가장 적은 숫자의 개수
    
    int maxCnt = 0;
    int minCnt = a.length + 1;
    
    for(int i =0;i<a.length;i++) {
       // a[i] -> 몇 개?
       int cnt = 0;
       for(int j=0; j<a.length; j++) {
          if(a[i] == a[j])
             cnt ++;
       }
       
       if(cnt > maxCnt) {
          maxCnt = cnt;
       }
       
       if(cnt < minCnt)
          minCnt = cnt;
       
    }
    
    int maxCount = 0;   // 배열의 크기를 의미
    int[] maxNums = null;
    
    int minCount = 0;   // 배열의 크기를 의미
    int[] minNums = null;

    // 3. 가장 많은 숫자의 개수와 같으면 -> 별도로 해당 숫자를 여러개(몇 개인지 모름) 기억(A배열)
    // 4. 가장 적은 숫자의 개수와 같으면 -> 별도로 해당 숫자를 여러개(몇 개인지 모름) 기억(B배열)
    
    for(int i=0; i<a.length; i++) {
       int cnt = 0;
       for(int j=0; j<a.length; j++) {
          if(a[i] == a[j])
             cnt++;
       }
       
       if(cnt == maxCnt) {
          // maxNums 배열에 a[i] 숫자가 이미 존재하느냐
          boolean isDupl = false;
          for(int j=0; j<maxCount; j++) {
             if(a[i] == maxNums[j]) {
                isDupl = true;
             }
          }
          
          if(!isDupl) {
             // a[i]를 maxNums 배열에 넣기
             int[] temp = maxNums;
             maxNums = new int[maxCount+1];
             
             for(int j=0;j<maxCount; j++)
                maxNums[j] = temp[j];
             maxNums[maxCount ++] = a[i];
             // maxCount ++;
          }
       }
       
       if(cnt == minCnt) {
          boolean isDupl = false;
          for(int j=0; j<minCount; j++) {
             if(a[i] == minNums[j])
                isDupl = true;
          }
          
          if(!isDupl) {
             int[] temp = minNums;
             minNums = new int[minCount+1];
             
             for(int j=0; j<minCount; j++){
                minNums[j] = temp[j];
             }
             minNums[minCount ++] = a[i];
          }
       }
    }
    
    // 5.  결과 배열 A, B를 출력
    System.out.println("maxNums: " + Arrays.toString(maxNums));
    System.out.println("minNums: " + Arrays.toString(minNums));
    
    for(int i=0; i<maxCount; i++) {
       System.out.printf("가장 많은 갯수 출력: %d ===> %d개\n", maxNums[i], maxCnt);
    }
    for(int i=0; i<minCount; i++) {
       System.out.printf("가장 적은 갯수 출력: %d ===> %d개\n", minNums[i], minCnt);
    }
 }

}