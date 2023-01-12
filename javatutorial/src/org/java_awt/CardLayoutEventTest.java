package org.java_awt;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutEventTest extends Frame {
	Button first, prev, next, last;
	Panel buttons;
	Panel slide;
	Panel card1, card2, card3, card4, card5;
	CardLayout card;
	
	

	CardLayoutEventTest(String title) {
		super(title);
		
		slide = new Panel();
		card = new CardLayout();
		slide.setLayout(card);
		
		buttons = new Panel();
		buttons.setLayout(new FlowLayout());
		
		first = new Button("<<");
		prev = new Button("<");
		next = new Button(">");
		last = new Button(">>");
		buttons.add(first);
		buttons.add(prev);
		buttons.add(next);
		buttons.add(last);
		
		first.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.first(slide);
			}
		});
		prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(slide);
			}
		});
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(slide);
			}
		});
		last.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.last(slide);
			}
		});
		
		card1= new Panel();
		card1.setBackground(Color.gray);
		card1.add(new Label("첫번째 페이지 입니다."));
		card2= new Panel();
		card2.setBackground(Color.orange);
		card2.add(new Label("두번째 페이지 입니다."));
		card3= new Panel();
		card3.setBackground(Color.blue);
		card3.add(new Label("세번째 페이지 입니다."));
		card4= new Panel();
		card4.setBackground(Color.cyan);
		card4.add(new Label("네번째 페이지 입니다."));
		card5= new Panel();
		card5.setBackground(Color.pink);
		card5.add(new Label("다섯번째 페이지 입니다."));
		
		slide.add(card1, "1");
		slide.add(card2, "2");
		slide.add(card3, "3");
		slide.add(card4, "4");
		slide.add(card5, "5");
		
		add("South", buttons);
		add("Center", slide);
		
		setSize(200, 200);
		setLocation(890, 440);
		setVisible(true);
		
		card.show(slide, "1");
	}



	public static void main(String[] args) {
		CardLayoutEventTest mainWin = new CardLayoutEventTest("CardLayoutEventTest");
	}

}
