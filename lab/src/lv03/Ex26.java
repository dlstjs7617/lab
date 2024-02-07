package lv03;

import java.util.Iterator;

public class Ex26 {

	public static void main(String[] args) {
		/*
		 *  문제 1)
		 *  #
		 *  ##
		 *  ###
		 */
		System.out.println("===문제1===");
		for(int i=1; i<=3; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("#");
			}
			System.out.println();
		}
		/*
		 *  문제 2)
		 *  ###
		 *  ##
		 *  #
		 */
		System.out.println("===문제2===");
		for(int i=0; i<3; i++) {
			for(int j=0; j<=2-i; j++) {
				System.out.print("#");
			}
			System.out.println();
		}
		/*
		 *  문제 3)
		 *  @##   012
		 *  @@#   345
		 *  @@@   678
		 */
		System.out.println("===문제3===");
		for(int i=0; i<3; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.print("@");
			}
			for(int j=0; j<2-i; j++) {
				System.out.print("#");
			}
			System.out.println();
		}
		/*
		 *  문제 4)
		 *    #
		 *   ###
		 *  #####
		 */
		System.out.println("===문제4===");
		
		 for(int i=1; i<=3; i++){
	            for(int j=5-i; j>0; j--){
	                System.out.print(" ");
	            }
	            for(int j=1; j<=i*2-1; j++){
	                System.out.print("#");
	            }
	            System.out.println();
	        }
	}

}
