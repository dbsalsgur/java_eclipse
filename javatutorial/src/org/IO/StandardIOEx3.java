package org.IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

class StandardIOEx3 {

	public static void main(String[] args) {
		PrintStream ps = null;
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("minn.txt");
			ps = new PrintStream(fos);
			System.setOut(ps);
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found.");
		}
		
		System.out.println("Hello by System.out");
		System.err.println("Hello by System.err");
	}

}
