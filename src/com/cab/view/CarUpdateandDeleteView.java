package com.cab.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cab.db.CarDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarUpdateandDeleteView extends JFrame {

	private JPanel contentPane;
	private JTextField carIdJTF;
	private JTextField carStateJTF;
	private JTextField carTypeJTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarUpdateandDeleteView frame = new CarUpdateandDeleteView();
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
	public CarUpdateandDeleteView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8F66\u8F86\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(34, 33, 90, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8F66\u8F86\u72B6\u6001\uFF1A");
		lblNewLabel_1.setBounds(34, 119, 90, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8F66\u8F86\u7C7B\u578B\uFF1A");
		lblNewLabel_2.setBounds(298, 33, 90, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6240\u5728\u5730\u533A\uFF1A");
		lblNewLabel_3.setBounds(298, 119, 90, 18);
		contentPane.add(lblNewLabel_3);
		
		carIdJTF = new JTextField();
		carIdJTF.setBounds(125, 30, 135, 24);
		contentPane.add(carIdJTF);
		carIdJTF.setColumns(10);
		
		carStateJTF = new JTextField();
		carStateJTF.setBounds(125, 116, 135, 24);
		contentPane.add(carStateJTF);
		carStateJTF.setColumns(10);
		
		carTypeJTF = new JTextField();
		carTypeJTF.setBounds(395, 30, 135, 24);
		contentPane.add(carTypeJTF);
		carTypeJTF.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u629A\u987A\u5E02", "\u5927\u8FDE\u5E02", "\u9526\u5DDE\u5E02"}));
		comboBox.setBounds(395, 116, 135, 24);
		contentPane.add(comboBox);
		
		//车辆信息修改按钮单击响应事件
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (carIdJTF.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "请输入车辆编号！");
				} else{
					int carid = Integer.parseInt(carIdJTF.getText().trim());
					String cartype = carTypeJTF.getText().trim();
					String carstate = carStateJTF.getText().trim();
					String area = (String) comboBox.getSelectedItem();
				
					int i = CarDao.updateCar(carid, cartype, area, carstate);
					if (i == 1){
						JOptionPane.showMessageDialog(null, "修改成功");
					}
				}
			}
		});
		button.setBounds(125, 234, 113, 27);
		contentPane.add(button);
		
		//车辆信息删除按钮单击响应事件
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (carIdJTF.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "请输入车辆编号！");
				} else{
					int carid = Integer.parseInt(carIdJTF.getText().trim());
					
					int i = CarDao.deleteCar(carid);
					if (i == 1){
						JOptionPane.showMessageDialog(null, "删除成功");
					}
				}
			}
		});
		button_1.setBounds(330, 234, 113, 27);
		contentPane.add(button_1);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
