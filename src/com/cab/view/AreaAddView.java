package com.cab.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cab.db.AreaDao;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AreaAddView extends JFrame {

	private JPanel contentPane;
	private JTextField areaIdJTF;
	private JTextField areaNameJTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaAddView frame = new AreaAddView();
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
	public AreaAddView() {
		setTitle("\u5730\u533A\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel areaidJL = new JLabel("\u5730\u533A\u7F16\u53F7\uFF1A");
		areaidJL.setBounds(161, 90, 98, 18);
		contentPane.add(areaidJL);
		
		areaIdJTF = new JTextField();
		areaIdJTF.setBounds(273, 87, 199, 24);
		contentPane.add(areaIdJTF);
		areaIdJTF.setColumns(10);
		
		JLabel areaNameJL = new JLabel("\u5730\u533A\u540D\u79F0\uFF1A");
		areaNameJL.setBounds(161, 157, 98, 18);
		contentPane.add(areaNameJL);
		
		areaNameJTF = new JTextField();
		areaNameJTF.setBounds(273, 154, 199, 24);
		contentPane.add(areaNameJTF);
		areaNameJTF.setColumns(10);
		
		JButton addJB = new JButton("\u786E\u5B9A");
		addJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int areaId = Integer.parseInt(areaIdJTF.getText().trim());
				String areaName = areaNameJTF.getText().trim();
				
				int i = AreaDao.insertArea(areaId, areaName);
				if (i == 1){
					JOptionPane.showMessageDialog(null, "Ìí¼Ó³É¹¦");
					areaIdJTF.setText("");
					areaNameJTF.setText("");
				}
			}
		});
		addJB.setBounds(107, 273, 113, 27);
		contentPane.add(addJB);
		
		JButton resetJB = new JButton("\u91CD\u7F6E");
		resetJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				areaIdJTF.setText("");
				areaNameJTF.setText("");
			}
		});
		resetJB.setBounds(417, 273, 113, 27);
		contentPane.add(resetJB);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
