package org.myblog.model;

import java.io.Serializable;

/**
 * 首页导航菜单
 * @author bobmeek
 *
 */
public class MenuVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer parentId;
	private int type;
	private int status;
	private int orders;
	public MenuVO() {
		super();
	}
	public MenuVO(Integer id, String name, Integer parentId,int type, int status,int orders) {
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.type = type;
		this.status = status;
		this.orders = orders;
	}
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
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", parentId=" + parentId
				+ ", status=" + status+ ", type=" + type + ", orders=" + orders + "]";
	}
	
	

}
