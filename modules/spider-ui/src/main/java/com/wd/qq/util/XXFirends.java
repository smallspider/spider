package com.wd.qq.util;

import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import org.spider.resource.factory.LoadResource;


//好友列表
public class XXFirends extends JTree {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3363595571421618666L;
	Image img;
	LoadResource lr;// 静态实例

	private FrientType node1 = null;// 好友
	private FrientType node2 = null;// 陌生人
	private FrientType node3 = null;// 黑名单
	DefaultMutableTreeNode top = null;

	public XXFirends() {
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {

		lr = LoadResource.getResource();
		top = new DefaultMutableTreeNode();

		node1 = new FrientType(0, "好友", "sign_right");
		top.add(node1);
		node2 = new FrientType(1, "陌生人", "sign_right");
		top.add(node2);
		node3 = new FrientType(2, "黑名单", "sign_right");
		top.add(node3);

		User user = null;
		for (int i = 0; i < 10; i++) {
			user = new User();
			user.setName("friends-" + i);
			user.setId(200 + i);
			user.setHeadImgName("check");
			addUser(1, user);
		}

		for (int i = 0; i < 10; i++) {
			user = new User();
			user.setName("strangers-" + i);
			user.setId(300 + i);
			user.setHeadImgName("check");
			addUser(2, user);

		}

		for (int i = 0; i < 10; i++) {
			user = new User();
			user.setName("strangers-" + i);
			user.setId(300 + i);
			user.setHeadImgName("check");
			addUser(3, user);
		}

		// 树的数据模型
		DefaultTreeModel model = new DefaultTreeModel(top);
		// 设置数据模型
		setModel(model);
		getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);// 设置模式
		setRootVisible(false);// 隐藏父节点
		putClientProperty("JTree.lineStyle", "None");// 设置是层次线消失
		setToggleClickCount(1);// 设置节点展开或关闭之前鼠标的单击数。

		setCellRenderer(new XXTreeCellRenderer());

		/*
		 * // 监听Tree的节点活动 this.addTreeSelectionListener(new
		 * TreeSelectionListener() {
		 * 
		 * @Override public void valueChanged(TreeSelectionEvent e) { // TODO
		 * Auto-generated method stub // 获取选择的节点 DefaultMutableTreeNode node =
		 * (DefaultMutableTreeNode) XXFirends.this
		 * .getLastSelectedPathComponent(); if (node == null) return;
		 * 
		 * if (node instanceof FrientType) { FrientType ft = (FrientType) node;
		 * if (!ft.isClick) { ft.setImageName("check"); ft.setClick(true); }
		 * else { System.out.println("=========="); ft.setImageName("sign");
		 * ft.setClick(false); }
		 * 
		 * System.out.println("FrientType :");
		 * 
		 * } else if (node instanceof User) { System.out.println("User :");
		 * 
		 * } } });
		 */

		// 监听鼠标事件
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int selRow = getRowForLocation(e.getX(), e.getY());
				TreePath selPath = getPathForLocation(e.getX(), e.getY());
				if (selRow != -1) {
					// if (e.getClickCount() == 1) { 获取鼠标按键次数
					myDoubleClick(selRow, selPath);
					// }
				}
			}

			private void myDoubleClick(int selRow, TreePath selPath) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) selPath
						.getLastPathComponent();
				if (node == null)
					return;

				if (node instanceof FrientType) {
					FrientType ft = (FrientType) node;

					if (!ft.isClick) {
						ft.setImageName("sign_down");
						ft.setClick(true);
					} else {
						ft.setImageName("sign_right");
						ft.setClick(false);
					}
					System.out.println("FrientType :");

				} else if (node instanceof User) {
					System.out.println("User :");

				}
			}
		});
        
	}

	/**
	 * 
	 * @param i
	 *            1 代表好友 2 代表陌生人 3 代表黑名单
	 * @param u
	 */
	public void addUser(int i, User u) {
		if (i == 1) {
			node1.add(u);
		} else if (i == 2) {
			node2.add(u);
		} else if (i == 3) {
			node3.add(u);
		}
	}

	public static void main(String[] args) {

	}

	// 好友类型
	@SuppressWarnings("serial")
	class FrientType extends DefaultMutableTreeNode {

		FrientType(String text, String imageName) {
			super(text);
			this.imageName = imageName;
		}

		public FrientType(int i, String text, String imageName) {
			// TODO Auto-generated constructor stub
			this(text, imageName);
			this.id = i;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getImageName() {
			return imageName;
		}

		public void setImageName(String imageName) {
			this.imageName = imageName;
		}

		public boolean isClick() {
			return isClick;
		}

		public void setClick(boolean isClick) {
			this.isClick = isClick;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		private int id;
		private String name;
		private String imageName;
		private boolean isClick;
	}

	// 树节点渲染器
	class XXTreeCellRenderer extends DefaultTreeCellRenderer {

		private static final long serialVersionUID = 147557432828425233L;

		public Component getTreeCellRendererComponent(JTree tree, Object value,
				boolean sel, boolean expanded, boolean leaf, int row,
				boolean hasFocus) {

			super.getTreeCellRendererComponent(tree, value, sel, expanded,
					leaf, row, hasFocus);

			if (leaf) {
				User user = (User) value;
				setFont(new Font("宋体", Font.PLAIN, 14));
				setIcon(lr.getLr_imageIcon().get(user.getHeadImgName()));
				setText(user.getName());
			} else {
				FrientType ft = (FrientType) value;
				setFont(new Font("宋体", Font.PLAIN, 14));
				setIcon(lr.getLr_imageIcon().get(ft.getImageName()));
			}
			return this;
		}
	}
}
