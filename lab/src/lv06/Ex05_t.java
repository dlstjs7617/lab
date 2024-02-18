package lv06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * # 더하기 게임
 * 1. 1부터 10 사이의 랜덤한 값을 중복 없이 game 배열에 6개 저장한다.
 * 2. 6개의 배열의 인덱스를 0부터 5사이의 랜덤 값 3개를 중복 없이 선택해
 *    그 인덱스 값의 합을 출력한다.
 * 3. 사용자는 중복없이 3개의 인덱스를 골라 그 합을 맞추는 게임이다. 
 *   예) 4, 7, 5, 3, 2, 9 // 문제 : 12 ===> 인덱스 3개를 골라서 합을 맞추면 된다.
 *   정답) 1, 3, 4 (여러가지 경우의 수가 나올수는있다)
 */
class Game_t{
	
	  int total;

	   int game[] = new int[6];
	   int idx[] = new int[3];
	   int myIdx[] = new int[3];

	   void setGame() {
	      for (int i = 0; i < game.length; i++) {
	         game[i] = (int) (Math.random() * 10) + 1;
	         for (int j = 0; j < i; j++) {
	            if (game[j] == game[i]) {
	               i--;
	            }
	         }
	      }
	   }

	   void makeQuiz() {
	      for (int i = 0; i < idx.length; i++) {
	         idx[i] = (int) (Math.random() * 5);
	         boolean isCheck = true;
	         for (int j = 0; j < i; j++) {
	            if (idx[j] == idx[i]) {
	               isCheck = false;
	            }
	         }
	         if (!isCheck) {
	            i--;
	         } else
	            total += game[idx[i]];
	      }
	   }

	   void printQuiz() {
	      System.out.println("보기" + Arrays.toString(game));
	      System.out.println("문제: " + total);
	      System.out.println("정답입력(3개)");

	   }

	   int inputIndex() {
	      Scanner scan = new Scanner(System.in);
	      int result = 0;
	      for (int i = 0; i < myIdx.length; i++) {
	         System.out.print((i + 1) + "번: ");
	         myIdx[i] = scan.nextInt();
	         if (myIdx[i] < 0 || myIdx[i] >= game.length) {
	            i--;
	            System.out.println("1~" + game.length + "까지만 입력하세요.");
	            continue;
	         }
	         boolean isCheck = true;
	         for (int j = 0; j < i; j++) {
	            if (myIdx[j] == myIdx[i]) {
	               isCheck = false;
	               System.out.println("중복된 숫자입니다.");
	            }
	         }

	         if (!isCheck)
	            i--;
	         else
	            result += game[myIdx[i]];
	      }
	      return result;
	   }
	   
	   int getResult() {
		   int result = 0;
		   result = inputIndex();
		   return result;
		   
	   }
	   
	   void printResult(int result) {
	      if (total == result) {
	         System.out.println("정답입니다~!");
	      } else {
	         System.out.println("오답입니다.." + result);
	      }
	   }

	   void run() {
	      setGame();
	      makeQuiz();
	      printQuiz();
	      printResult(getResult());
	      // 게임 배열만들기
	      // 문제만들기
	      // 출력
	      // 값3개 받기
	      // 중복정답도 포함
	   }
}


public class Ex05_t {

	public static void main(String[] args) {
		
		Game_t game = new Game_t();
		game.run();
	}

}
