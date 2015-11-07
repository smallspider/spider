package org.spider.resource.factory;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

//负责加载资源类
public class ImageFactory {

	static ImageFactory imaeFactory;// 静态实例

	Map<String, Image> lf_image_map = null;// 负责存放Image
	Map<String, ImageIcon> lf_imageIcon_map = null;// 负责存放ImageIcon
	/**
	 * @return the lr_map
	 */

	Image img = null;
	ImageIcon imgi = null;

	Toolkit tl = null;

	// 私有构造函数
	private ImageFactory() {
		lf_image_map = new HashMap<String, Image>();
		lf_imageIcon_map = new HashMap<String, ImageIcon>();
		tl = Toolkit.getDefaultToolkit();
		loadResource();
	}

	// 获得该实例
	public static ImageFactory getImageFactory() {
		if (imaeFactory == null) {
			imaeFactory = new ImageFactory();
		}
		return imaeFactory;
	}

	public void loadResource() {
		ClassLoader cl = this.getClass().getClassLoader();// 获得类加载器
		// 获得资源
		img = tl.getImage(cl.getResource("images/bg_game.JPG"));
		// 保存资源
		lf_image_map.put("bg_game", img);
		// 获得资源
		img = tl.getImage(cl.getResource("images/black.png"));
		// 保存资源
		lf_image_map.put("black", img);
		// 获得资源
		img = tl.getImage(cl.getResource("images/pointer.png"));
		// 保存资源
		lf_image_map.put("pointer", img);
		// 获得资源
		img = tl.getImage(cl.getResource("images/white.png"));
		// 保存资源
		lf_image_map.put("white", img);
		// 获得资源
		img = tl.getImage(cl.getResource("images/menu.png"));
		// 保存资源
		lf_image_map.put("menu", img);
		// 获得资源
		img = tl.getImage(cl.getResource("images/w.png"));
		// 保存资源
		lf_image_map.put("w", img);
		// 获得资源
		img = tl.getImage(cl.getResource("images/x.gif"));
		// 保存资源
		lf_image_map.put("x", img);

		// 获得资源
		img = tl.getImage(cl.getResource("images/user_green.png"));
		// 保存资源
		lf_image_map.put("user_green", img);

		// 获得资源
		img = tl.getImage(cl.getResource("images/search1.png"));
		// 保存资源
		lf_image_map.put("search1", img);

		// 获得资源
		img = tl.getImage(cl.getResource("images/border.gif"));
		// 保存资源
		lf_image_map.put("border", img);
		
		// 获得资源
		img = tl.getImage(cl.getResource("images/Logining.gif"));
		// 保存资源
		lf_image_map.put("logining", img);
		
		// 获得资源
		img = tl.getImage(cl.getResource("images/LoginPanel_window_windowBkg.gif"));
		// 保存资源
		lf_image_map.put("LoginPanel_window_windowBkg", img);
		img = tl.getImage(cl.getResource("images/top.gif"));
		// 保存资源
		lf_image_map.put("top", img);
		
////////////////////////////////////////////////////////////////////////
		// 获得资源
		imgi = new ImageIcon(cl.getResource("images/check.png"));
		// 保存资源
		lf_imageIcon_map.put("check", imgi);

		// 获得资源
		imgi = new ImageIcon(cl.getResource("images/user_green.png"));
		// 保存资源
		lf_imageIcon_map.put("user_green", imgi);

		// 获得资源
		imgi = new ImageIcon(cl.getResource("images/search.png"));
		// 保存资源
		lf_imageIcon_map.put("search", imgi);

		// 获得资源
		imgi = new ImageIcon(cl.getResource("images/search1.png"));
		// 保存资源
		lf_imageIcon_map.put("search1", imgi);
		// 获得资源
		imgi = new ImageIcon(cl.getResource("images/root.png"));
		// 保存资源
		lf_imageIcon_map.put("root", imgi);
		// 获得资源
		imgi = new ImageIcon(cl.getResource("images/sign_right.png"));
		// 保存资源
		lf_imageIcon_map.put("sign_right", imgi);
		// 获得资源
		imgi = new ImageIcon(cl.getResource("images/sign_down.png"));
		// 保存资源
		lf_imageIcon_map.put("sign_down", imgi);
		imgi = new ImageIcon(cl.getResource("images/btn_clear.png"));
		// 保存资源
		lf_imageIcon_map.put("btn_clear", imgi);
		// 获得资源
		imgi = new ImageIcon(cl.getResource("images/Pets_table.png"));
		// 保存资源
		lf_imageIcon_map.put("Pets_table", imgi);
		// 获得资源
		imgi = new ImageIcon(cl
				.getResource("images/bar_button_close_pressed.png"));
		// 保存资源
		lf_imageIcon_map.put("bar_button_close_pressed", imgi);
		// 获得资源
		imgi = new ImageIcon(cl
				.getResource("images/bar_button_hide_pressed.png"));
		// 保存资源
		lf_imageIcon_map.put("bar_button_hide_pressed", imgi);

		imgi = new ImageIcon(cl.getResource("images/button.gif"));
		// 保存资源
		lf_imageIcon_map.put("button", imgi);
		imgi = new ImageIcon(cl.getResource("images/1-1.png"));
		// 保存资源
		lf_imageIcon_map.put("1-1", imgi);
		
	}

	public Map<String, Image> getlf_image_map() {
		return lf_image_map;
	}

	public Map<String, ImageIcon> getlf_imageIcon_map() {
		return lf_imageIcon_map;
	}

	public static void main(String[] arg) {
		ImageFactory lr = ImageFactory.getImageFactory();
		lr.loadResource();
		System.out.println(lr.getlf_imageIcon_map().get("1-1"));
	}
}
