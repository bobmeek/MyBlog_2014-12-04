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
	
	private Integer parent_id; //栏目外键父id自关联主键id
	
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public CategoryVO() {
		super();
	}

	public CategoryVO(Integer id, String name, List<ArticleVO> articles,
			Integer parent_id) {
		super();
		this.id = id;
		this.name = name;
		this.articles = articles;
		this.parent_id = parent_id;
	}

	@Override
	public String toString() {
		return "CategoryVO [id=" + id + ", name=" + name + ", articles="
				+ articles + ", parent_id=" + parent_id + "]";
	}
}