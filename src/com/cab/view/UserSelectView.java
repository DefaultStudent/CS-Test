package com.cab.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cab.db.CarDao;
import com.cab.db.UserDao;
import com.cab.modle.User;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserSelectView extends JFrame {

	private JPanel contentPane;
	private JTextField printJTF;
	private JTable jtable;
	
	private String[] userhead = {"用户编号", "用户姓名", "性别", "联系电话"};
	private Object[][] getSelect(List<User> list){
		Object[][] results = new Object[list.size()][userhead.length];
		for (int i = 0; i < list.size(); i++){
			User user = list.get(i);
			results[i][0] = user.getUserid();
			results[i][1] = user.getUsername();
			results[i][2] = user.getSex();
			results[i][3] = user.getTel();
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
					UserSelectView frame = new UserSelectView();
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
	public UserSelectView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6309\u7F16\u53F7\u67E5\u8BE2", "\u6309\u59D3\u540D\u67E5\u8BE2", "\u6309\u7535\u8BDD\u67E5\u8BE2"}));
		comboBox.setBounds(14, 13, 101, 24);
		contentPane.add(comboBox);
		
		printJTF = new JTextField();
		printJTF.setBounds(129, 13, 187, 24);
		contentPane.add(printJTF);
		printJTF.setColumns(10);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 108, 302, 240);
		Object[][] results = getSelect(UserDao.selectUser());
		jtable = new JTable(results, userhead);
		jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(jtable);
		contentPane.add(scrollPane);
		
		//用户信息查询按钮监听响应事件
		JButton selectJB = new JButton("\u67E5\u8BE2");
		selectJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String condition = (String)comboBox.getSelectedItem();
				
				if (condition.equals("按编号查询")){
					int userid = Integer.parseInt(printJTF.getText().trim());
					Object[][] results = getSelect(UserDao.selectUserById(userid));
					jtable = new JTable(results, userhead);
					scrollPane.setViewportView(jtable);
				} else if (condition.equals("按姓名查询")){
					String username = printJTF.getText().trim();
					Object[][] results = getSelect(UserDao.selectUserByUserName(username));
					jtable = new JTable(results, userhead);
					scrollPane.setViewportView(jtable);
				} else if (condition.equals("按电话查询")){
					String tel = printJTF.getText().trim();
					Object[][] results = getSelect(UserDao.selectUserByTel(tel));
					jtable = new JTable(results, userhead);
					scrollPane.setViewportView(jtable);
				}
			}
		});
		selectJB.setBounds(14, 68, 113, 27);
		contentPane.add(selectJB);
		
		//用户信息重置按钮监听响应事件
		JButton resetJB = new JButton("\u91CD\u7F6E");
		resetJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedItem("按编号查询");
				printJTF.setText("");
			}
		});
		resetJB.setBounds(203, 68, 113, 27);
		contentPane.add(resetJB);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
