package com.mindviewinc.chapter18.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectToByteArray {

	public byte[] convertToByteArray(Object target) {
		byte[] byteArray = null;
		ByteArrayOutputStream bos = null;
		ObjectOutputStream ooo = null;
		try {
			bos = new ByteArrayOutputStream();
			ooo = new ObjectOutputStream(bos);

			ooo.writeObject(target);

			byteArray = bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ooo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return byteArray;
	}

	public Object convertToObject(byte[] byteArray) {

		Object obj = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;

		try {

			bis = new ByteArrayInputStream(byteArray);
			ois = new ObjectInputStream(bis);

			obj = ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return obj;
	}

}
