package com.entity;

/**
 * 调货实体类
 */
public class Transfer {
	private Integer id;
	private String name;//产品名称
	private String sort;//产品分类
	private Sort sortfk;//用于获取分类列表信息
	private Integer store;//门店
	private Store storefk;//用于获得门店信息
	private Integer nums;//调货数量
	private String sdate;//调货日期
	private String state;//状态
	private String uname;//执行此操作的用户名

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

	public Integer getNums() {
		return nums;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Override
	public String toString() {
		return "Diaohuo [id=" + id + ", name=" + name +
				", sort=" + sort + ", store=" + store +
				", nums=" + nums + ", sdate=" + sdate +
				", state=" + state + ", uname=" + uname + "]";
	}
}