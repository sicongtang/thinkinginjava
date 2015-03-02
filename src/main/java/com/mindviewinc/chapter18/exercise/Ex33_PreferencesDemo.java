package com.mindviewinc.chapter18.exercise;

import java.util.Scanner;
import java.util.prefs.Preferences;

public class Ex33_PreferencesDemo {
	public static void main(String[] args) throws Exception {
		Preferences prefs = Preferences.userNodeForPackage(Ex33_PreferencesDemo.class);
		String directory = prefs.get("base directory", "Not defined");
		System.out.println("directory: " + directory);
		// simple usage reading data from console input
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a new directory: ");
		//
		directory = sc.nextLine();
		prefs.put("base directory", directory);
		System.out.println("\ndirectory: " + directory);
	}
}
