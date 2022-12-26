package org.java_awt;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

class FrameTest {

	public static void main(String[] args) {
		Frame f= new Frame("Login");
		f.setSize(300, 200);
		f.setLayout(null);
		
		Button b = new Button("확 인");
		b.setSize(100, 50);
		b.setLocation(100, 75);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		
		f.add(b);
		f.setLocation(screenSize.width/2 - 150, screenSize.height/2 - 100);
		f.setVisible(true);
	}

}
