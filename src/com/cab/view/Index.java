package com.cab.view;

import javax.swing.JFrame;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Index extends JFrame {
	private JPanel textJP, addJP, buttonJP;
	private JMenuBar jMenuBar;
	private JMenu areaMenu, userMenu, borrowInfoMenu, returnInfoMenu, carMenu, helpMenu;
	private JMenuItem carAddItem, carDeleteItem, carSelectItem, carUpdateItem,  userAddItem, userDeleteItem, userUpdateItem, userSelectItem, areaAddItem, areaDeleteItem, areaUpdateItem, areaSelectItem,
		borrowInfoAddItem, borrowInfoSelectItem, returnInfoAddItem, returnInfoSelectItem, exitItem, infoItem;
	
	public Index(){
		setSize(1000, 800);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width / 2 - 500, height / 2 - 450);
		
		jMenuBar = new JMenuBar();
		this.setJMenuBar(jMenuBar);
		carMenu = new JMenu("车辆信息管理");
		userMenu = new JMenu("用户信息管理");
		areaMenu = new JMenu("地区信息管理");
		borrowInfoMenu = new JMenu("租借信息");
		returnInfoMenu = new JMenu("归还信息");
		helpMenu = new JMenu("帮助");
		
		jMenuBar.add(carMenu);
		jMenuBar.add(userMenu);
		jMenuBar.add(areaMenu);
		jMenuBar.add(borrowInfoMenu);
		jMenuBar.add(returnInfoMenu);
		jMenuBar.add(helpMenu);
		carAddItem = new JMenuItem("车辆信息添加");
		carDeleteItem = new JMenuItem("车辆信息删除");
		carUpdateItem = new JMenuItem("车辆信息修改");
		carSelectItem = new JMenuItem("车辆信息查询");
		carMenu.add(carAddItem);
		carMenu.add(carDeleteItem);
		carMenu.add(carUpdateItem);
		carMenu.add(carSelectItem);
		userAddItem = new JMenuItem("用户信息添加");
		userDeleteItem = new JMenuItem("用户信息删除");
		userUpdateItem = new JMenuItem("用户信息修改");
		userSelectItem = new JMenuItem("用户信息查询");
		userMenu.add(userAddItem);
		userMenu.add(userDeleteItem);
		userMenu.add(userUpdateItem);
		userMenu.add(userSelectItem);
		areaAddItem = new JMenuItem("地区信息添加");
		areaDeleteItem = new JMenuItem("地区信息删除");
		areaUpdateItem = new JMenuItem("地区信息修改");
		areaSelectItem = new JMenuItem("地区信息查询");
		areaMenu.add(areaAddItem);
		areaMenu.add(areaDeleteItem);
		areaMenu.add(areaUpdateItem);
		areaMenu.add(areaSelectItem);
		borrowInfoAddItem = new JMenuItem("租借信息添加");
		borrowInfoSelectItem = new JMenuItem("租借信息查询");
		borrowInfoMenu.add(borrowInfoAddItem);
		borrowInfoMenu.add(borrowInfoSelectItem);
		returnInfoAddItem = new JMenuItem("归还信息添加");
		returnInfoSelectItem = new JMenuItem("归还信息查询");
		returnInfoMenu.add(returnInfoAddItem);
		returnInfoMenu.add(returnInfoSelectItem);
		exitItem = new JMenuItem("退出系统");
		infoItem = new JMenuItem("关于我们");
		helpMenu.add(infoItem);
		helpMenu.addSeparator();
		helpMenu.add(exitItem);
		exitItem.addActionListener(new ExitActionListener());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		setResizable(false);
	}
	
	class ExitActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			System.exit(0);
		}
	}
	
	public static void main(String[] args){
		new Index();
	}

}
