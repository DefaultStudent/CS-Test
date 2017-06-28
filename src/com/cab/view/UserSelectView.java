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
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserSelectView extends JFrame {

	private JPanel contentPane;
	private JTextField printJTF;
	private JTable jtable;
	private ButtonGroup buttonGroup = new ButtonGroup();
	
	private String[] userhead = {"�û����", "�û�����", "�Ա�", "��ϵ�绰"};
	private JTextField userIdJTF;
	private JTextField userNameJTF;
	private JTextField telJTF;
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
		setBounds(100, 100, 822, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6309\u7F16\u53F7\u67E5\u8BE2", "\u6309\u59D3\u540D\u67E5\u8BE2", "\u6309\u7535\u8BDD\u67E5\u8BE2"}));
		comboBox.setBounds(14, 13, 101, 24);
		contentPane.add(comboBox);
		
		printJTF = new JTextField();
		printJTF.setBounds(129, 13, 218, 24);
		contentPane.add(printJTF);
		printJTF.setColumns(10);
		
		
		
		
		JLabel label = new JLabel("\u7528\u6237\u7F16\u53F7\uFF1A");
		label.setBounds(14, 82, 101, 18);
		contentPane.add(label);
		
		userIdJTF = new JTextField();
		userIdJTF.setEnabled(false);
		userIdJTF.setBounds(129, 79, 218, 24);
		contentPane.add(userIdJTF);
		userIdJTF.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u59D3\u540D\uFF1A");
		label_1.setBounds(14, 143, 101, 18);
		contentPane.add(label_1);
		
		userNameJTF = new JTextField();
		userNameJTF.setBounds(129, 140, 218, 24);
		contentPane.add(userNameJTF);
		userNameJTF.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setBounds(43, 207, 72, 18);
		contentPane.add(label_2);
		
		final JRadioButton maleJRB = new JRadioButton("\u7537");
		maleJRB.setBounds(129, 203, 50, 27);
		buttonGroup.add(maleJRB);
		maleJRB.setSelected(true);
		contentPane.add(maleJRB);
		
		final JRadioButton femaleJRB = new JRadioButton("\u5973");
		femaleJRB.setBounds(190, 203, 50, 27);
		buttonGroup.add(femaleJRB);
		contentPane.add(femaleJRB);
		
		
		JLabel label_3 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		label_3.setBounds(14, 260, 101, 18);
		contentPane.add(label_3);
		
		telJTF = new JTextField();
		telJTF.setBounds(129, 257, 218, 24);
		contentPane.add(telJTF);
		telJTF.setColumns(10);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(488, 8, 302, 325);
		Object[][] results = getSelect(UserDao.selectUser());
		jtable = new JTable(results, userhead);
		jtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selRow = jtable.getSelectedRow();
				userIdJTF.setText(jtable.getValueAt(selRow, 0).toString().trim());
				userNameJTF.setText(jtable.getValueAt(selRow, 1).toString().trim());
				if (jtable.getValueAt(selRow, 2).toString().trim().equals("��")){
					maleJRB.setSelected(true);
				} else {
					femaleJRB.setSelected(true);
				}
				telJTF.setText(jtable.getValueAt(selRow, 3).toString());
			}
		});
		jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(jtable);
		contentPane.add(scrollPane);
		
		//�û���Ϣ��ѯ��ť������Ӧ�¼�
		JButton selectJB = new JButton("\u67E5\u8BE2");
		selectJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String condition = (String)comboBox.getSelectedItem();
				
				if (condition.equals("����Ų�ѯ")){
					int userid = Integer.parseInt(printJTF.getText().trim());
					Object[][] results = getSelect(UserDao.selectUserById(userid));
					jtable = new JTable(results, userhead);
					scrollPane.setViewportView(jtable);
				} else if (condition.equals("��������ѯ")){
					String username = printJTF.getText().trim();
					Object[][] results = getSelect(UserDao.selectUserByUserName(username));
					jtable = new JTable(results, userhead);
					scrollPane.setViewportView(jtable);
				} else if (condition.equals("���绰��ѯ")){
					String tel = printJTF.getText().trim();
					Object[][] results = getSelect(UserDao.selectUserByTel(tel));
					jtable = new JTable(results, userhead);
					scrollPane.setViewportView(jtable);
				}
			}
		});
		selectJB.setBounds(361, 12, 113, 27);
		contentPane.add(selectJB);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userid = Integer.parseInt(userIdJTF.getText().trim());
				String username = userNameJTF.getText().trim();
				String sex = "��";
				if (!maleJRB.isSelected()){
					sex = "Ů";
				}
				String tel = telJTF.getText().trim();
				
				if (userIdJTF.getText().trim().length() == 0){
					JOptionPane.showMessageDialog(null, "�û���Ų���Ϊ�գ�");
				} else if (username.length() == 0){
					JOptionPane.showMessageDialog(null, "�û���������Ϊ�գ�");
				} else if (tel.length() == 0){
					JOptionPane.showMessageDialog(null, "��ϵ�绰����Ϊ�գ�");
				} else{
					int i = UserDao.updateUser(userid, username, sex, tel);
					if (i == 1){
						JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
					}
				}
			}
		});
		button.setBounds(43, 321, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userid = Integer.parseInt(userIdJTF.getText().trim());
				
				if (userIdJTF.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "�û���Ų���Ϊ�գ�");
				}else{
					int i = UserDao.deleteUser(userid);
					if (i == 1){
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					}
				}
			}
		});
		button_1.setBounds(279, 321, 113, 27);
		contentPane.add(button_1);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
