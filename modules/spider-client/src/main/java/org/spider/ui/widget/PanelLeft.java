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
import java.awt.Dimension;
import java.awt.Label;

import javax.swing.JPanel;

/**
 * 人员 讨论区
 * 
 * @author yangguangftlp
 * 
 */
public class PanelLeft extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1988272633516053139L;

	public PanelLeft() {
		super();
		init();
	}

	private void init() {
		setLayout(new BorderLayout());
		// 提示
		Label label = new Label("aa");
		add(label, BorderLayout.NORTH);
		// 会议人员
		add(new FriendsList(), BorderLayout.CENTER);
		// 讨论区
		add(new TalkPanel(), BorderLayout.SOUTH);
		// 输入
		add(new TalkPanel(), BorderLayout.SOUTH);
	}
}
