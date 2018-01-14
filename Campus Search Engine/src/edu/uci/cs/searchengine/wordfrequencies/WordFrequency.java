package edu.uci.cs.searchengine.wordfrequencies;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class WordFrequency {
	

	// write texts in a file and return a list of the tokens
	public static List<String> tokenize(String textFilePath) {
		// open file
		Scanner file = null;
		try {
			file = new Scanner(new File(textFilePath));
		} catch(Exception e) {
			System.out.println("Could not find file");
		}
		// read file
		List<String> tokenList = new ArrayList<String>();
		while(file.hasNext()) tokenList.add(dropSymbol(file.next().toLowerCase()));
		
		// close file
		file.close();
		
		return tokenList;
	}
	
	// count the number off occurrences of each word in the token list	
	public static HashMap<String, Integer> computerWordFrequencies(List<String> words) {
		HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
		
		for(String word : words) {
			if(frequencies.containsKey(word) == false) frequencies.put(word, 1);
			else frequencies.replace(word, frequencies.get(word) + 1);
		}
		
		return frequencies;
	}
	
	// print words and their frequencies
	public static void print(Map<String, Integer> frequencies) {
		for(String word : frequencies.keySet())	System.out.println(word + " : " + frequencies.get(word));
	}
	public static void print(HashSet<String> words) {
		for(String word : words) System.out.println(word);
	}
	
	// drop some symbol in head or tail
	private static String dropSymbol(String word) {
		// head
		int head = 0;
		while(!((word.charAt(head) >= 'a' && word.charAt(head) <= 'z') || (word.charAt(head) >= '0' && word.charAt(head) <= '9'))) head ++;
		
		// tail
		int tail = word.length() - 1;
		while(!((word.charAt(tail) >= 'a' && word.charAt(tail) <= 'z') || (word.charAt(tail) >= '0' && word.charAt(tail) <= '9'))) tail --;
		
		return word.substring(head, tail + 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fileName = "/home/markpen/Desktop/CompSci 221/Campus Search Engine/src/Campus Search Engine/src/Test/text.txt";
		
		WordFrequency.print(WordFrequency.computerWordFrequencies(WordFrequency.tokenize(fileName)));
		
	}
	
	
}
