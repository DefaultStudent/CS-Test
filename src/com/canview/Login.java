package com.canview;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame{
	private JPanel textJP, loginJP, buttonJP;
	private JLabel textJL, useridJL, passwordJL;
	private JTextField useridJTF;
	private JPasswordField pwdJPF;
	private JButton loginJB, resetJB;
	private Font f1 = new Font("����", Font.BOLD, 32);
	
	public Login(){
		setSize (260, 180);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width / 2 - 200, height / 2 - 150);
		setTitle("Welcome use C.A.B System");
		textJP = new JPanel();
		loginJP = new JPanel();
		buttonJP = new JPanel();
		
		textJL = new JLabel();
		textJL.setFont(f1);
		textJL.setText("��������ϵͳ");
		textJP.add(textJL);
		
		this.add(textJP, BorderLayout.NORTH);
		
		loginJP.setLayout(new GridLayout(2, 2));
		useridJL = new JLabel("�û��˻���");
		useridJL.setHorizontalAlignment(SwingConstants.CENTER);
		useridJTF = new JTextField();
		passwordJL = new JLabel("���룺");
		passwordJL.setHorizontalAlignment(SwingConstants.CENTER);
		pwdJPF = new JPasswordField();
		
		loginJP.add(useridJL);
		loginJP.add(useridJTF);
		loginJP.add(passwordJL);
		loginJP.add(pwdJPF);
		
		this.add(loginJP, BorderLayout.CENTER);
		
		loginJB = new JButton("��½");
		loginJB.addActionListener(new LoginAddAction());
		resetJB = new JButton("����");
		resetJB.addActionListener(new ResetAction());
		buttonJP.add(loginJB);
		buttonJP.add(resetJB);
		this.add(buttonJP, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		setResizable(false);
	}
	
	class LoginAddAction implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			if (useridJTF.getText().length() == 0){
				JOptionPane.showMessageDialog(null, "�û��˻�������Ϊ��");
                return;
			} else if (pwdJPF.getPassword().length == 0){
				JOptionPane.showMessageDialog(null, "���벻����Ϊ��");
                return;
			} else if (useridJTF.getText().equals("admin") && pwdJPF.getText().equals("admin")){
				new Index();
			} else{
				JOptionPane.showMessageDialog(null, "�˻����������");
                return;
			}
		}
	}
	
	class ResetAction implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			useridJTF.setText("");
			pwdJPF.setText("");
		}
	}
	
	public static void main(String[] args){
		new Login();
	}

}
