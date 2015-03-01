package com.mindviewinc.chapter18.exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Modify OSExecute.java so that, instead of printing the standard output
 * stream, it returns the results of executing the program as a List of Strings.
 * Demonstrate the use of this new version of the utility.
 * 
 * @author BobbyTang
 *
 */
public class Ex22_OSExecuteDemo {
	public static List<String> command(String command) {
		List<String> result = new ArrayList<>();
		boolean err = false;
		try {
			Process process = new ProcessBuilder(command.split(" ")).start();
			BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String s;
			while ((s = results.readLine()) != null)
				result.add(s);
			BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			// Report errors and return nonzero value
			// to calling process if there are problems:
			while ((s = errors.readLine()) != null) {
				System.err.println(s);
				err = true;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		// if (err)
		// throw new OSExecuteException("Errors executing " + command);

		return result;
	}

	public static void main(String[] args) {

		List<String> result = Ex22_OSExecuteDemo
				.command("javap target/classes/com/mindviewinc/chapter18/exercise/Ex22_OSExecuteDemo");
		for (String s : result)
			System.out.println(s);
	}
}
