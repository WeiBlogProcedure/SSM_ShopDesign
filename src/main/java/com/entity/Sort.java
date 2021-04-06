package com.entity;

/**
 * 分类实体类
 */
public class Sort {
	private Integer id;
	private String name;//分类名称

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

	@Override
	public String toString() {
		return "Sort [id=" + id + ", name=" + name + "]";
	}
}