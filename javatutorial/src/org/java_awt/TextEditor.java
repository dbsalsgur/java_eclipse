package org.java_awt;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

class TextEditor extends Frame {
	String fileName;
	TextArea content;
	MenuBar mb;
	Menu mFile;
	MenuItem miNew, miOpen, miSaveAs, miExit;
	
	

	public TextEditor(String title) {
		super(title);
		content = new TextArea();
		add(content);
		
		mb = new MenuBar();
		mFile = new Menu("File");
		miNew = new MenuItem("New");
		miOpen = new MenuItem("Open");
		miSaveAs = new MenuItem("Save As...");
		miExit = new MenuItem("Exit");
		
		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.add(miSaveAs);
		mFile.addSeparator();
		mFile.add(miExit);
		
		mb.add(mFile);
		setMenuBar(mb);
		
		MyHandler handler = new MyHandler();
		miNew.addActionListener(handler);
		miOpen.addActionListener(handler);
		miSaveAs.addActionListener(handler);
		miExit.addActionListener(handler);
		
		setSize(300, 200);
		setVisible(true);
		
	}
	
	void fileOpen(String fileName) {
		FileReader fr;
		BufferedReader br;
		StringWriter sw;
		
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			sw = new StringWriter();
			
			int ch = 0;
			while ((ch=br.read())!=-1) {
				sw.write(ch);
			}
			
			br.close();
			content.setText(sw.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void saveAs(String fileName) {
		FileWriter fw;
		BufferedWriter bw;
		
		try {
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			bw.write(content.getText());
			bw.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TextEditor mainWin = new TextEditor("Text Editor");
	}
	
	class MyHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			
			if (command.equals("New")) {
				content.setText("");
			} else if(command.equals("Open")){
				FileDialog fileOpen = new FileDialog(TextEditor.this, "파일열기");
				fileOpen.setVisible(true);
				fileName = fileOpen.getDirectory() + fileOpen.getFile();
				System.out.println(fileName);
				fileOpen(fileName);
			} else if(command.equals("Save As...")) {
				FileDialog fileSave = new FileDialog(TextEditor.this, "파일저장", FileDialog.SAVE);
				fileSave.setVisible(true);
				fileName = fileSave.getDirectory();
				System.out.println(fileName);
				saveAs(fileName);
			} else if(command.equals("Exit")) {
				System.exit(0);
			}
		}
	}
}
