package org.myblog.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 文章实体
 * @author Keven小卫
 */
public class ArticleVO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Integer id; //文章id

	private String title; //文章标题
	
	private String author; //文章作者
	
	private String content; //文章内容
	
	private Date releaseDate; //文章发布日期
	
	private int readCount; //文章阅读数
	
	private int commentCount; //文章评论数
	
	private int topLevel; //文章是否置顶，0表示置顶，1表示不置顶
	
	private int privacy; //文章是否私密，0表示公开，1表示私密
	
	private CategoryVO category; //文章和栏目是多对一的关联关系
	private TagVO tag; //文章和标签是多对多的关联关系
	private List<ArticleTagVO> articleTags; //文章和文章标签是多对多的关联关系
	
	private int id_category; //文章外键属性(参照栏目id)
	private int id_tag_article_tag; //文章外键属性(参照文章标签id_tag)

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getTopLevel() {
		return topLevel;
	}

	public void setTopLevel(int topLevel) {
		this.topLevel = topLevel;
	}

	public int getPrivacy() {
		return privacy;
	}

	public void setPrivacy(int privacy) {
		this.privacy = privacy;
	}

	public CategoryVO getCategory() {
		return category;
	}
	
	public TagVO getTag() {
		return tag;
	}

	public void setTag(TagVO tag) {
		this.tag = tag;
	}

	public void setCategory(CategoryVO category) {
		this.category = category;
	}
	
	public List<ArticleTagVO> getArticleTags() {
		return articleTags;
	}

	public void setArticleTags(List<ArticleTagVO> articleTags) {
		this.articleTags = articleTags;
	}

	public int getId_category() {
		return id_category;
	}

	public void setId_category(int id_category) {
		this.id_category = id_category;
	}

	public int getId_tag_article_tag() {
		return id_tag_article_tag;
	}

	public void setId_tag_article_tag(int id_tag_article_tag) {
		this.id_tag_article_tag = id_tag_article_tag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public ArticleVO() {
		super();
	}

	public ArticleVO(Integer id, String title, String author, String content,
			Date releaseDate, int readCount, int commentCount, int topLevel,
			int privacy, CategoryVO category, TagVO tag,
			List<ArticleTagVO> articleTags, int id_category,
			int id_tag_article_tag) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.content = content;
		this.releaseDate = releaseDate;
		this.readCount = readCount;
		this.commentCount = commentCount;
		this.topLevel = topLevel;
		this.privacy = privacy;
		this.category = category;
		this.tag = tag;
		this.articleTags = articleTags;
		this.id_category = id_category;
		this.id_tag_article_tag = id_tag_article_tag;
	}

	@Override
	public String toString() {
		return "ArticleVO [id=" + id + ", title=" + title + ", author="
				+ author + ", content=" + content + ", releaseDate="
				+ releaseDate + ", readCount=" + readCount + ", commentCount="
				+ commentCount + ", topLevel=" + topLevel + ", privacy="
				+ privacy + ", category=" + category + ", tag=" + tag
				+ ", articleTags=" + articleTags + ", id_category="
				+ id_category + ", id_tag_article_tag=" + id_tag_article_tag
				+ "]";
	}
}