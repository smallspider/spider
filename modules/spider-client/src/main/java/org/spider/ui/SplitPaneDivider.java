package org.spider.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class SplitPaneDivider extends BasicSplitPaneDivider {

	private int oneTouchSize, oneTouchOffset;
	boolean centerOneTouchButtons;
	// center空白区域
	private int x1, y1;
	boolean isFlag;

	/**
	 * 
	 */
	private static final long serialVersionUID = 4618840906748572196L;

	public SplitPaneDivider(BasicSplitPaneUI ui) {
		super(ui);
		oneTouchSize = ONE_TOUCH_SIZE;
		oneTouchOffset = ONE_TOUCH_OFFSET;
		centerOneTouchButtons = true;
		setLayout(new SpiderDividerLayout());
		setBasicSplitPaneUI(ui);
		orientation = splitPane.getOrientation();
		setCursor((orientation == JSplitPane.HORIZONTAL_SPLIT) ? Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR)
				: Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
		setBackground(UIManager.getColor("SplitPane.background"));

		leftButton.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
		leftButton.setToolTipText("123");
		rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		rightButton.setVisible(false);
		leftButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				rightButton.setVisible(true);
				leftButton.setVisible(false);
			}
		});
		rightButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				leftButton.setVisible(true);
				rightButton.setVisible(false);
			}
		});
	}

	private class SpiderDividerLayout implements LayoutManager {

		public void layoutContainer(Container c) {

			System.out.println("========" + c.getWidth() + " " + getHeight());
			if (leftButton != null && rightButton != null) {
				if (splitPane.isOneTouchExpandable()) {
					Insets insets = getInsets();

					if (orientation == JSplitPane.VERTICAL_SPLIT) {
						int extraX = (insets != null) ? insets.left : 0;
						int blockSize = getHeight();

						if (insets != null) {
							blockSize -= (insets.top + insets.bottom);
							blockSize = Math.max(blockSize, 0);
						}
						blockSize = Math.min(blockSize, oneTouchSize);

						int y = (c.getSize().height - blockSize) / 2;

						if (!centerOneTouchButtons) {
							y = (insets != null) ? insets.top : 0;
							extraX = 0;
						}
						int width = (int) SplitPaneDivider.this.getSize().getWidth();
						x1 = width / 2 - oneTouchSize;
						leftButton.setBounds(extraX - oneTouchOffset + width / 2, y, blockSize * 2, blockSize);
						rightButton.setBounds(extraX - oneTouchOffset + oneTouchSize * 2 + width / 2, y, blockSize * 2,
								blockSize);
					} else {
						int extraY = (insets != null) ? insets.top : 0;
						int blockSize = getWidth();
						if (insets != null) {
							blockSize -= (insets.left + insets.right);
							blockSize = Math.max(blockSize, 0);
						}
						blockSize = Math.min(blockSize, oneTouchSize);

						int x = (c.getSize().width - blockSize) / 2;

						if (!centerOneTouchButtons) {
							x = (insets != null) ? insets.left : 0;
							extraY = 0;
						}
						int height = (int) SplitPaneDivider.this.getSize().getHeight();
						y1 = height / 2 - oneTouchSize;
						leftButton.setBounds(x, extraY - oneTouchOffset + height / 2, blockSize, blockSize * 2);
						rightButton.setBounds(x, extraY - oneTouchOffset + oneTouchSize * 2 + height / 2, blockSize,
								blockSize * 2);
					}
				} else {
					leftButton.setBounds(-5, -5, 1, 1);
					rightButton.setBounds(-5, -5, 1, 1);
				}
			}
		}

		public Dimension minimumLayoutSize(Container c) {
			// NOTE: This isn't really used, refer to
			// BasicSplitPaneDivider.getPreferredSize for the reason.
			// I leave it in hopes of having this used at some point.
			if (splitPane == null) {
				return new Dimension(0, 0);
			}
			Dimension buttonMinSize = null;

			if (splitPane.isOneTouchExpandable() && leftButton != null) {
				buttonMinSize = leftButton.getMinimumSize();
			}

			Insets insets = getInsets();
			int width = getDividerSize();
			int height = width;

			if (orientation == JSplitPane.VERTICAL_SPLIT) {
				if (buttonMinSize != null) {
					int size = buttonMinSize.height;
					if (insets != null) {
						size += insets.top + insets.bottom;
					}
					height = Math.max(height, size);
				}
				width = 1;
			} else {
				if (buttonMinSize != null) {
					int size = buttonMinSize.width;
					if (insets != null) {
						size += insets.left + insets.right;
					}
					width = Math.max(width, size);
				}
				height = 1;
			}
			return new Dimension(width, height);
		}

		public Dimension preferredLayoutSize(Container c) {
			return minimumLayoutSize(c);
		}

		public void removeLayoutComponent(Component c) {
		}

		public void addLayoutComponent(String string, Component c) {
		}

	}
}
