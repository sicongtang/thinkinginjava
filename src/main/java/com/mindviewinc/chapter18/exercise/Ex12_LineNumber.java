package com.mindviewinc.chapter18.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Modify Exercise 8 to also open a text file so you can write text into it.
 * Write the lines in the LinkedList, along with line numbers (do not attempt to
 * use the "LineNumber" classes), out to the file.
 * 
 * @author BobbyTang
 *
 */
public class Ex12_LineNumber {
	public static void main(String[] args) {
		String fileName = "/Users/BobbyTang/Projects/thinkinginjava/src/main/java/com/mindviewinc/chapter18/exercise/Ex12.java";

		BufferedReader reader = null;
		LinkedList<String> list = new LinkedList<>();
		try {
			reader = new BufferedReader(new FileReader(fileName));

			String line = null;
			int lineNumber = 0;

			while ((line = reader.readLine()) != null) {
				lineNumber++;
				list.add(lineNumber + ":" + line);
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

		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter("/Users/BobbyTang/Tmp/Ex12.java"));
			while (iter.hasPrevious()) {
				writer.println(iter.previous());
			}

			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}

	}

}
