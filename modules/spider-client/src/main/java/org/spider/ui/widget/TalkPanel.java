package org.spider.ui.widget;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JPanel;

/**
 * 讨论组件
 * 
 * @author yangguangftlp
 * @date 2015年3月6日
 */
public class TalkPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TalkPanel() {
		super();
		init();
	}

	private void init() {
		setLayout(new BorderLayout());
		// 内容区域
		add(new TextArea(), BorderLayout.CENTER);
		// 讨论区
		// 操作区
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(3, 1));
		TextField tf = new TextField(100);
		jp.add(tf);
		jp.add(new Button("aa"));
		add(jp, BorderLayout.CENTER);
	}

}
