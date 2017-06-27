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
		this.setLocation(width / 2 - 500, height / 2 - 450);
		
		jMenuBar = new JMenuBar();
		this.setJMenuBar(jMenuBar);
		carMenu = new JMenu("������Ϣ����");
		userMenu = new JMenu("�û���Ϣ����");
		areaMenu = new JMenu("������Ϣ����");
		borrowInfoMenu = new JMenu("�����Ϣ");
		returnInfoMenu = new JMenu("�黹��Ϣ");
		helpMenu = new JMenu("����");
		
		jMenuBar.add(carMenu);
		jMenuBar.add(userMenu);
		jMenuBar.add(areaMenu);
		jMenuBar.add(borrowInfoMenu);
		jMenuBar.add(returnInfoMenu);
		jMenuBar.add(helpMenu);
		carAddItem = new JMenuItem("������Ϣ���");
		carAddItem.addActionListener(new carAddActionListener());
		carDeleteItem = new JMenuItem("������Ϣɾ��");
		carUpdateItem = new JMenuItem("������Ϣ�޸�");
		carSelectItem = new JMenuItem("������Ϣ��ѯ");
		carSelectItem.addActionListener(new carSelectActionListener());
		carMenu.add(carAddItem);
		carMenu.add(carDeleteItem);
		carMenu.add(carUpdateItem);
		carMenu.add(carSelectItem);
		userAddItem = new JMenuItem("�û���Ϣ���");
		userDeleteItem = new JMenuItem("�û���Ϣɾ��");
		userUpdateItem = new JMenuItem("�û���Ϣ�޸�");
		userSelectItem = new JMenuItem("�û���Ϣ��ѯ");
		userMenu.add(userAddItem);
		userMenu.add(userDeleteItem);
		userMenu.add(userUpdateItem);
		userMenu.add(userSelectItem);
		areaAddItem = new JMenuItem("������Ϣ���");
		areaAddItem.addActionListener(new areaAddInfoActionListener());
		areaDeleteItem = new JMenuItem("������Ϣɾ��");
		areaDeleteItem.addActionListener(new areaUpdateandDeleteActionListener());
		areaUpdateItem = new JMenuItem("������Ϣ�޸�");
		areaUpdateItem.addActionListener(new areaUpdateandDeleteActionListener());
		areaSelectItem = new JMenuItem("������Ϣ��ѯ");
		areaSelectItem.addActionListener(new areaSelectActionListener());
		areaMenu.add(areaAddItem);
		areaMenu.add(areaDeleteItem);
		areaMenu.add(areaUpdateItem);
		areaMenu.add(areaSelectItem);
		borrowInfoAddItem = new JMenuItem("�����Ϣ���");
		borrowInfoSelectItem = new JMenuItem("�����Ϣ��ѯ");
		borrowInfoMenu.add(borrowInfoAddItem);
		borrowInfoMenu.add(borrowInfoSelectItem);
		returnInfoAddItem = new JMenuItem("�黹��Ϣ���");
		returnInfoSelectItem = new JMenuItem("�黹��Ϣ��ѯ");
		returnInfoMenu.add(returnInfoAddItem);
		returnInfoMenu.add(returnInfoSelectItem);
		exitItem = new JMenuItem("�˳�ϵͳ");
		infoItem = new JMenuItem("��������");
		helpMenu.add(infoItem);
		helpMenu.addSeparator();
		helpMenu.add(exitItem);
		exitItem.addActionListener(new ExitActionListener());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//�˳��˵���ť��Ӧ�¼�
	class ExitActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			System.exit(0);
		}
	}
	
	//������Ϣ��Ӳ˵���ť��Ӧ�¼�
	class areaAddInfoActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			AreaAddView areaAddView = new AreaAddView();
			areaAddView.setVisible(true);
		}
	}
	
	//������Ϣ��ѯ�˵���ť��Ӧ�¼�
	class areaSelectActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			AreaSelectView areaSelectView = new AreaSelectView();
			areaSelectView.setVisible(true);
		}
	}
	
	//������Ϣ�޸ĺ�ɾ���˵���ť��Ӧ�¼�
	class areaUpdateandDeleteActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			AreaUpdateandDeleteView aUD = new AreaUpdateandDeleteView();
			aUD.setVisible(true);
		}
	}
	
	//������Ϣ��Ӳ˵���ť��Ӧ�¼�
	class carAddActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			CarAddView carAddView = new CarAddView();
			carAddView.setVisible(true);
		}
	}
	
	//������Ϣ��ѯ�˵���ť��Ӧ�¼�
	class carSelectActionListener implements ActionListener{
		public void actionPerformed(final ActionEvent e){
			CarSelectView carSelectView = new CarSelectView();
			carSelectView.setVisible(true);
		}
	}
	
	public static void main(String[] args){
		new Index();
	}

}
