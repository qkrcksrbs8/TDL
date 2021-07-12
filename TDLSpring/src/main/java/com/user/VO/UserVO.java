package com.user.VO;

/**
 * 회원정보
 *
 */
public class UserVO {
	
	private int userNo 				= 0;
	private String userId 			= "";
	private String userName 		= "";
	private String userGender 		= "";
	private String phoneSt			= "010";
	private String phoneMd			= "";
	private String phoneEd			= "";
	private String emailId			= "";
	private String emailDomain		= "";
	private String brithday			= "";
	private String useFlag			= "Y";
	private String createdBy		= "pcg0902";
	private String createdDate 		= "";
	private String lastUpdateBy 	= "pcg0902";
	private String lastUpdateDate 	= "";
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getPhoneSt() {
		return phoneSt;
	}
	public void setPhoneSt(String phoneSt) {
		this.phoneSt = phoneSt;
	}
	public String getPhoneMd() {
		return phoneMd;
	}
	public void setPhoneMd(String phoneMd) {
		this.phoneMd = phoneMd;
	}
	public String getPhoneEd() {
		return phoneEd;
	}
	public void setPhoneEd(String phoneEd) {
		this.phoneEd = phoneEd;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailDomain() {
		return emailDomain;
	}
	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	public String getBrithday() {
		return brithday;
	}
	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}
	public String getUseFlag() {
		return useFlag;
	}
	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getLastUpdateBy() {
		return lastUpdateBy;
	}
	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	@Override
	public String toString() {
		return "UserVO [userNo=" + userNo + ", userId=" + userId + ", userName=" + userName + ", userGender="
				+ userGender + ", phoneSt=" + phoneSt + ", phoneMd=" + phoneMd + ", phoneEd=" + phoneEd + ", emailId="
				+ emailId + ", emailDomain=" + emailDomain + ", brithday=" + brithday + ", useFlag=" + useFlag
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", lastUpdateBy=" + lastUpdateBy
				+ ", lastUpdateDate=" + lastUpdateDate + "]";
	}
	
}
