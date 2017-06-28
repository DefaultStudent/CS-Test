package com.cab.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cab.db.AreaDao;
import com.cab.db.BorrowInfoDao;
import com.cab.modle.Area;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;

public class BorrowInfoAddView extends JFrame {

	private JPanel contentPane;
	private JTextField userIdJTF;
	private JTextField userNameJTF;
	private JTextField carIdJTF;
	private JTextField dateJTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowInfoAddView frame = new BorrowInfoAddView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BorrowInfoAddView() {
		setTitle("\u79DF\u501F\u4FE1\u606F\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u7F16\u53F7\uFF1A");
		label.setBounds(14, 80, 80, 18);
		contentPane.add(label);
		
		userIdJTF = new JTextField();
		userIdJTF.setBounds(108, 77, 140, 24);
		contentPane.add(userIdJTF);
		userIdJTF.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u59D3\u540D\uFF1A");
		label_1.setBounds(320, 80, 80, 18);
		contentPane.add(label_1);
		
		userNameJTF = new JTextField();
		userNameJTF.setBounds(414, 77, 140, 24);
		contentPane.add(userNameJTF);
		userNameJTF.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8F66\u8F86\u7F16\u53F7\uFF1A");
		label_2.setBounds(14, 159, 80, 18);
		contentPane.add(label_2);
		
		carIdJTF = new JTextField();
		carIdJTF.setBounds(108, 156, 140, 24);
		contentPane.add(carIdJTF);
		carIdJTF.setColumns(10);
		
		JLabel label_3 = new JLabel("\u79DF\u501F\u8F66\u8F86\u6240\u5728\u5730\uFF1A");
		label_3.setBounds(320, 159, 125, 18);
		contentPane.add(label_3);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(459, 156, 95, 24);
		List<Area> list = AreaDao.selectArea();
		for (int i = 0; i < list.size(); i++){
			Area area = list.get(i);
			comboBox.addItem(area.getAreaname());
		}
		contentPane.add(comboBox);
		
		JLabel label_4 = new JLabel("\u79DF\u501F\u65E5\u671F\uFF1A");
		label_4.setBounds(14, 237, 80, 18);
		contentPane.add(label_4);
		
		dateJTF = new JTextField();
		dateJTF.setBounds(108, 234, 140, 24);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String str = format.format(new java.util.Date());
		dateJTF.setText(str);
		contentPane.add(dateJTF);
		dateJTF.setColumns(10);
		
		//添加按钮单击响应事件
		JButton aaddJB = new JButton("\u6DFB\u52A0");
		aaddJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int userid = Integer.parseInt(userIdJTF.getText().trim());
				String username = userNameJTF.getText().trim();
				int carid = Integer.parseInt(carIdJTF.getText().trim());
				String areaname = (String)comboBox.getSelectedItem();
				String borrowtime = dateJTF.getText().trim();
				
				int i = BorrowInfoDao.insertBorrowinfo(userid, username, carid, borrowtime, areaname);
				if (i == 1){
					JOptionPane.showMessageDialog(null, "添加成功");
				}
			}
		});
		aaddJB.setBounds(135, 304, 113, 27);
		contentPane.add(aaddJB);
		
		//重置按钮单击响应事件
		JButton resetJB = new JButton("\u91CD\u7F6E");
		resetJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userIdJTF.setText("");
				userNameJTF.setText("");
				carIdJTF.setText("");
				comboBox.setSelectedItem("抚顺市");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String str = format.format(new java.util.Date());
				dateJTF.setText(str);
			}
		});
		resetJB.setBounds(332, 304, 113, 27);
		contentPane.add(resetJB);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
