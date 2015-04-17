package org.spider.ui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.DatagramSocket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.spider.resource.factory.ImageFactory;

public class LoginProgressUI extends JFrame {
	private String userName;
	private String userPassword;

	private Point currentPoint;
	private Rectangle rectangle;// 顶部界面

	private DatagramSocket dataGramSocket;

	private static int HEIGHT = 600;
	private static int WIDTH = 250;

	private JButton jbcancel;

	private LoginUI lui;

	private JPaneCenter jpanelCenter;
	private JPanelTop jpanelTop;
	private int time = 10;

	private boolean isStopLogin;
	private boolean isClickCancel;
	private boolean isOutTime;

	public LoginProgressUI(LoginUI lui) throws HeadlessException {
		this();
		this.lui = lui;
	}

	public LoginProgressUI(LoginUI lui, String userName, String userPassword) throws HeadlessException {
		super();
		this.lui = lui;
		this.userName = userName;
		this.userPassword = userPassword;
		init();
	}

	LoginProgressUI() {
		init();

		new Thread(new Runnable() {

			
			public void run() {
				try {
					LoginProgressUI.this.repaint();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void init() {
		setSize(WIDTH, HEIGHT);
		setUndecorated(true);
		rectangle = new Rectangle(WIDTH, 20);
		jbcancel = new JButton("取消");
		jbcancel.setBounds(95, 340, 60, 30);
		jbcancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jbcancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// 恢复登陆界面的显示 销毁该界面
				if (!isOutTime) {
					isClickCancel = true;
					// stop("登录已取消...");
				} else {
					// System.exit(0);
				}
				System.exit(0);
			}
		});
		jpanelTop = new JPanelTop();
		jpanelTop.setPreferredSize(new Dimension(250, 20));
		// add(jpanelTop, BorderLayout.NORTH);
		jpanelCenter = new JPaneCenter();
		jpanelCenter.add(jbcancel);
		add(jpanelCenter, BorderLayout.CENTER);
		setLoactionCenter(this, "RIGHT");
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2)
					dispose();
			}

			
			public void mousePressed(MouseEvent e) {
				currentPoint = e.getPoint();
			}

		});
		this.addMouseMotionListener(new MouseMotionListener() {

			
			public void mouseMoved(MouseEvent e) {
			}

			
			public void mouseDragged(MouseEvent e) {
				Point windosP = getLocation();
				Point point = e.getPoint();
				if (rectangle.contains(currentPoint)) {
					int x = windosP.x + point.x - currentPoint.x;
					int y = windosP.y + point.y - currentPoint.y;
					setLocation(x, y);
				}
			}
		});

	}

	class JPanelTop extends JPanel {
		Image imageTop;

		JPanelTop() {
			init();
		}

		void init() {
			imageTop = ImageFactory.getImageFactory().getlf_image_map().get("top");

		}

		
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			g.drawImage(imageTop, -1, 0, this);
		}
	}

	class JPaneCenter extends JPanel {
		Image imageBorder;
		Image imagePanel;

		JPaneCenter() {
			init();
		}

		void init() {
			setLayout(null);
			imageBorder = ImageFactory.getImageFactory().getlf_image_map().get("logining");
			imagePanel = ImageFactory.getImageFactory().getlf_image_map().get("LoginPanel_window_windowBkg");
			imagePanel = imagePanel.getScaledInstance(250, 580, Image.SCALE_AREA_AVERAGING);

		}

		int icount = 0;
		int itime = 50;
		StringBuffer sfalg = new StringBuffer();

		
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(imagePanel, 0, 0, this);
			g.drawImage(imageBorder, 15, 150, this);
			if (icount >= 0 && icount <= 3) {
				sfalg.append(".");
			}
			g.drawString("正在登录" + sfalg, 100, 300);
			if (icount == 3) {
				sfalg.delete(0, sfalg.length());
				icount = -1;
			}
			icount++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param jf
	 * @param align
	 *            对齐方式 LEFT CENTER RIGHT
	 *            LEADING此值指示每一行组件都应该与容器方向的开始边对齐，例如，对于从左到右的方向，则与左边对齐。
	 *            TRAILING此值指示每行组件都应该与容器方向的结束边对齐，例如，对于从左到右的方向，则与右边对齐。
	 */
	private void setLoactionCenter(JFrame jf, String align, int hgap, int vgap) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		if (align.equalsIgnoreCase("RIGHT")) {
			jf.setLocation((dim.width - jf.getWidth() - vgap), hgap);
		}

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	private void setLoactionCenter(JFrame jf, String align) {
		setLoactionCenter(jf, align, 5, 5);
	}

	public static void main(String[] args) {
		try {
			// 在此处必须先指定样式
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		LoginProgressUI lpui = new LoginProgressUI();
		lpui.setVisible(true);
	}

}
