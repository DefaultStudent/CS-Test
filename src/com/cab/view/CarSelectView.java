package com.cab.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cab.db.AreaDao;
import com.cab.db.CarDao;
import com.cab.modle.Area;
import com.cab.modle.Car;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CarSelectView extends JFrame {

	private JPanel contentPane;
	private JTextField printJTF;
	private JTable jtable;
	
	private String[] carhead = {"车辆编号", "车辆类型", "车辆状态", "所属地区"};
	private JTextField carIdJTF;
	private JTextField carTypeJTF;
	private JTextField carStateJTF;
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
		setBounds(100, 100, 857, 450);
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
		
		JLabel lblNewLabel = new JLabel("\u8F66\u8F86\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(45, 112, 109, 18);
		contentPane.add(lblNewLabel);
		
		carIdJTF = new JTextField();
		carIdJTF.setEnabled(false);
		carIdJTF.setBounds(168, 109, 185, 24);
		contentPane.add(carIdJTF);
		carIdJTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8F66\u8F86\u7C7B\u578B\uFF1A");
		lblNewLabel_1.setBounds(45, 164, 109, 18);
		contentPane.add(lblNewLabel_1);
		
		carTypeJTF = new JTextField();
		carTypeJTF.setBounds(168, 161, 185, 24);
		contentPane.add(carTypeJTF);
		carTypeJTF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8F66\u8F86\u72B6\u6001\uFF1A");
		lblNewLabel_2.setBounds(45, 220, 109, 18);
		contentPane.add(lblNewLabel_2);
		
		carStateJTF = new JTextField();
		carStateJTF.setBounds(168, 217, 185, 24);
		contentPane.add(carStateJTF);
		carStateJTF.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6240\u5C5E\u5730\u533A\uFF1A");
		lblNewLabel_3.setBounds(45, 275, 109, 18);
		contentPane.add(lblNewLabel_3);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(168, 272, 135, 24);
		List<Area> list = AreaDao.selectArea();
		for (int i = 0; i < list.size(); i++){
			Area area = list.get(i);
			comboBox_1.addItem(area.getAreaname());
		}
		contentPane.add(comboBox_1);
		
		JButton updateJB = new JButton("\u4FEE\u6539");
		updateJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (carIdJTF.getText().trim().length() == 0){
					JOptionPane.showMessageDialog(null, "请输入车辆编号！");
				} else{
					int carid = Integer.parseInt(carIdJTF.getText().trim());
					String cartype = carTypeJTF.getText().trim();
					String carstate = carStateJTF.getText().trim();
					String area = (String) comboBox_1.getSelectedItem();
				
					int i = CarDao.updateCar(carid, cartype, area, carstate);
					if (i == 1){
						JOptionPane.showMessageDialog(null, "修改成功");
					}
				}
			}
		});
		updateJB.setBounds(70, 345, 113, 27);
		contentPane.add(updateJB);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(521, 18, 304, 354);
		Object[][] results = getSelect(CarDao.selectCar());
		jtable = new JTable(results, carhead);
		jtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selRow = jtable.getSelectedRow();
				carIdJTF.setText(jtable.getValueAt(selRow, 0).toString().trim());
				carTypeJTF.setText(jtable.getValueAt(selRow, 1).toString().trim());
				carStateJTF.setText(jtable.getValueAt(selRow, 2).toString().trim());
				comboBox_1.setSelectedItem(jtable.getValueAt(selRow, 3).toString().trim());
			}
		});
		jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(jtable);
		contentPane.add(scrollPane);
		
		//查询按钮监听响应事件
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
		btnNewButton.setBounds(394, 22, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton deleteJB = new JButton("\u5220\u9664");
		deleteJB.addActionListener(new ActionListener() {
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
		deleteJB.setBounds(265, 345, 113, 27);
		contentPane.add(deleteJB);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
