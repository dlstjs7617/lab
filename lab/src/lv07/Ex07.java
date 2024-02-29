package lv07;

import java.util.Random;
import java.util.Scanner;

class Word{
	private String value;
	private int hiddenIndex;
	private boolean answer;
	public Word(String value, int hiddenIndex) {
		this.value = value;
		this.hiddenIndex = hiddenIndex;
	}
	
	public String getValue() {
		return value;
	}
	
	public int getHiddenIndex() {
		return hiddenIndex;
	}
	
	public boolean getAnswer() {
		return answer;
	}
	
	private void setAnswer(boolean answer) {
		this.answer = answer;
	}
	
	public void inputAnswer(boolean answer) {
		setAnswer(answer);
	}
}

class WordSample{
	private String[] wordSampleList;
	
	public WordSample() {
		wordSampleList = new String[] { "java", "jsp", "python", "android", "spring" };
	}
	
	public String getWordSampleList(int index) {
		return wordSampleList[index];
	}
	
	public int getSampleLength() {
		return wordSampleList.length;
	}
	
}

class WordGame{
	private Scanner sc = new Scanner(System.in);
	private Random ran = new Random();
	
	private Word[] words;
	private WordSample sample;
	
	private int size;
	private int score;
	
	private void setGame(){
		sample = new WordSample();
		size = sample.getSampleLength();
		score = size*100;
		wordSet();
	}
	
	private void wordSet() {
		words = new Word[size];
		for(int i=0; i<size; i++) {
			int rHiddenIdx = ran.nextInt(sample.getWordSampleList(i).length());
			words[i] = new Word(sample.getWordSampleList(i), rHiddenIdx);
		}
	}
	
	private boolean isRun() {
		if(score < 0)
			return false;
		
		for(int i=0; i<size; i++)
			if(!words[i].getAnswer())
				return true;
		
		return false;
	}
	
	private void game() {
		int rIdx = rWord();
		while(true) {
			printWord(rIdx);
			
			String inputAnswer = inputString("정답");
			
			if(answer(rIdx, inputAnswer)) {
				words[rIdx].inputAnswer(true);
				System.out.println("정답입니다");
				break;
			}else {
				System.err.println("오답");
				score -= 10;
			}
		}
	}
	
	private int rWord() {
		int idx;
		while(true) {
			idx = ran.nextInt(sample.getSampleLength());
			
			if(!words[idx].getAnswer())
				break;
		}
		
		return idx;
	}
	
	private void printWord(int idx) {
		for(int i=0; i<words[idx].getValue().length(); i++) {
			if(i != words[idx].getHiddenIndex())
				System.out.print(words[idx].getValue().charAt(i));
			else
				System.out.print("*");
		}
		System.out.println();
	}
	
	private boolean answer(int idx, String answer) {
		if(words[idx].getValue().equals(answer))
			return true;
		
		return false;
	}
	
	private String inputString(String message) {
		System.out.print(message + " : ");
		return sc.next();
	}
	
	private void printScore() {
		System.out.println("점수 : " + score);
	}
	
	public void run() {
		setGame();
		
		while(isRun()) {
			game();
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
