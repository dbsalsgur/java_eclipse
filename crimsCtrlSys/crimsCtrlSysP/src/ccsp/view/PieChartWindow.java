package ccsp.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ChartPanel extends JPanel {
	PieChartWindow pcw;

	ChartPanel(PieChartWindow pcw) {
		this.pcw = pcw;
	}

	@Override
	public void paint(Graphics arg0) {
		super.paint(arg0);
		int startAngle = 0;// 0: 수평선에서 부터 그린다. 90: 수직선에서부터 그린다.
		for (int i = 0; i < pcw.data.length; i++) {
			arg0.setColor(pcw.colors[i]);// 그래프의 색을 설정
			arg0.drawString(pcw.titles[i] + "" + Math.round(pcw.arcAngle[i] * 100. / 360.) + "%", 50 + i * 100, 20);
			// 해당 그래프의 제목과 퍼센트를 출력한다.
		}
		for (int i = 0; i < pcw.data.length; i++) {
			arg0.setColor(pcw.colors[i]);// 그래프의 색을 설정
			arg0.fillArc(150, 50, 200, 200, startAngle, pcw.arcAngle[i]);
			startAngle = startAngle + pcw.arcAngle[i]; // 각도를 증가시킨다.
		}
	}
}

class InputPanel extends JPanel implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField t = (JTextField) e.getSource();
		int n = -1;
		try {
			n = Integer.parseInt(t.getText());
			// 입력한 값을 정수로 변환

		} catch (NumberFormatException nfe) {
			// 입력한 값이 정수가 아닌 경우

			t.setText("0"); // 입력한 창에 0을 입력
			return; // 메서드 종료
		}
		drawPieChart();// 파이그래프를 그린다.
	} // 데이터를 입력한 후 Enter를 누른 경우

	private void drawPieChart() {
		int sum = 0;
		for (int i = 0; i < pcw.data.length; i++) {
			pcw.data[i] = Integer.parseInt(pcw.inputs[i].getText());
			sum = sum + pcw.data[i];
		}
		if (sum == 0)
			return;// 입력간 데이터의 합이 0이면, 메서드 종료(왜? 그래프를 그릴 필요없으니까)
		for (int i = 0; i < pcw.data.length; i++) {
			pcw.arcAngle[i] = (int) Math.round((double) pcw.data[i] / (double) sum * 360);
		}
		pcw.chartPanel.repaint();
		// chartPanel을 다시 그리도록 한다.
	}

	PieChartWindow pcw;

	InputPanel(PieChartWindow pcw) {
		this.pcw = pcw;
		this.setBackground(Color.LIGHT_GRAY);// 배경색 설정
		for (int i = 0; i < pcw.inputs.length; i++) {
			pcw.inputs[i] = new JTextField("0", 5);
			// 초기값은 0, 길이, 4개 생성

			pcw.inputs[i].addActionListener(this);
			this.add(new JLabel(pcw.titles[i]));
			this.add(pcw.inputs[i]);
		}
	}
}

public class PieChartWindow extends JFrame {
	public int[] data = { 0, 0, 0, 0 }; // 초기데이터
	public int[] arcAngle = new int[4]; // 원의각도를 위한 배열 생성
	public Color[] colors = { Color.RED, Color.MAGENTA, Color.BLUE, new Color(165, 42, 42) };
	// 각 원의 색을 위한 배열
	// 색상사이트 https://en.wikipedia.org/wiki/Web_colors

	public String[] titles = { "사과", "딸기", "바나나", "키위" };// 각원의 제목
	public JTextField[] inputs = new JTextField[4];

	public ChartPanel chartPanel = new ChartPanel(this);
	private InputPanel inputPanel = new InputPanel(this);

	public PieChartWindow() {
		Container c = this.getContentPane();// 윈도우가 가지고 있는 패널을 획득
		c.add(inputPanel, BorderLayout.NORTH);
		c.add(chartPanel, BorderLayout.CENTER);
		this.setSize(500, 350);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}