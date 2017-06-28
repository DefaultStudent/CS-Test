package com.cab.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cab.db.AreaDao;
import com.cab.db.BorrowInfoDao;
import com.cab.db.ReturnInfoDao;
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

public class ReturnInfoAddView extends JFrame {

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
					ReturnInfoAddView frame = new ReturnInfoAddView();
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
	public ReturnInfoAddView() {
		setTitle("\u5F52\u8FD8\u4FE1\u606F\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u7F16\u53F7\uFF1A");
		label.setBounds(14, 55, 90, 18);
		contentPane.add(label);
		
		userIdJTF = new JTextField();
		userIdJTF.setBounds(118, 52, 170, 24);
		contentPane.add(userIdJTF);
		userIdJTF.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u59D3\u540D\uFF1A");
		label_1.setBounds(363, 55, 90, 18);
		contentPane.add(label_1);
		
		userNameJTF = new JTextField();
		userNameJTF.setBounds(467, 52, 170, 24);
		contentPane.add(userNameJTF);
		userNameJTF.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8F66\u8F86\u7F16\u53F7\uFF1A");
		label_2.setBounds(14, 140, 90, 18);
		contentPane.add(label_2);
		
		carIdJTF = new JTextField();
		carIdJTF.setBounds(118, 137, 170, 24);
		contentPane.add(carIdJTF);
		carIdJTF.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8F66\u8F86\u5F52\u8FD8\u5730\u533A\uFF1A");
		label_3.setBounds(363, 140, 120, 18);
		contentPane.add(label_3);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(522, 137, 115, 24);
		List<Area> list = AreaDao.selectArea();
		for (int i = 0; i < list.size(); i++){
			Area area = list.get(i);
			comboBox.addItem(area.getAreaname());
		} 
		contentPane.add(comboBox);
		
		JLabel label_4 = new JLabel("\u5F52\u8FD8\u65E5\u671F\uFF1A");
		label_4.setBounds(14, 226, 90, 18);
		contentPane.add(label_4);
		
		dateJTF = new JTextField();
		dateJTF.setBounds(118, 220, 170, 24);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String str = format.format(new java.util.Date());
		dateJTF.setText(str);
		contentPane.add(dateJTF);
		dateJTF.setColumns(10);
		
		JButton addButton = new JButton("\u6DFB\u52A0");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int userid = Integer.parseInt(userIdJTF.getText().trim());
				String username = userNameJTF.getText().trim();
				int carid = Integer.parseInt(carIdJTF.getText().trim());
				String area = (String)comboBox.getSelectedItem();
				String date = dateJTF.getText().trim();
				
				int i = ReturnInfoDao.insertReturninfo(userid, username, carid, date, area);
				if (i == 1){
					JOptionPane.showMessageDialog(null, "Ìí¼Ó³É¹¦");
				}
			}
		});
		addButton.setBounds(175, 300, 113, 27);
		contentPane.add(addButton);
		
		JButton resetJB = new JButton("\u91CD\u7F6E");
		resetJB.setBounds(363, 300, 113, 27);
		contentPane.add(resetJB);
	}

}
