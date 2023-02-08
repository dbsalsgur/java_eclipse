package ccsp.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import ccsp.models.CrimeRecordVO;
import ccsp.models.CrimeSysDAO;

public class AddPanel extends JPanel implements ItemListener, ActionListener {

	private JPanel jp[] = new JPanel[8];
	private JLabel jl[] = new JLabel[7];
	private JTextField tf[] = new JTextField[3];
	private JButton insert;
	// ok(추가하기) 버튼
	private JButton reset;
	// reset(다시하기)버튼
	JComboBox rcombo = new JComboBox();
	JComboBox scombo = new JComboBox();
	JComboBox ctgycombo = new JComboBox();
	JComboBox crcombo = new JComboBox();
	JComboBox[] comboBoxes = { rcombo, scombo, ctgycombo, crcombo };

	String[] caption = { "犯罪分類 : ", "地域 : ", "性別 : ", "前科 : ", "名前 : ", "住民登録番号 : ", "発生日 : " };

	public AddPanel() {
		setLayout(new GridLayout(9, 1));
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);
		ArrayList<String> regionDataList = new ArrayList<String>();
		ArrayList<String> sexDataList = new ArrayList<String>();
		ArrayList<String> categoryDataList = new ArrayList<String>();
		ArrayList<String> cRecordDataList = new ArrayList<String>();
		CrimeSysDAO crDAO = new CrimeSysDAO();

		int size = caption.length;

		for (int i = 0; i <= 3; i++) {
			jl[i] = new JLabel(caption[i]);
			jp[i] = new JPanel();
			jp[i].add(jl[i]);
			add(jp[i]);
		}
		for (int i = 4; i < size; i++) {
			jl[i] = new JLabel(caption[i]);
			tf[i - 4] = new JTextField(10);
			jp[i] = new JPanel();
			jp[i].add(jl[i]);
			jp[i].add(tf[i - 4]);
			add(jp[i]);
			tf[i - 4].setEditable(true);
		}

		ctgycombo.addItem("番号を選択してください");
		categoryDataList = crDAO.getCrimeCategoryTableData();
		addCbboxItem(ctgycombo, categoryDataList);
		jp[0].add(ctgycombo);
		ctgycombo.addActionListener(this);
		ctgycombo.addItemListener(this);

		rcombo.addItem("地域を選択してください");
		regionDataList = crDAO.getCrimeRegionTableData();
		addCbboxItem(rcombo, regionDataList);
		jp[1].add(rcombo);
		rcombo.addActionListener(this);
		rcombo.addItemListener(this);

		scombo.addItem("性別を選択してください");
		sexDataList = crDAO.getCrimeSexTableData();
		addCbboxItem(scombo, sexDataList);
		jp[2].add(scombo);
		scombo.addActionListener(this);
		scombo.addItemListener(this);

		crcombo.addItem("前科の有無を選択してください");
		cRecordDataList = crDAO.getCRecordTableData();
		addCbboxItem(crcombo, cRecordDataList);
		jp[3].add(crcombo);
		crcombo.addActionListener(this);
		crcombo.addItemListener(this);

		jp[size] = new JPanel();
		insert = new JButton("追加");
		insert.addActionListener(this);
		reset = new JButton("リセット");
		reset.addActionListener(this);
		jp[size].add(insert);
		jp[size].add(reset);
		add(jp[size]);

	}

	public void addCbboxItem(JComboBox cbbox, ArrayList<String> list) {
		for (int i = 1; i <= list.size(); i++) {
			cbbox.addItem(i + ". " + list.get(i - 1));
		}

	}

	@Override
	public void itemStateChanged(ItemEvent ie) {

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String ae_type = ae.getActionCommand();
		CrimeRecordVO crVO = null;
		CrimeSysDAO crDAO = null;
		int regitNumInput = 0;
		if (ae_type.equals(insert.getText())) {
			try {
				System.out.println(tf[1].getText());
				regitNumInput = Integer.parseInt(tf[1].getText().trim());
				crVO = new CrimeRecordVO(0, rcombo.getSelectedIndex(), scombo.getSelectedIndex(),
						crcombo.getSelectedIndex(), tf[0].getText().trim(), regitNumInput, tf[2].getText().trim(),
						ctgycombo.getSelectedIndex());
				crDAO = new CrimeSysDAO();
				crDAO.getCriminalRegister(crVO);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("input error");
				System.out.println("e=[" + e + "e");
			}
			if (crVO != null) {
				JOptionPane.showMessageDialog(this, tf[0].getText() + "様が成功的に追加されました");
			} else {
				JOptionPane.showMessageDialog(this, "正しくありません" + "\n" + "入力内容を確認してください");
			}
		} else if (ae_type.equals(reset.getText())) {
			for (int i = 0; i < tf.length; i++) {
				tf[i].setText("");
			}
			for (int i = 0; i < comboBoxes.length; i++) {
				comboBoxes[i].setSelectedIndex(0);
			}
		}
	}

}
