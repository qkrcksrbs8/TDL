package com.tdlPost.dao;

import java.util.List;
import java.util.Map;

import com.tdlPost.domain.*;

public interface TDLPostDAO {

	//1.목록보기
		public List<TdlCommand> list(Map<String,Object>map);
		
		//2.총레코드수
		public int getRowCount(Map<String,Object>map);
		
		//3.최대값 번호 구하기
		public int getNewNumP();
	
		//4.게시판의 글쓰기
		public void insert(TdlCommand TDLPost);
		
		//5.게시물번호에 해당하는 조회수 증가
		public void updateHit(Integer TP_num);
		
		//6.글상세보기
		public TdlCommand selectTDLPost(Integer TP_num);//~(int seq);
		
		//7.글삭제
		public void delete(Integer TP_num);
		
		//8.글수정
		public void update(TdlCommand TDLPost);
		
	
}
