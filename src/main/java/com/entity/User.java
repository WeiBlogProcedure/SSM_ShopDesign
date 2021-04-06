package com.entity;

/**
 * 员工实体类
 */
public class User {
	private Integer id;
	private String username;//用户名
	private String pwd;//密码
	private String name;//姓名
	private String sex;//性别
	private String position;//职位
	private Integer store;//所属门店
	private Store storefk;//用于获取门店信息
	private String telephone;//电话号
	private String limits;//权限

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getStore() {
		return store;
	}

	public void setStore(Integer store) {
		this.store = store;
	}

	public Store getStorefk() {
		return storefk;
	}

	public void setStorefk(Store storefk) {
		this.storefk = storefk;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLimits() {
		return limits;
	}

	public void setLimits(String limits) {
		this.limits = limits;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username +
				", pwd=" + pwd + ", name=" + name + ", sex=" + sex +
				", position=" + position + ", store=" + store +
				", telephone=" + telephone + ", limits=" + limits + "]";

	}
}