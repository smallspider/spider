package org.spider.data.center.entity;

import java.util.List;

public class UserEntity {
	private String userId;
	private String userName;
	private String password;
	private String email;
	private String tel;
	private String image;
	private List<GroupEntity> groupEntitys;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<GroupEntity> getGroupEntitys() {
		return groupEntitys;
	}

	public void setGroupEntitys(List<GroupEntity> groupEntitys) {
		this.groupEntitys = groupEntitys;
	}
}
