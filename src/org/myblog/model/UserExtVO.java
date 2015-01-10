/**  
 * @Title: UserExtVO.java
 * @Package org.myblog.model
 * @Description: TODO
 * @author bobmeek
 * @date Jan 10, 2015 4:44:19 PM
 * @version V1.0  
 */
package org.myblog.model;

import java.sql.Date;

/**
 * @ClassName: UserExtVO
 * @Description: 用户信息扩展类
 * @author bobmeek
 * @date Jan 10, 2015 4:44:19 PM
 */
public class UserExtVO
{
	
	private Integer id;
	private Integer gender;
	private Date birthday;
	private String mobile;
	private String headImg;
	private String signature;
	private String qq;
	private String intro;
	private UserVO user;
	
	public UserExtVO()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public UserExtVO(Integer id, Integer gender, Date birthday, String mobile, String headImg, String signature, String qq, String intro, UserVO user)
	{
		super();
		this.id = id;
		this.gender = gender;
		this.birthday = birthday;
		this.mobile = mobile;
		this.headImg = headImg;
		this.signature = signature;
		this.qq = qq;
		this.intro = intro;
		this.user = user;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getGender()
	{
		return gender;
	}

	public void setGender(Integer gender)
	{
		this.gender = gender;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getHeadImg()
	{
		return headImg;
	}

	public void setHeadImg(String headImg)
	{
		this.headImg = headImg;
	}

	public String getSignature()
	{
		return signature;
	}

	public void setSignature(String signature)
	{
		this.signature = signature;
	}

	public String getQq()
	{
		return qq;
	}

	public void setQq(String qq)
	{
		this.qq = qq;
	}

	public String getIntro()
	{
		return intro;
	}

	public void setIntro(String intro)
	{
		this.intro = intro;
	}

	public UserVO getUser()
	{
		return user;
	}

	public void setUser(UserVO user)
	{
		this.user = user;
	}

	@Override
	public String toString()
	{
		return "UserExtVO [id=" + id + ", gender=" + gender + ", birthday=" + birthday + ", mobile=" + mobile + ", headImg=" + headImg + ", signature=" + signature + ", qq=" + qq + ", intro=" + intro
				+ ", user=" + user + "]";
	}

	
	
	
	
	
	
}
