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
package org.spider.ui.widget;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.spider.ui.MainUI;
import org.spider.ui.ScreenWindow;

/**
 * @author yangguangftlp
 * 
 */
public class MonitorPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 352105446757913417L;
	private String id;
	private ImageWidget imageWidget;
	private Dimension preferredSize = new Dimension(200, 200);

	public MonitorPanel() {
		super();
		init();
	}

	private void init() {

		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("border_title"), BorderFactory
				.createEmptyBorder(10, 10, 10, 10)));
		setLayout(new BorderLayout());
		setPreferredSize(preferredSize);
		imageWidget = new ImageWidget(new ImageIcon("test_2.png"));
		imageWidget.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(imageWidget, BorderLayout.CENTER);
		imageWidget.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(!imageWidget.isResize()){
					/*MainUI MainUI = (MainUI) WidgetManager.getInstance().getWidget(MainUI.class.getName()+"_MainUI01");
					MainUI.remove(MainUI.getSplitPane());
					MainUI.repaint();
					JPanel jp = new JPanel();
					jp.setLayout(new BorderLayout());
					jp.add(imageWidget, BorderLayout.CENTER);
					imageWidget.doResize();
					MainUI.add(jp,BorderLayout.CENTER);*/
					MainUI MainUI = (MainUI) WidgetManager.getInstance().getWidget(MainUI.class.getName()+"_MainUI01");
					MainUI.setVisible(false);
					ScreenWindow screenWindow = (ScreenWindow) WidgetManager.getInstance().getWidget("ScreenWindow.class");
					screenWindow.setVisible(true);
				}
			}
		});
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
