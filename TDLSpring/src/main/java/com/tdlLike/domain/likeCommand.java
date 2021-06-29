package com.tdlLike.domain;

public class likeCommand {

	String TL_addrL;//좋아요일련번호 ->댓글일련번호 + 유저아이디
	String TL_addrC;//댓글일련번호
	String TL_id;//유저아이디
	int TL_PNUM;//게시물번호
	
	public String getTL_addrL() {
		return TL_addrL;
	}
	public void setTL_addrL(String tL_addrL) {
		TL_addrL = tL_addrL;
	}
	public String getTL_addrC() {
		return TL_addrC;
	}
	public void setTL_addrC(String tL_addrC) {
		TL_addrC = tL_addrC;
	}
	public String getTL_id() {
		return TL_id;
	}
	public void setTL_id(String tL_id) {
		TL_id = tL_id;
	}
	public int getTL_PNUM() {
		return TL_PNUM;
	}
	public void setTL_PNUM(int tL_PNUM) {
		TL_PNUM = tL_PNUM;
	}
	
	

	
}
