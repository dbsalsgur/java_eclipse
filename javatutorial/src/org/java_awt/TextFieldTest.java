package org.java_awt;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;


class TextFieldTest {

	public static void main(String[] args) {
		Frame f = new Frame("Login");
		f.setSize(400, 80);
		f.setLayout(new FlowLayout());;
		
		Label lid = new Label("ID :", Label.RIGHT);
		Label lpwd = new Label("Password : ", Label.RIGHT);
		
		TextField id = new TextField(10);
		TextField pwd = new TextField(10);
		pwd.setEchoChar('*');
		
		f.add(lid);
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.setVisible(true);
	}

}
