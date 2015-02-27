package com.mindviewinc.chapter18.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Modify Exercise 8 to force all the lines in the LinkedList to uppercase and
 * send the results to System.out.
 * 
 * @author BobbyTang
 *
 */
public class Ex09 {
	public static void main(String[] args) {

		String fileName = "/Users/BobbyTang/Projects/thinkinginjava/src/main/java/com/mindviewinc/chapter18/exercise/Ex7.java";

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
			System.out.println(iter.previous().toUpperCase());
		}
	}

}
