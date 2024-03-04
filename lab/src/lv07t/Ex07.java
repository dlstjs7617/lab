package lv07t;

import java.util.Random;
import java.util.Scanner;

class Word{
	private String value;
	private int hiddenIndex;
	
	public Word(String value) {
		this.value = value;
		
		Random random = new Random();
		this.hiddenIndex = random.nextInt(value.length());
	}
	
	@Override
	public String toString() {
		String word = "";
		
		if(value != null) {
			for(int i=0; i<value.length(); i++) {
				if(i != hiddenIndex)
					word += value.charAt(i);
				else
					word += "*";
			}			
		}
		return word;		
	} 
	
	public String getValue() {
		return this.value;
	}
}

class WordSample{
	private String[] wordSampleList;
	
	public WordSample() {
		wordSampleList = new String[] { "java", "jsp", "python", "android", "spring" };
		shuffle();
	}
	
	public String[] getWordSampleList() {
		return this.wordSampleList.clone();
	}
	
	private void shuffle() {
		Random random = new Random();
		
		for(int i=0; i<100; i++) {
			int rIdx = random.nextInt(wordSampleList.length);
			
			String word = wordSampleList[0];
			wordSampleList[0] = wordSampleList[rIdx];
			wordSampleList[rIdx] = word;
			
		}
	}
	
}

class WordGame{
	
	private Scanner sc = new Scanner(System.in);
	
	private Word[] words;
	private int gameIndex;
	private int score;
	
	public WordGame() {
		WordSample sample = new WordSample();
		
		String[] list = sample.getWordSampleList();
		int size = list.length;
		
		words = new Word[size];
		
		for(int i=0; i<size; i++) {
			words[i] = new Word(list[i]);
		}
		
		this.score = 100;
	}
	
	private boolean isRun() {
		return gameIndex == words.length ? false : true;
	}
	
	private void printQuiz() {
		System.out.println("quiz" + (gameIndex + 1) + " : ");
		System.out.println(words[gameIndex]);
	}
	
	private String inputString() {
		System.out.print(": ");
		return sc.next();
	}
	
	private boolean  checkAnswer(String answer) {
		boolean result = answer.equals(words[gameIndex].getValue());
		
		if(!result && this.score > 0) {
			this.score -= 2;
		}
		
		return result;
	}
	
	private void addGameIndex() {
		this.gameIndex++;
	}
	
	private void printScore() {
		System.out.printf("score : %d\n", this.score);
	}
	
	
	public void run() {
		while(isRun()) {
			printQuiz();
			String input = inputString();
			if(!checkAnswer(input)) {
				System.out.println("틀림");
				continue;
			}
			addGameIndex();
		}
		printScore();
		
	}
}

public class Ex07 {

	public static void main(String[] args) {
		WordGame game = new WordGame();
		game.run();
	}

}
