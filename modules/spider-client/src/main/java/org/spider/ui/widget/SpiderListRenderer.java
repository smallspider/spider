package org.spider.ui.widget;

import java.awt.Color;
import java.awt.Component;
import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class SpiderListRenderer extends JLabel implements ListCellRenderer, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6301718737778285519L;
	private JList list;

	/**
	 * 
	 * JList cell renderer.
	 */

	public SpiderListRenderer(JList list) {

		this.list = list;

		// setLayout(null);

		// add(checkBox = new JCheckBox());

		// add(label = new MyListLabel());

		// checkBox.setBackground(UIManager.getColor("Tree.textBackground"));

		// label.setForeground(UIManager.getColor("Tree.textForeground"));

		// commonIcon = UIManager.getIcon("Tree.leafIcon");

	}

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		if (isSelected) {
			setBackground(Color.RED);
			setForeground(Color.RED);
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		if (value instanceof Icon) {
			setIcon((Icon) value);
			setText("---");
		} else {
			setIcon(null);
			setText((value == null) ? "" : value.toString());
		}
		return this;
	}

}
