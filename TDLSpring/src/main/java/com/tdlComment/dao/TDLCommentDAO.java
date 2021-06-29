package com.tdlComment.dao;

import java.util.List;
import java.util.Map;

import com.tdlComment.domain.*;
import com.tdlPost.domain.TdlCommand;

public interface TDLCommentDAO {

	//1.목록보기
	public List<CommentCommand> listC(Integer TPC_num);
		
	//2.총레코드수
	public int getRowCountC(Integer TPC_num);
		
	//3.최대값 번호 구하기
	public int getNewNumC(Integer TPC_num);
		
	//4.댓글 글쓰기
	public void insertC(CommentCommand TDLComment);
		
	//5.글삭제
	public void deleteC(String TPC_num);
	
	//6.좋아요 증가
	public void likeUp(String TPC_addr);
	
	//7.좋아요 취소
	public void likeDown(String TPC_addr);
}
 