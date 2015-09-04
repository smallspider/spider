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

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import org.spider.ui.widget.MonitorPanel;
import org.spider.ui.widget.PanelCenter;
import org.spider.ui.widget.PanelLeft;
import org.spider.ui.widget.Widget;
import org.spider.ui.widget.WidgetManager;

/**
 * @author yangguangftlp
 * 
 */
public class MainUI extends JFrame implements Widget {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4362259820616960943L;
	private PanelLeft panelleft;
	private PanelCenter panelCenter;
	private JSplitPane splitPane;
	JScrollPane scrollPanelCenter;
	JTabbedPane jtabbedPane;

	// private Dimension theSize = new Dimension(500, 500);

	public MainUI() {
		setSize(800, 500);
		init();
		winit();
	}

	private void init() {
		panelleft = new PanelLeft();
		panelCenter = new PanelCenter();
		panelCenter.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {

			}

			public void mouseExited(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseClicked");
			}
		});
		scrollPanelCenter = new JScrollPane(panelCenter, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JButton jb1 = new JButton("xxx");
		// panelleft.add(jb1);
		jb1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panelCenter.add(new MonitorPanel());
				scrollPanelCenter.validate();
			}
		});
		jtabbedPane = new JTabbedPane();
		jtabbedPane.add("电脑屏幕", scrollPanelCenter);
		jtabbedPane.add("电脑屏幕", new JPanel());
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, panelleft, jtabbedPane);
		// 设置显示小三角
		splitPane.setOneTouchExpandable(true);
		splitPane.setContinuousLayout(true);
		splitPane.setDividerSize(8);
		splitPane.setDividerLocation(200);
		// 禁止中间线拖动
		splitPane.setEnabled(false);
		/*
		 * splitPane.addComponentListener(new ComponentAdapter() {
		 * 
		 * @Override public void componentResized(ComponentEvent e) {
		 * splitPane.setDividerLocation(1.0 / 3.0); } });
		 */
		// splitPane.setUI(new ShineSplitPaneUI());
		// 添加分割面板
		add(splitPane, BorderLayout.CENTER);
	}

	public PanelLeft getPanelleft() {
		return panelleft;
	}

	public void setPanelleft(PanelLeft panelleft) {
		this.panelleft = panelleft;
	}

	public PanelCenter getPanelCenter() {
		return panelCenter;
	}

	public void setPanelCenter(PanelCenter panelCenter) {
		this.panelCenter = panelCenter;
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

	public JScrollPane getScrollPanelCenter() {
		return scrollPanelCenter;
	}

	public void setScrollPanelCenter(JScrollPane scrollPanelCenter) {
		this.scrollPanelCenter = scrollPanelCenter;
	}

	public JTabbedPane getJtabbedPane() {
		return jtabbedPane;
	}

	public void setJtabbedPane(JTabbedPane jtabbedPane) {
		this.jtabbedPane = jtabbedPane;
	}

	public void winit() {
		WidgetManager.getInstance().addMonitorPanel(this);
	}

	public String getWid() {
		return MainUI.class.getName() + "_MainUI01";
	}
}
