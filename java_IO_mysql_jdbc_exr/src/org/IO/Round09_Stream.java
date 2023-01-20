package org.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Round09_Stream {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		File dir = new File("C:/imsi");
		if(!dir.exists()) dir.mkdir();
		File file = new File(dir, "data.dat");
		DataOutputStream f_out = null;
		DataInputStream f_in = null;
		while (true) {
			System.out.print("1.데이터 저장 2.데이터 출력 3.종료 = ");
			int dist = in.nextInt();
			in.nextLine();
			switch (dist) {
			case 1:
				System.out.print("저장할 데이터 = ");
				try {
					f_out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file, true), 1024));
					f_out.write((in.nextLine()+"\n").getBytes());
					f_out.close();
					System.out.println("저장완료!");
				} catch (IOException e) {
					System.out.println("저장 실패 : "+e);
				}
				break;
			case 2:
				try {
					f_in = new DataInputStream(new BufferedInputStream(new FileInputStream(file), 1024));
					byte[] by = new byte[1024];
					while (true) {
						int x = f_in.read(by, 0, by.length);
						if(x==-1) break;
						System.out.print(new String(by, 0, x));
					}
					f_in.close();
					System.out.println("\n출력종료!");
				} catch(IOException e) {
					System.out.println("출력 실패 :"+e);
				}
				break;
			case 3:
				System.out.println("시스템 종료");
				System.exit(0);
			default:
				System.out.println("잘못 입력 하셨습니다.");
			}
			System.out.println();
		}
	}

}
