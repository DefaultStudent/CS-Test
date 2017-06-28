package com.cab.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cab.db.AreaDao;
import com.cab.modle.Area;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AreaSelectView extends JFrame {

	private JPanel contentPane;
	private JTextField areaIdJTF;
	private JTextField areaNameJTF;
	private JTable jtable;
	
	private String[] areahead = {"地区编号", "地区名称"};
	private Object[][] getSelect(List<Area> list){
		Object[][] results = new Object[list.size()][areahead.length];
		for (int i = 0; i < list.size(); i++){
			Area area = list.get(i);
			results[i][0] = area.getAreaid();
			results[i][1] = area.getAreaname();
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
					AreaSelectView frame = new AreaSelectView();
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
	public AreaSelectView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5730\u533A\u7F16\u53F7\uFF1A");
		label.setBounds(39, 34, 100, 18);
		contentPane.add(label);
		
		areaIdJTF = new JTextField();
		areaIdJTF.setBounds(126, 31, 242, 24);
		contentPane.add(areaIdJTF);
		areaIdJTF.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5730\u533A\u540D\u79F0\uFF1A");
		label_1.setBounds(39, 118, 93, 18);
		contentPane.add(label_1);
		
		areaNameJTF = new JTextField();
		areaNameJTF.setBounds(126, 115, 242, 24);
		contentPane.add(areaNameJTF);
		areaNameJTF.setColumns(10);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(468, 34, 150, 210);
		Object[][] results = getSelect(AreaDao.selectArea());
		jtable = new JTable(results, areahead);
		jtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selRow = jtable.getSelectedRow();
				areaIdJTF.setText(jtable.getValueAt(selRow, 0).toString().trim());
				areaNameJTF.setText(jtable.getValueAt(selRow, 1).toString().trim());
			}
		});
		jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(jtable);
		contentPane.add(scrollPane);
		
		JButton selectJB = new JButton("\u67E5\u8BE2");
		selectJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (areaIdJTF.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "地区编号不能为空！");
	                return;
				} else{
					int areaid = Integer.parseInt(areaIdJTF.getText().trim());
					Object[][] results = getSelect(AreaDao.selectAreaById(areaid));
					jtable = new JTable(results, areahead);
					scrollPane.setViewportView(jtable);
				}
			}
		});
		selectJB.setBounds(14, 217, 113, 27);
		contentPane.add(selectJB);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int areaid = Integer.parseInt(areaIdJTF.getText().trim());
				String areaname = areaNameJTF.getText().trim();
				
				int i = AreaDao.updateArea(areaid, areaname);
				if (i == 1){
					JOptionPane.showMessageDialog(null, "修改成功！");
				}
			}
		});
		btnNewButton.setBounds(163, 217, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int areaid = Integer.parseInt(areaIdJTF.getText().trim());
				
				int i = AreaDao.deleteArea(areaid);
				if (i == 1){
					JOptionPane.showMessageDialog(null, "删除成功！");
				}
			}
		});
		btnNewButton_1.setBounds(310, 217, 113, 27);
		contentPane.add(btnNewButton_1);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
