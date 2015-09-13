package org.spider.ui.widget;

import java.awt.HeadlessException;
import java.awt.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class FriendList extends JList {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FriendList() throws HeadlessException {
		super();
		init();
	}

	private void init() {
		DefaultListModel listModel = new DefaultListModel();
		listModel.addElement("a");
		listModel.addElement("a");
		listModel.addElement("a");
		setModel(listModel);
		setCellRenderer(new SpiderListRenderer(this));
	}
}
