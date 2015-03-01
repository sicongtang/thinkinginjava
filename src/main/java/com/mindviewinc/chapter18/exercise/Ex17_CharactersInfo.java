package com.mindviewinc.chapter18.exercise;

import java.util.Map;
import java.util.TreeMap;

import net.mindview.util.TextFile;

/**
 * Using TextFile and a Map<Character,Integer>, create a program that counts the
 * occurrence of all the different characters in a file. (So if there are 12
 * occurrences of the letter ‘a’ in the file, the Integer associated with the
 * Character containing ‘a’ in the Map contains ‘12’).
 * 
 * @author BobbyTang
 *
 */
public class Ex17_CharactersInfo {
	public static void main(String[] args) {

		Map<Character, Integer> map = new TreeMap<>();

		TextFile textFile = new TextFile("src/main/java/com/mindviewinc/chapter18/exercise/Ex17.java", "\\W+");
		for (String word : textFile) {
			for (int i = 0; i < word.length(); i++) {
				Character ch = word.charAt(i);
				// handle counting via using map
				Integer freq = map.get(ch);
				map.put(ch, freq == null ? 1 : freq + 1);
			}
		}

		System.out.println(map);
	}
}
