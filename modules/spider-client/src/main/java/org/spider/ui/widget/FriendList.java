package org.spider.ui.widget;

import java.awt.HeadlessException;
import java.awt.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

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
		addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3){
					
				}
			}
		});
	}
}
