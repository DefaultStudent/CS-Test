package com.cab.view;

import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;

public class CarView extends JFrame {
	private JPanel textJP, infoJP, buttonJP;
	private JLabel caridJL, typeJL, stateJL, areaJL;
	private JTextField caridJTF, typeJTF, stateJTF;
	private JComboBox areaJCB;
	private JButton addJB, resetJB;
	
	public CarView(){
		setSize(800, 600);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width / 2 - 500, height / 2 - 450);
		
		textJP = new JPanel();
		infoJP = new JPanel();
		buttonJP = new JPanel();
		
		infoJP.setLayout(new GridLayout(4, 2));
		caridJL = new JLabel("车辆编号：");
		caridJL.setHorizontalAlignment(SwingConstants.CENTER);
		caridJTF = new JTextField();
		typeJL = new JLabel("车辆类型：");
		typeJL.setHorizontalAlignment(SwingConstants.CENTER);
		typeJTF = new JTextField();
		stateJL = new JLabel("车辆状态");
		stateJL.setHorizontalAlignment(SwingConstants.CENTER);
		stateJTF = new JTextField();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args){
		new CarView();
	}

}
