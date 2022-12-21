package org.IO;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class BufferedOutPutStreamEx1 {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("123.txt");
			
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
			
			for (int i = '1'; i <= '9'; i++) {
				bos.write(i);
				bos.flush();
			}
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
