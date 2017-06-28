package com.cab.view;

import javax.swing.JFrame;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Index extends JFrame {
	private JMenuBar jMenuBar;
	private JMenu areaMenu, userMenu, borrowInfoMenu, returnInfoMenu, carMenu, helpMenu;
	private JMenuItem carAddItem, carDeleteItem, carSelectItem, carUpdateItem,  userAddItem, userDeleteItem, userUpdateItem, userSelectItem, areaAddItem, areaDeleteItem, areaUpdateItem, areaSelectItem,
		borrowInfoAddItem, borrowInfoSelectItem, returnInfoAddItem, returnInfoSelectItem, exitItem, infoItem;
	
	public Index(){
		setSize(1000, 800);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setTitle("车辆出租管理系统");
		this.setLocation(width / 2 - 500, height / 2 - 450);
		
		//一级菜单栏内容
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
		
		//二级菜单栏内容
		carAddItem = new JMenuItem("车辆信息添加");
		carAddItem.addActionListener(new carAddActionListener());
		carDeleteItem = new JMenuItem("车辆信息删除");
		carDeleteItem.addActionListener(new carUpdateandDeleteActionListener());
		carUpdateItem = new JMenuItem("车辆信息修改");
		carUpdateItem.addActionListener(new carUpdateandDeleteActionListener());
		carSelectItem = new JMenuItem("车辆信息查询");
		carSelectItem.addActionListener(new carSelectActionListener());
		carMenu.add(carAddItem);
		carMenu.add(carDeleteItem);
		carMenu.add(carUpdateItem);
		carMenu.add(carSelectItem);
		userAddItem = new JMenuItem("用户信息添加");
		userAddItem.addActionListener(new userAddActionListener());
		userDeleteItem = new JMenuItem("用户信息删除");
		userDeleteItem.addActionListener(new userUpdateandDeleteActionListener());
		userUpdateItem = new JMenuItem("用户信息修改");
		userUpdateItem.addActionListener(new userUpdateandDeleteActionListener());
		userSelectItem = new JMenuItem("用户信息查询");
		userSelectItem.addActionListener(new userSelectActionListener());
		userMenu.add(userAddItem);
		userMenu.add(userDeleteItem);
		userMenu.add(userUpdateItem);
		userMenu.add(userSelectItem);
		areaAddItem = new JMenuItem("地区信息添加");
		areaAddItem.addActionListener(new areaAddInfoActionListener());
		areaDeleteItem = new JMenuItem("地区信息删除");
		areaDeleteItem.addActionListener(new areaUpdateandDeleteActionListener());
		areaUpdateItem = new JMenuItem("地区信息修改");
		areaUpdateItem.addActionListener(new areaUpdateandDeleteActionListener());
		areaSelectItem = new JMenuItem("地区信息查询");
		areaSelectItem.addActionListener(new areaSelectActionListener());
		areaMenu.add(areaAddItem);
		areaMenu.add(areaDeleteItem);
		areaMenu.add(areaUpdateItem);
		areaMenu.add(areaSelectItem);
		borrowInfoAddItem = new JMenuItem("租借信息添加");
		borrowInfoAddItem.addActionListener(new borrowInfoAddActionListener());
		borrowInfoSelectItem = new JMenuItem("租借信息查询");
		borrowInfoSelectItem.addActionListener(new borrowInfoSelectActionListener());
		borrowInfoMenu.add(borrowInfoAddItem);
		borrowInfoMenu.add(borrowInfoSelectItem);
		returnInfoAddItem = new JMenuItem("归还信息添加");
		returnInfoAddItem.addActionListener(new returnInfoAddActionListener());
		returnInfoSelectItem = new JMenuItem("归还信息查询");
		returnInfoSelectItem.addActionListener(new returnInfoSelectActionListener());
		returnInfoMenu.add(returnInfoAddItem);
		returnInfoMenu.add(returnInfoSelectItem);
		exitItem = new JMenuItem("退出系统");
		infoItem = new JMenuItem("关于我们");
		helpMenu.add(infoItem);
		helpMenu.addSeparator();
		helpMenu.add(exitItem);
		exitItem.addActionListener(new ExitActionListener());
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	//退出菜单按钮响应事件
	class ExitActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			System.exit(0);
		}
	}
	
	//地区信息添加菜单按钮响应事件
	class areaAddInfoActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			AreaAddView areaAddView = new AreaAddView();
			areaAddView.setVisible(true);
		}
	}
	
	//地区信息查询菜单按钮响应事件
	class areaSelectActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			AreaSelectView areaSelectView = new AreaSelectView();
			areaSelectView.setVisible(true);
		}
	}
	
	//地区信息修改和删除菜单按钮响应事件
	class areaUpdateandDeleteActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			AreaUpdateandDeleteView aUD = new AreaUpdateandDeleteView();
			aUD.setVisible(true);
		}
	}
	
	//车辆信息添加菜单按钮响应事件
	class carAddActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			CarAddView carAddView = new CarAddView();
			carAddView.setVisible(true);
		}
	}
	
	//车辆信息查询菜单按钮响应事件
	class carSelectActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			CarSelectView carSelectView = new CarSelectView();
			carSelectView.setVisible(true);
		}
	}
	
	//车辆信息修改和删除菜单按钮响应事件
	class carUpdateandDeleteActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			CarUpdateandDeleteView carUpdateandDeleteView = new CarUpdateandDeleteView();
			carUpdateandDeleteView.setVisible(true);
		}
	}
	
	//用户信息添加菜单按钮响应事件
	class userAddActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			UserAddView userAddView = new UserAddView();
			userAddView.setVisible(true);
		}
	}
	
	//用户信息查询菜单按钮响应事件
	class userSelectActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			UserSelectView userSelectView = new UserSelectView();
			userSelectView.setVisible(true);
		}
	}
	
	//用户信息查询和修改菜单按钮响应事件
	class userUpdateandDeleteActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			UserUpdateandDeleteView userUpdateandDeleteView = new UserUpdateandDeleteView();
			userUpdateandDeleteView.setVisible(true);
		}
	}
	
	//租借信息添加菜单按钮响应事件
	class borrowInfoAddActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			BorrowInfoAddView borrowInfoAddView = new BorrowInfoAddView();
			borrowInfoAddView.setVisible(true);
		}
	}
	
	//租借信息查询菜单按钮响应事件
	class borrowInfoSelectActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			BorrowInfoSelectView borrowInfoSelectView = new BorrowInfoSelectView();
			borrowInfoSelectView.setVisible(true);
		}
	}
	
	//归还信息添加菜单按钮响应事件
	class returnInfoAddActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			ReturnInfoAddView returnInfoAddView = new ReturnInfoAddView();
			returnInfoAddView.setVisible(true);
		}
	}
	
	//归还信息查询菜单按钮响应事件
	class returnInfoSelectActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			ReturnInfoSelectView returnInfoSelectView = new ReturnInfoSelectView();
			returnInfoSelectView.setVisible(true);
		}
	}
	
	public static void main(String[] args){
		new Index();
	}

}
