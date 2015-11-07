package com.wd.qq.util;

import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("serial")
public class User extends DefaultMutableTreeNode {

	public User() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getHeadImgName() {
		return headImgName;
	}

	public void setHeadImgName(String headImgName) {
		this.headImgName = headImgName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * user HTML formation to format the components
	 */
	public String toString() {
		return "<html><center><b>" + name + "(" + id + ")</b><br>"
				+ "<font color=#0920F7>ha ha ha !</font>";

	}

	private String headImgName;
	private String name;
	private String ip;
	private int port;
	private int id;
}
