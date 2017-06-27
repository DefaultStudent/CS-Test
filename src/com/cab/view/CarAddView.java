package com.cab.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cab.db.CarDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarAddView extends JFrame {

	private JPanel areaJCB;
	private JTextField carIdJTF;
	private JTextField carTypeJTF;
	private JTextField carStateJTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarAddView frame = new CarAddView();
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
	public CarAddView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 393);
		areaJCB = new JPanel();
		areaJCB.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(areaJCB);
		areaJCB.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8F66\u8F86\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(34, 35, 93, 18);
		areaJCB.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8F66\u8F86\u72B6\u6001\uFF1A");
		lblNewLabel_1.setBounds(34, 158, 93, 18);
		areaJCB.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8F66\u8F86\u7C7B\u578B\uFF1A");
		lblNewLabel_2.setBounds(303, 35, 93, 18);
		areaJCB.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6240\u5C5E\u5730\u533A");
		lblNewLabel_3.setBounds(303, 158, 93, 18);
		areaJCB.add(lblNewLabel_3);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u629A\u987A\u5E02", "\u5927\u8FDE\u5E02", "\u9526\u5DDE\u5E02"}));
		comboBox.setBounds(411, 155, 130, 24);
		areaJCB.add(comboBox);
		
		carIdJTF = new JTextField();
		carIdJTF.setBounds(141, 32, 131, 24);
		areaJCB.add(carIdJTF);
		carIdJTF.setColumns(10);
		
		carTypeJTF = new JTextField();
		carTypeJTF.setBounds(410, 32, 131, 24);
		areaJCB.add(carTypeJTF);
		carTypeJTF.setColumns(10);
		
		carStateJTF = new JTextField();
		carStateJTF.setBounds(141, 155, 131, 24);
		areaJCB.add(carStateJTF);
		carStateJTF.setColumns(10);
		
		JButton addJB = new JButton("\u6DFB\u52A0");
		addJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int carId = Integer.parseInt(carIdJTF.getText().trim());
				String carType = carTypeJTF.getText().trim();
				String carState = carStateJTF.getText().trim();
				String areaName = (String) comboBox.getSelectedItem();
				
				int i = CarDao.insertCar(carId, carType, areaName, carState);
				if (i == 1){
					JOptionPane.showMessageDialog(null, "添加成功");
					carIdJTF.setText("");
					carTypeJTF.setText("");
					carStateJTF.setText("");
					comboBox.setSelectedItem("抚顺市");
				}
			}
		});
		addJB.setBounds(34, 284, 113, 27);
		areaJCB.add(addJB);
		
		JButton resetJB = new JButton("\u91CD\u7F6E");
		resetJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carIdJTF.setText("");
				carTypeJTF.setText("");
				carStateJTF.setText("");
			}
		});
		resetJB.setBounds(221, 284, 113, 27);
		areaJCB.add(resetJB);
		
		JButton closeJB = new JButton("\u5173\u95ED");
		closeJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		closeJB.setBounds(411, 284, 113, 27);
		areaJCB.add(closeJB);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
