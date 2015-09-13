package org.spider.ui;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;


public class SpiderSplitPaneUI extends BasicSplitPaneUI {

	/**
	 * Creates the default divider.
	 */
	@Override
	public BasicSplitPaneDivider createDefaultDivider() {
		return new SplitPaneDivider(this);
	}
}
