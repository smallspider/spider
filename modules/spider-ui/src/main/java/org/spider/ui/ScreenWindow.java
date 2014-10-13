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
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JWindow;

import org.spider.ui.widget.Widget;

/**
 * @author yangguangftlp
 * 
 */
public class ScreenWindow extends JWindow implements Widget {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3528196568423979934L;

	private Window win;
	private JPanel toolbar;

	public ScreenWindow() {

		init();
		initTool();

	}

	/**
	 * 工具栏
	 */
	protected void initTool() {
		setLayout(null);
		toolbar = new JPanel();
		toolbar.setSize(500, 50);
		toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton jb = new JButton("aa");
		toolbar.add(jb);
		toolbar.add(new JButton("aa"));
		toolbar.add(new JButton("aa"));
		toolbar.add(new JButton("aa"));
		toolbar.setBorder(BorderFactory.createTitledBorder(""));
		add(toolbar);
		jb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (null != win) {
					toolbar.setVisible(false);
					setVisible(false);
					win.setVisible(true);
					win.setFocusableWindowState(true);
				}
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
	}

	public void init() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		getContentPane().setBackground(Color.BLACK);
		setAlwaysOnTop(true);
	}

	public static void main(String[] args) {
		ScreenWindow sw = new ScreenWindow();
		sw.init();
		sw.setVisible(true);
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
