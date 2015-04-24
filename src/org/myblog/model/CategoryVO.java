package org.myblog.model;

import java.io.Serializable;
import java.util.List;

/**
 * 栏目实体
 * @author Keven小卫
 */
public class CategoryVO implements Serializable
{
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer id; //栏目id
	
	private String name; //栏目名称
	
	private List<ArticleVO> articles; //栏目和文章是一对多的关联关系
	
	private Integer parentId; //栏目外键父id自关联主键id
	
	//方便后面排序:数据库SQL语句concat(parent_id,id)
	private String parentIds;
	
	private Integer userId;

	private Integer type;
	
	private Integer orders;

	private Integer status;
	
	public boolean isRootNode() {
        return parentId == 0;
    }

    public String makeSelfAsParentIds() {
        return getParentIds() + getId() + "/";
    }
	public CategoryVO() {
		
	}
	
	public CategoryVO(Integer id, String name, List<ArticleVO> articles,
			Integer parentId, String parentIds, Integer userId, Integer type,
			Integer orders, Integer status) {
		this.id = id;
		this.name = name;
		this.articles = articles;
		this.parentId = parentId;
		this.parentIds = parentIds;
		this.userId = userId;
		this.type = type;
		this.orders = orders;
		this.status = status;
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

	public List<ArticleVO> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleVO> articles) {
		this.articles = articles;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CategoryVO [id=" + id + ", name=" + name + ", articles="
				+ articles + ", parentId=" + parentId + ", parentIds="
				+ parentIds + ", userId=" + userId + ", type=" + type
				+ ", orders=" + orders + ", status=" + status + "]";
	}
    
    
    
    
	
	/*private static final long serialVersionUID = 1L;
	
	private Integer id; //栏目id
	
	private String name; //栏目名称
	
	private List<ArticleVO> articles; //栏目和文章是一对多的关联关系
	
	private Integer parentId; //栏目外键父id自关联主键id
	
	//方便后面排序:数据库SQL语句concat(parent_id,id)
	private String parentIds;
	
	private Integer userId;

	private Integer type;
	
	private Integer orders;

	private Integer status;
	
	public boolean isRootNode() {
        return parentId == 0;
    }

    public String makeSelfAsParentIds() {
        return getParentIds() + getId() + "/";
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

	public List<ArticleVO> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleVO> articles) {
		this.articles = articles;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public String getParentIds() {
		return parentIds;
	}
	
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	*//**栏目类型:栏目类型:0-用户栏目;1-导航栏目;2-内容栏目;3-图片栏目**//*
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	*//**栏目顺序**//*
	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	*//**状态:0-未启用;1-启用**//*
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CategoryVO() {
		super();
	}


	public CategoryVO(Integer id, String name, List<ArticleVO> articles,
			Integer parentId,String parentIds, Integer userId, Integer type, Integer orders,
			Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.articles = articles;
		this.parentId = parentId;
		this.parentIds = parentIds;
		this.userId = userId;
		this.type = type;
		this.orders = orders;
		this.status = status;
	}

	@Override
	public String toString() {
		return "CategoryVO [id=" + id + ", name=" + name + ", articles="
				+ articles + ", parentId=" + parentId + ", parentIds=" + parentIds + ", userId=" + userId
				+ ", type=" + type + ", orders=" + orders + ", status="
				+ status + "]";
	}*/

	
}