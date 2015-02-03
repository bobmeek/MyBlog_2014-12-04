package org.myblog.model;

/**
 * 文章标签实体类
 * 该类用于描述文章和标签之间的对应关系
 * @author Keven小卫
 */
public class ArticleTagVO 
{
	private ArticleVO article; //文章对象
	
	private TagVO tag; //标签对象
	
	private int id_article; //文章标签外键属性(参照文章id)
	
	private int id_tag; //文章标签外键属性(参照标签id)

	public ArticleVO getArticle() {
		return article;
	}

	public void setArticle(ArticleVO article) {
		this.article = article;
	}

	public TagVO getTag() {
		return tag;
	}

	public void setTag(TagVO tag) {
		this.tag = tag;
	}
	
	public int getId_article() {
		return id_article;
	}

	public void setId_article(int id_article) {
		this.id_article = id_article;
	}

	public int getId_tag() {
		return id_tag;
	}

	public void setId_tag(int id_tag) {
		this.id_tag = id_tag;
	}

	public ArticleTagVO() {
		super();
	}

	public ArticleTagVO(ArticleVO article, TagVO tag, int id_article, int id_tag) {
		super();
		this.article = article;
		this.tag = tag;
		this.id_article = id_article;
		this.id_tag = id_tag;
	}

	@Override
	public String toString() {
		return "ArticleTagVO [article=" + article + ", tag=" + tag
				+ ", id_article=" + id_article + ", id_tag=" + id_tag + "]";
	}
}