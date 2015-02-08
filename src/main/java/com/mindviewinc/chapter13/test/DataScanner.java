package com.mindviewinc.chapter13.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataScanner {
	private static void readFile(String fileName) {
		try {
			Scanner scanner = new Scanner(new File(fileName));
			scanner.useDelimiter(System.getProperty("line.separator"));
			while (scanner.hasNext()) {
				parseLine(scanner.next());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void parseLine(String line) {
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter("\\s*,\\s*");
		String name = lineScanner.next();
		int age = lineScanner.nextInt();
		boolean isCertified = lineScanner.nextBoolean();
		double dd = lineScanner.nextDouble();
		System.out.println("It is " + isCertified + " that " + name + ", age " + age + ", is certified," + dd);
	}

	public static void main(String[] args) {
		readFile("/Users/BobbyTang/Projects/thinkinginjava/src/main/java/com/mindviewinc/chapter13/test/datascanner.txt");
	}

}
