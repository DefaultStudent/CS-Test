package com.cab.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cab.db.UserDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserUpdateandDeleteView extends JFrame {

	private JPanel contentPane;
	private JTextField userIdJTF;
	private JTextField userNameJTF;
	private JTextField telJTF;
	private ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUpdateandDeleteView frame = new UserUpdateandDeleteView();
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
	public UserUpdateandDeleteView() {
		setTitle("\u7528\u6237\u4FEE\u6539\u5220\u9664");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u7F16\u53F7\uFF1A");
		label.setBounds(14, 52, 84, 18);
		contentPane.add(label);
		
		userIdJTF = new JTextField();
		userIdJTF.setBounds(108, 49, 130, 24);
		contentPane.add(userIdJTF);
		userIdJTF.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u59D3\u540D\uFF1A");
		label_1.setBounds(252, 52, 84, 18);
		contentPane.add(label_1);
		
		userNameJTF = new JTextField();
		userNameJTF.setBounds(350, 49, 130, 24);
		contentPane.add(userNameJTF);
		userNameJTF.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setBounds(14, 136, 72, 18);
		contentPane.add(label_2);
		
		final JRadioButton maleJRB = new JRadioButton("\u7537");
		maleJRB.setBounds(108, 132, 43, 27);
		buttonGroup.add(maleJRB);
		maleJRB.setSelected(true);
		contentPane.add(maleJRB);
		
		JRadioButton femaleJRB = new JRadioButton("\u5973");
		femaleJRB.setBounds(195, 132, 43, 27);
		buttonGroup.add(femaleJRB);
		contentPane.add(femaleJRB);
		
		JLabel label_3 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		label_3.setBounds(252, 136, 84, 18);
		contentPane.add(label_3);
		
		telJTF = new JTextField();
		telJTF.setBounds(350, 133, 130, 24);
		contentPane.add(telJTF);
		telJTF.setColumns(10);
		
		//用户信息修改按钮单击响应事件
		JButton updateJB = new JButton("\u4FEE\u6539");
		updateJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userid = Integer.parseInt(userIdJTF.getText().trim());
				String username = userNameJTF.getText().trim();
				String sex = "男";
				if (!maleJRB.isSelected()){
					sex = "女";
				}
				String tel = telJTF.getText().trim();
				
				if (userIdJTF.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "用户编号不能为空！");
				} else if (username.equals("")){
					JOptionPane.showMessageDialog(null, "用户姓名不能为空！");
				} else if (tel.equals("")){
					JOptionPane.showMessageDialog(null, "联系电话不能为空！");
				} else{
					int i = UserDao.updateUser(userid, username, sex, tel);
					if (i == 1){
						JOptionPane.showMessageDialog(null, "修改成功");
					}
				}
			}
		});
		updateJB.setBounds(125, 202, 113, 27);
		contentPane.add(updateJB);
		
		//用户信息删除按钮单击响应事件
		JButton deleteJB = new JButton("\u5220\u9664");
		deleteJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userid = Integer.parseInt(userIdJTF.getText().trim());
				
				if (userIdJTF.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "用户编号不能为空！");
				}else{
					int i = UserDao.deleteUser(userid);
					if (i == 1){
						JOptionPane.showMessageDialog(null, "删除成功");
					}
				}
			}
		});
		deleteJB.setBounds(252, 202, 113, 27);
		contentPane.add(deleteJB);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
