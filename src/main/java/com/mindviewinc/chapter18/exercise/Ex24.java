package com.mindviewinc.chapter18.exercise;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

public class Ex24 {
	private static final int BSIZE = 1024;

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		DoubleBuffer db = bb.asDoubleBuffer();
		db.put(new double[]{2D,3D,6D,7D});
		
		System.out.println("get absolute postion " + db.get(1));
		
		System.out.println("set absolute postion " + db.put(1, 999D));
		
		db.flip();
		
		while(db.hasRemaining()){
			double dou = db.get();
			System.out.println("iterate " + dou);
		}
	}
}
