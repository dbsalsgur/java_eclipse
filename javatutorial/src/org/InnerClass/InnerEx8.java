package org.InnerClass;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class InnerEx8 {

	public static void main(String[] args) {
		Button b = new Button("Start");
		b.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("ActionEvent occurred!!");
				}
			}
		);	//익명클래스의 사용법
	}

}
