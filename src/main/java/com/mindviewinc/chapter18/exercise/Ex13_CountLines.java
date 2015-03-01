package com.mindviewinc.chapter18.exercise;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

/**
 * Modify BasicFileOutput.java so that it uses LineNumberReader to keep track of
 * the line count. Note that it’s much easier to just keep track
 * programmatically.
 * 
 * @author BobbyTang
 *
 */
public class Ex13_CountLines {
	static String file = "/Users/BobbyTang/Tmp/Ex13.java";

	public static void main(String[] args) throws IOException {
		LineNumberReader lReader = new LineNumberReader(new FileReader(
				"src/main/java/com/mindviewinc/chapter18/exercise/Ex13.java"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		String s;
		while ((s = lReader.readLine()) != null)
			writer.println(lReader.getLineNumber() + ": " + s);
		writer.close();
		lReader.close();
	}
}
