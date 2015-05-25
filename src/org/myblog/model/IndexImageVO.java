package org.myblog.model;

public class IndexImageVO {
	private int id;
	private String title;
	private int type; 
	private int status;
	private String articleLink;
	private String imgPath;
	private int orders;
	
	public IndexImageVO() {}
	
	public IndexImageVO(int id, String title, int type, int status,
			String articleLink, String imgPath, int orders) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.status = status;
		this.articleLink = articleLink;
		this.imgPath = imgPath;
		this.orders = orders;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getArticleLink() {
		return articleLink;
	}

	public void setArticleLink(String articleLink) {
		this.articleLink = articleLink;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "IndexImageVO [id=" + id + ", title=" + title + ", type=" + type
				+ ", status=" + status + ", articleLink=" + articleLink
				+ ", imgPath=" + imgPath + ", orders=" + orders + "]";
	}

	
	
	
	
	
	
}
