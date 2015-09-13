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
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

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

	// 提示
	private JLabel label;
	// 人员列表控件
	private FriendList friendsList;
	// 内容区
	private JTextArea textArea;
	// 输入框
	private TextField inputText;

	public PanelLeft() {
		super();
		init();
		addListener();
	}

	private void addListener() {
		inputText.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					textArea.setCaretPosition(textArea.getText().length());
					textArea.append(inputText.getText() + "\n");
					inputText.setText("");
				}
			};
		});

	}

	private void init() {
		setLayout(new BorderLayout(5, 5));
		// 提示
		label = new JLabel("人员列表");
		add(label, BorderLayout.NORTH);
		// 会议人员
		friendsList = new FriendList();
		friendsList.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1, false));
		add(friendsList, BorderLayout.CENTER);
		// 讨论区
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout(5, 5));
		textArea = new JTextArea(10, 50);
		//textArea.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.white, 1), "标题"));
		// textArea.setBorder(new LineBorder(new java.awt.Color(127, 157, 185),
		// 1, false));
		textArea.setLineWrap(true); // 激活自动换行功能
		textArea.setWrapStyleWord(true);

		JScrollPane scrollPane = new JScrollPane(textArea);
		// 分别设置水平和垂直滚动条自动出现
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		jp.add(scrollPane, BorderLayout.CENTER);
		inputText = new TextField(100);
		jp.add(inputText, BorderLayout.SOUTH);
		add(jp, BorderLayout.SOUTH);
	}
}
