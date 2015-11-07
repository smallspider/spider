package org.spider.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.spider.ui.widget.LoginPanel;

//登陆界面
@SuppressWarnings("serial")
public class LoginUI extends JFrame {

	LoginUI() {
		init();
	}

	private void init() {
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		loginPanel = new LoginPanel(this);
		add(loginPanel, BorderLayout.CENTER);
		rectangle = new Rectangle(WIDTH, 20);
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2)
					dispose();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				currentPoint = e.getPoint();
			}

		});
		this.addMouseMotionListener(new MouseMotionListener() {

			public void mouseMoved(MouseEvent e) {
			}

			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				Point windosP = getLocation();
				Point point = e.getPoint();
				if (rectangle.contains(currentPoint)) {
					int x = windosP.x + point.x - currentPoint.x;
					int y = windosP.y + point.y - currentPoint.y;
					setLocation(x, y);
				}
			}
		});
		setLoactionCenter(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setLoactionCenter(LoginUI lui) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		lui.setLocation((dim.width - lui.getWidth()) / 2,
				(dim.height - lui.getHeight()) / 2);

	}

	public void showFailMessage(String mes) {
		JOptionPane.showConfirmDialog(this, mes, "登陆失败",
				JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
	}

	public void showLoginProgressUI(String userName, String userPass) {
		if (null == lpui) {
			lpui = new LoginProgressUI(this);
		}
		lpui.setUserName(userName);
		lpui.setUserName(userPass);
		lpui.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LoginUI lui = new LoginUI();
		lui.setVisible(true);
	}

	private LoginProgressUI lpui;// 登录进度UI
	private Point currentPoint;
	private Rectangle rectangle;// 顶部界面
	private LoginPanel loginPanel;// 登陆主界面
	private static int HEIGHT = 300;
	private static int WIDTH = 400;

}
