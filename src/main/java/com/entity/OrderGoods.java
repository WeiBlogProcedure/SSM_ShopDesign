package com.entity;

/**
 * 订货单实体类
 */
public class OrderGoods {
	private Integer id;
	private String name;//产品名称
	private String sort;//产品分类
	private Sort sortfk;//获取产品信息
	private Integer nums;//数量
	private Integer store;//门店id
	private Store storefk;//获取门店信息
	private String sdate;//订单日期
	private String state;//状态
	private String uname;//用户名(创建订单门店员工)

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

	public Integer getNums() {
		return nums;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
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
		return "OrderGoods [id=" + id + ", name=" + name + ", sort=" + sort +
				", nums=" + nums + ", store=" + store +
				", sdate=" + sdate + ", state=" + state + ", uname=" + uname + "]";
	}
}