package com.mindviewinc.chapter18.exercise;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.mindview.util.BinaryFile;

/**
 * Using BinaryFile and a Map<Byte,Integer>, create a program that counts the
 * occurrence of all the different bytes in a file.
 * 
 * @author BobbyTang
 *
 */
public class Ex19_BytesInfo {
	public static void main(String[] args) throws IOException {

		byte[] bytes = BinaryFile.read("src/main/java/com/mindviewinc/chapter18/exercise/Ex19.java");

		Map<Byte, Integer> map = new HashMap<Byte, Integer>();
		for (byte b : bytes) {
			// handle counting via using map 
			Integer count = map.get(b);
			map.put(b, count == null ? 1 : count + 1);
		}

		System.out.println(map);

	}
}
