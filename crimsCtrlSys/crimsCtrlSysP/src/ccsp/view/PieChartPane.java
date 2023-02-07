package ccsp.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ccsp.models.ChartDataSet;
import ccsp.models.CrimeSysDAO;

// MALE 65
// FEMALE 100

public class PieChartPane extends JPanel {
	CrimeSysDAO crDAO = new CrimeSysDAO();
	String[] caption = { "성별 조회", "지역 조회", "범죄 구분 조회" };
	ArrayList<Integer> data = new ArrayList(); // 들어갈 데이터
	ArrayList<String> dataName = new ArrayList(); // 들어갈 데이터 이름
	ArrayList<Integer> arcAngle = new ArrayList();
	ArrayList<ChartDataSet> chartArr;

	Color[] color = { new Color(128, 128, 128), new Color(255, 0, 0), new Color(255, 255, 0), new Color(128, 128, 0),
			new Color(0, 255, 0), new Color(0, 255, 255), new Color(255, 0, 255), new Color(205, 133, 63),
			new Color(238, 130, 238), new Color(75, 0, 130), new Color(70, 130, 180), new Color(47, 79, 79),
			new Color(60, 179, 113), new Color(250, 250, 210), new Color(240, 128, 128), new Color(165, 42, 42),
			new Color(218, 165, 32) };

	JTextField[] tf = new JTextField[4];
	ChartPanel chartPanel = new ChartPanel();
//	LabelPanel labelPanel;

	PieChartPane() {
		chartArr = crDAO.getGenderChart();
		for (int i = 0; i < chartArr.size(); i++) {
			data.add(chartArr.get(i).dataValue);
			dataName.add(chartArr.get(i).dataKey);
		}

		setLayout(new BorderLayout());
		add(new InputPanel(), BorderLayout.NORTH);
		add(chartPanel, BorderLayout.CENTER);
		drawChart();
	}

	void drawChart() {
		for (int i = 0; i < data.size(); i++) {
			arcAngle.add((int) Math.round((double) data.get(i) / (double) data.size() * 360));
		}

		chartPanel.repaint();
	}

	class InputPanel extends JPanel {
		InputPanel() {
			for (int i = 0; i < caption.length; i++) {
				JButton btn = new JButton(caption[i].toString());
				btn.addActionListener(new MyActionListener());
				add(btn);
			}
		}

		class MyActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String e_type = e.getActionCommand();

				try {
					data.clear();
					dataName.clear();
					arcAngle.clear();
					if (e_type.equals(caption[0].toString())) {
						chartArr = crDAO.getGenderChart();
						for (int i = 0; i < chartArr.size(); i++) {
							data.add(chartArr.get(i).dataValue);
							dataName.add(chartArr.get(i).dataKey);
						}
					}
					if (e_type.equals(caption[1].toString())) {
						chartArr = crDAO.getRegionChart();
						for (int i = 0; i < chartArr.size(); i++) {
							data.add(chartArr.get(i).dataValue);
							dataName.add(chartArr.get(i).dataKey);
						}
					}
					if (e_type.equals(caption[2].toString())) {
						chartArr = crDAO.getCrimCateChart();
						for (int i = 0; i < chartArr.size(); i++) {
							data.add(chartArr.get(i).dataValue);
							dataName.add(chartArr.get(i).dataKey);
						}
					}
				} catch (NumberFormatException ex) {
					return;
				}
				drawChart();
			}
		}
	}

	class LabelPanel extends JPanel {
		public LabelPanel() {
			System.out.println(dataName.size());
			for (int i = 0; i < data.size(); i++) {
				System.out.println(dataName.get(i) + Math.round(arcAngle.get(i) * 100. / 360.) + "%");
				JLabel label = new JLabel(dataName.get(i) + Math.round(arcAngle.get(i) * 100. / 360.) + "%");
				label.setForeground(color[i]);
				add(label);
			}
		}
	}

	class ChartPanel extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int startAngle = 0;

			for (int i = 0; i < data.size(); i++) {
				g.setColor(color[i]);
				g.drawString(dataName.get(i) + " " + Math.round(arcAngle.get(i) * 100. / 360.) + "%", 50 + i * 100, 20);
			}
			for (int i = 0; i < data.size(); i++) {
				g.setColor(color[i]);
				g.fillArc(750, 150, 450, 450, startAngle, arcAngle.get(i));
				startAngle = startAngle + arcAngle.get(i);
			}
		}
	}

}