package com.wd.qq.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.MenuElement;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.spider.resource.factory.LoadResource;


@SuppressWarnings("serial")
public class TopJpanel extends JPanel {
	public TopJpanel() {
		init();
	}

	void init() {
		mla = new MouseListenerAdapter();// 鼠标事件
		setLayout(null);
		this.setBackground(Color.WHITE);
		jb = new CrystalButton(LoadResource.getResource().getLr_map().get(
				"user_green"));
		jb.setBounds(0, 0, 70, 27);
		jb.setPreferredSize(new Dimension(70, 27));

		jb.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Point point = jb.getLocation();
				jPopupMenu.show(jb, point.x, point.y + jb.getHeight());
				int index = jPopupMenu.getSelectionModel().getSelectedIndex();
				System.out.println(index);
			}
		});

		jPopupMenu = new JPopupMenu();
		jPopupMenu.setSize(20, 20);

		JMenuItem[] jitems = new JMenuItem[] { new JMenuItem("在线 "),
				new JMenuItem("暂离"), new JMenuItem("用餐"), new JMenuItem("开会"),
				new JMenuItem("来客"), new JMenuItem("出去"), new JMenuItem("回家"),
				new JMenuItem("很困"), new JMenuItem("工作"), new JMenuItem("隐身") };
		for (int i = 0, lenght = jitems.length; i < lenght; i++) {
			if (i == jitems.length - 1) {
				jPopupMenu.addSeparator();
			}
			String jiText = jitems[i].getText();
			jitems[i].setText("   " + jiText);
			jPopupMenu.add(jitems[i]);
			if (i == 0) {
				jitems[0].setIcon(LoadResource.getResource().getLr_imageIcon()
						.get("check"));
				jPopupMenu.addSeparator();

			}
			jitems[i].addActionListener(new ActionListener() {

				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JMenuItem jitem = (JMenuItem) e.getSource();
					JPopupMenu jpopm = (JPopupMenu) jitem.getParent();

					if (jitem.getIcon() != null) {
						return;
					}

					ImageIcon iicon = LoadResource.getResource()
							.getLr_imageIcon().get("check");

					MenuElement[] me = jpopm.getSubElements();
					for (int j = 0; j < me.length; j++) {
						JMenuItem jmicon = (JMenuItem) me[j];
						jmicon.setIcon(null);
					}
					//
					// 对应事件处理代码
					//

					jitem.setIcon(iicon);
					jb.setText(jitem.getText().trim());
				}
			});

		}

		jPopupMenu.addVetoableChangeListener(new VetoableChangeListener() {

			
			public void vetoableChange(PropertyChangeEvent evt)
					throws PropertyVetoException {
				// TODO Auto-generated method stub
				// System.out.println(evt.getNewValue());

			}
		});

		jlTop = new CrystalLabel(LoadResource.getResource().getLr_map().get(
				"search1"));
		jlTop.setBounds(70, 0, 15, 25);
		jlTop.setPreferredSize(new Dimension(15, 25));
		jlTop.setForeground(Color.WHITE);
		jlTop.setBackground(Color.WHITE);

		jfTop = new JTextField();
		jfTop.setBounds(90, 0, 130, 27);
		jfTop.setPreferredSize(new Dimension(130, 27));
		jfTop.setText("搜索好友");

		jlTopClear = new CrystalLabel(LoadResource.getResource()
				.getLr_imageIcon().get("btn_clear"));
		jlTopClear.setBounds(220, 0, 15, 24);
		jlTopClear.setPreferredSize(new Dimension(15, 24));

		jlTopClear.addMouseListener(mla);
		jfTop.addMouseListener(mla);
		jfTop.addKeyListener(new KeyAdapter() {

			
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				String current = jfTop.getText();
				if (current.equals("搜索好友")) {
					jfTop.setText("");
				}
			}

		});
        jfTop.getDocument().addDocumentListener(new DocumentListener(){

			
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				jfTop.setCaretPosition(0);
			}

			
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				jfTop.setCaretPosition(0);
			}

			
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				jfTop.setCaretPosition(0);
			}});
	
		
		add(jb);
		add(jlTop);
		add(jfTop);
		add(jlTopClear);
		setBounds(0, 0, 250, 25);
		setPreferredSize(new Dimension(250, 25));
	}

	
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.draw3DRect(0, 0, 250, 25, true);
	}

	// 鼠标监听器
	class MouseListenerAdapter extends MouseAdapter {

		private boolean flag;
		private String content;

		
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Object ob = e.getSource();
			if (ob instanceof JTextField) {
				JTextField jtf = (JTextField) e.getSource();
				if (!flag) {
					content = jtf.getText();
					jtf.setText("");
					System.out.println("鼠标进来了");
					flag = true;
				}
			} else if (ob instanceof CrystalLabel) {
				String current = jfTop.getText();
				if (!current.equals("搜索好友")) {
					jfTop.setText("");
				}
			}
		}

		
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Object ob = e.getSource();
			if (ob instanceof JTextField) {
				JTextField jtf = (JTextField) e.getSource();
				if (jtf.getText().equals("")) {
					jfTop.setText(content);
					flag = false;
				}
			}
		}
	}

	private CrystalLabel jlTopClear;
	private CrystalLabel jlTop;
	private JTextField jfTop;
	private MouseListenerAdapter mla;
	private CrystalButton jb;
	private JPopupMenu jPopupMenu;
}
