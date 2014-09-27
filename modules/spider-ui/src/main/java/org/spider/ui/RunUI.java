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

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * @author yangguangftlp
 * 
 */
public class RunUI {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MainUI mainUI = new MainUI();
		mainUI.setUndecorated(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle bounds = new Rectangle(screenSize);
		mainUI.setBounds(bounds);
		mainUI.setExtendedState(MainUI.MAXIMIZED_BOTH);
		mainUI.setDefaultCloseOperation(MainUI.EXIT_ON_CLOSE);
		mainUI.setVisible(true);
	}
}
