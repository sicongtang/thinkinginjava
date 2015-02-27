package com.mindviewinc.chapter18.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Modify Exercise 8 to take additional command-line arguments of words to find
 * in the file. Print all lines in which any of the words match.
 * 
 * @author BobbyTang
 *
 */
public class Ex10 {

	public static void main(String[] args) {
		// "/Users/BobbyTang/Projects/thinkinginjava/src/main/java/com/mindviewinc/chapter18/exercise/Ex7.java"

		String fileName = null;

		BufferedReader reader = null;
		LinkedList<String> list = new LinkedList<>();
		try {
			reader = new BufferedReader(new FileReader(fileName));

			String line = null;

			while ((line = reader.readLine()) != null) {
				list.add(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		ListIterator<String> iter = list.listIterator(list.size());
		while (iter.hasPrevious()) {
			System.out.println(iter.previous());
		}
	}

}
