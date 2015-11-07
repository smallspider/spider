package org.spider.resource.factory;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

//负责加载资源类
public class LoadResource {

	static LoadResource lr;// 静态实例
	Map<String, Image> lr_map = null;// 负责存放Image
	Map<String, ImageIcon> lr_imageIcon = null;// 负责存放ImageIcon
	/**
	 * @return the lr_map
	 */

	Image img = null;
	ImageIcon imgi = null;

	Toolkit tl = null;

	// 私有构造函数
	private LoadResource() {
		lr_map = new HashMap<String, Image>();
		lr_imageIcon = new HashMap<String, ImageIcon>();
		tl = Toolkit.getDefaultToolkit();
		loadResource();
	}

	// 获得该实例
	public static LoadResource getResource() {
		if (lr == null) {
			lr = new LoadResource();
		}
		return lr;
	}

	public void loadResource() {
		ClassLoader cl = this.getClass().getClassLoader();// 获得类加载器
		// 获得资源
		img = tl.getImage(cl.getResource("images/bg_game.JPG"));
		// 保存资源
		lr_map.put("bg_game", img);
		// 获得资源
		img = tl.getImage(cl.getResource("images/black.png"));
		// 保存资源
		lr_map.put("black", img);
		// 获得资源
		img = tl.getImage(cl.getResource("images/pointer.png"));
		// 保存资源
		lr_map.put("pointer", img);
		// 获得资源
		img = tl.getImage(cl.getResource("images/white.png"));
		// 保存资源
		img = lr_map.put("white", img);
		// 获得资源
		img = tl.getImage(cl.getResource("images/menu.png"));
		// 保存资源
		img = lr_map.put("menu", img);
		// 获得资源
		img = tl.getImage(cl.getResource("images/w.png"));
		// 保存资源
		img = lr_map.put("w", img);
		// 获得资源
		img = tl.getImage(cl.getResource("images/x.gif"));
		// 保存资源
		img = lr_map.put("x", img);

		// 获得资源
		img = tl.getImage(cl.getResource("images/user_green.png"));
		// 保存资源
		img = lr_map.put("user_green", img);

		// 获得资源
		img = tl.getImage(cl.getResource("images/search1.png"));
		// 保存资源
		lr_map.put("search1", img);

		// 获得资源
		img = tl.getImage(cl.getResource("images/border.gif"));
		// 保存资源
		lr_map.put("border", img);

		// 获得资源
		imgi = new ImageIcon(cl.getResource("images/check.png"));
		// 保存资源
		lr_imageIcon.put("check", imgi);

		// 获得资源
		imgi = new ImageIcon(cl.getResource("images/user_green.png"));
		// 保存资源
		lr_imageIcon.put("user_green", imgi);

		// 获得资源
		imgi = new ImageIcon(cl.getResource("images/search.png"));
		// 保存资源
		lr_imageIcon.put("search", imgi);

		// 获得资源
		imgi = new ImageIcon(cl.getResource("images/search1.png"));
		// 保存资源
		lr_imageIcon.put("search1", imgi);
		// 获得资源
		imgi = new ImageIcon(cl.getResource("images/root.png"));
		// 保存资源
		lr_imageIcon.put("root", imgi);
		// 获得资源
		imgi = new ImageIcon(cl.getResource("images/sign_right.png"));
		// 保存资源
		lr_imageIcon.put("sign_right", imgi);
		// 获得资源
		imgi = new ImageIcon(cl.getResource("images/sign_down.png"));
		// 保存资源
		lr_imageIcon.put("sign_down", imgi);
		imgi = new ImageIcon(cl.getResource("images/btn_clear.png"));
		// 保存资源
		lr_imageIcon.put("btn_clear", imgi);
		// 获得资源
		imgi = new ImageIcon(cl.getResource("images/Pets_table.png"));
		// 保存资源
		lr_imageIcon.put("Pets_table", imgi);
		// 获得资源
		imgi = new ImageIcon(
				cl.getResource("images/bar_button_close_pressed.png"));
		// 保存资源
		lr_imageIcon.put("bar_button_close_pressed", imgi);
		// 获得资源
		imgi = new ImageIcon(
				cl.getResource("images/bar_button_hide_pressed.png"));
		// 保存资源
		lr_imageIcon.put("bar_button_hide_pressed", imgi);
		// System.out.println(lr_map.get("bg_game"));bar_button_close_pressed.png
	}

	public Map<String, Image> getLr_map() {
		return lr_map;
	}

	public Map<String, ImageIcon> getLr_imageIcon() {
		return lr_imageIcon;
	}
	
	public static void main(String[] arg) {
		LoadResource lr = LoadResource.getResource();
		lr.loadResource();
		System.out.println(lr.getLr_map().get("bg_game"));
	}
}
