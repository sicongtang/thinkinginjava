package com.mindviewinc.chapter18.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Open a text file so that you can read the file one line at a time. Read each
 * line as a String and place that String object into a LinkedList. Print all of
 * the lines in the LinkedList in reverse order.
 * 
 * @author BobbyTang
 *
 */
public class Ex07 {
	public static void main(String[] args) {

		BufferedReader reader = null;
		LinkedList<String> list = new LinkedList<>();
		try {
			reader = new BufferedReader(
					new FileReader(
							"/Users/BobbyTang/Projects/thinkinginjava/src/main/java/com/mindviewinc/chapter18/exercise/Ex7.java"));

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
