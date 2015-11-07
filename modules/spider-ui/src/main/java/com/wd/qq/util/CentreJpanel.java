package com.wd.qq.util;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.print.attribute.standard.JobPrioritySupported;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;

import org.spider.resource.factory.LoadResource;


@SuppressWarnings("serial")
public class CentreJpanel extends JPanel {
	public CentreJpanel() {
		init();
	}

	void init() {

		jtabel = new JTabbedPane();
		xxf = new XXFirends();
		box = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(box);

		jphy1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		jphy1.setBackground(Color.WHITE);
		jphy1.add(xxf);

		jscrollpanel = new JScrollPane(jphy1,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jpmsr1 = new JPanel();
		jpmsr1.add(new Button("dd"));

		jtabel.setBackground(Color.WHITE);
		jtabel.addTab(" hh  ", LoadResource.getResource().getLr_imageIcon().get(
				"Pets_table"), jscrollpanel);
		jtabel.addTab(" hh  ", LoadResource.getResource().getLr_imageIcon().get(
				"Pets_table"), jpmsr1);
		jtabel.addTab(" hh  ", LoadResource.getResource().getLr_imageIcon().get(
				"Pets_table"), jphmd1);
		add(jtabel);
	}

	public Container getContentPane() {
		// TODO Auto-generated method stub
		return this;
	}

	private BoxLayout box;
	private JScrollPane jscrollpanel;
	private JTabbedPane jtabel;
	// 第一张卡片
	private JPanel jphy1;

	// 第二张卡片
	private JPanel jpmsr1;

	// 第二张卡片
	private JPanel jphmd1;

	private XXFirends xxf;
}
