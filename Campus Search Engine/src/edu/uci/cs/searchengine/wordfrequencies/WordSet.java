package edu.uci.cs.searchengine.wordfrequencies;

import java.util.HashMap;
import java.util.HashSet;

public class WordSet {

	// get a intersection of two files
	public static HashSet<String> intersectionWords(String file1, String file2) {
		
		return intersectionWords(WordFrequency.computerWordFrequencies(WordFrequency.tokenize(file1)), WordFrequency.computerWordFrequencies(WordFrequency.tokenize(file2)));
	}
	public static HashSet<String> intersectionWords(HashMap<String, Integer> file1Words, HashMap<String, Integer> file2Words) {
		HashSet<String> intersections = new HashSet<String>();
		for(String key: file1Words.keySet()) {
			if(file2Words.containsKey(key)) intersections.add(key);
		}
			
		return intersections;
	}
		
	// get a reduce of two files
	public static HashMap<String, Integer> reduceWords(String file1, String file2) {
			
		return reduceWords(WordFrequency.computerWordFrequencies(WordFrequency.tokenize(file1)), WordFrequency.computerWordFrequencies(WordFrequency.tokenize(file2)));
	}	
	public static HashMap<String, Integer> reduceWords(HashMap<String, Integer> file1Words, HashMap<String, Integer> file2Words) {
		
		for(String word : file1Words.keySet()) {
			if(file2Words.containsKey(word)) {
				int freq = file2Words.get(word);
				file2Words.replace(word, freq + file1Words.get(word));
			} else {
				file2Words.put(word, file1Words.get(word));
			}
		}
			
		return file2Words;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fileName = "/home/markpen/Desktop/CompSci 221/Campus Search Engine/src/Campus Search Engine/src/Test/text.txt";
		String fileName2 = "/home/markpen/Desktop/CompSci 221/Campus Search Engine/src/Campus Search Engine/src/Test/text2.txt";
		
		//WordFrequency.print(WordSet.reduceWords(fileName, fileName2));
		WordFrequency.print(WordSet.intersectionWords(fileName, fileName2));
		
	}
}
