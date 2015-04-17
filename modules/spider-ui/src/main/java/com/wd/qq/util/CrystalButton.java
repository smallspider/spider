package com.wd.qq.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Event;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JButton;

public class CrystalButton extends JButton {

	// private boolean isMouseEntered = false;// 鼠标是否进入按钮

	public CrystalButton() {
		initStyle();
	}

	public CrystalButton(Image img) {
		this();
		image = img;
		content = "隐身";

	}

	public CrystalButton(String buttonText) {
		super(buttonText);
		initStyle();
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
		setFocusPainted(false);// 不绘制焦点
		setContentAreaFilled(false); // 不填充所占的矩形区域
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(image, 5, 5, this);
		//g.drawRect(1, 1, this.getWidth() - 2, this.getHeight() - 2);
		g.drawString(content, 23, 18);
		g.fillPolygon(new int[] { 50, 57, 63 }, new int[] { 8, 20, 8 }, 3);
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		content = text;
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
	private String content;
}
