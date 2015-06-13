package org.myblog.model;

public class RegistrationVO {
	
	private int id;
	private String name;
	
	private int gender;//性别
	private String professional;//专业
	private String province;//省份
	private String qq;
	private int totalScores; //总成绩
	private int englishScores; //英语成绩
	private String idNumber; //身份证
	private String ticketNumber; //准考证号
	private String registrationNumber; //报名号
	private String homeAddress; //家庭住址
	private String phone; //电话
	private String time; //注册时间
	
	
	public RegistrationVO() {
		super(); 
	}

	public RegistrationVO(int id, String name, int gender, String province,
			String qq, String professional, int totalScores, int englishScores,
			String ticketNumber, String registrationNumber, String idNumber,
			String homeAddress, String phone, String time) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.province = province;
		this.qq = qq;
		this.professional = professional;
		this.totalScores = totalScores;
		this.englishScores = englishScores;
		this.ticketNumber = ticketNumber;
		this.registrationNumber = registrationNumber;
		this.idNumber = idNumber;
		this.homeAddress = homeAddress;
		this.phone = phone;
		this.time = time;
	}

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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public int getTotalScores() {
		return totalScores;
	}

	public void setTotalScores(int totalScores) {
		this.totalScores = totalScores;
	}

	public int getEnglishScores() {
		return englishScores;
	}

	public void setEnglishScores(int englishScores) {
		this.englishScores = englishScores;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", province=" + province + ", qq=" + qq + ", professional="
				+ professional + ", totalScores=" + totalScores
				+ ", englishScores=" + englishScores + ", ticketNumber="
				+ ticketNumber + ", registrationNumber=" + registrationNumber
				+ ", idNumber=" + idNumber + ", homeAddress=" + homeAddress
				+ ", phone=" + phone+ ", time=" + time + "]";
	}
	
	
	
	
	
}
