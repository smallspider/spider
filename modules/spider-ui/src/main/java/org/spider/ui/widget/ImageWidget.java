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

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author yangguangftlp
 * 
 */
public class ImageWidget extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4101796013240852018L;
	private Dimension preferredSize = new Dimension(200, 200);
	private Image image;
	private boolean isResize;

	public ImageWidget() {
		super();
		init();
	}

	public ImageWidget(Action a) {
		super(a);
		init();
	}

	public ImageWidget(Icon icon) {
		super();
		image = ((ImageIcon) icon).getImage();
		init();
	}

	public ImageWidget(String text, Icon icon) {
		super(text, icon);
		init();
	}

	public ImageWidget(String text) {
		super(text);
		init();
	}

	private void init() {
		setSize(preferredSize);
		setPreferredSize(preferredSize);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image, 5, 5, null);
	}

	public void loadImage(ImageIcon image) {
		this.image = image.getImage();
	}

	public boolean isResize() {
		return isResize;
	}

	public void restResize() {
		this.isResize = false;
	}

	public void doResize() {
		this.isResize = true;
		this.setSize(new Dimension(800, 800));
		this.setPreferredSize(new Dimension(800, 800));
		this.repaint();
	}

}
