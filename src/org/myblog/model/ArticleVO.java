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
	
	private String releaseDate; //文章发布日期
	
	private int readCount; //文章阅读数
	
	private int commentCount; //文章评论数
	
	private int topLevel = 0; //文章是否置顶，0-不置顶，1-置顶
	
	private int highLight = 0; //文章是否高亮,0-不高亮,1-高亮
	
	private int privacy = 1; //文章是否私密，0-私密，1-公开
	
	
	
	private CategoryVO category; //文章和栏目是多对一的关联关系
	private MenuVO menu;
	private List<ArticleTagVO> articleTags; //文章和文章标签是多对多的关联关系
	private int cagegoryId;
	private int menuId;
	
	public ArticleVO() {
	}
	
	public ArticleVO(Integer id, String title, String author, String content,
			String releaseDate, int readCount, int commentCount, int topLevel,
			int highLight,int privacy, CategoryVO category, MenuVO menu,
			List<ArticleTagVO> articleTags, int cagegoryId, int menuId) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.content = content;
		this.releaseDate = releaseDate;
		this.readCount = readCount;
		this.commentCount = commentCount;
		this.topLevel = topLevel;
		this.highLight = highLight;
		this.privacy = privacy;
		this.category = category;
		this.menu = menu;
		this.articleTags = articleTags;
		this.cagegoryId = cagegoryId;
		this.menuId = menuId;
	}
	
	
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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
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
	
	public int getHighLight() {
		return highLight;
	}
	
	public void setHighLight(int highLight) {
		this.highLight = highLight;
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

	public void setCategory(CategoryVO category) {
		this.category = category;
	}

	public MenuVO getMenu() {
		return menu;
	}

	public void setMenu(MenuVO menu) {
		this.menu = menu;
	}

	public List<ArticleTagVO> getArticleTags() {
		return articleTags;
	}

	public void setArticleTags(List<ArticleTagVO> articleTags) {
		this.articleTags = articleTags;
	}

	public int getCagegoryId() {
		return cagegoryId;
	}

	public void setCagegoryId(int cagegoryId) {
		this.cagegoryId = cagegoryId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ArticleVO [id=" + id + ", title=" + title + ", author="
				+ author + ", content=" + content + ", releaseDate="
				+ releaseDate + ", readCount=" + readCount + ", commentCount="
				+ commentCount + ", topLevel=" + topLevel + ", privacy="
				+ privacy +", highLight="+ highLight + ", category=" + category + ", menu=" + menu
				+ ", articleTags=" + articleTags + ", cagegoryId=" + cagegoryId
				+ ", menuId=" + menuId + "]";
	}
	
	
	
	
	
	
	
	
	
	
}