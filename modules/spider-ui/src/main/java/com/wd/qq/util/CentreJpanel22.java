package com.wd.qq.util;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CentreJpanel22 extends JPanel {
	public CentreJpanel22() {
		init();
	}

	void init() {
		cl = new CardLayout();
		setLayout(cl);
		buttonListener = new ButtonAction();
		jphy_jb1 = new JButton("我的好友");
		jphy_jb2 = new JButton("陌生人");
		jphy_jb3 = new JButton("黑名单");

		jphy_jb2.addActionListener(buttonListener);
		jphy_jb3.addActionListener(buttonListener);
		//
		jphy1 = new JPanel(new BorderLayout());
		// 假定有50个好友
		jphy2 = new JPanel(new GridLayout(20, 1));

		JLabel[] jb1s = new JLabel[20];

		for (int i = 0; i < jb1s.length; i++) {
			jb1s[i] = new JLabel(i + 1 + "", new ImageIcon("image/mm.jpg"),
					JLabel.LEFT);
			jphy2.add(jb1s[i]);
		}

		jphy2.setBackground(Color.WHITE);
		jphy3 = new JPanel(new GridLayout(2, 1));
		// 把两个按钮加入到jphy3
		jphy3.add(jphy_jb2);
		jphy3.add(jphy_jb3);

		jscrollpanel = new JScrollPane(jphy2);

		jphy1.add(jphy_jb1, "North");
		jphy1.add(jscrollpanel, "Center");
		jphy1.add(jphy3, "South");

		// 处理第二张卡片

		jpmsr_jb1 = new JButton("我的好友");
		jpmsr_jb2 = new JButton("陌生人");
		jpmsr_jb3 = new JButton("黑名单");

		jpmsr_jb1.addActionListener(buttonListener);
		jpmsr_jb3.addActionListener(buttonListener);

		jpmsr1 = new JPanel(new BorderLayout());
		// 假定有20个陌生人
		jpmsr2 = new JPanel(new GridLayout(20, 1, 4, 4));

		// 给jphy2，初始化20陌生人.
		JLabel[] jb1s2 = new JLabel[20];

		for (int i = 0; i < jb1s2.length; i++) {
			jb1s2[i] = new JLabel(i + 1 + "", new ImageIcon("image/mm.jpg"),
					JLabel.LEFT);
			jpmsr2.add(jb1s2[i]);
		}

		jpmsr3 = new JPanel(new GridLayout(2, 1));
		// 把两个按钮加入到jphy3
		jpmsr3.add(jpmsr_jb1);
		jpmsr3.add(jpmsr_jb2);

		jscrollpanel = new JScrollPane(jpmsr2);

		// 对jphy1,初始化
		jpmsr1.add(jpmsr3, "North");
		jpmsr1.add(jscrollpanel, "Center");
		jpmsr1.add(jpmsr_jb3, "South");

		// 处理第三张卡片

		jphmd_jb1 = new JButton("我的好友");
		jphmd_jb2 = new JButton("陌生人");
		jphmd_jb3 = new JButton("黑名单");

		jphmd_jb1.addActionListener(buttonListener);
		jphmd_jb2.addActionListener(buttonListener);
		jphmd1 = new JPanel(new BorderLayout());
		// 假定有20个陌生人
		jphmd2 = new JPanel(new GridLayout(20, 1, 4, 4));

		// 给jphy2，初始化20陌生人.
		JLabel[] jb1s3 = new JLabel[20];

		for (int i = 0; i < jb1s2.length; i++) {
			jb1s3[i] = new JLabel(i + 1 + "", new ImageIcon("image/mm.jpg"),
					JLabel.LEFT);
			jphmd2.add(jb1s3[i]);
		}

		jphmd3 = new JPanel(new GridLayout(3, 1));
		// 把两个按钮加入到jphy3
		jphmd3.add(jphmd_jb1);
		jphmd3.add(jphmd_jb2);
		jphmd3.add(jphmd_jb3);

		jscrollpanel = new JScrollPane(jphmd2);

		// 对jphy1,初始化
		jphmd1.add(jphmd3, "North");
		jphmd1.add(jscrollpanel, "Center");
		//jphmd1.add(jphmd_jb3, "South");

		
		add(jphy1, "1");
		add(jpmsr1, "2");
		add(jphmd1, "3");
	}

	// 按钮事件
	class ButtonAction implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			// 如果点击了陌生人按钮，就显示第二张卡片
			Object ob = arg0.getSource();
			if (ob == jphy_jb2) {
				cl.show(getContentPane(), "2");
			} else if (ob == jphy_jb3) {
				cl.show(getContentPane(), "3");
			} else if (ob == jpmsr_jb1) {
				cl.show(getContentPane(), "1");
			} else if (ob == jpmsr_jb3) {
				cl.show(getContentPane(), "3");
			} else if (ob == jphmd_jb1) {
				cl.show(getContentPane(), "1");
			} else if (ob == jphmd_jb2) {
				cl.show(getContentPane(), "2");
			}
		}
	}

	public Container getContentPane() {
		// TODO Auto-generated method stub
		return this;
	}

	private ButtonAction buttonListener;
	private CardLayout cl;
	private JScrollPane jscrollpanel;
	private JScrollPane jsp2;
	// 第一张卡片
	private JPanel jphy1, jphy2, jphy3;
	private JButton jphy_jb1, jphy_jb2, jphy_jb3;
	// 第二张卡片
	private JPanel jpmsr1, jpmsr2, jpmsr3;
	private JButton jpmsr_jb1, jpmsr_jb2, jpmsr_jb3;
	// 第二张卡片
	private JPanel jphmd1, jphmd2, jphmd3;
	private JButton jphmd_jb1, jphmd_jb2, jphmd_jb3;

}
