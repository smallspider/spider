package org.spider.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.wd.qq.util.BottomJpanel;
import com.wd.qq.util.CentreJpanel;
import com.wd.qq.util.TopJpanel;

public class MsgMainUI extends JFrame {

	public int WIDTH = 245;
	public int HEIGHT = 550;

	private TopJpanel topjpanel;
	private CentreJpanel centerjpanel;
	private BottomJpanel bottomjpanel;

	public void initUI() {

		this.setResizable(false);
		topjpanel = new TopJpanel();
		centerjpanel = new CentreJpanel();
		bottomjpanel = new BottomJpanel();

		this.add(topjpanel, BorderLayout.NORTH);
		this.add(centerjpanel, BorderLayout.CENTER);
		this.add(bottomjpanel, BorderLayout.SOUTH);
		this.setSize(WIDTH, HEIGHT);
		setWindowCenter(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setWindowCenter(JFrame jf) {
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (ds.width - jf.getWidth()) / 2;
		int y = (ds.height - jf.getHeight()) / 2;
		jf.setLocation(x, y);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MsgMainUI qqFriendList = new MsgMainUI();
		qqFriendList.initUI();
	}
}