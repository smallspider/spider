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
import java.awt.GridLayout;

import javax.swing.BorderFactory;
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
		super(new GridLayout(0, 5, 5, 5));
		init();
	}

	private void init() {
		setBorder(BorderFactory.createLineBorder(Color.red));
		for (int i = 0; i < 25; i++) {
			add(new MonitorPanel());
		}
	}
}
