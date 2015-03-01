package com.mindviewinc.chapter18.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Write a program that takes standard input and capitalizes all characters,
 * then puts the results on standard output. Redirect the contents of a file
 * into this program (the process of redirection will vary depending on your
 * operating system).
 * 
 * @author BobbyTang
 *
 */
public class Ex21_UpperCaseEcho {

	public static void main(String[] args) throws IOException {

		// base class of FileReader
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bis = new BufferedReader(isr);

		String line = null;
		while ((line = bis.readLine()) != null && line.length() != 0) {
			System.out.println(line.toUpperCase());
		}

	}

}
