package com.entity;

/**
 * 门店实体类
 */
public class Store {
	private Integer id;
	private String name;//门店名称
	private String address;//门店地址
	private String telephone;//联系电话
	private String tname;//店长姓名

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name +
				", address=" + address + ", telephone=" + telephone +
				", tname=" + tname + "]";
	}
}