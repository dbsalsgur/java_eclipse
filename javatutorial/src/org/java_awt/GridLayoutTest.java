package org.java_awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

class GridLayoutTest {

	public static void main(String[] args) {
		Frame f = new Frame("GridLayOutTest");
		f.setSize(150, 150);
		f.setLayout(new GridLayout(3, 2));
		f.add(new Button("1"));
		f.add(new Button("2"));
		f.add(new Button("3"));
		f.add(new Button("4"));
		f.add(new Button("5"));
		f.add(new Button("6"));
		
		f.setVisible(true);
	}

}
