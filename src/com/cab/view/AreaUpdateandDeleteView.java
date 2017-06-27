package com.cab.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cab.db.AreaDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AreaUpdateandDeleteView extends JFrame {

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
					AreaUpdateandDeleteView frame = new AreaUpdateandDeleteView();
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
	public AreaUpdateandDeleteView() {
		setTitle("\u5730\u533A\u4FE1\u606F\u4FEE\u6539\u5220\u9664");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5730\u533A\u7F16\u53F7\uFF1A");
		label.setBounds(104, 99, 91, 18);
		contentPane.add(label);
		
		areaIdJTF = new JTextField();
		areaIdJTF.setBounds(256, 96, 180, 24);
		contentPane.add(areaIdJTF);
		areaIdJTF.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5730\u533A\u540D\u79F0\uFF1A");
		label_1.setBounds(104, 189, 91, 18);
		contentPane.add(label_1);
		
		areaNameJTF = new JTextField();
		areaNameJTF.setBounds(256, 186, 180, 24);
		contentPane.add(areaNameJTF);
		areaNameJTF.setColumns(10);
		
		JButton updateJB = new JButton("\u4FEE\u6539");
		updateJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int areaid = Integer.parseInt(areaIdJTF.getText().trim());
				String areaname = areaNameJTF.getText().trim();
				
				int i = AreaDao.updateArea(areaid, areaname);
				if (i == 1){
					JOptionPane.showMessageDialog(null, "修改成功！");
					AreaSelectView areaSelectView = new AreaSelectView();
					areaSelectView.setVisible(true);
				}
			}
		});
		updateJB.setBounds(82, 294, 113, 27);
		contentPane.add(updateJB);
		
		JButton deleteJB = new JButton("\u5220\u9664");
		deleteJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int areaid = Integer.parseInt(areaIdJTF.getText().trim());
				
				int i = AreaDao.deleteArea(areaid);
				if (i == 1){
					JOptionPane.showMessageDialog(null, "删除成功！");
					AreaSelectView areaSelectView = new AreaSelectView();
					areaSelectView.setVisible(true);
				}
			}
		});
		deleteJB.setBounds(323, 294, 113, 27);
		contentPane.add(deleteJB);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
