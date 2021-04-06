package com.entity;

/**
 * 产品实体类
 */
public class Product {
	private Integer id;
	private String name;//名称
	private String number;//编号
	private String sort;//分类
	private Sort sortfk;//用于获取分类列表
	private String price;//价格
	private Integer nums;//库存
	private String remarks;//备注

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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Sort getSortfk() {
		return sortfk;
	}

	public void setSortfk(Sort sortfk) {
		this.sortfk = sortfk;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getNums() {
		return nums;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name +
				", number=" + number + ", sort=" + sort +
				", price=" + price + ", nums=" + nums +
				", remarks=" + remarks + "]";
	}
}