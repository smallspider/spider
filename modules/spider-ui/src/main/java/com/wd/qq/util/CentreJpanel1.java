package com.wd.qq.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.tree.DefaultMutableTreeNode;



public class CentreJpanel1 extends JPanel {
	public int WIDTH = 245;
	public int HEIGHT = 550;

	private DefaultMutableTreeNode node1 = null;// 好友
	private DefaultMutableTreeNode node2 = null;// 陌生人
	private DefaultMutableTreeNode node3 = null;// 黑名单

	public CentreJpanel1() {
		init();
	}

	void init() {
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		xxf = new XXFirends();
		
		JScrollPane jscrollPane = new JScrollPane(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// jscrollPane.setWheelScrollingEnabled(true);
		 jscrollPane.setLayout(new ScrollPaneLayout());
		// 添加树到滚动面板
		jscrollPane.getViewport().add(xxf, BorderLayout.CENTER);
		// 添加滚动面板到窗口中
		// jscrollPane.setBackground(Color.WHITE);
		jscrollPane.setFocusable(false);
		jscrollPane.setBounds(60, 0, 180, 472);
		jscrollPane.setPreferredSize(new Dimension(180, 472));
		this.getContentPane().add(jscrollPane);
	}

	public DefaultMutableTreeNode getRoot() {
		DefaultMutableTreeNode[] friends = null;
		DefaultMutableTreeNode[] strangers = null;
		DefaultMutableTreeNode[] blacklist = null;

		DefaultMutableTreeNode top = new DefaultMutableTreeNode(
				"The Java Series");

		node1 = new DefaultMutableTreeNode("好友");
		top.add(node1);
		node2 = new DefaultMutableTreeNode("陌生人");
		top.add(node2);
		node3 = new DefaultMutableTreeNode("黑名单");
		top.add(node3);

		friends = new DefaultMutableTreeNode[10];
		User user = null;
		for (int i = 0; i < 10; i++) {
			user = new User();
			user.setName("friends-" + i);
			user.setId(200 + i);
			user.setHeadImgName("img\\defaultHead1.jpg");
			friends[i] = new DefaultMutableTreeNode(user);
			node1.add(friends[i]);
		}

		strangers = new DefaultMutableTreeNode[10];
		for (int i = 0; i < 10; i++) {
			user = new User();
			user.setName("strangers-" + i);
			user.setId(300 + i);
			user.setHeadImgName("img\\defaultHead3.jpg");
			strangers[i] = new DefaultMutableTreeNode(user);
			node2.add(strangers[i]);

		}
		blacklist = new DefaultMutableTreeNode[10];

		for (int i = 0; i < 10; i++) {
			user = new User();
			user.setName("strangers-" + i);
			user.setId(300 + i);
			user.setHeadImgName("img\\defaultHead3.jpg");
			blacklist[i] = new DefaultMutableTreeNode(user);
			node3.add(blacklist[i]);

		}
		return top;

	}

	public Container getContentPane() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.draw3DRect(-1, 0, 240, 470, true);
	}

	private XXFirends xxf;
}
