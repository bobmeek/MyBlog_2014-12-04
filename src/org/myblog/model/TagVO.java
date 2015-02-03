package org.myblog.model;

import java.io.Serializable;
import java.util.List;

/**
 * 标签实体类
 * @author Keven小卫
 */
public class TagVO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int id; //标签id
	
	private String name; //标签名称
	
	private int tagCount; //标签数量
	
	private int id_article_article_tag; //标签外键属性(参照article_tag的id_article)
	
	private List<ArticleVO> articles; //标签和文章是多对多的关联关系

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getTagCount() {
		return tagCount;
	}

	public void setTagCount(int tagCount) {
		this.tagCount = tagCount;
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
	
	public int getId_article_article_tag() {
		return id_article_article_tag;
	}

	public void setId_article_article_tag(int id_article_article_tag) {
		this.id_article_article_tag = id_article_article_tag;
	}

	public TagVO() {
		super();
	}

	public TagVO(int id, String name, int tagCount, int id_article_article_tag,
			List<ArticleVO> articles) {
		super();
		this.id = id;
		this.name = name;
		this.tagCount = tagCount;
		this.id_article_article_tag = id_article_article_tag;
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "TagVO [id=" + id + ", name=" + name + ", tagCount=" + tagCount
				+ ", id_article_article_tag=" + id_article_article_tag
				+ ", articles=" + articles + "]";
	}
}