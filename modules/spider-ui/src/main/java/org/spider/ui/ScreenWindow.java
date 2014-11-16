/**
 * Copyright 2014 smallspider ORG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author yangguangftlp
 */
package org.spider.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JWindow;

import org.spider.ui.widget.Widget;
import org.spider.ui.widget.screen.ToolbarWidget;

/**
 * @author yangguangftlp
 * 
 */
public class ScreenWindow extends JWindow implements Widget {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3528196568423979934L;

	private ScreenWindow sw;

	private Window win;
	private ToolbarWidget toolbar;

	private Thread repaintThread;
	private boolean isStop;

	public ScreenWindow() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(null);
		initTool();
		initCanse();

		repaintThread = new Thread(new RepaintThread());
		repaintThread.start();

	}

	private class RepaintThread implements Runnable {
		public void run() {
			while (!isStop) {
				try {
					Thread.sleep(10);
					ScreenWindow.this.repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private Image iBuffer;
	private BufferedImage bImage;
	private Graphics gBuffer;
	private boolean isTrue;

	/**
	 * 工具栏
	 */
	protected void initTool() {
		toolbar = new ToolbarWidget();
		toolbar.setSize(500, 50);
		toolbar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton jb = new JButton("退出全屏");
		toolbar.add(jb);
		toolbar.setVisible(false);
		jb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (null != win) {
					toolbar.setVisible(false);
					setVisible(false);
					win.setVisible(true);
					win.setFocusableWindowState(true);
					ScreenWindow.this.dispose();
				}
				ScreenWindow.this.dispose();
			}
		});
		final int screenwidth = getWidth();
		final int toolbarWidth = 500;
		final int startX = (screenwidth - toolbarWidth) / 2;
		toolbar.setLocation(startX, 0);
		toolbar.setVisible(false);
		addMouseMotionListener(new MouseMotionListener() {

			public void mouseMoved(MouseEvent e) {

				if (isVisible()) {
					if (e.getX() >= startX && e.getX() <= startX + toolbarWidth
							&& e.getY() >= 0 && e.getY() <= toolbar.getHeight()) {
						if (!toolbar.isVisible()) {
							toolbar.setVisible(true);
						}
					} else {
						if (toolbar.isVisible()) {
							toolbar.setVisible(false);
						}
					}
				}
			}

			public void mouseDragged(MouseEvent e) {
			}
		});

		add(toolbar);
	}

	public void initCanse() {
		JPanel jp = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -4586413151408313946L;

			public void paintComponent(Graphics g) {
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, this.getSize().width, this.getSize().height);
				g.setColor(Color.RED);
				g.drawString("ddddddddddddddd" + System.currentTimeMillis(),
						400, 15);
				g.fillOval(450, 20, 80, 80);
				g.setColor(Color.BLACK);
			}
		};
		jp.setSize(getSize());
		jp.setLocation(0, 0);
		add(jp);
	}

	public static void main(String[] args) {
		ScreenWindow.showFullScreenWindow(null);
	}

	public static void showFullScreenWindow(Window win) {
		ScreenWindow sw = new ScreenWindow();
		sw.setWindow(win);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		if (gd.isFullScreenSupported()) {
			gd.setFullScreenWindow(sw);
		}
	}

	public void winit() {

	}

	public String getWid() {
		return null;
	}

	public void setWindow(Window win) {
		this.win = win;
	}
}
