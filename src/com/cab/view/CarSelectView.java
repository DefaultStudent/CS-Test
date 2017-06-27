package com.cab.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cab.db.AreaDao;
import com.cab.db.CarDao;
import com.cab.modle.Car;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class CarSelectView extends JFrame {

	private JPanel contentPane;
	private JTextField printJTF;
	private JTable jtable;
	
	private String[] carhead = {"车辆编号", "车辆类型", "车辆状态", "所属地区"};
	private Object[][] getSelect(List<Car> list){
		Object[][] results = new Object[list.size()][carhead.length];
		for (int i = 0; i < list.size(); i++){
			Car car = list.get(i);
			results[i][0] = car.getCarid();
			results[i][1] = car.getCartype();
			results[i][2] = car.getCarstate();
			results[i][3] = car.getArename();
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
					CarSelectView frame = new CarSelectView();
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
	public CarSelectView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		printJTF = new JTextField();
		printJTF.setBounds(168, 23, 185, 24);
		contentPane.add(printJTF);
		printJTF.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6309\u7F16\u53F7\u67E5\u8BE2", "\u6309\u7C7B\u578B\u67E5\u8BE2", "\u6309\u72B6\u6001\u67E5\u8BE2", "\u6309\u5730\u533A\u67E5\u8BE2"}));
		comboBox.setBounds(45, 23, 109, 24);
		contentPane.add(comboBox);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 141, 304, 225);
		Object[][] results = getSelect(CarDao.selectCar());
		jtable = new JTable(results, carhead);
		jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(jtable);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String condition = (String) comboBox.getSelectedItem();
				
				if (condition.equals("按编号查询")){
					int carid = Integer.parseInt(printJTF.getText().trim());
					Object[][] results = getSelect(CarDao.selectCarById(carid));
					jtable = new JTable(results, carhead);
					scrollPane.setViewportView(jtable);
				} else if (condition.equals("按类型查询")){
					String cartype = printJTF.getText().trim();
					Object[][] results = getSelect(CarDao.selectCarByType(cartype));
					jtable = new JTable(results, carhead);
					scrollPane.setViewportView(jtable);
				} else if (condition.equals("按状态查询")){
					String carstate = printJTF.getText().trim();
					Object[][] results = getSelect(CarDao.selectCarByState(carstate));
					jtable = new JTable(results, carhead);
					scrollPane.setViewportView(jtable);
				} else if (condition.equals("按地区查询")){
					String area = printJTF.getText().trim();
					Object[][] results = getSelect(CarDao.selectCarByArea(area));
					jtable = new JTable(results, carhead);
					scrollPane.setViewportView(jtable);
				}
			}
		});
		btnNewButton.setBounds(45, 85, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u6E05\u7A7A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printJTF.setText("");
				comboBox.setSelectedItem("按编号查询");
				Object[][] results = getSelect(CarDao.selectCar());
				jtable = new JTable(results, carhead);
				jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				scrollPane.setViewportView(jtable);
			}
		});
		button.setBounds(240, 85, 113, 27);
		contentPane.add(button);
	}

}
