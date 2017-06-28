package com.cab.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cab.db.ReturnInfoDao;
import com.cab.modle.Returninfo;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ReturnInfoSelectView extends JFrame {

	private JPanel contentPane;
	private JTextField printJTF;
	private JTable jtable;
	
	private String[] infohead = {"�û����", "�û�����", "�������", "������", "�������"};
	private Object[][] getSelect(List<Returninfo> list){
		Object[][] results = new Object[list.size()][infohead.length];
		for (int i = 0; i < list.size(); i ++){
			Returninfo returninfo = list.get(i);
			results[i][0] = returninfo.getUserid();
			results[i][1] = returninfo.getUsername();
			results[i][2] = returninfo.getCarid();
			results[i][3] = returninfo.getAreaname();
			results[i][4] = returninfo.getReturntime();
		}
		return results;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnInfoSelectView frame = new ReturnInfoSelectView();
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
	public ReturnInfoSelectView() {
		setTitle("\u5F52\u8FD8\u4FE1\u606F\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6309\u7528\u6237\u7F16\u53F7\u67E5\u8BE2", "\u6309\u7528\u6237\u59D3\u540D\u67E5\u8BE2", "\u6309\u8F66\u8F86\u7F16\u53F7\u67E5\u8BE2", "\u6309\u5F52\u8FD8\u5730\u533A\u67E5\u8BE2", "\u6309\u5F52\u8FD8\u65E5\u671F\u67E5\u8BE2"}));
		comboBox.setBounds(14, 13, 134, 24);
		contentPane.add(comboBox);
		
		printJTF = new JTextField();
		printJTF.setBounds(162, 13, 280, 24);
		contentPane.add(printJTF);
		printJTF.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 61, 558, 246);
		Object[][] results = getSelect(ReturnInfoDao.selectReturnInfo());
		jtable = new JTable(results, infohead);
		contentPane.add(scrollPane);
		
		JButton selectJB = new JButton("\u67E5\u8BE2");
		selectJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		selectJB.setBounds(456, 12, 113, 27);
		contentPane.add(selectJB);
		
		
	}

}
