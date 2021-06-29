package com.tdl.member.domain;


public class MemberCommand {
	
	private String TU_id;
	private String TU_passwd;
	private String TU_name;// 이름
	private String TU_email;// 메일
	private String TU_phone;// 전번
	private String TU_gender;// 성별
	
	public String getTU_id() {
		return TU_id;
	}
	public void setTU_id(String tU_id) {
		TU_id = tU_id;
	}
	public String getTU_passwd() {
		return TU_passwd;
	}
	public void setTU_passwd(String tU_passwd) {
		TU_passwd = tU_passwd;
	}
	public String getTU_name() {
		return TU_name;
	}
	public void setTU_name(String tU_name) {
		TU_name = tU_name;
	}
	public String getTU_email() {
		return TU_email;
	}
	public void setTU_email(String tU_email) {
		TU_email = tU_email;
	}
	public String getTU_phone() {
		return TU_phone;
	}
	public void setTU_phone(String tU_phone) {
		TU_phone = tU_phone;
	}
	public String getTU_gender() {
		return TU_gender;
	}
	public void setTU_gender(String tU_gender) {
		TU_gender = tU_gender;
	}

}
