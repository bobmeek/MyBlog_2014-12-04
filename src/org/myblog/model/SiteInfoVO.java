package org.myblog.model;

/**   
 * @desc   [ 站点信息 ]
 * @author [ bobmeek ]   
 * @time   [ 2015年3月24日 下午5:16:45 ] 
 *
 */
public class SiteInfoVO {
	private Integer id;
	private String siteName;
	private String mainTitle;
	private String subTitle;
	private String footerTitle;
	private String copyright;
	private Integer pageCount;
	private Integer hotPageCount;
	private String target; //打开网页的方式
	private Integer navCount; //导航最多显示数量
	public SiteInfoVO() {
		super();
	}
	
	public SiteInfoVO(Integer id, String siteName, String mainTitle,
			String subTitle, String footerTitle, String copyright,
			Integer pageCount, Integer hotPageCount, String target,Integer navCount) {
		super();
		this.id = id;
		this.siteName = siteName;
		this.mainTitle = mainTitle;
		this.subTitle = subTitle;
		this.footerTitle = footerTitle;
		this.copyright = copyright;
		this.pageCount = pageCount;
		this.hotPageCount = hotPageCount;
		this.target = target;
		this.navCount = navCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getMainTitle() {
		return mainTitle;
	}

	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getFooterTitle() {
		return footerTitle;
	}

	public void setFooterTitle(String footerTitle) {
		this.footerTitle = footerTitle;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getHotPageCount() {
		return hotPageCount;
	}

	public void setHotPageCount(Integer hotPageCount) {
		this.hotPageCount = hotPageCount;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	
	public Integer getNavCount() {
		return navCount;
	}
	public void setNavCount(Integer navCount) {
		this.navCount = navCount;
	}

	@Override
	public String toString() {
		return "SiteInfoVO [id=" + id + ", siteName=" + siteName
				+ ", mainTitle=" + mainTitle + ", subTitle=" + subTitle
				+ ", footerTitle=" + footerTitle + ", copyright=" + copyright
				+ ", pageCount=" + pageCount + ", hotPageCount=" + hotPageCount
				+ ", target=" + target + ", navCount="+navCount+"]";
	}

	
	
	
	
}
