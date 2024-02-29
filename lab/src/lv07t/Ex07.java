package lv07t;

import java.util.Random;
import java.util.Scanner;

class Word{
	private String value;
	private int hiddenIndex;
}

class WordSample{
	private String[] wordSampleList;
	
	public WordSample() {
		wordSampleList = new String[] { "java", "jsp", "python", "android", "spring" };
		
	}
}

class WordGame{
	private Scanner sc = new Scanner(System.in);
	private Random ran = new Random();
	
	private Word[] words;
	
	void run() {
	}
}

public class Ex07 {

	public static void main(String[] args) {
		WordGame game = new WordGame();
		game.run();
	}

}
