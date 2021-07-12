package com.board.VO;


/**
 * °Ô½ÃÆÇ VO
 *
 */
public class BoardVO {
	
	private int boardNo 			= 0;
	private int userNo 				= 0;
	private String boardTitle 		= "";
	private String boardDetail 		= "";
	private String useFlag			= "Y";
	private String createdBy		= "pcg0902";
	private String createdDate 		= "";
	private String lastUpdateBy 	= "pcg0902";
	private String lastUpdateDate 	= "";
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardDetail() {
		return boardDetail;
	}
	public void setBoardDetail(String boardDetail) {
		this.boardDetail = boardDetail;
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
		return "BoardVO [boardNo=" + boardNo + ", userNo=" + userNo + ", boardTitle=" + boardTitle + ", boardDetail="
				+ boardDetail + ", useFlag=" + useFlag + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastUpdateBy=" + lastUpdateBy + ", lastUpdateDate=" + lastUpdateDate + "]";
	}
	
}
