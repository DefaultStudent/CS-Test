package com.cab.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class loginView extends JFrame {

	private JPanel contentPane;
	private JTextField useridJTF;
	private JPasswordField pwdJPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginView frame = new loginView();
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
	public loginView() {
		setBackground(new Color(0, 0, 0));
		setTitle("\u6B22\u8FCE\u767B\u9646");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 358);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setBounds(95, 88, 108, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(95, 153, 108, 18);
		contentPane.add(lblNewLabel_1);
		
		useridJTF = new JTextField();
		useridJTF.setBounds(217, 85, 144, 24);
		contentPane.add(useridJTF);
		useridJTF.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B\u9646");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (useridJTF.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "用户账户不可以为空");
	                return;
				} else if (pwdJPF.getPassword().length == 0){
					JOptionPane.showMessageDialog(null, "密码不可以为空");
	                return;
				} else if (useridJTF.getText().equals("admin") && pwdJPF.getText().equals("admin")){
					Index index = new Index();
					index.setVisible(true);
					loginView lg = new loginView();
					lg.setVisible(false);
				} else{
					JOptionPane.showMessageDialog(null, "账户或密码错误");
	                return;
				}
			}
		});
		btnNewButton.setBounds(50, 256, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setBackground(SystemColor.menu);
		btnNewButton_1.setBounds(248, 256, 113, 27);
		contentPane.add(btnNewButton_1);
		
		pwdJPF = new JPasswordField();
		pwdJPF.setBounds(217, 150, 144, 24);
		contentPane.add(pwdJPF);
		
		JLabel label = new JLabel("\u8F66\u8F86\u51FA\u79DF\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("宋体", Font.BOLD, 21));
		label.setBounds(123, 34, 218, 18);
		contentPane.add(label);
		
		JLabel lbladminadmin = new JLabel("\u767B\u9646\u8D26\u53F7\u4E3A\uFF1Aadmin,       \u5BC6\u7801\u4E3A\uFF1Aadmin\u3002");
		lbladminadmin.setBounds(71, 214, 347, 18);
		contentPane.add(lbladminadmin);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
