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
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserAddView extends JFrame {

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
					UserAddView frame = new UserAddView();
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
	public UserAddView() {
		setTitle("\u7528\u6237\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(14, 50, 83, 18);
		contentPane.add(lblNewLabel);
		
		userIdJTF = new JTextField();
		userIdJTF.setBounds(111, 47, 116, 24);
		contentPane.add(userIdJTF);
		userIdJTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u6027\u522B");
		lblNewLabel_1.setBounds(14, 134, 83, 18);
		contentPane.add(lblNewLabel_1);
		
		final JRadioButton maleJRB = new JRadioButton("\u7537");
		buttonGroup.add(maleJRB);
		maleJRB.setSelected(true);
		maleJRB.setBounds(111, 130, 50, 27);
		contentPane.add(maleJRB);
		
		JRadioButton femaleJRB = new JRadioButton("\u5973");
		buttonGroup.add(femaleJRB);
		femaleJRB.setBounds(177, 130, 50, 27);
		contentPane.add(femaleJRB);
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u59D3\u540D\uFF1A");
		lblNewLabel_2.setBounds(280, 50, 83, 18);
		contentPane.add(lblNewLabel_2);
		
		userNameJTF = new JTextField();
		userNameJTF.setBounds(377, 47, 116, 24);
		contentPane.add(userNameJTF);
		userNameJTF.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		lblNewLabel_3.setBounds(280, 134, 83, 18);
		contentPane.add(lblNewLabel_3);
		
		telJTF = new JTextField();
		telJTF.setBounds(377, 131, 116, 24);
		contentPane.add(telJTF);
		telJTF.setColumns(10);
		
		//用户信息添加按钮单击响应事件
		JButton addJB = new JButton("\u6DFB\u52A0");
		addJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userid = Integer.parseInt(userIdJTF.getText().trim());
				String username = userNameJTF.getText().trim();
				String sex = "男";
				if (!maleJRB.isSelected()){
					sex = "女";
				}
				String tel = telJTF.getText().trim();
				
				if (!UserDao.selectUserById(userid).isEmpty()){
					JOptionPane.showMessageDialog(null, "该用户已存在");
					return;
				}
				
				if (userIdJTF.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "用户编号不能为空！");
					return;
				} else if (username.length() == 0){
					JOptionPane.showMessageDialog(null, "用户姓名不能为空！");
					return;
				} else if (tel.length() == 0){
					JOptionPane.showMessageDialog(null, "联系电话不能为空！");
					return;
				} else{
					int i = UserDao.insertUser(userid, username, sex, tel);
					if (i == 0){
						JOptionPane.showMessageDialog(null, "添加成功");
						userIdJTF.setText("");
						userNameJTF.setText("");
						maleJRB.setSelected(true);
						telJTF.setText("");
					}
				}
			}
		});
		addJB.setBounds(114, 231, 113, 27);
		contentPane.add(addJB);
		
		//用户信息重置按钮单击响应事件
		JButton resetJB = new JButton("\u91CD\u7F6E");
		resetJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		resetJB.setBounds(280, 231, 113, 27);
		contentPane.add(resetJB);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
