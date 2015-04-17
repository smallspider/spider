package com.wd.qq.util;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CrystalLabel extends JLabel{

	

	public CrystalLabel() {
		initStyle();
	}

	public CrystalLabel(ImageIcon img) {
		this();
		image = img.getImage();
	}
	public CrystalLabel(Image img) {
		this();
		image = img;
	}
	/**
	 * 初始化按钮样式
	 */
	private void initStyle() {
		// setOpaque(false);
		// setBorder(null);
		// setBorderPainted(false);
		// setFocusable(false);
		//setFocusPainted(false);// 不绘制焦点
	    //setBorderPainted(false); //不绘制边界
		//setContentAreaFilled(false); // 不填充所占的矩形区域
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		if(image != null){
			g.drawImage(image, 1, 6, this);
		}
		//g.drawRect(1, 1, this.getWidth() - 2, this.getHeight() - 2);
		//g.fillPolygon(new int[] { 50, 57, 63 }, new int[] { 8, 20, 8 }, 3);
	}

	@Override
	public void setIcon(Icon defaultIcon) {
		// TODO Auto-generated method stub

	}

	public void setImage(Image defaultIcon) {
		// TODO Auto-generated method stub
		image = defaultIcon;
	}
	private Image image;
}
