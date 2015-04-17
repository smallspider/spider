package com.wd.qq.util;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomJpanel extends JPanel {
	public BottomJpanel() {
		init();
	}

	void init() {
		setLayout(null);
		setBounds(0, 0, 250, 25);
		setPreferredSize(new Dimension(250,25));
		//add(new JButton("dd"));
	}

}
