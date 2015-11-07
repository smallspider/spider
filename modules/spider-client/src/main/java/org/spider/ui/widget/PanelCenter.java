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

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author yangguangftlp
 * 
 */
public class PanelCenter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8395687179742213851L;

	public PanelCenter() {
		init();
	}

	private void init() {
		setLayout(null);
		JPanel jpanel = new JPanel();
		jpanel.setSize(350, 200);
		jpanel.setBorder(BorderFactory.createLineBorder(Color.red));
		JButton shareButton = new JButton("共享");
		shareButton.setSize(77,25);
		JButton cancelButton = new JButton("取消");
		cancelButton.setSize(77,25);
		add(jpanel);
		add(shareButton);
		add(cancelButton);
		jpanel.setLocation(25, 25);
		shareButton.setLocation(90, 235);
		cancelButton.setLocation(178, 235);
	}
}
