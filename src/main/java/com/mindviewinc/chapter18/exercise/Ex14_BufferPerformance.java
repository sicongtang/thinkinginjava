package com.mindviewinc.chapter18.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Starting with BasicFileOutput.java, write a program that compares the
 * performance of writing to a file when using buffered and unbuffered I/O.
 * 
 * @author BobbyTang
 *
 */
public class Ex14_BufferPerformance {
	public static void main(String[] args) throws Exception {

		// Reminder: defaultCharBufferSize = 8192;
		BufferedReader reader = new BufferedReader(new FileReader(
				"src/main/java/com/mindviewinc/chapter18/exercise/Ex14_BufferPerformance.java"));
		PrintWriter bufferWriter = new PrintWriter(new BufferedWriter(new FileWriter(
				"/Users/BobbyTang/Tmp/Ex14_BufferPerformance_Buffer.java")));
		PrintWriter regularWriter = new PrintWriter(new FileWriter(
				"/Users/BobbyTang/Tmp/Ex14_BufferPerformance_NonBuffer.java"));
		List<String> list = new ArrayList<>();

		String line = null;
		while ((line = reader.readLine()) != null) {
			list.add(line);
		}

		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			for (String lineStr : list) {
				bufferWriter.println(lineStr);
			}
		}

		System.out.println("bufferWriter cost: " + (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			for (String lineStr : list) {
				regularWriter.println(lineStr);
			}
		}

		System.out.println("regularWriter cost: " + (System.currentTimeMillis() - start));

		reader.close();
		bufferWriter.close();
		regularWriter.close();

	}
}
